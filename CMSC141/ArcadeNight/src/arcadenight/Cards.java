package arcadenight;

public class Cards {
	
	 //Fields
	 private int creditBalance;
	 private int ticketBalance;
	 private int cardNumber;
	
	 //Constructors
	 public Cards (int creditBalance, int ticketBalance, int cardNumber) {
		 this.creditBalance = creditBalance;
		 this.ticketBalance = ticketBalance;
		 this.cardNumber    = cardNumber;
	 }
	 
	 //Getters
	 public int getCreditBalance() {
	        return creditBalance;
	 }
	 public int getTicketBalance() {
	        return ticketBalance;
	 }
	 public int getCardNumber() {
	        return cardNumber;
	 }
	 
	 //Setters
	 public void setCreditBalance(int c) {
	        this.creditBalance = c;
	 }
	 public void setTicketBalance(int t) {
	        this.ticketBalance = t;
	 } 
}
