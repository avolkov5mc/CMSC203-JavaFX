/*
Class: CMSC203 CRN 30339
Program: Assignment #4
Instructor: Grigoriy Grinberg
Summary of Description: Calculates and stores information about plots of land and properties.
Due Date: 4/1/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Alexei Volkov
*/

package CMSC203_Assignment4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlotTestStudent {

	@Test
	public void testOverlaps() {
		Plot p1 = new Plot(2, 4, 5, 5);
		Plot p2 = new Plot(1, 5, 3, 2);
		Plot p3 = new Plot(0,0, 1,1);
		assertTrue(p1.overlaps(p2));
		assertTrue(p2.overlaps(p1));
		assertFalse(p3.overlaps(p2));
		assertFalse(p2.overlaps(p3));
	}

	@Test
	public void testEncompasses() {
		Plot p1 = new Plot(2, 4, 5, 5);
		Plot p2 = new Plot(3, 5, 2, 1);
		Plot p3 = new Plot(0,0, 1,1);
		assertTrue(p1.encompasses(p2));
		assertFalse(p2.encompasses(p3));
		assertFalse(p3.encompasses(p1));
	}
	
	@Test
	public void testToString() {
		Plot p3 = new Plot(0,0, 1,1);
		assertEquals("0,0,1,1",p3.toString());
	}

}
