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
	private JFrame frame= new JFrame();
	/**
	 * Create the frame.
	 */
	public NewFeatures() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][grow][grow][][][]", "[][][][][grow][][][][grow][][]"));
		
		JLabel lblFeatures = new JLabel("Features");
		lblFeatures.setBackground(Color.BLACK);
		lblFeatures.setForeground(Color.MAGENTA);
		lblFeatures.setFont(new Font("Calibri", Font.PLAIN, 11));
		contentPane.add(lblFeatures, "cell 1 0 7 1,alignx center");
		
		JLabel lblExtraPrice = new JLabel("Extra price");
		contentPane.add(lblExtraPrice, "cell 2 2");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 3 2,alignx left");
		textField.setColumns(10);
		
		JLabel lblStyle = new JLabel("Style");
		contentPane.add(lblStyle, "cell 4 2,alignx left");
		
		String op1[]={"","Yes","No"};
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 5 2,alignx left");
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "cell 0 4 8 1,growx,aligny center");
		
		JLabel lblSensibility = new JLabel("Sensibility");
		contentPane.add(lblSensibility, "cell 2 6,alignx center");
		
		JComboBox comboBox = new JComboBox(op1);
		contentPane.add(comboBox, "cell 3 6,alignx left");
		comboBox.getSelectedIndex();
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced movement");
		contentPane.add(lblEnhancedMovement, "cell 4 6,alignx left");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		JComboBox comboBox_1 = new JComboBox(op1);
		contentPane.add(comboBox_1, "cell 5 6,alignx left");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, "cell 0 8 8 1,growx,aligny center");
		contentPane.add(btnCancel, "cell 3 10,growx,aligny baseline");
		
		JButton btnOk = new JButton("OK");
		contentPane.add(btnOk, "cell 4 10,growx,aligny baseline");
		//txtEenhancedMovement.setText(String);
		//modificar texto, Mirar!!!
		//frame.add(contentPane);
		frame.setVisible(true);
	}

}
