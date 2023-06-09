package ds.milkingParlourService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

import ds.constants.Constants;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceImplBase;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class MilkingParlourServer extends MilkingParlourServiceImplBase{
	
	//an internal list of machines is held in the server.
	//this list of machines is queried by the client and simulates data results
	// the list is initially populated with mock data sent from the client
	List<Machine> machines = new ArrayList<Machine>();

	/*
	 * Milk parlour service main method to create an instance of the server and register it 
	 * using the jmDNS library
	 */
	public static void main(String[] args) throws InterruptedException, IOException{
		
		MilkingParlourServer service = new MilkingParlourServer();
		
		Properties prop = service.getProperties();
		service.registerService(prop);
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;


		Server server = ServerBuilder.forPort(port)
				.addService(service)
			    .intercept(new AuthorisationServerInterceptor())				
				.build()
				.start();

		System.out.println("Milking Parlour Service started, listening on " + port);

		server.awaitTermination();		
		
	}

	
	/*
	 * Read the properties from the .properties file to aid registration 
	 * using the jmDNS library
	 */
	private Properties getProperties() {
		Properties prop = null;		
		 try (InputStream input = new FileInputStream("src/main/resources/milkingParlour.properties")) {
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            // get the property value and print it out
	            System.out.println("Milking Parlour Service Properies ...");
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
	 * method implements the setMachineDetails client streaming grpc call
	 */
	@Override
	public StreamObserver<MachineDetail> setMachineDetails(StreamObserver<SetMachineDetailsReply> responseObserver) {
		//Client streaming: The client will supply a stream of mock details for multiple milking machines
		//The data recieved is used to initialise a bunch of machine objects for simulation
		return new StreamObserver<MachineDetail> () {
			
			@Override
			public void onNext(MachineDetail machine) {
				Machine mc = new Machine(machine.getMachineID().getId(), machine.getDateInstalled(), machine.getDateNextService());
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
				String str = "Successfully added " + machines.size() + " machines to server";
				SetMachineDetailsReply reply = SetMachineDetailsReply.newBuilder().setSetMachineDetailsReply(str).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
		};
	}

	
	
	
	
	/*
	 * method implements the getMachineIds server streaming grpc call
	 */
	@Override
	public void getMachineIds(Empty request, StreamObserver<MachineId> responseObserver) {
		//Server streaming: this returns a stream of machine id's to the client
		//the client can then use the id's in subsequent query's to the server
		for(Machine mc : machines) {
			MachineId mcid = MachineId.newBuilder().setId(mc.getId()).build();
			responseObserver.onNext(mcid);
		}
		responseObserver.onCompleted();
	}





	/*
	 * method implements the getMilkReports bi-directional streaming grpc call
	 */
	@Override
	public StreamObserver<MachineReportDate> getMilkReports(StreamObserver<MilkReport> responseObserver) {
		// Bi-directional streaming: Client streams in a series of machine ID's (incl. date) and the service streams
		// back some milk reports for each machine
		return new StreamObserver<MachineReportDate> () {
			
			@Override
			public void onNext(MachineReportDate machine) {
				for(Machine m : machines) {
					if(m.getId() == machine.getMachineID().getId()) {
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


	
	
	
	
	/*
	 * method implements the getMilkVolume unary grpc call
	 */
	@Override
	public void getMilkVolume(MachineTimeSpan request, StreamObserver<MilkQuantity> responseObserver) {
		//Unary: this returns the milk volume produced by the machine and time span chosen by the client

		//Context ctx =Context.current();
		String clientId;
		clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
		if(clientId == null) {
			responseObserver.onError(Status.UNAUTHENTICATED.withDescription("User not logged in for access to milk volumes").asRuntimeException());
			return;
		}
		System.out.println("getMilkVolume invoked by user: " + clientId);
		
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
	
	

	
	
	
	/***************************************************
	 * Milking machine class that simulates
	 * and generates data to mimik a milking machine
	 ***************************************************/
	
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
			long durationDays = Duration.between(from.atStartOfDay(), to.atStartOfDay()).toDays()+1;
			if(durationDays<=0)
				durationDays=1;
			return milkProductionRate * durationDays;
		}

		
		/*
		 * Simulate a milk volume (litres) produced by this
		 * milking machine for a given day*/
		public float getMilkProduced(String day) {
			
			Random rand = new Random();
			return milkProductionRate * rand.nextFloat();
		}
		
		
		/*
		 * Simulate the temperature that
		 * the milk machine heated the milk to, for use in daily
		 * report*/
		public float getMilkTemperatureHeated() {
			Random rand = new Random();
			return 60 + (20 * rand.nextFloat());
		}

		
		/*
		 * Simulate the temperature that
		 * the milk machine cooled the milk to for storage, for use in daily
		 * report*/
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
