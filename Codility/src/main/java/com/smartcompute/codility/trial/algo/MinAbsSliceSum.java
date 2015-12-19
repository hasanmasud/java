package com.smartcompute.codility.trial.algo;


public class MinAbsSliceSum {
	public static int solution(int[] A) {
		
        long minSum = Long.MAX_VALUE;
        int cumulativeSum= 0;	
        for (int currentIndex = 0; currentIndex < A.length; currentIndex++) {
            int eachArrayItem = A[currentIndex];
            cumulativeSum += eachArrayItem;
            if( Math.abs(cumulativeSum)  < minSum){
            	minSum = Math.abs(cumulativeSum);
            }else if( Math.abs(cumulativeSum) == 0 ){
            	return 0;
            }
        }
		return (int)minSum;
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
