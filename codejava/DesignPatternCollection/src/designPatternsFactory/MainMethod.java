package designPatternsFactory;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        Notification notification1 = notificationFactory.createNotification("EMAIL");
       // Notification notification2 = notificationFactory.createNotification("WHATSAPP");
        Notification notification3 = notificationFactory.createNotification("");
        notification.notifyUser();
       // notification3.notifyUser();
        notification1.notifyUser();
       // notification2.notifyUser();
        
	}

}
