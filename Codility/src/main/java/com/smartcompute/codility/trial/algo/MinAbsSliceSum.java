package com.smartcompute.codility.trial.algo;

import java.util.Arrays;

// need to write it correctly

public class MinAbsSliceSum {
	public static int solution(int[] A) {
		if(A.length < 1 ){
			return 0;
		}
		if(A.length == 1){
			return Math.abs(A[0]);
		}
		
		int start = 0;
		int end = A.length -1;
		long min = Long.MAX_VALUE;
		Arrays.sort(A);
		while(start <= end){
			long temp = A[start] + A[end];
			min = Math.min(min , Math.abs(temp));
			if(temp <= 0){
				start++;
			}else{
				end--;
			}
		}
		return (int)min;
	}
	
	
	public static void main(String ...args){
		
		
		int a[] = {2,-4,6,-3,9};
		System.out.println(solution(a));
		
		
		int b[] = {-1,1,3,4,5};
		System.out.println(solution(b));
		
		int c[] = {5,5,5,5,5};
		System.out.println(solution(c));
		
		
		int d[] = {-5,-5,-5,-5,-5};
		System.out.println(solution(d));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
