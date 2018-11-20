import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class View_dAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_dAppointment frame = new View_dAppointment();
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
	public View_dAppointment(String docu) {
		setTitle("Apointments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDoctor.setBounds(49, 13, 56, 16);
		contentPane.add(lblDoctor);
		
		JLabel label_1 = new JLabel("Appointments");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(49, 66, 89, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Doctor Name");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(124, 95, 89, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(247, 95, 35, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Slot");
		label_4.setFont(new Font("Arial", Font.PLAIN, 15));
		label_4.setBounds(311, 95, 35, 16);
		contentPane.add(label_4);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(49, 118, 499, 188);
		contentPane.add(list);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.setBounds(451, 381, 97, 25);
		contentPane.add(button);
		
		JLabel lblId = new JLabel("  ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(49, 95, 26, 16);
		contentPane.add(lblId);
	}

}
