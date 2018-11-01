import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
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
		userlbl.setText(user);
		
		JButton btnBookAppointments = new JButton("Book Appointments");
		btnBookAppointments.setBounds(111, 148, 155, 25);
		contentPane.add(btnBookAppointments);
		
		JButton btnNewButton = new JButton("Check Avaliablity");
		btnNewButton.setBounds(111, 197, 155, 25);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				Login.main(null);
			}
		});
		btnLogout.setBounds(453, 45, 120, 25);
		contentPane.add(btnLogout);
		
		JButton btnNewButton_1 = new JButton("View Reports");
		btnNewButton_1.setBounds(111, 247, 155, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnEditProfile = new JButton("View Profile");
		btnEditProfile.setBounds(453, 100, 120, 25);
		contentPane.add(btnEditProfile);
		
		JButton btnNewButton_2 = new JButton("View Doctors");
		btnNewButton_2.setBounds(108, 100, 158, 25);
		contentPane.add(btnNewButton_2);
	}
}