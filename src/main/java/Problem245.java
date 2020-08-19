import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import utils.Euler;

public class Problem245 {
	private static final long limit = 2*(long)Math.pow(10, 11);
	public static void main(String[] args) {
		/**
		 * alle faktorer er i foerste
		 * 
		 * n = p1*p2*..*pk
		 * phi(n) = phi(p1)*phi(p2)..*phi(pk)
		 *        = (p1-1)*(p2-1)*...*(pk-1)
		 *
		 * n-1 == 0 mod (n-(p1-1)*(p2-1)*...*(pk-1))
		 */
		
		long[] primes = getPrimes();
		
		List<Long> set = new ArrayList<Long>();

		addTwoFactors(primes, set);
		addThreeFactors(primes, set);
		addFourFactors(primes, set);
		addFiveFactors(primes, set);
		
		Collections.sort(set);
		
		long sum = 0;
		long count = 0;
		for (Long long1 : new TreeSet<Long>(set)) {
			if (long1 > limit || Euler.isPrime(long1))
				continue;
			System.out.println(++count + ": " + long1);
			sum+=long1;
		}
		System.out.println("Antall: " + set.size());
		System.out.println("Sum: " +sum);
	}

	private static void addFiveFactors(long[] primes, List<Long> set) {
		for (int i = 1; i < primes.length && primes[i]*primes[i+1]*primes[i+2]*primes[i+3]*primes[i+4] <= limit; i++) {
			System.out.println(i + " five");
			long p1 = primes[i];
			for (int j = i+1; j < primes.length && primes[i]*primes[j]*primes[j+1]*primes[j+2]*primes[j+3] <= limit; j++) {
				System.out.println(i + " " + j + " five");
				long p2 = primes[j];
				for (int k = j+1; k < primes.length && p1*p2*primes[k]*primes[k+1]*primes[k+2] <= limit; k++) {
					long p3 = primes[k];
					for (int k2 = k+1; k2 < primes.length && p1*p2*p3*primes[k2]*primes[k2+1] <= limit; k2++) {
						long p4 = primes[k2];
						for (int l = k2+1; l < primes.length && p1*p2*p3*p4*primes[l] <= limit; l++) {
							long p5 = primes[l];
							long n = p1*p2*p3*p4*p5;
							
							if ((n-1) % (n-(p1-1)*(p2-1)*(p3-1)*(p4-1)*(p5-1)) == 0) {
								set.add(n);
							}					
						}
						
					}
				}
			}
		}
	}

	private static void addFourFactors(long[] primes, List<Long> set) {
		for (int i = 1; i < primes.length && primes[i]*primes[i+1]*primes[i+2]*primes[i+3] <= limit; i++) {
			System.out.println(i + "four");
			long p1 = primes[i];
			for (int j = i+1; j < primes.length && primes[i]*primes[j]*primes[j+1]*primes[j+2] <= limit; j++) {
				System.out.println(i + " " + j + " four");
				long p2 = primes[j];
				for (int k = j+1; k < primes.length && p1*p2*primes[k]*primes[k+1] <= limit; k++) {
					long p3 = primes[k];
					for (int k2 = k+1; k2 < primes.length && p1*p2*p3*primes[k2] <= limit; k2++) {
						long p4 = primes[k2];
						long n = p1*p2*p3*p4;
						
						if ((n-1) % (n-(p1-1)*(p2-1)*(p3-1)*(p4-1)) == 0) {
							set.add(n);
						}					
					}
				}
			}
		}
	}

	private static void addThreeFactors(long[] primes, List<Long> set) {
		for (int i = 1; i < primes.length && primes[i]*primes[i+1]*primes[i+2] <= limit; i++) {
			System.out.println(i + " three");
			long p1 = primes[i];
			for (int j = i+1; j < primes.length && primes[i]*primes[j]*primes[j+1] <= limit; j++) {
				if (j%1000==0)
					System.out.println(i + " " + j);
				long p2 = primes[j];
				for (int k = j+1; k < primes.length && p1*p2*primes[k] <= limit; k++) {
					long p3 = primes[k];
					long n = p1*p2*p3;
					
					if ((n-1) % (n-(p1-1)*(p2-1)*(p3-1)) == 0) {
						set.add(n);
					}					
				}
			}
		}
	}

	private static void addTwoFactors(long[] primes, List<Long> set) {
		for (int i = 0; i < primes.length; i++) {
			if (i%100 == 0)
				System.out.println(i + " two");
			long p1 = primes[i];
			if (p1 > 5 && !(p1 % 6 == 1 || p1 % 6 == 5))
				continue;
			for (int j = i+1; j < primes.length && primes[i]*primes[j] <= limit; j++) {
				long p2 = primes[j];
				long n = p1*p2;
				
				if ((n-1) % (n-(p1-1)*(p2-1)) == 0) {
					set.add(n);
				}
			}
		}
	}

	private static long[] getPrimes() {
		List<Integer> primes = Euler.primeList((int)(limit/2000));
		long[] p = new long[primes.size()];
		int i = 0;
		for (long prime : primes) {
			p[i++] = prime;
		}
		return p;
	}
}
