package telephone;

public class contact {
	String name , phone;
	
	public contact(String name , String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String toString() {
		return "Name : " + name + " Phone Number : " + phone ;
	}
}