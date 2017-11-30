package com.smartcompute.codinginterview.interviewset1;

import java.util.ArrayList;
import java.util.List;

public class FibbonacciNumber {

	public static int solutionRecursion(int n) {
		if (n < 2) {
			return 1;
		}
		return solutionRecursion(n - 1) + solutionRecursion(n - 2);
	}

	public static int solution(int n) {
		int sum[] = new int[n + 1];
		sum[0] = 0;
		sum[1] = 1;

		for (int i = 2; i <= n; i++) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}
		return sum[n];
	}

	public static int solution1(int n) {
		List<Integer> sum = new ArrayList<>();
		sum.add(1);
		sum.add(1);

		for (int i = 2; i <= n; i++) {
			int x = sum.get(i - 1) + sum.get(i - 2);
			sum.add(x);
		}
		return sum.get(n);
	}

	public static void main(String... args) {

		long x1 = System.nanoTime();
		System.out.print("fibo of 50 : " + solution1(12));
		long x2 = System.nanoTime();
		System.out.println("->time taken:" + ((x2 - x1) / 1000000000d) + "secs");

		x1 = System.nanoTime();
		System.out.print("fibo of 50 by recursion : " + solutionRecursion(50));
		x2 = System.nanoTime();
		System.out.println(": time taken:" + ((x2 - x1) / 1000000000d) + "secs");

	}

}
