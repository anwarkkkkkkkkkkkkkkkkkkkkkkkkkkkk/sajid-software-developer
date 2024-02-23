package com.PersonalInventorySystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	static Connection conn = null;
	public static Connection connectDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			 String url,username,password;
			  url="jdbc:mysql://localhost:3306/PersonalInventorySystem";
			  username="root";
			  password="root";
			  conn = DriverManager.getConnection(url,username,password);
			  System.out.println("Database Connection success PersonalInventorySystem ");
			  
		} catch (ClassNotFoundException e) {
		      e.printStackTrace();
		} 
		catch (SQLException e) {
		e.printStackTrace();
		
		}
		return conn;
		}
		
		public static void main(String[] args) {
			ConnectionPool.connectDB();
		}

}
