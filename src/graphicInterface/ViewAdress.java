package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wizard_Handler.WizardHandler;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class ViewAdress extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JFrame frame =new JFrame();

	public ViewAdress(WizardHandler myNameIsTim, int id) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.add(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblViewAddress = new JLabel("View Address");
		lblViewAddress.setForeground(Color.GREEN);
		lblViewAddress.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel.add(lblViewAddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "cell 23 0");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "cell 23 1");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2, "cell 23 2");
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "cell 23 3");
		
		Component verticalStrut_12 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_12, "cell 23 4");
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_11, "cell 23 5");
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_10, "cell 23 6");
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_9, "cell 23 7");
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_8, "cell 23 8");
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_7, "cell 23 9");
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_6, "cell 23 10");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "cell 23 11");
		
		JLabel lblCountry = new JLabel("Country:\r\n");
		panel_1.add(lblCountry, "cell 22 12,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "flowx,cell 23 12,alignx left");
		textField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		panel_1.add(lblCity, "cell 23 12");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 23 12");
		textField_1.setColumns(10);
		
		JLabel lblTown = new JLabel("Town:");
		panel_1.add(lblTown, "cell 23 12");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 23 12");
		textField_2.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "cell 0 13");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 1 13");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, "cell 2 13");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, "cell 3 13");
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4, "cell 4 13");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5, "cell 5 13");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6, "cell 6 13");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "cell 7 13");
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_8, "cell 8 13");
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_9, "cell 9 13");
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_10, "cell 10 13");
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_11, "cell 11 13");
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_12, "cell 12 13");
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_13, "cell 13 13");
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_14, "cell 14 13");
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_15, "cell 15 13");
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_16, "cell 16 13");
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_17, "cell 17 13");
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_18, "cell 18 13");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "cell 23 13");
		
		JLabel lblStreet = new JLabel("Street:");
		panel_1.add(lblStreet, "cell 22 14,alignx trailing");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "flowx,cell 23 14,alignx left");
		textField_3.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		panel_1.add(lblNumber, "cell 23 14");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 23 14");
		textField_5.setColumns(10);
		
		JLabel lblPostcode = new JLabel("PostCode:");
		panel_1.add(lblPostcode, "cell 23 14");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 23 14");
		textField_4.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOk.setForeground(Color.GREEN);
		btnOk.setBackground(Color.BLACK);
		panel_2.add(btnOk);
		textField.setText(""+myNameIsTim.getAddressFull(id).getCountry());
		textField_1.setText(myNameIsTim.getAddressFull(id).getCity());
		textField_2.setText(myNameIsTim.getAddressFull(id).getTown());
		textField_3.setText(myNameIsTim.getAddressFull(id).getStreet());
		textField_4.setText(""+myNameIsTim.getAddressFull(id).getPostCode());
		textField_5.setText(""+myNameIsTim.getAddressFull(id).getNumber());
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField.setEditable(false);
		frame.setVisible(true);
	}

}
