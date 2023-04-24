package ds.livestockActivityService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

public class LivestockActivityServer extends LivestockActivityServiceImplBase {
	
	List<Animal> animals = new ArrayList<Animal>();


	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		LivestockActivityServer service = new LivestockActivityServer();
		
		Properties prop = service.getProperties();
		service.registerService(prop);
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service)
				.build()
				.start();

		System.out.println("Livestock Activity Service started, listening on " + port);

		server.awaitTermination();		
		
	}


	private Properties getProperties() {
		Properties prop = null;		
		 try (InputStream input = new FileInputStream("src/main/resources/livestockActivity.properties")) {
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            // get the property value and print it out
	            System.out.println("Livestock Activity Service Properies ...");
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
	public StreamObserver<AnimalDetail> setAnimalDetails(StreamObserver<SetAnimalDetailsReply> responseObserver) {
		// Client streaming: client sends a list of animal data for simulating
		return new StreamObserver<AnimalDetail> () {
			
			@Override
			public void onNext(AnimalDetail machine) {
				Animal animal = new Animal(machine.getAnimalID().getId(), machine.getDateOfBirth(), machine.getDateNextVaccine());
				for(int i = 0; i < animals.size(); i++) {
					if(animals.get(i).getId() == animal.getId()) {
						animals.set(i, animal);
						return;
					}
				}
				animals.add(animal);
			}
			
			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				String str = "Successfully added " + animals.size() + " animals to server";
				SetAnimalDetailsReply reply = SetAnimalDetailsReply.newBuilder().setSetAnimalDetailsReply(str).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
		};
	}


	
	@Override
	public void getAnimalIds(Empty request, StreamObserver<AnimalId> responseObserver) {
		//Server streaming: this returns a stream of animal id's to the client so that
		//the client knows what animals can be queried
		for(Animal animal : animals) {
			AnimalId aid = AnimalId.newBuilder().setId(animal.getId()).build();
			responseObserver.onNext(aid);
		}
		responseObserver.onCompleted();
	}

	@Override
	public void getLiveHeartRate(AnimalId request, StreamObserver<LiveHeartRate> responseObserver) {
		Timer timer = new Timer();
		Animal animal = animals.get(request.getId());
	    timer.schedule(new LiveHeartRateGenerator( responseObserver, animal ), 0, 1000);
	}

	@Override
	public void getHeartRateHistory(AnimalTimeSpan request, StreamObserver<HeartRateHistory> responseObserver) {
		int[] heartRateHist = animals.get(request.getAnimalID().getId()).getHeartRateHistory(request.getStartDate(), request.getEndDate());
		if(heartRateHist == null) {
			responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("The time range is too large")
					.asRuntimeException());			
		}
		else {
			System.out.println("Sending heartrate history samples: " + heartRateHist.length);
			for(int i = 0; i<heartRateHist.length; i++) {
				HeartRateHistory hrh = HeartRateHistory.newBuilder()
						.setTimeStamp(Integer.toString(i))
						.setBpm(heartRateHist[i])
						.build();
				responseObserver.onNext(hrh);
			}
			responseObserver.onCompleted();
		}
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
			Random rand = new Random();
			heartRate = rand.nextInt(71) +50; //range from 50 ~ 120 bpm
		}
		
		
		public int getId() {
			return id;
		}
		
		
		public int getHeartRate() {
			Random rand = new Random();
			heartRate = heartRate + (rand.nextInt(3) - 1);
			return heartRate;
		}
		
		
		public int[] getHeartRateHistory(String dateFrom, String dateTo) {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate from = LocalDate.parse(dateFrom, df);
			LocalDate to = LocalDate.parse(dateTo, df);
			long numSamples = Duration.between(from.atStartOfDay(), to.atStartOfDay()).toHours();
			if(numSamples>1008)
				return null;
			int[] heartHistSamples = new int[(int)numSamples];
			Random rand = new Random();
			for(int i = 0; i<numSamples; i++) {
				heartRate = heartRate + (rand.nextInt(11) - 5);
				heartHistSamples[i] = heartRate;
			}
			return heartHistSamples;
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
