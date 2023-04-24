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
import ds.client.ModelsUI.MachineReportCollectionModel;
import ds.client.ModelsUI.MachineReportModel;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JOptionPane;

import java.util.List;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.ELProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel; 

public class ClientUI {

	private JFrame frame;
	private MachineIdCollectionModel mc;
	private MachineReportCollectionModel mcListReport;
	private MachineIdModel mm = new MachineIdModel();
	private MachineReportModel mReport = new MachineReportModel();
	private jmDNSInfo jmDnsMilkParlour;
	static ArrayList<Integer> machineIDs = new ArrayList<Integer>();
	private MilkingParlourServiceBlockingStub blockingStub;
	private MilkingParlourServiceStub asyncStub;
	private ServiceInfo milkParlourServiceInfo;
	private JLabel lblNewLabel_1;
	private JList list;
	private JDateChooser dateBeginMilkVolume;
	private JDateChooser dateEndMilkVolume;
	private JDateChooser dateOfReport;
	private JButton btnGetMilkVolume;
	private JButton btnGetMachineReports;
	private JTable table;


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
		mcListReport = new MachineReportCollectionModel();
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
		list.setBounds(49, 105, 137, 325);
		frame.getContentPane().add(list);
		
		dateBeginMilkVolume = new JDateChooser();
		dateBeginMilkVolume.setDateFormatString("dd/MM/yyyy");
		dateBeginMilkVolume.setEnabled(false);
		dateBeginMilkVolume.setBounds(238, 105, 157, 32);
		dateBeginMilkVolume.setDate(new Date());
		frame.getContentPane().add(dateBeginMilkVolume);
		
		btnGetMilkVolume = new JButton("Get Milk Volume");
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
		btnGetMilkVolume.setBounds(238, 212, 157, 32);
		frame.getContentPane().add(btnGetMilkVolume);
		
		dateEndMilkVolume = new JDateChooser();
		dateEndMilkVolume.setEnabled(false);
		dateEndMilkVolume.setDateFormatString("dd/MM/yyyy");
		dateEndMilkVolume.setBounds(238, 170, 157, 32);
		dateEndMilkVolume.setDate(new Date());
		frame.getContentPane().add(dateEndMilkVolume);
		
		dateOfReport = new JDateChooser();
		dateOfReport.setEnabled(false);
		dateOfReport.setDateFormatString("dd/MM/yyyy");
		dateOfReport.setBounds(238, 356, 157, 32);
		dateOfReport.setDate(new Date());
		frame.getContentPane().add(dateOfReport);
		
		btnGetMachineReports = new JButton("Get Reports");
		btnGetMachineReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
				String dateReport = dateFormat.format(dateOfReport.getDate());
				getMilkReports(list.getSelectedValuesList(), dateReport);
			}
		});
		btnGetMachineReports.setEnabled(false);
		btnGetMachineReports.setBounds(238, 398, 157, 32);
		frame.getContentPane().add(btnGetMachineReports);
		
		JLabel lblNewLabel_2 = new JLabel("Available Machines:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(51, 86, 155, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("From:");
		lblNewLabel_3.setBounds(238, 88, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("To:");
		lblNewLabel_4.setBounds(238, 157, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Report Date:");
		lblNewLabel_5.setBounds(238, 339, 93, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Available Reports:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(432, 85, 155, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 105, 561, 325);
		frame.getContentPane().add(scrollPane);
		
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
		jTableBinding.addColumnBinding(machineReportModelBeanProperty).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, String> machineReportModelBeanProperty_1 = BeanProperty.create("reportDate");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_2 = BeanProperty.create("heatedTemperature");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_2).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_3 = BeanProperty.create("heatedDuration");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_3).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_4 = BeanProperty.create("chilledTemperature");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_4).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, Float> machineReportModelBeanProperty_5 = BeanProperty.create("volumeLitres");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_5).setColumnName("New Column");
		//
		BeanProperty<MachineReportModel, String> machineReportModelBeanProperty_6 = BeanProperty.create("dateNextService");
		jTableBinding.addColumnBinding(machineReportModelBeanProperty_6).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
