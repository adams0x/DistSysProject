package ds.client;

import java.awt.EventQueue;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JFrame;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import ds.client.ModelsUI.AnimalIdModel;
import ds.client.ModelsUI.AnimalIdCollectionModel;
import ds.client.ModelsUI.MachineIdCollectionModel;
import ds.client.ModelsUI.MachineIdModel;
import ds.client.ModelsUI.MachineReportCollectionModel;
import ds.client.ModelsUI.MachineReportModel;
import ds.client.ModelsUI.LiveHeartRateModel;
import ds.client.ModelsUI.AnimalHealthReportModel;
import ds.client.ModelsUI.AnimalHealthReportCollectionModel;
import ds.livestockActivityService.AnimalDetail;
import ds.livestockActivityService.AnimalHealthInfo;
import ds.livestockActivityService.AnimalId;
import ds.livestockActivityService.CurrentActivity;
import ds.livestockActivityService.LiveHeartRate;
import ds.livestockActivityService.LivestockActivityServiceGrpc;
import ds.livestockActivityService.SetAnimalDetailsReply;
import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceBlockingStub;
import ds.livestockActivityService.LivestockActivityServiceGrpc.LivestockActivityServiceStub;
import ds.milkingParlourService.Empty;
import ds.milkingParlourService.MachineDetail;
import ds.milkingParlourService.MachineId;
import ds.milkingParlourService.MachineReportDate;
import ds.milkingParlourService.MachineTimeSpan;
import ds.milkingParlourService.MilkQuantity;
import ds.milkingParlourService.MilkReport;
import ds.milkingParlourService.MilkingParlourServiceGrpc;
import ds.milkingParlourService.SetMachineDetailsReply;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceBlockingStub;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceStub;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.Context.CancellableContext;
import io.grpc.stub.StreamObserver;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.List;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.ObjectProperty; 

public class ClientUI {

	private JFrame frame;
	private MachineIdCollectionModel mc;
	private MachineReportCollectionModel mcListReport;
	private MachineIdModel mm = new MachineIdModel();
	private MachineReportModel mReport = new MachineReportModel();
	private AnimalIdCollectionModel ac;
	private AnimalIdModel am = new AnimalIdModel();
	private AnimalHealthReportModel hm = new AnimalHealthReportModel();
	private AnimalHealthReportCollectionModel hc;

	private jmDNSInfo jmDnsMilkParlour;
	static ArrayList<Integer> machineIDs = new ArrayList<Integer>();
	private MilkingParlourServiceBlockingStub blockingStub;
	private MilkingParlourServiceStub asyncStub;
	private ServiceInfo milkParlourServiceInfo;

	/*
	 * Livestock activity service members
	 */
	private jmDNSInfo jmDnsLivestock;
	private LivestockActivityServiceBlockingStub blockingStub2;
	private LivestockActivityServiceStub asyncStub2;
	private ServiceInfo livestockActivityServiceInfo;
	private ArrayList<Integer> animalIDs = new ArrayList<Integer>();
	private LiveHeartRateModel liveHeartRateModel = new LiveHeartRateModel();
	
	
	private CancellableContext withCancellation2;
	
	private JLabel lblNewLabel_1;
	private JList list;
	private JDateChooser dateBeginMilkVolume;
	private JDateChooser dateEndMilkVolume;
	private JDateChooser dateOfReport;
	private JButton btnGetMilkVolume;
	private JButton btnGetMachineReports;
	private JTable table;
	private JLabel lblNewLabel_1_1;
	private JList listAnimalIds;
	private JLabel lblLiveHeartRateAnimalId;
	private JLabel lblLiveHeartRateAnimalType;
	private JLabel lblLiveHeartRateBpm;
	private JTable tableHealthReports;


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
		jmDnsLivestock = new jmDNSInfo();
		jmDnsLivestock.setDiscoveryStatus("Initialised");
		mc = new MachineIdCollectionModel();
		mcListReport = new MachineReportCollectionModel();
		ac = new AnimalIdCollectionModel();
		hc = new AnimalHealthReportCollectionModel();
		//mm = new MachineIdModel();
		frame = new JFrame();
		frame.setResizable(false);
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

				newCachedThreadPool.submit(() -> {
					String livestockActivityServiceType = "_livestockActivity._tcp.local.";
					discoverLivestockActivityService(livestockActivityServiceType);
					String host = livestockActivityServiceInfo.getHostAddresses()[0];
					int port = livestockActivityServiceInfo.getPort();

					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					blockingStub2 = LivestockActivityServiceGrpc.newBlockingStub(channel);
					asyncStub2 = LivestockActivityServiceGrpc.newStub(channel);
					
					setAnimalDetails();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // important, allow time for all data transferred
					getAnimalIDs();
				});
				
				
			}
		});
		frame.setBounds(100, 100, 1259, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1233, 699);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelMilkMachines = new JPanel();
		panelMilkMachines.setName("");
		tabbedPane.addTab("Milk Machines", null, panelMilkMachines, null);
		panelMilkMachines.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Milking Parlour Service Discovery Status:");
		lblNewLabel.setBounds(34, 0, 277, 23);
		panelMilkMachines.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblNewLabel_1 = new JLabel("???");
		lblNewLabel_1.setBounds(323, 0, 245, 23);
		panelMilkMachines.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(128, 128, 128)));
		list.setBounds(34, 47, 168, 338);
		panelMilkMachines.add(list);
		list.setMaximumSize(new Dimension(100, 100));
		list.setOpaque(false);
		
		JLabel lblNewLabel_2 = new JLabel("Available Machines:");
		lblNewLabel_2.setBounds(44, 30, 143, 17);
		panelMilkMachines.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_1.setBounds(214, 47, 175, 208);
		panelMilkMachines.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("<HTML>Select date range to obtain volume of milk for that duration<HTML>");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 0, 153, 53);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("From:");
		lblNewLabel_3.setBounds(10, 56, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		dateBeginMilkVolume = new JDateChooser();
		dateBeginMilkVolume.setBounds(10, 73, 157, 32);
		panel_1.add(dateBeginMilkVolume);
		dateBeginMilkVolume.setDateFormatString("dd/MM/yyyy");
		dateBeginMilkVolume.setEnabled(false);
		dateBeginMilkVolume.setDate(new Date());
		
		JLabel lblNewLabel_4 = new JLabel("To:");
		lblNewLabel_4.setBounds(10, 108, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		dateEndMilkVolume = new JDateChooser();
		dateEndMilkVolume.setBounds(10, 121, 157, 32);
		panel_1.add(dateEndMilkVolume);
		dateEndMilkVolume.setEnabled(false);
		dateEndMilkVolume.setDateFormatString("dd/MM/yyyy");
		dateEndMilkVolume.setDate(new Date());
		
		btnGetMilkVolume = new JButton("Get Milk Volume");
		btnGetMilkVolume.setBounds(10, 164, 157, 32);
		panel_1.add(btnGetMilkVolume);
		btnGetMilkVolume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
				String dateFrom = dateFormat.format(dateBeginMilkVolume.getDate());
				String dateTo = dateFormat.format(dateEndMilkVolume.getDate());
				getMilkQuantity((int)list.getSelectedValue(), dateFrom, dateTo);
			}
		});
		btnGetMilkVolume.setEnabled(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_2.setBounds(214, 263, 175, 122);
		panelMilkMachines.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Report Date:");
		lblNewLabel_5.setBounds(12, 12, 93, 13);
		panel_2.add(lblNewLabel_5);
		
		dateOfReport = new JDateChooser();
		dateOfReport.setBounds(12, 29, 157, 32);
		panel_2.add(dateOfReport);
		dateOfReport.setEnabled(false);
		dateOfReport.setDateFormatString("dd/MM/yyyy");
		dateOfReport.setDate(new Date());
		
		btnGetMachineReports = new JButton("Get Reports");
		btnGetMachineReports.setBounds(12, 71, 157, 32);
		panel_2.add(btnGetMachineReports);
		btnGetMachineReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
				String dateReport = dateFormat.format(dateOfReport.getDate());
				getMilkReports(list.getSelectedValuesList(), dateReport);
			}
		});
		btnGetMachineReports.setEnabled(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Available Reports:");
		lblNewLabel_2_1.setBounds(401, 32, 155, 13);
		panelMilkMachines.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 47, 790, 583);
		panelMilkMachines.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Date", "Volume", "Heated (\u00B0C)", "Heated Time", "Chilled (\u00B0C)", "Service"
			}
		));
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		
		JPanel panelLivestock = new JPanel();
		tabbedPane.addTab("Livestock Activity", null, panelLivestock, null);
		panelLivestock.setLayout(null);
		
		JLabel lblLivestockActivityService = new JLabel("Livestock Activity Service Discovery Status:");
		lblLivestockActivityService.setBounds(38, 12, 280, 15);
		lblLivestockActivityService.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLivestockActivityService.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLivestock.add(lblLivestockActivityService);
		
		lblNewLabel_1_1 = new JLabel("???");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(335, 11, 245, 23);
		panelLivestock.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 39, 214, 346);
		panelLivestock.add(scrollPane_1);
		
		listAnimalIds = new JList();
		scrollPane_1.setViewportView(listAnimalIds);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_4.setBounds(287, 39, 167, 180);
		panelLivestock.add(panel_4);
		panel_4.setLayout(null);
		
		lblLiveHeartRateAnimalId = new JLabel("animal id");
		lblLiveHeartRateAnimalId.setBounds(12, 12, 143, 26);
		panel_4.add(lblLiveHeartRateAnimalId);
		
		lblLiveHeartRateAnimalType = new JLabel("animal type");
		lblLiveHeartRateAnimalType.setBounds(12, 50, 143, 16);
		panel_4.add(lblLiveHeartRateAnimalType);
		
		lblLiveHeartRateBpm = new JLabel("heart rate");
		lblLiveHeartRateBpm.setBounds(12, 78, 55, 16);
		panel_4.add(lblLiveHeartRateBpm);
		
		JButton btnNewButton = new JButton("start monitor");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listAnimalIds.getSelectedValue()==null)
					return;
				else {
					getLiveHeartRateBegin((int)listAnimalIds.getSelectedValue());
				}
			}
		});
		btnNewButton.setBounds(22, 106, 114, 26);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("stop monitor");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				withCancellation2.cancel(null);
			}
		});
		btnNewButton_1.setBounds(22, 142, 114, 26);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_5.setBounds(287, 231, 167, 154);
		panelLivestock.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Get the animal activity:");
		lblNewLabel_7.setBounds(12, 28, 143, 16);
		panel_5.add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("Get Activity");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listAnimalIds.getSelectedValue()==null)
					return;
				else {
					getAnimalActivity((int)listAnimalIds.getSelectedValue());
				}
			}
		});
		btnNewButton_2.setBounds(25, 56, 113, 26);
		panel_5.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel.setBounds(466, 39, 728, 599);
		panelLivestock.add(panel);
		panel.setLayout(null);
		
		JButton btnGetHealthReports = new JButton("Get Health Reports");
		btnGetHealthReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getAnimalVitals(listAnimalIds.getSelectedValuesList());
			}
		});
		btnGetHealthReports.setBounds(12, 12, 152, 26);
		panel.add(btnGetHealthReports);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 50, 691, 521);
		panel.add(scrollPane_2);
		
		tableHealthReports = new JTable();
		scrollPane_2.setViewportView(tableHealthReports);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedIndices().length==1) {
					dateBeginMilkVolume.setEnabled(true);
					dateEndMilkVolume.setEnabled(true);
					dateOfReport.setEnabled(true);
					btnGetMilkVolume.setEnabled(true);
					btnGetMachineReports.setEnabled(true);
				}

				else if(list.getSelectedIndices().length>1) {
					dateBeginMilkVolume.setEnabled(false);
					dateEndMilkVolume.setEnabled(false);
					dateOfReport.setEnabled(true);
					btnGetMilkVolume.setEnabled(false);
					btnGetMachineReports.setEnabled(true);
				}

				else {
					dateBeginMilkVolume.setEnabled(false);
					dateEndMilkVolume.setEnabled(false);
					dateOfReport.setEnabled(false);
					btnGetMilkVolume.setEnabled(false);
					btnGetMachineReports.setEnabled(false);
				}
			}
		});
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
	
	
	
	private void getMilkQuantity(int machineId, String from, String to) {
		MachineId mcId = MachineId.newBuilder().setId(machineId).build();
		MachineTimeSpan mc = MachineTimeSpan.newBuilder()
				.setMachineID(mcId)
				.setStartDate(from)
				.setEndDate(to)
				.build();
		MilkQuantity reply = blockingStub.getMilkVolume(mc);
		System.out.println("Milk volume at machine id=" + machineId +" is " + reply.getVolumeLitres() + " litres");
		JLabel resultLabel = new JLabel("Milk volume at machine id=" + machineId +" is " + reply.getVolumeLitres() + " litres from " + from + " to " + to);
		resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabel);
	}
	
	
	
	private void getMilkReports(List<Integer> mids, String reportDate) {
		
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
				SwingUtilities.invokeLater(new Runnable() {
					 public void run() {
							mReport = new MachineReportModel();
							mReport.setId(report.getMachId());
							mReport.setReportDate(report.getReportDate());
							mReport.setDateNextService(report.getDateNextService());
							mReport.setHeatedTemperature(report.getHeatedTemperature());
							mReport.setHeatedDuration(report.getHeatedDuration());
							mReport.setChilledTemperature(report.getChilledTemperature());
							mReport.setVolumeLitres(report.getVolumeLitres());
							mcListReport.addMachine(mReport);
						 }
						 });
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
			for(int i = 0; i < mids.size(); i++) {
				requestObserver.onNext(MachineReportDate.newBuilder()
						.setMachineID(MachineId.newBuilder().setId((int)mids.get(i)).build())
						.setReportDate(reportDate)
						.build());
					//Thread.sleep(500);
			}

			// Mark the end of requests
			requestObserver.onCompleted();
			//Thread.sleep(2000);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} //catch (InterruptedException e) {			
			//e.printStackTrace();
		//}

	}

	
	private void discoverLivestockActivityService(String serviceType) {
		try {
			// Create a JmDNS instance
			jmDnsLivestock.setDiscoveryStatus("Discovering...");
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(serviceType, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					
					System.out.println("Livestock Activity Service resolved: " + event.getInfo());
					livestockActivityServiceInfo = event.getInfo();
					int port = livestockActivityServiceInfo.getPort();
					System.out.println("resolving " + serviceType + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + livestockActivityServiceInfo.getNiceTextString());
					System.out.println("\t host: " + livestockActivityServiceInfo.getHostAddresses()[0]);
					jmDnsLivestock.setDiscoveryStatus("Livestock Activity service resolved");
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Livestock Activity Service removed: " + event.getInfo());
					jmDnsLivestock.setDiscoveryStatus("Livestock Activity service removed");
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Livestock Activity Service added: " + event.getInfo());
					jmDnsLivestock.setDiscoveryStatus("Livestock Activity service added");
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			if(livestockActivityServiceInfo==null)
				jmDnsLivestock.setDiscoveryStatus("Livestock Activity service not found");
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

	

	private void setAnimalDetails() {
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

	
	private void getAnimalIDs() {
		ds.livestockActivityService.Empty emp = ds.livestockActivityService.Empty.newBuilder().build();
		try {
			Iterator<AnimalId> it = blockingStub2.getAnimalIds(emp);
			System.out.println("Getting animal id's:");
			while(it.hasNext()) {
				AnimalId temp = it.next();
				animalIDs.add(temp.getId());				
				SwingUtilities.invokeLater(new Runnable() {
					 public void run() {
							am = new AnimalIdModel();
							am.setId(temp.getId());
							ac.addAnimal(am);
						 }
						 });
			}
			System.out.println(animalIDs.toString());
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}
	

	
	private void getAnimalActivity(int animalId) {
		AnimalId aId = AnimalId.newBuilder().setId(animalId).build();

		CurrentActivity reply = blockingStub2.getCurrentActivity(aId);
		System.out.println("Activity of "+ reply.getAnimal().getTypeOfAnimal() + " with id=" + animalId +" is " + reply.getActivity());
		JLabel resultLabelActivity = new JLabel("Activity of "+ reply.getAnimal().getTypeOfAnimal() + " with id=" + animalId +" is " + reply.getActivity());
		resultLabelActivity.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabelActivity);
	}


	private void getAnimalVitals(List<Integer> mids) {
		
		//Create a StreamObserver that receives the stream of milk reports
		StreamObserver<AnimalHealthInfo> responseObserver = new StreamObserver<AnimalHealthInfo>() {

			@Override
			public void onNext(AnimalHealthInfo report) {
				//MilkReport received, extract the data
				System.out.println("Receiving report for animal health: " + report.getAnimal().getAnimalID().getId() );
				System.out.println("Report date: " + report.getReportDate() );
				System.out.println("Milk volume (L): " + report.getAnimal().getTypeOfAnimal() );
				System.out.println("Heated Temperature (C): " + report.getAnimal().getDateOfBirth() );
				System.out.println("Heated Duration (mins): " + report.getAnimal().getDateNextVaccine() );
				System.out.println("Cooled Temperature (C): " + report.getMinBPM() );
				System.out.println("Next service on: " + report.getMaxBPM() );
				System.out.println("Next service on: " + report.getAvgBPM() );
				System.out.println("Next service on: " + report.getHealthIndicator() );
				System.out.println();
				SwingUtilities.invokeLater(new Runnable() {
					 public void run() {
							hm = new AnimalHealthReportModel();
							hm.setId(report.getAnimal().getAnimalID().getId());
							hm.setReportDate(report.getReportDate());
							hm.setAnimalType(report.getAnimal().getTypeOfAnimal().toString());
							hm.setDateOfBirth(report.getAnimal().getDateOfBirth());
							hm.setDateNextVaccine(report.getAnimal().getDateNextVaccine());
							hm.setMinBPM(report.getMinBPM());
							hm.setMaxBPM(report.getMaxBPM());
							hm.setAvgBPM(report.getAvgBPM());
							hm.setHealth(report.getHealthIndicator().toString());
							hc.addHealthReport(hm);
						 }
						 });
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... all animal health reports recieved");
			}

		};

		//Create a StreamObserver that sends the stream of MachineReportsDate's
		StreamObserver<AnimalId> requestObserver = asyncStub2.getAnimalVitals(responseObserver);
		try {
			for(int i = 0; i < mids.size(); i++) {
				requestObserver.onNext(AnimalId.newBuilder()
						.setId((int)mids.get(i))
						.build());
			}

			// Mark the end of requests
			requestObserver.onCompleted();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	
	
	
	private void getLiveHeartRateBegin(int animalID) {
		
		StreamObserver<LiveHeartRate> streamHeartRateRecvd = new StreamObserver<LiveHeartRate>() {
			@Override
			public void onNext(LiveHeartRate lhr) {
				System.out.println("Getting heart rate:" + lhr.getBpm());
				SwingUtilities.invokeLater(new Runnable() {
					 public void run() {
							liveHeartRateModel.setId(lhr.getAnimal().getAnimalID().getId());
							liveHeartRateModel.setAnimalType(lhr.getAnimal().getTypeOfAnimal().toString());
							liveHeartRateModel.setLiveHeartRate(lhr.getBpm());
						 }
						 });
			}
			
			@Override
			public void onError(Throwable t) {
				//t.printStackTrace();
				System.out.println("Server stream live heartrate error: " +t);
			}

			@Override
			public void onCompleted() {
				System.out.println("Server finished sending live heartrate");
			}
		};		
		
		AnimalId id = AnimalId.newBuilder()
				.setId(animalID)
				.build();
		try {
			withCancellation2 = Context.current().withCancellation();
			withCancellation2.run(() -> {
				asyncStub2.getLiveHeartRate(id, streamHeartRateRecvd);
			});

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
		//
		BeanProperty<MachineReportCollectionModel, List<MachineReportModel>> machineReportCollectionModelBeanProperty = BeanProperty.create("machines");
		JTableBinding<MachineReportModel, MachineReportCollectionModel, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, mcListReport, machineReportCollectionModelBeanProperty, table);
		//
		BeanProperty<MachineReportModel, Integer> machineReportModelBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty).setColumnName("Machine Id");
		//
		BeanProperty<MachineReportModel, String> machineReportModelBeanProperty_1 = BeanProperty.create("reportDate");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_1).setColumnName("Date");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_2 = BeanProperty.create("heatedTemperature");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_2).setColumnName("Heated \u00B0C");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_3 = BeanProperty.create("heatedDuration");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_3).setColumnName("Heat Hrs");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_4 = BeanProperty.create("chilledTemperature");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_4).setColumnName("Chilled \u00B0C");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_5 = BeanProperty.create("volumeLitres");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_5).setColumnName("Volume L");
		//
		BeanProperty<MachineReportModel, String> machineReportModelBeanProperty_6 = BeanProperty.create("dateNextService");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_6).setColumnName("Next Service");
		//
		jTableBinding.bind();
		//
		AutoBinding<jmDNSInfo, String, JLabel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, jmDnsLivestock, jmDNSInfoBeanProperty, lblNewLabel_1_1, jLabelBeanProperty);
		autoBinding_1.bind();
		//
		BeanProperty<AnimalIdCollectionModel, List<AnimalIdModel>> animalIdCollectionModelBeanProperty = BeanProperty.create("animals");
		JListBinding<AnimalIdModel, AnimalIdCollectionModel, JList> jListBinding_1 = SwingBindings.createJListBinding(UpdateStrategy.READ, ac, animalIdCollectionModelBeanProperty, listAnimalIds);
		//
		BeanProperty<AnimalIdModel, Integer> animalIdModelBeanProperty = BeanProperty.create("id");
		jListBinding_1.setDetailBinding(animalIdModelBeanProperty);
		//
		jListBinding_1.bind();
		//
		BeanProperty<LiveHeartRateModel, Integer> liveHeartRateModelBeanProperty = BeanProperty.create("id");
		AutoBinding<LiveHeartRateModel, Integer, JLabel, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, liveHeartRateModel, liveHeartRateModelBeanProperty, lblLiveHeartRateAnimalId, jLabelBeanProperty);
		autoBinding_2.bind();
		//
		BeanProperty<LiveHeartRateModel, Integer> liveHeartRateModelBeanProperty_2 = BeanProperty.create("liveHeartRate");
		AutoBinding<LiveHeartRateModel, Integer, JLabel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, liveHeartRateModel, liveHeartRateModelBeanProperty_2, lblLiveHeartRateBpm, jLabelBeanProperty);
		autoBinding_4.bind();
		//
		BeanProperty<LiveHeartRateModel, String> liveHeartRateModelBeanProperty_1 = BeanProperty.create("animalType");
		AutoBinding<LiveHeartRateModel, String, JLabel, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, liveHeartRateModel, liveHeartRateModelBeanProperty_1, lblLiveHeartRateAnimalType, jLabelBeanProperty);
		autoBinding_3.bind();
		//
		BeanProperty<AnimalHealthReportCollectionModel, List<AnimalHealthReportModel>> animalHealthReportCollectionModelBeanProperty = BeanProperty.create("healthReports");
		JTableBinding<AnimalHealthReportModel, AnimalHealthReportCollectionModel, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, hc, animalHealthReportCollectionModelBeanProperty, tableHealthReports);
		//
		BeanProperty<AnimalHealthReportModel, Integer> animalHealthReportModelBeanProperty = BeanProperty.create("id");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty).setColumnName("Animal Id");
		//
		BeanProperty<AnimalHealthReportModel, String> animalHealthReportModelBeanProperty_1 = BeanProperty.create("reportDate");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_1).setColumnName("Date");
		//
		BeanProperty<AnimalHealthReportModel, String> animalHealthReportModelBeanProperty_2 = BeanProperty.create("dateOfBirth");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_2).setColumnName("DOB");
		//
		BeanProperty<AnimalHealthReportModel, String> animalHealthReportModelBeanProperty_3 = BeanProperty.create("dateNextVaccine");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_3).setColumnName("Vaccine Due");
		//
		BeanProperty<AnimalHealthReportModel, String> animalHealthReportModelBeanProperty_4 = BeanProperty.create("animalType");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_4).setColumnName("Type");
		//
		BeanProperty<AnimalHealthReportModel, Integer> animalHealthReportModelBeanProperty_5 = BeanProperty.create("minBPM");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_5).setColumnName("BPM Min");
		//
		BeanProperty<AnimalHealthReportModel, Integer> animalHealthReportModelBeanProperty_6 = BeanProperty.create("maxBPM");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_6).setColumnName("BPM Max");
		//
		BeanProperty<AnimalHealthReportModel, Integer> animalHealthReportModelBeanProperty_7 = BeanProperty.create("avgBPM");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_7).setColumnName("BPM Avg");
		//
		BeanProperty<AnimalHealthReportModel, String> animalHealthReportModelBeanProperty_8 = BeanProperty.create("health");
		jTableBinding_1.addColumnBinding(animalHealthReportModelBeanProperty_8).setColumnName("Overall");
		//
		jTableBinding_1.bind();
	}
}
