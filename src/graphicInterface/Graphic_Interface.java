package graphicInterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Graphic_Interface extends JFrame{
	private boolean tablesCreated=false;
	private JFrame frame;
	JPanel panel_1 = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphic_Interface window = new Graphic_Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Graphic_Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoadTables = new JMenuItem("Load Tables");
		mnFile.add(mntmLoadTables);
		
		JMenuItem mntmCreateTables = new JMenuItem("Create Tables");
		mnFile.add(mntmCreateTables);
		
		JMenuItem mntmDeleteTables = new JMenuItem("Delete Tables");
		mnFile.add(mntmDeleteTables);
		
		JMenuItem mntmSaveAllChanges = new JMenuItem("Save All Changes");
		mnFile.add(mntmSaveAllChanges);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenu mnShowTables = new JMenu("show Tables");
		mnView.add(mnShowTables);
		
		JMenuItem mntmAll = new JMenuItem("All");
		mnShowTables.add(mntmAll);
		
		JMenuItem mntmProsthetics = new JMenuItem("Prosthetics");
		mnShowTables.add(mntmProsthetics);
		
		JMenuItem mntmClient = new JMenuItem("Client");
		mnShowTables.add(mntmClient);
		
		JMenuItem mntmPayment = new JMenuItem("Payment");
		mnShowTables.add(mntmPayment);
		
		JMenuItem mntmFeatures = new JMenuItem("Features");
		mnShowTables.add(mntmFeatures);
		
		JMenuItem mntmMaterials = new JMenuItem("Materials");
		mnShowTables.add(mntmMaterials);
		
		JMenuItem mntmAdress = new JMenuItem("Adress");
		mnShowTables.add(mntmAdress);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnView.add(mntmAbout);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmProsthetics_1 = new JMenuItem("Prosthetics");
		mnEdit.add(mntmProsthetics_1);
		
		JMenuItem mntmClient_1 = new JMenuItem("Client");
		mnEdit.add(mntmClient_1);
		
		JMenuItem mntmPayment_1 = new JMenuItem("Payment");
		mnEdit.add(mntmPayment_1);
		
		JMenuItem mntmFeatures_1 = new JMenuItem("Features");
		mnEdit.add(mntmFeatures_1);
		
		JMenuItem mntmMaterial = new JMenuItem("Material");
		mnEdit.add(mntmMaterial);
		
		JMenuItem mntmAdress_1 = new JMenuItem("Adress");
		mnEdit.add(mntmAdress_1);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(100, 10));
		panel.setBackground(new Color(0, 0, 204));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_1 = new JButton("New Client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEntryOneTable();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Add New Element");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 2;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Update Element");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Element");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton = new JButton("Show:");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}
	/*Requires specifying the fields of each JTextField. Aside from that remember to change the visibility of tthe buttons and textfields to false in 
	 * the field is visible when the function is terminated. */
	public void NewEntryOneTable () {
		//if(this.tablesCreated==true) {
			panel_1.setVisible(false);
			GridLayout Createnewtype = new GridLayout(6,2);
			panel_1.setLayout(Createnewtype);
			JButton prs= new JButton();
			prs.setText("New Entry (Prosthetics)");
			panel_1.add(prs);
			JTextField cln =new JTextField();
			cln.setText("Pops up a window where a new entry may be added to the existing PROSTHETIC table. (fields)");
			panel_1.add(cln);
			JButton ad= new JButton();
			ad.setText("New Entry (Client)");
			panel_1.add(ad);
			JTextField add=new JTextField();
			add.setText("Pops up a window where a new entry may be added to the existing CLIENT table. (fields)");
			panel_1.add(add);
			JButton pay =new JButton();
			pay.setText("New Entry (Payment)");
			panel_1.add(pay);
			JTextField paym =new JTextField();
			paym.setText("Pops up a window where a new entry may be added to the existing PAYMENT table. (fields)");
			panel_1.add(paym);
			JButton Ft =new JButton();
			Ft.setText("New Entry (Features)");
			panel_1.add(Ft);
			JTextField Feat = new JTextField();
			Feat.setText("Pops up a window where a new entry may be added to the existing FEATURE table. (fields)");
			panel_1.add(Feat);
			JButton mat= new JButton();
			mat.setText("New Entry (Materials)");
			JTextField mt= new JTextField();
			mt.setText("Pops up a window where a new entry may be added to the existing MATERIAL table. (fields)");
			panel_1.add(mat);
			panel_1.add(mt);
			JButton Adr= new JButton();
			Adr.setText("New Entry (Address)");
			panel_1.add(Adr);
			JTextField adr =new JTextField();
			adr.setText("Pops up a window where a new entry may be added to the existing ADDRESS table. (fields)");
			panel_1.add(adr);
			panel_1.setVisible(true);
		//}
	}
}
