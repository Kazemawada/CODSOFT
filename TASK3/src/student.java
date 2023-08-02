
public class student {
	
private	String Name;

private int rollnumber;


private double grade;


public String getName() {
	return Name;
}
public int getRollnumber() {
	return rollnumber;
}
public double getGrade() {
	return grade;
}
public void setName(String name) {
	Name = name;
}
public void setRollnumber(int rollnumber) {
	this.rollnumber = rollnumber;
}
public void setGrade(double grade) {
	this.grade = grade;
}
public student(String name, int rollnumber, double grade) {
	
	Name = name;
	this.rollnumber = rollnumber;
	this.grade = grade;
}





	
	
	

}
