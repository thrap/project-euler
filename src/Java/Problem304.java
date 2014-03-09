package Java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Euler;

public class Problem304 {
	public static boolean[] primeArrayBetween(long start, long limit) {
		limit++;
//		limit-=start;
		boolean[] array = new boolean[(int)(limit-start)];
		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}
		
//		 0 = 1000
//		32 = 1032   1031/7?
//		5761457
//		5761457 (4374 ms)
		
		for (int t = 0; t < primes.size(); ++t) {
			int i = primes.get(t);
//			System.out.print(i);
			long s = (start/i);
			s*=i;
			if (s != start)
				s+=i;
//			System.out.println(", " +s);
			for (long j = s; j < limit; j += i) {
				if (j != i) {
					array[(int)(j-start)] = false;
				}
			}
		}
		return array;
	}
	static List<Integer> primes;
	public static boolean isPrime(long l) {
		int sqrt = (int)Math.sqrt(l)+1;
		for (int prime : primes) {
			if (prime>sqrt)
				return true;
			if (l%prime == 0)
				return false;
		}
		return true;
	}
	
	public static long next_prime(long n) {
		for (long i = n+2; true; i+=2) {
			if (isPrime(i))
				return i;
		}
	}
	
	public static void main(String[] args) {
		primes = Euler.primeList(34622776);
		long a, b, c;
		long mod = 1234567891011L;
		a=0;
		b=1;
		
//		long prime = next_prime(99999999999999L);
//		for (int i = 1; i <= 100000; i++) {
//			if (i%100 == 0)
//				System.out.println(prime + " " +i);
//			prime=next_prime(prime);
//		}
		
		boolean[] prime = primeArrayBetween(100000000000000L, 99999999999999L+40000000);
		Set<Long> primes = new HashSet<Long>();
		for (int i = 0; primes.size()<100000; i++) {
			if (prime[i]) {
				primes.add(((long)i+100000000000000L)%900788112L);
				if (primes.size()%100 == 0)
					System.out.println(primes.size());
			}
		}
		
		/**
		 * REPETERER SEG PAA 900788112!!!!!!!!!!!11111
		 */
		long sum = 0;
		for (int i = 2; i < 900788111+100; i++) {
			c=(a+b)%mod;
			a=b%mod;
			b=c%mod;
			if(primes.contains((long)i)) {
				sum+=c;
				sum%=1234567891011L;
			}
			if(i%1000000 == 0)
				System.out.println(i);
//			System.out.println(c);
			if (i>=900788100L)
				System.out.println(i+": "+c);
		}
		System.out.println(sum);
	}
}
