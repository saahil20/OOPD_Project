import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Patient_profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String name;
	private String username;
	private String email;
	private int age;
	private String location;
	private int pid;
	private String mobile;
	private String critical; 
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_profile frame = new Patient_profile();
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
	public Patient_profile(String username) {
		setTitle("SHS Patient Profile");
		this.username=username; // 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
			Statement stmt=con.createStatement();
			String sql = "Select name, pid, email,age from patients where username = '"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
					this.name = rs.getString("name");
					this.pid = rs.getInt("pid");
					this.email = rs.getString("email");
					this.age = rs.getInt("age");
					// update database right now default
					location = "LOCAL";
					mobile = "007";
					critical = "No";								
				}
			con.close();
		} catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}

		JLabel lblProfile = new JLabel("Name");
		lblProfile.setFont(new Font("Arial", Font.BOLD, 15));
		lblProfile.setBounds(51, 70, 58, 16);
		contentPane.add(lblProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			//contentPane.setVisible(false);
			//Patients_logged pre=new Patients_logged(user);
			//pre.setVisible(true);
			}
		});
		btnBack.setBounds(493, 331, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblPatientId = new JLabel("PID");
		lblPatientId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPatientId.setBounds(51, 99, 58, 16);
		contentPane.add(lblPatientId);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAge.setBounds(51, 128, 58, 16);
		contentPane.add(lblAge);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEmail.setBounds(51, 158, 58, 16);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsername.setBounds(51, 186, 97, 16);
		contentPane.add(lblUsername);
		
		JLabel lblCritical = new JLabel("Critical");
		lblCritical.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCritical.setBounds(51, 214, 91, 16);
		contentPane.add(lblCritical);
		
		JLabel label_1 = new JLabel("");		//PId
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(159, 103, 167, 16);
		contentPane.add(label_1);
		label_1.setText(Integer.toString(pid));
		
		JLabel label = new JLabel("");		//age
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(159, 130, 167, 16);
		contentPane.add(label);
		label.setText(Integer.toString(age));
		
		JLabel label_2 = new JLabel("");		//username
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(159, 187, 167, 16);
		contentPane.add(label_2);
		label_2.setText(username);
		
		JLabel label_3 = new JLabel(""); 		// critical
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(159, 215, 167, 16);
		contentPane.add(label_3);
		label_3.setText(critical);
		
		JLabel label_4 = new JLabel("");  // name
		label_4.setFont(new Font("Arial", Font.PLAIN, 15));
		label_4.setBounds(159, 71, 167, 16);
		contentPane.add(label_4);
		label_4.setText(name);
		
		JLabel lblLocationl = new JLabel("Location");	
		lblLocationl.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLocationl.setBounds(51, 242, 91, 16);
		contentPane.add(lblLocationl);
				
		JLabel label_5 = new JLabel("");  //location
		label_5.setFont(new Font("Arial", Font.PLAIN, 15));
		label_5.setBounds(159, 243, 167, 16);
		contentPane.add(label_5);
		label_5.setText(location);

		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPhoneNo.setBounds(51, 270, 91, 16);
		contentPane.add(lblPhoneNo);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBounds(156, 157, 170, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(email);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(159, 271, 167, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(mobile);
		
		JButton btnSave = new JButton("Update");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSave.setBounds(376, 331, 97, 25);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt = con.createStatement();
					
					//get existing emails and mobile
					
					String sql2 = "Select email from patients"; // mobile to be added
					ResultSet rs2 = stmt.executeQuery(sql2);
					
					while(rs2.next()) {
						//System.out.println(rs2.getString("email")+' '+textField.getText());
							if(textField.getText().equals(rs2.getString("email"))) {
								flag = false;
							}
						}

					//update if flag is true
					if(flag) {
						//Temporary query
						String sql = "UPDATE patients set email='"+textField.getText()+"' where username = '"+username+"'";
						
						//Original query :  Uncomment below line after updating database
						//String sql = "UPDATE patients set email='"+textField.getText()+"', mobile='"+textField_1.getText()+"' where username = '"+username+"'";
						
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Updated Successfully!");

					} else {
						JOptionPane.showMessageDialog(null,"That email already exist!");
					}
					con.close();
				} catch(Exception E) {
					System.out.println(E);
					JOptionPane.showMessageDialog(null,E);
				}				
			}
		});
		
	}
}
