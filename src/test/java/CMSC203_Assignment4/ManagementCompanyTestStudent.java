package CMSC203_Assignment4;
/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 * 
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementCompanyTestStudent {
	Property property1;
	Property property2;
	Property property3;
	ManagementCompany managementCompany;
	
	@Before
	public void setUp() throws Exception {
		managementCompany = new ManagementCompany("Management Inc.", "6687",20);
	}

	@After
	public void tearDown() throws Exception {
		managementCompany =null;
		property1 = null;
		property2 = null;
		property3 = null;
	}

	@Test
	public void testAddProperty() {
		property1 = new Property ("Citibank", "Rockville", 1000, "Michael",5,3,2,1);
		property2 = new Property ("Starbucks", "Rockville", 400, "Brandon",7,4,2,1);
		property3 = new Property ("Target", "Rockville", 1400, "James",0,0,3,3);
		assertEquals(managementCompany.addProperty(property1),0);
		assertEquals(managementCompany.addProperty(property2),1);
		assertEquals(managementCompany.addProperty(property3),2);
	}
	
	@Test
	public void testGetPropertiesCount() {
		property1 = new Property ("Citibank", "Rockville", 1000, "Michael",5,3,2,1);
		property2 = new Property ("Starbucks", "Rockville", 400, "Brandon",7,4,2,1);
		property3 = new Property ("Target", "Rockville", 1400, "James",0,0,3,3);
		assertEquals(managementCompany.addProperty(property1),0);
		assertEquals(managementCompany.addProperty(property2),1);
		assertEquals(managementCompany.addProperty(property3),2);

		assertEquals(managementCompany.getPropertiesCount(), 3);
	}

	@Test
	public void testHighestRentProperty() {
		property1 = new Property ("Citibank", "Rockville", 1000, "Michael",5,3,2,1);
		property2 = new Property ("Starbucks", "Rockville", 400, "Brandon",7,4,2,1);
		property3 = new Property ("Target", "Rockville", 1400, "James",0,0,3,3);
		assertEquals(managementCompany.addProperty(property1),0);
		assertEquals(managementCompany.addProperty(property2),1);
		assertEquals(managementCompany.addProperty(property3),2);

		System.out.println("Expected: " + property3.getPropertyName() + ", got: " + managementCompany.getHighestRentProperty().getPropertyName());
		assertEquals(managementCompany.getHighestRentProperty().getPropertyName(), property3.getPropertyName());
	}

	@Test
	public void testManagementFeeValid() {
		assertTrue(managementCompany.isManagementFeeValid());
	}

	@Test
	public void testToString() {
		property1 = new Property ("Citibank", "Rockville", 1000, "Michael",5,3,2,1);
		property2 = new Property ("Starbucks", "Rockville", 400, "Brandon",7,4,2,1);
		property3 = new Property ("Target", "Rockville", 1400, "James",0,0,3,3);
		assertEquals(managementCompany.addProperty(property1),0);
		assertEquals(managementCompany.addProperty(property2),1);
		assertEquals(managementCompany.addProperty(property3),2);

		String expectedString = "List of the properties for Management Inc., taxID: 6687\n" +
				"______________________________________________________\n" +
				"Citibank,Rockville,Michael,1000.0\n" +
				"Starbucks,Rockville,Brandon,400.0\n" +
				"Target,Rockville,James,1400.0\n" +
				"______________________________________________________\n" +
				"\n" +
				" total management Fee: 560.0";
		System.out.println("Expected: " + expectedString);
		System.out.println("Got: " + managementCompany.toString());
		assertEquals(expectedString, managementCompany.toString());
				
	}

}
