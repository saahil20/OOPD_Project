import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;

public class Patient_registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JTextField age;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_registration frame = new Patient_registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Patient_registration() {
		setTitle("SHS Patient Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Login.main(null);
			}
		});
		btnBack.setBounds(240, 361, 195, 25);
		contentPane.add(btnBack);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		name.setBounds(240, 49, 195, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setBounds(240, 95, 195, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setBounds(240, 142, 195, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblName.setBounds(150, 53, 79, 16);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsername.setBounds(149, 98, 79, 16);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(149, 145, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Password");
		lblPhoneNo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhoneNo.setBounds(149, 190, 78, 16);
		contentPane.add(lblPhoneNo);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt=con.createStatement();
					//String sql="Select * from patients where username='"+username.getText()+"' and password='"+password.getText()+"'";
					//ResultSet rs=stmt.executeQuery(sql);
					String name_v = name.getText();
					String username_v = username.getText();
					String email_v = email.getText();
					Integer age_v = Integer.parseInt(age.getText());
					String pass = password.getText();
					
					String sql="Insert into patients (name,username,password,email,age) VALUES ('"+name_v+"','"+username_v+"','"+pass+"','"+email_v+"',"+age_v+")";
					Integer rs=stmt.executeUpdate(sql);
					
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"Registration Sucessful !!");
						contentPane.setVisible(false);
						Login.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Login Credentials");
					}
					con.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(240, 321, 195, 25);
		contentPane.add(btnNewButton);
		
		age = new JTextField();
		age.setFont(new Font("Arial", Font.PLAIN, 15));
		age.setBounds(240, 230, 195, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAge.setBounds(149, 233, 56, 16);
		contentPane.add(lblAge);
		
		password = new JPasswordField();
		password.setBounds(240, 187, 195, 22);
		contentPane.add(password);
	}
}
