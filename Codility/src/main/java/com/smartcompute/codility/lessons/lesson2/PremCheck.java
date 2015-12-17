package com.smartcompute.codility.lessons.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;




public class PremCheck {

	public int solution(int[] A) {
		// write your code in Java SE 8
		if(A.length == 0){
			return 1;
		}
		if(A.length == 1){
			if(A[0] != 1){
				return 0;
			}else{
				return 1;
			}
		}
		
		if(A.length == 2){
			if(A[0] - A[1] == 1){
				return A[1];
			}else if(A[0] - A[1] == -1){
				return A[0];
			}else{
				return 1;
			}
		}
		
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for(int i : A){
			Integer val = map.put(i, i);
			if(val != null){
				return 0;
			}
		}
		List<Integer> setx = new ArrayList<Integer>(map.keySet());
		for(int i = 1; i< setx.size();i++){
			if( setx.get(i) - setx.get(i-1) > 1 ){
				return 0;
			}
		}
		return setx.get(0);
	}

}
