package predefinedjavaclass;

import java.util.Vector;

public class VectorConcept {
	public static void main(String[] args) {
		Vector<String> fn = new Vector<String>();
		fn.add("MongoDB");
		fn.add("Table");
		fn.add("Records");
		fn.add("Update");
		fn.add("Delete");
		System.out.println("Vector a before using add method : " + fn);

		// add
		fn.add(3, "Insert");
		System.out.println("Vector a after using add method : " + fn);

		// capacity
		System.out.println(" ");
		int vectorCapacity = fn.capacity();
		System.out.println("The Capacity of this Vector is  " + vectorCapacity);

		// Size
		System.out.println(" ");
		int size = fn.size();
		System.out.println("The size of this Vector is " + size);

		// clear
		// fn.clear();
		// System.out.println("Vector vt after using clear method : "+fn);

		// contains
		System.out.println(" ");
		System.out.println("If Given input present in Vector return 'True' else 'False': ");
		boolean a = fn.contains("MongoDB");
		System.out.println("1: " + a);

		boolean b = fn.contains("date");
		System.out.println("2: " + b);

		// Equals
		System.out.println(" ");
		System.out.println("If Given input Equals in Vector return 'True' else 'False': ");
		Vector<Integer> a1 = new Vector<Integer>();
		a1.add(100);
		a1.add(150);
		a1.add(200);

		Vector<Integer> b1 = new Vector<Integer>();
		b1.add(200);
		b1.add(10);
		b1.add(1);

		Vector<Integer> c1 = new Vector<Integer>();
		c1.add(200);
		c1.add(10);
		c1.add(1);

		boolean v = a1.equals(b1);
		System.out.println(v);

		boolean v1 = b1.equals(c1);
		System.out.println(v1);

		// firstelement
		System.out.println(" ");
		System.out.println("The First Element in the Vector is: " + fn.firstElement());

		// element at a specific position
		System.out.println(" ");
		System.out.println("The element at index position 0 is : " + fn.get(0));
		System.out.println("The element at index position 5 is : " + fn.get(5));

		// index of
		System.out.println(" ");
		int indexElement = fn.indexOf("Update");
		System.out.println("The indexOf element in the Vector is : " + indexElement);

	}
}
