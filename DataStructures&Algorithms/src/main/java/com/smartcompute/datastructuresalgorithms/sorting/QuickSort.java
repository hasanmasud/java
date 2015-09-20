package com.smartcompute.datastructuresalgorithms.sorting;

import java.util.LinkedList;
import java.util.List;

public class QuickSort {

	public List<Integer> sort(List<Integer> list){
		
		int pivot = list.get(0);
		
		List<Integer> less = new LinkedList<Integer>();
		List<Integer> more = new LinkedList<Integer>();
		List<Integer> pivots = new LinkedList<Integer>();
		
		for(Integer x : list){
			if(pivot > x){
				less.add(x);
			}else if(pivot < x){
				more.add(x);
			}else{
				pivots.add(x);
			}
		}
		
		less = this.sort(less);
		more = this.sort(more);
		
		less.addAll(pivots);
		less.addAll(more);
		
		
		return less;
		
	}
}
