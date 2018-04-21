package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JFrame frame =new JFrame();

	public ViewPayment(WizardHandler myNameIsTim, int id,int prostheticId) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//frame.add(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblViewPayment = new JLabel("View Payment");
		lblViewPayment.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblViewPayment.setForeground(Color.GREEN);
		panel.add(lblViewPayment);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		JButton btnOk =new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.GREEN);
		btnOk.setFont(new Font("Consolas",Font.PLAIN, 11));
		panel_2.add(btnOk);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][][grow]", "[][][][][][][][][][][]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "cell 9 0");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2, "cell 9 1");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "cell 9 2");
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "cell 9 3");
		
		JLabel lblPaymentId = new JLabel("Payment Id:");
		panel_1.add(lblPaymentId, "cell 8 4,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "flowx,cell 9 4,alignx left");
		textField.setColumns(10);
		
		JLabel lblMehtod = new JLabel("Mehtod:");
		panel_1.add(lblMehtod, "cell 9 4");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 9 4");
		textField_1.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline:");
		panel_1.add(lblDeadline, "cell 9 4");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 9 4");
		textField_3.setColumns(3);
		
		JLabel label = new JLabel("/");
		panel_1.add(label, "cell 9 4");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 9 4");
		textField_4.setColumns(3);
		
		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1, "cell 9 4");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 9 4");
		textField_5.setColumns(3);
		
		JLabel lblIban = new JLabel("IBAN:");
		panel_1.add(lblIban, "cell 9 4,alignx trailing");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 9 4,alignx left");
		textField_2.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "cell 9 5");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "cell 9 6");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "cell 0 7");
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_8, "cell 1 7");
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_9, "cell 2 7");
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_10, "cell 3 7");
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_11, "cell 4 7");
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_12, "cell 5 7");
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_13, "cell 6 7");
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_14, "cell 7 7");
		
		JLabel lblMaterialId = new JLabel("Material Id:");
		panel_1.add(lblMaterialId, "cell 8 7,alignx trailing");
		
		textField_6 = new JTextField();
		panel_1.add(textField_6, "flowx,cell 9 7,alignx left");
		textField_6.setColumns(10);
		
		JLabel lblMaterialPrice = new JLabel("Material Price:");
		panel_1.add(lblMaterialPrice, "cell 9 7");
		
		textField_7 = new JTextField();
		panel_1.add(textField_7, "cell 9 7");
		textField_7.setColumns(10);
		
		JLabel lblFeatureId = new JLabel("Feature Id:");
		panel_1.add(lblFeatureId, "cell 9 7");
		
		textField_8 = new JTextField();
		panel_1.add(textField_8, "cell 9 7");
		textField_8.setColumns(10);
		
		JLabel lblFeaturePrice = new JLabel("Feature Price:");
		panel_1.add(lblFeaturePrice, "cell 9 7");
		
		textField_9 = new JTextField();
		panel_1.add(textField_9, "cell 9 7");
		textField_9.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_6, "cell 9 8");
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_7, "cell 9 9");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "flowx,cell 9 10");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 9 10");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, "cell 9 10");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, "cell 9 10");
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4, "cell 9 10");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5, "cell 9 10");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6, "cell 9 10");
		
		JLabel lblTotal = new JLabel("Total:");
		panel_1.add(lblTotal, "cell 9 10");
		
		textField_10 = new JTextField();
		panel_1.add(textField_10, "cell 9 10");
		textField_10.setColumns(10);
		textField.setText(""+id);
		textField_1.setText(myNameIsTim.getPaymentFull(id).getMethod());
		textField_2.setText(""+myNameIsTim.getPaymentFull(id).getIban());
		textField_3.setText(""+myNameIsTim.getPaymentFull(id).getDeadline().toLocalDate().getDayOfMonth());
		textField_4.setText(""+myNameIsTim.getPaymentFull(id).getDeadline().toLocalDate().getMonthValue());
		textField_5.setText(""+myNameIsTim.getPaymentFull(id).getDeadline().toLocalDate().getYear());
		textField_6.setText(""+myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prostheticId)).getId());
		textField_7.setText(""+myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prostheticId)).getPriceModifier());
		textField_8.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prostheticId)).getId());
		textField_9.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prostheticId)).getExtraPrice());
		textField_10.setText(""+myNameIsTim.getFullPrice(prostheticId));
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField_6.setEditable(false);
		textField_7.setEditable(false);
		textField_8.setEditable(false);
		textField_9.setEditable(false);
		textField_10.setEditable(false);
		
		
		
		frame.setVisible(true);
	}

}
