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

public class Doctor_logged extends JFrame {
	String doctor;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_logged frame = new Doctor_logged();
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
	public Doctor_logged(String doc) {
		this.doctor=doc;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Welcome:");
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setBounds(36, 35, 76, 16);
		contentPane.add(label);
		
		JLabel doct = new JLabel("<dynamic>");
		doct.setFont(new Font("Arial", Font.BOLD, 14));
		doct.setBounds(117, 35, 146, 16);
		contentPane.add(doct);
		doct.setText(doctor);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login.main(null);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.setBounds(461, 32, 123, 25);
		contentPane.add(btnLogout);
		
		JButton btnNewButton = new JButton("View Appontments");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View_dAppointment vdp=new View_dAppointment(doc);
				vdp.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(36, 102, 173, 25);
		contentPane.add(btnNewButton);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_profile dp=new Doctor_profile(doc);
				dp.setVisible(true);
			}
		});
		btnProfile.setFont(new Font("Arial", Font.PLAIN, 15));
		btnProfile.setBounds(461, 102, 123, 25);
		contentPane.add(btnProfile);
	}
}
