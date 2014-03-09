package Java;

import java.math.BigInteger;

public class Problem160NaaSnakkerVi {
	public static void main(String[] args) {
		long limit = 1000000000000L;
		long mod = 1000000L;
		long toere = pows(limit,2) - pows(limit,5);
		System.out.println(toere);
		
		long fact = BigInteger.valueOf(2).modPow(BigInteger.valueOf(toere), BigInteger.valueOf(mod)).longValue();
		System.out.println(fact);
//		for (int i = 2; i <= limit; i++) {
//			if (i % 2 == 0 || i % 5 == 0)
//				continue;
//			fact*=i;
//			System.out.println(fact);
//		}
//		for (int prime : Euler.primeList((int)mod)) {
//			if (prime == 2 || prime == 5)
//				continue;
//			fact *= BigInteger.valueOf(prime).modPow(BigInteger.valueOf(pows(limit, prime)), BigInteger.valueOf(mod)).longValue();
//			fact %= mod;
//		}
		long temp = 1;
		for (long i = 2; i <= limit; i++) {
			if (i%100000000 == 0)
				System.out.println(i + " " + (double)i/(double)limit);
			long tallet = i;
			while (tallet % 5 == 0)
				tallet /= 5;
			while (tallet % 2 == 0)
				tallet /= 2;
			temp*=tallet;
			temp%=mod;
		}
//		System.out.println(temp);
//		System.out.println(fact);
		System.out.println((temp*fact)%mod);
	}
	
	private static long pows(long n, int p) {
		long amount = 0;
		/**
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 * flaskehals
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		long pow = p;
		while (pow <= n) {
			amount+=n/pow;
			pow*=p;
		}
		return amount;
	}
}
