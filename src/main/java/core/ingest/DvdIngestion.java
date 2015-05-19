package core.ingest;

import java.sql.*;

import core.config.Config;

public class DvdIngestion {
	public static void main(String[] args) throws SQLException {
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

			String sql = "CREATE DATABASE STUDENTS";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		} catch (SQLException se) {
			String sql = "USE STUDENTS";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			 String sql = "CREATE TABLE REGISTRATION " +
	                 "(id INTEGER not NULL, " +
	                 " first VARCHAR(255), " + 
	                 " last VARCHAR(255), " + 
	                 " age INTEGER, " + 
	                 " PRIMARY KEY ( id ))"; 

			 stmt.executeUpdate(sql);
			 System.out.println("Table has been created...");
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
}