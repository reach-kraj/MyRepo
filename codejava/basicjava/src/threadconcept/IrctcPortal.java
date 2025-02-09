package threadconcept;
class IrctcLogin{
	public void loginDetails(String thread,String name,String name1) {
		System.out.println(thread+" Please Enter UserName: "+name);
		System.out.println(thread+" Please Enter Password: "+name1);
	}
	public void selectTrain(String thread,String src,String dst) {
		System.out.println(thread+" Logging in");
		System.out.println(thread+" Enter Your Source: "+src);
		System.out.println(thread+" Enter Your Destination Station: "+dst);
		System.out.println(thread+" Kindly Select Train from the List");
	}
	public  void checkAvailability(String thread) {
		System.out.println(thread+" Select No of Seat");
		System.out.println(thread+" Enter Passanger Details");
	}
	public  void paymentGateway(String thread,String payment) {
		System.out.println(thread+" UPI, 2.NetBanking, 3.DebitCard,4.CreditCard: "+payment);
	}
	public void transcation(String thread) {
		System.out.println(thread+" Payment Sucessfull");
	}
	public void pnrGeneration(String thread,String name) {
		System.out.println(thread+" Pnr for: "+name);
	}
}

class Thread1 extends Thread {
	IrctcLogin l1;

	Thread1(IrctcLogin l1){
		this.l1=l1;
	}

	public void run() {
		String thread="Thread1";
		String username="user1";
		String password="1q2w3e4r5t6y";
		String src="Villupuram";
		String dst="Egmore";
		String payment="UPI";
		l1.loginDetails(thread,username,password);
//		try { 
//			Thread.sleep(3000);
//		} catch (InterruptedException e) { 
//			e.printStackTrace(); 
//		}
		l1.selectTrain(thread,src,dst);
		l1.checkAvailability(thread);
		l1.paymentGateway(thread,payment);
		l1.transcation(thread);
		l1.pnrGeneration(thread,username);
	}
}

class Thread2 extends Thread {
	IrctcLogin l2;

	Thread2(IrctcLogin l2){
		this.l2=l2;
	}

	public void run() {
		String thread="Thread2";
		String username="user2";
		String password="qwerty12345";
		String src="Egmore";
		String dst="Villupuram";
		String payment="DebitCard";
		l2.loginDetails(thread,username,password);
//		try { 
//			Thread.sleep(3000);
//		} catch (InterruptedException e) { 
//			e.printStackTrace(); 
//		}
		l2.selectTrain(thread,src,dst);
		l2.checkAvailability(thread);
		l2.paymentGateway(thread,payment);
		l2.transcation(thread);
		l2.pnrGeneration(thread,username);
	}
}

public class IrctcPortal{

	public static void main(String[] args) {
		IrctcLogin obj = new IrctcLogin(); 
		Thread1 t1=new Thread1(obj);  
		Thread2 t2=new Thread2(obj);
		t1.start();
		t2.start();
	}
}
