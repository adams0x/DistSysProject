package ds.milkingParlourService;

import java.io.IOException;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MilkingParlourServer extends MilkingParlourServiceImplBase{

	public static void main(String[] args) throws InterruptedException, IOException{
		
		MilkingParlourServer service = new MilkingParlourServer();
		
		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service)
				.build()
				.start();

		System.out.println("Milking Parlour Service started, listening on " + port);

		server.awaitTermination();		
		
	}

	@Override
	public StreamObserver<MachineDetail> setMachineDetails(StreamObserver<SetMachineDetailsReply> responseObserver) {
		// TODO Auto-generated method stub
		return super.setMachineDetails(responseObserver);
	}

	@Override
	public StreamObserver<MachineId> getMilkReports(StreamObserver<MilkReport> responseObserver) {
		// TODO Auto-generated method stub
		return super.getMilkReports(responseObserver);
	}

	@Override
	public void getMilkVolume(MachineTimeSpan request, StreamObserver<MilkQuantity> responseObserver) {
		// TODO Auto-generated method stub
		super.getMilkVolume(request, responseObserver);
	}
	
	
}
