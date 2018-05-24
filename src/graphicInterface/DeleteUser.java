package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import pojos.db.prosthetics.User;
import wizard_Handler.WizardHandlerJPA;

public class DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame =new JFrame();
	static int id;
	private JList<String> list;


	public DeleteUser(WizardHandlerJPA myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.add(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblDeleteProsthetic = new JLabel("Delete User:");
		lblDeleteProsthetic.setForeground(Color.GREEN);
		lblDeleteProsthetic.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel.add(lblDeleteProsthetic);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("paso con un selected Index ="+list.getSelectedIndex());
				if(list.getSelectedIndex()!=-1) {
					List <User> userList =myNameIsTim.getUser();
					Iterator it =userList.iterator();
					System.out.println(it.hasNext());
					User user =new User();
					id=Integer.parseInt(textField.getText());
					while(it.hasNext()) {
						user =(User)it.next();
						System.out.println(user+"		"+id);
						if(user.getId()==id) {
							try {
								System.out.println("paso por deleteUser try myNameIsTim.deleteUser");
								myNameIsTim.deleteUser(user);
								
								frame.dispose();
							}catch(Exception ex) {
								ex.printStackTrace();
								JOptionPane.showMessageDialog(null,"Failed User deletion");
							}
							break;
						}
					}

				}else {
					JOptionPane.showMessageDialog(null,"Select Something!");
				}
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.BLACK);
		panel_1.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setBackground(Color.BLACK);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 0));

		list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String text="";
				char[] id=list.getSelectedValue().toCharArray();
				int counter=0;
				boolean found=false;
				for (int i = 0; i < list.getSelectedValue().toCharArray().length; i++) {
					if(id[i]==':') {
						found=true;
					}
					if(found && id[i]==' ') {
						counter=counter+1;
					}
					if(counter ==3 && id[i]!=' ') {
						text=text+id[i];
					}
				}
				textField.setText(text);
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setBackground(Color.LIGHT_GRAY);
		panel_2.add(list);
		User[] users;
		String[] usernames;
		users=myNameIsTim.getUser().toArray(new User[1]);
		usernames=new String[users.length];
		for (int i = 0; i < users.length; i++) {
			usernames[i]=users[i].getName()+":   "+users[i].getId();
		}
		list.setListData(usernames);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[][grow]", "[]"));

		textField = new JTextField();
		panel_3.add(textField, "flowx,cell 1 0,alignx left");
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search:");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean foundEscapeChar=false;
				boolean found=false;
				int counter=0;
				String candidate;
				User[]userList=myNameIsTim.getUser().toArray(new User[1]);
				for (int i = 0; i < userList.length; i++) {
					candidate="";
					foundEscapeChar=false;
					counter=0;
					list.setSelectedIndex(i);
					char[]name=((String) list.getSelectedValue()).toCharArray();
					for (int j = 0; j < name.length-1; j++) {
						if(name[j]==':') {
							foundEscapeChar=true;
						}
						if(foundEscapeChar && name[j]==' ') {
							counter=counter+1;
						}
						if(counter>=3) {
							candidate=candidate+name[j+1];
						}
					}
					if(textField.getText().equals(candidate)) {
						list.setSelectedIndex(i);
						found =true;
						id=Integer.parseInt(candidate);
						break;
					}
				}

			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setBackground(Color.BLACK);
		panel_3.add(btnSearch, "cell 1 0");
		frame.setVisible(true);
	}

}
