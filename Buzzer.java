package assignment9;

public class Buzzer implements Notification {

	@Override
	public void notify1(String to, String message) {
		System.out.println("Buzzer Sound!");
	}

}
