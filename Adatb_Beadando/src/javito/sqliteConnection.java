package javito;

import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;

	public static Connection dbConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:C:\\************\\Adatb_Beadando\\Beadando_masodik.db");
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			String productName = databaseMetaData.getDatabaseProductName();
			String productVersion = databaseMetaData.getDatabaseProductVersion();
			String driverName = databaseMetaData.getDriverName();
			String driverVersion = databaseMetaData.getDriverVersion();
			System.out.println(driverName);
			System.out.println(driverVersion);
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}

	public void DisConnenct(Connection conn) {
		try {
			if (conn != null)
				conn.close();
			System.out.println("Sikeres lekapcsolodas az adatbazisrol");
		} catch (SQLException e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
	}

	public boolean ReadData(String felhNev, String felhJelszo) {

		String nev = felhNev;
		String pswd = felhJelszo;
		Boolean siker = false;
		Connection Conn = this.dbConnection();
		String adatb = "SELECT KOD_NEV, JELSZO FROM FELHASZNALO";
		try {
			Statement s = Conn.createStatement();
			ResultSet rs = s.executeQuery(adatb);

			while (rs.next()) {
				if (nev.equalsIgnoreCase(rs.getString("KOD_NEV")) && pswd.equalsIgnoreCase(rs.getString("JELSZO"))) {

					siker = true;

				}
				if (siker == false)
					System.out.println("sikertelen belepes, probald ujra");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		this.DisConnenct(Conn);
		return siker;
	};

	public String GetMunkakor(String FelhNev) {
		Connection Conn = this.dbConnection();
		String adatb = "SELECT MUNKAKOR FROM DOLGOZO WHERE KOD_NEV LIKE"+"'"+FelhNev+"';";
		try {
			Statement s = Conn.createStatement();
			ResultSet rs = s.executeQuery(adatb);
			
			String munkakor = rs.getString("MUNKAKOR");
			rs.close();
			s.close();
			this.DisConnenct(Conn);
			return munkakor;
			
		}
			catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
				this.DisConnenct(Conn);
				return null;
			}
	}
	public	String NevLekerdezes(String nev, String jelszo) {
			String felhNev = null;
			Connection Conn = this.dbConnection();
			String adatb = "SELECT KOD_NEV FROM DOLGOZO WHERE KOD_NEV=" + '"' + nev + '"' + "AND JELSZO=" + '"' + jelszo
					+ '"';
			try {
				Statement s = Conn.createStatement();
				ResultSet rs = s.executeQuery(adatb);
				felhNev = rs.getString("KOD_NEV");
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}

			this.DisConnenct(Conn);
			return felhNev;
		

		
		
		
	}

}
