package com.smartcompute.datastructure.iitdelhi.courses.introduction;

import java.math.BigDecimal;

public class Introduction {
	
	public static void main(String ...args){
		
		int a[] = {3,5,1,14,10};
		insertionSort(a);
		
		for(int x : a){
			//System.out.println(x);
		}
		
		//System.out.println(2.00d - 1.10d);
		
		for(byte b= Byte.MIN_VALUE ; b < Byte.MAX_VALUE ; b++){
			//System.out.println(0x90);
			if(b == 0x90){
				//System.out.println("Hello");
			}
		}
		
		String x = "mas";
		String z= "ud";
		//String y = x+z;
		String y = "masud";
		//System.out.println("masud" == y);
		
		int s = Integer.MIN_VALUE;
		
		//System.out.println(s == -s);
		
		
		
		Integer i1 = new Integer(11);
		Integer i2 = new Integer(10);
		
		System.out.println(i1 > i2);
		
		
	
		
		
		
	}

	public static int arrayMax(int array[]) {
		int maximun = array[0];
		for (int i = 1; i < array.length; i++) {
			if (maximun < array[i]) {
				maximun = array[i];
			}
		}
		return maximun;
	}

	public static void insertionSort(int array[]) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}

	}

}
