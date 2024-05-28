package designPatternsFactory;

public class EmailNotification implements Notification{

	public void notifyUser() {
		System.out.println("Sending an E-Mail notification.");
	}
}
