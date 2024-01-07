package com.jdbc.practice;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DisplayImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayImage frame = new DisplayImage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayImage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 900, 550);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		contentPane.setBorder(new LineBorder(Color.black, 2,true));

		setContentPane(contentPane);
		
		JLabel lablId = new JLabel("Enter ID:");
		lablId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lablId.setBounds(62, 142, 75, 45);
		contentPane.add(lablId);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textId.setBounds(147, 142, 96, 45);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel imageLable = new JLabel("");
		imageLable.setBackground(SystemColor.window);
		imageLable.setOpaque(true);
		imageLable.setBounds(372, 84, 428, 345);
		contentPane.add(imageLable);
		
		JButton btn = new JButton("Show Image");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textId.getText();
				int id=Integer.parseInt(str);
				ImageIcon icon=Helper.getImageIconById(id,ConnectDB.getConnection());
				if(icon==null) {
					JOptionPane.showMessageDialog(null, "No image Found for given ID.");
				}
				else {
					imageLable.setIcon(icon);
				}
			}
		});
		btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn.setBounds(88, 256, 142, 38);
		contentPane.add(btn);
		
		JLabel lblNewLabel = new JLabel("Image:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(372, 43, 75, 31);
		contentPane.add(lblNewLabel);
		
		
	}
}
