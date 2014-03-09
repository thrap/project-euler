package Java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

import utils.Euler;

public class Problem407 {
	static int limit = (int)(Math.pow(10, 7));
	static boolean[] prime = Euler.primeArray(limit);
	
	public static void main(String[] args) {
		for (int n = 1; n < 1000; n++) {
			System.out.print(n+" "+Euler.primeFactorList(n)+": ");
			for (int a = 2; a < n; a++) {
				/**
				 * n m dele a*(a-1) og (n-a+1)*(n-a)
				 * a*(a-1) = 0 mod n
				 * (n-a+1)*(n-a) = 0 mod n
				 */
				if ((a*a)%n == a) {
					if (((a-1)*a) % n != 0 || ((n-a+1)*(n-a)) % n != 0) {
						System.out.println("todo");
						System.exit(0);
					}
					System.out.print(a+" " + Euler.primeFactorList(a) + " ");
					//dette er ikke tilfeldig vett hh
					System.out.print(n-a+1 + " ");
//					System.out.println(n%a == 0);
					
				}
			}
			System.out.println();
		}
		
		Map<Integer, Integer> forrige = Euler.primeFactorMap(limit);
		for (int a = limit; a >= 1; a--) {
			//m sjekke alle divisorer til a*(a-1)
			Map<Integer, Integer> denne = Euler.primeFactorMap(a-1);
//			System.out.println(forrige + " " + denne);
			for (Map.Entry<Integer,Integer> factor : denne.entrySet()) {
				if (forrige.containsKey(factor.getKey())) {
					forrige.put(factor.getKey(), factor.getValue()+forrige.get(factor));
				} else {
					forrige.put(factor.getKey(), factor.getValue());
				}
			}
			
			int[] primeDivisors = new int[forrige.size()];
			int[] multiplicity = new int[primeDivisors.length];
			int i = 0;
			for (Map.Entry<Integer,Integer> factor : forrige.entrySet()) {
				primeDivisors[i] = factor.getKey();
				multiplicity[i] = factor.getValue();
				++i;
			}
			/**
			 * a*(a-1)
			 */
//			System.out.print(a + " " + forrige + ": ");
			findFactors(primeDivisors, multiplicity, 0, 1, a);
//			System.out.println();
//			System.out.println(forrige);
			
			if (a%10000 == 0)
				System.out.println(a);
			
			forrige = denne;
		}
		BigInteger res = BigInteger.ZERO;
		for (int i = 2; i < max.length; i++) {
			res = res.add(BigInteger.valueOf(max[i]));
		}
		System.out.println(res);
//		long res2 = 0;
//		for (int n = limit; n >= 1; n--) {
//			for (long a = n-1; a>=1; a--) {
//				if ((a*a)%n == a) {
//					System.out.println(n + ": "+ a + " " + max[n]);
//					if (a != max[n]) {
//						System.out.println("todo");
//						System.exit(0);
//					}
//					break;
//				}
//			}
//		}
	}
	
	static int[] max = new int[limit+1];
	
	static {
		Arrays.fill(max, 1);
	}
	
	static void findFactors(int[] primeDivisors, int[] multiplicity, int currentDivisor, long currentResult, int a) {
	    if (currentDivisor == primeDivisors.length) {
	        // no more balls
	    	if (currentResult <= limit) {
	    		int n = (int)currentResult;
	    		if (prime[n])
	    			return;
//	    		max[n] = Math.max(n-a+1, max[n]); TODO
	    		if (a < n) {
	    			max[n] = Math.max(a, max[n]);
	    			
	    		}
	    	}
//	    	System.out.print(currentResult + " ");
	        return;
	    }
	    // how many times will we take current divisor?
	    // we have to try all options
	    for (int i = 0; i <= multiplicity[currentDivisor]; ++i) {
	        findFactors(primeDivisors, multiplicity, currentDivisor + 1, currentResult, a);
	        currentResult *= primeDivisors[currentDivisor];
	    }
	}
}
