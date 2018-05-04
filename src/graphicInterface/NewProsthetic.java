package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Features;
import pojos.db.prosthetics.Material;
import pojos.db.prosthetics.Payment;
import pojos.db.prosthetics.Prosthetics;
import wizard_Handler.WizardHandler;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class NewProsthetic extends JFrame {

	private JPanel contentPane;
	private JFrame frame =new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel txtBankAccount;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextArea txtrWarningsComments;
	private int clientID;

	public NewProsthetic(WizardHandler myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewProstheticInsertion = new JLabel("New Prosthetic Insertion");
		lblNewProstheticInsertion.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewProstheticInsertion.setForeground(Color.GREEN);
		panel.add(lblNewProstheticInsertion);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][][][][][][]", "[][grow][][grow][][][][][][][][][grow][grow][]"));
		
		JLabel lblSelectAClient = new JLabel("Select A Client");
		panel_1.add(lblSelectAClient, "cell 1 0");
		final String[] clientIds = myNameIsTim.getClientId();
		final String[]names=new String[clientIds.length];
		for (int i = 0; i < clientIds.length; i++) {
			names[i]=clientIds[i]+":   "+myNameIsTim.getClientFull(Integer.parseInt(clientIds[i])).getName();
		}
		JList list = new JList(names);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int Index;
				char charcmp='D';
				char[]name=((String) list.getSelectedValue()).toCharArray();
				String id="";
				for(int i=0;	charcmp!=':';	i++) {
					charcmp=name[i];
					if(charcmp!=':') {
						id=id+charcmp;
					}
				}
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_8.setEditable(true);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
				textField_11.setEditable(true);
				textField_12.setEditable(true);
				comboBox.setEnabled(true);
				comboBox_1.setEnabled(true);
				comboBox.setVisible(false);
				comboBox.setVisible(true);
				clientID=Integer.parseInt(id);
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setBackground(Color.GRAY);
		panel_1.add(list, "cell 0 1 7 3,grow");
		
		JLabel Search = new JLabel("Search:");
		panel_1.add(Search, "flowx,cell 0 4");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 0 4");
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")) {
					txtrWarningsComments.setText(txtrWarningsComments.getText()+"Cmon Mang gibe me somethin to work with...\n");
				}
				else {
					boolean found =false;
					String id="";
					int counter=0;
					boolean foundEscapeChar=false;
					for (int i = 0; i < names.length; i++) {
						id="";
						foundEscapeChar=false;
						counter=0;
						list.setSelectedIndex(i);
						char[]name=((String) list.getSelectedValue()).toCharArray();
						for (int j = 0; j < name.length-1; j++) {
							if(name[j]==':') {
								foundEscapeChar=true;
							}
							if(foundEscapeChar && name[j]==' ') {
								counter=counter+1;
							}
							if(counter>=3) {
								id=id+name[j+1];
							}
						}
						if(textField.getText().equals(id)) {
							list.setSelectedIndex(i);
							found =true;
							break;
						}
					}
					if(found==false) {
						txtrWarningsComments.setText(txtrWarningsComments.getText()+"Error 404, Client not found\n");
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
						textField_11.setEditable(false);
						textField_12.setEditable(false);
						comboBox.setEnabled(false);
					}
					else {
						textField_1.setEditable(true);
						textField_2.setEditable(true);
						textField_3.setEditable(true);
						textField_4.setEditable(true);
						textField_5.setEditable(true);
						textField_6.setEditable(true);
						textField_7.setEditable(true);
						textField_8.setEditable(true);
						textField_9.setEditable(true);
						textField_10.setEditable(true);
						textField_11.setEditable(true);
						textField_12.setEditable(true);
						comboBox.setEnabled(true);
						
					}
				}
				
			}
		});
		btnGo.setForeground(Color.GREEN);
		btnGo.setBackground(Color.BLACK);
		panel_1.add(btnGo, "cell 0 4");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_1.add(panel_2, "cell 0 5 7 1,grow");
		
		JLabel lblProsthetic = new JLabel("Prosthetic");
		lblProsthetic.setForeground(Color.GREEN);
		lblProsthetic.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel_2.add(lblProsthetic);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "flowx,cell 0 6");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 0 6");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, "cell 0 6");
		
		JLabel lblMeasures = new JLabel("Measures:");
		panel_1.add(lblMeasures, "cell 0 6");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_1.add(textField_2, "cell 0 6");
		textField_2.setColumns(10);
		
		JLabel lblSize = new JLabel("Size");
		panel_1.add(lblSize, "cell 0 6");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_1.add(textField_1, "cell 0 6");
		textField_1.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		panel_1.add(lblWeight, "cell 0 6");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_1.add(textField_3, "cell 0 6");
		textField_3.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		panel_1.add(lblPrice, "cell 0 6");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_1.add(textField_4, "cell 0 6");
		textField_4.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, "flowx,cell 0 7");
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4, "cell 0 7");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5, "cell 0 7");
		
		JLabel lblColor = new JLabel("Color:");
		panel_1.add(lblColor, "cell 0 7");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		panel_1.add(textField_5, "cell 0 7");
		textField_5.setColumns(10);
		
		JLabel lblTypeOfFunctionality = new JLabel("Type of Functionality:");
		panel_1.add(lblTypeOfFunctionality, "cell 0 7");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		panel_1.add(textField_6, "cell 0 7");
		textField_6.setColumns(10);
		
		JLabel lblTypeOfAmputation = new JLabel("Type of Amputation:");
		panel_1.add(lblTypeOfAmputation, "cell 0 7");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		panel_1.add(textField_7, "cell 0 7");
		textField_7.setColumns(10);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6, "flowx,cell 0 8");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_1.add(panel_3, "cell 0 9 7 1,grow");
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblPayment.setForeground(Color.GREEN);
		panel_3.add(lblPayment);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "cell 0 8");
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_8, "cell 0 8");
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_9, "cell 0 8");
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_10, "cell 0 8");
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_11, "cell 0 8");
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_12, "cell 0 8");
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_13, "cell 0 8");
		
		JLabel lblMaterial = new JLabel("Material:");
		panel_1.add(lblMaterial, "cell 0 8");
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		panel_1.add(comboBox, "cell 0 8");
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_14, "flowx,cell 0 10");
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_15, "cell 0 10");
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_16, "cell 0 10");
		
		JLabel lblNewLabel = new JLabel("Method");
		panel_1.add(lblNewLabel, "cell 0 10");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		panel_1.add(textField_8, "cell 0 10");
		textField_8.setColumns(10);
		
		txtBankAccount = new JLabel();
		txtBankAccount.setText("Bank Account:");
		panel_1.add(txtBankAccount, "cell 0 10");
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		panel_1.add(textField_9, "cell 0 10");
		textField_9.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline");
		panel_1.add(lblDeadline, "cell 0 10");
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		panel_1.add(textField_10, "cell 0 10");
		textField_10.setColumns(3);
		
		JLabel label = new JLabel("/");
		panel_1.add(label, "cell 0 10");
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		panel_1.add(textField_11, "cell 0 10");
		textField_11.setColumns(3);
		
		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1, "cell 0 10");
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		panel_1.add(textField_12, "cell 0 10");
		textField_12.setColumns(3);
		
		txtrWarningsComments = new JTextArea();
		txtrWarningsComments.setEditable(false);
		txtrWarningsComments.setText("Warnings / Comments / Errors:");
		txtrWarningsComments.setForeground(Color.GREEN);
		txtrWarningsComments.setBackground(Color.BLACK);
		panel_1.add(txtrWarningsComments, "cell 0 12 7 1,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_1.add(panel_4, "cell 0 14 7 1,grow");
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().equals("")|| textField_3.getText().equals("")|| textField_4.getText().equals("")|| textField_5.getText().equals("")|| textField_6.getText().equals("")||
						textField_7.getText().equals("") || textField_8.getText().equals("") || textField_9.getText().equals("") || textField_10.getText().equals("")||
						textField_11.getText().equals("") || textField_12.getText().equals("")|| comboBox.getSelectedIndex()==-1|| comboBox_1.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(null,"Empty fields are a big no no with me, fill on everything before comming back");
					txtrWarningsComments.setText(txtrWarningsComments.getText()+"You cannot pass! I am a servant of the Secret Fire, wielder of the Flame of Anor.The Dark Flame will not avail you, Flame of Udun."
							+ " Go back to the shadow. You shall not pass!\n");
				}
				else {
					String report="";
					int fuckedUp=0;
					float size=0;
					float weight=0;
					float price=0;
					String TOA="";
					String TOF="";
					String color="";
					String Method="";
					int Iban=0;
					LocalDate dt=null;
					try {
						size=Float.parseFloat(textField_1.getText());
					}catch(Exception ex){
						fuckedUp=fuckedUp+1;
						report=report+"size must be a real number, ";
					}
					try {
						weight= Float.parseFloat(textField_3.getText());
					}catch(Exception ex) {
						fuckedUp= fuckedUp+1;
						report=report+"weight must be a real number, ";
					}
					try {
						price = Float.parseFloat(textField_4.getText());
					}catch(Exception ex) {
						fuckedUp=fuckedUp+1;
						report=report+"price must be a real number, ";
					}
					try {
						Iban = Integer.parseInt(textField_9.getText());
					}catch(Exception ex) {
						fuckedUp=fuckedUp+1;
						report=report+"the iban must be a whole number, ";
					}

					color= textField_5.getText();
					TOF= textField_6.getText();
					TOA= textField_7.getText();
					Method =textField_8.getText();
					try {
						if(Integer.parseInt(textField_11.getText())<10){
							textField_11.setText("0"+textField_11.getText());
						}
						String str=textField_12.getText()+"-"+textField_11.getText()+"-"+textField_10.getText();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						dt = LocalDate.parse(str, formatter);
					}catch(Exception ex) {
						fuckedUp=fuckedUp+1;
						report =report+"the deadline seems to have something wrong.";
					}
					report=report+"\n";
					if(fuckedUp==0) {
						Prosthetics prs= new Prosthetics();
						prs.setSize(size);
						prs.setColor(color);
						prs.setWeight(weight);
						prs.setBestPrice(price);
						prs.setTypeOfAmputation(TOA);
						prs.setTypeOfFunctionality(TOF);
						prs.setColor(color);
						Payment pmn = new Payment();
						pmn.setMethod(Method);
						pmn.setIban(Iban);
						pmn.setDeadline(Date.valueOf(dt));
						Material mat= myNameIsTim.getMaterialFull(Integer.parseInt((String)comboBox.getSelectedItem()));
						Features feat =myNameIsTim.getFeatureFull(Integer.parseInt((String)comboBox_1.getSelectedItem()));
						myNameIsTim.newProsthetic(prs,mat,feat,pmn,clientID);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Ok, there are "+fuckedUp+" things wrong, details in the error tab.");
						txtrWarningsComments.setText(txtrWarningsComments.getText()+report);
					}
				}
			}
		});
		btnCreate.setForeground(Color.GREEN);
		btnCreate.setBackground(Color.BLACK);
		panel_4.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.GREEN);
		panel_4.add(btnCancel);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setForeground(Color.GREEN);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(Integer.parseInt((String)comboBox.getSelectedItem()));
				ViewMaterial m= new ViewMaterial(myNameIsTim, Integer.parseInt((String)comboBox.getSelectedItem()));
				m.setVisible(true);
			}
		});
		btnCheck.setBackground(Color.BLACK);
		panel_1.add(btnCheck, "cell 0 8");
		
		JLabel lblFeatures = new JLabel("Features:");
		panel_1.add(lblFeatures, "cell 0 8");
		
		comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		panel_1.add(comboBox_1, "cell 0 8");
		String [] matId=myNameIsTim.getMaterialId();
		String [] featureId=myNameIsTim.getFeatureId();
		for (int i = 0; i < matId.length; i++) {
			comboBox.addItem(matId[i]);
		}
		for (int i = 0; i < featureId.length; i++) {
			comboBox_1.addItem(featureId[i]);
		}
		JButton btnCheck_1 = new JButton("Check");
		btnCheck_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getSelectedIndex()!=-1) {
					//System.out.println(Integer.parseInt((String) comboBox_1.getSelectedItem()));
					ViewFeatures f=new ViewFeatures(myNameIsTim, Integer.parseInt((String) comboBox_1.getSelectedItem()));
					f.setVisible(true);
				}
			}
		});
		btnCheck_1.setForeground(Color.GREEN);
		btnCheck_1.setBackground(Color.BLACK);
		panel_1.add(btnCheck_1, "cell 0 8");
		frame.getContentPane().add(contentPane);
		frame.setVisible(true);
	}
}