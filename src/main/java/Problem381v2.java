import java.math.BigInteger;

import utils.Euler;

public class Problem381v2 {
	public static void main(String[] args) {
		long sum = 0;
		int i = 0;
		boolean[] isPrime = Euler.primeArray((int)Math.pow(10, 8));
		for (int prime = 5; prime <= Math.pow(10, 8); prime++) {
			if (!isPrime[prime])
				continue;
			if (++i % 100000 == 0)
				System.out.println(prime);
			sum+=S(prime);
		}
		System.out.println(sum);
	}

	private static long S(long prime) {
		return ((prime-1)+mod(prime-2, prime) + mod(prime-3, prime) + mod(prime-4, prime) + mod(prime-5, prime))%prime;
	}

	private static long mod(long n, long prime) {
		BigInteger prod = BigInteger.valueOf(-1);
		for (long k = n+1; k < prime; k++) {
			prod = prod.multiply(BigInteger.valueOf(k));
		}
		return prod.modPow(BigInteger.valueOf(prime-2), BigInteger.valueOf(prime)).longValue();
	}
}
