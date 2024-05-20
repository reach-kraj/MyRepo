package oppconcept;

public class OverLoading extends Polymorphism {

	public void display(){
		System.out.println("example of overridding");
	}
	private void display(int a){
		System.out.println("Arguments: " + a);
	}
	private void display(String a){
		System.out.println("Arguments: " + a);
	}
	private void display(double a, double b){
		System.out.println("Arguments: " + a + " and " + b);
	}

	public static void main(String[] args) {
		OverLoading l1=new OverLoading();
		l1.display();
		l1.display(1);
		l1.display("124cc");
		l1.display(1.25, 4.25);
	}
}
