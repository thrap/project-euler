package Java;

import java.math.BigInteger;

import utils.Euler;

public class Problem218 {
	public static void main(String[] args) {
		System.out.println(getPerfectTriples());
	}

	private static int getPerfectTriples() {
		int perfect = 0;
		int superPerfect = 0;
		for (long k = 0; k < 100000; k++) {
			if (k%1000 == 0)
				System.out.println(k + " " + perfect);
			for (long j = 1; j < k; j++) {
				long m = k*k-j*j;
				long n = 2*k*j;
				long d = k*k+j*j;
				
				if (d > Math.pow(10, 8)) 
					break;
				
				long a = Math.abs(m*m-n*n);
				long b = 2*m*n;
				long c = d*d;
				if (isPrimitive(a,b,c)) {
					perfect++;
					
					if (isSuperPerfect(a,b)) {
						superPerfect++;
					}
				}
			}
		}
		System.out.println(perfect);
		System.out.println(superPerfect);
		return perfect-superPerfect;
	}
	
	private static boolean isSuperPerfect(long a, long b) {
		BigInteger area = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(2));
		return area.mod(BigInteger.valueOf(28)).equals(BigInteger.ZERO) && area.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO);
	}

	private static boolean isPrimitive(long a, long b, long c) {
		return Euler.gcd(a, b) == 1 && Euler.gcd(b, c) == 1;
	}
}
