package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Features;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class NewFeatures extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame= new JFrame();
	/**
	 * Create the frame.
	 */
	public NewFeatures(WizardHandler myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][grow][grow][][][]", "[][][grow][][][][][][grow][][][][][][grow][][grow][][][grow][]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3, "cell 0 0 8 1,grow");
		
		JLabel lblFeatures = new JLabel("Features");
		panel_3.add(lblFeatures);
		lblFeatures.setBackground(Color.BLACK);
		lblFeatures.setForeground(Color.GREEN);
		lblFeatures.setFont(new Font("Consolas", Font.PLAIN, 11));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut, "cell 4 3");
		
		JLabel lblExtraPrice = new JLabel("Extra price");
		contentPane.add(lblExtraPrice, "cell 2 5");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 3 5,alignx left");
		textField.setColumns(10);
		
		JLabel lblStyle = new JLabel("Style");
		contentPane.add(lblStyle, "cell 4 5,alignx left");
		
		String op1[]={"","Yes","No"};
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 5 5,alignx left");
		textField_1.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_1, "cell 4 7");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "cell 0 8 8 1,growx,aligny center");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_2, "cell 4 9");
		
		JLabel lblSensibility = new JLabel("Sensibility");
		contentPane.add(lblSensibility, "cell 2 11,alignx center");
		
		JComboBox comboBox = new JComboBox(op1);
		contentPane.add(comboBox, "cell 3 11,alignx left");
		comboBox.getSelectedIndex();
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced movement");
		contentPane.add(lblEnhancedMovement, "cell 4 11,alignx left");
		
		JComboBox comboBox_1 = new JComboBox(op1);
		contentPane.add(comboBox_1, "cell 5 11,alignx left");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_3, "cell 4 12");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, "cell 0 14 8 1,growx,aligny center");
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_4, "cell 4 15");
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setForeground(Color.GREEN);
		textArea.setText("Warnings / comments / errors:\n");
		contentPane.add(textArea, "cell 0 16 8 1,grow");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_5, "cell 4 18");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, "cell 0 20 8 1,grow");
		
		JButton btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setBorderPainted(false);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBorderPainted(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please, all fields must be filled in before proceeding.");
					String missingFields="";
					if(textField.getText().equals("")) {
						missingFields="extra price, ";
					}
					if(textField_1.equals("")) {
						missingFields=missingFields+"Style";
					}
					textArea.setText(textArea.getText()+"Missing"+missingFields+"\n");
				}
				else {
					if(comboBox.getSelectedIndex()==0 || comboBox_1.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "Please select an option in the respective ComboBoxes");
					}
					else{
						String result="weird stuff happened";
						try {
							result="price must be a number";
							float price = Float.parseFloat(textField.getText());
							String style =textField_1.getText();
							boolean enhanced;
							boolean sensibility;
							if(comboBox.getSelectedIndex()==1) {
								enhanced=true;
							}
							else {
								enhanced=false;
							}
							if(comboBox_1.getSelectedIndex()==1) {
								sensibility= true;
							}
							else {
								sensibility =false;
							}
							Features feat =new Features(price, style, sensibility, enhanced);
							result= myNameIsTim.newFeature(feat);
							frame.dispose();
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Something Went Terribly Wrong!\n details int the error log");
							textArea.setText(textArea.getText()+result+"\n");
						}
						
					}
				}
			}
		});
		panel_2.add(btnOk);
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.GREEN);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		//txtEenhancedMovement.setText(String);
		//modificar texto, Mirar!!!
		frame.add(contentPane);
		frame.setVisible(true);
	}

}
