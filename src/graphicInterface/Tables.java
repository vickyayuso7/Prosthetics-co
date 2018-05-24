package graphicInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pojos.db.prosthetics.Address;
import pojos.db.prosthetics.User;
import wizard_Handler.WizardHandler;
import wizard_Handler.WizardHandlerJPA;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tables extends JFrame{
	private JFrame frame =new JFrame();
	private JPanel contentPane;
	private static JPanel panel_2;
	private static WizardHandlerJPA oz;
	private static User admin;
	/**
	 * Create the application.
	 */
	public Tables(WizardHandler myNameIsTim,WizardHandlerJPA oz,User admin) {
		this.admin=admin;
		this.oz=oz;
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblTableViewer = new JLabel("Table Viewer");
		lblTableViewer.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblTableViewer.setBackground(Color.BLACK);
		lblTableViewer.setForeground(Color.GREEN);
		panel.add(lblTableViewer);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(new GridLayout(7,1));
		contentPane.add(panel_1, BorderLayout.WEST);

		JButton btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForClients(myNameIsTim);
			}
		});
		btnClients.setText("       Clients        ");
		btnClients.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnClients.setBackground(Color.BLACK);
		btnClients.setForeground(Color.GREEN);
		btnClients.setBorderPainted(false);
		panel_1.add(btnClients);

		JButton btnNewButton = new JButton("Prosthetics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForProsthetics(myNameIsTim);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton.setBorderPainted(false);
		panel_1.add(btnNewButton);

		JButton btnPayments = new JButton("Payments");
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForPayments(myNameIsTim);
			}
		});
		btnPayments.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnPayments.setForeground(Color.GREEN);
		btnPayments.setBackground(Color.BLACK);
		btnPayments.setBorderPainted(false);
		panel_1.add(btnPayments);

		JButton btnMaterials = new JButton("Materials");
		btnMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForMaterials(myNameIsTim);
			}
		});
		btnMaterials.setBackground(Color.BLACK);
		btnMaterials.setForeground(Color.GREEN);
		btnMaterials.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnMaterials.setBorderPainted(false);
		panel_1.add(btnMaterials);

		JButton btnFeatures = new JButton("Features");
		btnFeatures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForFeatures(myNameIsTim);
			}
		});
		btnFeatures.setForeground(Color.GREEN);
		btnFeatures.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnFeatures.setBackground(Color.BLACK);
		btnFeatures.setBorderPainted(false);
		panel_1.add(btnFeatures);

		JButton btnAddresses = new JButton("Addresses");
		btnAddresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyViewForAddresses(myNameIsTim);
			}
		});
		btnAddresses.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAddresses.setBackground(Color.BLACK);
		btnAddresses.setForeground(Color.GREEN);
		btnAddresses.setBorderPainted(false);
		panel_1.add(btnAddresses);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setForeground(Color.GREEN);
		btnExit.setBackground(Color.BLACK);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnExit.setBorderPainted(false);
		panel_1.add(btnExit);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		frame.add(contentPane);
		if(admin.getPrivilege().getPrivilege()==2) {
			btnExit.setBackground(Color.BLUE);
			btnExit.setBackground(Color.BLUE);
			btnAddresses.setBackground(Color.BLUE);
			btnClients.setBackground(Color.BLUE);
			btnFeatures.setBackground(Color.BLUE);
			btnMaterials.setBackground(Color.BLUE);
			btnNewButton.setBackground(Color.BLUE);
			btnPayments.setBackground(Color.BLUE);
			btnExit.setForeground(Color.WHITE);
			btnAddresses.setForeground(Color.WHITE);
			btnClients.setForeground(Color.WHITE);
			btnFeatures.setForeground(Color.WHITE);
			btnMaterials.setForeground(Color.WHITE);
			btnNewButton.setForeground(Color.WHITE);
			btnPayments.setForeground(Color.WHITE);
			panel.setBackground(Color.BLUE);
			panel_1.setBackground(Color.BLUE);
			btnAddresses.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnClients.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnExit.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnFeatures.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnMaterials.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnNewButton.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btnPayments.setFont(new Font("Times New Roman",Font.PLAIN,11));
			lblTableViewer.setForeground(Color.WHITE);
			lblTableViewer.setFont(new Font("Times New Roman",Font.PLAIN,11));
		}
		frame.setVisible(true);
	}
	private static void ModifyViewForClients(WizardHandler myNameIsTim) {
		panel_2.removeAll();
		JPanel panel_3 =new JPanel();
		JPanel panel_4 =new JPanel();
		panel_4.setLayout(new GridLayout(1,4));
		JLabel label_1 =new JLabel("Name:");
		JLabel label_2 =new JLabel("Bought these Prosthetics:");
		JLabel label_3 =new JLabel("Using this Payment:");
		JLabel label_4 =new JLabel("Lives in:");
		label_1.setForeground(Color.GREEN);
		label_1.setBackground(Color.BLACK);
		label_1.setFont(new Font("Consolas", Font.PLAIN, 11));
		label_2.setForeground(Color.GREEN);
		label_2.setBackground(Color.BLACK);
		label_2.setFont(new Font("Consolas", Font.PLAIN, 11));
		label_3.setForeground(Color.GREEN);
		label_3.setBackground(Color.BLACK);
		label_3.setFont(new Font("Consolas", Font.PLAIN, 11));
		label_4.setForeground(Color.GREEN);
		label_4.setBackground(Color.BLACK);
		label_4.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel_4.add(label_1);
		panel_4.add(label_2);
		panel_4.add(label_3);
		panel_4.add(label_4);
		panel_4.setBackground(Color.BLACK);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panel_4,BorderLayout.NORTH);
		panel_2.add(panel_3,BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1,4));
		final String[] clientIds = myNameIsTim.getClientId();
		final String[]names=new String[clientIds.length];
		for (int i = 0; i < clientIds.length; i++) {
			names[i]=clientIds[i]+":   "+myNameIsTim.getClientFull(Integer.parseInt(clientIds[i])).getName();
		}

		JList <String> listClients=new <String> JList(names);
		listClients.setSelectedIndex(-1);
		JList <String> listProsthetics =new JList();
		JList <String> listPayments =new JList();
		JList <String> listAddresses =new JList();

		listClients.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int Index;
				char charcmp='D';
				char[]name=listClients.getSelectedValue().toCharArray();
				String id="";
				for(int i=0;	charcmp!=':';	i++) {
					charcmp=name[i];
					if(charcmp!=':') {
						id=id+charcmp;
					}
				}
				String[]prosthetics=myNameIsTim.magicConversionProstheticsThrouClient(Integer.parseInt(id));
				for (int i = 0; i < prosthetics.length; i++) {
					prosthetics[i]="Prosthetic:   "+prosthetics[i];
				}
				listProsthetics.setListData(prosthetics);
				listProsthetics.setVisible(false);
				listProsthetics.setVisible(true);
				String[] idadr = new String[1];
				idadr[0]=""+myNameIsTim.getAddressIdThruClientId(Integer.parseInt(id))+":   "+myNameIsTim.getAddressFull(myNameIsTim.getAddressIdThruClientId(Integer.parseInt(id))).getStreet();   
				listAddresses.setListData(idadr);
			}
		});
		listClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char charcmp='D';
					char[]name=listClients.getSelectedValue().toCharArray();
					String id="";
					for(int i=0;	charcmp!=':';	i++) {
						charcmp=name[i];
						if(charcmp!=':') {
							id=id+charcmp;
						}
					}
					String[]prosthetics=myNameIsTim.magicConversionProstheticsThrouClient(Integer.parseInt(id));
					for (int i = 0; i < prosthetics.length; i++) {
						prosthetics[i]="Prosthetic:   "+prosthetics[i];
					}
					listProsthetics.setListData(prosthetics);
					listProsthetics.setVisible(false);
					listProsthetics.setVisible(true);
					String[] idadr = new String[1];
					idadr[0]=""+myNameIsTim.getAddressIdThruClientId(Integer.parseInt(id))+":   "+myNameIsTim.getAddressFull(myNameIsTim.getAddressIdThruClientId(Integer.parseInt(id))).getStreet();   
					listAddresses.setListData(idadr);
					User view =new User("default","pass");
					view.setUserType(oz.getStatus(1));
					EditClient c =new EditClient(myNameIsTim,view);
				}
			}
		});
		listProsthetics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[] prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					String id="";
					int counter=0;
					boolean escapechar=false;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							id=id+prostheticsId[i];
						}
					}
					ViewProsthetic p =new ViewProsthetic(myNameIsTim,Integer.parseInt(id));
				}
			}
		});
		listPayments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[]paymentId=listPayments.getSelectedValue().toCharArray();
					String id="";
					boolean escapechar=false;
					int counter=0;
					for (int i = 0; i < paymentId.length; i++) {
						if(paymentId[i]==':') {
							escapechar=true;
						}
						if(escapechar && paymentId[i]==' ') {
							counter=counter +1;
						}
						if(counter==3 && paymentId[i]!=' ') {
							id=id+paymentId[i];
						}
					}
					char[]prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					escapechar=false;
					String prsId="";
					counter=0;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							prsId=prsId+prostheticsId[i];
						}
					}
					System.out.println(prsId);
					ViewPayment p= new ViewPayment(myNameIsTim, Integer.parseInt(id), Integer.parseInt(prsId));
				}
			}
		});
		listProsthetics.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int pmnId;
				int prsId;
				if(listProsthetics.getSelectedIndex()!=-1) {
					char[] prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					String id="";
					int counter=0;
					boolean escapechar=false;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							id=id+prostheticsId[i];
						}
					}
					System.out.println(id);
					prsId=Integer.parseInt(id);
					pmnId=myNameIsTim.getPaymentIdThruProstheticId(prsId);
					String[] aFineAditionToMyCollection=new String[1];
					aFineAditionToMyCollection[0]="Payment Id:   "+pmnId;
					listPayments.setListData(aFineAditionToMyCollection);
				}
			}
		});

		listAddresses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {

					char[] address=listAddresses.getSelectedValue().toCharArray();
					String id="";
					boolean escapechar=false;
					for (int i = 0; i < address.length; i++) {
						if(address[i]==':') {
							escapechar=true;
						}
						if(escapechar!=true) {
							id=id+address[i];
						}
					}
					int idAdr=Integer.parseInt(id);
					ViewAdress a=new ViewAdress(myNameIsTim,idAdr);
				}
			}
		});
		/*index= Integer.parseInt(listProsthetics.getSelectedValue())
		listPayments.setListData(myNameIsTim.magicConversionPaymentsThrouProsthetic(index));*/

		listClients.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listClients.setBackground(Color.LIGHT_GRAY);
		listClients.setForeground(Color.BLACK);
		listProsthetics.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listProsthetics.setBackground(Color.LIGHT_GRAY);
		listProsthetics.setForeground(Color.BLACK);
		listPayments.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listPayments.setBackground(Color.LIGHT_GRAY);
		listPayments.setForeground(Color.BLACK);
		listAddresses.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listAddresses.setBackground(Color.LIGHT_GRAY);
		listAddresses.setForeground(Color.BLACK);
		panel_3.add(listClients);
		panel_3.add(listProsthetics);
		panel_3.add(listPayments);
		panel_3.add(listAddresses);
		if(admin.getPrivilege().getPrivilege()==2) {
			label_1.setForeground(Color.WHITE);
			label_2.setForeground(Color.WHITE);
			label_3.setForeground(Color.WHITE);
			label_4.setForeground(Color.WHITE);
			label_1.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label_2.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label_3.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label_4.setFont(new Font("Times New Roman",Font.PLAIN,11));
			panel_3.setBackground(Color.BLUE);
			panel_4.setBackground(Color.BLUE);
			listAddresses.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listClients.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listPayments.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listProsthetics.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listAddresses.setBackground(Color.WHITE);
			listClients.setBackground(Color.WHITE);
			listPayments.setBackground(Color.WHITE);
			listProsthetics.setBackground(Color.WHITE);
			listAddresses.setForeground(Color.BLACK);
			listClients.setForeground(Color.BLACK);
			listPayments.setForeground(Color.BLACK);
			listProsthetics.setForeground(Color.BLACK);
		}
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}
	private static void ModifyViewForProsthetics(WizardHandler myNameIsTim) {
		panel_2.removeAll();
		panel_2.setVisible(false);
		JPanel panel_3 =new JPanel();
		JPanel panel_4 =new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_4.setBackground(Color.WHITE);
		panel_3.setLayout(new GridLayout(1,2));
		JLabel label_1 =new JLabel("Prosthetics");
		JLabel label_2 =new JLabel("Payments");
		label_1.setFont(new Font("consolas",Font.PLAIN,11));
		label_2.setFont(new Font("consolas",Font.PLAIN,11));
		label_1.setForeground(Color.GREEN);
		label_2.setForeground(Color.GREEN);
		panel_3.add(label_1);
		panel_3.add(label_2);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panel_3,BorderLayout.NORTH);
		panel_2.add(panel_4,BorderLayout.CENTER);
		panel_3.setVisible(true); 
		panel_4.setVisible(true);
		panel_2.setVisible(true);
		JList<String> listProsthetics =new JList<String>();
		JList<String> listPayments = new JList<String>();
		listProsthetics.setBackground(Color.LIGHT_GRAY);
		listPayments.setBackground(Color.LIGHT_GRAY);
		listPayments.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listProsthetics.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setLayout(new GridLayout(1,2));
		panel_4.add(listProsthetics);
		panel_4.add(listPayments);
		String[]prsIds=myNameIsTim.getProstheticsId();
		for (int i = 0; i < prsIds.length; i++) {
			prsIds[i]="Prosthetic:   "+prsIds[i];
		}
		listProsthetics.setListData(prsIds);
		listProsthetics.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int pmnId;
				int prsId;
				if(listProsthetics.getSelectedIndex()!=-1) {
					char[] prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					String id="";
					int counter=0;
					boolean escapechar=false;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							id=id+prostheticsId[i];
						}
					}
					System.out.println(id);
					prsId=Integer.parseInt(id);
					pmnId=myNameIsTim.getPaymentIdThruProstheticId(prsId);
					String[] aFineAditionToMyCollection=new String[1];
					aFineAditionToMyCollection[0]="Payment Id:   "+pmnId;
					listPayments.setListData(aFineAditionToMyCollection);
				}
			}
		});
		listProsthetics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[] prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					String id="";
					int counter=0;
					boolean escapechar=false;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							id=id+prostheticsId[i];
						}
					}
					ViewProsthetic p =new ViewProsthetic(myNameIsTim,Integer.parseInt(id));
				}
			}
		});
		listPayments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[]paymentId=listPayments.getSelectedValue().toCharArray();
					String id="";
					boolean escapechar=false;
					int counter=0;
					for (int i = 0; i < paymentId.length; i++) {
						if(paymentId[i]==':') {
							escapechar=true;
						}
						if(escapechar && paymentId[i]==' ') {
							counter=counter +1;
						}
						if(counter==3 && paymentId[i]!=' ') {
							id=id+paymentId[i];
						}
					}
					char[]prostheticsId=listProsthetics.getSelectedValue().toCharArray();
					escapechar=false;
					String prsId="";
					counter=0;
					for (int i = 0; i < prostheticsId.length; i++) {
						if(prostheticsId[i]==':') {
							escapechar=true;
						}
						if(escapechar && prostheticsId[i]==' ') {
							counter=counter+1;
						}
						if(counter == 3 && prostheticsId[i]!=' ') {
							prsId=prsId+prostheticsId[i];
						}
					}
					System.out.println(prsId);
					ViewPayment p= new ViewPayment(myNameIsTim, Integer.parseInt(id), Integer.parseInt(prsId));
				}
			}
		});

		if(admin.getPrivilege().getPrivilege()==2) {
			label_1.setForeground(Color.WHITE);
			label_2.setForeground(Color.WHITE);
			label_1.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label_2.setFont(new Font("Times New Roman",Font.PLAIN,11));
			listPayments.setForeground(Color.BLACK);
			listProsthetics.setForeground(Color.BLACK);
			panel_3.setBackground(Color.BLUE);
			listPayments.setBackground(Color.WHITE);
			listProsthetics.setBackground(Color.WHITE);
			listPayments.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listProsthetics.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		}
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}
	private static void ModifyViewForPayments(WizardHandler myNameIsTim) {
		panel_2.removeAll();
		panel_2.setVisible(false);
		panel_2.setLayout(new BorderLayout());
		JPanel panel_3 =new JPanel();
		JPanel panel_4 =new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_4.setBackground(Color.WHITE);
		JLabel client =new JLabel("Client:");
		client.setFont(new Font("consolas",Font.PLAIN,11));
		client.setForeground(Color.GREEN);
		JLabel payments =new JLabel("Payments:");
		payments.setFont(new Font("consolas", Font.PLAIN,11));
		payments.setForeground(Color.GREEN);
		panel_3.setLayout(new GridLayout(1,2));
		panel_3.add(client);
		panel_3.add(payments);
		panel_4.setLayout(new GridLayout(1,2));
		final String[] clientIds = myNameIsTim.getClientId();
		final String[]names=new String[clientIds.length];
		for (int i = 0; i < clientIds.length; i++) {
			names[i]=clientIds[i]+":   "+myNameIsTim.getClientFull(Integer.parseInt(clientIds[i])).getName();
		}

		JList <String> listClients=new <String> JList(names);
		listClients.setSelectedIndex(-1);
		JList<String> listPayments=new JList<String>();
		listClients.setBackground(Color.LIGHT_GRAY);
		listPayments.setBackground(Color.LIGHT_GRAY);
		listClients.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listPayments.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listClients.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int Index;
				char charcmp='D';
				char[]name=listClients.getSelectedValue().toCharArray();
				String id="";
				for(int i=0;	charcmp!=':';	i++) {
					charcmp=name[i];
					if(charcmp!=':') {
						id=id+charcmp;
					}
				}
				String[]prosthetics=myNameIsTim.magicConversionProstheticsThrouClient(Integer.parseInt(id));
				String paymentId[]=new String[prosthetics.length];
				for (int i = 0; i < prosthetics.length; i++) {
					paymentId[i]="Payment Id:   "+myNameIsTim.getPaymentIdThruProstheticId(Integer.parseInt(prosthetics[i]));
					prosthetics[i]="Prosthetic:   "+prosthetics[i];
				}

				listPayments.setListData(paymentId);
				listPayments.setVisible(false);
				listPayments.setVisible(true);
			}
		});
		listClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					int Index;
					char charcmp='D';
					char[]name=listClients.getSelectedValue().toCharArray();
					String id="";
					for(int i=0;	charcmp!=':';	i++) {
						charcmp=name[i];
						if(charcmp!=':') {
							id=id+charcmp;
						}
					}
					User view =new User("default","pass");
					view.setUserType(oz.getStatus(1));
					EditClient c =new EditClient(myNameIsTim,view);
				}
			}
		});
		listPayments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[]paymentId=listPayments.getSelectedValue().toCharArray();
					String id="";
					boolean escapechar=false;
					int counter=0;
					for (int i = 0; i < paymentId.length; i++) {
						if(paymentId[i]==':') {
							escapechar=true;
						}
						if(escapechar && paymentId[i]==' ') {
							counter=counter +1;
						}
						if(counter==3 && paymentId[i]!=' ') {
							id=id+paymentId[i];
						}
					}
					int prsId=myNameIsTim.getProstheticIdThruPaymentId(Integer.parseInt(id));
					ViewPayment p= new ViewPayment(myNameIsTim, Integer.parseInt(id), prsId);
				}
			}
		});
		panel_4.add(listClients);
		panel_4.add(listPayments);
		panel_2.add(panel_3,BorderLayout.NORTH);
		panel_2.add(panel_4,BorderLayout.CENTER);
		if(admin.getPrivilege().getPrivilege()==2) {
			client.setForeground(Color.WHITE);
			payments.setForeground(Color.WHITE);
			client.setFont(new Font("Times New Roman",Font.PLAIN,11));
			payments.setFont(new Font("Times New Roman",Font.PLAIN,11));
			listPayments.setForeground(Color.BLACK);
			listClients.setForeground(Color.BLACK);
			panel_3.setBackground(Color.BLUE);
			listPayments.setBackground(Color.WHITE);
			listClients.setBackground(Color.WHITE);
			listPayments.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listClients.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		}
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}
	private static void ModifyViewForMaterials(WizardHandler myNameIsTim) {
		panel_2.removeAll();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_4.setBackground(Color.WHITE);
		JLabel label =new JLabel("Materials");
		panel_3.add(label);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panel_3,BorderLayout.NORTH);
		panel_2.add(panel_4,BorderLayout.CENTER);
		label.setFont(new Font("consolas",Font.PLAIN,11));
		label.setForeground(Color.GREEN);
		JList<String> listMaterials = new<String> JList();
		listMaterials.setBackground(Color.LIGHT_GRAY);
		listMaterials.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		String[] materials= myNameIsTim.getMaterialId();
		for (int i = 0; i < materials.length; i++) {
			materials[i]=materials[i]+":   "+myNameIsTim.getMaterialFull(Integer.parseInt(materials[i])).getType();
		}
		listMaterials.setListData(materials);
		panel_4.setLayout(new BorderLayout());
		panel_4.add(listMaterials,BorderLayout.CENTER);
		listMaterials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[] matID = listMaterials.getSelectedValue().toCharArray();
					String id="";
					for (int i = 0; i < matID.length; i++) {
						if(matID[i]!=':') {
							id=id+matID[i];
						}
						if(matID[i]==':') {
							break;
						}
					}
					System.out.println(id);
					ViewMaterial m=new ViewMaterial(myNameIsTim,Integer.parseInt(id));
					m.setVisible(true);
				}
			}
		});
		if(admin.getPrivilege().getPrivilege()==2) {
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Times New Roman",Font.PLAIN,11));
			listMaterials.setForeground(Color.BLACK);
			panel_3.setBackground(Color.BLUE);
			listMaterials.setBackground(Color.WHITE);
			listMaterials.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		}
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}
	private static void ModifyViewForFeatures(WizardHandler myNameIsTim) {
		panel_2.removeAll();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_4.setBackground(Color.WHITE);
		JLabel label =new JLabel("Materials");
		panel_3.add(label);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panel_3,BorderLayout.NORTH);
		panel_2.add(panel_4,BorderLayout.CENTER);
		label.setFont(new Font("consolas",Font.PLAIN,11));
		label.setForeground(Color.GREEN);
		JList<String> listFeatures = new<String> JList();
		listFeatures.setBackground(Color.LIGHT_GRAY);
		listFeatures.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		String[] materials= myNameIsTim.getFeatureId();
		for (int i = 0; i < materials.length; i++) {
			materials[i]=materials[i]+":   "+myNameIsTim.getFeatureFull(Integer.parseInt(materials[i])).getStyle();
		}
		listFeatures.setListData(materials);
		panel_4.setLayout(new BorderLayout());
		panel_4.add(listFeatures,BorderLayout.CENTER);
		listFeatures.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char[] matID = listFeatures.getSelectedValue().toCharArray();
					String id="";
					for (int i = 0; i < matID.length; i++) {
						if(matID[i]!=':') {
							id=id+matID[i];
						}
						if(matID[i]==':') {
							break;
						}
					}
					System.out.println(id);
					ViewFeatures m=new ViewFeatures(myNameIsTim,Integer.parseInt(id));
					m.setVisible(true);
				}
			}
		});
		if(admin.getPrivilege().getPrivilege()==2) {
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Times New Roman",Font.PLAIN,11));
			listFeatures.setForeground(Color.BLACK);
			panel_3.setBackground(Color.BLUE);
			listFeatures.setBackground(Color.WHITE);
			listFeatures.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		}
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}
	private static void ModifyViewForAddresses(WizardHandler myNameIsTim) {
		JPanel panel_3=new JPanel();
		JPanel panel_4=new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setLayout(new GridLayout(1,4));
		panel_4.setLayout(new GridLayout(1,4));
		JLabel label = new JLabel("Country:");
		JLabel label1 =new JLabel("city:");
		JLabel label2=new JLabel("Street:");
		JLabel label3=new JLabel("Name:");
		panel_3.setLayout(new GridLayout(1,4));
		label.setForeground(Color.GREEN);
		label1.setForeground(Color.GREEN);
		label2.setForeground(Color.GREEN);
		label3.setForeground(Color.GREEN);
		label.setFont(new Font("consolas",Font.PLAIN,11));
		label1.setFont(new Font("consolas",Font.PLAIN,11));
		label2.setFont(new Font("consolas",Font.PLAIN,11));
		label3.setFont(new Font("consolas",Font.PLAIN,11));	
		panel_3.add(label3);
		panel_3.add(label);
		panel_3.add(label1);
		panel_3.add(label2);
		JList<String> listClients =new JList<String>();
		JList<String> listCities =new JList<String>();
		JList<String> listCountry =new JList<String>();
		JList<String> listStreets =new JList<String>();
		JPanel panel_5=new JPanel();
		panel_5.setBackground(Color.BLACK);
		JButton btn1 =new JButton(); 	//order by Country
		JButton btn2 =new JButton();	//order by city
		JButton btn3 =new JButton();	//order by Street
		JButton btn4 =new JButton();	//order by names
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []orderedCountries=myNameIsTim.getCountriesOrdered();
				String[] countries=new String [orderedCountries.length];
				String[] cities =new String[orderedCountries.length];
				String[] street = new String[orderedCountries.length];
				String[] name = new String [orderedCountries.length];
				int thisIsWhyWeCantHaveNiceThings=0;

				for (int i = 0; i < orderedCountries.length; i++) {
					countries[i]="";
					cities[i]="";
					street[i]="";
					name[i]="";
					thisIsWhyWeCantHaveNiceThings=0;
					char[] nastyStuff= orderedCountries[i].toCharArray();

					for (int j = 0; j < nastyStuff.length; j++) {
						if(thisIsWhyWeCantHaveNiceThings ==0 && nastyStuff[j]!=';') {
							countries[i]=countries[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==1 && nastyStuff[j]!=';') {
							street[i]=street[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==2 && nastyStuff[j]!=';') {
							cities[i]=cities[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==3 && nastyStuff[j]!=';') {
							name[i]=name[i]+nastyStuff[j];
						}
						if(nastyStuff[j]==';') {
							thisIsWhyWeCantHaveNiceThings=thisIsWhyWeCantHaveNiceThings+1;
						}
					}
				}
				listCountry.setListData(countries);
				listCities.setListData(cities);
				listStreets.setListData(street);
				listClients.setListData(name);

				listCountry.setVisible(false);
				listCountry.setVisible(true);

				listClients.setVisible(false);
				listClients.setVisible(true);

				listStreets.setVisible(false);
				listStreets.setVisible(true);

				listCities.setVisible(false);
				listCities.setVisible(true);
				//System.out.println("ordered by countires");
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []orderedCities=myNameIsTim.getCitiesOrdered();
				String[] countries=new String [orderedCities.length];
				String[] cities =new String[orderedCities.length];
				String[] street = new String[orderedCities.length];
				String[] name = new String [orderedCities.length];
				int thisIsWhyWeCantHaveNiceThings=0;

				for (int i = 0; i < orderedCities.length; i++) {
					countries[i]="";
					cities[i]="";
					street[i]="";
					name[i]="";
					thisIsWhyWeCantHaveNiceThings=0;
					char[] nastyStuff= orderedCities[i].toCharArray();

					for (int j = 0; j < nastyStuff.length; j++) {
						if(thisIsWhyWeCantHaveNiceThings ==0 && nastyStuff[j]!=';') {
							countries[i]=countries[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==1 && nastyStuff[j]!=';') {
							street[i]=street[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==2 && nastyStuff[j]!=';') {
							cities[i]=cities[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==3 && nastyStuff[j]!=';') {
							name[i]=name[i]+nastyStuff[j];
						}
						if(nastyStuff[j]==';') {
							thisIsWhyWeCantHaveNiceThings=thisIsWhyWeCantHaveNiceThings+1;
						}
					}
				}
				listCountry.setListData(countries);
				listCities.setListData(cities);
				listStreets.setListData(street);
				listClients.setListData(name);

				listCountry.setVisible(false);
				listCountry.setVisible(true);

				listClients.setVisible(false);
				listClients.setVisible(true);

				listStreets.setVisible(false);
				listStreets.setVisible(true);

				listCities.setVisible(false);
				listCities.setVisible(true);
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []orderedCities=myNameIsTim.getStreetsOrdered();
				String[] countries=new String [orderedCities.length];
				String[] cities =new String[orderedCities.length];
				String[] street = new String[orderedCities.length];
				String[] name = new String [orderedCities.length];
				int thisIsWhyWeCantHaveNiceThings=0;

				for (int i = 0; i < orderedCities.length; i++) {
					countries[i]="";
					cities[i]="";
					street[i]="";
					name[i]="";
					thisIsWhyWeCantHaveNiceThings=0;
					char[] nastyStuff= orderedCities[i].toCharArray();

					for (int j = 0; j < nastyStuff.length; j++) {
						if(thisIsWhyWeCantHaveNiceThings ==0 && nastyStuff[j]!=';') {
							countries[i]=countries[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==1 && nastyStuff[j]!=';') {
							street[i]=street[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==2 && nastyStuff[j]!=';') {
							cities[i]=cities[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==3 && nastyStuff[j]!=';') {
							name[i]=name[i]+nastyStuff[j];
						}
						if(nastyStuff[j]==';') {
							thisIsWhyWeCantHaveNiceThings=thisIsWhyWeCantHaveNiceThings+1;
						}
					}
				}
				listCountry.setListData(countries);
				listCities.setListData(cities);
				listStreets.setListData(street);
				listClients.setListData(name);

				listCountry.setVisible(false);
				listCountry.setVisible(true);

				listClients.setVisible(false);
				listClients.setVisible(true);

				listStreets.setVisible(false);
				listStreets.setVisible(true);

				listCities.setVisible(false);
				listCities.setVisible(true);
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []orderedCities=myNameIsTim.getNamesOrdered();
				String[] countries=new String [orderedCities.length];
				String[] cities =new String[orderedCities.length];
				String[] street = new String[orderedCities.length];
				String[] name = new String [orderedCities.length];
				int thisIsWhyWeCantHaveNiceThings=0;

				for (int i = 0; i < orderedCities.length; i++) {
					countries[i]="";
					cities[i]="";
					street[i]="";
					name[i]="";
					thisIsWhyWeCantHaveNiceThings=0;
					char[] nastyStuff= orderedCities[i].toCharArray();

					for (int j = 0; j < nastyStuff.length; j++) {
						if(thisIsWhyWeCantHaveNiceThings ==0 && nastyStuff[j]!=';') {
							countries[i]=countries[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==1 && nastyStuff[j]!=';') {
							street[i]=street[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==2 && nastyStuff[j]!=';') {
							cities[i]=cities[i]+nastyStuff[j];
						}
						if(thisIsWhyWeCantHaveNiceThings ==3 && nastyStuff[j]!=';') {
							name[i]=name[i]+nastyStuff[j];
						}
						if(nastyStuff[j]==';') {
							thisIsWhyWeCantHaveNiceThings=thisIsWhyWeCantHaveNiceThings+1;
						}
					}
				}
				listCountry.setListData(countries);
				listCities.setListData(cities);
				listStreets.setListData(street);
				listClients.setListData(name);

				listCountry.setVisible(false);
				listCountry.setVisible(true);

				listClients.setVisible(false);
				listClients.setVisible(true);

				listStreets.setVisible(false);
				listStreets.setVisible(true);

				listCities.setVisible(false);
				listCities.setVisible(true);
			}
		});
		btn1.setBackground(Color.BLACK);
		btn3.setBackground(Color.BLACK);
		btn2.setBackground(Color.BLACK);
		btn4.setBackground(Color.BLACK);
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
		btn3.setBorderPainted(false);
		btn4.setBorderPainted(false);
		btn1.setForeground(Color.GREEN);
		btn2.setForeground(Color.GREEN);
		btn3.setForeground(Color.GREEN);
		btn4.setForeground(Color.GREEN);
		btn1.setText("Order By Country");
		btn2.setText("Order By City");
		btn3.setText("Order By Street");
		btn4.setText("Order By Names");
		btn1.setFont(new Font("consolas",Font.PLAIN,11));
		btn2.setFont(new Font("consolas",Font.PLAIN,11));
		btn3.setFont(new Font("consolas",Font.PLAIN,11));
		btn4.setFont(new Font("consolas",Font.PLAIN,11));
		panel_5.setLayout(new GridLayout(4,1));
		panel_5.add(btn1);
		panel_5.add(btn2);
		panel_5.add(btn3);
		panel_5.add(btn4);
		String[] clientNames=myNameIsTim.getClientId();
		int[] id =new int[clientNames.length];
		for (int i = 0; i < clientNames.length; i++) {
			id[i]=Integer.parseInt(clientNames[i]);
			clientNames[i]=clientNames[i]+":   "+myNameIsTim.getClientFull(Integer.parseInt(clientNames[i])).getName();
		}
		String[] CountryNames=new String[id.length];
		for (int j = 0; j < id.length; j++) {
			CountryNames[j]=myNameIsTim.getAddressFull(myNameIsTim.getAddressIdThruClientId(id[j])).getCountry();
		}
		String[] cityNames=new String[id.length];
		for (int i = 0; i < cityNames.length; i++) {
			cityNames[i]=myNameIsTim.getAddressFull(myNameIsTim.getAddressIdThruClientId(id[i])).getCity();
		}
		String[] streetNames=new String[id.length];
		for (int i = 0; i < streetNames.length; i++) {
			streetNames[i]=myNameIsTim.getAddressFull(myNameIsTim.getAddressIdThruClientId(id[i])).getStreet();
		}
		listClients.setListData(clientNames);
		listCountry.setListData(CountryNames);
		listCities.setListData(cityNames);
		listStreets.setListData(streetNames);
		listClients.setBackground(Color.LIGHT_GRAY);
		listCountry.setBackground(Color.LIGHT_GRAY);
		listCities.setBackground(Color.LIGHT_GRAY);
		listStreets.setBackground(Color.LIGHT_GRAY);
		listClients.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listCountry.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listCities.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		listStreets.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.add(listClients);
		panel_4.add(listCountry);
		panel_4.add(listCities);
		panel_4.add(listStreets);
		panel_2.removeAll();
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panel_3,BorderLayout.NORTH);
		panel_2.add(panel_4,BorderLayout.CENTER);
		panel_2.add(panel_5,BorderLayout.EAST);
		if(admin.getPrivilege().getPrivilege()==2) {
			btn1.setBackground(Color.BLUE);
			btn2.setBackground(Color.BLUE);
			btn3.setBackground(Color.BLUE);
			btn4.setBackground(Color.BLUE);
			panel_3.setBackground(Color.BLUE);
			panel_5.setBackground(Color.BLUE);
			listCities.setBackground(Color.WHITE);
			listClients.setBackground(Color.WHITE);
			listCountry.setBackground(Color.WHITE);
			listStreets.setBackground(Color.WHITE);
			btn1.setForeground(Color.WHITE);
			btn2.setForeground(Color.WHITE);
			btn3.setForeground(Color.WHITE);
			btn4.setForeground(Color.WHITE);
			listCities.setForeground(Color.BLACK);
			listClients.setForeground(Color.BLACK);
			listCountry.setForeground(Color.BLACK);
			listStreets.setForeground(Color.BLACK);
			btn1.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btn2.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btn3.setFont(new Font("Times New Roman",Font.PLAIN,11));
			btn4.setFont(new Font("Times New Roman",Font.PLAIN,11));
			listStreets.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listCities.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listClients.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			listCountry.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
			label.setForeground(Color.WHITE);
			label1.setForeground(Color.WHITE);
			label2.setForeground(Color.WHITE);
			label3.setForeground(Color.WHITE);
			label.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label1.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label2.setFont(new Font("Times New Roman",Font.PLAIN,11));
			label3.setFont(new Font("Times New Roman",Font.PLAIN,11));
		}
		
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_3.setVisible(true);
		panel_2.setVisible(true);
		listClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					char charcmp='D';
					char[]name=listClients.getSelectedValue().toCharArray();
					String id="";
					for(int i=0;	charcmp!=':';	i++) {
						charcmp=name[i];
						if(charcmp!=':') {
							id=id+charcmp;
						}
						User view =new User("default","pass");
						view.setUserType(oz.getStatus(1));
						EditClient c =new EditClient(myNameIsTim,view);
					}
				}
			}
		});
	}

}

