package com.betterprogrammer.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.betterprogrammer.BetterProgrammerTask3;
import com.betterprogrammer.BetterProgrammerTask3.Node;

public class BetterProgrammerTask3Test extends TestCase {
	
	private Node inputNode1 = null; 
	
	private Node inputNode2 = null;
	
	private Node inputNode3 = null;
	
	private Node inputNode4 = null;
	
	// assigning the values
	protected void setUp() {
		inputNode1 = new Node(){
			public List<Node> getChildren() {
				return null;
			}
			public int getValue() {
				return 10;
			}
		};
		
		
		inputNode2 = new Node(){
			public List<Node> getChildren() {
				List<Node> listNode =  new ArrayList<Node>();
				listNode.add(inputNode1);
				return listNode;
			}
			public int getValue() {
				return 5;
			}
		};
		
		
		inputNode3 = new Node(){
			public List<Node> getChildren() {
				List<Node> listNode =  new ArrayList<Node>();
				listNode.add(inputNode1);
				listNode.add(inputNode1);
				return listNode;
			}
			public int getValue() {
				return 5;
			}
		};
		
		inputNode4 = new Node(){
			public List<Node> getChildren() {
				List<Node> listNode =  new ArrayList<Node>();
				listNode.add(inputNode2);
				return listNode;
			}
			public int getValue() {
				return 10;
			}
		};	
	}
	
	// test method to add two values
	public void testGetAverage1() {
		double avg = BetterProgrammerTask3.getAverage(inputNode1);
		assertEquals(10d, avg);
	}
	
	// test method to add two values
	public void testGetAverage2() {
		double avg = BetterProgrammerTask3.getAverage(inputNode2);
		assertEquals((10d+5d)/2, avg);
	}
	
	// test method to add two values
	public void testGetAverage3() {
		double avg = BetterProgrammerTask3.getAverage(inputNode3);
		assertEquals(( (double)(10+10+5)/3), avg);
	}
	
	// test method to add two values
	public void testGetAverage4() {
		double avg = BetterProgrammerTask3.getAverage(inputNode4);
		assertEquals((double)(10+5+10)/3, avg);
	}
}
