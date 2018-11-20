import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class View_pAppointment extends JFrame {

	private JPanel contentPane;
	String name;
	int id;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_pAppointment frame = new View_pAppointment();
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
	public View_pAppointment(String user) {
		setTitle("Patient Appointments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 13, 218, 16);
		contentPane.add(label);
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select pid,name from patients where username = '"+user+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					id=rs.getInt("pid");
					name=rs.getString("name");
					label.setText(name);
				}
			
			con.close();
		} catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setBounds(43, 13, 56, 16);
		contentPane.add(lblPatient);
		
		JList list = new JList();
		list.setBounds(43, 96, 499, 188);
		contentPane.add(list);
		DefaultListModel DLM= new DefaultListModel();
		
		
		
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setBounds(43, 67, 89, 16);
		contentPane.add(lblAppointments);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(445, 382, 97, 25);
		contentPane.add(btnNewButton);
	}
}
