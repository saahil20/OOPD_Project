import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Add_department extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Department frame = new Add_Department();
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
	public Add_department() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department Name");
		lblNewLabel.setBounds(49, 40, 126, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(193, 38, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.setBounds(170, 202, 114, 25);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(310, 202, 114, 25);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String deptName = textField.getText();
				
				//add
				try {
					Connection con=ConnectDB.getConnection();
					Statement stmt=con.createStatement();
					
					//check dept already in table
					int flag = 0;
				
					String getAllDept = "Select dept_name from departments";
					ResultSet rs=stmt.executeQuery(getAllDept);
					
					 
				while(rs.next()) {
						//System.out.println(rs.getString("hod_id"));
						if(rs.getString("dept_name").equals(deptName)) {
							flag = 1;
						}
				}
 				
				if(flag == 0) {
 						try {
 							String sql="Insert into departments (dept_name)  VALUES ('"+deptName+"')";
 							
 							Integer rs1=stmt.executeUpdate(sql);
 							if(rs1 > 0) {		
 								JOptionPane.showMessageDialog(null,"Department Added Sucessfully !!");
 								con.close();
 							} else {
 								JOptionPane.showMessageDialog(null,"Department not added.");
 							}			
 						} catch(Exception E){ Login.ex.logException(E);
 							System.out.println(E);
 						}

 					} else {
 						JOptionPane.showMessageDialog(null, "Department already exists!");
 					}
										
				} catch(Exception E){ Login.ex.logException(E);
					System.out.println("Connection to database failed!");
				}
;			}
		});
	}
}
