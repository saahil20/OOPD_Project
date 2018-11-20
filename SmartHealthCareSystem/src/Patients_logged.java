import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Patients_logged extends JFrame {

	private JPanel contentPane;
	String user="";
	//JLabel userlbl;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patients_logged frame = new Patients_logged();
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
	
	public Patients_logged(String user) {
		setTitle("Smart HealthCare System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome:");
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
		lblWelcome.setBounds(111, 45, 76, 16);
		contentPane.add(lblWelcome);
		
		JLabel userlbl = new JLabel("");
		userlbl.setFont(new Font("Arial", Font.BOLD, 14));
		userlbl.setBounds(192, 46, 146, 16);
		contentPane.add(userlbl);
		this.user=user;
		//userlbl.setText(user);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select name from patients where username = '"+user+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					
					String name=rs.getString("name");
					userlbl.setText(name);
				}
			
			con.close();
		} catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		JButton btnBookAppointments = new JButton("Need an Appointment?");
		btnBookAppointments.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ViewDoc_ForAppointment vda = new ViewDoc_ForAppointment(user);
				vda.setVisible(true);
				
			}
		});
		btnBookAppointments.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBookAppointments.setBounds(111, 196, 170, 25);
		contentPane.add(btnBookAppointments);
		
		JButton btnNewButton = new JButton("Check Avaliablity");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(108, 150, 170, 25);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//contentPane.setVisible(false);
				Login.main(null);
			}
		});
		btnLogout.setBounds(427, 45, 146, 25);
		contentPane.add(btnLogout);
		
		JButton btnNewButton_1 = new JButton("View Reports");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(111, 247, 170, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnEditProfile = new JButton("View Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.setVisible(false);
				Patient_profile pf=new Patient_profile(user);
				pf.setVisible(true);
			}
		});
		btnEditProfile.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEditProfile.setBounds(427, 100, 146, 25);
		contentPane.add(btnEditProfile);
		
		JButton btnNewButton_2 = new JButton("View Doctors");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View_doctors vd=new View_doctors();
				vd.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setBounds(108, 100, 173, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Appointments");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View_pAppointment vp=new View_pAppointment(user);
				vp.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_3.setBounds(111, 297, 170, 25);
		contentPane.add(btnNewButton_3);
	}
}