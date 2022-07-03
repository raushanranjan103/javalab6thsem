package telephone;
import java.util.Date;

public class missedCall {
	contact c;
	Date d;
	
	public missedCall(contact c , Date d) {
		this.c = c;
		this.d = d;
	}
	
	public String toString() {
		return c.toString() + " Time : " + d.toString();
	}
}