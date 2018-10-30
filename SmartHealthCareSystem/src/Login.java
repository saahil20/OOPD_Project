import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setBounds(217, 104, 189, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Arial", Font.PLAIN, 15));
		password.setBounds(217, 152, 189, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnPatient.setBounds(217, 197, 77, 25);
		frame.getContentPane().add(rdbtnPatient);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnDoctor.setBounds(329, 197, 77, 25);
		frame.getContentPane().add(rdbtnDoctor);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnAdmin.setBounds(217, 236, 77, 25);
		frame.getContentPane().add(rdbtnAdmin);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsername.setBounds(92, 107, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(92, 155, 83, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from patients where username='"+username.getText()+"' and password='"+password.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessful !!");
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
		btnNewButton.setBounds(217, 294, 189, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Patient Register");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Patient_registration pre=new Patient_registration();
				pre.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(217, 332, 189, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
