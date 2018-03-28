package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import wizard_Handler.WizardHandler;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

public class ViewMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMaterial frame = new ViewMaterial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewMaterial(WizardHandler myNameIsTim,int id) {
		Material mat =myNameIsTim.getMaterialFull(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblMaterial.setBackground(Color.BLACK);
		lblMaterial.setForeground(Color.GREEN);
		panel.add(lblMaterial);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));
		
		JLabel lblId = new JLabel("Id:");
		panel_1.add(lblId, "cell 1 1,alignx trailing");
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField, "flowx,cell 2 1,alignx left");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price:");
		panel_1.add(lblNewLabel, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_1.add(textField_1, "flowx,cell 2 4,alignx left");
		textField_1.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "cell 2 1");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 2 1");
		
		JLabel lblStyle = new JLabel("Style:");
		panel_1.add(lblStyle, "cell 2 1");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_1.add(textField_2, "cell 2 1");
		textField_2.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, "cell 2 4");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, "cell 2 4");
		
		JLabel lblProvider = new JLabel("Provider:");
		panel_1.add(lblProvider, "cell 2 4");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_1.add(textField_3, "cell 2 4");
		textField_3.setColumns(10);
	}

}
