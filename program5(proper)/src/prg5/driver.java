package prg5;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class driver {
	
	JFrame frame;
	JPanel panel;
	GridBagConstraints gbc;
	static Connection con;
	
	driver() {
		initializeGUI();
	}
 	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/program5","root","Saifrizvi99!");
			System.out.println("Successfully connected");
			driver d = new driver();
			d.showGUI();
		} catch (Exception e) {
			System.out.println("Failure");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	void initializeGUI() {
		frame = new JFrame("Program 5");
		frame.setSize(300, 200);
		panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void showGUI() {
		gbc.fill = GridBagConstraints.BOTH;
	    gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(3, 3, 3, 3);
		
		gbc.gridwidth = 2;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton rep = new JButton("Add Representative");
		rep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new representative(con);
			}
		});
		panel.add(rep, gbc);
		
		gbc.gridy = 1;
		JButton cus = new JButton("Add Customer");
		cus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new customer(con);
			}
		});
		panel.add(cus, gbc);
		
		gbc.gridy = 2;
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new display(con);
			}
		});
		panel.add(display , gbc);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}