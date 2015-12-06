package com.smartcompute.testdome;
public class Palindrome {
    public static boolean isPalindrome(String str) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	StringBuilder strBuilder = new StringBuilder();
    	for(int i = 0; i < str.length() ; i++){
    		char b = Character.toUpperCase(str.charAt(i));
    		if( b >= 65 && b<= 90 ){
    			strBuilder.append(b);
    		}
    	}
    	if(strBuilder.toString().equals(strBuilder.reverse().toString())){
    		return true;
    	}
    	//System.out.println(strBuilder.toString());
    	return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leon."));
    }
}