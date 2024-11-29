package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection connection;
	public static synchronized Connection getConnection() {
		if(connection!=null) {
			return connection;
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/javatest?useUnicode=true&characterEncoding=UTF-8";
				String user = "root";
				String pass = "";
				try {
					connection = DriverManager.getConnection(url, user, pass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public static synchronized void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				connection=null;
			}
		}
	}
}
