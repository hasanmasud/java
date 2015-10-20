package com.betterprogrammer.test;

import junit.framework.TestCase;

import com.betterprogrammer.BetterProgrammerTask4;

public class BetterProgrammerTask4Test extends TestCase{
	
	// assigning the values
	protected void setUp() {
	}
	
	public void testWays1() {
		int ways = BetterProgrammerTask4.countWaysToProduceGivenAmountOfMoney(11);
		assertEquals(4, ways);
	}
	
	public void testWays2() {
		int ways = BetterProgrammerTask4.countWaysToProduceGivenAmountOfMoney(1);
		assertEquals(1, ways);
	}
	
	public void testWays3() {
		int ways = BetterProgrammerTask4.countWaysToProduceGivenAmountOfMoney(2);
		assertEquals(1, ways);
	}
	
	public void testWays4() {
		int ways = BetterProgrammerTask4.countWaysToProduceGivenAmountOfMoney(10);
		assertEquals(4, ways);
	}
	
	
	
	
}
