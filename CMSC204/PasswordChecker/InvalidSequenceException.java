
public class InvalidSequenceException extends Exception {
	
	public InvalidSequenceException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password cannot contain more than two of the same character in sequence.");
	}
	
}
