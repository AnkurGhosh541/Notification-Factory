package assignment9;

public class NotificationFactory {
	private Notification notification;
	
	public void sendNotification(String type, String to, String message) {
		notification = null;
		if(type.equalsIgnoreCase("sms")) {
			notification = new SMS();
			notification.notify1(to, message);
		} else if(type.equalsIgnoreCase("e-mail")) {
			notification = new Email();
			notification.notify1(to, message);
		} else if(type.equalsIgnoreCase("buzzer")) {
			notification = new Buzzer();
			notification.notify1(null, null);
		}
	}
}
