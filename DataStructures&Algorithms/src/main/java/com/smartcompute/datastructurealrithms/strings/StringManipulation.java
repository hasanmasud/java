package com.smartcompute.datastructurealrithms.strings;

import java.util.HashMap;
import java.util.Map;

public class StringManipulation {
	
	
	/**
	 * To start with, we have a simple String related coding question frequently asked in programming interviews. 
	 * You need to write a program in C, C++, Java or Python to print duplicate characters from a given String, 
	 * for example if String is "Java" then program should print "a". 
	 * Bonus points if your program is robust and handle different kinds of input e.g. String without duplicate, 
	 * null or empty String etc. Bonus points if you also write unit tests for normal and edge cases.
	 */
	public static void printDuplicateChars(String word){
		
		char[] ch = word.toCharArray();
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(Character c : ch){
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		
		for(Character c : map.keySet()){
			if(map.get(c) > 1){
				System.out.println(c);
			}
		}
	}
	
	
	
	public static boolean checkAnagram(String first,String second){
		
		if(first.length() != second.length()){
			return false;
		}
		char ch[] = first.toCharArray();
		StringBuilder strBuilder = new StringBuilder(second);
		for(char c : ch){
			int index = strBuilder.indexOf(""+c);
			if(index == -1){
				return false;
			}else{
				strBuilder.deleteCharAt(index);
			}
		}
		return (strBuilder.length() == 0) ? true : false;
	}
	
	
	
	

}