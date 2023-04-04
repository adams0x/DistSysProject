package ds.milkingParlourService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MilkingParlourServer extends MilkingParlourServiceImplBase{
	
	List<Machine> machines = new ArrayList<Machine>();

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
		//Client streaming: The client will supply a stream of details for multiple milking machines
		return new StreamObserver<MachineDetail> () {
			
			@Override
			public void onNext(MachineDetail machine) {
				Machine mc;
				try {
					mc = new Machine(machine.getMachineID().getId(), machine.getDateInstalled(), machine.getDateNextService());
					machines.add(mc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			@Override
			public void onError(Throwable t) {
				
			}

			@Override
			public void onCompleted() {
				String str = "Successfully added " + machines.size() + " machines to server";
				SetMachineDetailsReply reply = SetMachineDetailsReply.newBuilder().setSetMachineDetailsReply(str).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
			
		};
	}

	@Override
	public StreamObserver<MachineId> getMilkReports(StreamObserver<MilkReport> responseObserver) {
		// Bi-directional streaming: Client streams in a series of machine ID's and the service streams
		// back some milk reports for each machine
		return super.getMilkReports(responseObserver);
	}

	@Override
	public void getMilkVolume(MachineTimeSpan request, StreamObserver<MilkQuantity> responseObserver) {
		// TODO Auto-generated method stub
		super.getMilkVolume(request, responseObserver);
	}
	
	
	private class Machine{
		int id;
		Date dateInstalled;
		Date dateNextService;
		
		
		public Machine(int id, String dateInstalled, String dateNextService) throws ParseException {
			this.id = id;
			DateFormat df = DateFormat.getDateInstance();
			this.dateInstalled = df.parse(dateInstalled);
			this.dateNextService = df.parse(dateNextService);
		}
		
		public int getId() {
			return id;
		}
		
		public Date getInstallationDate() {
			return dateInstalled;
		}

		public Date getNextServiceDate() {
			return dateNextService;
		}
	
	
	}
	
	
}
