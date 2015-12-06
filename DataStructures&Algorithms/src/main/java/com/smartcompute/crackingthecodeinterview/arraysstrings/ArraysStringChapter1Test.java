package com.smartcompute.crackingthecodeinterview.arraysstrings;

import junit.framework.TestCase;

public class ArraysStringChapter1Test extends TestCase {
	ArraysStringChapter1 arraysStringChapter1 = null;
	protected void setUp() {
		arraysStringChapter1 = new ArraysStringChapter1();
	}
	
	public void testIsAllUnique() {
		char x1[] = {'a','b','c'};
		char x2[] = {'a','b','a'};
		assertEquals(arraysStringChapter1.isAllUnique(x1),true);
		assertEquals(arraysStringChapter1.isAllUnique(x2),false);
		assertEquals(arraysStringChapter1.isAllUniqueChar(x1),true);
		assertEquals(arraysStringChapter1.isAllUniqueChar(x2),false);
	}
	
	
	public void testReverse(){
		char x1[] = {'a','b','c','d'};
		char x2[] = {'a','b','c'};
		arraysStringChapter1.reverse(x1);
		arraysStringChapter1.reverse(x2);
		System.out.println(x1);
		System.out.println(x2);
		assertEquals(new String(x1),"dcba");
		assertEquals(new String(x2),"cba");
	}
	
	public void testRemoveDuplicates(){
		char x1[] = {'a','b','a','d'};
		char x2[] = {'a','b','c'};
		x1 = arraysStringChapter1.removeDuplicates(x1);
		System.out.println(x1);
		//assertEquals(new String(x1),"abc");
	}
	
	
	public void testAnagram(){
		assertEquals(arraysStringChapter1.anagram("masud", "samud"), true);
	}

}
