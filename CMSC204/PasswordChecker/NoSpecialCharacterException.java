
public class NoSpecialCharacterException extends Exception {

	public NoSpecialCharacterException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password must contain at least one special character ");
	}
}
