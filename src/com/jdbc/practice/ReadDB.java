package com.jdbc.practice;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReadDB {
	public static void main(String args[]) {
		try {
			
			Connection con=ConnectDB.getConnection();
			
			String query="Select * from table1";
			
			Statement stmt=con.createStatement();
			
			// --->  ResultSet :- ResultSet is interface to store data fetched from database and it Object store data in simiiler to table.
			//                 :- data store in ResultSet object is not updateble.
			//                 :- we can only scroll in ResultSet in only forward.---> rset.next() use to get one row forword.
			//															          ---> get element of current row :getString(index or column name),getInt() etc
			ResultSet set=stmt.executeQuery(query);
			
			while(set.next()) {
				System.out.println("Id="+set.getInt(1)+" Name="+set.getString(2)+" City="+set.getString(3));
			}
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
