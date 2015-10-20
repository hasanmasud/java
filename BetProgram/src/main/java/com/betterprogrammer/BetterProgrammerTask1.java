package com.betterprogrammer;

public class BetterProgrammerTask1 {

	public static int countWords(String s) {
		/*
		 * Please implement this method to return the word count in a given
		 * String. Assume that the parameter String can only contain spaces and
		 * alphanumeric characters.
		 */
		int suma = 0;
		if (s != null){
			String[] splitArray = s.split("\\s+");
			for (String str : splitArray) {
				if ("".equals(str)) {
					continue;
				}
				suma++;
			}
		}
		return suma;
	}
}
