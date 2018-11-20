import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Doc_Appointment_Select extends JFrame {

	private JPanel contentPane;
	int pid,did,slot;
	String pname,date;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doc_Appointment_Select frame = new Doc_Appointment_Select();
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
	public Doc_Appointment_Select(int aid) {
		setTitle("Appointments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblName.setBounds(26, 54, 56, 16);
		contentPane.add(lblName);
		
		JLabel plabel = new JLabel("");
		plabel.setFont(new Font("Arial", Font.PLAIN, 15));
		plabel.setBounds(94, 54, 135, 16);
		contentPane.add(plabel);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(94, 91, 135, 16);
		contentPane.add(label);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDate.setBounds(26, 91, 56, 16);
		contentPane.add(lblDate);
		
		JLabel lblSlot = new JLabel("Slot");
		lblSlot.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSlot.setBounds(26, 130, 56, 16);
		contentPane.add(lblSlot);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(94, 130, 135, 16);
		contentPane.add(lblNewLabel);
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select did,pid,date,slot from appointment where aid = '"+aid+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					did=rs.getInt("did");
					pid=rs.getInt("pid");
					date=rs.getString("date");
					slot=rs.getInt("slot");
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		label.setText(date);
		lblNewLabel.setText(Integer.toString(slot));
		
try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select name from patients where pid = '"+pid+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					pname=rs.getString("name");
					plabel.setText(pname);
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		
		
		JButton btnCreateReport = new JButton("Create Report");
		btnCreateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCreateReport.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCreateReport.setBounds(26, 307, 165, 25);
		contentPane.add(btnCreateReport);
		
		JButton btnDeleteAppointment = new JButton("Delete Appointment");
		btnDeleteAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteAppointment.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDeleteAppointment.setBounds(26, 260, 165, 25);
		contentPane.add(btnDeleteAppointment);
		
		JButton btnAssignAnotherDoctor = new JButton("Assign Another Doctor");
		btnAssignAnotherDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAssignAnotherDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAssignAnotherDoctor.setBounds(337, 307, 219, 25);
		contentPane.add(btnAssignAnotherDoctor);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(26, 375, 97, 25);
		contentPane.add(btnBack);
		
		
		
	}

}
