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
	private JTextField emailtxt;
	private JTextField phonetxt;
	private String name;
	private String username;
	private String email;
	private int age;
	private String location;
	private String pid;
	private String mobile;
	private String critical; 
	int patient_id;
	
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
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select patient_id,name,email,age,phone,location from patients where username = '"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
					this.name = rs.getString("name");
					pid = rs.getString("patient_id");
					this.email = rs.getString("email");
					this.age = rs.getInt("age");
					mobile=rs.getString("phone");
					location=rs.getString("location");
					
					
					
					
					// update database right now default
												
				}
			con.close();
		} catch(Exception E){ //Login.ex.logException(E);
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
		
		JLabel lblCritical = new JLabel("Critical");
		lblCritical.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCritical.setBounds(51, 214, 91, 16);
		contentPane.add(lblCritical);
		
		JLabel patientid = new JLabel("");		//PId
		patientid.setFont(new Font("Arial", Font.PLAIN, 15));
		patientid.setBounds(159, 103, 167, 16);
		contentPane.add(patientid);
		patientid.setText(pid);
		
		JLabel agelbl = new JLabel("");		//age
		agelbl.setFont(new Font("Arial", Font.PLAIN, 15));
		agelbl.setBounds(159, 130, 167, 16);
		contentPane.add(agelbl);
		agelbl.setText(Integer.toString(age));
		
		JLabel criticaltxt = new JLabel(""); 		// critical
		criticaltxt.setFont(new Font("Arial", Font.PLAIN, 15));
		criticaltxt.setBounds(159, 215, 167, 16);
		contentPane.add(criticaltxt);
		criticaltxt.setText("NO");
		
		JLabel namelbl = new JLabel("");  // name
		namelbl.setFont(new Font("Arial", Font.PLAIN, 15));
		namelbl.setBounds(159, 71, 167, 16);
		contentPane.add(namelbl);
		namelbl.setText(name);
		
		JLabel lblLocationl = new JLabel("Location");	
		lblLocationl.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLocationl.setBounds(51, 242, 91, 16);
		contentPane.add(lblLocationl);
				
		JLabel locationlbl = new JLabel("");  //location
		locationlbl.setFont(new Font("Arial", Font.PLAIN, 15));
		locationlbl.setBounds(159, 243, 167, 16);
		contentPane.add(locationlbl);
		locationlbl.setText(location);

		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPhoneNo.setBounds(51, 270, 91, 16);
		contentPane.add(lblPhoneNo);
		
		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Arial", Font.PLAIN, 13));
		emailtxt.setBounds(156, 157, 170, 19);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);
		emailtxt.setText(email);
		
		phonetxt = new JTextField();
		phonetxt.setFont(new Font("Arial", Font.PLAIN, 15));
		phonetxt.setBounds(159, 271, 167, 19);
		contentPane.add(phonetxt);
		phonetxt.setColumns(10);
		phonetxt.setText(mobile);
		
		JButton btnSave = new JButton("Update");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSave.setBounds(376, 331, 97, 25);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				
				
				
				try {
					
					Connection con = ConnectDB.getConnection();
					Statement stmt = con.createStatement();
					
					//get existing emails and mobile
					
					String sql2 = "Select email from patients"; // mobile to be added
					ResultSet rs2 = stmt.executeQuery(sql2);
					
					while(rs2.next()) {
						//System.out.println(rs2.getString("email")+' '+textField.getText());
							if(emailtxt.getText().equals(rs2.getString("email"))) {
								flag = false;
							}
						}

					//update if flag is true
					if(flag) {
						//Temporary query
						String sql = "UPDATE patients set email='"+emailtxt.getText()+"' where username = '"+username+"'";
						
						//Original query :  Uncomment below line after updating database
						//String sql = "UPDATE patients set email='"+textField.getText()+"', mobile='"+textField_1.getText()+"' where username = '"+username+"'";
						
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Updated Successfully!");

					} else {
						JOptionPane.showMessageDialog(null,"That email already exist!");
					}
					con.close();
				} catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
					JOptionPane.showMessageDialog(null,E);
				}				
			}
		});
		
	}
}
