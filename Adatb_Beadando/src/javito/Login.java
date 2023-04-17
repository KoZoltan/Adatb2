package javito;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



import java.sql.*;
import javax.swing.*;
public class Login extends JFrame {

	public JFrame frame;
	public static String FelhNev;
	public static String Munkakor;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connecction = null;
	private JTextField felhasznNev;
	private JTextField felhasznJelsz;
	
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Felhasználónév");
		lblNewLabel.setBounds(45, 80, 88, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblJelszo = new JLabel("Jelszo");
		lblJelszo.setBounds(59, 115, 46, 14);
		frame.getContentPane().add(lblJelszo);
		
		felhasznNev = new JTextField();
		felhasznNev.setBounds(143, 77, 86, 20);
		frame.getContentPane().add(felhasznNev);
		felhasznNev.setColumns(10);
		
		felhasznJelsz = new JTextField();
		felhasznJelsz.setColumns(10);
		felhasznJelsz.setBounds(143, 112, 86, 20);
		frame.getContentPane().add(felhasznJelsz);
		
		JButton loginButton = new JButton("Bejelentkezés");
		loginButton.setBounds(143, 177, 153, 23);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqliteConnection db = new sqliteConnection();
				String nev = felhasznNev.getText();
				String jelszo = felhasznJelsz.getText();
				boolean bejelentkezes = db.ReadData(nev, jelszo);
				db.dbConnection();
				if(bejelentkezes) {
					FelhNev = db.NevLekerdezes(nev,jelszo);
					Munkakor = db.GetMunkakor(nev);
					if(Munkakor.equalsIgnoreCase("ADMIN")) {
						AdminPanel window = new AdminPanel();
						window.frame.setVisible(true);
						frame.dispose();
						
						
						
					}
					else if (Munkakor.equalsIgnoreCase("ELADO")) {
						EladoPanel window = new EladoPanel();
						window.setVisible(true);
						frame.dispose();
					}
					else if (Munkakor.equalsIgnoreCase("SZERELO")) {
						SzereloPanel window = new SzereloPanel();
						window.setVisible(true);
						frame.dispose();
					}
					
				}
			
			}
		});
		
	}
	public static String getFelhNev() {
		return FelhNev;
	}

	public void setFelhNev(String felhNev) {
		FelhNev = felhNev;
	}
	public static String getMunkakor() {
		return Munkakor;
	}
}
