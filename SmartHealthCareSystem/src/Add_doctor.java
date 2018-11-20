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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JRadioButton;

public class Add_doctor extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField timing;
	private JTextField phoneField;

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
		lblDepartment.setBounds(159, 249, 80, 16);
		contentPane.add(lblDepartment);
		Choice choice = new Choice();
		choice.setBounds(250, 243, 195, 22);
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
		}catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
		}

		Choice post = new Choice();
		post.setBounds(250, 330, 195, 22);
		contentPane.add(post);
		post.add("Junior Doctor");
		post.add("Senior Doctor");
		post.add("Specialist");
		post.add("HOD");
		
		btnNewButton = new JButton("Add Doctor");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					
					String name_v = name.getText();
					String username_v = username.getText();
					String email_v = email.getText();
					String pass = password.getText();
					String dept=choice.getSelectedItem();
					String time=timing.getText();
					String pst=post.getSelectedItem();
					String phone = phoneField.getText();
					
					// get dept id
					int flag = 0;
					
					// check if for given dept hod_id is null or not
					try {	
						String sql="Select hod_id from departments where dept_name='"+dept+"'";
						ResultSet rs=stmt.executeQuery(sql);
						
						 
						if(rs.next()) {
					
							if(rs.getString("hod_id") == null) {
								flag = 1;
							}
						}
						
					}catch(Exception E){ Login.ex.logException(E);
						System.out.println(E);
					}
					
					if((flag == 1) || !pst.equals("HOD")) {
						
						int doc_id = 0; 
						String sql="Insert into doctor (name,username,password,email,department,timing,post,phone) "
								+ " VALUES ('"+name_v+"','"+username_v+"','"+pass+"','"+email_v+"','"+dept+"','"+time+"','"+pst+"','"+phone+"')";
						
						Integer rs=stmt.executeUpdate(sql);
						
						if(pst.equals("HOD")) { 
							 
							String sql3 = "Select id from doctor where username='"+username_v+"'"; 
							ResultSet rs3 = stmt.executeQuery(sql3); 
							 
							if(rs3.next()) { 
								doc_id = rs3.getInt("id"); 
							} 
						 
														 
							String sql4="Update departments set hod_id='"+doc_id+"' where dept_name='"+dept+"'"; 
							 
							Integer rs4=stmt.executeUpdate(sql4); 
							if(rs4 > 0) {		 
								JOptionPane.showMessageDialog(null,"Doctor Added Sucessfully !!"); 
								dispose(); 
								con.close(); 
							} 
							else { 
								JOptionPane.showMessageDialog(null,"Doctor Not Added"); 
							} 
						} else {
							if(rs > 0) {		
								JOptionPane.showMessageDialog(null,"Doctor Added Sucessfully !!");
								dispose();
								con.close();
							}
							else {
								JOptionPane.showMessageDialog(null,"Doctor Not Added");
							}
						}
							
					} else {
						JOptionPane.showMessageDialog(null, dept+" HOD already filled, select something else!");
					}

				
				}catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
				}
			}
		});
		btnNewButton.setBounds(489, 361, 139, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//contentPane.setVisible(false);
				//Admin_logged ad=new Admin_logged();
				//ad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(499, 398, 119, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTiming.setBounds(160, 289, 80, 16);
		contentPane.add(lblTiming);
		
		
		
		
		timing = new JTextField();
		timing.setBounds(250, 287, 195, 22);
		contentPane.add(timing);
		timing.setColumns(10);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPost.setBounds(159, 336, 80, 16);
		contentPane.add(lblPost);
		
		JLabel lblHhmmhhmm = new JLabel("hh:mm-hh:mm");
		lblHhmmhhmm.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHhmmhhmm.setBounds(457, 277, 97, 16);
		contentPane.add(lblHhmmhhmm);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhone.setBounds(161, 212, 78, 16);
		contentPane.add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Dialog", Font.PLAIN, 15));
		phoneField.setBounds(250, 211, 195, 22);
		contentPane.add(phoneField);
		
		
	}
}
