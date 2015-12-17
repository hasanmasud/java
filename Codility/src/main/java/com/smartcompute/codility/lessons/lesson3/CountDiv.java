package com.smartcompute.codility.lessons.lesson3;

public class CountDiv {

	public int solution(int A, int B, int K) {
		int offsetForLeftRange = 0;
		if (A % K == 0) {
			++offsetForLeftRange;
		}
		return (B / K) - (A / K) + offsetForLeftRange;
	}

}
