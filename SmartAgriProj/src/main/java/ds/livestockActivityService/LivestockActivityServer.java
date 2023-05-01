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
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

public class LivestockActivityServer extends LivestockActivityServiceImplBase {
	
	//an internal list of animals is held in the server.
	//this list of animals is queried by the client and simulates data results
	// the list is initially populated with mock data sent from the client
	List<Animal> animals = new ArrayList<Animal>();
	
	/*
	 * Livestock activity service main method to create an instance of the server and register it 
	 * using the jmDNS library
	 */
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


	/*
	 * Read the properties from the .properties file to aid registration 
	 * using the jmDNS library
	 */
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
	
	
	/*
	 * Register the service to allow for discovery by clients 
	 * using the jmDNS library
	 */
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
				e.printStackTrace();
			}
	    
	}

	
	
	/*
	 * method implements the setAnimalDetails client streaming grpc call
	 */
	@Override
	public StreamObserver<AnimalDetail> setAnimalDetails(StreamObserver<SetAnimalDetailsReply> responseObserver) {
		//Client streaming: The client will supply a stream of mock details for multiple animals
		//The data recieved is used to initialise a bunch of animal objects for simulation
		return new StreamObserver<AnimalDetail> () {
			
			@Override
			public void onNext(AnimalDetail machine) {
				Animal animal = new Animal(machine.getAnimalID().getId(), machine.getDateOfBirth(), machine.getDateNextVaccine(), machine.getTypeOfAnimal());
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


	
	/*
	 * method implements the getAnimalIds server streaming grpc call
	 */
	@Override
	public void getAnimalIds(Empty request, StreamObserver<AnimalId> responseObserver) {
		//Server streaming: this returns a stream of animal id's to the client
		//the client can then use the id's in subsequent query's to the server
		for(Animal animal : animals) {
			AnimalId aid = AnimalId.newBuilder().setId(animal.getId()).build();
			responseObserver.onNext(aid);
		}
		responseObserver.onCompleted();
	}


	
	/*
	 * method implements the getLiveHeartRate server streaming grpc call
	 * this method initiates a stream of bpm values with no predetermined
	 * end. the client will cancel the stream. 
	 */
	@Override
	public void getLiveHeartRate(AnimalId request, StreamObserver<LiveHeartRate> responseObserver) {
		Timer timer = new Timer();
		//use a periodic timer to stream a bpm every second
		for(Animal animal:animals) {
			if(animal.getId()==request.getId())
				timer.schedule(new LiveHeartRateGenerator( responseObserver, animal ), 0, 1000);
		}
	}


	
	/*
	 * method implements the getHeartRateHistory server streaming grpc call
	 * this method initiates a fixed stream of historical bpm values (randomly generated)
	 * for a given time period to the client.
	 */
	@Override
	public void getHeartRateHistory(AnimalTimeSpan request, StreamObserver<HeartRateHistory> responseObserver) {
			for(Animal animal:animals) {
				if(animal.getId()==request.getAnimalID().getId()) {
					int[] heartRateHist = animal.getHeartRateHistory(request.getStartDate(), request.getEndDate());
					if(heartRateHist == null) {
						//error scenario: time range is too large!
						responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("The time range is too large")
								.asRuntimeException());			
					}
					else {
						System.out.println("Sending heartrate history samples: " + heartRateHist.length);
						for(int i = 0; i<heartRateHist.length; i++) {
							DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				    		AnimalDetail animalDetail = AnimalDetail.newBuilder()
				    				.setAnimalID(AnimalId.newBuilder().setId(request.getAnimalID().getId()))
				    				.setTypeOfAnimal(animals.get(request.getAnimalID().getId()).getAnimalType())
									.setDateOfBirth(df.format(animal.getDateOfBirth()))
									.setDateNextVaccine(df.format(animal.getDateNextVaccine()))
				    				.build();
							HeartRateHistory hrh = HeartRateHistory.newBuilder()
									.setTimeStamp(Integer.toString(i))
									.setBpm(heartRateHist[i])
									.setAnimal(animalDetail)
									.build();
							responseObserver.onNext(hrh);
						}
						responseObserver.onCompleted();
						return;
					}
				
			}
				//error scenario: couldnt find the requested animal id
			responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("The animal ID is not found")
					.asRuntimeException());
		}
	}


	
	/*
	 * method implements the getCurrentActivity unary grpc call
	 * this method returns the activity of the requested animal id
	 * to the client
	 */
	@Override
	public void getCurrentActivity(AnimalId request, StreamObserver<CurrentActivity> responseObserver) {
		//a unary call whereby the client sends an animal id and this sends back the randomly
		//generated activity of the animal
		for(Animal animal:animals) {
			if(animal.getId()==request.getId()) {
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				AnimalDetail animalDetail = AnimalDetail.newBuilder()
						.setAnimalID(AnimalId.newBuilder().setId(animal.getId()))
						.setTypeOfAnimal(animal.getAnimalType())
						.setDateOfBirth(df.format(animal.getDateOfBirth()))
						.setDateNextVaccine(df.format(animal.getDateNextVaccine()))
						.build();
				CurrentActivity activity = CurrentActivity.newBuilder()
						.setActivity(animal.getActivity())
						.setAnimal(animalDetail)
						.build();
				responseObserver.onNext(activity);
				responseObserver.onCompleted();
				return;
			}
			
		}
		responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("The animal ID is not found")
				.asRuntimeException());
	}


	
	
	/*
	 * method implements the getAnimalVitals bi-directional grpc call
	 * this method returns health reports of the requested animal id's
	 * to the client
	 */
	@Override
	public StreamObserver<AnimalId> getAnimalVitals(StreamObserver<AnimalHealthInfo> responseObserver) {
		// Bi-directional streaming: Client streams in a series of animal ID's and the service streams
		// back some health reports for each animal
		return new StreamObserver<AnimalId> () {
			
			@Override
			public void onNext(AnimalId animalId) {
				for(Animal animal : animals) {
					if(animal.getId() == animalId.getId()) {
						DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						
						String reportDate = df.format(LocalDate.now());
						int minBPM = animal.getMinBPM();
						int maxBPM = animal.getMaxBPM();
						int avgBPM = animal.getAvgBPM();
						AnimalHealthInfo.Health health = animal.getHealth();
						
						AnimalDetail animalDetail = AnimalDetail.newBuilder()
								.setAnimalID(AnimalId.newBuilder().setId(animal.getId()))
								.setTypeOfAnimal(animal.getAnimalType())
								.setDateOfBirth(df.format(animal.getDateOfBirth()))
								.setDateNextVaccine(df.format(animal.getDateNextVaccine()))
								.build();
						
						AnimalHealthInfo report = AnimalHealthInfo.newBuilder()
								.setReportDate(reportDate)
								.setMinBPM(minBPM)
								.setMaxBPM(maxBPM)
								.setAvgBPM(avgBPM)
								.setHealthIndicator(health)
								.setAnimal(animalDetail)
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



	
	
	/***************************************************
	 * Animal class that simulates
	 * and generates data to mimic an animal
	 ***************************************************/
	
	private class Animal{
		
		//members of the animal class
		 int id;
		 LocalDate dateOfBirth;
		 LocalDate dateNextVaccine;
		 int heartRate;
		 int minBPM;
		 int maxBPM;
		 int avgBPM;
		 AnimalDetail.TypeOfAnimal animalType;
		 CurrentActivity.Activity activity;
		 AnimalHealthInfo.Health health;

		 
		public AnimalHealthInfo.Health getHealth() {
			return health;
		}


		public int getMinBPM() {
			return minBPM;
		}


		public int getMaxBPM() {
			return maxBPM;
		}


		public int getAvgBPM() {
			return avgBPM;
		}


		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}


		public LocalDate getDateNextVaccine() {
			return dateNextVaccine;
		}


		public CurrentActivity.Activity getActivity() {
			return activity;
		}


		public AnimalDetail.TypeOfAnimal getAnimalType() {
			return animalType;
		}


		/*
		 * Livestock animal object construction based on mock data recieved from
		 * the client and also lots of randomly generated data
		 */
		public Animal(int id, String dateOfBirth, String dateNextVaccine, AnimalDetail.TypeOfAnimal animalType) {
			this.id = id;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			this.dateOfBirth = LocalDate.parse(dateOfBirth, df);
			this.dateNextVaccine = LocalDate.parse(dateNextVaccine, df);
			Random rand = new Random();
			heartRate = rand.nextInt(71) +50; //range from 50 ~ 120 bpm
			minBPM = rand.nextInt(11) +40; //range from 40 ~ 50 bpm
			maxBPM = rand.nextInt(11) +120; //range from 120 ~ 130 bpm
			avgBPM = ((maxBPM - minBPM) / 2) + minBPM ;
			this.activity = CurrentActivity.Activity.values()[rand.nextInt(4)];
			this.health = AnimalHealthInfo.Health.values()[rand.nextInt(4)];
			this.animalType = animalType;
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
	
	
	
	/***************************************************
	 * LiveHeartRateGenerator class that simulates
	 * and generates data to mimic an animal heart rate
	 * at timed intervals
	 ***************************************************/
	
	private class LiveHeartRateGenerator extends TimerTask {

	    private final StreamObserver<LiveHeartRate> responseObserver;
	    private final Animal animal;


	    LiveHeartRateGenerator ( StreamObserver<LiveHeartRate> responseObserver, Animal animal )
	    {
	      this.responseObserver = responseObserver;
	      this.animal = animal;
	    }

	    public void run() {
	    	Context cxt = Context.current();
	    	if (cxt.isCancelled()) {
	    		this.cancel();
	    		System.out.println("live heart rate cancelled by client");
	    	}
	    	else
	    	{
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				AnimalDetail animalDetail = AnimalDetail.newBuilder()
						.setAnimalID(AnimalId.newBuilder().setId(animal.getId()))
						.setTypeOfAnimal(animal.getAnimalType())
						.setDateOfBirth(df.format(animal.getDateOfBirth()))
						.setDateNextVaccine(df.format(animal.getDateNextVaccine()))
						.build();
		    	LiveHeartRate lhr = LiveHeartRate.newBuilder()
		    			.setBpm(animal.getHeartRate())
		    			.setAnimal(animalDetail)
		    			.build();
		    	System.out.println("live heart rate " + lhr.getBpm() + " for animal id " + lhr.getAnimal().getAnimalID().getId());
		    	responseObserver.onNext(lhr);	    		
	    	}
	    	
	    }
	}
	

	
}
