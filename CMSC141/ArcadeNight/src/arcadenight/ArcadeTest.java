package arcadenight;

public class ArcadeTest {

	public static void main(String[] args) {
		
		//Creates prize categories
		//                       name            price   Remaining prizes 
		Prize prize3 = new Prize("Mini Car",       50,        15);
		Prize prize2 = new Prize("Teddy Bear",     25,        10);
		Prize prize1 = new Prize("Nerds candy box", 5,         2);
		
		//Creates a terminal object
		Terminal terminal = new Terminal(prize1, prize2, prize3);
		
		//Create cards 
		//                              credits         tickets     card number
		Cards card1 = new Cards(terminal.convertMoney(),   0,          1234);
		terminal.checkCard(card1);
		Cards card2 = new Cards(terminal.convertMoney(),   0,          4321);
		terminal.checkCard(card2);
		
		//Create game objects
		//                      game price
		Games airHockey    = new Games(1);
		Games mortalKombat = new Games(10);
		Games dragonBallZ  = new Games(5);
		
		//Play games with card1
		airHockey.swipeCard(card1);
		mortalKombat.swipeCard(card1);
		dragonBallZ.swipeCard(card1);
		
		//play games with card2
		mortalKombat.swipeCard(card2);
		mortalKombat.swipeCard(card2);
		dragonBallZ.swipeCard(card2);
		dragonBallZ.swipeCard(card2);
		airHockey.swipeCard(card2);
		
		//Transfer credits or tickets or both from card1 to card2
		terminal.transferCredits(card1, card2);
		terminal.transferTickets(card1, card2);
		
		//Claim prizes
        terminal.awardPrize(card2);
        
		dragonBallZ.swipeCard(card1);
        terminal.awardPrize(card1);
	}

}
