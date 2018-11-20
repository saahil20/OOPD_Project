import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Patient_registration extends JFrame {

	
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JTextField age;
	private JPasswordField password;
	private static int totalPatients = 0;
	private JTextField textField;

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
	}
*/
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
				dispose();
				//contentPane.setVisible(false);
				Login.main(null);
			}
		});
		btnBack.setBounds(476, 393, 125, 25);
		contentPane.add(btnBack);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		name.setBounds(250, 50, 195, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setBounds(250, 95, 195, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setBounds(250, 142, 201, 22);
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
		
		JRadioButton radioOPD = new JRadioButton("OPD");
		radioOPD.setBounds(248, 279, 91, 23);
		radioOPD.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(radioOPD);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLocation.setBounds(149, 282, 66, 16);
		contentPane.add(lblLocation);
		
		
		JRadioButton radioLOCAL = new JRadioButton("LOCAL");
		radioLOCAL.setBounds(343, 279, 136, 23);
		radioLOCAL.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(radioLOCAL);
		
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(radioOPD);
		bg1.add(radioLOCAL);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(150, 318, 100, 15);
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblDepartment);

		
		Choice choice = new Choice();
		choice.setBounds(256, 318, 185, 22);
		contentPane.add(choice);
		
		try {	
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql="Select dept_name from departments";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				choice.add(rs.getString("dept_name"));
			}
			
			con.close();
		 }catch(Exception e) {
			System.out.println(e);
		}


		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					//String sql="Select * from patients where username='"+username.getText()+"' and password='"+password.getText()+"'";
					//ResultSet rs=stmt.executeQuery(sql);
					String name_v = name.getText();
					String username_v = username.getText();
					String email_v = email.getText();
					Integer age_v = Integer.parseInt(age.getText());
					String pass = password.getText(); 
					String phone = textField.getText();
					
					String loc = "";
					if(radioOPD.isSelected()) {
						loc = "OPD"; // needs consultation
					} 
					
					if(radioLOCAL.isSelected()) {
						loc = "LOCAL";	// needs hospitalization
					}
					
					// generate unique patient_id 
					// form : SHS + First 3 letters of dept + patient number
					
					totalPatients++;
					String dpt = choice.getSelectedItem();
					String newid = "SHS"+dpt.substring(0, 3).toUpperCase() + totalPatients;
										
					
					
					String sql="Insert into patients (name,patient_id, phone, username,password,email,age,location) VALUES ('"+name_v+"','"+newid+"','"+phone+"', '"+username_v+"','"+pass+"','"+email_v+"','"+age_v+"','"+loc+"')";
					Integer rs=stmt.executeUpdate(sql);
					
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"Registration Sucessful !!");
						dispose();
						//contentPane.setVisible(false);
						Login.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Login Credentials");
					}
					con.close();
				}catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(476, 356, 125, 25);
		contentPane.add(btnNewButton);
		
		age = new JTextField();
		age.setFont(new Font("Arial", Font.PLAIN, 15));
		age.setBounds(256, 360, 195, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAge.setBounds(150, 360, 56, 16);
		contentPane.add(lblAge);
		
		password = new JPasswordField();
		password.setBounds(250, 188, 201, 22);
		contentPane.add(password);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(150, 236, 66, 15);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 15));;
		contentPane.add(lblPhone);
		
		textField = new JTextField();
		textField.setBounds(250, 234, 201, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
				
		
				
			}
}
