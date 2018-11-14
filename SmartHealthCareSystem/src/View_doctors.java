import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class View_doctors extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_doctors frame = new View_doctors();
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
	public View_doctors() {
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
		list.setBounds(55, 119, 348, 172);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				try {
					DefaultListModel DLM= new DefaultListModel();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shs","root","");
					Statement stmt=con.createStatement();
					String sql="Select name,username from doctor where department='"+choice.getSelectedItem()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						String name=rs.getString(1);
						String username=rs.getString(2);
						DLM.addElement(name);
						list.setModel(DLM);
						
						//System.out.println(name);
						//System.out.println(username);
					}
					else {
						
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
		
		btnNewButton_1 = new JButton("View Profile");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected="";
				if(!list.isSelectionEmpty()) {
					selected=list.getSelectedValue().toString();
				}
				//selected=list.getSelectedValue().toString();
				System.out.print(selected);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(420, 117, 137, 25);
		contentPane.add(btnNewButton_1);
		
		
	}
}
