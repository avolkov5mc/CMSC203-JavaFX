package CMSC203_Assignment3;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		// get ascii values
		int lowerASCII = LOWER_RANGE;
		int upperASCII = UPPER_RANGE;

		// cycle thru each character
		for(char c : plainText.toCharArray()){
			int charASCII = c;
			if(charASCII < lowerASCII || charASCII > upperASCII){
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if(!isStringInBounds(plainText)){
			return "The selected string is not in bounds, Try again.";
		}
		String temp = "";
		for(char c : plainText.toCharArray()){
			int charASCII = c;
			int newValue = charASCII + key;
			// wrap around by subtracting RANGE from the value until it's within bounds
			while(newValue > UPPER_RANGE){
				newValue -= RANGE;
			}
			temp += (char)newValue;
		}
		return temp;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String fullKey = bellasoStr;
		// build up the full key until it's as long as or longer than the plaintext
		while (fullKey.length() < plainText.length()){
			fullKey += bellasoStr;
		}
		String temp = "";
		// iterate thru plaintext
		for(int i = 0; i < plainText.length(); i++){
			// instead of using a fixed offset - use the corresponding char in the key
			char pChar = plainText.charAt(i);
			char keyChar = fullKey.charAt(i);
			int newValue = pChar + keyChar;
			// wrap around by subtracting RANGE from the value until it's within bounds
			while(newValue > UPPER_RANGE){
				newValue -= RANGE;
			}
			// append the character to the result string
			temp += (char) newValue;
		}
		return temp;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		if(!isStringInBounds(encryptedText)){
			return "The selected string is not in bounds, Try again.";
		}
		String temp = "";
		for(char c : encryptedText.toCharArray()){
			int charASCII = c;
			int newValue = charASCII - key;
			// wrap around by adding RANGE to the value until it's within bounds
			while(newValue < LOWER_RANGE){
				newValue += RANGE;
			}
			temp += (char)newValue;
		}
		return temp;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String fullKey = bellasoStr;
		// build up the full key until it's as long as or longer than the original text
		while (fullKey.length() < encryptedText.length()){
			fullKey += bellasoStr;
		}
		String temp = "";
		// iterate thru encrypted text
		for(int i = 0; i < encryptedText.length(); i++){
			// instead of using a fixed offset - use the corresponding char in the key
			char pChar = encryptedText.charAt(i);
			char keyChar = fullKey.charAt(i);
			int newValue = pChar - keyChar;
			// wrap around by adding RANGE to the value until it's within bounds
			while(newValue < LOWER_RANGE){
				newValue += RANGE;
			}
			// append the character to the result string
			temp += (char) newValue;
		}
		return temp;
	}
}
