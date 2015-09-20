package com.smartcompute.datastructuresalgorithms.sorting;

public class SelectionSort {

	public int[] sort(int a[]){
		
		for(int i = 0; i< a.length -1 ; i++){
			int min = i;
			for(int j = i+1; j<a.length -1;j++){
				if(a[j] < a[i]){
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			
		}
		
		return a;
	}
	
}
