package ds.client;

import java.util.concurrent.Executor;

import ds.constants.Constants;
import io.grpc.CallCredentials;
import io.grpc.Status;
import io.grpc.Metadata;

public class BearerToken extends CallCredentials {

	private String value;

    public BearerToken(String value) {
        this.value = value;
    }
    
	@Override
	public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
		// TODO Auto-generated method stub
        appExecutor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(Constants.AUTHORIZATION_METADATA_KEY, String.format("%s %s", Constants.BEARER_TYPE, value));
                applier.apply(headers);
            } catch (Throwable e) {
                applier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });		
	}

	@Override
	public void thisUsesUnstableApi() {
		// TODO Auto-generated method stub
		
	}

}
