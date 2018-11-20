import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;

public class ViewDoc_ForAppointment extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton_1;
	String pat_usr;
	String doc_usr;
	int id;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDoc_ForAppointment frame = new ViewDoc_ForAppointment();
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
	public ViewDoc_ForAppointment(String user) {
		
		this.pat_usr= user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(199, 59, 195, 22);
		contentPane.add(choice);
		
		try {	
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql="Select dept_name from departments";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				choice.add(rs.getString("dept_name"));
			}
			
			con.close();
		 }catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
		}

		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSelectDepartment.setBounds(55, 62, 137, 16);
		contentPane.add(lblSelectDepartment);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(55, 136, 252, 213);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				try {
					DefaultListModel DLM= new DefaultListModel();
										
					
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					String sql="Select name,username, timing from doctor where department='"+choice.getSelectedItem()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						String name=rs.getString("name");
						
						String username=rs.getString("username");
						
						
						DLM.addElement(name);
						list.setModel(DLM);
												
 						
					}
					
					con.close();
				}catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
					JOptionPane.showMessageDialog(null,E);
				}							
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(420, 59, 137, 25);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(420, 383, 137, 25);
		contentPane.add(btnBack);
	
		
		
	

	
		btnNewButton_1 = new JButton("Proceed");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!list.isSelectionEmpty()) {
					doc_usr=list.getSelectedValue().toString();
					try {

						
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=ConnectDB.getConnection();

						Statement stmt=con.createStatement();
						String sql="Select id from doctor where name='"+doc_usr+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							id = rs.getInt("id");
										
						}						
						con.close();
					}catch(Exception E){ Login.ex.logException(E);
						System.out.println(E);
						
					}	
					
					
					
					Book_Appointment bookapt = new Book_Appointment(doc_usr,  pat_usr, id);
					bookapt.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(55, 379, 188, 33);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblDoctors = new JLabel("Doctors");
		lblDoctors.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDoctors.setBounds(69, 107, 66, 15);
		contentPane.add(lblDoctors);
		
		JLabel lblSelectDoctor = new JLabel("Select Doctor");
		lblSelectDoctor.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSelectDoctor.setBounds(55, 13, 137, 16);
		contentPane.add(lblSelectDoctor);
		
		JButton btnGetYourDoctor = new JButton("Get A Suggestion !");
		btnGetYourDoctor.setVerticalAlignment(SwingConstants.TOP);
		btnGetYourDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SmartSearch ob = new SmartSearch();
				ob.setVisible(true);
			}
		});
		btnGetYourDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGetYourDoctor.setBounds(362, 169, 237, 25);
		contentPane.add(btnGetYourDoctor);
		
		JLabel lblNotSureAbout = new JLabel("Not Sure about the doctor ? ");
		lblNotSureAbout.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNotSureAbout.setBounds(387, 138, 195, 16);
		contentPane.add(lblNotSureAbout);
		
	}
}
