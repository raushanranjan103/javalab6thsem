package p4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	JFrame frame;
	JPanel panel;
	JButton additm, total, nextCustomer;
	JTextArea area;
	Customer cust, currentCust;
	Users user;
	Item items;
	static Main m;
	double amount;
	double discount;
	Main(){
		cust = new Customer();
		items = new Item();
		user = new Users();
		initGUI();
	}
	void initGUI() {
		frame = new JFrame("Customer GUI");
		panel = new JPanel();
//		frame.setLayout(new FlowLayout());
		amount=0;
	}
	
	boolean checkUser() {
		String username = JOptionPane.showInputDialog("Enter Username").trim();
		String password = JOptionPane.showInputDialog("Enter Password");
		
		if(user.auth(username, password)) {
			JOptionPane.showMessageDialog(null, "Successfully Logged In");
			return false;
		}else {
			JOptionPane.showMessageDialog(null, "Incorrect Login Details! Please retry.");
			return true;
		}
	}
	
	void accessCust() {
		String cusid = JOptionPane.showInputDialog("Enter Customer ID").trim();
		currentCust = cust.validateCustId(cusid);
		panel.add(new JLabel("Customer ID: "+currentCust.id));
		panel.add(new JLabel("Customer Name: "+currentCust.name));
		panel.add(new JLabel("Customer Mobile: "+currentCust.mobile));
		
		String header[] = new String[] {"Item id", "Item Name", "Price", "Quantity", "Total"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		JTable tb1 = new JTable(dtm);
		panel.add(tb1);
		JLabel total = new JLabel("Total: $0", JLabel.CENTER);
		panel.add(total);
		
		additm = new JButton("Add Item");
		additm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Enter Item Id");
				Item i = items.retrieveItem(id);
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				dtm.addRow(new Object[] {i.id, i.name, i.price, qty, (qty*i.price)});
				amount += qty*i.price;
				total.setText("Total: $"+amount);
			}
		});
		panel.add(additm);
		JButton disc = new JButton("Discount");
		disc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String head[] = new String[] {"7.0", "10.0", "15.0"};
				int x = JOptionPane.showOptionDialog(null, "Choose the needed discount",
		                null,
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, head, head[0]);
				discount = Double.parseDouble(head[x]);
				
			}
		});
		panel.add(disc);
		nextCustomer = new JButton("Next Customer");
		nextCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				amount -=amount*discount/100;
				JOptionPane.showMessageDialog(frame, "Amount to be paid after "+discount+"% discount is : $"+amount);
				frame.dispose();
				initGUI();
				m.accessCust();
			}
		});
		panel.add(nextCustomer);
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
		
		public static void main(String[] args){
			m = new Main();
			while(m.checkUser());
			m.accessCust();
		}
}

