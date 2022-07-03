package xyz;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main extends Frame implements ActionListener {

	
ArrayList<Student>slist=new ArrayList<Student>();
public JTextArea area;
public JLabel name,usn,address,age,g1,g2,g3,g4,g5,g6,g7,g8,cat;
public JTextField txtname,txtusn,txtaddr,txtage,txtg1,txtg2,txtg3,txtg4,txtg5,txtg6,txtg7,txtg8;
public JComboBox<String>category;
public JButton submit,display;
public String cats[]= {"GM","BC","SC"};
public Main()
{
	name = new JLabel("NAME");
	txtname = new JTextField("NAME");
	add(name); 
	add(txtname); 
	usn = new JLabel("USN");
	txtusn = new JTextField("ADDRESS");
	add(usn);
	add(txtusn); 
	address = new JLabel("ADDRESS");
	txtaddr = new JTextField(10);
	add(address); 
	add(txtaddr);
	age = new JLabel("AGE");
	txtage = new JTextField();
	add(age); 
	add(txtage); 
	cat = new JLabel("Category");
	category = new JComboBox<String>(cats);
	add(cat);
	add(category);
	g1 = new JLabel("SGPA-1");
	txtg1 = new JTextField();
	add(g1);
	add(txtg1);
	g2 = new JLabel("SGPA-2");
	txtg2 = new JTextField();
	add(g2);
	add(txtg2);
	g3 = new JLabel("SGPA-3");
	txtg3 = new JTextField();
	add(g3);
	add(txtg3);
	g4 = new JLabel("SGPA-4");
	txtg4 = new JTextField();
	add(g4);
	add(txtg4);
	g5 = new JLabel("SGPA-5");
	txtg5 = new JTextField();
	add(g5);
	add(txtg5);
	g6 = new JLabel("SGPA-6");
	txtg6 = new JTextField();
	add(g6);
	add(txtg6);
	g7 = new JLabel("SGPA-7");
	txtg7 = new JTextField();
	add(g7);
	add(txtg7);
	g8 = new JLabel("SGPA-8");
	txtg8 = new JTextField(); 
	add(g8);
	add(txtg8);
	submit = new JButton("sUBMIT");
	add(submit); 
	display = new JButton("dISPLAY");
	add(display);
	area = new JTextArea();
	add(area);
	
	display.addActionListener((ActionListener)this);
	submit.addActionListener((ActionListener)this);
	
}
public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==submit) {
int age=0;
try {
age = Integer.parseInt(txtage.getText());
if(age<0 || age>100)
{

txtage.setText(JOptionPane.showInputDialog(null, "reenter age&quot"));

}
}catch(Exception e) {
txtage.setText(JOptionPane.showInputDialog(null,"reenter age"));
// txtage.requestFocus();

}
}
Student s = new Student(
txtname.getText(),
txtusn.getText(),
txtaddr.getText(),
(String)

category.getItemAt(category.getSelectedIndex()),
Integer.parseInt(txtage.getText()),
Double.parseDouble(txtg1.getText()),
Double.parseDouble(txtg2.getText()),
Double.parseDouble(txtg3.getText()),
Double.parseDouble(txtg4.getText()),
Double.parseDouble(txtg5.getText()),
Double.parseDouble(txtg6.getText()),
Double.parseDouble(txtg7.getText()),
Double.parseDouble(txtg8.getText())

);



double g = (s.g1+s.g2+s.g3+s.g4+s.g5+s.g6+s.g7+s.g8)/8;
s.setCGPA(g);
slist.add(s);

if(ev.getSource()==display) {
area.setText("");
for(Student i:slist)
{
area.setText(area.getText()+i+"\n");
System.out.println(i);
}

}
}
public static void main(String[] args) {
Main m = new Main();
m.setLayout(new GridLayout(15,10));
m.setSize(1000,1500);
m.setVisible(true);
}
}

