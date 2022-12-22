
public class WeakPasswordException extends Exception {
	
	public WeakPasswordException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password is OK but weak - it contains fewer than 10 characters.");

	}
}
