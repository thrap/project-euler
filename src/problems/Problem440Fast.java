package problems;

import utils.Euler;

public class Problem440Fast {
	public static void main(String[] args) {
		int i = 10;
		System.out.println("S("+i+") = "+S(i));
		System.out.println(count);
	}
static int count = 0;
	static long mod = 987898789;
	private static long S(int L) {
		long sum = 0;
		
		// a and b equal
		for (int ab = 1; ab <= L; ab++) {
			for (int c = 1; c <= L; c++) {
				sum+= T((long)Math.pow(c, ab));
			}
		}
		
		for (int a = 1; a <= L; a++) {
			for (int b = a+1; b <= L; b++) {
				for (int c = 1; c <= L; c++) {
					long pow1 = (long)Math.pow(c, a);
					long pow2 = (long)Math.pow(c, b);
					sum += 2*T(Euler.gcd(pow1+1, pow2+1)-1);
					if (Euler.gcd(pow1+1, pow2+1)!=1) {
						count++;
						System.out.println(c + " " +a + " " + b);
					}
					sum %= mod;
				}
			}
		}
		return sum;
	}

	
	private static long T(long n) {
		if (n == 0)
			return 1;
		return Euler.matrixPow(new long[][] {{10,1}, {1,0}},n, mod)[0][0];
	}
}
