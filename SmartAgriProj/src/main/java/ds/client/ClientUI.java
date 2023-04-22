package ds.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ClientUI {

	private JFrame frame;
	private MachineInfo mc;
	private JTextField textField;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 389, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(124, 101, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		mc = new MachineInfo();
		mc.setId(5);
		initDataBindings();
	}
	protected void initDataBindings() {
		BeanProperty<MachineInfo, Integer> machineInfoBeanProperty = BeanProperty.create("id");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<MachineInfo, Integer, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, mc, machineInfoBeanProperty, textField, jTextFieldBeanProperty);
		autoBinding.bind();
	}
}
