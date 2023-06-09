package ds.userService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.milkingParlourService.AuthorisationServerInterceptor;
import ds.userService.UserServiceGrpc.UserServiceImplBase;
import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerCredentials;
import io.grpc.TlsServerCredentials;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;




public class UserServer extends UserServiceImplBase{

	/*
	 * User service main method to create an instance of the server and register it 
	 * using the jmDNS library
	 * This service uses TLS encryption and server athentication
	 */
	public static void main(String[] args) throws InterruptedException, IOException {

		UserServer service = new UserServer();
		//setJwtSecret(); //this is a once off call to create a secret signing key into a properties file
		
		Properties prop = service.getProperties();
		service.registerService(prop);
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
		
		//build the server using tls server authentication
		//the self signed cert and private key are saved in the sss folder
		ServerCredentials creds = TlsServerCredentials.create(new File("src//main//resources//ssl//publickeycert.pem"), new File("src//main//resources//ssl//privatekey.pem"));
		Server server = Grpc.newServerBuilderForPort(port, creds)
			    .addService(service)
			    .build()
			    .start();
		
		System.out.println("User Service started, listening on " + port);

		server.awaitTermination();		

		
	}

	
	/*
	 * Read the properties from the .properties file to aid registration 
	 * using the jmDNS library
	 */
	private Properties getProperties() {
		Properties prop = null;		
		 try (InputStream input = new FileInputStream("src/main/resources/user.properties")) {
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            // get the property value and print it out
	            System.out.println("User Service Properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}


	
	/*
	 * Register the service to allow for discovery by clients 
	 * using the jmDNS library
	 */
	private  void registerService(Properties prop) {
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            String serviceType = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String serviceName = prop.getProperty("service_name")  ;// "example";
	           // int service_port = 1234;
	            int servicePort = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
	            String serviceDescriptionProperties = prop.getProperty("service_description")  ;//"path=index.html";
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, servicePort, serviceDescriptionProperties);
	            jmdns.registerService(serviceInfo);
	            System.out.printf("registrering service with type %s and name %s \n", serviceType, serviceName);
	            // Wait a bit
	            Thread.sleep(1000);
	            // Unregister all services
	            //jmdns.unregisterAllServices();
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				e.printStackTrace();
			}
	    
	}


	/*
	 * a method that generates a random secret key for signing and verifying
	 * java web tokens (jwt's)
	 */	
	static void setJwtSecret() {
		Properties prop = new Properties();
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	    String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
		
		prop.setProperty("secretKey", encodedKey);
		try {
			prop.store(new FileOutputStream("src/main/resources/jwt/secret.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * method implements the login unary grpc call
	 */
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		String userName = request.getUsername();
		String password = request.getPassword();
		
		//check the user and password and if a match then respond with success
		// and more importantly create a signed jwt and include it in the reply
		if(userName.equals("user") && password.equals("password")) {
			LoginResponse response = LoginResponse.newBuilder()
					.setResponseCode(1)
					.setResponseMessage(userName +" log in success !")
					.setJwtToken(getJwt(userName))
					.build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
			
		}
		else {
			LoginResponse response = LoginResponse.newBuilder()
					.setResponseCode(0)
					.setResponseMessage(userName +" entered incorrect details !")
					.build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
			
		}
		
	}

	/*
	 * method implements the logout unary grpc call
	 */
	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		
		String userName = request.getUsername();

		if(userName.equals("user")) {
			LogoutResponse response = LogoutResponse.newBuilder()
					.setResponseCode(1)
					.setResponseMessage(userName +" log out success !")
					.build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
			
		}
		else {
			LogoutResponse response = LogoutResponse.newBuilder()
					.setResponseCode(0)
					.setResponseMessage(userName +" not logged in !")
					.build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
			
		}

		
	}

	
	/*
	 * method creates a jwt and adds the user to the claims
	 */	
	private String getJwt(String user) {
		Properties prop = null;		
		 try (InputStream input = new FileInputStream("src/main/resources/jwt/secret.properties")) {
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            //retreive the secret code from the file
	            String secretKey = prop.getProperty("secretKey");
	            byte[] decodedKey = Base64.getDecoder().decode(secretKey);
	            SecretKey originalKey = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS256.getJcaName());
	            // get the property value and print it out
	            System.out.println("User Service Getting Secret Signing Key ...");
	            System.out.println("\t secret key: " + secretKey);
	            return Jwts.builder()
	            .setSubject(user)
	            .signWith(originalKey)
	            .compact();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		 return "";
	    
	}	
	
	
	
}
