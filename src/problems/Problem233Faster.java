package problems;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem233Faster {
	public static void main(String[] args) {
		
		T t = new T();
		
		long[] superPrimes = getSuperPrimes();
		
		
		Set<Long> fourTwoZero = new TreeSet<Long>();
		
		BigInteger LIMIT = TEN.pow(11);
		
		BigInteger A = ONE;
		for (int i = 0; i < superPrimes.length && A.pow(6).compareTo(LIMIT) == -1; i++) {
			A = valueOf(superPrimes[i]);
			BigInteger B = ONE;
			for (int j = i+1;  j < superPrimes.length && A.pow(3).multiply(B.pow(3)).compareTo(LIMIT) == -1; j++) {
				B = valueOf(superPrimes[j]);
				BigInteger C = ONE;
				System.out.println(i + " "+ j);
				for (int k = j+1; k < superPrimes.length && A.pow(3).multiply(B.pow(2)).multiply(C).compareTo(LIMIT) == -1; k++) {
					C = valueOf(superPrimes[k]);
					BigInteger[] bigs = {
							A.pow(3).multiply(B.pow(2)).multiply(C.pow(1)),
							A.pow(3).multiply(B.pow(1)).multiply(C.pow(2)),
							A.pow(2).multiply(B.pow(1)).multiply(C.pow(3)),
							A.pow(2).multiply(B.pow(3)).multiply(C.pow(1)),
							A.pow(1).multiply(B.pow(2)).multiply(C.pow(3)),
							A.pow(1).multiply(B.pow(3)).multiply(C.pow(2))
						};
					
					for (BigInteger num : bigs) {
						if (num.compareTo(LIMIT) <= 0) {
							fourTwoZero.add(num.longValue());
						}
					}
				}
			}
		}
		System.out.println("Ferdig f¿rste");
		
		A = ONE;
		for (int i = 0; i < superPrimes.length && A.pow(10).compareTo(LIMIT) == -1; i++) {
			System.out.println(i);
			A = valueOf(superPrimes[i]);
			BigInteger B = ONE;
			for (int j = i+1;  j < superPrimes.length && A.pow(7).multiply(B.pow(3)).compareTo(LIMIT) == -1; j++) {
				B = valueOf(superPrimes[j]);
				
				BigInteger[] bigs = {
						A.pow(10).multiply(B.pow(2)),
						A.pow(2).multiply(B.pow(10)),
						A.pow(7).multiply(B.pow(3)),
						A.pow(3).multiply(B.pow(7))
					};
				
				for (BigInteger num : bigs) {
					if (num.compareTo(LIMIT) <= 0) {
						fourTwoZero.add(num.longValue());
					}
				}
			}
		}
		System.out.println("Ferdig andre");
		
		
		Set<Long> skumlinger = new HashSet<Long>();
		for (Long long1 : superPrimes) {
			skumlinger.add(long1);
		}
		
		
		long limit = LIMIT.longValue();
		long lowest = fourTwoZero.iterator().next();
		
		Set<Integer> skip = new HashSet<Integer>(); 
		ytterste:
		for (int i = 1; i*lowest <= limit; i++) {
			for (long p : Euler.primeFactorDistinctList(i)) {
				if (skumlinger.contains(p)) {
					skip.add(i);
					continue ytterste;
				}
			}
		}
		System.out.println("Ferdig skip");
		
		BigInteger sum = valueOf(0);
		for (long long1 : fourTwoZero) {
			for (int i = 1; i*long1 <= limit; i++) {
				if (skip.contains(i))
					continue;
				sum = sum.add(valueOf(i*long1));
			}
		}
		
		System.out.println(sum + " " + t);
	}



	private static long[] getSuperPrimes() {
		Set<Integer> superPrimes = new HashSet<Integer>();
		
		int PRIME_LIMIT = (int)((long)(Math.pow(10, 11))/(5*5*5*13*13));
		
		for (Integer prime : Euler.primeList(PRIME_LIMIT)) {
			if ((prime-1)%4 == 0) {
				superPrimes.add(prime);
			}
		}
		
		long[] res = new long[superPrimes.size()];
		int i = 0;
		for (int p : superPrimes) {
			res[i++] = p;
		}
		Arrays.sort(res);
		return res;
	}
}
