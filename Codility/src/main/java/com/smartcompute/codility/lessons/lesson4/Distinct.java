package com.smartcompute.codility.lessons.lesson4;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A consisting of N integers, returns the
 * number of distinct values in array A.
 * 
 * @author Masud
 *
 */
public class Distinct {

	public int solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : A) {
			map.put(i, 0);
		}
		return map.keySet().size();
	}

}
