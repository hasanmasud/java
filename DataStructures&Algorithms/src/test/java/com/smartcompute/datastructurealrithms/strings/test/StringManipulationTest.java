package com.smartcompute.datastructurealrithms.strings.test;

import com.smartcompute.datastructurealrithms.strings.StringManipulation;

import junit.framework.TestCase;

public class StringManipulationTest extends TestCase {
	
	// assigning the values
	protected void setUp() {

	}
	
	public void testDuplicateChars(){
		StringManipulation.printDuplicateChars("javav");
		assertEquals(true, true);
	}
	
	public void testAnagram(){
		assertEquals(true, StringManipulation.checkAnagram("mary", "army"));
	}
	
}
