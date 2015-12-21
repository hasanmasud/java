package com.smartcompute.codinginterview.interviewset1;

/**
 * Dynamic Programming
 * Kadane's algorithm
 * 
 * Find the maximum sum of subarray of a given array.
 * 
 * Time Complexity 		: O(N)
 * Space Complexity 	: O(1)
 * 
 */
public class MaximumSubSequence {

	public static int solution(int a[]) {
		int maxSoFar = a[0];
		int maxEndingHere = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if (maxEndingHere < 0) {
				maxEndingHere = a[i];
			} else {
				maxEndingHere += a[i];
			}
			if (maxEndingHere >= maxSoFar) {
				maxSoFar = maxEndingHere;
			}
		}
		
		return maxSoFar;
	}

	public static void main(String... args) {

		int a[] = { 1, 2, 3, 4 };
		System.out.println(solution(a));

		int b[] = { -1, 2, 3, 4 };
		System.out.println(solution(b));

		int c[] = { -1, 2, -3, 4 };
		System.out.println(solution(c));

	}
}
