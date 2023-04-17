package javito;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SzereloKomplexLekerdezes {

	public JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	String Tabla = "SZERVIZ";



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzereloKomplexLekerdezes window = new SzereloKomplexLekerdezes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	public SzereloKomplexLekerdezes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 146, 1184, 604);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(16, 16, 985, 120);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(297, 16, 529, 97);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Felt\u00E9tel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("SOR_SZAM");
		chckbxNewCheckBox_1.setBounds(6, 16, 97, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxMarka_1 = new JCheckBox("MARKA");
		chckbxMarka_1.setBounds(6, 42, 97, 23);
		panel_1.add(chckbxMarka_1);
		
		JCheckBox chckbxNewCheckBox_1_1_2 = new JCheckBox("HIBA");
		chckbxNewCheckBox_1_1_2.setBounds(6, 68, 97, 23);
		panel_1.add(chckbxNewCheckBox_1_1_2);
		
		JCheckBox chckbxVnev_1 = new JCheckBox("VNEV");
		chckbxVnev_1.setBounds(260, 16, 97, 23);
		panel_1.add(chckbxVnev_1);
		
		JCheckBox chckbxVcim_1 = new JCheckBox("VCIM");
		chckbxVcim_1.setBounds(260, 42, 97, 23);
		panel_1.add(chckbxVcim_1);
		
		JCheckBox chckbxNewCheckBox_1_1_1_1 = new JCheckBox("KOD_NEV");
		chckbxNewCheckBox_1_1_1_1.setBounds(260, 68, 97, 23);
		panel_1.add(chckbxNewCheckBox_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(109, 17, 138, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 43, 138, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 69, 138, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(363, 16, 138, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(363, 42, 138, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(363, 68, 138, 20);
		panel_1.add(textField_5);
		
		JButton btnNewButton = new JButton("Lekérdezés");
		btnNewButton.setBounds(854, 37, 89, 59);
		panel_2.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Főmenü");
		btnNewButton_2.setBounds(1085, 42, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String adattag;
				String parameter;
				
				
				
				try {
					
					String whereString= " Where ?,?,?,?,?,?);";
					
					connection = sqliteConnection.dbConnection();
					String query = "Select  * from "+ Tabla+whereString;
					PreparedStatement pst = connection.prepareStatement(query);
				
					
					String SOR_SZAM;
					pst.setString(7, SOR_SZAM= textField.getText());
					String MARKA;
					pst.setString(8, MARKA= textField_1.getText());
					String HIBA;
					pst.setString(9, HIBA= textField_2.getText());
					String VNEV;
					pst.setString(10, VNEV= textField_3.getText());
					String VCIM;
					pst.setString(11, VCIM= textField_4.getText());
					String KOD_NEV;
					pst.setString(12, KOD_NEV= textField_5.getText());
				
					pst.execute();

					JOptionPane.showMessageDialog(null, "Sikeres adatfelvitel");
					pst.close();

					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SzereloPanel window = new SzereloPanel();
				window.setVisible(true);
				frame.dispose();
			}
			
		});
		
	}
	
}
