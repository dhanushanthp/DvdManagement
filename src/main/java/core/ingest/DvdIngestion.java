package core.ingest;

import java.sql.*;
import core.config.Config;
import core.domain.DVDMeta;
import core.domain.Inventory;
import core.domain.Users;

public class DvdIngestion {

	public static void initializeDB() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("Registering Database...");
			Class.forName(Config.JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASS);

			System.out.println("Creating database...");
			stmt = conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			String sql = "CREATE DATABASE " + Config.DB;
			stmt.executeUpdate(sql);
			System.out.println("Database " + Config.DB + " created successfully...");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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

		try {
			System.out.println("Registering Database to Create Tables...");
			Class.forName(Config.JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(Config.DB_URL + Config.DB, Config.USER, Config.PASS);

			System.out.println("Creating Tables...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE DVDMETA " 
					+ "(title VARCHAR(255) not NULL, " 
					+ " year YEAR, " 
					+ " actor VARCHAR(255), "
					+ " imd_rating INTEGER, " 
					+ " format VARCHAR(50), " 
					+ " isle_num INTEGER, " 
					+ " self_num INTEGER, " 
					+ " copy_num INTEGER, "
					+ " PRIMARY KEY ( title ))";

			stmt.executeUpdate(sql);
			System.out.println("DVDMETA table has been created...");

			sql = "CREATE TABLE USERS " 
					+ "(id INTEGER not NULL, " 
					+ " type VARCHAR(50), " 
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			System.out.println("USERS table has been created...");

			sql = "CREATE TABLE DVDMANAGEMENT " 
					+ "(reserveid INTEGER not NULL, " 
					+ "userid INTEGER, " 
					+ "dvdid VARCHAR(255), "
					+ "reserved BOOLEAN, " 
					+ "delivered BOOLEAN, " 
					+ "FOREIGN KEY ( userid ) REFERENCES USERS(id), "
					+ "FOREIGN KEY ( dvdid ) REFERENCES DVDMETA(title), " 
					+ "PRIMARY KEY ( reserveid ))";

			stmt.executeUpdate(sql);
			System.out.println("DVDMANAGEMENT table has been created...");
		} catch (SQLException se) {
			se.printStackTrace();
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
		System.out.println("Goodbye!");

	}
	
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
	

	public static void main(String[] args) throws SQLException {
		// Create and build tables and database
		// initializeDB();
		
		// Add dvd details
//		DVDMeta dvd = new DVDMeta("Movie5", "2014", "Dhanu", 5, "1080i");
//		Inventory inventory = new Inventory();
//		inventory.setIselNum(20);
//		inventory.setShelfNum(2);
//		inventory.setCopyNum(5);
//		dvd.setInventory(inventory);
//		addDvd(dvd);
		
		// Add users
//		Users user = new Users(1, UserType.EMP);
//		addUsers(user);
		
		// Update Inventory
//		Inventory inventoryUpdate = new Inventory();
//		inventoryUpdate.setIselNum(20);
//		inventoryUpdate.setShelfNum(2);
//		inventoryUpdate.setCopyNum(5);
//		updateDvd("Movie1",inventoryUpdate);
		
		// Check user is employee or customer
//		isEmployeeOrCustomer(1);
		
//		int numberOfcopy = searchDvd("Movie1", "2014", 5, "1080i");
//		System.out.println("Number of Copy : " + numberOfcopy);
		
		
		
	}
}