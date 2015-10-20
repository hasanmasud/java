package com.betterprogrammer.test;

import junit.framework.TestCase;

import org.junit.Assert;

import com.betterprogrammer.BetterProgrammerTask2;

public class BetterProgrammerTask2Test extends TestCase {
	
	int input1[] = {2,1,2,3};
	int input2[] = {1,1,1,2,2,2};
	int input3[] = {1,2,3,4};
	int input4[] = {1,1,1};
	// assigning the values
	protected void setUp() {
	}
	
	// test method to add two values
	public void testremoveDuplicates1() {
		int result[] =BetterProgrammerTask2.removeDuplicates(input1);
		Assert.assertArrayEquals(new int[]{2,1,3}, result);
	}
	
	public void testremoveDuplicates2() {
		int result[] =BetterProgrammerTask2.removeDuplicates(input2);
		Assert.assertArrayEquals(new int[]{1,2}, result);
	}
	
	public void testremoveDuplicates3() {
		int result[] =BetterProgrammerTask2.removeDuplicates(input3);
		Assert.assertArrayEquals(input3, result);
	}
	
	public void testremoveDuplicates4() {
		int result[] =BetterProgrammerTask2.removeDuplicates(input4);
		Assert.assertArrayEquals(new int[]{1}, result);
	}
	
	
	
}
