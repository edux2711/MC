/*
 * Class: CMSC203 35533
 * Instructor: Dr. Tarek
 * Description: 
 
 * Class 1 (RandomNumberGuesser) Driver class that contains main method, this class 
 * contains two loops, one to determine when to end the program by asking the user to 
 * input yes or no. The second loop runs until the user guesses the number correctly.
 * This class utilizes the static methods and variable of the RNG class to get a random number,
 * keep the count of guesses and reset it when necessary, and to validate the guess input
 * to see if it is within the guess boundaries.
  
 * Class 2 (RNG) Provided class that generates a random number by creating an instance 
 * of the random class and provided. This class also provides a method to validate the input.

 * Due: 2/22/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Eduardo Gonzalez
*/

package randomnumberguesser;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		//update variable that will be updated each iteration of the
		//while loop to determine if it will continue or not
		String tryAgain = "yes";
		
		//runs until the user enters no to exit the program
		while (tryAgain.equals("yes")){
			
			//variables that will store the guesses of the user and 
			//a random number between 0 and 100 that the user must guess
			int rndNum = RNG.rand(), guess = 0;
			int lowGuess = 0, highGuess = 100;
			
			System.out.println("Random Number Guesser!\n");
			RNG.resetCount();
			
			do {
				if (RNG.getCount() == 0) {
					System.out.println("Enter your first guess: ");
				}
				else {
					System.out.println("Enter your next guess between " 
							+ lowGuess + " and " + highGuess);
				}
				guess = RNG.scan.nextInt();
				if (RNG.inputValidation(guess, lowGuess, highGuess) == false) {
					guess = RNG.scan.nextInt();
				}
				
				System.out.println("Number of guesses is " + RNG.getCount());
				
				if(guess < rndNum) {
					System.out.println("Your guess is too low");
					lowGuess = guess;
				}
				else if (guess > rndNum) {
					System.out.println("Your guess is too high");
					highGuess = guess;
				}
				
				
			} while (guess != rndNum);
			
			System.out.println("Congratulations... you guessed correctly!\n"
					+ "Would you like to try again?");
			tryAgain = RNG.scan.next();

		} 
		
		System.out.println("Thanks for playing...");
		System.exit(0); 		
		
	}

}
