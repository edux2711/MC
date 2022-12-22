package accounttest;

public class AccountTest {

	public static void main(String[] args) {
		CheckingAccount p01 = new CheckingAccount();
		p01.balance = 200;
		p01.name    = "Eduardo";
		p01.withdraw(50.0);
		
		Bond p02 = new Bond();
		p02.balance = 1000;
		p02.name    = "Eduardo";
		p02.term    = 60;
		p02.setTermAndRate(p02.term);
		p02.earnInterest();
	}

}
