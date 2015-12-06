package com.smartcompute.testdome;
public class AreAnagrams {
    public static boolean areAnagrams(String a, String b) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	
    	long totala = 0l;
    	long totalb = 0l;
    	
    	for(char c : a.toCharArray()){
    		totala += c;
    	}
    	for(char c : b.toCharArray()){
    		totalb += c;
    	}
    	if(totala != totalb){
    		return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
    }
}