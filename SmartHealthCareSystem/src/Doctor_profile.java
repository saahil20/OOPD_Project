import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor_profile extends JFrame {
	String doc;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_profile frame = new Doctor_profile();
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
	public Doctor_profile(String doc) {
		this.doc=doc;
		System.out.println(doc);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(65, 44, 76, 16);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setBounds(65, 77, 89, 16);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setBounds(65, 113, 76, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhone.setBounds(65, 146, 76, 16);
		contentPane.add(lblPhone);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Arial", Font.BOLD, 15));
		lblDepartment.setBounds(65, 179, 110, 16);
		contentPane.add(lblDepartment);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setFont(new Font("Arial", Font.BOLD, 15));
		lblTiming.setBounds(65, 217, 76, 16);
		contentPane.add(lblTiming);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setFont(new Font("Arial", Font.BOLD, 15));
		lblPost.setBounds(65, 253, 76, 16);
		contentPane.add(lblPost);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		name.setBounds(203, 44, 162, 16);
		contentPane.add(name);
		
		JLabel username = new JLabel("");
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setBounds(203, 77, 162, 16);
		contentPane.add(username);
		
				
		JLabel department = new JLabel("");
		department.setFont(new Font("Arial", Font.PLAIN, 15));
		department.setBounds(203, 179, 162, 16);
		contentPane.add(department);
		
		
		JLabel post = new JLabel("");
		post.setFont(new Font("Arial", Font.PLAIN, 15));
		post.setBounds(203, 253, 162, 16);
		contentPane.add(post);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(462, 334, 119, 25);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUpdate.setBounds(322, 334, 119, 25);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean flag = true;
				try {
					
					Connection con = ConnectDB.getConnection();
					Statement stmt = con.createStatement();
					
					//get existing emails and mobile
					
					String sql2 = "Select email,phone from doctor"; // 
					ResultSet rs2 = stmt.executeQuery(sql2);
					
					while(rs2.next()) {
						//System.out.println(rs2.getString("email")+' '+textField.getText());
							if(textField.getText().equals(rs2.getString("email")) || textField_1.getText().equals(rs2.getString("phone")) ) {
								flag = false;
							}
						}

					//update if flag is true
					if(flag) {
						//Temporary query
						//String sql = "UPDATE patients set email='"+textField.getText()+"' where username = '"+username+"'";
						
						//Original query :  Uncomment below line after updating database
						String sql = "UPDATE doctor set email='"+textField.getText()+"', phone='"+textField_1.getText()+"', timing='"+textField_2.getText()+"' where username = '"+doc+"'";
						
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Updated Successfully!");

					} else {
						JOptionPane.showMessageDialog(null,"That email or mobile already exist!");
					}
					con.close();
				} catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
					JOptionPane.showMessageDialog(null,E);
				}				
			}
		});
		contentPane.add(btnUpdate);
		
		textField = new JTextField();
		textField.setBounds(203, 112, 175, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(203, 145, 124, 19);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(203, 216, 124, 19);
		contentPane.add(textField_2);
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select name,username,email,phone,department,timing,post from doctor where username = '"+this.doc+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
					name.setText(rs.getString("name"));
					username.setText(rs.getString("username"));
					textField.setText(rs.getString("email"));
					textField_1.setText(rs.getString("phone"));
					department.setText(rs.getString("department"));
					textField_2.setText(rs.getString("timing"));
					post.setText(rs.getString("post"));
														
				}
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
	}
}