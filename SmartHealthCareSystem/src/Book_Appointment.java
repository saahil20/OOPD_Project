import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.time.LocalDateTime;
public class Book_Appointment extends JFrame {

	private JPanel contentPane;
	private String patientUserName;
	private String doc_usr;
	private int id;
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
	public Book_Appointment(String docName, String patientUserName,int id) {
		this.doc_usr=docName;
		this.id=id;
		this.patientUserName = patientUserName;
		//System.out.println(docName+' '+patientUserName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppointmentSummary = new JLabel("Book Appointment");
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
		//label_1.setText(docName);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(261, 153, 133, 15);
		contentPane.add(label_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
			
		});
		btnBack.setBounds(471, 364, 97, 25);
		contentPane.add(btnBack);
		
		Choice choice = new Choice();
		choice.setBounds(249, 184, 195, 22);
		contentPane.add(choice);
		
		try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select * from doc_avaliablity where id = '"+this.id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			int []slots = new int[4];
			
			
			if(rs.next()) {
					slots[0] = rs.getInt("a");
					if(slots[0] == 1)
						choice.add("Slot 1");
					slots[1] = rs.getInt("b");
					if(slots[1] == 1)
						choice.add("Slot 2");
					slots[2] = rs.getInt("c");
					if(slots[2] == 1)
						choice.add("Slot 3");
					slots[3] = rs.getInt("d");
					if(slots[3] == 1)
						choice.add("Slot 4");
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		
		JLabel lblAvaliableSlots = new JLabel("Avaliable Slots");
		lblAvaliableSlots.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblAvaliableSlots.setBounds(72, 189, 147, 15);
		contentPane.add(lblAvaliableSlots);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					String v = choice.getSelectedItem();
					char choosen='\0';
					if(v.equals("Slot 1"))
						choosen='a';
					if(v.equals("Slot 2"))
						choosen='b';
					if(v.equals("Slot 3"))
						choosen='c';
					if(v.equals("Slot 4"))
						choosen='d';
					//String sql = "UPDATE patients set email='"+textField.getText()+"', mobile='"+textField_1.getText()+"' where username = '"+username+"'";
					
					
					int ch=0;
					switch(choosen) {
					case 'a':ch=1;break;
					case 'b':ch=2;break;
					case 'c':ch=3;break;
					case 'd':ch=4;break;
					}
					
					String sql = "SELECT pid from patients where username='"+patientUserName+"'";
					ResultSet rs  = stmt.executeQuery(sql);
					int patientID=0;
					if(rs.next()) {
						patientID = rs.getInt("pid");
					}
					
					String currD = java.time.LocalDate.now().toString();
					//System.out.println(currD);
					String sql1 = "INSERT into appointments (did,pid,date,slot) VALUES ('"+id+"','"+patientID+"','"+currD+"','"+ch+"')";
					stmt.executeUpdate(sql1);
					
					sql = "UPDATE doc_avaliablity set "+choosen+"=0";
					
					stmt.executeUpdate(sql);
					
					con.close();
					dispose();
				}catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
					JOptionPane.showMessageDialog(null,E);
				}
				
			}
		});
		btnBook.setBounds(263, 364, 97, 25);
		contentPane.add(btnBook);
		
		
		try {
			
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql="Select name,timing from doctor where name='"+this.doc_usr+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				label_2.setText(rs.getString("timing"));
				label_1.setText(rs.getString("name"));
			}						
			con.close();
		}catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}			

		
		
	}
}
