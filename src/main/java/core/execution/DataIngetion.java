package core.execution;

import java.sql.*;

import core.config.Config;
import core.domain.DVDMeta;
import core.domain.Inventory;
import core.domain.Reservation;
import core.domain.UserType;
import core.domain.Users;

public class DataIngetion {

	public static void addDvd(DVDMeta dvd) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();

			String sql = "INSERT INTO DVDMETA VALUES ('" + dvd.getTitle() + "', '" + dvd.getYear() + "', '" + dvd.getActors() + "', "
					+ dvd.getImdbRating() + " ,'" + dvd.getFormat() + "'," + dvd.getInventory().getIselNum() + " ,"
					+ dvd.getInventory().getShelfNum() + " ," + dvd.getInventory().getCopyNum() + " )";
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
	
	public static void updateDvd(String title, Inventory inventory) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();

			String sql = "UPDATE DVDMETA " + "SET isle_num = " + inventory.getIselNum() + ", self_num = " + inventory.getShelfNum() + ", copy_num = " + inventory.getCopyNum()
					+ "  WHERE title in ('" + title + "')";

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
	
	public static void addUsers(Users user) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Config.JDBC_DRIVER);

			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			stmt = conn.createStatement();

			String sql = "INSERT INTO USERS VALUES (" + user.getId() + ", '" + user.getType() + "')";
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
	
	public static void main(String[] args) throws SQLException {
		// Create and build tables and database
//		 DataBaseInitialization.initializeDB();
		
		// Add dvd details
//		DVDMeta dvd = new DVDMeta("Movie4", "2014", "Dhanu", 5, "1080i");
//		Inventory inventory = new Inventory();
//		inventory.setIselNum(20);
//		inventory.setShelfNum(2);
//		inventory.setCopyNum(5);
//		dvd.setInventory(inventory);
//		addDvd(dvd);
		
		// Add users
//		Users user = new Users(4, UserType.CUS);
//		addUsers(user);
//		
		// Update Inventory
//		Inventory inventoryUpdate = new Inventory();
//		inventoryUpdate.setIselNum(20);
//		inventoryUpdate.setShelfNum(2);
//		inventoryUpdate.setCopyNum(5);
//		updateDvd("Movie1",inventoryUpdate);
		
		// Check user is employee or customer
//		DataReterival.isEmployeeOrCustomer(1);
		
		// This is to get the balance number of copies
//		int numberOfcopy = DataReterival.searchDvd("Movie1", "2014", 5, "1080i");
//		System.out.println("Number of Copy : " + numberOfcopy);
		
		// This is to reserve the DVD
//		Reservation reserve = new Reservation(3, "Movie1", true);
//		DataReterival.reserveDvd(reserve);
		
		
		
		
		
	}
}