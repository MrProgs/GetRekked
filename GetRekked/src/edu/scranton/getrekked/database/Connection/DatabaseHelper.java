package edu.scranton.getrekked.database.Connection;

import java.sql.*;

public class DatabaseHelper {
	Connection mConnection;
	
	public DatabaseHelper(String host, String dbName, String userName, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://" + host.trim() + "/";
			mConnection = DriverManager.getConnection(url + dbName, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * Get a handle on the current connection
	 * @return the current Connection to the Database Server
	 */
	public Connection getConnection() {
		return mConnection;
	}

	/**
	 * Safely close the Connection once client is finished
	 */
	public void close() {
		if (mConnection != null) {
			try {
				mConnection.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
