package p4;

import java.util.*;

import javax.swing.*;

public class Item {
	String name, id;
	double price;
	
	static private ArrayList<Item> items = new ArrayList<Item>();
	
	Item retrieveItem(String id) {
		for(Item i: items)
			if(i.id.equals(id))
				return i;
		
		Item i = new Item();
		i.id=id;
		i.name =JOptionPane.showInputDialog("Enter product name").trim();
		i.price = Double.parseDouble(JOptionPane.showInputDialog("Enter price"));
		items.add(i);
		return i;
	}
}
