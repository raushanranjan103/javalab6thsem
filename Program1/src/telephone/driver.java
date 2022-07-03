package telephone;
import java.util.*;

public class driver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		contactList cl = new contactList();
		missedCallList mcl = new missedCallList();
		
		System.out.println("1.Create new contact");
		System.out.println("2.Register a missed call");
		System.out.println("3.Missed Call Directory");
		System.out.println("4.View All Missed Calls");
		System.out.println("5.Exit");
		
		boolean flag = true;
		while(flag) {
			System.out.print("\nEnter your choice : ");
			int x = sc.nextInt(); sc.nextLine();
			
			if(x==1) {
				System.out.print("Enter the name : ");
				String name = sc.nextLine();
				System.out.print("Enter the phone : ");
				String phone = sc.nextLine();
				cl.createContact(name, phone);
			} 
			else if(x==2) {
				System.out.print("Enter the phone number : ");
				String phone = sc.nextLine();
				mcl.registerMissedCall(phone);
			}
			else if(x==3)
				mcl.missedCallDirectory();
			else if(x==4)
				mcl.viewAll();
			else if(x==5)
				flag = false;
			else 
				System.out.println("Invalid choice.");
		}
	}
}