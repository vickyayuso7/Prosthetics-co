
package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Material;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class EditMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame frame=new JFrame();
	private JTextArea textArea;
	private Material mat;

	/**
	 * Create the frame.
	 */
	public EditMaterial(WizardHandler myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewMaterialInsertion = new JLabel("New Material Insertion");
		lblNewMaterialInsertion.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewMaterialInsertion.setBackground(Color.BLACK);
		lblNewMaterialInsertion.setForeground(Color.GREEN);
		panel.add(lblNewMaterialInsertion);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")|| textField_1.getText().equals("")||textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in the required fields:");
					if(textField.getText().equals("")) {
						textArea.setText(textArea.getText()+"Type Of Material, ");
					}
					if(textField_1.getText().equals("")) {
						textArea.setText(textArea.getText()+"Price, ");
					}
					if(textField_2.getText().equals("")) {
						textArea.setText(textArea.getText()+"provider ");
					}
					textArea.setText(textArea.getText()+"\n");
				}
				else {
					String status="";
					try {
						status = "price must be a number";
						float price = Float.parseFloat(textField_1.getText());
						String provider= textField_2.getText();
						String material = textField.getText();
						mat.setPriceModifier(price);
						mat.setProvider(provider);
						mat.setType(material);
						status="failed material insertion";
						status= myNameIsTim.EditMaterial(mat);
						frame.dispose();
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Something Went Horribly Wrong!\n details in the error tab");
						textArea.setText(textArea.getText()+status);
					}
				}
			}
		});
		btnOk.setBackground(Color.BLACK);
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOk.setForeground(Color.GREEN);
		btnOk.setBorderPainted(false);
		panel_1.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCancel.setBorderPainted(false);
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[][grow][][grow][grow]", "[][][grow][][grow][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Type Of Material:");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel_2.add(lblNewLabel, "cell 3 1,alignx center,aligny center");
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_2.add(textField, "cell 4 1,alignx left");
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_2.add(panel_4, "cell 0 2 5 1,growx,aligny center");
		
		JLabel lblChoose = new JLabel("choose:");
		panel_2.add(lblChoose, "cell 0 3,alignx trailing");
		String[] materialIds = myNameIsTim.getMaterialId();
		JComboBox comboBox = new JComboBox(materialIds);
		panel_2.add(comboBox, "cell 1 3,growx");
		
		JButton btnSignMeUp = new JButton("Sign me up Fam");
		btnSignMeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==-1) {
					textArea.setText("select something you fool!");
				}
				else {
					int id = Integer.parseInt(materialIds[comboBox.getSelectedIndex()]);
					mat=myNameIsTim.getMaterialFull(id);
					textField.setText(mat.getType());
					textField.setEditable(true);
					textField_1.setText(""+mat.getPriceModifier());
					textField_1.setEditable(true);
					textField_2.setText(mat.getProvider());
					textField_2.setEditable(true);
				}
			}
		});
		btnSignMeUp.setForeground(Color.GREEN);
		btnSignMeUp.setBackground(Color.BLACK);
		panel_2.add(btnSignMeUp, "cell 2 3");
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel_2.add(lblPrice, "cell 3 3,alignx center");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_2.add(textField_1, "cell 4 3,alignx left");
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_2.add(panel_3, "cell 0 4 5 1,growx,aligny center");
		
		JLabel lblProvider = new JLabel("Provider:\r\n");
		lblProvider.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel_2.add(lblProvider, "cell 3 5,alignx center");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_2.add(textField_2, "cell 4 5,alignx left");
		textField_2.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut, "cell 3 6");
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		textArea.setForeground(Color.GREEN);
		textArea.setRows(5);
		textArea.setBackground(Color.BLACK);
		textArea.setText("Warnings / Comments / Errors:\n");
		panel_2.add(textArea, "cell 0 7 5 1,grow");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1, "cell 3 8");
		frame.add(contentPane);
		frame.setVisible(true);
	}

}
