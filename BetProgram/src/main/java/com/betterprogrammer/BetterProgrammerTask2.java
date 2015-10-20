package com.betterprogrammer;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BetterProgrammerTask2 {

    public static int[] removeDuplicates(int[] a) {
        /*
          Please implement this method to
          remove all duplicates from the original array. Retain the order of the elements and
          always retain the first occurrence of the duplicate elements.
          For example, parameter: {2,1,2,3}, result: {2,1,3}
         */
    	Map<Integer, Integer> mapa = new LinkedHashMap<Integer, Integer>();
		int[] ret = new int[a.length];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (mapa.get(a[i]) == null) {
				mapa.put(a[i], 1);
				ret[index++] = a[i];
			}
		}
		return Arrays.copyOfRange(ret, 0, index);
    }
}
