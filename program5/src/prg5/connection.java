package prg5;
import java.sql.*;
public class connection {
	public static Connection c;
	connection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/rj","root","717273");
			System.out.println("connected to databse");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}