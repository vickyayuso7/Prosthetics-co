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
import pojos.db.prosthetics.Features;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

public class ViewFeatures extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public ViewFeatures(WizardHandler myNameIsTim, int id) {
		String style = myNameIsTim.getFeatureFull(id).getStyle();
		float extraPrice =myNameIsTim.getFeatureFull(id).getExtraPrice();
		boolean sensibility =myNameIsTim.getFeatureFull(id).getSensibility();
		boolean enhancedMovement =myNameIsTim.getFeatureFull(id).getEnhancedMovement();
		Features feat=new Features(id, extraPrice, style, sensibility, enhancedMovement);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblViewFeature = new JLabel("View  Feature");
		lblViewFeature.setBackground(Color.BLACK);
		lblViewFeature.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblViewFeature.setForeground(Color.GREEN);
		panel.add(lblViewFeature);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][]"));
		
		JLabel lblId = new JLabel("Id:");
		panel_1.add(lblId, "cell 2 1,alignx trailing");
		
		textField = new JTextField();
		textField.setText(""+feat.getId());
		textField.setEditable(false);
		panel_1.add(textField, "flowx,cell 3 1,alignx left");
		textField.setColumns(10);
		
		JLabel lblStyle = new JLabel("Style:");
		panel_1.add(lblStyle, "cell 2 3,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setText(feat.getStyle());
		textField_1.setEditable(false);
		panel_1.add(textField_1, "flowx,cell 3 3,alignx left");
		textField_1.setColumns(10);
		
		JLabel lblBestPrice = new JLabel("Best Price:");
		panel_1.add(lblBestPrice, "cell 2 5,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(""+feat.getExtraPrice());
		panel_1.add(textField_2, "cell 3 5,alignx left");
		textField_2.setColumns(10);
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced Movement");
		panel_1.add(lblEnhancedMovement, "cell 3 1");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(""+feat.getEnhancedMovement());
		panel_1.add(textField_3, "cell 3 1");
		textField_3.setColumns(10);
		
		JLabel lblSensibility = new JLabel("Sensibility:");
		panel_1.add(lblSensibility, "cell 3 3");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "cell 3 3");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 3 3");
		
		textField_4 = new JTextField();
		textField_4.setText(""+feat.getSensibility());
		textField_4.setEditable(false);
		panel_1.add(textField_4, "cell 3 3");
		textField_4.setColumns(10);
	}

}
