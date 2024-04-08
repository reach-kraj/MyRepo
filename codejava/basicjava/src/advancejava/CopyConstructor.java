package advancejava;

class Student{
	private String name;
	private double gpa;
	
	//parameterized constructor
	Student(String name, double gpa){
		this.name = name;
		this.gpa = gpa;
	}	
//	Copy Constructor
	Student(Student s){
		this.name = s.getName();
		this.gpa = s.getGpa();
	}	
	//getters and setters
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getGpa(){
		return gpa;
	}
	public void setGpa(double gpa){
		this.gpa = gpa;
	}
}

public class CopyConstructor {
	public static void main(String[] args){
		Student s1 = new Student("Justin", 8.5);
		Student cloneOfS1 = new Student(s1);
		
		s1.setName("Jessica");//Changing the original object
		s1.setGpa(9.5);//Changing the original object
		
		System.out.println("Student-1: " + s1.getName()+" "+s1.getGpa());
		System.out.print("Student-2: " +  cloneOfS1.getName()+" "+cloneOfS1.getGpa());
	}
}
