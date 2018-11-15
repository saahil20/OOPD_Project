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

public class ViewDoc_ForAppointment extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton_1;
	private String patient_username;
	private static String selectedDoctor;
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
		
		this.patient_username = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(199, 59, 195, 22);
		contentPane.add(choice);
		choice.add("OPD");
		choice.add("Cardiology");
		choice.add("ENT");
		choice.add("Gastroenterology");
		choice.add("Gynaecology");
		choice.add("Ophthalmology");
		choice.add("Orthopaedics");
		choice.add("Urology");
		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSelectDepartment.setBounds(55, 62, 137, 16);
		contentPane.add(lblSelectDepartment);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(55, 136, 175, 213);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		list_1.setBounds(267, 136, 175, 213);
		contentPane.add(list_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				try {
					DefaultListModel DLM= new DefaultListModel();
										
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt=con.createStatement();
					String sql="Select name,username, timing from doctor where department='"+choice.getSelectedItem()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						String name=rs.getString("name");
						String username=rs.getString("username");
						String timing = rs.getString("timing");
						//String completeStr = name+" "+rs.getString("timing");
						//DLM.addElement(completeStr);
						DLM.addElement(name);
						list.setModel(DLM);
												
 						
					}
					
					con.close();
				}catch(Exception E) {
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
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
								
				DefaultListModel DLM2= new DefaultListModel();

				if(arg0.getValueIsAdjusting() == false) {
			
					ViewDoc_ForAppointment.selectedDoctor  = list.getSelectedValue().toString();
					//doc name is unique : get timing
					try {
																	
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
						Statement stmt=con.createStatement();
						String sql="Select timing from doctor where name='"+ViewDoc_ForAppointment.selectedDoctor+"'";
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							String timing = rs.getString("timing");
							DLM2.addElement(timing);
							list_1.setModel(DLM2);				
						}						
						con.close();
					}catch(Exception E) {
						System.out.println(E);
						JOptionPane.showMessageDialog(null,E);
					}			

				}
			}
			
		});
		
		
	

	
		btnNewButton_1 = new JButton("Book Appointment");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedDoc = ViewDoc_ForAppointment.selectedDoctor;
				if(!selectedDoc.equals("")) {
					Book_Appointment bookapt = new Book_Appointment(ViewDoc_ForAppointment.selectedDoctor,  patient_username);
					bookapt.setVisible(true);
				}
				//selected=list.getSelectedValue().toString();
				//System.out.print(ViewDoc_ForAppointment.bookingDetails);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(55, 379, 188, 33);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblDoctors = new JLabel("Doctors");
		lblDoctors.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDoctors.setBounds(55, 109, 66, 15);
		contentPane.add(lblDoctors);
		
		JLabel lblTimings = new JLabel("Timings");
		lblTimings.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTimings.setBounds(265, 109, 66, 15);
		contentPane.add(lblTimings);
		
	}
}
