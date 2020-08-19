import java.math.BigInteger;

import utils.Euler;

public class Problem440BaseCase {
	public static void main(String[] args) {
		System.out.println("T(1) = "+T(1));
		System.out.println("T(2) = "+T(2));
		System.out.println();
		System.out.println("S(2) = "+S(2));
		System.out.println("S(3) = "+S(3));
	}

	private static BigInteger S(int L) {
		BigInteger sum = BigInteger.ZERO;
		for (int a = 1; a <=L; a++) {
			for (int b = 1; b <=L; b++) {
				for (int c = 1; c <=L; c++) {
					long pow1 = (long)Math.pow(c, a);
					long pow2 = (long)Math.pow(c, b);
					sum = sum.add(Euler.gcd(Tb(pow1), Tb(pow2)));
				}
			}
		}
		return sum;
	}

	private static long T(long n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;
		return 10*T(n-1)+T(n-2);
	}
	
	private static BigInteger Tb(long n) {
		if (n == 0)
			return BigInteger.ONE;
		if (n == 1)
			return BigInteger.TEN;
		return BigInteger.TEN.multiply(Tb(n-1)).add(Tb(n-2));
	}
}
