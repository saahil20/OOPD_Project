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
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_dAppointment extends JFrame {

	private JPanel contentPane;
	int did;
	int pid;
	String dname;
	String pname;
	String display;
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
		
		JLabel label = new JLabel("");
		label.setBounds(104, 13, 218, 16);
		contentPane.add(label);
		
try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select id,name from doctor where username = '"+docu+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					did=rs.getInt("id");
					dname=rs.getString("name");
					label.setText(dname);
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		JLabel label_1 = new JLabel("Appointments");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(49, 66, 89, 16);
		contentPane.add(label_1);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPatientName.setBounds(93, 95, 89, 16);
		contentPane.add(lblPatientName);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(225, 95, 35, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Slot");
		label_4.setFont(new Font("Arial", Font.PLAIN, 15));
		label_4.setBounds(291, 95, 35, 16);
		contentPane.add(label_4);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(49, 118, 499, 188);
		contentPane.add(list);
		DefaultListModel DLM= new DefaultListModel();
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select pid,date,slot from appointment where did = '"+did+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
					//System.out.println("1");
					pid=rs.getInt("pid");
					String date=rs.getString("date");
					String slot=rs.getString("slot");
					
					//System.out.println("2");
					Statement stmt1=con.createStatement();
					String sql1="Select name from patients where pid = '"+pid+"'";
					ResultSet rs1=stmt1.executeQuery(sql1);
					//System.out.println("3");
					if(rs1.next()) {
						//System.out.println("4");
						String docname=rs1.getString("name");
						String id=Integer.toString(pid);
						display=id+"        "+docname+"      "+date+"         "+slot;
						DLM.addElement(display);
						
					}
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		list.setModel(DLM);
		
		
		
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.setBounds(451, 381, 97, 25);
		contentPane.add(button);
		
		JLabel lblId = new JLabel("  ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(44, 95, 26, 16);
		contentPane.add(lblId);
	}

}
