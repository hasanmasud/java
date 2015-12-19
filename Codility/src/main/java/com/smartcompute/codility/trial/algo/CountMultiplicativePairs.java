package com.smartcompute.codility.trial.algo;

import java.util.Arrays;

public class CountMultiplicativePairs {
	/**
	 * solution 2 gives 100%
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int solution(int A[], int B[]) {

		if (A.length == 0 || B.length == 0) {
			return 0;
		}

		long C[] = new long[A.length];
		final int ONE_MILLION = 1000000;
		int left = 0;
		int right = A.length - 1;
		long c_left = 0;
		long count = 0;
		for (int i = 0; i < A.length; i++) {
			C[i] = A[i] * ONE_MILLION + B[i];
		}
		Arrays.sort(C);

		if (C[0] == 0) {
			int index = 1;
			while (index <= right && C[index] == 0) {
				count += index;
				index++;
			}
		}

		while (left < right) {
			c_left = C[left];
			if (c_left >= ONE_MILLION) {
				long val1 = c_left * C[right];
				long val2 = (c_left + C[right]) * ONE_MILLION;
				if (val1 >= val2) {
					count = count + (right - left);
					right--;
				} else {
					left++;
				}
			} else {
				left++;
			}
		}
		if (count > 1000000000) {
			return 1000000000;
		}
		return (int) count;
	}

	public static void main(String... args) {
		CountMultiplicativePairs obj = new CountMultiplicativePairs();

		int a[] = { 0, 0, 0, 0 };
		int b[] = { 0, 0, 0, 0 };
		System.out.println(obj.solution(a, b));

	}

}
