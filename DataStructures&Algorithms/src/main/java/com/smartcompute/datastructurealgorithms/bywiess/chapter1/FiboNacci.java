package com.smartcompute.datastructurealgorithms.bywiess.chapter1;

public class FiboNacci {
	
	public static void main(String ...args){
		
		for(int i = 1 ; i < 6 ; i++){
			System.out.println(fibonaci(i));
		}
		
		
	}
	
	
	public static int fibonaci(int x){
		if(x == 0 || x == 1){
			return 1;
		}else{
			return fibonaci(x - 2) + fibonaci(x - 1) ;
		}
	}
	
	

}
