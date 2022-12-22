
public class LengthException extends Exception {
	
	public LengthException(String message) {
		super(message);
	}

	public void showMessage() {
		System.out.println("Password must be at least 6 characters long.");
	}
}
