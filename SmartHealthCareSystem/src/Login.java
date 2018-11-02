import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmSmartHealthcareSystem;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSmartHealthcareSystem.setVisible(true);
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
		frmSmartHealthcareSystem = new JFrame();
		frmSmartHealthcareSystem.setTitle("Smart HealthCare System");
		frmSmartHealthcareSystem.setBounds(100, 100, 640, 480);
		frmSmartHealthcareSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartHealthcareSystem.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setBounds(217, 104, 189, 22);
		frmSmartHealthcareSystem.getContentPane().add(username);
		username.setColumns(10);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnPatient.setBounds(217, 197, 77, 25);
		frmSmartHealthcareSystem.getContentPane().add(rdbtnPatient);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnDoctor.setBounds(329, 197, 77, 25);
		frmSmartHealthcareSystem.getContentPane().add(rdbtnDoctor);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnAdmin.setBounds(217, 236, 77, 25);
		frmSmartHealthcareSystem.getContentPane().add(rdbtnAdmin);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnDoctor);
		bg.add(rdbtnAdmin);
		bg.add(rdbtnPatient);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsername.setBounds(92, 107, 83, 16);
		frmSmartHealthcareSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(92, 155, 83, 16);
		frmSmartHealthcareSystem.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(username.getText().equals("") || password.getText().equals(""))) {
					if(rdbtnPatient.isSelected()) {
						patient_login();
					}
					else if(rdbtnDoctor.isSelected()) {
						doctor_login();
					}
					else if(rdbtnAdmin.isSelected()) {
						
						admin_login();
					}
					else {
						JOptionPane.showMessageDialog(null,"No Options Selected!!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Enter Username and Password");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(217, 294, 189, 25);
		frmSmartHealthcareSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Patient Register");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSmartHealthcareSystem.dispose();
				Patient_registration pre=new Patient_registration();
				pre.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(217, 332, 189, 25);
		frmSmartHealthcareSystem.getContentPane().add(btnNewButton_1);
		
		password = new JPasswordField();
		password.setBounds(217, 152, 189, 22);
		frmSmartHealthcareSystem.getContentPane().add(password);
	}
	
	void patient_login() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from patients where username='"+username.getText()+"' and password='"+password.getText()+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null,"Login Sucessful !!");
				frmSmartHealthcareSystem.dispose();
				Patients_logged pre=new Patients_logged(username.getText());
				pre.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Incorrect Login Credentials");
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	void admin_login() {
		
		if(username.getText().equals("admin")&&password.getText().equals("admin")) {
			frmSmartHealthcareSystem.dispose();
			Admin_logged ad=new Admin_logged();
			ad.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null,"Incorrect Login Credentials");
		}
	}
	void doctor_login() {
		
	}
}
