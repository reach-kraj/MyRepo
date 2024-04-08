package testCase;

public class A1 {
	public 	void print(I1 t1) {
		t1.print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1 obj1=new A1();
		
		C1 a1=new C1();
		C2 a2=new C2();
		C3 a3=new C3();
		
		obj1.print(a1);
		obj1.print(a2);
		obj1.print(a3);
	}
}
