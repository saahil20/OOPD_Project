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

public class Patient_profile extends JFrame {

	private JPanel contentPane;
	String user;

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
	public Patient_profile(String user) {
		setTitle("SHS Patient Profile");
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Arial", Font.BOLD, 15));
		lblProfile.setBounds(51, 70, 58, 16);
		contentPane.add(lblProfile);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(121, 70, 121, 16);
		contentPane.add(label);
		label.setText(user);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			//contentPane.setVisible(false);
			//Patients_logged pre=new Patients_logged(user);
			//pre.setVisible(true);
			
			}
		});
		btnBack.setBounds(481, 66, 97, 25);
		contentPane.add(btnBack);
	}

}
