import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Book_Appointment extends JFrame {

	private JPanel contentPane;
	private String patientUserName;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Appointment frame = new Book_Appointment();
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
	public Book_Appointment(String docName, String patientUserName) {
		this.patientUserName = patientUserName;
		System.out.println(docName+' '+patientUserName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppointmentSummary = new JLabel("Appointment Summary");
		lblAppointmentSummary.setBounds(38, 25, 223, 24);
		lblAppointmentSummary.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblAppointmentSummary);
		
		JLabel lblPatient = new JLabel("Patient UserName");
		lblPatient.setBounds(72, 78, 147, 15);
		lblPatient.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPatient);
		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDoctorName.setBounds(72, 115, 147, 15);
		contentPane.add(lblDoctorName);
		
		JLabel lblDoctorTimings = new JLabel("Doctor Timings");
		lblDoctorTimings.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDoctorTimings.setBounds(72, 153, 147, 15);
		contentPane.add(lblDoctorTimings);
		
		JLabel label = new JLabel("");
		label.setBounds(262, 78, 132, 15);
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(label);
		label.setText(patientUserName);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(262, 115, 132, 15);
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(label_1);
		label_1.setText(docName);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(262, 142, 66, 15);
		contentPane.add(label_2);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
			Statement stmt=con.createStatement();
			String sql="Select timing from doctor where name='"+docName+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				label_2.setText(rs.getString("timing"));		
			}						
			con.close();
		}catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}			

		
		
	}
}
