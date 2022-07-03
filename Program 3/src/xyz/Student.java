package xyz;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Student {
String USN,name,address,category;
int age;
double g1,g2,g3,g4,g5,g6,g7,g8,cgpa;
Scanner sc = new Scanner(System.in);
public Student(String name,String usn,String addr, String cat,int
age,double g1,double g2,double g3,double g4,double g5,double g6,double g7,double g8){
this.address = addr;
this.name = name;
this.USN = usn;
this.age = age;
this.category = cat;
this.g1 = g1;
this.g2=g2;
this.g3=g3;
this.g4=g4;
this.g5=g5;
this.g6=g6;
this.g7=g7;
this.g8=g8;

}
public void setCGPA(double g) {
this.cgpa = g;
}
public String toString() {
return "Name: "+ name+"         USN:"+USN+"     AGE"+age+"    Address"+address+"    Category"+category+"    CGPA"+cgpa;
}
}