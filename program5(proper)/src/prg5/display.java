package prg5;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class display {
	
	JFrame frame;
	JPanel panel;
	GridBagConstraints gbc;
	Connection con;
	
	public display(Connection con) {
		frame = new JFrame("Output");
		frame.setSize(500, 500);
		panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.con = con;
		showForm();
	}
	
	public void showForm() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Customer No.");
		dtm.addColumn("Customer Name");
		dtm.addColumn("State");
		dtm.addColumn("Credit");
		dtm.addColumn("Representative No.");
		JTable jt = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(jt);
		
		try {
			Statement st = con.createStatement();
			String query = "SELECT * FROM customer";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int cno = rs.getInt("cusNo");
				String cname = rs.getString("cusName");
				String state = rs.getString("state");
				double credit = rs.getDouble("credit");
				int rno = rs.getInt("repNo");
				dtm.addRow(new Object[] {cno,cname,state,credit,rno});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(scroll , gbc);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		gbc.gridy = 1;
		
		panel.add(close , gbc);
		frame.add(panel);
		
		frame.setVisible(true);
	}
 	
}