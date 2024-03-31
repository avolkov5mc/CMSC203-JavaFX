package CMSC203_Assignment4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Farnaz Eivazi
 * @version 7/11/2022
 */
class PropertyTestStudent {

	Property property;

	@BeforeEach
	void setUp() throws Exception {
		property = new Property("Citibank", "Rockville", 500.0, "Michael", 2, 4, 5, 5);
	}

	@AfterEach
	void tearDown() throws Exception {
		property = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Citibank", property.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(500.0, property.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(2, property.getPlot().getX());
		assertEquals(4, property.getPlot().getY());
		assertEquals(5, property.getPlot().getWidth());
		assertEquals(5, property.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Citibank,Rockville,Michael,500.0",property.toString());
	}

}
