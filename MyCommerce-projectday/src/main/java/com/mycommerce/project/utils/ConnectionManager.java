package com.mycommerce.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance;
	private Connection conn;
	
	private ConnectionManager() {}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		if(conn==null) {
			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
			} catch ( SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conn;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		conn = null;
	}

}
