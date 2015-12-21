package com.smartcompute.codility.trial.algo;


// need to write it correctly

public class MinAbsSliceSum {
	public static int solution(int[] A) {
		if(A.length < 1 ){
			return 0;
		}
		if(A.length == 1){
			return Math.abs(A[0]);
		}
		long min = Long.MAX_VALUE;
		
		for(int i = 0 ; i < A.length - 1 ; i++){
			long temp = A[i];
			for(int j = i+1 ; j < A.length; j++){
				temp  += A[j];
				if(min > Math.abs(temp)){
					min = Math.abs(temp);
				}
				if(min == 0){
					return 0;
				}
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
