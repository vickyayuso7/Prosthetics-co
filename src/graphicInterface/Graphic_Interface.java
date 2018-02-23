package graphicInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Graphic_Interface extends JFrame{
	private boolean tablesCreated=false;
	private JFrame frame;
	private boolean displayed_new_element=false;
	private int warnings=3;
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
		//frame.setBounds(100, 100, 450, 300);
		//frame.setSize(frame.getMaximumSize());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
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
		GridLayout gbl_panel = new GridLayout(6,1);
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_1 = new JButton("New Client");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Add New Element");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEntryOneTable();
			}
		});
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
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
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
		btnNewButton_5.setText("exit");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 0;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}
	/*Requires specifying the fields of each JTextField. Aside from that remember to change the visibility of tthe buttons and textfields to false in 
	 * the field is visible when the function is terminated. */
	public void NewEntryOneTable () {
		if(this.tablesCreated==true) {
			if (this.displayed_new_element==false) {
				panel_1.setVisible(false);
				GridLayout Createnewtype = new GridLayout(6,4);
				panel_1.setLayout(Createnewtype);
				JPanel filler= new JPanel();
				JPanel filler2= new JPanel();
				JPanel filler3= new JPanel();
				JPanel filler4= new JPanel();
				JPanel filler5= new JPanel();
				JPanel filler6= new JPanel();
				JPanel filler7= new JPanel();
				JPanel filler8= new JPanel();
				JPanel filler9= new JPanel();
				JPanel filler10= new JPanel();
				JPanel filler11= new JPanel();
				JPanel filler12= new JPanel();
				
				filler.setBackground(new Color(255, 255, 255));
				filler2.setBackground(new Color(255, 255, 255));
				filler3.setBackground(new Color(255, 255, 255));
				filler4.setBackground(new Color(255, 255, 255));
				filler5.setBackground(new Color(255, 255, 255));
				filler6.setBackground(new Color(255, 255, 255));
				filler7.setBackground(new Color(255, 255, 255));
				filler8.setBackground(new Color(255, 255, 255));
				filler9.setBackground(new Color(255, 255, 255));
				filler10.setBackground(new Color(255, 255, 255));
				filler11.setBackground(new Color(255, 255, 255));
				filler12.setBackground(new Color(255, 255, 255));
				
				panel_1.add(filler);
				JButton prs= new JButton();
				prs.setText("New Entry (Prosthetics)");
				JTextArea cln =new JTextArea();
				prs.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						cln.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						cln.setVisible(false);
					}
				});
				panel_1.add(prs);
				
				cln.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing PROSTHETIC table. (fields)");
				panel_1.add(cln);
				panel_1.add(filler2);
				panel_1.add(filler7);
				JButton ad= new JButton();
				ad.setText("New Entry (Client)");
				panel_1.add(ad);
				JTextArea add=new JTextArea();
				ad.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						add.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						add.setVisible(false);
					}
				});
				add.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing CLIENT table. (fields)");
				panel_1.add(add);
				panel_1.add(filler3);
				panel_1.add(filler8);
				JButton pay =new JButton();
				pay.setText("New Entry (Payment)");
				panel_1.add(pay);
				JTextArea paym =new JTextArea();
				pay.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						paym.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						paym.setVisible(false);
					}
				});
				paym.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing PAYMENT table. (fields)");
				panel_1.add(paym);
				panel_1.add(filler4);
				panel_1.add(filler9);
				JButton Ft =new JButton();
				Ft.setText("New Entry (Features)");
				panel_1.add(Ft);
				JTextArea Feat = new JTextArea();
				Feat.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing FEATURE table. (fields)");
				Ft.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						Feat.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						Feat.setVisible(false);
					}
				});
				panel_1.add(Feat);
				panel_1.add(filler5);
				panel_1.add(filler10);
				JButton mat= new JButton();
				mat.setText("New Entry (Materials)");
				JTextArea mt= new JTextArea();
				mt.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing MATERIAL table. (fields)");
				panel_1.add(mat);
				panel_1.add(mt);
				mat.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						mt.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						mt.setVisible(false);
					}
				});
				panel_1.add(filler6);
				panel_1.add(filler11);
				JButton Adr= new JButton();
				Adr.setText("New Entry (Address)");
				panel_1.add(Adr);
				JTextArea adr =new JTextArea();
				adr.setText("\n\n\nPops up a window where a new entry may\nbe added to the existing ADDRESS table. (fields)");
				Adr.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						adr.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						adr.setVisible(false);
					}
				});
				panel_1.add(adr);
				panel_1.add(filler12);
				cln.setVisible(false);
				add.setVisible(false);
				paym.setVisible(false);
				Feat.setVisible(false);
				mt.setVisible(false);
				adr.setVisible(false);
				panel_1.setVisible(true);
				this.displayed_new_element=true;
			}
		}
		else {
			if(warnings>0) {
				warnings=warnings-1;
				JOptionPane.showMessageDialog(null, "For the love of chin chin can you please stop trying to break my f*cking program?\nMuch apreciated. Try opening the tables"
						+ " or how about creating them, you dim witted stump?\n"+this.warnings+" warinings left");
			}
			else {
				JOptionPane.showMessageDialog(null, "you tried to blow up my program, now im gonna blow up your prostate!");
				this.inmolationProtocol();
			}
		}
	}
	private void inmolationProtocol() {
		int i=0;
		Random randomGenerator = new Random();
		while(i>-1) {
			JFrame XD =new JFrame();
			int rand1=randomGenerator.nextInt(255);
			int rand2=randomGenerator.nextInt(255);
			int rand3=randomGenerator.nextInt(255);
			XD.setBackground(new Color(rand1,rand2,rand3));
			XD.setVisible(true);
			XD.setTitle("Repent You heretic Scum!");
			XD.setSize(XD.getMaximumSize());
			i=i+1;
			if(i==100) {
				int choice= JOptionPane.showOptionDialog(null, "Wow, that was spastic... Do you repent or do you wish it to continue?", "mercy",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(choice==JOptionPane.YES_NO_OPTION) {
					i=-1;
					XD.dispose();
				}
			}
		}
	}
}
