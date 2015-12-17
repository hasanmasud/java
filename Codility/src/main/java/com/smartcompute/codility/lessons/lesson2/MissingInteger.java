package com.smartcompute.codility.lessons.lesson2;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
	
	  public int solution(int[] A) {
		  int num = 1;
		  Set<Integer> hashSet = new HashSet<Integer>();
		  for(int i = 0 ; i < A.length;i++){
			  hashSet.add(A[i]);
			  while(hashSet.contains(num)){
				  num++;
			  }
		  }
		  return num;
	  }
}
