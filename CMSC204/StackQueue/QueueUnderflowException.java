package assignment2;

public class QueueUnderflowException extends RuntimeException {
	public QueueUnderflowException() {
		super("Underflow exception!");
	}
}
