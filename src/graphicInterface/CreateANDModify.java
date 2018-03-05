package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridBagLayout;

public class CreateANDModify extends JFrame {
	private JFrame frame;
	public CreateANDModify() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JTextArea txtrNewClientInsertion = new JTextArea();
		txtrNewClientInsertion.setForeground(Color.WHITE);
		txtrNewClientInsertion.setBackground(Color.BLUE);
		txtrNewClientInsertion.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtrNewClientInsertion.setText("New Client Insertion");
		panel_1.add(txtrNewClientInsertion);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0};
		gbl_panel_2.rowHeights = new int[]{0};
		gbl_panel_2.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
	}

	private JPanel contentPane;

	public void fullClient() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setSize(frame.getMaximumSize());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
