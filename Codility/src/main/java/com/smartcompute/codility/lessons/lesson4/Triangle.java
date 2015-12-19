package com.smartcompute.codility.lessons.lesson4;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R)
 * is triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example,
 * consider array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 Triplet (0, 2, 4) is
 * triangular.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A consisting of N integers, returns 1 if
 * there exists a triangular triplet for this array and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * 
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N*log(N)); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author Masud
 *
 */
public class Triangle {
	public int solution(int[] A) {
		// write your code in Java SE 8
		if (A == null || A.length < 3) {
			return 0;
		}
		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {
			long a1 = A[i];
			long a2 = A[i+1];
			long a3 = A[i+2];
			boolean x1 = (a1 + a2) > a3 ;
			boolean x2 = (a1 + a3) > a2 ;
			boolean x3 = (a2 + a3) > a1 ;
			if (A[i] > 0 && x1 && x2 && x3 ) {
				return 1;
			}
		}
		return 0;
	}
}
