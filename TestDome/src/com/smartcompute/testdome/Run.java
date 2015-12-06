package com.testdome.exam;
public class Run {
    public static int indexOfLongestRun(String str) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	char prev = ' ';
    	int size = 0;
    	int  max_size = 0;
    	int  curr_pos = 0;
    	int  max_pos = 0;
    	char charArray[] = str.toCharArray();
    	for(int i = 0 ; i < charArray.length ; i++){
    		if(charArray[i] == prev){
    			size += 1;
    			if( size > max_size ){
    				max_size = size;
    				max_pos = curr_pos;
    			}
    		}else{
    			 size = 0;
    			 curr_pos = i;
    		}
    		prev = charArray[i];
    	}
    	return max_pos;
    }

    public static void main(String[] args) {
        System.out.println(indexOfLongestRun("abbcccddddcccbba"));
    }
}
