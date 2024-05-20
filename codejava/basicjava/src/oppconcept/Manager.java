package oppconcept;


public class Manager extends Employee {
	
	 public void bonus(int n) {
		 int bonus=n;
		 System.out.println("Bonus for the Employee is: "+bonus);
	 }
	 public void displayInfo() {
	      System.out.println("Manager of So and so company");
	 }
	public static void main(String[] args) {
		Manager c1 =new Manager();
		c1.salary("Test", 30000);
		c1.bonus(2000);
		c1.displayInfo();
	}
}
