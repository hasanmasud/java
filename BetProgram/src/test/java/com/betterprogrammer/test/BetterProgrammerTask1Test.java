package com.betterprogrammer.test;

import com.betterprogrammer.BetterProgrammerTask1;

import junit.framework.TestCase;

public class BetterProgrammerTask1Test extends TestCase {
	
	private String value1, value2,value3;

	// assigning the values
	protected void setUp() {
		value1 = "java is a good language";
		value2 = "    java    is a good language   ";
		value3 = "132  c    is best   ";

	}

	// test method to add two values
	public void testCountWords1() {
		double result = BetterProgrammerTask1.countWords(value1);
		assertTrue(result == 5);
	}
	
	public void testCountWords2() {
		double result = BetterProgrammerTask1.countWords(value2);
		assertTrue(result == 5);
	}
	
	public void testCountWords3() {
		double result = BetterProgrammerTask1.countWords(value3);
		assertTrue(result == 4);
	}
}