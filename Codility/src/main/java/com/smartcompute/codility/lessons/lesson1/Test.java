package com.smartcompute.codility.lessons.lesson1;

import java.io.IOException;
import java.io.InputStream;

public class Test {
	public static void main(String... args) throws IOException {
		double x = 999999999999999d;
		System.out.println(x);
		InputStream source = Runtime.getRuntime().exec("dir").getInputStream();
		System.out.println(source.toString());
	}
}
