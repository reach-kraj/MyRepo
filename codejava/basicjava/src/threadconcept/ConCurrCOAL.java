package threadconcept;

import java.util.concurrent.CopyOnWriteArrayList;

class ccslms{
	
	CopyOnWriteArrayList<String> cars = new CopyOnWriteArrayList<String>();

	public CopyOnWriteArrayList<String> ccslminputs(String value) {
		
		cars.add(value);
		return cars;
	}

	public void print() {
		System.out.println(cars);
	}
	public void getlist(int i) {

		System.out.println(cars.get(i));
	}
}

class trd1s extends Thread{
	private ccslms l1;

	trd1s(ccslms l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test3");
	}
}
class trd2s extends Thread{

	private ccslms l1;

	trd2s(ccslms l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test2");
	}
}
class trd3s extends Thread{

	private ccslms l1;

	trd3s(ccslms l1){
		this.l1=l1;
	}
	public void run() {
		l1.ccslminputs("Test1");
	}
}

class trd4s extends Thread{
	private ccslms l1;

	trd4s(ccslms l1){
		this.l1=l1;
	}
	public void run() {
		for(int i=0;i<3;i++) {
			l1.getlist(i);
		}
	}
}
public class ConCurrCOAL {
	public static void main(String[] args) {
		ccslms obj =new ccslms();

		trd1s t1=new trd1s(obj);
		trd2s t2=new trd2s(obj);
		trd3s t3=new trd3s(obj);
		trd4s t4=new trd4s(obj);

		t1.start();
		t4.start();
		t2.start();
		t3.start();

		obj.print();
	}
}

