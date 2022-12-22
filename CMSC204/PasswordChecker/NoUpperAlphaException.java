
public class NoUpperAlphaException extends Exception {
	
	public NoUpperAlphaException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password must contain at least one uppercase alphabetic character");	
	}
}
