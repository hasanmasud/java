package com.smartcompute.testdome;


/**
 * A frog only moves forward, but it can move in steps 1 inch long or in jumps 2
 * inches long. A frog can cover the same distance using different combinations
 * of steps and jumps.
 * 
 * Write a function that calculates the number of different combinations a frog
 * can use to cover a given distance.
 * 
 * For example, a distance of 3 inches can be covered in three ways:
 * step-step-step, step-jump, and jump-step.
 * 
 *
 */

public class Frog {
    public static int numberOfWays(int n) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	
    	if(n <= 1){
    		return 1;
    	}else{
    		return numberOfWays(n-1) + numberOfWays(n-2);
    	}
    	
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(3));
    }
}