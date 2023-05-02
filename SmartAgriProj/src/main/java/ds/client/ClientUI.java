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
import ds.client.ModelsUI.jmDNSInfo;
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
import ds.userService.LoginRequest;
import ds.userService.LoginResponse;
import ds.userService.LogoutRequest;
import ds.userService.LogoutResponse;
import ds.userService.UserServiceGrpc;
import ds.userService.UserServiceGrpc.UserServiceBlockingStub;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceBlockingStub;
import ds.milkingParlourService.MilkingParlourServiceGrpc.MilkingParlourServiceStub;
import io.grpc.ChannelCredentials;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.TlsChannelCredentials;
import io.grpc.Context.CancellableContext;
import io.grpc.Grpc;
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
import javax.swing.JTextField;
import javax.swing.JPasswordField; 

public class ClientUI {

	private JFrame frame;
	/*
	 * Milking parlour service members
	 */
	private jmDNSInfo jmDnsMilkParlour;
	static ArrayList<Integer> machineIDs = new ArrayList<Integer>();
	private MilkingParlourServiceBlockingStub blockingStub;
	private MilkingParlourServiceStub asyncStub;
	private ServiceInfo milkParlourServiceInfo;
	private MachineIdCollectionModel mc;
	private MachineReportCollectionModel mcListReport;
	private MachineIdModel mm = new MachineIdModel();
	private MachineReportModel mReport = new MachineReportModel();

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
	private AnimalIdCollectionModel ac;
	private AnimalIdModel am = new AnimalIdModel();
	private AnimalHealthReportModel hm = new AnimalHealthReportModel();
	private AnimalHealthReportCollectionModel hc;
	private boolean isHeartRateMonitorActive = false;

	/*
	 * User Login/Out service members
	 */
	private jmDNSInfo jmDnsUser;
	private UserServiceBlockingStub blockingStub3;
	private ServiceInfo userServiceInfo;
	private String jwtSignedToken = "invalid user";
	
	/*
	 * UI controls
	 */	
	private JLabel lblNewLabel_1;
	private JList jlistAvailMachines;
	private JDateChooser dateBeginMilkVolume;
	private JDateChooser dateEndMilkVolume;
	private JDateChooser dateOfReport;
	private JButton btnGetMilkVolume;
	private JButton btnGetMachineReports;
	private JTable jtableReports;
	private JLabel lblNewLabel_1_1;
	private JList jlistAnimalIds;
	private JLabel lblLiveHeartRateAnimalId;
	private JLabel lblLiveHeartRateAnimalType;
	private JLabel lblLiveHeartRateBpm;
	private JTable jtableHealthReports;
	private JLabel lblNewLabel_1_2;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;


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
		jmDnsUser = new jmDNSInfo();
		jmDnsUser.setDiscoveryStatus("Initialised");
		mc = new MachineIdCollectionModel();
		mcListReport = new MachineReportCollectionModel();
		ac = new AnimalIdCollectionModel();
		hc = new AnimalHealthReportCollectionModel();
		//mm = new MachineIdModel();
		frame = new JFrame();
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			/**
			 * Main window opened so begin service discovery and sending mock data to the servers
			 */
			@Override
			public void windowOpened(WindowEvent e) {
				//use threadpool to for executing service discovery in initialising so that
				//the UI thread remains responsive
				ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
				/**
				 * Launch discovery of Milking parlour service and create channels then send some mock data from csv file
				 * After that read back the list of milking machine id's that were created by the service
				 */
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
					
					setMachineDetails();//send the mock data to the service via client stream
					try {
						Thread.sleep(2000);// important, allow time for all data transferred
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} 
					getMachineIDs();//Read machine id's created in the service via server stream
				});
				/**
				 * Launch discovery of livestock activity service and create channels then send some mock data from csv file
				 * After that read back the list of animal id's that were created by the service
				 */
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
					
					setAnimalDetails();//send the mock data to the service via client stream
					try {
						Thread.sleep(2000);// important, allow time for all data transferred
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} 
					getAnimalIDs();//Read animal id's created in the service via server stream
				});
				/**
				 * Launch discovery of user service and create a channel
				 * This channel uses ssl/tls server authentication
				 */
				newCachedThreadPool.submit(() -> {
					String userServiceType = "_user._tcp.local.";
					discoverUserService(userServiceType);
					//String host = userServiceInfo.getHostAddresses()[0];
					String host = "localhost";
					int port = userServiceInfo.getPort();

					try {
						ChannelCredentials creds;
						creds = TlsChannelCredentials.newBuilder()
							    .trustManager(new File("src//main//resources//ssl//publickeycert.pem"))
							    .build();
						ManagedChannel channel = Grpc.newChannelBuilderForAddress(host, port, creds)
								.build();
						blockingStub3 = UserServiceGrpc.newBlockingStub(channel);

					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				});

				
			}
		});
		/**
		 * A lot of windowbuilder generated code follows for UI layout
		 */
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
		
		jlistAvailMachines = new JList<>();
		jlistAvailMachines.setBorder(new LineBorder(new Color(128, 128, 128)));
		jlistAvailMachines.setBounds(34, 47, 168, 338);
		panelMilkMachines.add(jlistAvailMachines);
		jlistAvailMachines.setMaximumSize(new Dimension(100, 100));
		jlistAvailMachines.setOpaque(false);
		
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
				getMilkQuantity((int)jlistAvailMachines.getSelectedValue(), dateFrom, dateTo);
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
				getMilkReports(jlistAvailMachines.getSelectedValuesList(), dateReport);
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
		
		jtableReports = new JTable();
		jtableReports.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Date", "Volume", "Heated (\u00B0C)", "Heated Time", "Chilled (\u00B0C)", "Service"
			}
		));
		scrollPane.setViewportView(jtableReports);
		jtableReports.setRowSelectionAllowed(false);
		
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
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_4.setBounds(287, 39, 167, 180);
		panelLivestock.add(panel_4);
		panel_4.setLayout(null);
		
		lblLiveHeartRateAnimalId = new JLabel("animal id");
		lblLiveHeartRateAnimalId.setBounds(91, 17, 64, 16);
		panel_4.add(lblLiveHeartRateAnimalId);
		
		lblLiveHeartRateAnimalType = new JLabel("animal type");
		lblLiveHeartRateAnimalType.setBounds(91, 45, 64, 16);
		panel_4.add(lblLiveHeartRateAnimalType);
		
		lblLiveHeartRateBpm = new JLabel("heart rate");
		lblLiveHeartRateBpm.setBounds(91, 73, 64, 16);
		panel_4.add(lblLiveHeartRateBpm);

		JButton btnStopMonitor = new JButton("stop monitor");
		btnStopMonitor.setEnabled(false);
		btnStopMonitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isHeartRateMonitorActive)
					withCancellation2.cancel(null);
				isHeartRateMonitorActive = false;
			}
		});
		btnStopMonitor.setBounds(22, 142, 114, 26);
		panel_4.add(btnStopMonitor);

		
		JButton btnStartMonitor = new JButton("start monitor");
		btnStartMonitor.setEnabled(false);
		btnStartMonitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jlistAnimalIds.getSelectedValue()==null)
					return;
				else {
					if(!isHeartRateMonitorActive) {
						getLiveHeartRateBegin((int)jlistAnimalIds.getSelectedValue());
						btnStopMonitor.setEnabled(true);											
					}
				}
			}
		});
		btnStartMonitor.setBounds(22, 106, 114, 26);
		panel_4.add(btnStartMonitor);
		
		JLabel lblNewLabel_8 = new JLabel("ID:");
		lblNewLabel_8.setBounds(12, 17, 67, 16);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Type:");
		lblNewLabel_9.setBounds(12, 45, 67, 16);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Live BPM:");
		lblNewLabel_10.setBounds(12, 73, 67, 16);
		panel_4.add(lblNewLabel_10);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_5.setBounds(287, 231, 167, 154);
		panelLivestock.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Get the animal activity:");
		lblNewLabel_7.setBounds(12, 28, 143, 16);
		panel_5.add(lblNewLabel_7);
		
		JButton btnGetActivity = new JButton("Get Activity");
		btnGetActivity.setEnabled(false);
		btnGetActivity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jlistAnimalIds.getSelectedValue()==null)
					return;
				else {
					getAnimalActivity((int)jlistAnimalIds.getSelectedValue());
				}
			}
		});
		btnGetActivity.setBounds(25, 56, 113, 26);
		panel_5.add(btnGetActivity);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel.setBounds(466, 39, 728, 599);
		panelLivestock.add(panel);
		panel.setLayout(null);
		
		JButton btnGetHealthReports = new JButton("Get Health Reports");
		btnGetHealthReports.setEnabled(false);
		btnGetHealthReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getAnimalVitals(jlistAnimalIds.getSelectedValuesList());
			}
		});
		btnGetHealthReports.setBounds(12, 12, 152, 26);
		panel.add(btnGetHealthReports);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(22, 50, 691, 521);
		panel.add(scrollPane_2);

		
		jlistAnimalIds = new JList<int[]>();
		jlistAnimalIds.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(jlistAnimalIds.getSelectedIndices().length==1) {
					btnStartMonitor.setEnabled(true);
					if(!isHeartRateMonitorActive)
						btnStopMonitor.setEnabled(false);
					btnGetActivity.setEnabled(true);
					btnGetHealthReports.setEnabled(true);
				}

				else if(jlistAnimalIds.getSelectedIndices().length>1) {
					btnStartMonitor.setEnabled(false);
					if(!isHeartRateMonitorActive)
						btnStopMonitor.setEnabled(false);
					btnGetActivity.setEnabled(false);
					btnGetHealthReports.setEnabled(true);
				}

				else {
					btnStartMonitor.setEnabled(false);
					if(!isHeartRateMonitorActive)
						btnStopMonitor.setEnabled(false);
					btnGetActivity.setEnabled(false);
					btnGetHealthReports.setEnabled(false);
				}
			}
		});
		scrollPane_1.setViewportView(jlistAnimalIds);
		
		
		
		jtableHealthReports = new JTable();
		scrollPane_2.setViewportView(jtableHealthReports);
		
		JPanel panelUser = new JPanel();
		tabbedPane.addTab("User", null, panelUser, null);
		panelUser.setLayout(null);
		
		JLabel lblUserServiceDiscovery = new JLabel("User Service Discovery Status:");
		lblUserServiceDiscovery.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserServiceDiscovery.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserServiceDiscovery.setBounds(12, 12, 277, 23);
		panelUser.add(lblUserServiceDiscovery);
		
		lblNewLabel_1_2 = new JLabel("???");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(301, 15, 245, 23);
		panelUser.add(lblNewLabel_1_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_3.setBounds(416, 174, 382, 271);
		panelUser.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("User Name:");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_11.setBounds(26, 66, 94, 16);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Password:");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_12.setBounds(26, 127, 94, 16);
		panel_3.add(lblNewLabel_12);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(193, 66, 104, 20);
		panel_3.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 127, 104, 20);
		panel_3.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = textFieldUserName.getText();
				String pass = new String(passwordField.getPassword());
				if(!user.equals("") && !pass.equals(""))
					login(user, pass);
			}
		});
		btnLogIn.setBounds(229, 203, 99, 26);
		panel_3.add(btnLogIn);
		
		JLabel lblNewLabel_13 = new JLabel("Enter user name and password then log in/out");
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_13.setBounds(12, 12, 358, 26);
		panel_3.add(lblNewLabel_13);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = textFieldUserName.getText();
				if(!user.equals(""))
					logout(user);
			}
		});
		btnNewButton.setBounds(71, 203, 99, 26);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_14 = new JLabel("Hint: try 'user' and 'password'");
		lblNewLabel_14.setBounds(115, 243, 182, 16);
		panel_3.add(lblNewLabel_14);
		jlistAvailMachines.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(jlistAvailMachines.getSelectedIndices().length==1) {
					dateBeginMilkVolume.setEnabled(true);
					dateEndMilkVolume.setEnabled(true);
					dateOfReport.setEnabled(true);
					btnGetMilkVolume.setEnabled(true);
					btnGetMachineReports.setEnabled(true);
				}

				else if(jlistAvailMachines.getSelectedIndices().length>1) {
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
	
	
	/**
	 * Discover milking parlour service using jmDNS
	 */	
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
			e.printStackTrace();
		}
		
		
	}

	
		
	/**
	 * Send mock data to the server from a csv file, the server will
	 * create a list of machines for simulation
	 */		
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

	
	
	/**
	 * Read the machine Id's that are available for the machines
	 * that are available in the server
	 */		
	private void getMachineIDs() {
		//This method server streams machine id's for multiple machines to this client.
		//We use these id's in subsequent query's to the service

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
	
	
	
	/**
	 * Read the volume of milk produced by a specified machine id
	 */		
	private void getMilkQuantity(int machineId, String from, String to) {
		//This method uses a unary blocking call to the server to obtain
		//the volume of milk produced by a given machine for a given time span
		JLabel resultLabel;
		MachineId mcId = MachineId.newBuilder().setId(machineId).build();
		MachineTimeSpan mc = MachineTimeSpan.newBuilder()
				.setMachineID(mcId)
				.setStartDate(from)
				.setEndDate(to)
				.build();
		try {
			MilkQuantity reply = blockingStub.withCallCredentials(new BearerToken(jwtSignedToken)).getMilkVolume(mc);
			System.out.println("Milk volume at machine id=" + machineId +" is " + reply.getVolumeLitres() + " litres");
			resultLabel = new JLabel("Milk volume at machine id=" + machineId +" is " + reply.getVolumeLitres() + " litres from " + from + " to " + to);			
		} catch (StatusRuntimeException e) {
			resultLabel = new JLabel(e.getStatus().getDescription());			
		}
		resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabel); //show the result in a pop up window
	}
	
	
	
	/**
	 * Read the reports for one or more  machine id's
	 */		
	private void getMilkReports(List<Integer> mids, String reportDate) {
		//This method uses bi-directonal streaming to get reports from the service for
		//a specified group of machine id's
		
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
			}

			// Mark the end of requests
			requestObserver.onCompleted();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Discover livestock activity service using jmDNS
	 */		
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
			e.printStackTrace();
		}
		
		
	}

	

	/**
	 * Send mock data to the server from a csv file, the server will
	 * create a list of animals for simulation
	 */		
	private void setAnimalDetails() {
		//This method client streams animal details for multiple animals to the server.
		//The service will use this data for simulating activities of many animals

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

	
	/**
	 * Read the animal Id's that are available for the animals
	 * that are available in the server
	 */		
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
	

	
	/**
	 * Get the current activity of the specified animal id
	 */		
	private void getAnimalActivity(int animalId) {
		AnimalId aId = AnimalId.newBuilder().setId(animalId).build();

		CurrentActivity reply = blockingStub2.getCurrentActivity(aId);
		System.out.println("Activity of "+ reply.getAnimal().getTypeOfAnimal() + " with id=" + animalId +" is " + reply.getActivity());
		JLabel resultLabelActivity = new JLabel("Activity of "+ reply.getAnimal().getTypeOfAnimal() + " with id=" + animalId +" is " + reply.getActivity());
		resultLabelActivity.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabelActivity);
	}


	/**
	 * Get a series of animal health reports for the specified
	 * group of animal id's
	 */		
	private void getAnimalVitals(List<Integer> mids) {
		//This method uses bi-directonal streaming to get health reports from the service for
		//a specified group of animal id's
				
		//Create a StreamObserver that receives the stream of health reports
		StreamObserver<AnimalHealthInfo> responseObserver = new StreamObserver<AnimalHealthInfo>() {

			@Override
			public void onNext(AnimalHealthInfo report) {
				//health report received, extract the data
				System.out.println("Receiving report for animal health: " + report.getAnimal().getAnimalID().getId() );
				System.out.println("Report date: " + report.getReportDate() );
				System.out.println("Type of anmimal: " + report.getAnimal().getTypeOfAnimal() );
				System.out.println("Animal date of birth: " + report.getAnimal().getDateOfBirth() );
				System.out.println("Next vaccine due: " + report.getAnimal().getDateNextVaccine() );
				System.out.println("Heartrate min BPM: " + report.getMinBPM() );
				System.out.println("Heartrate max BPM: " + report.getMaxBPM() );
				System.out.println("Heartrate avg BPM: " + report.getAvgBPM() );
				System.out.println("Overall health: " + report.getHealthIndicator() );
				System.out.println();
				//invokeLater allows updates to the UI from this thread without issues
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
	
	
	/**
	 * Begin getting a series of heart rates for the specified
	 * animal id
	 */		
	private void getLiveHeartRateBegin(int animalID) {
		//This method starts a server stream (with no particualar ending) of
		//animal heart rate values. The stream is cancelled elsewhere by the user.
		
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
			//using the cancellation object to start the stream so it can be 
			//cancelled later at an unspecified time
			withCancellation2 = Context.current().withCancellation();
			withCancellation2.run(() -> {
				asyncStub2.getLiveHeartRate(id, streamHeartRateRecvd);
				isHeartRateMonitorActive = true;
			});

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Discover user service using jmDNS
	 */		
	private void discoverUserService(String serviceType) {
		try {
			// Create a JmDNS instance
			jmDnsUser.setDiscoveryStatus("Discovering...");
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(serviceType, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					
					System.out.println("User Service resolved: " + event.getInfo());
					userServiceInfo = event.getInfo();
					int port = userServiceInfo.getPort();
					System.out.println("resolving " + serviceType + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + userServiceInfo.getNiceTextString());
					System.out.println("\t host: " + userServiceInfo.getHostAddresses()[0]);
					jmDnsUser.setDiscoveryStatus("User service resolved");
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("User Service removed: " + event.getInfo());
					jmDnsUser.setDiscoveryStatus("User service removed");
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("User Service added: " + event.getInfo());
					jmDnsUser.setDiscoveryStatus("User service added");
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			if(userServiceInfo==null)
				jmDnsUser.setDiscoveryStatus("User service not found");
			jmdns.close();
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	

	/**
	 * very basic login method of the user service
	 */		
	private void login(String user, String pass) {
		//simple unary call to demonstrate logging in

		LoginRequest loginRequest = LoginRequest.newBuilder()
				.setUsername(user)
				.setPassword(pass)
				.build();

		LoginResponse response = blockingStub3.login(loginRequest);
		System.out.println("User service responded: " + response);
		JLabel resultLabel = new JLabel(response.getResponseMessage());
		resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabel);
		if(response.getResponseCode() == 1) {
			jwtSignedToken = response.getJwtToken();
		}else {
			jwtSignedToken = "invalid user";
		}

	}

	
	/**
	 * very basic logout method of the user service
	 */		
	private void logout(String user) {
		//simple unary call to demonstrate logging out

		LogoutRequest logoutRequest = LogoutRequest.newBuilder()
				.setUsername(user)
				.build();

		LogoutResponse response = blockingStub3.logout(logoutRequest);
		System.out.println("User service responded: " + response);
		JLabel resultLabel = new JLabel(response.getResponseMessage());
		resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(frame,resultLabel);
		jwtSignedToken = "invalid user";

	}

	//auto generated code for ui<->data model bindings
	protected void initDataBindings() {
		BeanProperty<jmDNSInfo, String> jmDNSInfoBeanProperty = BeanProperty.create("discoveryStatus");
		BeanProperty<JLabel, String> jLabelBeanProperty = BeanProperty.create("text");
		AutoBinding<jmDNSInfo, String, JLabel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, jmDnsMilkParlour, jmDNSInfoBeanProperty, lblNewLabel_1, jLabelBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<MachineIdCollectionModel, List<MachineIdModel>> machineIdCollectionModelBeanProperty = BeanProperty.create("machines");
		JListBinding<MachineIdModel, MachineIdCollectionModel, JList> jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ, mc, machineIdCollectionModelBeanProperty, jlistAvailMachines);
		//
		BeanProperty<MachineIdModel, Integer> machineIdModelBeanProperty = BeanProperty.create("id");
		jListBinding.setDetailBinding(machineIdModelBeanProperty, "b123");
		//
		jListBinding.bind();
		//
		BeanProperty<MachineReportCollectionModel, List<MachineReportModel>> machineReportCollectionModelBeanProperty = BeanProperty.create("machines");
		JTableBinding<MachineReportModel, MachineReportCollectionModel, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, mcListReport, machineReportCollectionModelBeanProperty, jtableReports);
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
		JListBinding<AnimalIdModel, AnimalIdCollectionModel, JList> jListBinding_1 = SwingBindings.createJListBinding(UpdateStrategy.READ, ac, animalIdCollectionModelBeanProperty, jlistAnimalIds);
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
		JTableBinding<AnimalHealthReportModel, AnimalHealthReportCollectionModel, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, hc, animalHealthReportCollectionModelBeanProperty, jtableHealthReports);
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
		//
		AutoBinding<jmDNSInfo, String, JLabel, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ, jmDnsUser, jmDNSInfoBeanProperty, lblNewLabel_1_2, jLabelBeanProperty);
		autoBinding_5.bind();
	}
}
