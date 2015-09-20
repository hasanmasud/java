package com.smartcompute.datastructuresalgorithms.sorting;

/**
 * @author Masud
 * 
 * Best     : O(n)
 * Average  : O(n2)
 * Worst 	: O(n2)
 *
 */

public class BubbleSort {
	
	public int[] sort(int a[]){
		for(int i = 0 ; i < a.length - 1 ; i++){
			
			for(int j = 0 ; j< a.length -1 - i ; j++){
				
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
		}
		return a;
	}
	
}
