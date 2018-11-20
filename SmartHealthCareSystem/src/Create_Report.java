import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Create_Report extends JFrame {

	private JPanel contentPane;
	String pname;
	private JTextField detailtxt;
	private JTextField opiniontxt;
	private JTextField prescriptiontxt;
	private JTextField testtxt;
	private JTextField conclusiontxt;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Report frame = new Create_Report();
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
	public Create_Report(int did, int pid,String date) {
		setTitle("Create Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblName.setBounds(42, 39, 56, 16);
		contentPane.add(lblName);
		
		JLabel namelbl = new JLabel("");
		namelbl.setFont(new Font("Arial", Font.PLAIN, 15));
		namelbl.setBounds(110, 39, 178, 16);
		contentPane.add(namelbl);
		
		JLabel lblDetail = new JLabel("Detail");
		lblDetail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDetail.setBounds(42, 96, 56, 16);
		contentPane.add(lblDetail);
		
		detailtxt = new JTextField();
		detailtxt.setFont(new Font("Arial", Font.PLAIN, 15));
		detailtxt.setBounds(140, 96, 282, 55);
		contentPane.add(detailtxt);
		detailtxt.setColumns(10);
		
		JLabel lblDrOpinion = new JLabel("Dr. Opinion");
		lblDrOpinion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDrOpinion.setBounds(42, 181, 80, 16);
		contentPane.add(lblDrOpinion);
		
		opiniontxt = new JTextField();
		opiniontxt.setFont(new Font("Arial", Font.PLAIN, 15));
		opiniontxt.setColumns(10);
		opiniontxt.setBounds(140, 176, 282, 55);
		contentPane.add(opiniontxt);
		
		JLabel lblNewLabel = new JLabel("Prescription");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 254, 80, 16);
		contentPane.add(lblNewLabel);
		
		prescriptiontxt = new JTextField();
		prescriptiontxt.setFont(new Font("Arial", Font.PLAIN, 15));
		prescriptiontxt.setColumns(10);
		prescriptiontxt.setBounds(140, 249, 282, 21);
		contentPane.add(prescriptiontxt);
		
		JLabel lblTestSuggested = new JLabel("Test Suggested");
		lblTestSuggested.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTestSuggested.setBounds(42, 294, 89, 16);
		contentPane.add(lblTestSuggested);
		
		testtxt = new JTextField();
		testtxt.setFont(new Font("Arial", Font.PLAIN, 15));
		testtxt.setBounds(140, 291, 282, 22);
		contentPane.add(testtxt);
		testtxt.setColumns(10);
		
		JLabel lblConclusion = new JLabel("Conclusion");
		lblConclusion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConclusion.setBounds(42, 345, 80, 16);
		contentPane.add(lblConclusion);
		
		conclusiontxt = new JTextField();
		conclusiontxt.setFont(new Font("Arial", Font.PLAIN, 15));
		conclusiontxt.setColumns(10);
		conclusiontxt.setBounds(140, 326, 282, 55);
		contentPane.add(conclusiontxt);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					
					String detail = detailtxt.getText();
					String opinion= opiniontxt.getText();
					String prescription = prescriptiontxt.getText();
				
					String test = testtxt.getText(); 
					String conclusion=conclusiontxt.getText();
	
					String sql="Insert into reports (pid,did,date,detail,d_opinion,prescription,test_suggested,conclusion) VALUES ('"+pid+"','"+did+"','"+date+"','"+detail+"','"+opinion+"','"+prescription+"','"+test+"','"+conclusion+"')";
					
					Integer rs=stmt.executeUpdate(sql);
					
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"Report Created ");
						dispose();
						//contentPane.setVisible(false);
						//Login.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null,"Not Created");
					}
					con.close();
				}catch(Exception E){ Login.ex.logException(E);
					System.out.println(E);
				}
		
				
			}
		});
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCreate.setBounds(210, 395, 97, 25);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(481, 395, 97, 25);
		contentPane.add(btnBack);
		
		JLabel datelbl = new JLabel("");
		datelbl.setBounds(498, 39, 80, 16);
		contentPane.add(datelbl);
		datelbl.setText(date);
		
try {
			
			Connection con=ConnectDB.getConnection();
			Statement stmt=con.createStatement();
			String sql = "Select name from patients where pid = '"+pid+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
					pname=rs.getString("name");
					lblName.setText(pname);
					
				}
			
			con.close();
		} catch(Exception E){ Login.ex.logException(E);
			System.out.println(E);
			JOptionPane.showMessageDialog(null,E);
		}
		
		
	
	
	}
}
