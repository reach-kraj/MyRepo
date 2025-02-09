package predefinedjavaclass;
import java.util.*;
import java.util.LinkedList;

public class LinkedListConcept {

	public static void main(String[] args){
		LinkedList<String> cars=new LinkedList<>();
		cars.add("TATA");
		cars.add("BMW");
		cars.add("Suzuki");
		cars.add("Tesla");
		cars.add("Suzuki");
		cars.add("Honda");
		cars.remove("Tesla");
		System.out.println(cars);
		System.out.println(cars.peekLast());
		System.out.println("Last Index: "+cars.lastIndexOf("Suzuki"));
		LinkedList<String> sedan = (LinkedList<String>) cars.clone();
		Iterator li =cars.descendingIterator();
		while(li.hasNext()) {//hasNext() -> to check the list contain next element in the ArrayList
			System.out.println("Example of Iterator method: "+li.next());
		}
		System.out.println("cloned copy of cars"+sedan);
	}
}
