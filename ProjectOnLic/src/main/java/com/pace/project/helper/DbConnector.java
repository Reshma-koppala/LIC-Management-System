package com.pace.project.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	// New instance of Connection
		private static Connection connection = null;

		// Opening connection with MYSQL database
		public static Connection createConnection() throws ClassNotFoundException,
				SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// If error occurs type the following code
			//Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/project","root","Reshma@123");
			return connection;
		}

		// Closing connection
		//public static void closeConnection() throws SQLException {
			//connection.close();
		//}

}
