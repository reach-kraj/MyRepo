package testCase;

interface I1 {
void print();	
}

class C1 implements I1 {

	public void print() {
		System.out.println("Mr.");
	}
}

class C2 implements I1{
	public void print() {
		System.out.println("Mrs.");
	}
}

class C3 implements I1{
	public void print() {
		System.out.println("Ms.");
	}
}
