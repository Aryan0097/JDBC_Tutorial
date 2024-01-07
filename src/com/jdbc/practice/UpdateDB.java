package com.jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDB {
	public static void main(String args[]) {
		try {
			Connection c=ConnectDB.getConnection();
			
			String query="update table1 set tName=?,tCity=? where tId=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, "Parth");
			ps.setString(2, "Amreli");
			ps.setInt(3, 2);
			ps.executeUpdate();
			
			System.out.println("data updated");
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
