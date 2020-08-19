import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem342 {
	public static void main(String[] args) {
		T t = new T();
		Set<Long> set = new TreeSet<Long>();
		long limit = (long) Math.pow(10, 5);
		
		// 2, 3, 5, 7, 11, 13, 17, 19, 37
		for (int a = 0; Math.pow(2, a) <= limit; a++) {
			for (int b = 0; Math.pow(2, a)*Math.pow(3, b) <= limit; b++) {
				for (int c = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c) <= limit; c++) {
					for (int d = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d) <= limit; d++) {
						for (int e = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e) <= limit; e++) {
							for (int f = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e)*Math.pow(13, f) <= limit; f++) {
								for (int g = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e)*Math.pow(13, f)*Math.pow(17, g) <= limit; g++) {
									for (int h = 0; Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e)*Math.pow(13, f)*Math.pow(17, g)*Math.pow(19, h) <= limit; h++) {
										for (int i = 0;  Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e)*Math.pow(13, f)*Math.pow(17, g)*Math.pow(19, h)*Math.pow(37, i) <= limit; i++) {
											long p = (long)(Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c)*Math.pow(7, d)*Math.pow(11, e)*Math.pow(13, f)*Math.pow(17, g)*Math.pow(19, h)*Math.pow(37, i))+1;
											if (Euler.isPrime(p) || p == 2) {
												set.add(p);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		reccurse(new ArrayList<Long>(set), 1, 0, new ArrayList<Long>());
		System.out.println(answer + " " + t);
	}
	
	static Set<Long> candidates = new HashSet<Long>();
	
	static Set<Integer> setz = new TreeSet<Integer>();
	
	static int count = 0;
	static long answer = 0;

	static long LIMIT = (long)Math.pow(10, 10);
	private static void reccurse(List<Long> ps, long number, int index, List<Long> factors) {
		if (index == ps.size()|| number*ps.get(index) > LIMIT) {
			count++;
			if (count % 1000000 == 0) {
				
				System.out.println(count + " / "+242271315);
			}
			if (phiIsCube(number, factors) && number < LIMIT && number != 1) {
				answer += number;
			}
			return;
		}
		final long p = ps.get(index);
		for (int i = 0; number*Math.pow(p, i) <= LIMIT; i++) {
			reccurse(ps, number*(long)Math.pow(p, i), index+1, (i==0?new ArrayList<Long>(factors) : new ArrayList<Long>(factors){{add(p);}}));
		}
	}

	private static boolean phiIsCube(long n, List<Long> primeFactors) {
		/**
		 * n = p1^k1*p2^k2*...*pr^kr
		 * 
		 * phi(n^2) = n*phi(n) = n^2*(1-1/p1)(1-1/p2)...(1-1/pr)
		 * 			
		 * 			= p1^(2*k1)*p2^(2*k2)*...*pr^(2*kr)   *   ((p1-1)/p1)((p2-1)/p2)...((pr-1)/pr)
		 * 
		 * 			= p1^(2*k1-1)*p2^(2*k2-1)*...*pr^(2*kr-1)     *    (p1-1)*(p2-1)*...*(pr-1)
		 * 
		 */
		
		Map<Long, Integer> ps = new HashMap<Long, Integer>();
		
		for (long p : primeFactors) {
			int k = 1;
			long temp = n/p;
			while (temp % p == 0) {
				temp/=p;
				k++;
			}
			
			ps.put(p, 2*k-1);
		}
		
		for (long p : primeFactors) {
			for (Map.Entry<Integer, Integer> entry: primeFactorMap((int)(p-1)).entrySet()) {
				long prime = entry.getKey();
				ps.put(prime, (ps.containsKey(prime) ? ps.get(prime) : 0) + entry.getValue());
			}
		}
		
		for (Map.Entry<Long, Integer> entry : ps.entrySet()) {
			if (entry.getValue() % 3 != 0)
				return false;
		}
		
		return true;
	}

	static Map<Integer, Map<Integer, Integer>> memo = new HashMap<Integer, Map<Integer, Integer>>(); 
	private static Map<Integer, Integer> primeFactorMap(int i) {
		if (memo.containsKey(i))
			return memo.get(i);
		Map<Integer, Integer> temp = Euler.primeFactorMap(i);
		memo.put(i, temp);
		return temp;
	}
}
