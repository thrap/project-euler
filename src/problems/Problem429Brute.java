package problems;

import utils.Euler;

public class Problem429Brute {
	public static void main(String[] args) {
		long n = Euler.factorial(7).longValue();
		/**
		 * må ta alle permutasjoner av prime^pow
		 */
		long sum = 0;
		for (int d = 1; d <= n; d++) {
			if (n%d == 0 && Euler.gcd(d, n/d) == 1) {
				sum += d*d;
				System.out.println(Euler.primeFactorMap(d));
			}
		}
		System.out.println(sum);
	}
}
