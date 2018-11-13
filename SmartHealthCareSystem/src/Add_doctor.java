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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Choice;

public class Add_doctor extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
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
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(250, 43, 195, 22);
		contentPane.add(name);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(160, 47, 79, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(159, 92, 79, 16);
		contentPane.add(label_1);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setColumns(10);
		username.setBounds(250, 89, 195, 22);
		contentPane.add(username);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(159, 139, 56, 16);
		contentPane.add(label_2);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setColumns(10);
		email.setBounds(250, 136, 195, 22);
		contentPane.add(email);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(159, 184, 78, 16);
		contentPane.add(label_3);
		
		password = new JPasswordField();
		password.setFont(new Font("Arial", Font.PLAIN, 15));
		password.setBounds(250, 181, 195, 22);
		contentPane.add(password);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDepartment.setBounds(159, 227, 80, 16);
		contentPane.add(lblDepartment);
		Choice choice = new Choice();
		choice.setBounds(250, 227, 195, 22);
		contentPane.add(choice);
		choice.add("OPD");
		choice.add("Cardiology");
		choice.add("ENT");
		choice.add("Gastroenterology");
		choice.add("Gynaecology");
		choice.add("Ophthalmology");
		choice.add("Orthopaedics");
		choice.add("Urology");
		
		btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt=con.createStatement();
					
					String name_v = name.getText();
					String username_v = username.getText();
					String email_v = email.getText();
					String pass = password.getText();
					String dept=choice.getSelectedItem();
					
					
					String sql="Insert into doctor (name,username,password,email,department) VALUES ('"+name_v+"','"+username_v+"','"+pass+"','"+email_v+"','"+dept+"')";
					Integer rs=stmt.executeUpdate(sql);
					
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"Doctor Added Sucessfully !!");
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Doctor Not Added");
					}
					con.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(250, 323, 195, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//contentPane.setVisible(false);
				//Admin_logged ad=new Admin_logged();
				//ad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(250, 372, 195, 25);
		contentPane.add(btnNewButton_1);
		
		
	}
}
