package problems;

import utils.Euler;

public class Problem443BaseCase {
	public static void main(String[] args) {
		System.out.println(g(1000));
		System.out.println(g(1000000));
	}

	private static long g(long n) {
		long g = 13;
		for (int i = 5; i <= n; i++) {
			g = g+Euler.gcd(i, g);
		}
		return g;
	}
}
