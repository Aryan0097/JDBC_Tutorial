package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class InsertImage {
	public static void main(String args[]) {
		try {
			
			Connection c=ConnectDB.getConnection();
			
			String query="insert into images(img) values(?)";
			
			PreparedStatement pstmt=c.prepareStatement(query);
			
			JFileChooser jfc=new JFileChooser();
			jfc.showOpenDialog(null);
			File file=jfc.getSelectedFile();
			FileInputStream fis=new FileInputStream(file);
			pstmt.setBinaryStream(1, fis,fis.available());
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Image Inserted.");
			fis.close();
			c.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
