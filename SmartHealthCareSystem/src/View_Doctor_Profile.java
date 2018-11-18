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

public class View_Doctor_Profile extends JFrame {
	String doc;
	private JPanel contentPane;

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
	public View_Doctor_Profile(String doc) {
		this.doc=doc;
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
		
		JLabel email = new JLabel("");
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setBounds(203, 113, 162, 16);
		contentPane.add(email);
		
		JLabel phone = new JLabel("");
		phone.setFont(new Font("Arial", Font.PLAIN, 15));
		phone.setBounds(203, 146, 162, 16);
		contentPane.add(phone);
		
		JLabel department = new JLabel("");
		department.setFont(new Font("Arial", Font.PLAIN, 15));
		department.setBounds(203, 179, 162, 16);
		contentPane.add(department);
		
		JLabel timing = new JLabel("");
		timing.setFont(new Font("Arial", Font.PLAIN, 15));
		timing.setBounds(203, 217, 162, 16);
		contentPane.add(timing);
		
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
		btnBack.setBounds(457, 373, 119, 25);
		contentPane.add(btnBack);
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select name,username,email,phone,department,timing,post from doctor where name = '"+this.doc+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
					name.setText(rs.getString("name"));
					username.setText(rs.getString("username"));
					email.setText(rs.getString("email"));
					phone.setText(rs.getString("phone"));
					department.setText(rs.getString("department"));
					timing.setText(rs.getString("timing"));
					post.setText(rs.getString("post"));
														
				}
			con.close();
		} catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
	}

}