package predefinedjavaclass;


public class ArrayListConcept {

	public static void main(String[] args) {
		java.util.ArrayList<String> cars = new java.util.ArrayList<String>();
		cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.remove(2);
	    System.out.println(cars);
	}
}
