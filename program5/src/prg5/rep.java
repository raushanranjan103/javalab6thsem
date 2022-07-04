package prg5;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class rep extends Frame implements ActionListener{
	JLabel no,name,state,comm,rate;
	JTextField notxt,nametxt,statetxt,commtxt,ratetxt;
	JButton submit;
	rep(){
		no = new JLabel("Rep No");
		notxt = new JTextField();
		add(no);
		add(notxt);
		name = new JLabel("Rep Name");
		nametxt = new JTextField();
		add(name);
		add(nametxt);
		state = new JLabel("Rep State");
		statetxt = new JTextField();
		add(state);
		add(statetxt);
		
		comm = new JLabel("Rep Commision");
		commtxt = new JTextField();
		add(comm);
		add(commtxt);
		rate = new JLabel("Rep Rate");
		ratetxt = new JTextField();
		add(rate);
		add(ratetxt);
		submit = new JButton("ADD");
		
		
		
		add(submit);
		setSize(800,600);
		setLayout(new GridLayout(9,2));
		setVisible(true);
		
		
		submit.addActionListener((ActionListener)this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String n = notxt.getText();
			String na = nametxt.getText();
			String c = commtxt.getText();
			String r = ratetxt.getText();
			String s = statetxt.getText();
			
			String sql = "insert into rep(repno,repname,comm,state,rate) values(?,?,?,?,?)";
			
			try {
				PreparedStatement st = connection.c.prepareStatement(sql);
				st.setString(1, n);
				st.setString(2, na);
				st.setString(3, c);
				st.setString(4, s);
				st.setString(5, r);
				st.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}

}