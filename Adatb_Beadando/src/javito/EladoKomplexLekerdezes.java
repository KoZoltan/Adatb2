package javito;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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

public class EladoKomplexLekerdezes {

	public JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String Tabla = "ELADAS";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EladoKomplexLekerdezes window = new EladoKomplexLekerdezes();
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
	public EladoKomplexLekerdezes() {
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
		panel_1.setBounds(42, 16, 784, 97);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Felt\u00E9tel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("ELADAS_KOD");
		chckbxNewCheckBox_1.setBounds(6, 16, 97, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxMarka_1 = new JCheckBox("SOR_SZAM");
		chckbxMarka_1.setBounds(6, 42, 97, 23);
		panel_1.add(chckbxMarka_1);
		
		JCheckBox chckbxNewCheckBox_1_1_2 = new JCheckBox("KOD_NEV");
		chckbxNewCheckBox_1_1_2.setBounds(6, 68, 97, 23);
		panel_1.add(chckbxNewCheckBox_1_1_2);
		
		JCheckBox chckbxVnev_1 = new JCheckBox("VKOD");
		chckbxVnev_1.setBounds(260, 16, 97, 23);
		panel_1.add(chckbxVnev_1);
		
		JCheckBox chckbxVcim_1 = new JCheckBox("AR");
		chckbxVcim_1.setBounds(260, 42, 97, 23);
		panel_1.add(chckbxVcim_1);
		
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
					
					String whereString= " Where ? and ? and ? and ? and ? );";
					
					connection = sqliteConnection.dbConnection();
					DatabaseMetaData databaseMetaData = connection.getMetaData();
					String query = "Select  * from "+ Tabla +whereString;
					PreparedStatement pst = connection.prepareStatement(query);
				
					
					
					
					String ELADAS_KOD;
					pst.setString(1, ELADAS_KOD= textField.getText());
					String SOR_SZAM;
					pst.setString(2, SOR_SZAM= textField_1.getText());
					String KOD_NEV;
					pst.setString(3, KOD_NEV= textField_2.getText());
					String VKOD;
					pst.setString(4, VKOD= textField_3.getText());
					String AR;
					pst.setString(5, AR= textField_4.getText());
					
				
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
				EladoPanel window = new EladoPanel();
				window.setVisible(true);
				frame.dispose();
			}
			
		});
		
		}
	
}

