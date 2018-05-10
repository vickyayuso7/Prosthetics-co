package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import net.miginfocom.swing.MigLayout;
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
	private JTextField txtUser;
	private JTextField textField;
	private JTextField txtPassword;
	private JPasswordField passwordField;
	int admin;

	public Greetings() {
		admin = 0;
		//WizardHandlerJPA dumbleBore = new WizardHandlerJPA();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, BorderLayout.NORTH);

		JTextArea txtrGreetingsPleaseLog = new JTextArea();
		txtrGreetingsPleaseLog.setForeground(Color.WHITE);
		txtrGreetingsPleaseLog.setBackground(Color.BLUE);
		txtrGreetingsPleaseLog.setText("Greetings: Please log in.");
		panel.add(txtrGreetingsPleaseLog);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[90px][86px,grow][80px,grow][86px]", "[20px][][][][grow][][]"));

		txtUser = new JTextField();
		txtUser.setBackground(Color.WHITE);
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtUser.setEditable(false);
		txtUser.setBorder(null);
		txtUser.setText("User:");
		panel_1.add(txtUser, "cell 1 2,alignx left,aligny center");
		txtUser.setColumns(10);

		textField = new JTextField();
		panel_1.add(textField, "cell 2 2,growx,aligny top");
		textField.setColumns(10);
		textField.setEditable(true);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setEditable(false);
		txtPassword.setBorder(null);
		txtPassword.setText("Password:");
		panel_1.add(txtPassword, "cell 1 3,alignx left,aligny center");
		txtPassword.setColumns(10);

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
				System.out.println(comboBox.getSelectedIndex() + "	" + str + "		" + textField.getText());
				Graphic_Interface g = new Graphic_Interface(1);
				frame.dispose();
			}
		});
		panel_1.add(btnOk, "cell 2 6,growx");

	}
	static Greetings frame = null;
	public static void main(String[] args) {
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
