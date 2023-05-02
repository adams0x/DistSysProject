package ds.milkingParlourService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import ds.constants.Constants;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Server interceptor: this interceptor checks the headers for metadata
 * for an authorisation key that may be added by the client. If present then
 * it gets its value and if it is a verified jwt token then it will add
 * the subject (ie user name) to the context. rpc calls can use that to know if a valid user
 * made the request
 */	
public class AuthorisationServerInterceptor implements ServerInterceptor {
	
    private JwtParser parser = Jwts.parserBuilder().setSigningKey(getJwtSecret()).build();

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
    	System.out.println("Milking Parlour Service intercepted");
    	Context ctx = Context.current();//this context can be modified if valid jwt is extracted below
    	String value = metadata.get(Constants.AUTHORIZATION_METADATA_KEY);

        if (value != null) {
        	if(value.startsWith(Constants.BEARER_TYPE)) {
                try {
                    String token = value.substring(Constants.BEARER_TYPE.length()).trim();//remove the prefix
                    Jws<Claims> claims = parser.parseClaimsJws(token);//verify signature and parse
                    //add the user to the context for use by rpc's
                    ctx = ctx.withValue(Constants.CLIENT_ID_CONTEXT_KEY, claims.getBody().getSubject());
                } catch (Exception e) {
                	Status status = Status.UNAUTHENTICATED.withDescription(e.getMessage()).withCause(e);
                	serverCall.close(status, metadata);
                    return new ServerCall.Listener<ReqT>() {
                        // noop
                    };                }        		
        	}
        }
        //forward the call with possible updated context
        return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);

    }

 
    
	/**
	 * Read the jwt secret key from properties file that can be
	 * used above to verify the received jwt token
	 */	
	private SecretKey getJwtSecret() {
		Properties prop = null;		
		 try (InputStream input = new FileInputStream("src/main/resources/jwt/secret.properties")) {
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            String secretKey = prop.getProperty("secretKey");//read the key in current string format
	            byte[] decodedKey = Base64.getDecoder().decode(secretKey);//decode from string to byte varray values
	            SecretKey originalKey = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS256.getJcaName()); //convert byte array to secret key
	            return originalKey;
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		 return null;
	    
	}	
    
    
    
	
}	
