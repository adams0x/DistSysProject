package ds.userService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.userService.UserServiceGrpc.UserServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class UserServer extends UserServiceImplBase{

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		UserServer service = new UserServer();
		
		Properties prop = service.getProperties();
		service.registerService(prop);
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;


		Server server = ServerBuilder.forPort(port)
				.addService(service)
				.build()
				.start();

		System.out.println("Milking Parlour Service started, listening on " + port);

		server.awaitTermination();		

		
	}

	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}

	
	
	
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		String userName = request.getUsername();
		String password = request.getPassword();
		
		if(userName.equals("user") && password.equals("password")) {
			LoginResponse response = LoginResponse.newBuilder()
					.setResponseCode(1)
					.setResponseMessage(userName +" log in success !")
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

	
	
}
