package com.smartcompute.testdome;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        if (list == null || list.length < 2) return null;
        //map values to indexes
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            int needed = sum - list[i];
            if (indexMap.get(needed) != null) {
                return new int[]{i, indexMap.get(needed)};
            }

            indexMap.put(list[i], i);
        }

        //none found
        return null;
    	
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}