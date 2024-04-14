package CMSC203_Assignment5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class represents GFA test cases for a HolidayBonus object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class HolidayBonusTestStudent {

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
	public void calculateHolidayBonus() {
		double[] result = HolidayBonus.calculateHolidayBonus(testdata);
		assertEquals(15000.0, result[0], .001);
		assertEquals(12000, result[1], .001);
		assertEquals(20000, result[2], .001);
	}

	@Test
	public void calculateTotalHolidayBonus() {
		assertEquals(47000, HolidayBonus.calculateTotalHolidayBonus(testdata), .001);
	}

}
