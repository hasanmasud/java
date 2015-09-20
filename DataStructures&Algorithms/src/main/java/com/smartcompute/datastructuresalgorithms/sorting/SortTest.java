package com.smartcompute.datastructuresalgorithms.sorting;

import java.util.LinkedList;
import java.util.List;

public class SortTest {

	public static void main(String ...args){
		
		int a[] = {5,8,6,3,4,1,2};
		List<Integer> x = new LinkedList<Integer>();
		x.add(32);
		x.add(45);
		x.add(1);
		
		print(new BubbleSort().sort(a));
		print(new InsertionSort().sort(a));
		print(new SelectionSort().sort(a));
		print(new QuickSort().sort(x).toArray());
		
		
		
	}
	
	public static void print(int []a){
		System.out.print("\n");
		for(int x : a){
			System.out.print(x+" ");
		}
	}
	
	public static void print(Object []a){
		System.out.print("\n");
		for(Object x : a){
			System.out.print(x+" ");
		}
	}
	
	
}
