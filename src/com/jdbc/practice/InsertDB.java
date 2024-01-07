package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class InsertDB {
	public static void main(String args[]) {
		try {
			
			Connection con=ConnectDB.getConnection();		

			String query="insert into table1(tName,tCity) values(?,?)";
					
			//****object-->PreparedStatement and method prepareStarement ---  --> "there is diffrencr in prepared and prepare"
			PreparedStatement pstmt=con.prepareStatement(query);
					
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name:");
			String name=br.readLine();
					
			System.out.println("Enter City:");
			String city=br.readLine();
					
			//set valued in query
			pstmt.setString(1, name);
			pstmt.setString(2, city);
				
			pstmt.executeUpdate();
			System.out.println("Data inserted...");
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
