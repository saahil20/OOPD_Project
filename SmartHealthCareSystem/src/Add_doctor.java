import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Choice;

public class Add_doctor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_doctor frame = new Add_doctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public Add_doctor() {
		setTitle("Add Doctor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(250, 43, 195, 22);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(160, 47, 79, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(159, 92, 79, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(250, 89, 195, 22);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(159, 139, 56, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(250, 136, 195, 22);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(159, 184, 78, 16);
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 181, 195, 22);
		contentPane.add(passwordField);
		
		JLabel label_4 = new JLabel("Age");
		label_4.setFont(new Font("Arial", Font.PLAIN, 15));
		label_4.setBounds(159, 227, 56, 16);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(250, 224, 195, 22);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Add Doctor");
		btnNewButton.setBounds(250, 323, 195, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Admin_logged ad=new Admin_logged();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(250, 372, 195, 25);
		contentPane.add(btnNewButton_1);
		
		Choice choice = new Choice();
		choice.setBounds(250, 269, 195, 22);
		contentPane.add(choice);
		choice.add("OPD");
		choice.add("Cardiology");
		choice.add("ENT");
		choice.add("Gastroenterology");
		choice.add("Gynaecology");
		choice.add("Ophthalmology");
		choice.add("Orthopaedics");
		choice.add("Urology");
	}
}
