package problems;

import java.math.BigInteger;

import utils.Euler;

public class Problem440 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("S("+i+") = "+S(i));
		}
	}

	static long mod = 987898789;
	private static BigInteger S(int L) {
		BigInteger sum = BigInteger.ZERO;
		// a and b equal
		for (int ab = 1; ab <= L; ab++) {
			for (int c = 1; c <= L; c++) {
				sum = sum.add(BigInteger.valueOf(T((long)Math.pow(c, ab), mod)));
			}
		}
		for (int a = 1; a <= L; a++) {
			for (int b = a+1; b <= L; b++) {
				for (int c = 1; c <= L; c++) {
					/**
					 * hvis en av dem er delelig pŒ 2: gcd = 1
					 */
					long pow1 = (long)Math.pow(c, a);
					BigInteger t1 = Tb(pow1);
					long pow2 = (long)Math.pow(c, b);
					BigInteger t2 = Tb(pow2);
					
					sum = sum.add(BigInteger.valueOf(2).multiply(Euler.gcd(t1, t2)));
				}
			}
		}
		return sum.mod(BigInteger.valueOf(mod));
	}

	private static long T(long n) {
		return Euler.matrixPow(new long[][] {{10,1}, {1,0}},n)[1][0];
	}
	
	private static long T(long n, long mod) {
		return Euler.matrixPow(new long[][] {{10,1}, {1,0}},n, mod)[0][0];
	}
	
	static BigInteger[][] base = 
		{{BigInteger.TEN, BigInteger.ONE},
		{BigInteger.ONE, BigInteger.ZERO}};
	
	private static BigInteger Tb(long n) {
		return Euler.matrixPow(base,n)[0][0];
	}
}
