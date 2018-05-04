package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteProsthetic extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame =new JFrame();
	int id;
	private JButton btnView;

	public DeleteProsthetic(WizardHandler myNameIsTim) {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.add(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblDeleteProsthetic = new JLabel("Delete Prosthetic:");
		lblDeleteProsthetic.setForeground(Color.GREEN);
		lblDeleteProsthetic.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel.add(lblDeleteProsthetic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnView.isEnabled()) {
					String report=myNameIsTim.deleteProsthetic(myNameIsTim.getProstheticFull(Integer.parseInt(textField.getText())));
					if(report.equals("success")) {
						frame.dispose();
					}
					else {
						JOptionPane.showInputDialog(null, "Could not find requested prosthetic", JOptionPane.ERROR_MESSAGE);
					}
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 0));
		
		JList<String> list = new JList<String>();
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
				btnView.setEnabled(true);
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setBackground(Color.LIGHT_GRAY);
		panel_2.add(list);
		String[] prosthetics;
		prosthetics=myNameIsTim.getProstheticsId();
		for (int i = 0; i < prosthetics.length; i++) {
			prosthetics[i]="Prosthetic:   "+prosthetics[i];
		}
		list.setListData(prosthetics);
		
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
				String[] candidates = myNameIsTim.getProstheticsId();
				for (int i = 0; i < prosthetics.length; i++) {
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
						btnView.setEnabled(true);
						break;
					}
				}
				
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setBackground(Color.BLACK);
		panel_3.add(btnSearch, "cell 1 0");
		
		btnView = new JButton("View:");
		btnView.setForeground(Color.GREEN);
		btnView.setBackground(Color.BLACK);
		panel_3.add(btnView, "cell 1 0");
		btnView.setEnabled(false);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				ViewProsthetic p =new ViewProsthetic(myNameIsTim, Integer.parseInt(text));
		}
		});
		frame.setVisible(true);
	}

}
