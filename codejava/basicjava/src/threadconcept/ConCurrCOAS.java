package threadconcept;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class SourceList{
	
	CopyOnWriteArraySet<String> cars = new CopyOnWriteArraySet<String>();

	public CopyOnWriteArraySet<String> ccslminputs(String value) {
		
		cars.add(value);
		return cars;
	}

	public void print() {
		System.out.println(cars);
	}
	public void getlist() {

		Iterator itr = cars.iterator();
		 
        // check element is present or not. if not loop will
        // break.
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
	}
}

class tr1 extends Thread{
	private SourceList l1;

	tr1(SourceList l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test3");
	}
}
class tr2 extends Thread{

	private SourceList l1;

	tr2(SourceList l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test2");
	}
}
class tr3 extends Thread{

	private SourceList l1;

	tr3(SourceList l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test1");
	}
}

class tr4 extends Thread{
	private SourceList l1;

	tr4(SourceList l1){
		this.l1=l1;
	}
	public void run() {
			l1.getlist();
	}
}
public class ConCurrCOAS {
	
	public static void main(String[] args) {
		SourceList obj =new SourceList();

		tr1 t1=new tr1(obj);
		tr2 t2=new tr2(obj);
		tr3 t3=new tr3(obj);
		tr4 t4=new tr4(obj);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		obj.print();
	}
}
