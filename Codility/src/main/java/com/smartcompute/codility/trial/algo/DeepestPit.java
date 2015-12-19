package com.smartcompute.codility.trial.algo;

public class DeepestPit {

	/**
	 * it gives 100%
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		
		int P = -1, R = -1, Q = -1, depth = -1;

		for (int i = 0; i < A.length - 1; i++) {
			if (Q < 0) {
				if (A[i] > A[i + 1]) {
					Q = i + 1;
					P = i;
				}
			} else {
				if (R < 0) {
					if (A[i] > A[i + 1]){
						Q++;
					}
					if (A[i] < A[i + 1]){
						R = i + 1;
					}
					if (A[i] == A[i + 1]) {
						P = Q = R = -1;
					}
				} else {
					if (A[i] < A[i + 1]){
						R++;
					}else {
						depth = Math.max(depth,
								Math.min(A[P] - A[Q], A[R] - A[Q]));
						if (A[i] > A[i + 1]) {
							P = i;
							Q = i + 1;
							R = -1;
						} else {
							P = Q = R = -1;
						}
					}
				}
			}
		}

		if (R > 0) {
			depth = Math.max(depth, Math.min(A[P] - A[Q], A[R] - A[Q]));
		}

		return depth;
	}
	
	
	public static void main(String ...args){
		
		DeepestPit obj = new DeepestPit();
		
		int a[] = {0,1,3,-2,0,1,0,-3,2,3};
		System.out.println(obj.solution(a));
		
		
	}

}
