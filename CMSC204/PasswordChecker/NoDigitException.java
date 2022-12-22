
public class NoDigitException extends Exception {
	
	public NoDigitException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password must contain at least one digit");
	}
}
