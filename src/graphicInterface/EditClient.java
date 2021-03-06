package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Address;
import pojos.db.prosthetics.Client;
import pojos.db.prosthetics.Payment;
import pojos.db.prosthetics.Prosthetics;
import pojos.db.prosthetics.User;
import wizard_Handler.WizardHandler;

public class EditClient extends JFrame {
	private int fuckedup;
	private int option1;
	private int option2;
	private String gender[] = { "Unspecified", "Male", "Female" };;
	private Client cln = new Client();
	private Prosthetics prs = new Prosthetics();
	private Address adr = new Address();
	private Payment pmn = new Payment();
	private JComboBox comboBox_1;
	private JFrame frame =new JFrame();
	private JTextArea textArea;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public EditClient(WizardHandler myNameIsTim,User admin) {
		if(admin.getPrivilege().getPrivilege()==1) {
			option1 = -1;
			option2 = -1;
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
			contentPane.add(panel, BorderLayout.SOUTH);
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * how to check if the combobox is a valid option and actually contains
					 * something valid.
					 */
					fuckedup = 0;
					if (option1 != -1 && option2 != -1) {
						if (textField.getText().equals("") && textField_1.getText().equals("")
								&& textField_2.getText().equals("")
								&& textField_4.getText().equals("") && textField_5.getText().equals("")
								&& textField_6.getText().equals("") && textField_7.getText().equals("")
								&& textField_8.getText().equals("") && textField_9.getText().equals("")
								&& textField_10.getText().equals("") && textField_11.getText().equals("")
								&& textField_12.getText().equals("") && textField_13.getText().equals("")
								&& textField_14.getText().equals("") && textField_15.getText().equals("")
								&& textField_16.getText().equals("") && textField_17.getText().equals("")
								&& textField_18.getText().equals("") && textField_19.getText().equals("")
								&& textField_20.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "No empty fields allowed!");
						} else {
							adr.setCountry(textField_8.getText());
							try {
								adr.setNumber(Integer.parseInt(textField_13.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Number must be an actual number,");
							}
							try {
								adr.setPostCode(Integer.parseInt(textField_11.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Postcode must be an actual number,");
							}
							adr.setStreet(textField_12.getText());
							adr.setTown(textField_10.getText());
							adr.setCity(textField_9.getText());
							try {
								if(Integer.parseInt(textField_6.getText())<10 && textField_6.getText().toCharArray()[0]!=0) {
									textField_6.setText("0"+textField_6.getText());
								}
								String str = textField_14.getText() + "-" + textField_6.getText() + "-"
										+ textField_1.getText();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dt = LocalDate.parse(str, formatter);
								cln.setDateOfBirth(Date.valueOf(dt));
								cln.setAddress(adr);
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText()
										+ " Date Of Birth is messed up, probably because there are several empty fields,");
								ex.printStackTrace();
							}
							if (option1 != -1 && option1 != 0) {
								cln.setGender(gender[option1]);
							} else {
								JOptionPane.showMessageDialog(null,
										"No, no unspecified gender allowed, we are a filthy bunch of cis white males that only accept 2 genders in their lives.");
								fuckedup = fuckedup + 1;
							}
							cln.setName(textField.getText());
							try {
								if (Integer.parseInt(textField_18.getText()) < 10 && textField_18.getText().toCharArray()[0]!='0') {
									textField_18.setText("0" + textField_18.getText());
								}
								String str = textField_19.getText() + "-" + textField_18.getText() + "-"
										+ textField_17.getText();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dt = LocalDate.parse(str, formatter);
								pmn.setDeadline((Date.valueOf(dt)));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText()
										+ " The Deadline is messed up, probably because there are some empty fileds,");
								ex.printStackTrace();
							}
							try {
								pmn.setIban(Integer.parseInt(textField_16.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Iban must be an actual number,");
							}
							if (textField_15.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(Method)");
							} else {
								pmn.setMethod(textField_15.getText());
							}
							try {
								prs.setBestPrice(Float.parseFloat(textField_20.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Price must be an actual number,");
							}
							prs.setColor(myNameIsTim.getStringThroughIndex(comboBox_1.getSelectedIndex()));
							try {
								prs.setSize(Float.parseFloat(textField_4.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Size must be an actual number,");
							}
							if (textField_4.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOA)");
							} else {
								prs.setTypeOfAmputation(textField_7.getText());
							}
							if (textField_2.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOF)");
							} else {
								prs.setTypeOfFunctionality(textField_2.getText());
							}
							try {
								prs.setWeight(Float.parseFloat(textField_5.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Wheight must be an actual number");
							}
							if (fuckedup != 0) {
								JOptionPane.showMessageDialog(null, "Ok, there are " + fuckedup
										+ " things wrong with this entry fix them before continuing\nMay I suggest checking the Warnings and Failures tab?");
								textArea.setText(textArea.getText() + "\n");
							} else {
								String choice="";
								choice=myNameIsTim.editClient(cln,adr,prs,pmn);
								if (choice.equals("all clear")) {
									frame.dispose();
								} else {
									JOptionPane.showMessageDialog(null,"failed to insert a new client\nDetails in the erro tab");
									textArea.setForeground(Color.RED);
									textArea.setText(textArea.getText() + choice);
									textArea.setForeground(Color.GREEN);
								}
							}
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
			txtrNewClientInsertion.setText("Edit Client");
			panel_1.add(txtrNewClientInsertion);

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(new MigLayout("", "[][][][][grow][][][][][grow][][grow][][][][][][][][grow]", "[][][][][][grow][][][][grow][][][][][][grow][][][grow][][][][][][][][]"));

			Component verticalStrut_4 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_4, "flowx,cell 19 0");

			JLabel lblSelectClient = new JLabel("Select Client:");
			panel_2.add(lblSelectClient, "cell 3 1");

			JComboBox comboBox_2 = new JComboBox(myNameIsTim.getClientId());
			panel_2.add(comboBox_2, "cell 6 1 4 1,growx");

			JButton btnOk_1 = new JButton("ok");
			btnOk_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox_2.getSelectedIndex()!=-1) {
						cln=myNameIsTim.getClientFull(Integer.parseInt(myNameIsTim.getClientId()[comboBox_2.getSelectedIndex()]));
						int addressId=myNameIsTim.getAddressIdThruClientId(Integer.parseInt(myNameIsTim.getClientId()[comboBox_2.getSelectedIndex()]));
						adr=myNameIsTim.getAddressFull(addressId);
						int prostheticId=myNameIsTim.getProstheticIdThruClientId(Integer.parseInt(myNameIsTim.getClientId()[comboBox_2.getSelectedIndex()]));
						prs=myNameIsTim.getProstheticFull(prostheticId);
						int paymentId = myNameIsTim.getPaymentIdThruProstheticId(prostheticId);
						pmn=myNameIsTim.getPaymentFull(paymentId);
						textField.setText(cln.getName());
						textField.setEditable(true);
						textField_1.setText(""+cln.getDateOfBirth().toLocalDate().getDayOfMonth());
						textField_1.setEditable(true);
						textField_6.setText(""+cln.getDateOfBirth().toLocalDate().getMonthValue());
						textField_6.setEditable(true);
						textField_14.setText(""+cln.getDateOfBirth().toLocalDate().getYear());
						textField_14.setEditable(true);
						if(cln.getGender().equals("Male")) {
							comboBox.setSelectedIndex(1);
						}
						else {
							comboBox.setSelectedIndex(2);
						}
						comboBox.setEnabled(true);


						textField_4.setText(""+prs.getSize());
						textField_4.setEditable(true);
						textField_5.setText(""+prs.getWeight());
						textField_5.setEditable(true);
						textField_20.setText(""+prs.getBestPrice());
						textField_20.setEditable(true);
						comboBox_1.removeAllItems();
						String[] colors =myNameIsTim.getColours();
						for (int i = 0; i < colors.length; i++) {
							comboBox_1.addItem(colors[i]);
						}
						int index=0;
						for (int j = 0; j < colors.length; j++) {
							if(colors[j].equals(prs.getColor())) {
								index=j;
								break;
							}
							else {
								continue;
							}
						}
						comboBox_1.setSelectedIndex(index);
						comboBox_1.setVisible(false);
						comboBox_1.setEnabled(true);
						comboBox_1.setVisible(true);
						textField_2.setText(prs.getTypeOfFunctionality());
						textField_2.setEditable(true);
						textField_7.setText(prs.getTypeOfAmputation());
						textField_7.setEditable(true);


						textField_8.setText(adr.getCountry());
						textField_8.setEditable(true);
						textField_9.setText(adr.getCity());
						textField_9.setEditable(true);
						textField_10.setText(adr.getTown());
						textField_10.setEditable(true);
						textField_11.setText(""+adr.getPostCode());
						textField_11.setEditable(true);
						textField_12.setText(adr.getStreet());
						textField_12.setEditable(true);
						textField_13.setText(""+adr.getNumber());
						textField_13.setEditable(true);


						textField_15.setText(pmn.getMethod());
						textField_15.setEditable(true);
						textField_16.setText(""+pmn.getIban());
						textField_16.setEditable(true);
						textField_17.setText(""+pmn.getDeadline().toLocalDate().getDayOfMonth());
						textField_17.setEditable(true);
						textField_18.setText(""+pmn.getDeadline().toLocalDate().getMonthValue());
						textField_18.setEditable(true);
						textField_19.setText(""+pmn.getDeadline().toLocalDate().getYear());
						textField_19.setEditable(true);
					}
				}
			});
			btnOk_1.setBackground(Color.BLACK);
			btnOk_1.setForeground(Color.GREEN);
			panel_2.add(btnOk_1, "cell 11 1");

			JLabel lblName = new JLabel("Name:");
			panel_2.add(lblName, "flowx,cell 19 1,alignx left");

			textField = new JTextField();
			textField.setEditable(false);
			panel_2.add(textField, "cell 19 1,alignx right");
			textField.setColumns(10);

			JLabel lblAge = new JLabel("Date Of Birth:");
			panel_2.add(lblAge, "cell 19 1,alignx center");

			textField_1 = new JTextField();
			textField_1.setEditable(false);
			panel_2.add(textField_1, "cell 19 1,alignx center");
			textField_1.setColumns(3);

			JLabel label = new JLabel("/");
			panel_2.add(label, "cell 19 1");

			textField_6 = new JTextField();
			textField_6.setEditable(false);
			panel_2.add(textField_6, "cell 19 1");
			textField_6.setColumns(3);

			JLabel label_1 = new JLabel("/");
			panel_2.add(label_1, "cell 19 1");

			textField_14 = new JTextField();
			textField_14.setEditable(false);
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
			textField_3.setEditable(false);
			panel_2.add(textField_3, "cell 19 5,alignx right");
			textField_3.setColumns(10);

			JLabel lblNewLabel = new JLabel("Size:");
			panel_2.add(lblNewLabel, "cell 19 5");

			textField_4 = new JTextField();
			textField_4.setEditable(false);
			panel_2.add(textField_4, "cell 19 5");
			textField_4.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Weight:");
			panel_2.add(lblNewLabel_1, "cell 19 5");

			textField_5 = new JTextField();
			textField_5.setEditable(false);
			panel_2.add(textField_5, "cell 19 5");
			textField_5.setColumns(10);

			Component verticalStrut_5 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_5, "flowx,cell 19 6");

			JLabel lblNewLabel_2 = new JLabel("Color:");
			panel_2.add(lblNewLabel_2, "flowx,cell 19 7");

			comboBox = new JComboBox(gender);
			comboBox.setEnabled(false);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					option1 = comboBox.getSelectedIndex();
					textArea.setText(textArea.getText() + "\n" + option1);
				}
			});
			panel_2.add(comboBox, "cell 19 1,alignx trailing");
			option1 = comboBox.getSelectedIndex();
			String colours[] = myNameIsTim.getColours();
			comboBox_1 = new JComboBox(colours);
			comboBox_1.setEnabled(false);
			panel_2.add(comboBox_1, "cell 19 7");
			option2 = comboBox_1.getSelectedIndex();

			JLabel lblTypeOfFunctionality = new JLabel("Type of functionality:");
			panel_2.add(lblTypeOfFunctionality, "cell 19 7,alignx left");

			textField_2 = new JTextField();
			textField_2.setEditable(false);
			panel_2.add(textField_2, "cell 19 7");
			textField_2.setColumns(10);

			JLabel lblTypeOfAmputation = new JLabel("Type of Amputation");
			panel_2.add(lblTypeOfAmputation, "cell 19 7");

			textField_7 = new JTextField();
			textField_7.setEditable(false);
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

			txtAddress = new JLabel();
			txtAddress.setFont(new Font("Consolas", Font.PLAIN, 11));
			txtAddress.setBackground(Color.BLACK);
			txtAddress.setForeground(Color.GREEN);
			txtAddress.setText("Address");
			panel_4.add(txtAddress);

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

			JLabel lblCity = new JLabel("Country:");
			panel_2.add(lblCity, "flowx,cell 19 11");

			textField_8 = new JTextField();
			textField_8.setEditable(false);
			panel_2.add(textField_8, "cell 19 11,aligny top");
			textField_8.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("City:");
			panel_2.add(lblNewLabel_3, "cell 19 11");

			textField_9 = new JTextField();
			textField_9.setEditable(false);
			panel_2.add(textField_9, "cell 19 11");
			textField_9.setColumns(10);

			JLabel lblTown = new JLabel("Town:");
			panel_2.add(lblTown, "cell 19 11");

			textField_10 = new JTextField();
			textField_10.setEditable(false);
			panel_2.add(textField_10, "cell 19 11");
			textField_10.setColumns(10);

			Component verticalStrut_6 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_6, "flowx,cell 19 12");

			JLabel lblPostcode = new JLabel("PostCode:");
			panel_2.add(lblPostcode, "flowx,cell 19 13,aligny top");

			textField_11 = new JTextField();
			textField_11.setEditable(false);
			panel_2.add(textField_11, "cell 19 13");
			textField_11.setColumns(10);

			JLabel lblNumber = new JLabel("Street:");
			panel_2.add(lblNumber, "cell 19 13");

			textField_12 = new JTextField();
			textField_12.setEditable(false);
			panel_2.add(textField_12, "cell 19 13");
			textField_12.setColumns(10);

			JLabel lblNumber_1 = new JLabel("Number:");
			panel_2.add(lblNumber_1, "cell 19 13");

			textField_13 = new JTextField();
			textField_13.setEditable(false);
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
			textField_15.setEditable(false);
			panel_2.add(textField_15, "cell 19 22");
			textField_15.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("ISBN:");
			panel_2.add(lblNewLabel_5, "cell 19 22");

			textField_16 = new JTextField();
			textField_16.setEditable(false);
			panel_2.add(textField_16, "cell 19 22");
			textField_16.setColumns(10);

			JLabel lblDeadline = new JLabel("Deadline:");
			panel_2.add(lblDeadline, "cell 19 22");

			textField_17 = new JTextField();
			textField_17.setEditable(false);
			panel_2.add(textField_17, "cell 19 22");
			textField_17.setColumns(3);

			JLabel label_2 = new JLabel("/");
			panel_2.add(label_2, "cell 19 22");

			textField_18 = new JTextField();
			textField_18.setEditable(false);
			panel_2.add(textField_18, "cell 19 22");
			textField_18.setColumns(3);

			JLabel label_3 = new JLabel("/");
			panel_2.add(label_3, "cell 19 22");

			textField_19 = new JTextField();
			textField_19.setEditable(false);
			panel_2.add(textField_19, "cell 19 22");
			textField_19.setColumns(3);

			JLabel lblPrice = new JLabel("Price:");
			panel_2.add(lblPrice, "cell 19 5");

			textField_20 = new JTextField();
			textField_20.setEditable(false);
			panel_2.add(textField_20, "cell 19 5");
			textField_20.setColumns(10);
			panel.setVisible(true);
			frame.setVisible(true);
		}
		if(admin.getPrivilege().getPrivilege()==0) {
			option1 = -1;
			option2 = -1;
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			frame.getContentPane().add(contentPane);

			JPanel panel = new JPanel();
			panel.setBackground(Color.PINK);
			contentPane.add(panel, BorderLayout.SOUTH);
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * how to check if the combobox is a valid option and actually contains
					 * something valid.
					 */
					fuckedup = 0;
					if (option1 != -1 && option2 != -1) {
						if (textField.getText().equals("") && textField_1.getText().equals("")
								&& textField_2.getText().equals("")
								&& textField_4.getText().equals("") && textField_5.getText().equals("")
								&& textField_6.getText().equals("") && textField_7.getText().equals("")
								&& textField_8.getText().equals("") && textField_9.getText().equals("")
								&& textField_10.getText().equals("") && textField_11.getText().equals("")
								&& textField_12.getText().equals("") && textField_13.getText().equals("")
								&& textField_14.getText().equals("") && textField_15.getText().equals("")
								&& textField_16.getText().equals("") && textField_17.getText().equals("")
								&& textField_18.getText().equals("") && textField_19.getText().equals("")
								&& textField_20.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "No empty fields allowed!");
						} else {
							adr.setCountry(textField_8.getText());
							try {
								adr.setNumber(Integer.parseInt(textField_13.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Number must be an actual number,");
							}
							try {
								adr.setPostCode(Integer.parseInt(textField_11.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Postcode must be an actual number,");
							}
							adr.setStreet(textField_12.getText());
							adr.setTown(textField_10.getText());
							adr.setCity(textField_9.getText());
							try {
								if(Integer.parseInt(textField_6.getText())<10 && textField_6.getText().toCharArray()[0]!=0) {
									textField_6.setText("0"+textField_6.getText());
								}
								String str = textField_14.getText() + "-" + textField_6.getText() + "-"
										+ textField_1.getText();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dt = LocalDate.parse(str, formatter);
								cln.setDateOfBirth(Date.valueOf(dt));
								cln.setAddress(adr);
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText()
										+ " Date Of Birth is messed up, probably because there are several empty fields,");
								ex.printStackTrace();
							}
							if (option1 != -1 && option1 != 0) {
								cln.setGender(gender[option1]);
							} else {
								JOptionPane.showMessageDialog(null,
										"No, no unspecified gender allowed, we are a filthy bunch of cis white males that only accept 2 genders in their lives.");
								fuckedup = fuckedup + 1;
							}
							cln.setName(textField.getText());
							try {
								if (Integer.parseInt(textField_18.getText()) < 10 && textField_18.getText().toCharArray()[0]!='0') {
									textField_18.setText("0" + textField_18.getText());
								}
								String str = textField_19.getText() + "-" + textField_18.getText() + "-"
										+ textField_17.getText();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dt = LocalDate.parse(str, formatter);
								pmn.setDeadline((Date.valueOf(dt)));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText()
										+ " The Deadline is messed up, probably because there are some empty fileds,");
								ex.printStackTrace();
							}
							try {
								pmn.setIban(Integer.parseInt(textField_16.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Iban must be an actual number,");
							}
							if (textField_15.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(Method)");
							} else {
								pmn.setMethod(textField_15.getText());
							}
							try {
								prs.setBestPrice(Float.parseFloat(textField_20.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Price must be an actual number,");
							}
							prs.setColor(myNameIsTim.getStringThroughIndex(comboBox_1.getSelectedIndex()));
							try {
								prs.setSize(Float.parseFloat(textField_4.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Size must be an actual number,");
							}
							if (textField_4.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOA)");
							} else {
								prs.setTypeOfAmputation(textField_7.getText());
							}
							if (textField_2.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "fill in the rquired field:(TOF)");
							} else {
								prs.setTypeOfFunctionality(textField_2.getText());
							}
							try {
								prs.setWeight(Float.parseFloat(textField_5.getText()));
							} catch (Exception ex) {
								fuckedup = fuckedup + 1;
								textArea.setText(textArea.getText() + " Wheight must be an actual number");
							}
							if (fuckedup != 0) {
								JOptionPane.showMessageDialog(null, "Ok, there are " + fuckedup
										+ " things wrong with this entry fix them before continuing\nMay I suggest checking the Warnings and Failures tab?");
								textArea.setText(textArea.getText() + "\n");
							} else {
								String choice="";
								choice=myNameIsTim.editClient(cln,adr,prs,pmn);
								if (choice.equals("all clear")) {
									frame.dispose();
								} else {
									JOptionPane.showMessageDialog(null,"failed to insert a new client\nDetails in the erro tab");
									textArea.setForeground(Color.RED);
									textArea.setText(textArea.getText() + choice);
									textArea.setForeground(Color.BLACK);
								}
							}
						}
					}

				}
			});
			btnOk.setForeground(Color.BLACK);
			btnOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			btnOk.setBackground(Color.PINK);
			btnOk.setBorderPainted(false);
			panel.add(btnOk);

			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
				}
			});
			btnCancel.setBackground(Color.PINK);
			btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			btnCancel.setForeground(Color.BLACK);
			btnCancel.setBorderPainted(false);
			panel.add(btnCancel);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.PINK);
			contentPane.add(panel_1, BorderLayout.NORTH);

			JTextArea txtrNewClientInsertion = new JTextArea();
			txtrNewClientInsertion.setForeground(Color.BLACK);
			txtrNewClientInsertion.setBackground(Color.PINK);
			txtrNewClientInsertion.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
			txtrNewClientInsertion.setText("Edit Client");
			panel_1.add(txtrNewClientInsertion);

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(new MigLayout("", "[][][][][grow][][][][][grow][][grow][][][][][][][][grow]", "[][][][][][grow][][][][grow][][][][][][grow][][][grow][][][][][][][][]"));

			Component verticalStrut_4 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_4, "flowx,cell 19 0");
			JLabel lblName = new JLabel("Name:");
			panel_2.add(lblName, "flowx,cell 19 1,alignx left");

			textField = new JTextField();
			textField.setEditable(false);
			panel_2.add(textField, "cell 19 1,alignx right");
			textField.setColumns(10);

			JLabel lblAge = new JLabel("Date Of Birth:");
			panel_2.add(lblAge, "cell 19 1,alignx center");

			textField_1 = new JTextField();
			textField_1.setEditable(false);
			panel_2.add(textField_1, "cell 19 1,alignx center");
			textField_1.setColumns(3);

			JLabel label = new JLabel("/");
			panel_2.add(label, "cell 19 1");

			textField_6 = new JTextField();
			textField_6.setEditable(false);
			panel_2.add(textField_6, "cell 19 1");
			textField_6.setColumns(3);

			JLabel label_1 = new JLabel("/");
			panel_2.add(label_1, "cell 19 1");

			textField_14 = new JTextField();
			textField_14.setEditable(false);
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
			textField_3.setEditable(false);
			panel_2.add(textField_3, "cell 19 5,alignx right");
			textField_3.setColumns(10);

			JLabel lblNewLabel = new JLabel("Size:");
			panel_2.add(lblNewLabel, "cell 19 5");

			textField_4 = new JTextField();
			textField_4.setEditable(false);
			panel_2.add(textField_4, "cell 19 5");
			textField_4.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Weight:");
			panel_2.add(lblNewLabel_1, "cell 19 5");

			textField_5 = new JTextField();
			textField_5.setEditable(false);
			panel_2.add(textField_5, "cell 19 5");
			textField_5.setColumns(10);

			Component verticalStrut_5 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_5, "flowx,cell 19 6");

			JLabel lblNewLabel_2 = new JLabel("Color:");
			panel_2.add(lblNewLabel_2, "flowx,cell 19 7");

			comboBox = new JComboBox(gender);
			comboBox.setEnabled(false);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					option1 = comboBox.getSelectedIndex();
					textArea.setText(textArea.getText() + "\n" + option1);
				}
			});
			panel_2.add(comboBox, "cell 19 1,alignx trailing");
			option1 = comboBox.getSelectedIndex();
			String colours[] = myNameIsTim.getColours();
			comboBox_1 = new JComboBox(colours);
			comboBox_1.setEnabled(false);
			panel_2.add(comboBox_1, "cell 19 7");
			option2 = comboBox_1.getSelectedIndex();

			JLabel lblTypeOfFunctionality = new JLabel("Type of functionality:");
			panel_2.add(lblTypeOfFunctionality, "cell 19 7,alignx left");

			textField_2 = new JTextField();
			textField_2.setEditable(false);
			panel_2.add(textField_2, "cell 19 7");
			textField_2.setColumns(10);

			JLabel lblTypeOfAmputation = new JLabel("Type of Amputation");
			panel_2.add(lblTypeOfAmputation, "cell 19 7");

			textField_7 = new JTextField();
			textField_7.setEditable(false);
			panel_2.add(textField_7, "cell 19 7");
			textField_7.setColumns(10);

			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.BLACK);
			panel_3.setBackground(Color.PINK);
			panel_2.add(panel_3, "cell 0 3 20 1,growx");

			JLabel lblProsthetics = new JLabel("Prosthetic\r\n");
			lblProsthetics.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			lblProsthetics.setForeground(Color.BLACK);
			panel_3.add(lblProsthetics);

			Component verticalStrut_2 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_2, "flowx,cell 19 8");

			JPanel panel_4 = new JPanel();
			panel_4.setBackground(Color.PINK);
			panel_4.setForeground(Color.BLACK);
			panel_2.add(panel_4, "cell 0 9 20 1,growx,aligny top");

			txtAddress = new JLabel();
			txtAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			txtAddress.setBackground(Color.PINK);
			txtAddress.setForeground(Color.BLACK);
			txtAddress.setText("Address");
			panel_4.add(txtAddress);

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

			JLabel lblCity = new JLabel("Country:");
			panel_2.add(lblCity, "flowx,cell 19 11");

			textField_8 = new JTextField();
			textField_8.setEditable(false);
			panel_2.add(textField_8, "cell 19 11,aligny top");
			textField_8.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("City:");
			panel_2.add(lblNewLabel_3, "cell 19 11");

			textField_9 = new JTextField();
			textField_9.setEditable(false);
			panel_2.add(textField_9, "cell 19 11");
			textField_9.setColumns(10);

			JLabel lblTown = new JLabel("Town:");
			panel_2.add(lblTown, "cell 19 11");

			textField_10 = new JTextField();
			textField_10.setEditable(false);
			panel_2.add(textField_10, "cell 19 11");
			textField_10.setColumns(10);

			Component verticalStrut_6 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_6, "flowx,cell 19 12");

			JLabel lblPostcode = new JLabel("PostCode:");
			panel_2.add(lblPostcode, "flowx,cell 19 13,aligny top");

			textField_11 = new JTextField();
			textField_11.setEditable(false);
			panel_2.add(textField_11, "cell 19 13");
			textField_11.setColumns(10);

			JLabel lblNumber = new JLabel("Street:");
			panel_2.add(lblNumber, "cell 19 13");

			textField_12 = new JTextField();
			textField_12.setEditable(false);
			panel_2.add(textField_12, "cell 19 13");
			textField_12.setColumns(10);

			JLabel lblNumber_1 = new JLabel("Number:");
			panel_2.add(lblNumber_1, "cell 19 13");

			textField_13 = new JTextField();
			textField_13.setEditable(false);
			panel_2.add(textField_13, "cell 19 13");
			textField_13.setColumns(10);

			Component verticalStrut_13 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_13, "cell 19 14");

			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.PINK);
			panel_2.add(panel_5, "cell 0 15 20 1,grow");

			JLabel lblPayment = new JLabel("Payment");
			lblPayment.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			lblPayment.setBackground(Color.PINK);
			lblPayment.setForeground(Color.BLACK);
			panel_5.add(lblPayment);

			JLabel lblNewLabel_4 = new JLabel("Method:");
			panel_2.add(lblNewLabel_4, "flowx,cell 19 22");

			Component verticalStrut_7 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_7, "cell 19 23");

			textArea = new JTextArea();
			textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
			textArea.setLineWrap(true);
			textArea.setForeground(Color.BLACK);
			textArea.setBackground(Color.PINK);
			textArea.setEditable(false);
			textArea.setRows(5);
			textArea.setText("Warnings / Comments / Errors:\n");
			panel_2.add(textArea, "cell 0 24 20 1,grow");

			Component verticalStrut_9 = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut_9, "cell 19 25");

			textField_15 = new JTextField();
			textField_15.setEditable(false);
			panel_2.add(textField_15, "cell 19 22");
			textField_15.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("ISBN:");
			panel_2.add(lblNewLabel_5, "cell 19 22");

			textField_16 = new JTextField();
			textField_16.setEditable(false);
			panel_2.add(textField_16, "cell 19 22");
			textField_16.setColumns(10);

			JLabel lblDeadline = new JLabel("Deadline:");
			panel_2.add(lblDeadline, "cell 19 22");

			textField_17 = new JTextField();
			textField_17.setEditable(false);
			panel_2.add(textField_17, "cell 19 22");
			textField_17.setColumns(3);

			JLabel label_2 = new JLabel("/");
			panel_2.add(label_2, "cell 19 22");

			textField_18 = new JTextField();
			textField_18.setEditable(false);
			panel_2.add(textField_18, "cell 19 22");
			textField_18.setColumns(3);

			JLabel label_3 = new JLabel("/");
			panel_2.add(label_3, "cell 19 22");

			textField_19 = new JTextField();
			textField_19.setEditable(false);
			panel_2.add(textField_19, "cell 19 22");
			textField_19.setColumns(3);

			JLabel lblPrice = new JLabel("Price:");
			panel_2.add(lblPrice, "cell 19 5");

			textField_20 = new JTextField();
			textField_20.setEditable(false);
			panel_2.add(textField_20, "cell 19 5");
			textField_20.setColumns(10);
			System.out.println(myNameIsTim.getClientIdThrouUserId(admin.getId())+"this id is bein passed down as client id");
			System.out.println(admin.getId()+"this is the supposed user id");
			cln=myNameIsTim.getClientFull(myNameIsTim.getClientIdThrouUserId(admin.getId()));
			System.out.println(cln);
			int addressId=myNameIsTim.getAddressIdThruClientId(myNameIsTim.getClientIdThrouUserId(admin.getId()));
			adr=myNameIsTim.getAddressFull(addressId);
			int prostheticId=myNameIsTim.getProstheticIdThruClientId(myNameIsTim.getClientIdThrouUserId(admin.getId()));
			prs=myNameIsTim.getProstheticFull(prostheticId);
			int paymentId = myNameIsTim.getPaymentIdThruProstheticId(prostheticId);
			pmn=myNameIsTim.getPaymentFull(paymentId);
			
			textField.setText(cln.getName());
			textField.setEditable(true);
			textField_1.setText(""+cln.getDateOfBirth().toLocalDate().getDayOfMonth());
			textField_1.setEditable(true);
			textField_6.setText(""+cln.getDateOfBirth().toLocalDate().getMonthValue());
			textField_6.setEditable(true);
			textField_14.setText(""+cln.getDateOfBirth().toLocalDate().getYear());
			textField_14.setEditable(true);
			if(cln.getGender().equals("Male")) {
				comboBox.setSelectedIndex(1);
			}
			else {
				comboBox.setSelectedIndex(2);
			}
			comboBox.setEnabled(true);


			textField_4.setText(""+prs.getSize());
			textField_4.setEditable(true);
			textField_5.setText(""+prs.getWeight());
			textField_5.setEditable(true);
			textField_20.setText(""+prs.getBestPrice());
			textField_20.setEditable(true);
			comboBox_1.removeAllItems();
			String[] colors =myNameIsTim.getColours();
			for (int i = 0; i < colors.length; i++) {
				comboBox_1.addItem(colors[i]);
			}
			int index=0;
			for (int j = 0; j < colors.length; j++) {
				if(colors[j].equals(prs.getColor())) {
					index=j;
					break;
				}
				else {
					continue;
				}
			}
			comboBox_1.setSelectedIndex(index);
			comboBox_1.setVisible(false);
			comboBox_1.setEnabled(true);
			comboBox_1.setVisible(true);
			textField_2.setText(prs.getTypeOfFunctionality());
			textField_2.setEditable(true);
			textField_7.setText(prs.getTypeOfAmputation());
			textField_7.setEditable(true);


			textField_8.setText(adr.getCountry());
			textField_8.setEditable(true);
			textField_9.setText(adr.getCity());
			textField_9.setEditable(true);
			textField_10.setText(adr.getTown());
			textField_10.setEditable(true);
			textField_11.setText(""+adr.getPostCode());
			textField_11.setEditable(true);
			textField_12.setText(adr.getStreet());
			textField_12.setEditable(true);
			textField_13.setText(""+adr.getNumber());
			textField_13.setEditable(true);


			textField_15.setText(pmn.getMethod());
			textField_15.setEditable(true);
			textField_16.setText(""+pmn.getIban());
			textField_16.setEditable(true);
			textField_17.setText(""+pmn.getDeadline().toLocalDate().getDayOfMonth());
			textField_17.setEditable(true);
			textField_18.setText(""+pmn.getDeadline().toLocalDate().getMonthValue());
			textField_18.setEditable(true);
			textField_19.setText(""+pmn.getDeadline().toLocalDate().getYear());
			textField_19.setEditable(true);
			
			panel.setVisible(true);
			frame.setVisible(true);
		}
	}	
	JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_7;
	private JLabel txtAddress;
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
	
}
