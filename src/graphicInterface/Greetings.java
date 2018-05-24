package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.User;
import wizard_Handler.WizardHandler;
import wizard_Handler.WizardHandlerJPA;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import wizard_Handler.WizardHandlerJPA;
public class Greetings extends JFrame {

	private JPanel contentPane;
	private JLabel txtUser;
	private JTextField textField;
	private JLabel txtPassword;
	private JPasswordField passwordField;
	private WizardHandlerJPA oz;
	int admin;

	public Greetings() {
		admin = 0;
		oz = new WizardHandlerJPA();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel txtrGreetingsPleaseLog = new JLabel();
		txtrGreetingsPleaseLog.setForeground(Color.WHITE);
		txtrGreetingsPleaseLog.setBackground(Color.BLUE);
		txtrGreetingsPleaseLog.setText("Greetings: Please log in.");
		panel.add(txtrGreetingsPleaseLog);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[90px][86px,grow][80px,grow][86px]", "[20px][][][][grow][][]"));

		txtUser = new JLabel();
		txtUser.setBackground(Color.WHITE);
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtUser.setBorder(null);
		txtUser.setText("User:");
		panel_1.add(txtUser, "cell 1 2,alignx left,aligny center");

		textField = new JTextField();
		panel_1.add(textField, "cell 2 2,growx,aligny top");
		textField.setColumns(10);
		textField.setEditable(true);

		txtPassword = new JLabel();
		txtPassword.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBorder(null);
		txtPassword.setText("Password:");
		panel_1.add(txtPassword, "cell 1 3,alignx left,aligny center");

		passwordField = new JPasswordField();
		panel_1.add(passwordField, "cell 2 3,growx");
		passwordField.setEditable(true);
		String options[] = { "Pleb User", "Evil Overlord", "Auditor" };
		JComboBox comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0);
		panel_1.add(comboBox, "cell 1 4 2 1,growx");
		JButton btnOk = new JButton("Ok");

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = new String(passwordField.getPassword());
				//System.out.println(comboBox.getSelectedIndex() + "	" + str + "		" + textField.getText());
				//System.out.println((String) comboBox.getSelectedItem() + "privilege level");
				if (((String) comboBox.getSelectedItem()).equals("Pleb User")) {
					admin = 0;
				}
				if (((String) comboBox.getSelectedItem()).equals("Evil Overlord")) {
					admin = 1;
				}
				if (((String) comboBox.getSelectedItem()).equals("Auditor")) {
					admin = 2;
				}
				String usr;
				String psw;
				User[] users = oz.getUser().toArray(new User[1]);
				User logged = null;
				boolean found = false;
				for (int i = 0; i < users.length; i++) {
					//System.out.println(users[i]);
					usr = users[i].getName();
					psw = users[i].getPassword();
					if (usr.equals(textField.getText()) && psw.equals(str)) {
						found = true;
						logged = users[i];
						break;
					}
				}
				if (found) {
					Graphic_Interface g = new Graphic_Interface(oz, logged);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Password or username");
					System.out.println(str + "   " + textField.getText());
				}

			}
		});
		panel_1.add(btnOk, "cell 2 6,growx");

	}

	static Greetings frame = null;

	public static void main(String[] args) {
		WizardHandler dirtySolution = null;
		try {
			dirtySolution = new WizardHandler();
			dirtySolution.createTables();
		} catch (Exception e) {
			System.out.println("Tables already there, you know.");
		} finally {
			dirtySolution.appClosed();

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new Greetings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
