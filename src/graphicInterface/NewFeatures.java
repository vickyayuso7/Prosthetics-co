package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewFeatures extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFeatures frame = new NewFeatures();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewFeatures() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][][][][]", "[][][][][][][][][]"));
		
		JLabel lblFeatures = new JLabel("Features");
		lblFeatures.setForeground(Color.MAGENTA);
		lblFeatures.setFont(new Font("Calibri", Font.PLAIN, 11));
		contentPane.add(lblFeatures, "cell 2 0");
		
		JLabel lblExtraPrice = new JLabel("Extra price");
		contentPane.add(lblExtraPrice, "cell 1 2");
		
		JLabel lblStyle = new JLabel("Style");
		contentPane.add(lblStyle, "cell 3 2");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 3,alignx left");
		textField.setColumns(10);
		
		String op1[]={"","Yes","No"};
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 3 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblSensibility = new JLabel("Sensibility");
		contentPane.add(lblSensibility, "cell 1 5,alignx trailing");
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced movement");
		contentPane.add(lblEnhancedMovement, "cell 3 5");
		
		JComboBox comboBox = new JComboBox(op1);
		contentPane.add(comboBox, "cell 1 6,growx");
		comboBox.getSelectedIndex();
		
		JComboBox comboBox_1 = new JComboBox(op1);
		contentPane.add(comboBox_1, "cell 3 6,growx");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.dispose()
			}
		});
		contentPane.add(btnCancel, "cell 2 8,growx");
		
		JButton btnOk = new JButton("OK");
		contentPane.add(btnOk, "cell 3 8,growx");
		//txtEenhancedMovement.setText(String);
		//modificar texto, Mirar!!!
		
	}

}
