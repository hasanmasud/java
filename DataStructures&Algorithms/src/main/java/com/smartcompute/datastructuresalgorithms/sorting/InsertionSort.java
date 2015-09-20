package com.smartcompute.datastructuresalgorithms.sorting;
/**
 * @author Masud 
 *  Best     	: O(n)
 *  Average  	: O(n2)
 *  Worst 		: O(n2)
 *
 *
 */
public class InsertionSort {
	
	public int[] sort(int []a){
		
		for(int i = 0 ; i< a.length ; i++){
			
			for(int j = i ; j > 0; j--){
				
				if(a [j] < a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
			
		}
		
		return a;
	}

}
