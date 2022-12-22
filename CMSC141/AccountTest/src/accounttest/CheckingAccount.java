package accounttest;

public class CheckingAccount {
	public int balance;
	public String name;

	public void withdraw(double x) {
		System.out.println(name + "'s balance is " + balance);

		if (x > balance) {
			System.out.println("Balance is too low to make the withdrawal.");
		}
		else if (x < 0) {
			System.out.println("Invalid number, please enter a positive number.");
		}
		else {
			balance -= x;
			System.out.println( name + "'s new balance is: " + balance);
		}
	}
}
