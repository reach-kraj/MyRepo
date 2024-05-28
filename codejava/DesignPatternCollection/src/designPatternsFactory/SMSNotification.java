package designPatternsFactory;

public class SMSNotification implements Notification{

	public void notifyUser() {
		System.out.println("Sending a SMS notification");
	}
}
