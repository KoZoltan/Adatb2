package javito;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AdminPanel {


	public JFrame frame;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connecction = null;
	public AdminPanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 523, 381);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Kijelentkezés");
		btnNewButton.setBounds(402, 11, 95, 23);
		contentPane.add(btnNewButton);

		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00E1bl\u00E1k", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 25, 107, 248);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Dolgozó");
		btnNewButton_1.setBounds(6, 16, 95, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Szervíz");
		btnNewButton_1_1.setBounds(6, 63, 95, 33);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Laptop");
		btnNewButton_1_2.setBounds(6, 110, 95, 33);
		panel.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Vevő");
		btnNewButton_1_3.setBounds(6, 157, 95, 33);
		panel.add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("Eladás");
		btnNewButton_1_4.setBounds(6, 204, 95, 33);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_2_1 = new JButton("Eladott Laptop");
		btnNewButton_1_2_1.setBounds(23, 284, 136, 33);
		contentPane.add(btnNewButton_1_2_1);

		
		
		btnNewButton_1_2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminEladottLaptop frame = new AdminEladottLaptop();
				frame.setVisible(true);

			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDolgozoPanel frame = new AdminDolgozoPanel();
				frame.setVisible(true);

			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminSzervizPanel frame = new AdminSzervizPanel();
				frame.setVisible(true);

			}
		});
		btnNewButton_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminLaptopPanel frame = new AdminLaptopPanel();
				frame.setVisible(true);

			}
		});
		btnNewButton_1_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminVevoPanel frame = new AdminVevoPanel();
				frame.setVisible(true);

			}
		});
		btnNewButton_1_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminEladasPanel frame = new AdminEladasPanel();
				frame.setVisible(true);

			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.frame.dispose();
				frame.frame.setVisible(true);
				

			}
		});
	}
}
