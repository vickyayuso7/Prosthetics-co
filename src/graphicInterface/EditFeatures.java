package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Features;
import wizard_Handler.WizardHandler;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EditFeatures extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame= new JFrame();
	private JTextArea textArea;
	private JTextField textField_2;
	private JList<String> list;
	private Features editedFeature;
	private JComboBox comboBox;
	private JComboBox comboBox_1; 

	public EditFeatures(WizardHandler myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][grow][grow][][][]", "[][][][grow][][grow][][][][grow][][][][][][grow][][grow][][][grow][]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3, "cell 0 0 8 1,grow");

		JLabel lblFeatures = new JLabel("Features");
		panel_3.add(lblFeatures);
		lblFeatures.setBackground(Color.BLACK);
		lblFeatures.setForeground(Color.GREEN);
		lblFeatures.setFont(new Font("Consolas", Font.PLAIN, 11));
		try {
			if(myNameIsTim.getFeatureId()[1].equals("error")) {
				textArea.setText(textArea.getText()+"could not load list\n");
				list = new JList <String>();
			}
			else {
				list = new JList <String> (myNameIsTim.getFeatureId());
			}
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex()!=-1) {
					editedFeature = myNameIsTim.getFeatureFull(Integer.parseInt(myNameIsTim.getFeatureId()[list.getSelectedIndex()]));
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox.setEnabled(true);
					textField.setText(""+editedFeature.getExtraPrice());
					textField_1.setText(editedFeature.getStyle());
					if(editedFeature.getEnhancedMovement()==true) {
						comboBox.setSelectedIndex(1);
					}
					else {
						comboBox.setSelectedIndex(2);
					}
					if(editedFeature.getSensibility()==true) {
						comboBox_1.setSelectedIndex(1);
					}
					else {
						comboBox_1.setSelectedIndex(2);
					}
				}
			}
		});
		}
		catch(Exception ex) {
			System.out.println("Catched at 95 EditFeatures");
			ex.printStackTrace();
		}
		
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setBackground(Color.LIGHT_GRAY);
		list.setForeground(Color.BLACK);
		contentPane.add(list, "cell 0 1 8 3,grow");
		
		list.setAutoscrolls(true);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblSearch = new JLabel("Search:");
		contentPane.add(lblSearch, "cell 2 4,alignx center");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 3 4,alignx left");
		textField_2.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut, "cell 4 4");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		contentPane.add(panel_4, "cell 0 5 8 1,grow");

		JLabel lblExtraPrice = new JLabel("Extra price");
		contentPane.add(lblExtraPrice, "cell 2 6,alignx center");

		textField = new JTextField();
		textField.setEnabled(false);
		contentPane.add(textField, "cell 3 6,alignx left");
		textField.setColumns(10);

		JLabel lblStyle = new JLabel("Style");
		contentPane.add(lblStyle, "cell 4 6,alignx left");

		String op1[]={"Select option","Yes","No"};

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		contentPane.add(textField_1, "cell 5 6,alignx left");
		textField_1.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_1, "cell 4 8");

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "cell 0 9 8 1,growx,aligny center");

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_2, "cell 4 10");

		JLabel lblSensibility = new JLabel("Sensibility");
		contentPane.add(lblSensibility, "cell 2 12,alignx center");

		comboBox = new JComboBox(op1);
		comboBox.setEnabled(false);
		contentPane.add(comboBox, "cell 3 12,alignx left");
		comboBox.getSelectedIndex();

		JLabel lblEnhancedMovement = new JLabel("Enhanced movement");
		contentPane.add(lblEnhancedMovement, "cell 4 12,alignx left");

		comboBox_1 = new JComboBox(op1);
		comboBox_1.setEnabled(false);
		contentPane.add(comboBox_1, "cell 5 12,alignx left");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_3, "cell 4 13");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, "cell 0 15 8 1,growx,aligny center");

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_4, "cell 4 16");

		textArea= new JTextArea();
		textArea.setRows(5);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setForeground(Color.GREEN);
		textArea.setText("Warnings / comments / errors:\n");
		contentPane.add(textArea, "cell 0 17 8 1,grow");

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_5, "cell 4 19");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, "cell 0 21 8 1,grow");

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
							//System.out.println(style);
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
							int id=Integer.parseInt(list.getSelectedValue());
							Features feat =new Features(id, price, style, sensibility, enhanced);
							result= myNameIsTim.editFeature(feat);
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