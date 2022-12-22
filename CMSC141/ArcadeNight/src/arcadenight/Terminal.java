package arcadenight;
import javax.swing.JOptionPane;

//Converts money to game credits
public class Terminal {
	//Fields 
	private int money;
	private int credits;
	private Prize prize1;
	private Prize prize2;
	private Prize prize3;
	
	//Constructor
	public Terminal (Prize prize1, Prize prize2, Prize prize3) {
		this.prize1 = prize1;
		this.prize2 = prize2;
		this.prize3 = prize3;
	}
	
	//Returns the number of credits purchased and checks for negative values
	public int convertMoney() {
		money = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to enter?  "));
		while (money < 0) {
			money = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive whole number: "));
		}
		credits = money * 2;
		return credits;
	}
	
	//Prints the information of a card
	public void checkCard(Cards card) {
		System.out.println("Card number:         " + card.getCardNumber()    + "\n"
				         + "Card Credit Balance: " + card.getCreditBalance() + "\n"
				         + "Card Ticket Balance: " + card.getTicketBalance() + "\n");
		
	}
	
	//Transfers credits from the first card entered to the second card entered
	public void transferCredits(Cards card1, Cards card2) {
		
		int transferCredits; //Stores the amount of credits that the user wants to transfer
		transferCredits = Integer.parseInt(JOptionPane.showInputDialog("How many credits would you like to transfer? "));
		
		//Input validation, the amount of credits transferred cannot be grater than the amount stored in the card
		while (transferCredits > card1.getCreditBalance() || transferCredits < 0) {
			transferCredits = Integer.parseInt(JOptionPane.showInputDialog(
					  "The amount you want to transfer is greater than the amount stored in the card from which you wish to transfer. \n"
					+ "Also, the amount cannot be negative.\n"
					+ "Please re-enter the amount you want to transfer: "));
		}
			//Prints the information of the cards before the transfer
			checkCard(card1);
			checkCard(card2);
			
			//Adds the amount of credits that the user wants to transfer to the second card
			card2.setCreditBalance(card2.getCreditBalance() + transferCredits);
			//Subtracts the amount of credits that the user wants to transfer to the first card
			card1.setCreditBalance(card1.getCreditBalance() - transferCredits);	
			
			
			System.out.println("Transferring " + transferCredits + " credits from: ");
			checkCard(card1);
			System.out.println("To: ");
			checkCard(card2);
	}
	
	//Transfer tickets from the first card entered to the second card entered
	public void transferTickets(Cards card1, Cards card2) {

		
		int transferTickets; //Stores the amount of tickets that the user wants to transfer
		transferTickets = Integer.parseInt(JOptionPane.showInputDialog("How many tickets would you like to transfer? "));
		
		//Input validation, the amount of tickets transferred cannot be grater than the amount stored in the card
		while (transferTickets > card1.getTicketBalance() || transferTickets < 0) {
			transferTickets = Integer.parseInt(JOptionPane.showInputDialog(
					  "The amount you want to transfer is greater than the amount stored in the card from which you wish to transfer. \n"
					+ "Also, the amount cannot be negative.\n"
					+ "Please re-enter the amount you want to transfer: "));
		}
		
		
			//Prints the information of the cards before the transfer
			checkCard(card1);
			checkCard(card2);
			
			//Adds the amount of tickets that the user wants to transfer to the second card
			card2.setTicketBalance(card2.getTicketBalance() + transferTickets);
			//Subtracts the amount of tickets that the user wants to transfer to the first card
			card1.setTicketBalance(card1.getTicketBalance() - transferTickets);	

			System.out.println("Transferring " + transferTickets + " tickets from: ");
			checkCard(card1);
			System.out.println("To: ");
			checkCard(card2);
	}
	
	//Decreases the remaining prizes by one after a prize is awarded
	public void decreasePrizeCount(Prize prize) {
		prize.setRemainingPrizes(prize.getRemainingPrizes() - 1); 
	}
	
	//Pays the corresponding amount of tickets after a prize is awarded
	public void decreaseTicketBalance(Prize prize, Cards card) {
		card.setTicketBalance(card.getTicketBalance() - prize.getTicketPrice());
	}
	
	//Awards prize based on how many tickets the user has stores in a card
	public void awardPrize(Cards card) {
		if (card.getTicketBalance() >= prize1.getTicketPrice() && card.getTicketBalance() < prize2.getTicketPrice()) {
			checkCard(card);
			System.out.println("Congratulations!!! you have been awarded the following prize: " + prize1.getPrizeName() + "\n");
			decreaseTicketBalance(prize1, card);
			decreasePrizeCount(prize1);
			checkCard(card);
		}
		else if (card.getTicketBalance() >= prize2.getTicketPrice() && card.getTicketBalance() < prize3.getTicketPrice()) {
			checkCard(card);
			System.out.println("Congratulations!!! you have been awarded the following prize: " + prize2.getPrizeName() + "\n");
			decreaseTicketBalance(prize2, card);
			decreasePrizeCount(prize2);
			checkCard(card);
		}
		else if (card.getTicketBalance() >= prize3.getTicketPrice()) {
			checkCard(card);
			System.out.println("Congratulations!!! you have been awarded the following prize: " + prize3.getPrizeName() + "\n");
			decreaseTicketBalance(prize3, card);
			decreasePrizeCount(prize3);
			checkCard(card);
		}
		else {
			System.out.println("Sorry, you do not have enough tickets to claim a prize right now\n"
				             + "Play more games and come back to earn a prize!");
			
		}
	}
}
