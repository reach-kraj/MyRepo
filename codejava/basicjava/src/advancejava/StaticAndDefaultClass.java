package advancejava;


interface TestInterfaces {
	
	void display();  // by default this method is public abstract

	default void show() { // using default keyword we can define a method in interface, from java 1.8
		System.out.println("new feature in java 8....."); 
	}
	
	default void printMessage() {
		System.out.println("testing new feature....");
	}
	
	static void success() { // from java 1.8 we can have static methods in interface
		System.out.println("Transaction success.....");
	}
}

public class StaticAndDefaultClass {
	public void show() { // if we want we can override the default methods here
	System.out.println("overriding the message in interface Test ....");
}

//@Override
public void display() {
	System.out.println("in display method ....");
	
}

public static void main(String[] args) {
	StaticAndDefaultClass obj = new StaticAndDefaultClass();
	obj.show();
	TestInterfaces.success(); // since success is a static method, we can directly call this method with interface name
}

}
