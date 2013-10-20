package problems;

import utils.Euler;
import utils.Rational;

public class Problem441Naive {
	public static void main(String[] args) {
		System.out.println(R(2));
		System.out.println(S(2));
		System.out.println(S(10));
		System.out.println(S(15));
		System.out.println(S(26));
	}

	private static Rational S(int N) {
		Rational sum = new Rational(0,1);
		for (int i = 2; i <= N; i++) {
			sum = sum.add(R(i));
		}
		return sum;
	}

	private static Rational R(int M) {
		Rational sum = new Rational(0,1);
		for (int p = 0; p <= M; p++) {
			for (int q = p+1; q <= M; q++) {
				if (Euler.gcd(p, q) != 1 || p+q < M)
					continue;
				sum = sum.add(new Rational(1, p*q));
			}
		}
		return sum;
	}
}
