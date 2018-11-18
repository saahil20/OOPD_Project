import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.*;
import java.util.*;
public class View_patients extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_patients frame = new View_patients();
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
	public View_patients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> dlm = new DefaultListModel<>();  

		
		ArrayList<String> patientAL = new ArrayList<>();
		ArrayList<String> patientUsername = new ArrayList<>();
		
		try {
			
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select username,name from patients";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				patientAL.add(rs.getString("name"));
				patientUsername.add(rs.getString("username"));
				}
			con.close();
		}catch(Exception E) {
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		String[] pt = patientAL.toArray(new String[patientAL.size()]);
		
		for(int i=0; i < pt.length; i++) {
			dlm.addElement(pt[i]);
		}
		
		JList<String> list = new JList<String>(dlm);
		JScrollPane jsp = new JScrollPane(list);
		jsp.setBounds(60, 75, 197, 271);
		contentPane.add(jsp);
		
		JLabel lblPatients = new JLabel("Patients Profile");
		lblPatients.setBounds(60, 28, 187, 15);
		lblPatients.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblPatients);
		
		JLabel lblPatientName = new JLabel("Patient Name :");
		lblPatientName.setBounds(306, 76, 114, 15);
		lblPatientName.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPatientName);
		
		JLabel lblPatientId = new JLabel("Patient ID :");
		lblPatientId.setBounds(306, 119, 114, 15);
		lblPatientId.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPatientId);
		
		JLabel lblPatientAge = new JLabel("Patient Age :");
		lblPatientAge.setBounds(306, 163, 114, 15);
		lblPatientAge.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPatientAge);
		
		JLabel lblPatientEmail = new JLabel("Patient Email :");
		lblPatientEmail.setBounds(306, 200, 114, 15);
		lblPatientEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPatientEmail);
		
		JLabel label = new JLabel("");	// Name
		label.setBounds(432, 76, 176, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel(""); //ID
		lblNewLabel.setBounds(432, 119, 176, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel(""); //Age
		label_1.setBounds(432, 163, 78, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(""); // Email
		label_2.setBounds(432, 200, 196, 15);
		contentPane.add(label_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(432, 365, 114, 25);
		contentPane.add(btnBack);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
								
			
				if(arg0.getValueIsAdjusting() == false) {
					
					int i = list.getSelectedIndex();
					String search = patientUsername.get(i);
					//System.out.println(i+' '+ search);
					
					try {
						
						Connection con=ConnectDB.getConnection();
						Statement stmt=con.createStatement();
						String sql = "Select pid,name,email,age from patients where username='"+search+"'";
						
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							
							label.setText(rs.getString("name"));
							lblNewLabel.setText(rs.getString("pid"));
							label_1.setText(rs.getString("age"));
							label_2.setText(rs.getString("email"));
							
							}
						
						con.close();
					}catch(Exception E) {
						System.out.println(E);
						JOptionPane.showMessageDialog(null,E);
					}
					
					
				}
			}
			
		});
		
	}
}
