package problems;

import utils.T;

public class Problem375BaseCase {
	static long[] S; 
	public static void main(String[] args) {
		T t = new T();
		int N = 10000;
		S = new long[N+1];
		S[0] = 290797;
		for (int i = 1; i < S.length; i++) {
			S[i] = (S[i-1]*S[i-1]) % 50515093;
		}
		
		System.out.println(M(N) + " " + t);
	}

	private static long M(int N) {
		long sum = 0;
		for (int j = 1; j <= N; j++) {
			if (j % 100 == 0)
				System.out.println(j + " / " + N);
			for (int i = 1; i <= j; i++) {
				sum+=A(i, j);
			}
		}
		return sum;
	}

	private static long A(int i, int j) {
		long min = Long.MAX_VALUE;
		for (; i <= j; i++) {
			min = Math.min(min, S[i]);
		}
		return min;
	}
}
