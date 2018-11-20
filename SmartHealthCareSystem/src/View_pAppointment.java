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
import java.awt.Font;

public class View_pAppointment extends JFrame {

	private JPanel contentPane;
	String name;
	int id;
	int did;
	String display;
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
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPatient.setBounds(43, 14, 56, 16);
		contentPane.add(lblPatient);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(43, 119, 499, 188);
		contentPane.add(list);
		DefaultListModel DLM= new DefaultListModel();
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select did,date,slot from appointment where pid = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
					//System.out.println("1");
					did=rs.getInt("did");
					String date=rs.getString("date");
					String slot=rs.getString("slot");
					label.setText(name);
					//System.out.println("2");
					Statement stmt1=con.createStatement();
					String sql1="Select name from doctor where id = '"+did+"'";
					ResultSet rs1=stmt1.executeQuery(sql1);
					//System.out.println("3");
					if(rs1.next()) {
						//System.out.println("4");
						String docname=rs1.getString("name");
						display=docname+"      "+date+"         "+slot;
						DLM.addElement(display);
						
					}
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		list.setModel(DLM);
		
		
		
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAppointments.setBounds(43, 67, 89, 16);
		contentPane.add(lblAppointments);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(445, 382, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDoctorName.setBounds(43, 96, 89, 16);
		contentPane.add(lblDoctorName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDate.setBounds(153, 96, 42, 16);
		contentPane.add(lblDate);
		
		JLabel lblSlot = new JLabel("Slot");
		lblSlot.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSlot.setBounds(207, 96, 42, 16);
		contentPane.add(lblSlot);
	}
}
