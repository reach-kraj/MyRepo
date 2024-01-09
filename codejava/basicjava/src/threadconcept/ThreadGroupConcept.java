package threadconcept; 

class ThreadCollection extends Thread { 
	IrctcLoginTGroup l1;
	ThreadCollection(String threadname, ThreadGroup tgobj,IrctcLoginTGroup l1) 
	{ 
		super(tgobj, threadname); 
		this.l1=l1;
		start(); 
	}
	public void run() 
	{ 
		String username="user";
		String password="1q2w3e4r5t6y";
		String src="Villupuram";
		String dst="Egmore";
		String payment="UPI";
		l1.loginDetails(username,password);
		try { 
			try  
	         {  
	             Thread.sleep(10);  
	         }  
	         catch (InterruptedException ex)   
	         {  
	           System.out.println(Thread.currentThread().getName()  
	                                + " interrupted"+ex); 
//	           ex.printStackTrace();
	         }  
			Thread.sleep(3000);
			
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		l1.selectTrain(src,dst);
		l1.checkAvailability();
		l1.paymentGateway(payment);
		l1.transcation();
		l1.pnrGeneration(username);
	}
}
class IrctcLoginTGroup{
	
	public void loginDetails(String username,String password) {
		System.out.println("Please Enter UserName: "+username);
		System.out.println("Please Enter Password: "+password);
	}
	public void selectTrain(String src,String dst) {
		System.out.println("Logging in");
		System.out.println("Enter Your Source: "+src);
		System.out.println("Enter Your Destination Station: "+dst);
		System.out.println("Kindly Select Train from the List");
	}
	public  void checkAvailability( ) {
		System.out.println("Select No of Seat");
		System.out.println("Enter Passanger Details");
	}
	public  void paymentGateway(String payment) {
		System.out.println("UPI, 2.NetBanking, 3.DebitCard,4.CreditCard: "+payment);
	}
	public void transcation( ) {
		System.out.println("Payment Sucessfull");
	}
	public void pnrGeneration( String username) {
		System.out.println("Pnr for: "+username);
	}
}
public class ThreadGroupConcept 
{
	public static void main(String arg[]) throws InterruptedException  { 
		ThreadGroup tg = new ThreadGroup("Parent thread"); 
		IrctcLoginTGroup obj = new IrctcLoginTGroup();
		
		ThreadCollection t1 = new ThreadCollection("ThreadOne", tg,obj); 
		System.out.println("Starting ThreadOne");
		
		ThreadCollection t2 = new ThreadCollection("ThreadTwo", tg,obj); 
		System.out.println("Starting ThreadTwo"); 
		
		t1.interrupt();
		
		System.out.println("No of Active Thread: "+tg.activeCount());
	} 
} 

