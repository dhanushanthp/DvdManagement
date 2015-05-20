package core.execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import core.config.Config;
import core.domain.Reservation;

public class DataReterival {
	public static String isEmployeeOrCustomer(int id) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();

			String sql = "SELECT type FROM USERS WHERE id = "+id;
			ResultSet response = stmt.executeQuery(sql);
			while (response.next()) {
				String s = response.getString("type");
				return s;
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
	
	public static int searchDvd(String title,String year,int imdbRating, String format) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();

			String sql = "SELECT * FROM DVDMETA WHERE title='"+title+"'AND year = '"+year+"' AND imd_rating = '"+imdbRating+"' AND format='"+format+"'";
			ResultSet response = stmt.executeQuery(sql);
			while (response.next()) {
				int s = response.getInt("self_num");
				return s;
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return 0;
	}
	
	public static void reserveDvd(Reservation reservation) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();
			
			String sql = "INSERT INTO DVDMANAGEMENT (userid,dvdid,reserved,delivered) VALUES (" + reservation.getUserId() + ", '" + reservation.getTitle() + "', " + reservation.isReserved() + ", "
					+ reservation.isDelivered()+" )";
			stmt.executeUpdate(sql);
			System.out.println("Dvd Mera data Has been added.");
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
