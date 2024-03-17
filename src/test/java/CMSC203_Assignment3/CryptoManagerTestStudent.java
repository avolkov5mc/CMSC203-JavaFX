package CMSC203_Assignment3;
/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: Tests cryptomanager methods
* Due: 3/18/2024
* Platform/compiler: IntelliJ
* I pledge that I have completed the programming  assignment independently.
*  I have not copied the code from a student or any source.
*  I have not given my code to any student.
*  Print your Name here: Alexei Volkov
*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CMSC"));
		assertTrue(CryptoManager.isStringInBounds("\"TESTCMSC\""));
		assertFalse(CryptoManager.isStringInBounds("lowercase"));
		assertFalse(CryptoManager.isStringInBounds("lowercase{{"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("9:;<=>?@A", CryptoManager.caesarEncryption("123456789", 8));
		assertEquals(">;BBEMEHB:", CryptoManager.caesarEncryption("HELLOWORLD", 118));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("lowercase", 8));
		assertEquals("J>;VGK?9AV8HEMDV<ENV@KCFIVEL;HVJ>;VB7POV:E=", CryptoManager.caesarEncryption("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 118));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("123456789", CryptoManager.caesarDecryption("9:;<=>?@A", 8));
		assertEquals("HELLOWORLD", CryptoManager.caesarDecryption(">;BBEMEHB:", 118));
		assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", CryptoManager.caesarDecryption("J>;VGK?9AV8HEMDV<ENV@KCFIVEL;HVJ>;VB7POV:E=", 118));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("YR%\\", CryptoManager.bellasoEncryption("CMSC", "VERYVERYLONGCIPHERKEY"));
		assertEquals("KR_O", CryptoManager.bellasoEncryption("CMSC", "HELLOWORLD"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("CMSC", CryptoManager.bellasoDecryption("YR%\\", "VERYVERYLONGCIPHERKEY"));
		assertEquals("CMSC", CryptoManager.bellasoDecryption("KR_O", "HELLOWORLD"));
	}

}
