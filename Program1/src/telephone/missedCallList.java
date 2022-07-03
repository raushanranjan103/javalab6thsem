package telephone;
import java.util.*;

public class missedCallList {
	
	private static ArrayList<missedCall> mc = new ArrayList<missedCall>();
	private Calendar date = Calendar.getInstance();
	private contactList cl = new contactList();
	Scanner sc = new Scanner(System.in);
	
	void registerMissedCall(String phone) {
		if(mc.size() == 10)
			mc.remove(0);
		
		contact c = cl.getContact(phone);
		if(c != null)
			mc.add(new missedCall(c, date.getTime()));
		else
			mc.add(new missedCall(new contact("Private Caller" , phone), date.getTime()));
	}
	
	void missedCallDirectory() {
		
		if(mc.size() == 0) {
			System.out.println("Missed Call directory is empty.");
			return;
		}
		System.out.println("After each number display, press");
		System.out.println("\t 1.To delete the call");
		System.out.println("\t 2.Go to the next call");
		System.out.println("\t 3.To display the call details");
		
		Iterator<missedCall> it = mc.iterator();
		while(it.hasNext()) {
			missedCall m = it.next();
			System.out.println("\nMissed call from : " + m.c.phone);
			System.out.print("Enter the operation : ");
			int x = sc.nextInt(); sc.nextLine();
			
			switch (x) {
				case 1: it.remove();
						break;
				
				case 2: break;
				
				case 3: System.out.println(m);
						break;
						
				default: System.out.println("Invalid Input.");
						 break;
			}
		}
	}
	
	void viewAll() {
		for(missedCall m : mc)
			System.out.println(m);
	}
}