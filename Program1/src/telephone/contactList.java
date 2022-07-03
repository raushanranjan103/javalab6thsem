package telephone;
import java.util.*;

public class contactList {
	private static ArrayList<contact> contacts = new ArrayList<contact>();
	contact getContact(String phone) {
		for(contact c : contacts)
			if(c.phone.equals(phone))
				return c;
		return null;
	}
	
	void createContact(String name , String phone) {
		if(getContact(phone) != null)
			System.out.println("Contact card with the phone number " + phone + " already exists.");
		else {
			contact c = new contact(name, phone);
			contacts.add(c);
			System.out.println("Contact card created successfully");
		}
	}
	
	
}