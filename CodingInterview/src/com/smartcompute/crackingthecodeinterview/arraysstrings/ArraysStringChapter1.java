package com.smartcompute.crackingthecodeinterview.arraysstrings;

import java.util.Arrays;

public class ArraysStringChapter1 {
	/**
	 * 1.1
	 * 
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 * 
	 * This uses additional spaces. But time complexity is less. It is O(n)
	 */
	public boolean isAllUnique(char[] str) {
		int length = str.length;
		boolean[] charset = new boolean[Character.MAX_VALUE];
		for (int i = 0; i < length; i++) {
			if (charset[str[i]]) {
				return false;
			}
			charset[str[i]] = true;
		}
		return true;
	}

	/**
	 * 
	 * another way to do it to check each character to every other character. In
	 * this case the time comlexity will be O(n^2)
	 */
	public boolean isAllUniqueChar(char[] str) {
		int length = str.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (str[i] == str[j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * Reverse of a string.
	 */
	public void reverse(char[] str) {
		int length = str.length;
		for (int i = 0; i < length / 2; i++) {
			char tmp = str[i];
			str[i] = str[length - 1 - i];
			str[length - 1 - i] = tmp;
		}
	}
	/**
	 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. 
	 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
	 * FOLLOW UP
	 * Write the test cases for this method.
	 */
	public char[] removeDuplicates(char []str){
		int length = str.length - 1;
		for(int i = 0 ; i < length ; i++){
			for(int j = i+1; j < length ; j++){
				if(str[i] == str[j]){
					str[j] = str[--length];
				}else{
					j++;
				}
			}
		}
		str = Arrays.copyOf(str,length);
		return str;
	}
	/**
	 * aanagram
	 */
	public boolean anagram(String s1 , String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		int total1 = 0;
		int total2 = 0;
		for(int i = 0 ; i < s1.length(); i++){
			total1 += s1.charAt(i);
			total2 += s2.charAt(i);
		}
		if(total1 != total2){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
