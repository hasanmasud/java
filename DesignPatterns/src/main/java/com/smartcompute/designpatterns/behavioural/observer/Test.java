package com.smartcompute.designpatterns.behavioural.observer;

import java.util.Arrays;

public class Test {
	public static void main(String... args) {
		String[] strarray = new String[100];
		System.out.println(strarray.length);
		strarray[5] = "mas";
		Arrays.asList(strarray).forEach(x -> System.out.println(x));
	}
}
