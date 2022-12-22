package eduardoGonzalezJavaLibs;

import javax.swing.JOptionPane;

public class JavaLibsGame {

	public static void main(String[] args) {
		
		
		String user            = JOptionPane.showInputDialog("What is your name? "),
		       bestFriend      = JOptionPane.showInputDialog("What is your best friend's name? "),
		       location        = JOptionPane.showInputDialog("What is your favorite place on Earth? "),
		       food            = JOptionPane.showInputDialog("What is your favorite food? "),
		       favoriteWord    = JOptionPane.showInputDialog("What is your favorite word? ");
		
		int favoriteInt        = Integer.parseInt(JOptionPane.showInputDialog("When is your favorite number? ")),
			age                = Integer.parseInt(JOptionPane.showInputDialog("How old are you? ")),
		    currentYear        = 2022,
		    birthYear          = currentYear - age;

		double favoriteDecimal = Double.parseDouble(JOptionPane.showInputDialog("What is your favorite decimal number? ")),			
		       moneyInBank     = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of money in your bank account: ")),
		       wish            = Double.parseDouble(JOptionPane.showInputDialog("How much money you wish you had in your bank account? ")),
		       missingMoney    = wish - moneyInBank,
		       colorValue      = favoriteDecimal + favoriteInt;
								
		System.out.println("I had a great time with " + user + ", said " + bestFriend + " to his parents. First we visited \n" 
		+ location + ", " + user + " was extremely happy because it is their favorite place on Earth. Then, we entered a restaurant for lunch \n" +
		user + " ordered " + food + " and I ordered chicken soup which was tasty. " + user + " mentioned that his favorite numbers are \n" + 
		favoriteDecimal + " and " + favoriteInt + " Knowing this information, and being the great friend that I am. I decided to gift him a custom \n" +
		"phone case that has a color value of " + colorValue + ", which is the result of his favorite numbers. Even though it \n"
	    + "was an uncommon gift, " + user + " liked it a lot and thought it was interesting. Since " + user + " is older because he was born in the \n" +
	    "year " + birthYear + " they had to pay the lunch and I had to pay the tip. Later, " + user + " told me that the money in the bank account\n" +
	    "was not enough to pay the whole lunch, so he told me to add " + wish + " meaning that " + user + " was missing " + missingMoney + ". Finally,\n" +
	    "we went to the movie theater to watch The Fate Of The " + favoriteWord + " to end the day.");
		
	}

}
