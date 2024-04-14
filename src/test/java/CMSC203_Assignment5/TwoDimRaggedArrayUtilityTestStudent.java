package CMSC203_Assignment5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityTestStudent {

	// Total: 12940, no elements: 18
	private double[][] testdata =
			{{500.0, 800.0, 900.0, 1200.0, 140.00},
			{400.0,500.0, 880.0, 600.0, 1500.0, 300.0, 900.0},
			{700.0,690.0,1200.0,300.0, 650.0, 780.0}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTotal() {
		assertEquals(12940,TwoDimRaggedArrayUtility.getTotal(testdata), 0.1);
	}
	@Test
	public void getLowestInColumn() {
		assertEquals(880.0,TwoDimRaggedArrayUtility.getLowestInColumn(testdata, 2), 0.1);
	}
	@Test
	public void getHighestInColumn() {
		assertEquals(700.0,TwoDimRaggedArrayUtility.getHighestInColumn(testdata, 0), 0.1);
	}
	@Test
	public void getLowestInArray() {
		assertEquals(140.0,TwoDimRaggedArrayUtility.getLowestInArray(testdata), 0.1);
	}
	@Test
	public void getHighestInArray() {
		assertEquals(1500,TwoDimRaggedArrayUtility.getHighestInArray(testdata), 0.1);
	}
	@Test
	public void getHighestInRow() {
		assertEquals(1500,TwoDimRaggedArrayUtility.getHighestInRow(testdata, 1), 0.1);
	}
	@Test
	public void getLowestInRow() {
		assertEquals(140,TwoDimRaggedArrayUtility.getLowestInRow(testdata, 0), 0.1);
	}
	@Test
	public void getAverage() {
		assertEquals(12940/18.0,TwoDimRaggedArrayUtility.getAverage(testdata), 0.1);
	}

}
