package javito;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class AdminEladasPanel extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTable table;
	private static String FelhNev;
	String Tabla = "ELADAS";
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEladasPanel frame = new AdminEladasPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */Connection connection = null;
		private JButton btnNewButton_1;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JLabel lblNewLabel;
		private JLabel lblNev;
		private JLabel lblJelszo;
		private JLabel lblEmail;
		private JLabel lblCim;
		private JLabel lblMunkakor;
		private JButton btnNewButton_2;
		private JButton btnNewButton_3;
		private JButton btnNewButton_4;
	public AdminEladasPanel() {
		setFelhNev();
		connection = sqliteConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Lekerdezes");
		btnNewButton.setBounds(44, 357, 89, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 35, 658, 452);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnNewButton_1 = new JButton("Beszuras");
		btnNewButton_1.setBounds(44, 293, 89, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(77, 72, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(77, 102, 86, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(77, 135, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(77, 166, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(77, 198, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(77, 229, 86, 20);
		contentPane.add(textField_5);

		lblNewLabel = new JLabel("ELADAS_KOD");
		lblNewLabel.setBounds(10, 75, 46, 14);
		contentPane.add(lblNewLabel);

		lblNev = new JLabel("SOR_SZAM");
		lblNev.setBounds(10, 105, 46, 14);
		contentPane.add(lblNev);

		lblJelszo = new JLabel("KOD_NEV");
		lblJelszo.setBounds(10, 138, 46, 14);
		contentPane.add(lblJelszo);

		lblEmail = new JLabel("VKOD");
		lblEmail.setBounds(10, 169, 46, 14);
		contentPane.add(lblEmail);

		lblCim = new JLabel("AR");
		lblCim.setBounds(10, 201, 46, 14);
		contentPane.add(lblCim);

		/*lblMunkakor = new JLabel("MUNKAKOR");
		lblMunkakor.setBounds(10, 232, 46, 14);
		contentPane.add(lblMunkakor);*/

		btnNewButton_2 = new JButton("Frissítés");
		btnNewButton_2.setBounds(44, 323, 89, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Törlés");
		btnNewButton_3.setBounds(44, 391, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea(FelhNev);
		textArea.setBounds(742, 11, 89, 16);
		contentPane.add(textArea);
		
		JButton btnNewButton_5 = new JButton("Főmenü");
		btnNewButton_5.setBounds(10, 11, 110, 23);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_4 = new JButton("Mentés txt-be");
		btnNewButton_4.setBounds(44, 425, 89, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPanel window = new AdminPanel();
				dispose();
				window.frame.setVisible(true);
				
				
			}});
		

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					connection = sqliteConnection.dbConnection();
					String query = "Select * from " + Tabla;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					connection = sqliteConnection.dbConnection();
					String query = "Insert into " + Tabla+" (ELADAS_KOD , SOR_SZAM , KOD_NEV , VKOD, AR ) values(?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
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
				try {
					connection = sqliteConnection.dbConnection();
					String query = "Update " + Tabla+" set ELADAS_KOD='" + textField.getText() + "', SOR_SZAM='"
							+ textField_1.getText() + "', KOD_NEV='" + textField_2.getText() + "', VKOD='"
							+ textField_3.getText() + "',AR='" + textField_4.getText() + "';";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sikeres frissítés");
					pst.close();
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					connection = sqliteConnection.dbConnection();
					String query = "delete from " + Tabla+" where ELADAS_KOD='" + textField.getText() + "';";
					PreparedStatement pst = connection.prepareStatement(query);

					pst.execute();
					JOptionPane.showMessageDialog(null, "Sikeres törlés");
					pst.close();
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> txtAdat = new ArrayList();
					connection = sqliteConnection.dbConnection();
					String query = "Select * from " + Tabla;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 while (rs.next()) {
                         String ELADAS_KOD = rs.getString("ELADAS_KOD");
                         String SOR_SZAM = rs.getString("SOR_SZAM");
                         String KOD_NEV  = rs.getString("KOD_NEV");
                         String VKOD = rs.getString("VKOD");
                         String AR = rs.getString("AR");
                         txtAdat.add(ELADAS_KOD + " " + SOR_SZAM + " " + KOD_NEV  + " " + VKOD +" "+AR);
                         writeToFile(txtAdat, "Eladasok.txt");
                 }
                 
					pst.close();
					rs.close();
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

	}
	
	
	
	
	
	public String getFelhNev() {
		return FelhNev;
	}

	public void setFelhNev() {
		FelhNev = Login.getFelhNev();;
	}
	 private static void writeToFile(ArrayList<String> list, String path) {
         BufferedWriter out = null;
         try {
                 File file = new File(path);
                 out = new BufferedWriter(new FileWriter(file, true));
                 for (Object s : list) {
                         out.write((String)s);
                         out.newLine();

                 }
                 out.close();
         } catch (IOException e) {
         }
 }
}
