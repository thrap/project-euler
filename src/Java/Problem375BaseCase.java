package Java;

import utils.T;

public class Problem375BaseCase {
	static long[] S; 
	public static void main(String[] args) {
		T t = new T();
		int N = 10000;
		/**
		 * Sn for n=1,2,.. er periodisk med periode 6308949
		 */
		S = new long[N+1];
		S[0] = 290797;
		for (int i = 1; i < S.length; i++) {
			S[i] = (S[i-1]*S[i-1]) % 50515093;
		}
		System.out.println("M(10) = "+M(10) + " " + t);
		System.out.println("M(100) = "+M(100) + " " + t);
		System.out.println("M(1000) = "+M(1000) + " " + t);
		System.out.println("M(10000) = "+M(10000) + " " + t);
		
		/**
			Scaler ikke som faen

			M(10) = 432256955 (1 ms)
			M(100) = 27022904418 (12 ms)
			M(1000) = 322833621931 (162 ms)
			M(10000) = 3264567774119 (153767 ms)
		 */
	}

	private static long M(int N) {
		long sum = 0;
		for (int j = 1; j <= N; j++) {
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
