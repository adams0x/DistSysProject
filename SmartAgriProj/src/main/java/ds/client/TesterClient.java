package ds.client;


import ds.milkingParlourService.MilkingParlourServiceGrpc;
import ds.milkingParlourService.MilkingParlourServiceGrpc.*;
import ds.livestockActivityService.AnimalDetail;
import ds.livestockActivityService.AnimalId;
import ds.livestockActivityService.LiveHeartRate;
import ds.livestockActivityService.LivestockActivityServiceGrpc;
import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceBlockingStub;
import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceStub;
import ds.livestockActivityService.SetAnimalDetailsReply;
import ds.milkingParlourService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.*;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class TesterClient {

	/*
	 * Milking parlour service members
	 */
	static MilkingParlourServiceBlockingStub blockingStub;
	static MilkingParlourServiceStub asyncStub;
	static ArrayList<Integer> machineIDs = new ArrayList<Integer>();
	static ServiceInfo milkParlourServiceInfo;

	/*
	 * Livestock activity service members
	 */
	static LivestockActivityServiceBlockingStub blockingStub2;
	static LivestockActivityServiceStub asyncStub2;
	static ArrayList<Integer> animalIDs = new ArrayList<Integer>();

	
	public static void main(String[] args) throws InterruptedException {

		
		String milkParlourServiceType = "_milkingParlour._tcp.local.";
		discoverMilkParlourService(milkParlourServiceType);
		
		String host = milkParlourServiceInfo.getHostAddresses()[0];
		int port = milkParlourServiceInfo.getPort();

		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		blockingStub = MilkingParlourServiceGrpc.newBlockingStub(channel);
		asyncStub = MilkingParlourServiceGrpc.newStub(channel);

		setMachineDetails();
		Thread.sleep(2000); // important, allow time for all data transferred
		getMachineIDs();
		getMilkQuantity(1);
		getMilkQuantity(5);
		getMilkReports();
		
		
		String host2 = "localhost";
		int port2 = 50052;



		ManagedChannel channel2 = ManagedChannelBuilder
				.forAddress(host2, port2)
				.usePlaintext()
				.build();
		
		blockingStub2 = LivestockActivityServiceGrpc.newBlockingStub(channel2);
		asyncStub2 = LivestockActivityServiceGrpc.newStub(channel2);
		

		setAnimalDetails();
		Thread.sleep(2000); // important, keep client alive till all data transferred
		getLiveHeartRate(200);

		
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
				System.out.println("streaming machines to server is completed.");
			}
		};		
		
		StreamObserver<MachineDetail> requestObserver = asyncStub.setMachineDetails(responseObserver);
		File directory = new File("");
  		String name = directory.getAbsolutePath() + "\\src\\main\\resources\\machines.csv";
		Scanner sc;
		try {
			sc = new Scanner(new File(name));
			sc.nextLine();
			String st = "";
			while (sc.hasNextLine())  //returns a boolean value
			{
				st = sc.nextLine();
				String[] data = st.split(",");
				MachineId mcid = MachineId.newBuilder().setId(Integer.parseInt(data[0])).build();
				MachineDetail md = MachineDetail.newBuilder()
						.setMachineID(mcid)
						.setDateInstalled(data[1])
						.setDateNextService(data[2])
						.build();
				requestObserver.onNext(md);
			}
			sc.close();  //closes the scanner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		requestObserver.onCompleted();

	}


	public static void getMachineIDs() {
		Empty emp = Empty.newBuilder().build();
		try {
			Iterator<MachineId> it = blockingStub.getMachineIds(emp);
			System.out.println("Getting machine id's:");
			while(it.hasNext()) {
				MachineId temp = it.next();
				machineIDs.add(temp.getId());				
			}
			System.out.println(machineIDs.toString());
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}
	

	public static void getMilkQuantity(int machineId) {
		MachineId mcId = MachineId.newBuilder().setId(machineId).build();
		MachineTimeSpan mc = MachineTimeSpan.newBuilder()
				.setMachineID(mcId)
				.setStartDate("10/04/2023")
				.setEndDate("17/04/2023")
				.build();
		MilkQuantity reply = blockingStub.getMilkVolume(mc);
		System.out.println("Milk volume at machine id=" + machineId +" is " + reply.getVolumeLitres() + " litres");
	}
	
	
	public static void getMilkReports() {
		
		//Create a StreamObserver that receives the stream of milk reports
		StreamObserver<MilkReport> responseObserver = new StreamObserver<MilkReport>() {

			@Override
			public void onNext(MilkReport report) {
				//MilkReport received, extract the data
				System.out.println("Receiving report for machine: " + report.getMachId() );
				System.out.println("Report date: " + report.getReportDate() );
				System.out.println("Milk volume (L): " + report.getVolumeLitres() );
				System.out.println("Heated Temperature (C): " + report.getHeatedTemperature() );
				System.out.println("Heated Duration (mins): " + report.getHeatedDuration() );
				System.out.println("Cooled Temperature (C): " + report.getChilledTemperature() );
				System.out.println("Next service on: " + report.getDateNextService() );
				System.out.println();
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... all milk reports recieved");
			}

		};

		//Create a StreamObserver that sends the stream of MachineReportsDate's
		StreamObserver<MachineReportDate> requestObserver = asyncStub.getMilkReports(responseObserver);
		try {
			requestObserver.onNext(MachineReportDate.newBuilder()
				.setMachineID(MachineId.newBuilder().setId(1).build())
				.setReportDate("18/04/2023")
				.build());
			Thread.sleep(500);

			requestObserver.onNext(MachineReportDate.newBuilder()
					.setMachineID(MachineId.newBuilder().setId(3).build())
					.setReportDate("18/04/2023")
					.build());
				Thread.sleep(500);


			// Mark the end of requests
			requestObserver.onCompleted();

			
			//Thread.sleep(2000);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

	}
	
	
	public static void discoverMilkParlourService(String serviceType) {
		try {
			// Create a JmDNS instance
			//InetAddress addr = InetAddress.getLocalHost();
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(serviceType, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					
					System.out.println("Math Service resolved: " + event.getInfo());
					milkParlourServiceInfo = event.getInfo();
					int port = milkParlourServiceInfo.getPort();
					System.out.println("resolving " + serviceType + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + milkParlourServiceInfo.getNiceTextString());
					System.out.println("\t host: " + milkParlourServiceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Math Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Math Service added: " + event.getInfo());
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			jmdns.close();
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void setAnimalDetails() {
		//This method client streams machine details for multiple machines to the server.
		//The service will use this data for simulating milking machines

		StreamObserver<SetAnimalDetailsReply> responseObserver = new StreamObserver<SetAnimalDetailsReply>() {
			@Override
			public void onNext(SetAnimalDetailsReply msg) {
				System.out.println(msg.getSetAnimalDetailsReply());
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onCompleted() {
				System.out.println("streaming animals to server is completed.");
			}
		};		
		
		StreamObserver<AnimalDetail> requestObserver = asyncStub2.setAnimalDetails(responseObserver);
		File directory = new File("");
  		String name = directory.getAbsolutePath() + "\\src\\main\\resources\\animals.csv";
		Scanner sc;
		try {
			sc = new Scanner(new File(name));
			sc.nextLine();
			String st = "";
			while (sc.hasNextLine())  //returns a boolean value
			{
				st = sc.nextLine();
				String[] data = st.split(",");
				AnimalId mcid = AnimalId.newBuilder().setId(Integer.parseInt(data[0])).build();
				AnimalDetail md = AnimalDetail.newBuilder()
						.setAnimalID(mcid)
						.setTypeOfAnimalValue(Integer.parseInt(data[1]))
						.setDateOfBirth(data[2])
						.setDateNextVaccine(data[3])
						.build();
				requestObserver.onNext(md);
			}
			sc.close();  //closes the scanner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		requestObserver.onCompleted();

	}

	
	
	public static void getLiveHeartRate(int animalID) {
		AnimalId id = AnimalId.newBuilder()
				.setId(animalID)
				.build();
		try {
			Iterator<LiveHeartRate> it = blockingStub2.getLiveHeartRate(id);
			System.out.println("Getting heart rate:");
			while(it.hasNext()) {
				LiveHeartRate temp = it.next();
				System.out.println("Getting heart rate:" + temp.getBpm());				
			}
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}

}
