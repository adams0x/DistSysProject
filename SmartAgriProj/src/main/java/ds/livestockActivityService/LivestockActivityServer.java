package ds.livestockActivityService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

public class LivestockActivityServer extends LivestockActivityServiceImplBase {
	
	List<Animal> machines = new ArrayList<Animal>();

	public static void main(String[] args) throws InterruptedException, IOException {
		
		LivestockActivityServer service = new LivestockActivityServer();
		
		int port = 50052;

		Server server = ServerBuilder.forPort(port)
				.addService(service)
				.build()
				.start();

		System.out.println("Livestock Activity Service started, listening on " + port);

		server.awaitTermination();		
		
	}

	@Override
	public StreamObserver<AnimalDetail> setAnimalDetails(StreamObserver<SetAnimalDetailsReply> responseObserver) {
		// Client streaming: client sends a list of animal data for simulating
		return new StreamObserver<AnimalDetail> () {
			
			@Override
			public void onNext(AnimalDetail machine) {
				Animal mc = new Animal(machine.getAnimalID().getId(), machine.getDateOfBirth(), machine.getDateNextVaccine());
				for(int i = 0; i < machines.size(); i++) {
					if(machines.get(i).getId() == mc.getId()) {
						machines.set(i, mc);
						return;
					}
				}
				machines.add(mc);
			}
			
			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				String str = "Successfully added " + machines.size() + " animals to server";
				SetAnimalDetailsReply reply = SetAnimalDetailsReply.newBuilder().setSetAnimalDetailsReply(str).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
		};
	}


	
	@Override
	public void getAnimalIds(Empty request, StreamObserver<AnimalId> responseObserver) {
		// TODO Auto-generated method stub
		super.getAnimalIds(request, responseObserver);
	}

	@Override
	public void getLiveHeartRate(AnimalId request, StreamObserver<LiveHeartRate> responseObserver) {
		Timer timer = new Timer();
		Animal animal = machines.get(request.getId());
	    timer.schedule(new LiveHeartRateGenerator( responseObserver, animal ), 0, 1000);
	}

	@Override
	public void getHeartRateHistory(AnimalTimeSpan request, StreamObserver<HeartRateHistory> responseObserver) {
		// TODO Auto-generated method stub
		super.getHeartRateHistory(request, responseObserver);
	}

	@Override
	public void getCurrentActivity(AnimalId request, StreamObserver<CurrentActivity> responseObserver) {
		// TODO Auto-generated method stub
		super.getCurrentActivity(request, responseObserver);
	}

	@Override
	public StreamObserver<AnimalId> getAnimalVitals(StreamObserver<AnimalHealthInfo> responseObserver) {
		// TODO Auto-generated method stub
		return super.getAnimalVitals(responseObserver);
	}


	private class Animal{
		int id;
		LocalDate dateOfBirth;
		LocalDate dateNextVaccine;
		int heartRate;

		
		/*
		 * Livestock animal object construction
		 */
		public Animal(int id, String dateOfBirth, String dateNextVaccine) {
			this.id = id;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			this.dateOfBirth = LocalDate.parse(dateOfBirth, df);
			this.dateNextVaccine = LocalDate.parse(dateNextVaccine, df);
		}
		
		
		public int getId() {
			return id;
		}
		
		
		public int getHeartRate() {
			return heartRate;
		}


	}
	
	
	
	class LiveHeartRateGenerator extends TimerTask {

	    private final StreamObserver<LiveHeartRate> responseObserver;
	    private final Animal animal;


	    LiveHeartRateGenerator ( StreamObserver<LiveHeartRate> responseObserver, Animal animal )
	    {
	      this.responseObserver = responseObserver;
	      this.animal = animal;
	    }

	    public void run() {
	    	ServerCallStreamObserver<LiveHeartRate> scStreamObserver
	    	= ((ServerCallStreamObserver<LiveHeartRate>)responseObserver);
	    	if (scStreamObserver.isCancelled()) {
	    		this.cancel();
	    		System.out.println("live haert reate cancelled by client");
	    	}
	    	else
	    	{
		    	LiveHeartRate lhr = LiveHeartRate.newBuilder()
		    			.setBpm(animal.getHeartRate())
		    			.build();
		    	scStreamObserver.onNext(lhr);
	    		
	    	}
	    	
	    }
	}
	
}
