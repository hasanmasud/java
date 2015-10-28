package com.smartcompute.datastructurealrithms.strings;

public class CheckAnagram {

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

