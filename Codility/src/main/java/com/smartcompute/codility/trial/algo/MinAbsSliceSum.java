package com.smartcompute.codility.trial.algo;

import java.util.Arrays;

// need to write it correctly

public class MinAbsSliceSum {

	public int solution(int[] A) {

		if (A.length == 1) {
			return Math.abs(A[0]);
		}
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < A.length -1 ; i++){
			int temp = A[i];
			
			for(int j = i+1 ; j < A.length ; j++){
				temp  += A[j];
				min = Math.min(min, Math.abs(temp));
				if(min == 0){
					return 0;
				}
			}
			
			
		}
		return min;

	}

	public static void main(String... args) {

		MinAbsSliceSum obj = new MinAbsSliceSum();

		int a[] = { 2, -4, 6, -3, 9 };
		System.out.println(obj.solution(a));

		int b[] = { -1, 1, 3, 4, 5 };
		System.out.println(obj.solution(b));

		int c[] = { 5, 5, 5, 5, 5 };
		System.out.println(obj.solution(c));

		int d[] = { -5, -5, -5, -5, -5 };
		System.out.println(obj.solution(d));

	}
}
