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
		//Server streaming: this returns a stream of machine id's to the client
		for(Machine mc : machines) {
			MachineId mcid = MachineId.newBuilder().setId(mc.getId()).build();
			responseObserver.onNext(mcid);
		}
		responseObserver.onCompleted();
	}





	@Override
	public StreamObserver<MachineReportDate> getMilkReports(StreamObserver<MilkReport> responseObserver) {
		// Bi-directional streaming: Client streams in a series of machine ID's (incl. date) and the service streams
		// back some milk reports for each machine
		return new StreamObserver<MachineReportDate> () {
			
			@Override
			public void onNext(MachineReportDate machine) {
				Machine mc;
				for(Machine m : machines) {
					if(m.getId() == machine.getMachineID().getId()) {
						mc = m;
						String reportDate = machine.getReportDate();
						float volume = m.getMilkProduced(reportDate);
						float tempHeated = m.getMilkTemperatureHeated();
						float heatDuration = m.getHeatingDuration();
						float tempChilled = m.getMilkTemperatureChilled();
						String nextServiceDue = m.getNextServiceDate();
						MilkReport report = MilkReport.newBuilder()
								.setReportDate(reportDate)
								.setVolumeLitres(volume)
								.setHeatedTemperature(tempHeated)
								.setHeatedDuration(heatDuration)
								.setChilledTemperature(tempChilled)
								.setDateNextService(nextServiceDue)
								.setMachId(m.getId())
								.build();
						responseObserver.onNext(report);
					}
				}
				
			}
			
			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}


	
	
	
	
	@Override
	public void getMilkVolume(MachineTimeSpan request, StreamObserver<MilkQuantity> responseObserver) {
		//Unary: this returns the milk volume produced by the machine and time span chosen by the client
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
		
		/*
		 * Milking machine object construction
		 */
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
		
		public String getInstallationDate() {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			return dateInstalled.format(df);
		}

		public String getNextServiceDate() {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			return dateNextService.format(df);
		}

		
		/*
		 * Simulate a milk volume (litres) produced by this
		 * milking machine for a given range of time
		 */
		public float getMilkProduced(String dateFrom, String dateTo) {
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate from = LocalDate.parse(dateFrom, df);
			LocalDate to = LocalDate.parse(dateTo, df);
			return milkProductionRate * Duration.between(from.atStartOfDay(), to.atStartOfDay()).toDays();
		}

		
		/*
		 * Simulate a milk volume (litres) produced by this
		 * milking machine for a given day
		 */

		public float getMilkProduced(String day) {
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate from = LocalDate.parse(day, df);
			Random rand = new Random();
			return milkProductionRate * rand.nextFloat();
		}
		
		
		/*
		 * Simulate the temperature that
		 * the milk machine heated the milk to, for use in daily
		 * report
		 */
		public float getMilkTemperatureHeated() {
			Random rand = new Random();
			return 60 + (20 * rand.nextFloat());
		}

		
		/*
		 * Simulate the temperature that
		 * the milk machine cooled the milk to for storage, for use in daily
		 * report
		 */
		public float getMilkTemperatureChilled() {
			Random rand = new Random();
			return 5 + (2 * rand.nextFloat());
		}

		
		
		/*
		 * Simulate the length of time in minutes that
		 * the milk machine heated milk for use in daily
		 * report
		 */
		public float getHeatingDuration() {
			Random rand = new Random();
			return 59 + (2 * rand.nextFloat());
		}

	
	}
	
	
}
