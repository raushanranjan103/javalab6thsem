package prg5;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class customer extends Frame implements ActionListener{
	JLabel cno,cname,climit,repno;
	JTextField cno_txt,cname_txt,climit_txt,repno_txt;
	JButton submit;
	customer(){
		
		cname = new JLabel("Customer Name");
		cname_txt = new JTextField();
		add(cname);
		add(cname_txt);
		cno = new JLabel("Customer No");
		cno_txt = new JTextField();
		add(cno);
		add(cno_txt);
		climit = new JLabel("Credit Limit");
		climit_txt = new JTextField();
		add(climit);
		add(climit_txt);
		repno =new JLabel("REP No");
		repno_txt = new JTextField();
		add(repno);
		add(repno_txt);
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
			String na=cname_txt.getText();
			String no=cno_txt.getText();
			String cl=climit_txt.getText();
			String repno=repno_txt.getText();
			
			try {
				
				if(Integer.parseInt(cl)>15000){
					String sql1 ="select * from rep where repno = ?";
					PreparedStatement st1 = connection.c.prepareStatement(sql1);
					st1.setString(1,repno);
					ResultSet res = st1.executeQuery();
					while(res.next()) {
						JOptionPane.showMessageDialog(this,"CL>15000\nNAME:"+res.getString("repname"));
					}
					
				}
				
				String sql = "insert into customer(cusno,cusname,climit,repno,state) values(?,?,?,?,?)";
				PreparedStatement st=connection.c.prepareStatement(sql);
				st.setString(1, no);
				st.setString(2, na);
				st.setString(3, cl);
				st.setString(4, repno);
				st.setString(5,"state");//get params correctly..if forgot to consider this
				st.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}