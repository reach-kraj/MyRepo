package javacode;

public class IrctcPortal extends Thread {
	
	public void run() {
		IrctcLogin s1=new IrctcLogin();
		s1.LoginDetails("User");
		
	}

	public static void main(String[] args) {
		IrctcPortal user1=new IrctcPortal();
		IrctcPortal user2=new IrctcPortal();
		
		user1.start();
		user2.start();
	}
}
