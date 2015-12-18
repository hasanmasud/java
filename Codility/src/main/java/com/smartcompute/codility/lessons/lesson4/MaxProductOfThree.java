package com.smartcompute.codility.lessons.lesson4;

import java.util.Arrays;

public class MaxProductOfThree {

	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int len = A.length;
		int maxRight =  A[len -1] * A[len - 2] * A[len - 3];
		int maxLeft = A[0] * A[1] * A[len -1];
		return Math.max(maxRight, maxLeft);
	}

}
