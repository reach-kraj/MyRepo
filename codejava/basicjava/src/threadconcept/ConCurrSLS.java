package threadconcept;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

class SourceSet {
	ConcurrentSkipListSet<String> cars = new ConcurrentSkipListSet<String>();

	public synchronized ConcurrentSkipListSet<String> ccslminputs(String thread,String value) {
		cars.add(value);
		System.out.println("Printing from Thread "+ thread);
		return cars;
	}

	public void print() {
		System.out.println(cars);
	}

	public void getlist() {

		Iterator itr = cars.iterator();

		// check element is present or not. if not loop will
		// break.
		System.out.println("Printing while Writing");
		while (itr.hasNext()) {
			
			System.out.println("From Set"+itr.next());
		}
	}
}

class trs1 extends Thread {
	private SourceSet l1;

	trs1(SourceSet l1) {
		this.l1 = l1;
	}

	public void run() {
		l1.ccslminputs("Thread_1","Test1");
	}
}

class trs2 extends Thread {

	private SourceSet l1;

	trs2(SourceSet l1) {
		this.l1 = l1;
	}

	public void run() {
		l1.ccslminputs("Thread_2","Test2");
	}
}

class trs3 extends Thread {

	private SourceSet l1;

	trs3(SourceSet l1) {
		this.l1 = l1;
	}

	public void run() {
		l1.ccslminputs("Thread_3","Test3");
	}
}

class trs4 extends Thread {
	private SourceSet l1;

	trs4(SourceSet l1) {
		this.l1 = l1;
	}

	public void run() {
		l1.getlist();
	}
}

public class ConCurrSLS {
	public static void main(String[] args) {
		SourceSet obj = new SourceSet();

		trs1 t1 = new trs1(obj);
		trs2 t2 = new trs2(obj);
		trs3 t3 = new trs3(obj);
		trs4 t4 = new trs4(obj);

		t1.start();
		t2.start();
		t4.start();
		t3.start();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		obj.print();
	}
}


//import java.util.concurrent.ConcurrentSkipListSet;
//
//public class ConcurrSLS {
//    public static void main(String[] args) {
//        // Creating a ConcurrentSkipListSet
//        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
//
//        // Creating multiple threads for writing
//        Thread writer1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                set.add(i);
//                System.out.println(Thread.currentThread().getName() + " added: " + i);
//            }
//        });
//
//        Thread writer2 = new Thread(() -> {
//            for (int i = 5; i < 10; i++) {
//                set.add(i);
//                System.out.println(Thread.currentThread().getName() + " added: " + i);
//            }
//        });
//
//        // Creating multiple threads for deleting
//        Thread deleter1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                set.remove(i);
//                System.out.println(Thread.currentThread().getName() + " removed: " + i);
//            }
//        });
//
//        Thread deleter2 = new Thread(() -> {
//            for (int i = 5; i < 10; i++) {
//                set.remove(i);
//                System.out.println(Thread.currentThread().getName() + " removed: " + i);
//            }
//        });
//
//        // Starting the threads
//        writer1.start();
//        writer2.start();
//        deleter1.start();
//        deleter2.start();
//
//        // Waiting for all threads to finish
//        try {
//            writer1.join();
//            writer2.join();
//            deleter1.join();
//            deleter2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Printing the final set
//        System.out.println("Final Set: " + set);
//    }
//}
