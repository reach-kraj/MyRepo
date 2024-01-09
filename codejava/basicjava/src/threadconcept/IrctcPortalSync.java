package threadconcept;

class IrctcLoginSync {
	synchronized  void loginDetails(String thread,String name,String name1,String src,String dst,String payment) {
		System.out.println(thread+" Please Enter UserName: "+name);
		System.out.println(thread+" Please Enter Password: "+name1);
		System.out.println(thread+" Logging in");
		System.out.println(thread+" Enter Your Source: "+src);
		System.out.println(thread+" Enter Your Destination Station: "+dst);
		System.out.println(thread+" Kindly Select Train from the List");
		System.out.println(thread+" Select No of Seat");
		System.out.println(thread+" Enter Passanger Details");
		System.out.println(thread+" UPI, 2.NetBanking, 3.DebitCard,4.CreditCard: "+payment);
		System.out.println(thread+" Payment Sucessfull");
		System.out.println(thread+" Pnr for: "+name);
	}
}
class ThreadSync1 extends Thread {
	IrctcLoginSync l1;

	ThreadSync1(IrctcLoginSync l1){
		this.l1=l1;
	}
	public void run() {
		String thread="Thread1";
		String username="user1";
		String password="1q2w3e4r5t6y";
		String src="Villupuram";
		String dst="Egmore";
		String payment="UPI";
		l1.loginDetails(thread,username,password,src,dst,payment);
		try { 
			Thread.sleep(3000);
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
	}
}

class ThreadSync2 extends Thread {
	IrctcLoginSync l2;

	ThreadSync2(IrctcLoginSync l2){
		this.l2=l2;
	}
	public void run() {
		String thread="Thread2";
		String username="user2";
		String password="qwerty12345";
		String src="Egmore";
		String dst="Villupuram";
		String payment="DebitCard";
		l2.loginDetails(thread,username,password,src,dst,payment);
		try { 
			Thread.sleep(3000);
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
	}
}
public class IrctcPortalSync {
	public static void main(String[] args) {
		IrctcLoginSync obj = new IrctcLoginSync(); 
		ThreadSync1 t1=new ThreadSync1(obj);  
		ThreadSync2 t2=new ThreadSync2(obj);
		t1.start();
		t2.start();
	}
}
