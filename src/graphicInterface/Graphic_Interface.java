package graphicInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import wizard_Handler.*;
import javax.swing.*;
//guts.close must be activated
public class Graphic_Interface extends JFrame{
	private boolean tablesCreated=false;
	private JFrame frame=new JFrame();
	private int warnings=3;
	private WizardHandler guts;
	JPanel panel_1 = new JPanel();
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	//set the boolean back to admin
	public Graphic_Interface (boolean admin) {
		admin=true;
		if(admin==true) {
			initialize();
		}
		else {
			JOptionPane.showMessageDialog(null, "Not implemented yet");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		//window.frame.setVisible(true);
		guts=new WizardHandler();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoadTables = new JMenuItem("Reload Tables");
		mntmLoadTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str =guts.reloadTables();
				if(str.equals("failed")) {
					JOptionPane.showMessageDialog(null, "Something Went Terribly Wrong! I guess you just wanted some love and I couldn't comply...\n I'm sorry: as a small compensation here is a fragment of the necronomicon:\nThat is not dead which can eternal lie,\r\n" + 
							" And with strange aeons even death may die ");
				}
			}
		});
		mnFile.add(mntmLoadTables);
		
		JMenuItem mntmCreateTables = new JMenuItem("Create Tables");
		mntmCreateTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String srt= guts.createTables();
					if(srt.equals("Failed")) {
						JOptionPane.showMessageDialog(null, "Tables Are Created. I guess you just wanted some love and I couldn't comply...\n I'm sorry: as a small compensation here is a fragment of the necronomicon:\n2 The Old Ones were, the Old Ones are, and the Old Ones shall be. 3 Not in the spaces we know, but between them, They walk serene and primal, undimensioned and to us unseen. ");
					}
			}
		});
		mnFile.add(mntmCreateTables);
		
		JMenuItem mntmDeleteTables = new JMenuItem("Delete Tables");
		mntmDeleteTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guts.deleteTables();
			}
		});
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
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridLayout gbl_panel = new GridLayout(6,1);
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_1 = new JButton("Insert New...");
		btnNewButton_1.setBackground(new Color(0,0,0));
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Edit Existent...");
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setBackground(new Color(0,0,0));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFont(new Font("Consolas", Font.PLAIN, 11));
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
		
		JButton btnNewButton_2 = new JButton("Remove Existent...");
		btnNewButton_2.setForeground(Color.GREEN);
		btnNewButton_2.setBackground(new Color(0,0,0));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("Consolas", Font.PLAIN, 11));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		
		JButton btnNewButton_3 = new JButton("View Existent...");
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.setBackground(new Color(0,0,0));
		btnNewButton_3.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_3.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Exit");
		btnNewButton_5.setForeground(Color.GREEN);
		btnNewButton_5.setBackground(new Color(0,0,0));
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guts.appClosed();
				frame.dispose();
			}
		});
		btnNewButton_5.setText("exit");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 0;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	
	public void NewEntryOneTable () {
				panel_1.removeAll();
				panel_1.setVisible(false);
				panel_1.setLayout(new GridLayout(7,3));
				JPanel panel1=new JPanel();
				JPanel panel2=new JPanel();
				JPanel panel3=new JPanel();
				JPanel panel4=new JPanel();
				JPanel panel5=new JPanel();
				JPanel panel6=new JPanel();
				JPanel panel7=new JPanel();
				JPanel panel8=new JPanel();
				JPanel panel9=new JPanel();
				JPanel panel10=new JPanel();
				JPanel panel11=new JPanel();
				JPanel panel12=new JPanel();
				JPanel panel13=new JPanel();
				JPanel panel14=new JPanel();
				JPanel panel15=new JPanel();
				JPanel panel16=new JPanel();
				JPanel panel17=new JPanel();
				JPanel panel18=new JPanel();
				
				panel1.setBackground(new Color(255,255,255));
				panel2.setBackground(new Color(255,255,255));
				panel3.setBackground(new Color(255,255,255));
				panel4.setBackground(new Color(255,255,255));
				panel5.setBackground(new Color(255,255,255));
				panel6.setBackground(new Color(255,255,255));
				panel7.setBackground(new Color(255,255,255));
				panel8.setBackground(new Color(255,255,255));
				panel9.setBackground(new Color(255,255,255));
				panel10.setBackground(new Color(255,255,255));
				panel11.setBackground(new Color(255,255,255));
				panel12.setBackground(new Color(255,255,255));
				panel13.setBackground(new Color(255,255,255));
				panel14.setBackground(new Color(255,255,255));
				panel15.setBackground(new Color(255,255,255));
				panel16.setBackground(new Color(255,255,255));
				panel17.setBackground(new Color(255,255,255));
				panel18.setBackground(new Color(255,255,255));
				
				JButton newCln= new JButton();
				newCln.setText("Edit Client");
				newCln.setForeground(Color.GREEN);
				newCln.setFont(new Font("Consolas", Font.PLAIN, 11));
				newCln.setBackground(new Color(0,0,0));
				newCln.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						
						}
						catch(Exception ex) {
							ex.printStackTrace();
							try {
								String str = guts.createTables();
								if(str.equals("failed")) {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
								}
								else {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
								}
								
							}
							catch(Exception exc) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
						}
					}
				});
				JButton newFtr= new JButton();
				newFtr.setText("Edit Feature");
				newFtr.setForeground(Color.GREEN);
				newFtr.setFont(new Font("Consolas", Font.PLAIN, 11));
				newFtr.setBackground(new Color(0,0,0));
				newFtr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							EditFeatures f= new EditFeatures(guts);
						}
						catch(Exception ex) {
							ex.printStackTrace();
							try {
								String str = guts.createTables();
								if(str.equals("failed")) {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
								}
								else {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
								}
								
							}
							catch(Exception exc) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
						}
					}
				});
				JButton newMat= new JButton();
				newMat.setText("Edit Material");
				newMat.setBackground(new Color(0,0,0));
				newMat.setForeground(Color.GREEN);
				newMat.setFont(new Font("Consolas", Font.PLAIN, 11));
				newMat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
						}
						catch(Exception ex) {
							ex.printStackTrace();
							try {
								String str = guts.createTables();
								if(str.equals("failed")) {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
								}
								else {
									JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
								}
								
							}
							catch(Exception exc) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
						}
					}
				});
				
				panel_1.add(panel1);
				panel_1.add(panel2);
				panel_1.add(panel3);
				panel_1.add(panel4);
				panel_1.add(newCln);
				panel_1.add(panel5);
				panel_1.add(panel6);
				panel_1.add(panel7);
				panel_1.add(panel8);
				panel_1.add(panel9);
				panel_1.add(newFtr);
				panel_1.add(panel10);
				panel_1.add(panel11);
				panel_1.add(panel12);
				panel_1.add(panel13);
				panel_1.add(panel14);
				panel_1.add(newMat);
				panel_1.add(panel15);
				panel_1.add(panel16);
				panel_1.add(panel17);
				panel_1.add(panel18);
				
				panel_1.setVisible(true);
				panel1.setVisible(true);
				panel2.setVisible(true);
				panel3.setVisible(true);
				panel4.setVisible(true);
				panel5.setVisible(true);
				panel6.setVisible(true);
				panel7.setVisible(true);
				panel8.setVisible(true);
				panel9.setVisible(true);
				panel10.setVisible(true);
				panel11.setVisible(true);
				panel12.setVisible(true);
				panel13.setVisible(true);
				panel14.setVisible(true);
				panel15.setVisible(true);
				newCln.setVisible(true);
				newFtr.setVisible(true);
				newMat.setVisible(true);
				
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
	public void New() {
		//if(this.tablesCreated==true) {
			panel_1.removeAll();
			panel_1.validate();
			panel_1.setVisible(false);
			panel_1.setLayout(new GridLayout(7,3));
			JPanel panel1=new JPanel();
			JPanel panel2=new JPanel();
			JPanel panel3=new JPanel();
			JPanel panel4=new JPanel();
			JPanel panel5=new JPanel();
			JPanel panel6=new JPanel();
			JPanel panel7=new JPanel();
			JPanel panel8=new JPanel();
			JPanel panel9=new JPanel();
			JPanel panel10=new JPanel();
			JPanel panel11=new JPanel();
			JPanel panel12=new JPanel();
			JPanel panel13=new JPanel();
			JPanel panel14=new JPanel();
			JPanel panel15=new JPanel();
			JPanel panel16=new JPanel();
			JPanel panel17=new JPanel();
			JPanel panel18=new JPanel();
			
			panel1.setBackground(new Color(255,255,255));
			panel2.setBackground(new Color(255,255,255));
			panel3.setBackground(new Color(255,255,255));
			panel4.setBackground(new Color(255,255,255));
			panel5.setBackground(new Color(255,255,255));
			panel6.setBackground(new Color(255,255,255));
			panel7.setBackground(new Color(255,255,255));
			panel8.setBackground(new Color(255,255,255));
			panel9.setBackground(new Color(255,255,255));
			panel10.setBackground(new Color(255,255,255));
			panel11.setBackground(new Color(255,255,255));
			panel12.setBackground(new Color(255,255,255));
			panel13.setBackground(new Color(255,255,255));
			panel14.setBackground(new Color(255,255,255));
			panel15.setBackground(new Color(255,255,255));
			panel16.setBackground(new Color(255,255,255));
			panel17.setBackground(new Color(255,255,255));
			panel18.setBackground(new Color(255,255,255));
			
			JButton newCln= new JButton();
			newCln.setText("New Client");
			newCln.setBackground(new Color(0,0,0));
			newCln.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						CreateANDModify m= new CreateANDModify(guts);
					}
					catch(Exception ex) {
						ex.printStackTrace();
						try {
							String str = guts.createTables();
							if(str.equals("failed")) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
							else {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
							}
							
						}
						catch(Exception exc) {
							JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
						}
					}
				}
			});
			JButton newFtr= new JButton();
			newFtr.setText("New Feature");
			newFtr.setBackground(new Color(0,0,0));
			newFtr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						NewFeatures f= new NewFeatures(guts);
					}
					catch(Exception ex) {
						ex.printStackTrace();
						try {
							String str = guts.createTables();
							if(str.equals("failed")) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
							else {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
							}
							
						}
						catch(Exception exc) {
							JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
						}
					}
					
				}
			});
			JButton newMat= new JButton();
			newMat.setText("New Material");
			newMat.setBackground(new Color(0,0,0));
			newMat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						NewMaterial mat= new NewMaterial(guts);
					}
					catch(Exception ex) {
						ex.printStackTrace();
						try {
							String str = guts.createTables();
							if(str.equals("failed")) {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
							}
							else {
								JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard: np fam, Ash nazg durbatulūk, ash nazg gimbatul, ash nazg thrakatulūk, agh burzum-ishi krimpatul");
							}
							
						}
						catch(Exception exc) {
							JOptionPane.showMessageDialog(null, " -Program: DataBase not created, Wizard u got this dude?\n-Wizard:np brah, YOU SHALL NOT PASS!\n*falls into pit of darkness and dies anticlimatically\n anyhow, your tables are fucked fix em up before continiung");
						}
					}
				}
			});
			
			panel_1.add(panel1);
			panel_1.add(panel2);
			panel_1.add(panel3);
			panel_1.add(panel4);
			panel_1.add(newCln);
			panel_1.add(panel5);
			panel_1.add(panel6);
			panel_1.add(panel7);
			panel_1.add(panel8);
			panel_1.add(panel9);
			panel_1.add(newFtr);
			panel_1.add(panel10);
			panel_1.add(panel11);
			panel_1.add(panel12);
			panel_1.add(panel13);
			panel_1.add(panel14);
			panel_1.add(newMat);
			panel_1.add(panel15);
			panel_1.add(panel16);
			panel_1.add(panel17);
			panel_1.add(panel18);
			
			panel_1.setVisible(true);
			panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			panel4.setVisible(true);
			panel5.setVisible(true);
			panel6.setVisible(true);
			panel7.setVisible(true);
			panel8.setVisible(true);
			panel9.setVisible(true);
			panel10.setVisible(true);
			panel11.setVisible(true);
			panel12.setVisible(true);
			panel13.setVisible(true);
			panel14.setVisible(true);
			panel15.setVisible(true);
			newCln.setVisible(true);
			newFtr.setVisible(true);
			newMat.setVisible(true);
			
			newCln.setForeground(new Color(0,255,0));
			newFtr.setForeground(new Color(0,255,0));
			newMat.setForeground(new Color(0,255,0));
			
			newCln.setFont(new Font("Consolas", Font.PLAIN, 11));
			newFtr.setFont(new Font("Consolas", Font.PLAIN, 11));
			newMat.setFont(new Font("Consolas", Font.PLAIN, 11));
			
		//}
	}
}

