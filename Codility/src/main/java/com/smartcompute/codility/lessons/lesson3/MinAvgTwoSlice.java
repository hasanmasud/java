package com.smartcompute.codility.lessons.lesson3;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		// write your code in Java SE 8
		double minAvg = Double.MAX_VALUE;
		int index = 0;
		if(A.length <= 2){
			return 0;
		}
		
		for(int i =0 ; i < A.length -2 ; i++){
			
			double x1 = (A[i] + A[i+1])/2.0d;
			double x2 = (A[i] + A[i+1] + A[i+2]) / 3.0d;
			
			if(minAvg > x1){
				minAvg = x1;
				index = i;
			}
			
			if(minAvg > x2){
				minAvg = x2;
				index = i;
			}
		}
		
		int amax = A.length -2;
		double x3 = (A[amax] + A[amax+1])/2.0d;
		if(minAvg > x3){
			minAvg = x3;
			index = amax;
		}
		
		return index;
	}
}
