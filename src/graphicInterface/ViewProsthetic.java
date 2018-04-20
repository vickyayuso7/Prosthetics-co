package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProsthetic extends JFrame {

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
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JFrame frame=new JFrame();
	
	public ViewProsthetic(WizardHandler myNameIsTim, int prsId) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.getContentPane().add(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblViewProsthetic = new JLabel("View Prosthetic");
		lblViewProsthetic.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblViewProsthetic.setForeground(Color.GREEN);
		panel.add(lblViewProsthetic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][grow]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "cell 0 0");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "flowx,cell 0 1");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 0 1");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, "cell 0 1");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, "cell 0 1");
		
		JLabel lblSize = new JLabel("Size:");
		panel_1.add(lblSize, "cell 0 1");
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4, "flowx,cell 0 2");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5, "cell 0 2");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6, "cell 0 2");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "cell 0 2");
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_8, "cell 0 2");
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_9, "cell 0 2");
		
		JLabel lblTypeOfAmputation = new JLabel("Type of Amputation:");
		panel_1.add(lblTypeOfAmputation, "cell 0 2");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_1.add(panel_2, "cell 0 4,grow");
		
		JLabel lblMaterialFeatures = new JLabel("Material & Features");
		lblMaterialFeatures.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblMaterialFeatures.setForeground(Color.GREEN);
		panel_2.add(lblMaterialFeatures);
		
		textField = new JTextField();
		panel_1.add(textField, "cell 0 1");
		textField.setColumns(10);
		textField.setText(""+myNameIsTim.getProstheticFull(prsId).getSize());
		
		JLabel lblWeight = new JLabel("Weight:");
		panel_1.add(lblWeight, "cell 0 1");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 0 1");
		textField_1.setColumns(10);
		textField_1.setText(""+myNameIsTim.getProstheticFull(prsId).getWeight());
		
		JLabel lblPrice = new JLabel("Price:");
		panel_1.add(lblPrice, "cell 0 1");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 0 1");
		textField_2.setColumns(10);
		textField_2.setText(""+myNameIsTim.getProstheticFull(prsId).getBestPrice());
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 0 2");
		textField_3.setColumns(10);
		textField_3.setText(""+myNameIsTim.getProstheticFull(prsId).getTypeOfFunctionality());
		
		JLabel lblTypeOfFunctionality = new JLabel("Type of Functionality:");
		panel_1.add(lblTypeOfFunctionality, "cell 0 2");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 0 2");
		textField_4.setColumns(10);
		textField_4.setText(""+myNameIsTim.getProstheticFull(prsId).getTypeOfAmputation());
		
		JLabel lblColor = new JLabel("Color:");
		panel_1.add(lblColor, "cell 0 1");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 0 1");
		textField_5.setColumns(10);
		textField_5.setText(""+myNameIsTim.getProstheticFull(prsId).getColor());
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "cell 0 5");
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_10, "flowx,cell 0 6");
		
		
		
		JLabel lblSize_1 = new JLabel("Style:\r\n");
		panel_1.add(lblSize_1, "cell 0 6");
		
		textField_6 = new JTextField();
		panel_1.add(textField_6, "cell 0 6");
		textField_6.setColumns(10);
		textField_6.setText(myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prsId)).getStyle());
		
		JLabel lblExtraPrice = new JLabel("Extra Price:");
		panel_1.add(lblExtraPrice, "cell 0 6");
		
		textField_7 = new JTextField();
		panel_1.add(textField_7, "cell 0 6");
		textField_7.setColumns(10);
		textField_7.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prsId)).getExtraPrice());
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced Movement:");
		panel_1.add(lblEnhancedMovement, "cell 0 6");
		
		textField_8 = new JTextField();
		panel_1.add(textField_8, "cell 0 6");
		textField_8.setColumns(10);
		textField_8.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prsId)).getSensibility());
		
		JLabel lblSensibility = new JLabel("Sensibility:");
		panel_1.add(lblSensibility, "cell 0 6");
		
		textField_9 = new JTextField();
		panel_1.add(textField_9, "cell 0 6");
		textField_9.setColumns(10);
		textField_9.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prsId)).getEnhancedMovement());
		
		JLabel lblFeatureId = new JLabel("Feature ID:");
		panel_1.add(lblFeatureId, "cell 0 6");
		
		textField_10 = new JTextField();
		panel_1.add(textField_10, "cell 0 6");
		textField_10.setColumns(10);
		textField_10.setText(""+myNameIsTim.getFeatureFull(myNameIsTim.getFeatureidThrouProstheticId(prsId)).getId());
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_11, "flowx,cell 0 7");
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_12, "cell 0 7");
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_13, "cell 0 7");
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_14, "cell 0 7");
		
		JLabel lblNewLabel = new JLabel("Type of Material:\r\n");
		panel_1.add(lblNewLabel, "cell 0 7");
		
		textField_11 = new JTextField();
		panel_1.add(textField_11, "cell 0 7");
		textField_11.setColumns(10);
		textField_11.setText(myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prsId)).getType());
		
		JLabel lblPrice_1 = new JLabel("Price:");
		panel_1.add(lblPrice_1, "cell 0 7");
		
		textField_12 = new JTextField();
		panel_1.add(textField_12, "cell 0 7");
		textField_12.setColumns(10);
		textField_12.setText(""+myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prsId)).getPriceModifier());
		
		JLabel lblProvider = new JLabel("Provider:");
		panel_1.add(lblProvider, "cell 0 7");
		
		textField_13 = new JTextField();
		panel_1.add(textField_13, "cell 0 7");
		textField_13.setColumns(10);
		textField_13.setText(myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prsId)).getProvider());
		
		JLabel lblMaterialId = new JLabel("Material ID:");
		panel_1.add(lblMaterialId, "cell 0 7");
		
		textField_14 = new JTextField();
		panel_1.add(textField_14, "cell 0 7");
		textField_14.setColumns(10);
		textField_14.setText(""+myNameIsTim.getMaterialFull(myNameIsTim.getMaterialidThrouProstheticId(prsId)).getId());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setForeground(Color.GREEN);
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOk.setBackground(Color.BLACK);
		panel_3.add(btnOk);
		frame.setVisible(true);
	}

}
