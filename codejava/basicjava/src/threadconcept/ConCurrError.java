package threadconcept;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CcslmError {

	List<Integer> cars = new ArrayList<Integer>();

	public List<Integer> ccslminput(int key) {
		cars.add(key);
		return cars;
	}

	public void print() {
		Iterator<Integer> iterator = cars.iterator();
		while (iterator.hasNext()) {
			int item = iterator.next();
			System.out.println("Iterating: " + item);
		}
	}
}

class CunCurrThread1 extends Thread {
	private CcslmError l1;

	CunCurrThread1(CcslmError l1) {
		this.l1 = l1;
	}

	public void run() {
		for (int i = 1; i >0; i++) {

			l1.ccslminput(i);
		}
	}
}

class CunCurrThread2 extends Thread {
	private CcslmError l1;

	CunCurrThread2(CcslmError l1) {
		this.l1 = l1;
	}

	public void run() {
			l1.print();
		}
	}

public class ConCurrError {

	public static void main(String[] args) {
		CcslmError obj = new CcslmError();

		CunCurrThread1 t1 = new CunCurrThread1(obj);
		CunCurrThread2 t2 = new CunCurrThread2(obj);

		t1.start();
		t2.start();
	}
}