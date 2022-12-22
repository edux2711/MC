
public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException(String message) {
		super(message);
	}
	
	public void showMessage() {
		System.out.println("The password must contain at least one lowercase alphabetic character");	
	}
}
