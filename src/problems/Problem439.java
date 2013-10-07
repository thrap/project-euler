package problems;

import utils.Euler;

public class Problem439 {
	public static void main(String[] args) {
		System.out.println(S(1000));
	}

	private static long S(int N) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int div : Euler.divisorList(i*j)) {
					sum += div;
				}
			}
		}
		return sum;
	}
}
