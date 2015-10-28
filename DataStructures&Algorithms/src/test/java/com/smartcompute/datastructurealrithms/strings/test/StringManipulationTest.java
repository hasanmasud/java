package com.smartcompute.datastructurealrithms.strings.test;

import junit.framework.TestCase;

import com.smartcompute.datastructurealrithms.strings.CheckAnagram;
import com.smartcompute.datastructurealrithms.strings.DuplicateChars;

public class StringManipulationTest extends TestCase {
	
	// assigning the values
	protected void setUp() {

	}
	
	public void testDuplicateChars(){
		DuplicateChars.printDuplicateChars("javav");
		assertEquals(true, true);
	}
	
	public void testAnagram(){
		assertEquals(true, CheckAnagram.checkAnagram("mary", "army"));
	}
	
}
