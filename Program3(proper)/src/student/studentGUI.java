package student;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentGUI {
	private JFrame mainFrame;
	private JPanel panel;
	private ArrayList<ArrayList<String>> stuinfo = new ArrayList<ArrayList<String>>();

	String cats[] = {"GM" ,"OBC" ,"SC" ,"ST"};
	JComboBox<String> category = new JComboBox<String>(cats);

	JTextField nameJTF = new JTextField(50);
	JTextField usnJTF = new JTextField(50);
	JTextField ageJTF = new JTextField(50);
	JTextField addrJTF = new JTextField(50);
	JTextField[] gJTF = new JTextField[8];

	JButton submit = new JButton("Submit");
	JButton display = new JButton("Display");

	JTextArea tArea = new JTextArea();
	JScrollPane scroll;
	
	public studentGUI() {
		initiateGUI();
	}
	
	public static void main(String[] args) {
		studentGUI a = new studentGUI();
		a.createGUI();
	}
	
	private void initiateGUI() {
		mainFrame = new JFrame("Student Information System");
		mainFrame.setSize(1000, 850);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBackground(Color.lightGray);
	}
	
	private void createGUI() {
		for(int i = 0 ; i < 8 ; i++)
			gJTF[i] = new JTextField(15);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 0, 2, 0);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 8;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Name : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(nameJTF , gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("USN : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(usnJTF , gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Age : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(ageJTF , gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Address : " , JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(addrJTF , gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Cateogry : ", JLabel.RIGHT) , gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(category , gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		panel.add(new JLabel("Enter your Results of all 8 Semester!" , JLabel.CENTER) , gbc);
		
		gbc.fill = GridBagConstraints.CENTER;

		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout());
		
		temp.add(new JLabel("SGPA 1 : ", JLabel.RIGHT));
		temp.add(gJTF[0]);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 2 : ", JLabel.RIGHT));
		temp.add(gJTF[1]);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 3 : ", JLabel.RIGHT));
		temp.add(gJTF[2]);
		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 4 : ", JLabel.RIGHT));
		temp.add(gJTF[3]);
		gbc.gridx = 0;
		gbc.gridy = 9;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 5 : ", JLabel.RIGHT));
		temp.add(gJTF[4]);
		gbc.gridx = 0;
		gbc.gridy = 10;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 6 : ", JLabel.RIGHT));
		temp.add(gJTF[5]);
		gbc.gridx = 0;
		gbc.gridy = 11;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 7 : ", JLabel.RIGHT));
		temp.add(gJTF[6]);
		gbc.gridx = 0;
		gbc.gridy = 12;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(new JLabel("SGPA 8 : ", JLabel.RIGHT));
		temp.add(gJTF[7]);
		gbc.gridx = 0;
		gbc.gridy = 13;
		panel.add(temp , gbc);
		
		temp = new JPanel();
		temp.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validate();
			}
		});
		temp.add(display);
		display.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printDetails();
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 14;
		panel.add(temp , gbc);

		temp = new JPanel();
		tArea.setColumns(53);
		tArea.setRows(12);
		tArea.setLineWrap(true);
		tArea.setEditable(false);
    	scroll = new JScrollPane(tArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		temp.add(scroll);
        
		mainFrame.add(new JLabel("Welcome to the SIS." , JLabel.CENTER) , BorderLayout.NORTH);
		mainFrame.add(panel , BorderLayout.CENTER); 
		mainFrame.add(temp , BorderLayout.SOUTH);
		mainFrame.setVisible(true);
	}

	void validate() {
		try {
			String name = nameJTF.getText(0 , Math.min(12, nameJTF.getText().length()));
			String usn = usnJTF.getText().toUpperCase();
			int age = Integer.parseInt(ageJTF.getText());
			String addr = addrJTF.getText(0 , Math.min(12, addrJTF.getText().length()));	
			String cat = (String)category.getSelectedItem();
			Double[] sgpa = new Double[8];
			double cgpa = 0.0;
			
			for(int i = 0 ; i < 8 ; i++) {
				sgpa[i] = Double.parseDouble(gJTF[i].getText());
				cgpa += sgpa[i];
			}
			
			if(usn.length() != 10)
				throw new IllegalArgumentException("USN should be off length 10.");
			
			if(age < 16 || age > 32 )
				throw new IllegalArgumentException("Please enter valid age.");
			
			for(int i = 0 ; i < 8 ; i++)
				if(sgpa[i] < 0 || sgpa[i] > 10)
					throw new IllegalAccessException("The SGPA entered is not valid.\nPlease note to enter SGPA between 0 - 10");
			
			ArrayList<String> t = new ArrayList<>();
			t.add(name);
			t.add(usn);
			t.add(age+"");
			t.add(addr);
			t.add(cat);
			t.add(String.format("%.2f", cgpa/8));
			stuinfo.add(t);
			JOptionPane.showMessageDialog(mainFrame, "Details Recorded Successfully");
			clearForm();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(mainFrame, e.getMessage());
		}
	}
	
	void clearForm() {
		nameJTF.setText(null);
		usnJTF.setText(null);
		ageJTF.setText(null);
		addrJTF.setText(null);
		for(int i = 0 ; i < 8 ; i++)
			gJTF[i].setText(null);
	}
	
	void printDetails() {
		tArea.setText(null);
		String header = "Name\tUSN\tAge\tAddress\tCategory\tCGPA\n";
		tArea.append(header);
		for(ArrayList<String> al : stuinfo) {
			for(String s : al) {
				tArea.append(s + "\t");
			}
			tArea.append("\n");
		}
	}
}