package arcadenight;

import java.util.Random;

public class Games {
	
	private int creditPrice;
	private int ticketsAwarded;
	Random rndNum = new Random();
    int randomNum = rndNum.nextInt(10)+1;
	
	//constructor
	public Games (int creditPrice) {
		 this.creditPrice    = creditPrice;		 
		 this.ticketsAwarded = randomNum;
	}
	
	//Swipes a card in a game, if the card has insufficient credits then print error message
	//Else, the payment is subtracted from the card and a random number of tickets is awarded to the card
	public void swipeCard(Cards card) {
		if (card.getCreditBalance() < creditPrice) {
			System.out.println("You have insufficient credits to play this game. \n"
					         + "Buy more credits or play another game.\n");
		}
		else {
			card.setCreditBalance(card.getCreditBalance() - creditPrice);
			card.setTicketBalance(card.getTicketBalance() + ticketsAwarded);
			System.out.println("Card number:        " + card.getCardNumber()     + "\n" +
							   "New credit balance: " + card.getCreditBalance()  + "\n" +
							   "New ticket balance: " + card.getTicketBalance()  + "\n" +
	            			   "Tickets gained:     " + ticketsAwarded           + "\n" +
							   "Credits lost:       " + creditPrice              + "\n");
		}
	}
		
}

