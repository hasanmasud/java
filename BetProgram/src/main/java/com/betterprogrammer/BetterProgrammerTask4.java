package com.betterprogrammer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BetterProgrammerTask4 {

    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */
    	int ways = count(cents, new ArrayList<Integer>(), 0);
    	return ways;
    }
    
	private static int count(int cents, List<Integer> combination, int lastSearch){
        int[] options = {1, 5, 10, 25, 50};
        int count = 0;
        List<Integer> newCombination;
        for (;lastSearch < options.length; lastSearch++){
                if (currentSum(combination) + options[lastSearch] == cents){
                        return count + 1;
                }
                if (currentSum(combination) + options[lastSearch] > cents){
                        return count;
                }
                
                newCombination = new LinkedList<Integer>(combination);
                newCombination.add(options[lastSearch]);
                
                count += count(cents, newCombination, lastSearch);
        }
        return count;
    }
    
	private  static int currentSum(List<Integer> combination){
        int ammount = 0;
        for (int current : combination){
        	ammount += current;
         }
        return ammount;
    }
}
