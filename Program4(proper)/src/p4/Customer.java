package p4;

import java.util.*;

import javax.swing.JOptionPane;

public class Customer {
	String name, id, mobile;
	
	static private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	Customer validateCustId(String id) {
		for(Customer c: customers) {
			if(c.id.equals(id))
				return c;
		}
		
		Customer c = new Customer();
		c.id=id;
		c.name = JOptionPane.showInputDialog("Enter Customer Name");
		c.mobile = JOptionPane.showInputDialog("Enter Customer Mobile");
		customers.add(c);
		return c;
	}
}
