package com.revaturebank.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBC {
private static Connection con;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded");
		//Step 2
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="tdas4";
		String password = "test218";
		return  con = DriverManager.getConnection(url, user, password);		
	}

	
	
	
}
