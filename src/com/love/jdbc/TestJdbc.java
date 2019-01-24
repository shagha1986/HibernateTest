package com.love.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSl=false";
		String Username = "root";
		String Pass = "root";
		
		try {
			
		System.out.println("Connectiong to database .. " + jdbcUrl);
		Connection myConn = DriverManager.getConnection(jdbcUrl, Username, Pass);
		
		System.out.println("connection was successful!!");
	}catch(Exception e) {
		e.printStackTrace();
	}

}//the End of main function
}//end of class
