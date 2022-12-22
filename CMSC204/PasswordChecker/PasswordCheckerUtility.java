import java.util.ArrayList;
import java.util.regex.*;

/**
 * @author Eduardo Gonzalez
 *
 */
public class PasswordCheckerUtility {

	//This method will check the validity of one password and return true if the password 
	//is valid and throw one or more exceptions if invalid.  (Refer to java doc for the list of the exceptions thrown)
	public static boolean isValidPassword(String passwordString) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		//Try calling each method, if any method throws an exception then isValidPassword will catch it and print the corresponding error
		System.out.println("Checking: " + passwordString);
		try {
			isValidLength​(passwordString);
			hasUpperAlpha​(passwordString);
			hasLowerAlpha​(passwordString);
			hasDigit​(passwordString);
			hasSpecialChar​(passwordString);
			NoSameCharInSequence​(passwordString);
			return true; //if the  methods do not throw an exception then password is valid
			
		} catch(LengthException le) {
			le.showMessage();
			throw new LengthException(le.getMessage());
		} catch(NoUpperAlphaException nuae) {
			nuae.showMessage();
			throw new NoUpperAlphaException(nuae.getMessage());
		} catch(NoLowerAlphaException nlae) {
			nlae.showMessage();
			throw new NoLowerAlphaException(nlae.getMessage());
		} catch(NoDigitException nde) {
			nde.showMessage();
			throw new NoDigitException(nde.getMessage());
		} catch(NoSpecialCharacterException nsce) {
			nsce.showMessage();
			throw new NoSpecialCharacterException(nsce.getMessage());
		} catch(InvalidSequenceException ise) {
			ise.showMessage();
			throw new InvalidSequenceException(ise.getMessage());
		}
				
	}
	
	//Checks if password is valid and the length is NOT between 6-9 characters. 
	//It returns false if the password is valid and the length of password is NOT
	//between 6 and 9 (inclusive) and throws WeakPasswordException otherwise. 
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException{
		
		try {
			//if the password length is between 6 and 9 inclusive, while also being an otherwise valid password, throw a WeakPasswordException
			//otherwise the exception will not be thrown and the password will then be strong and return false.
			if(passwordString.length() >= 6 && passwordString.length() <= 9
					                       &&
					      isValidPassword(passwordString) ) {
				System.out.println("Weak password!");
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
			} 
		} catch (WeakPasswordException wpe) {
			throw new WeakPasswordException(wpe.getMessage());
		} catch (Exception e) { // catches any other exception thrown by isValidPassword() method
			System.out.println(e.getMessage());
		} 
		System.out.println("Strong password!");
		return false;
	}
	
	//This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of 
	//any invalid passwords (weak passwords are not considered invalid).  The ArrayList of invalid passwords will be 
	//of the following format:
	//<password><blank><message of exception thrown>

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>(); //create ArrayList to store invalid passwords
		
		//go through the passwords ArrayList and try calling isValidPassword for each password in passwords
		//if the method call throws an exception, then p will be invalid and it will be added to invalidPasswords 
		for (String p : passwords) {
			try {
				isValidPassword(p);
			} catch (Exception e) {
				invalidPasswords.add(p + " -> " + e.getMessage());
			} 
		}
		return invalidPasswords; //Return the invalidPasswords
	}

	//Compare equality of two passwords
	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException{
		
		if(password.equals(passwordConfirm)) {
			System.out.println("Passwords match");
		} else {
			throw new UnmatchedException("Passwords do not match");
			//System.out.println("Passwords do not match");
		}
	}
	
	//Compare equality of two passwords
	public static boolean comparePasswordsWithReturn​(String passwordString, String passwordAString) {
		
		if(passwordString.equals(passwordAString)) {
			System.out.println("Passwords match");
			return true;
		} else {
			System.out.println("Passwords don't match");
			return false;
		}
	}

	//Checks the password length requirement
	//The password must be at least 6 characters long
	public static boolean isValidLength​(String password) throws LengthException {
		if(password.length() >= 6) {
			System.out.println("Valid length!");
			return true;
		}
		throw new LengthException("The password must be at least 6 characters long");
	}
	
	//Checks the password alpha character requirement 
	//Password must contain an uppercase alpha character
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException{
		//change individual chars in password to their corresponding ASCII value to check for uppercase alpha characters
		int numChar;
		for (int i = 0; i < password.length(); i++) {
			numChar = password.charAt(i);
			if(numChar >= 65 && numChar <= 90) {
				System.out.println("Uppercase found!");
				return true;
			}
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	//Checks the password lowercase requirement - 
	//Password must contain at least one lowercase alpha character
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException{
		//change individual chars in password to their corresponding ASCII value to check for lowercase alpha characters
		int numChar;
		for (int i = 0; i < password.length(); i++) {
			numChar = password.charAt(i);
			if(numChar >= 97 && numChar <= 122) {
				System.out.println("Lowercase found!");
				return true;
			}
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}

	//Checks the password Digit requirement - Password must contain a numeric character
	public static boolean hasDigit​(String password) throws NoDigitException{
		//create a char array of the password String and use Character class method isDigit to check for digits
	    char[] chars = password.toCharArray();
	    for(char c : chars){
	        if(Character.isDigit(c)){
	        	 System.out.println("Digit found!");
	        	 return true;
	        }
	    }
		throw new NoDigitException("The password must contain at least one digit");
	}
	
	//Checks the password SpecialCharacter requirement - Password must contain a Special Character
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException{
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
	
		if(!matcher.matches()) {
	        System.out.println("Special char found!");
			return true;
		} else {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
	}
	
	//Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException{
		
		//change password String to a char array
		char[] passwordToCharArray = password.toCharArray();
		//loop through the char array and starting from the third char, check if it is equal to the previous two chars
		//if the check is true, throw an InvalidSequenceException
		for (int i = 0; i < passwordToCharArray.length; i++) {
			Character ch = passwordToCharArray[i];
			if (i >= 2) {
				if (ch.equals(passwordToCharArray[i-1]) && ch.equals(passwordToCharArray[i-2])) {
					//throw the exception if the loop ends and it does not satisfy the requirement
					throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
				}	
			}
				
		}
		return true; // if no exception is thrown then return true because no sequence error was found in the password
	}

}
