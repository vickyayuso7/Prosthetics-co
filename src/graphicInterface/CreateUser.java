package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;
import wizard_Handler.WizardHandlerJPA;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int id;
	private JFrame frame=new JFrame();
	private WizardHandlerJPA myNameIsTim=new WizardHandlerJPA();
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewUserInsertion = new JLabel("New User Insertion");
		lblNewUserInsertion.setForeground(Color.GREEN);
		panel.add(lblNewUserInsertion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][grow][grow]", "[][][][][][][][]"));
		
		JLabel lblUser = new JLabel("Username:");
		panel_1.add(lblUser, "cell 3 1,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 4 1,alignx left");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel_1.add(lblPassword, "cell 3 3,alignx trailing");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 4 3,alignx left");
		textField_1.setColumns(10);
		
		JLabel lblVerifyPassword = new JLabel("Verify Password:");
		panel_1.add(lblVerifyPassword, "cell 3 5,alignx trailing");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 4 5,alignx left");
		textField_2.setColumns(10);
		Privilege[] pr=new Privilege[3];
		Iterator <Privilege> it=myNameIsTim.getPrivilege().iterator();
		for(int i=0;it.hasNext();i++) {
			pr[i]=it.next();
			//weird casting error
		}
		String[] privilege=new String[pr.length];
		privilege[0]=pr[0].getPrivilege()+":Pleb User";
		privilege[1]=pr[1].getPrivilege()+": Evil Overlord";
		privilege[2]=pr[2].getPrivilege()+": Acustic Auditor";
		JComboBox comboBox = new JComboBox(privilege);
		panel_1.add(comboBox, "cell 3 7,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setForeground(Color.GREEN);
		btnOk.setBackground(Color.BLACK);
		panel_2.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals("") ||textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"No empty fields allowed");
				}
				else {
					if(!textField_1.getText().equals(textField_2.getText())) {
						JOptionPane.showMessageDialog(null,"Passwords must match!");
					}
					else {
						User us=new User();
						Privilege pr =myNameIsTim.getStatus(comboBox.getSelectedIndex());
						us.setName(textField.getText());
						us.setPassword(textField_1.getText());
						us.setUserType(pr);
						pr.setUser(us);
						us=myNameIsTim.newUser(us);
						myNameIsTim.EditPrivilege(pr);
						setId(us.getId());
						frame.dispose();
					}
				}
			}
		});
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setBackground(Color.BLACK);
		panel_2.add(btnCancel);
		frame.getContentPane().add((contentPane));
		frame.setVisible(false);
		frame.setVisible(true);
		
	}
	public int getid() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}

}
