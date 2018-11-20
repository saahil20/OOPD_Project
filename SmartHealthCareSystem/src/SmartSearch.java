import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SmartSearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartSearch frame = new SmartSearch();
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
	public SmartSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Constipation");
		chckbxNewCheckBox.setBounds(37, 125, 113, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxIrregularBowel = new JCheckBox("Irregular Bowel");
		chckbxIrregularBowel.setBounds(164, 125, 117, 25);
		contentPane.add(chckbxIrregularBowel);
		
		JCheckBox chckbxBlood = new JCheckBox("Rectal Bleeding");
		chckbxBlood.setBounds(302, 125, 122, 25);
		contentPane.add(chckbxBlood);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Chest Pain");
		chckbxNewCheckBox_1.setBounds(37, 198, 113, 25);
		contentPane.add(chckbxNewCheckBox_1);
	
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Palpitations");
		chckbxNewCheckBox_2.setBounds(164, 198, 113, 25);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Heart-burn");
		chckbxNewCheckBox_3.setBounds(302, 198, 113, 25);
		contentPane.add(chckbxNewCheckBox_3);
		
		JLabel lblNotFoundYour = new JLabel("Not Found your Symptom ?");
		lblNotFoundYour.setBounds(40, 362, 162, 39);
		contentPane.add(lblNotFoundYour);
		
		JButton btnClickHere = new JButton("Click here");
		btnClickHere.setBounds(204, 369, 97, 25);
		contentPane.add(btnClickHere);
		
		JButton btnGetADoctor = new JButton("Get A Suggestion");
		btnGetADoctor.addActionListener(new ActionListener() {
			int sO=0,sC=0;
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					sO+=5;
				}
				if(chckbxIrregularBowel.isSelected()) {
					sO+=3;
				}
				if(chckbxBlood.isSelected()) {
					sO+=2;
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					sC+=5;
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					sC+=3;
				}
				if(chckbxNewCheckBox_3.isSelected()) {
					sC+=1;
				}
				if(sO > sC) {
					//Assign Gastroenterologist
					JOptionPane.showMessageDialog(null, "GO TO A Gastroenterologist");
					sO=0;sC=0;
				}else {
					//Assign Cardiologist
					JOptionPane.showMessageDialog(null, "GO TO A Cardiologist");
					sO=0;sC=0;
				}
			}
		});
		btnGetADoctor.setBounds(159, 265, 142, 25);
		contentPane.add(btnGetADoctor);
		
		JLabel lblSelectOneOr = new JLabel("Select one or more from the following list of symptoms");
		lblSelectOneOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectOneOr.setBounds(65, 42, 414, 47);
		contentPane.add(lblSelectOneOr);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(497, 369, 97, 25);
		contentPane.add(btnBack);
	}
}
