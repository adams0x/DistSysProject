package ds.client;


import ds.milkingParlourService.MilkingParlourServiceGrpc;
import ds.milkingParlourService.MilkingParlourServiceGrpc.*;
import ds.milkingParlourService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class TesterClient {

	static MilkingParlourServiceBlockingStub blockingStub;
	static MilkingParlourServiceStub asyncStub;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		blockingStub = MilkingParlourServiceGrpc.newBlockingStub(channel);
		asyncStub = MilkingParlourServiceGrpc.newStub(channel);
	}
	
	public static void setMachineDetails() {
		//This method client streams machine details for multiple machines to the server.
		//The service will use this data for simulating milking machines

		StreamObserver<SetMachineDetailsReply> responseObserver = new StreamObserver<SetMachineDetailsReply>() {

			@Override
			public void onNext(SetMachineDetailsReply msg) {
				System.out.println(msg.getSetMachineDetailsReply());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed.");
			}

		};		
		
		
		
	}

}
