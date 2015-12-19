package com.smartcompute.codility.trial.algo;

public class MinAbsSliceSum {
	public static int solution(int[] A) {
		long minTillHere = A[0];
		long absMinTillHere = A[0];
		long minSoFar = A[0];
		
		for (int i = 1; i < A.length; i++) {
			absMinTillHere = Math.min( Math.abs(A[i]),Math.abs(minTillHere + A[i]) );
			minTillHere = Math.min(A[i], minTillHere + A[i]);
			minSoFar = Math.min(Math.abs(minSoFar), absMinTillHere);
		}
		
		return (int)minSoFar;
	}
	
	
	public static void main(String ...args){
		
		
		int a[] = {2,-4,6,-3,9};
		System.out.println(solution(a));
		
		
		int b[] = {-1,2,3,4,5};
		System.out.println(solution(b));
		
		int c[] = {5,5,5,5,5};
		System.out.println(solution(c));
		
		
		int d[] = {-5,-5,-5,-5,-5};
		System.out.println(solution(d));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
