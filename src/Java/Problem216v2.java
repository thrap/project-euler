package Java;

import java.math.BigInteger;
import java.util.List;

import utils.Euler;

public class Problem216v2 {
	
	static List<Integer> primes = Euler.primeList(1000);
	static int LIMIT = 50000000;
	public static void main(String[] args) {
		primes = Euler.primeList(LIMIT*2);
		
		int count = 0;
		for (long i = LIMIT; i >= 2; i--) {
			if (i%100000 == 0)
				System.out.println(i);
			long number = 2*i*i-1;
			if (probablePrime(number))
				count++;
		}
		System.out.println(count);
	}
	private static boolean probablePrime(long number) {
		return BigInteger.valueOf(number).isProbablePrime(20);
	}
	
	
}
