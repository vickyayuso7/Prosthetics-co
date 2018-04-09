package graphicInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import wizard_Handler.WizardHandler;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tables extends JFrame{

	private JFrame frame =new JFrame();
	private JPanel contentPane;
	private static JPanel panel_2;

	/**
	 * Create the application.
	 */
	public Tables(WizardHandler myNameIsTim) {
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
			}
		});
		btnAddresses.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAddresses.setBackground(Color.BLACK);
		btnAddresses.setForeground(Color.GREEN);
		btnAddresses.setBorderPainted(false);
		panel_1.add(btnAddresses);
		
		JButton btnExit = new JButton("Exit");
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
		JList <String> listClients=new <String> JList(myNameIsTim.getClientId());
		listClients.setSelectedIndex(-1);
		JList <String> listProsthetics =new JList();
		JList <String> listPayments =new JList();
		JList <String> listAddresses =new JList();
		listClients.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(listClients.getSelectedIndex()!=-1) {
					int index= Integer.parseInt(listClients.getSelectedValue());
					listProsthetics.setListData(myNameIsTim.magicConversionProstheticsThrouClient(index));
					listProsthetics.setVisible(false);
					listProsthetics.setVisible(true);
					String[] id = new String[1];
					id[0]=""+myNameIsTim.getAddressIdThruClientId(index);
					listAddresses.setListData(id);;
				}
			}
		});
		listClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2) {
					int index = Integer.parseInt(listClients.getSelectedValue());
					EditClient c =new EditClient(myNameIsTim,index);
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
		panel_2.setVisible(false);
		panel_2.setVisible(true);
	}

}
