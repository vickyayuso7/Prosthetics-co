package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;

public class EditFeatures extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private JFrame frame= new JFrame();
	
	
	public EditFeatures() {
		setResizable(false);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][grow][][][][][][][grow][][][][][][][][grow][][][][][grow]", "[][][][][][][][][][]"));
		//frame.add(contentPane);
		
		JLabel lblEditFeatures = new JLabel("Edit Features");
		lblEditFeatures.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEditFeatures.setForeground(Color.MAGENTA);
		panel.add(lblEditFeatures, "cell 3 0");
		
		JLabel lblNewLabel = new JLabel("Extra Price");
		panel.add(lblNewLabel, "cell 2 2");
		
		Component glue_3 = Box.createGlue();
		panel.add(glue_3, "cell 3 2");
		
		JLabel lblStyle = new JLabel("Style");
		panel.add(lblStyle, "cell 4 2");
		
		textField = new JTextField();
		panel.add(textField, "cell 2 3,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 4 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblSensibility = new JLabel("Sensibility");
		panel.add(lblSensibility, "cell 2 6");
		
		JLabel lblEnhancedMovement = new JLabel("Enhanced movement");
		panel.add(lblEnhancedMovement, "cell 4 6");
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select an option:", "yes", "no"}));
		panel.add(comboBox_1, "cell 2 7,growx");
		comboBox_1.getSelectedIndex();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select an option", "yes", "no"}));
		panel.add(comboBox, "cell 4 7,growx");
		
		Component glue_2 = Box.createGlue();
		panel.add(glue_2, "flowx,cell 3 9");
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				JOptionPane.showMessageDialog(null, "Not implemented yet");
			}
		});
		panel.add(btnOk, "cell 3 9");
		
		JButton btnNewButton = new JButton("Cancel");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton, "cell 4 9,growx,aligny bottom");
		frame.setVisible(true);
	}

}
