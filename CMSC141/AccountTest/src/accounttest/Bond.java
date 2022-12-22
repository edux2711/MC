package accounttest;

public class Bond {
	public String name;
	public double balance, interestRate;
	public int term, monthsRemaining;
	
	public void setTermAndRate(int t) {
		
		if (t >= 0 && t <= 11) {
			interestRate = 0.005;
		}
		else if (t >= 12 && t <= 23) {
			interestRate = 0.01;
		}
		else if (t >= 24 && t <= 35) {
			interestRate = 0.015;
		}
		else if (t >= 36 && t <= 47) {
			interestRate = 0.02;
		}
		else if (t >= 48 && t <= 60) {
			interestRate = 0.025;
		}
		else {
			System.out.println("Invalid term");
			t = 0;
		}
		term = t;
		monthsRemaining = t;
	}
	
	public void earnInterest() {
		if (monthsRemaining > 0) {
			balance += balance * interestRate / 12;
			monthsRemaining--;
			System.out.println(name + "'s Balance: $" + balance);
			System.out.println(name + "'s Rate: $" + interestRate);
			System.out.println(name + "'s Months Remaining: " + monthsRemaining);
		}
		else {
			System.out.println(name + "'s Bond Matured.");
		}
	}
}
