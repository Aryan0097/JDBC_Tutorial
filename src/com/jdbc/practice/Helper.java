package com.jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper {
	public static ImageIcon getImageIconById(int id,Connection con) {
		ImageIcon icon=null;
				
		try {
			
			String query="Select img from images where Id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet set=ps.executeQuery();
			
			if(set.next()) {
				Blob b=set.getBlob("img");
				InputStream is=b.getBinaryStream();
				Image img=ImageIO.read(is);
				icon=new ImageIcon(img);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return icon;
	}

}
