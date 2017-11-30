package com.smartcompute.testdome;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

	public static void main(String... args) {

		int array[] = new int[Character.MAX_VALUE - 8];
	}

	static int[] oddNumbers(int l, int r) {
		List<Integer> list = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				list.add(i);
			}
		}
		return list.stream().mapToInt(x -> x).toArray();
	}

}
