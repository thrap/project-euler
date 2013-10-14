package problems;

import utils.Euler;

public class Problem440Fast {
	public static void main(String[] args) {
		int i = 10;
		System.out.println("S("+i+") = "+S(i));
		System.out.println("S(10) = 247399089");
		i = 4;
		System.out.println("S("+i+") = "+S(i));
		System.out.println("S(4) = 670616280");
	}

	static long mod = 987898789;
	private static long S(int L) {
		long sum = 0;
		
		// a and b equal
		for (int ab = 1; ab <= L; ab++) {
			for (int c = 2; c <= L; c++) {
				sum+= T((long)Math.pow(c, ab));
			}
		}
		
		// c == 1
		sum += 10*L*L;
		
		for (int c = 2; c <= L; c++) {
			for (int a = 1; a <= L; a++) {
				for (int b = a+1; b <= L; b++) {
					long pow1 = (long)Math.pow(c, a);
					long pow2 = (long)Math.pow(c, b);
					sum += 2*T(Euler.gcd(pow1+1, pow2+1)-1);
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
