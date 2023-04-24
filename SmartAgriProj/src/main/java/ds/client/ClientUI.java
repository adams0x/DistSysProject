package ds.client;

import java.awt.EventQueue;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import ds.client.ModelsUI.MachineIdCollectionModel;
import ds.client.ModelsUI.MachineIdModel;
import ds.milkingParlourService.Empty;
import ds.milkingParlourService.MachineDetail;
import ds.milkingParlourService.MachineId;
import ds.milkingParlourService.MilkingParlourServiceGrpc;
import ds.milkingParlourService.SetMachineDetailsReply;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceBlockingStub;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JList;
import java.util.List;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.ELProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientUI {

	private JFrame frame;
	private MachineIdCollectionModel mc;
	private MachineIdModel mm = new MachineIdModel();
	private jmDNSInfo jmDnsMilkParlour;
	static ArrayList<Integer> machineIDs = new ArrayList<Integer>();
	private MilkingParlourServiceBlockingStub blockingStub;
	private MilkingParlourServiceStub asyncStub;
	private ServiceInfo milkParlourServiceInfo;
	private JLabel lblNewLabel_1;
	private JList list;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI window = new ClientUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jmDnsMilkParlour = new jmDNSInfo();
		jmDnsMilkParlour.setDiscoveryStatus("Initialised");
		mc = new MachineIdCollectionModel();
		//mm = new MachineIdModel();
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
				newCachedThreadPool.submit(() -> {
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
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // important, allow time for all data transferred
					getMachineIDs();


				});
			
			}
		});
		frame.setBounds(100, 100, 1017, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Milking Parlour Service Discovery Status:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(227, 10, 277, 23);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("???");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(514, 10, 245, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		list = new JList();
		list.setBounds(49, 105, 157, 325);
		frame.getContentPane().add(list);
		initDataBindings();
	}
	
	
	
	private void discoverMilkParlourService(String serviceType) {
		try {
			// Create a JmDNS instance
			jmDnsMilkParlour.setDiscoveryStatus("Discovering...");
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(serviceType, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					
					System.out.println("Milk Parlour Service resolved: " + event.getInfo());
					milkParlourServiceInfo = event.getInfo();
					int port = milkParlourServiceInfo.getPort();
					System.out.println("resolving " + serviceType + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + milkParlourServiceInfo.getNiceTextString());
					System.out.println("\t host: " + milkParlourServiceInfo.getHostAddresses()[0]);
					jmDnsMilkParlour.setDiscoveryStatus("Milk Parlour service resolved");
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Milk Parlour Service removed: " + event.getInfo());
					jmDnsMilkParlour.setDiscoveryStatus("Milk Parlour service removed");
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Milk Parlour Service added: " + event.getInfo());
					jmDnsMilkParlour.setDiscoveryStatus("Milk Parlour service added");
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			if(milkParlourServiceInfo==null)
				jmDnsMilkParlour.setDiscoveryStatus("Milk Parlour service not found");
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

	private void setMachineDetails() {
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


	private void getMachineIDs() {
		Empty emp = Empty.newBuilder().build();
		try {
			Iterator<MachineId> it = blockingStub.getMachineIds(emp);
			System.out.println("Getting machine id's:");
			while(it.hasNext()) {
				MachineId temp = it.next();
				machineIDs.add(temp.getId());				
				SwingUtilities.invokeLater(new Runnable() {
					 public void run() {
							mm = new MachineIdModel();
							mm.setId(temp.getId());
							mc.addMachine(mm);
						 }
						 });
			}
			System.out.println(machineIDs.toString());
				
			//mc.setIds(arr);
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}
	protected void initDataBindings() {
		BeanProperty<jmDNSInfo, String> jmDNSInfoBeanProperty = BeanProperty.create("discoveryStatus");
		BeanProperty<JLabel, String> jLabelBeanProperty = BeanProperty.create("text");
		AutoBinding<jmDNSInfo, String, JLabel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, jmDnsMilkParlour, jmDNSInfoBeanProperty, lblNewLabel_1, jLabelBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<MachineIdCollectionModel, List<MachineIdModel>> machineIdCollectionModelBeanProperty = BeanProperty.create("machines");
		JListBinding<MachineIdModel, MachineIdCollectionModel, JList> jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ, mc, machineIdCollectionModelBeanProperty, list);
		//
		BeanProperty<MachineIdModel, Integer> machineIdModelBeanProperty = BeanProperty.create("id");
		jListBinding.setDetailBinding(machineIdModelBeanProperty, "b123");
		//
		jListBinding.bind();
	}
}
