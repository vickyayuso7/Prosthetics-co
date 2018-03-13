package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import wizard_Handler.WizardHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.awt.event.ActionEvent;
import pojos.db.prosthetics.*;
public class CreateANDModify extends JFrame {
	private JFrame frame=new JFrame();
	private int option1;
	private int option2;
	private String gender[]= {"Unspecified","Male","Female"};;
	private Client cln =new Client();
	private Prosthetics prs =new Prosthetics();
	private Address adr= new Address();
	private Payment pmn= new Payment();
	private JComboBox comboBox_1 ;
	private int fuckedup;
	private JTextArea textArea;
	
	public CreateANDModify(WizardHandler myNameIsTim) {
		option1=-1;
		option2=-1;
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.add(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.SOUTH);
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*how to check if the combobox is a valid option and actually contains something valid.*/
				fuckedup=0;
				if(option1!=-1 && option2!=-1 && textField.getText()!=""&& textField_1.getText()!=""&& textField_2.getText()!=""&& textField_3.getText()!=""
						&& textField_4.getText()!=""&& textField_5.getText()!=""&& textField_7.getText()!=""&& textField_8.getText()!=""&& textField_9.getText()!=""
						&& textField_10.getText()!=""&& textField_11.getText()!=""&& textField_12.getText()!=""&& textField_13.getText()!=""&& textField_14.getText()!=""
						&& textField_6.getText()!=""&& textField_15.getText()!=""&& textField_16.getText()!=""&& textField_17.getText()!=""&& textField_18.getText()!=""
						&& textField_19.getText()!=""&& textField_20.getText()!="") {
					
					adr.setCountry(textField_8.getText());
					try {
						adr.setNumber(Integer.parseInt(textField_13.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Number must be an actual number,");
					}
					try {
						adr.setPostCode(Integer.parseInt(textField_11.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Postcode must be an actual number,");
					}
					adr.setStreet(textField_12.getText());
					adr.setTown(textField_10.getText());
					adr.setCity(textField_9.getText());
					try {
					String str= textField_14.getText()+"-"+textField_6+"-"+textField_1.getText();
					DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dt = LocalDate.parse(str,formatter);
					cln.setDate_of_Birth(Date.valueOf(dt));
					cln.setAddress(adr);
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Address is messed up, probably because there are several empty fields,");
					}
					if(option1!=-1 && option1!=0) {
						cln.setGender(gender[option1]);
					}
					else {
						JOptionPane.showMessageDialog(null, "No, no unspecified gender allowed, we are a filthy bunch of cis white males that only accept 2 genders in their lives.");
						fuckedup=fuckedup+1;
					}
					cln.setName(textField.getText());
					try {
						String str= textField_17.getText()+"-"+textField_18+"-"+textField_19.getText();
						DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate dt = LocalDate.parse(str,formatter);
						pmn.setDeadline((Date.valueOf(dt)));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" The Deadline is messed up, probably because there are some empty fileds,");
					}
					try {
						pmn.setIban(Integer.parseInt(textField_16.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Iban must be an actual number,");
					}
					if(textField_15.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "fill in the rquired field:(Method)");
					}
					else {
						pmn.setMethod(textField_15.getText());
					}
					try {
						prs.setBest_price(Float.parseFloat(textField_20.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Price must be an actual number,");
					}
					//prs.setColor(myNameIsTim.getColor(comboBox_1.getSelectedIndex()));
					try {
						prs.setSize(Float.parseFloat(textField_4.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Size must be an actual number,");
					}
					if(textField_4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOA)");
					}
					else {
						prs.setType_of_amputation(textField_7.getText());
					}
					if(textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOF)");
					}
					else {
						prs.setType_of_functionality(textField_2.getText());
					}
					try {
						prs.setWeight(Float.parseFloat(textField_5.getText()));
					}
					catch(Exception ex) {
						fuckedup=fuckedup+1;
						textArea.setText(textArea.getText()+" Wheight must be an actual number");
					}
					if(fuckedup!=0) {
						JOptionPane.showMessageDialog(null, "Ok, there are "+fuckedup+" things wrong with this entry fix them before continuing\nMay I suggest checking the Warnings and Failures tab?");
						textArea.setText(textArea.getText()+"\n");
					}
					else {
						//myNameIsTim.newClient(cln,adr,pmn,prs);
						frame.dispose();
					}
					
				}
				
			}
		});
		btnOk.setForeground(Color.GREEN);
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOk.setBackground(Color.BLACK);
		btnOk.setBorderPainted(false);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setBorderPainted(false);
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JTextArea txtrNewClientInsertion = new JTextArea();
		txtrNewClientInsertion.setForeground(Color.GREEN);
		txtrNewClientInsertion.setBackground(Color.BLACK);
		txtrNewClientInsertion.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtrNewClientInsertion.setText("New Client Insertion");
		panel_1.add(txtrNewClientInsertion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][grow][][][][][][grow][][][grow][][][][][][][][]"));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4, "flowx,cell 19 0");
		
		JLabel lblName = new JLabel("Name:");
		panel_2.add(lblName, "flowx,cell 19 1,alignx left");
		
		textField = new JTextField();
		panel_2.add(textField, "cell 19 1,alignx right");
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Date Of Birth:");
		panel_2.add(lblAge, "cell 19 1,alignx center");
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 19 1,alignx center");
		textField_1.setColumns(3);
		
		JLabel label = new JLabel("/");
		panel_2.add(label, "cell 19 1");
		
		textField_6 = new JTextField();
		panel_2.add(textField_6, "cell 19 1");
		textField_6.setColumns(3);
		
		JLabel label_1 = new JLabel("/");
		panel_2.add(label_1, "cell 19 1");
		
		textField_14 = new JTextField();
		panel_2.add(textField_14, "cell 19 1");
		textField_14.setColumns(3);
		
		JLabel lblGender = new JLabel("Gender:");
		panel_2.add(lblGender, "cell 19 1,alignx center");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut, "flowx,cell 19 2");
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue, "flowx,cell 19 3");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1, "flowx,cell 19 4");
		
		JLabel lblMeasures = new JLabel("Measures:");
		panel_2.add(lblMeasures, "flowx,cell 19 5,alignx left");
		
		textField_3 = new JTextField();
		panel_2.add(textField_3, "cell 19 5,alignx right");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Size:");
		panel_2.add(lblNewLabel, "cell 19 5");
		
		textField_4 = new JTextField();
		panel_2.add(textField_4, "cell 19 5");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Weight:");
		panel_2.add(lblNewLabel_1, "cell 19 5");
		
		textField_5 = new JTextField();
		panel_2.add(textField_5, "cell 19 5");
		textField_5.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_5, "flowx,cell 19 6");
		
		JLabel lblNewLabel_2 = new JLabel("Color:");
		panel_2.add(lblNewLabel_2, "flowx,cell 19 7");
		
		JComboBox comboBox = new JComboBox(gender);
		panel_2.add(comboBox, "cell 19 1,alignx trailing");
		option1=comboBox.getSelectedIndex();
		
		//String colours[] = WizardHandler.getColours();
		String test[] = {"Red","green","blue"};
		comboBox_1 = new JComboBox(test);
		panel_2.add(comboBox_1, "cell 19 7");
		option2=comboBox_1.getSelectedIndex();
		//insrtintodatabase(test[option2])
		
		JLabel lblTypeOfFunctionality = new JLabel("Type of functionality:");
		panel_2.add(lblTypeOfFunctionality, "cell 19 7,alignx left");
		
		textField_2 = new JTextField();
		panel_2.add(textField_2, "cell 19 7");
		textField_2.setColumns(10);
		
		JLabel lblTypeOfAmputation = new JLabel("Type of Amputation");
		panel_2.add(lblTypeOfAmputation, "cell 19 7");
		
		textField_7 = new JTextField();
		panel_2.add(textField_7, "cell 19 7");
		textField_7.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.GREEN);
		panel_3.setBackground(Color.BLACK);
		panel_2.add(panel_3, "cell 0 3 20 1,growx");
		
		JLabel lblProsthetics = new JLabel("Prosthetic\r\n");
		lblProsthetics.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblProsthetics.setForeground(Color.GREEN);
		panel_3.add(lblProsthetics);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_2, "flowx,cell 19 8");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setForeground(Color.GREEN);
		panel_2.add(panel_4, "cell 0 9 20 1,growx,aligny top");
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtAddress.setBackground(Color.BLACK);
		txtAddress.setForeground(Color.GREEN);
		txtAddress.setText("Address");
		panel_4.add(txtAddress);
		txtAddress.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3, "flowx,cell 19 10");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut, "cell 2 11");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_1, "cell 3 11");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_2, "cell 4 11");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_3, "cell 6 11");
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_4, "cell 7 11");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_5, "cell 8 11");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_6, "cell 9 11");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_7, "cell 10 11");
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_8, "cell 11 11");
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_9, "cell 12 11");
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_10, "cell 13 11");
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_11, "cell 14 11");
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_12, "cell 15 11");
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_13, "cell 16 11");
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_14, "cell 17 11");
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_15, "cell 18 11");
		
		JLabel lblCity = new JLabel("Country:");
		panel_2.add(lblCity, "flowx,cell 19 11");
		
		textField_8 = new JTextField();
		panel_2.add(textField_8, "cell 19 11,aligny top");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City:");
		panel_2.add(lblNewLabel_3, "cell 19 11");
		
		textField_9 = new JTextField();
		panel_2.add(textField_9, "cell 19 11");
		textField_9.setColumns(10);
		
		JLabel lblTown = new JLabel("Town:");
		panel_2.add(lblTown, "cell 19 11");
		
		textField_10 = new JTextField();
		panel_2.add(textField_10, "cell 19 11");
		textField_10.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_6, "flowx,cell 19 12");
		
		JLabel lblPostcode = new JLabel("PostCode:");
		panel_2.add(lblPostcode, "flowx,cell 19 13,aligny top");
		
		textField_11 = new JTextField();
		panel_2.add(textField_11, "cell 19 13");
		textField_11.setColumns(10);
		
		JLabel lblNumber = new JLabel("Street:");
		panel_2.add(lblNumber, "cell 19 13");
		
		textField_12 = new JTextField();
		panel_2.add(textField_12, "cell 19 13");
		textField_12.setColumns(10);
		
		JLabel lblNumber_1 = new JLabel("Number:");
		panel_2.add(lblNumber_1, "cell 19 13");
		
		textField_13 = new JTextField();
		panel_2.add(textField_13, "cell 19 13");
		textField_13.setColumns(10);
		
		Component verticalStrut_13 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_13, "cell 19 14");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_2.add(panel_5, "cell 0 15 20 1,grow");
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblPayment.setBackground(Color.BLACK);
		lblPayment.setForeground(Color.GREEN);
		panel_5.add(lblPayment);
		
		JLabel lblNewLabel_4 = new JLabel("Method:");
		panel_2.add(lblNewLabel_4, "flowx,cell 19 22");
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_7, "cell 19 23");
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setRows(5);
		textArea.setText("Warnings / Comments / Errors:\n");
		panel_2.add(textArea, "cell 0 24 20 1,grow");
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_9, "cell 19 25");
		
		textField_15 = new JTextField();
		panel_2.add(textField_15, "cell 19 22");
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ISBN:");
		panel_2.add(lblNewLabel_5, "cell 19 22");
		
		textField_16 = new JTextField();
		panel_2.add(textField_16, "cell 19 22");
		textField_16.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline:");
		panel_2.add(lblDeadline, "cell 19 22");
		
		textField_17 = new JTextField();
		panel_2.add(textField_17, "cell 19 22");
		textField_17.setColumns(3);
		
		JLabel label_2 = new JLabel("/");
		panel_2.add(label_2, "cell 19 22");
		
		textField_18 = new JTextField();
		panel_2.add(textField_18, "cell 19 22");
		textField_18.setColumns(3);
		
		JLabel label_3 = new JLabel("/");
		panel_2.add(label_3, "cell 19 22");
		
		textField_19 = new JTextField();
		panel_2.add(textField_19, "cell 19 22");
		textField_19.setColumns(3);
		
		JLabel lblPrice = new JLabel("Price:");
		panel_2.add(lblPrice, "cell 19 5");
		
		textField_20 = new JTextField();
		panel_2.add(textField_20, "cell 19 5");
		textField_20.setColumns(10);
		panel.setVisible(true);
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField txtAddress;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_6;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;

	public void fullClient() {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setSize(frame.getMaximumSize());
		/*frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
	}

}
