package core.ingest;

import java.sql.*;

import core.config.Config;

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

	public static void main(String[] args) throws SQLException {
		initializeDB();
	}
}