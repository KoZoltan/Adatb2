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
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;

public class AdminEladottLaptop extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEladottLaptop frame = new AdminEladottLaptop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection = null;
	public AdminEladottLaptop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 10, 676, 402);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Főmenü");
		btnNewButton.setBounds(801, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Lekérdezés");
		btnNewButton_1.setBounds(-3, 40, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					connection = sqliteConnection.dbConnection();
					String query = "Select * from LAPTOP INNER JOIN ELADAS ON LAPTOP.SOR_SZAM = ELADAS.SOR_SZAM ";
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
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPanel window = new AdminPanel();
				dispose();
				window.frame.setVisible(true);
				
				
			}});
		
	}
	
}
