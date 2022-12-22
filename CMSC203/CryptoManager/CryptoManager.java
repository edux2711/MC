package encryption;

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//Assign the ASCII integer value to integer variables
		boolean characterOutOfBound = false;
		int characterAt;
		//checks each character of the string passed, if one of the character is not within bounds
		//then the characterOutOfBound variable will be increased by one 
		for(int i = 0; i < plainText.length(); i++) {
			characterAt = plainText.charAt(i);
			if (characterAt >= (int)LOWER_BOUND && characterAt <= (int)UPPER_BOUND) {
				characterOutOfBound = false;
			} else {
				characterOutOfBound = true;
				break;
			}

		}
		//If characterOutOfBound is greater than true then return false because one of the characters in the string is out of bounds
		//else return true because all characters are on bounds when characterOutOfBound is false
		if (characterOutOfBound == true) {
			return false;
		} else {
			return true;
		}

		//throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {		
		String encryptedStr = ""; 
		int    encryptedChar;
		for(int i = 0; i < plainText.length(); i++) {
			encryptedChar = (int)plainText.charAt(i) + key;
			while(encryptedChar > (int)UPPER_BOUND) {
				encryptedChar -= RANGE;
			}
	        encryptedStr += Character.toString(encryptedChar);
		}
		return encryptedStr;
		
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		int diff = plainText.length() - bellasoStr.length();
		for (int i = 0; i < diff; i++) {
			bellasoStr = bellasoStr + bellasoStr.charAt(i);
		}
		
		String encryptedStr = ""; 
		int    encryptedChar;
		for(int i = 0; i < plainText.length(); i++) {
			encryptedChar = plainText.charAt(i) + bellasoStr.charAt(i);
			while (encryptedChar > (int)UPPER_BOUND) {
				encryptedChar -= RANGE;
			}
			encryptedStr += Character.toString(encryptedChar);
		}
		return encryptedStr;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedStr = ""; 
		int    decryptedChar;
		for(int i = 0; i < encryptedText.length(); i++) {
			decryptedChar = (int)encryptedText.charAt(i) - key;
			while(decryptedChar < (int)LOWER_BOUND) {
				decryptedChar += RANGE;
			}
	        decryptedStr += Character.toString(decryptedChar);
		}
		return decryptedStr;
		
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		int diff = encryptedText.length() - bellasoStr.length();
		for (int i = 0; i < diff; i++) {
			bellasoStr = bellasoStr + bellasoStr.charAt(i);
		}
		
		String decryptedStr = ""; 
		int    decryptedChar;
		for(int i = 0; i < encryptedText.length(); i++) {
			decryptedChar = (int)encryptedText.charAt(i) - (int)bellasoStr.charAt(i);
			while(decryptedChar < (int)LOWER_BOUND) {
				decryptedChar += RANGE;
			}
	        decryptedStr += Character.toString(decryptedChar);
		}
		return decryptedStr;
		//throw new RuntimeException("method not implemented");
	}
}