import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_logged extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_logged frame = new Admin_logged();
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
	public Admin_logged() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome: Admin");
		lblWelcomeAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		lblWelcomeAdmin.setBounds(82, 37, 139, 16);
		contentPane.add(lblWelcomeAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//contentPane.setVisible(false);
				Login.main(null);
			}
		});
		btnLogout.setBounds(433, 33, 139, 25);
		contentPane.add(btnLogout);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.setVisible(false);
				Add_doctor ad=new Add_doctor();
				ad.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(82, 99, 139, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Doctors");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(82, 149, 139, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Patients");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setBounds(82, 202, 139, 25);
		contentPane.add(btnNewButton_2);
	}
}
