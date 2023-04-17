package ds.milkingParlourService;

import java.io.IOException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

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
				Machine mc = new Machine(machine.getMachineID().getId(), machine.getDateInstalled(), machine.getDateNextService());
				machines.add(mc);
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
	public void getMachineIds(Empty request, StreamObserver<MachineId> responseObserver) {
		// TODO Auto-generated method stub
		super.getMachineIds(request, responseObserver);
	}





	@Override
	public StreamObserver<MachineReportDate> getMilkReports(StreamObserver<MilkReport> responseObserver) {
		// Bi-directional streaming: Client streams in a series of machine ID's and the service streams
		// back some milk reports for each machine
		return super.getMilkReports(responseObserver);
	}


	
	
	
	
	@Override
	public void getMilkVolume(MachineTimeSpan request, StreamObserver<MilkQuantity> responseObserver) {
		int mcId = request.getMachineID().getId();
		
		for(Machine m : machines) {
			if(m.getId() == mcId) {
				float milkVolume = m.getMilkProduced(request.getStartDate(), request.getEndDate());
				MilkQuantity Reply = MilkQuantity.newBuilder().setVolumeLitres(milkVolume).build();
				responseObserver.onNext(Reply);
				responseObserver.onCompleted();
				return;
			}
		}
	}
	
	

	
	
	
	
	private class Machine{
		int id;
		float milkProductionRate; // Litres per day
		LocalDate dateInstalled;
		LocalDate dateNextService;
		
		
		public Machine(int id, String dateInstalled, String dateNextService) {
			this.id = id;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			this.dateInstalled = LocalDate.parse(dateInstalled, df);
			this.dateNextService = LocalDate.parse(dateNextService, df);
			Random rand = new Random();
			milkProductionRate = rand.nextFloat() * 1000;
		}
		
		public int getId() {
			return id;
		}
		
		public LocalDate getInstallationDate() {
			return dateInstalled;
		}

		public LocalDate getNextServiceDate() {
			return dateNextService;
		}
		
		public float getMilkProduced(String dateFrom, String dateTo) {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate from = LocalDate.parse(dateFrom, df);
			LocalDate to = LocalDate.parse(dateTo, df);
			return milkProductionRate * Duration.between(from.atStartOfDay(), to.atStartOfDay()).toDays();
		}
	
	
	}
	
	
}
