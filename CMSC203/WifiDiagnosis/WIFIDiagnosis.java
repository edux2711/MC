/*
 * Class: CMSC203 
 * Instructor: Dr.Tarek
 * Description: (Give a brief description for each Class)
 * Due: 02//2022
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Eduardo Gonzalez
*/


package assignment1;

import  java.util.Scanner;

public class WIFIDiagnosis {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("WI-FI Diagnosis Test\n\n"
						 + "If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n"
				         + "Step 1: Reboot the computer and try to reconnect.\n"
				         + "Did that fix the problem? (yes or no)");
		String vibeCheck = in.next();
		
		//check answer for step 1
		switch(vibeCheck.toLowerCase()) {
			case "yes":
				System.out.println("Great! rebooting the computer seemed to work.");
				System.exit(0);
				break;
			case "no":
				break;
			default:
				System.out.println("Invalid input, please try again.");
				System.exit(0);
		}
		
		//check answer for step 2
		System.out.println("Step 2: Reboot the router and try to connect.\n"
				         + "Did that fix the problem? (yes or no)");
		vibeCheck = in.next();
		
		switch(vibeCheck.toLowerCase()) {
		case "yes":
			System.out.println("Great! rebooting the router seemed to work.");
			System.exit(0);
			break;
		case "no":
			break;
		}
		
		//check answer for step 3
		System.out.println("Step 3: Make sure the cables connecting the router are firmly\n"
				         + "plugged in and power is getting to the router.\n"
		                 + "Did that fix the problem? (yes or no)");
		vibeCheck = in.next();

		switch(vibeCheck.toLowerCase()) {
		case "yes":
			System.out.println("Great! checking cable connectivity seemed to work.");
			System.exit(0);
			break;
		case "no":
			break;
		}
		
		//check answer for step 4
		System.out.println("Step 4: Move the computer closer to the router and try to connect.\n"
		         + "Did that fix the problem? (yes or no)");
		vibeCheck = in.next();

		switch(vibeCheck.toLowerCase()) {
		case "yes":
			System.out.println("Great! moving closer to the computer seemed to work.");
			System.exit(0);
			break;
		case "no":
			break;
		}
		
		//Print step 5 and exit program when the answer to the previous steps is no
		System.out.println("Step 5: Contact your internet service provider (ISP)\n"
				         + "Make sure your ISP is hooked up to your router. ");
		System.exit(0);

		
	}

}
