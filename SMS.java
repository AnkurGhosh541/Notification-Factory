package assignment9;

public class SMS implements Notification {

	@Override
	public void notify1(String to, String message) {
		System.out.println("Sending SMS...");
		System.out.println("To: " + to);
		System.out.println("Message: " + message);
	}

}
