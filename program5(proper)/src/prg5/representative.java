package prg5;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class representative {
	
	JFrame frame;
	JPanel panel;
	GridBagConstraints gbc;
	JTextField[] jtf = new JTextField[5];
	JButton submit , close;
	Connection con;
	
	representative(Connection con) {
		this.con = con;
		frame = new JFrame("Add Representative");
		frame.setSize(500, 500);
		panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		showForm();
	}
	
	String getString() {
		return "INSERT INTO representative VALUES(" + Integer.parseInt(jtf[0].getText()) + ",'" + jtf[1].getText() + "'," + "'" + jtf[2].getText() + "'," + Double.parseDouble(jtf[3].getText()) + "," + Double.parseDouble(jtf[4].getText()) + ");";
	}
	
	void clearForm() {
		for(int i = 0 ; i < 5 ; i++)
			jtf[i].setText(null);
	}
	
	void showForm() {
		gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.ipady = 8;
		
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		panel.add(new JLabel("Representative No : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		jtf[0] = new JTextField(10);
		panel.add(jtf[0] , gbc);
		
		gbc.gridy = 1;
		
		gbc.gridx = 0;
		panel.add(new JLabel("Representative Name : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		jtf[1] = new JTextField(10);
		panel.add(jtf[1] , gbc);
		
		gbc.gridy = 2;
		
		gbc.gridx = 0;
		panel.add(new JLabel("State : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		jtf[2] = new JTextField(10);
		panel.add(jtf[2] , gbc);
		
		gbc.gridy = 3;
		
		gbc.gridx = 0;
		panel.add(new JLabel("Commision : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		jtf[3] = new JTextField(10);
		panel.add(jtf[3] , gbc);
			
		gbc.gridy = 4;
		
		gbc.gridx = 0;
		panel.add(new JLabel("Rate : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		jtf[4] = new JTextField(10);
		panel.add(jtf[4] , gbc);
		
		gbc.gridy = 7;
		
		gbc.gridx = 0;
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeUpdate(getString());
					System.out.println("Executed successfully");
					clearForm();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
//					e.printStackTrace();
				}
				
			}
		});
		panel.add(submit , gbc);
		
		gbc.gridx = 1;
		close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		panel.add(close , gbc);

		frame.add(panel);
		frame.setVisible(true);
	}
	
}