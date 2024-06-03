package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static Connection con;
	
//	----> create table in database <-----
	
//	//1.load JDBC driver --->in built loader
//	
//
//	Connection con=null;
//	try {
//		String url="jdbc:mysql://localhost:3306/new";
////		String db="new";
//		String username="root";
//		String password="password";
//		
//	//2.create connection
//		con=DriverManager.getConnection(url,username,password);
//		if(con!=null) {
//			System.out.println("Connected to DB..");
//			
//	//3.create Query
//			String query="create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null,tCity varchar(400))";
//			
//	//4.create statement
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeUpdate(query);
//			rs.next();    --> because move pointer in table to first row		
//			System.out.println("Query Executed");
//			con.close();
//			
//		}
//		else {
//			System.out.println("Connection not created");
//		}
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//	}
	
	static Connection getConnection() {
		
		try{

			String url="jdbc:mysql://localhost:3306/new";
			String username="root";
			String password="password";
			
			if(con==null) {
				con=DriverManager.getConnection(url,username,password);
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
	
}
