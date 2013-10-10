package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem342Faster {
	public static void main(String[] args) {
		
		/**
		 * TODO: ta en titt pŒ hvordan primtall som er gangstere: feks 271, 251, 19 osv
		 */
		
		/**
		 * phi(n^2) = n*phi(n) 
		 *	 		= (p1-1)p1^(2*k1-1)*(p2-1)p2^(2*k2-1)*...*(pr-1)pr^(2*kr-1)
		 *
		 *der 
		 *
		 *n = p1^k1*p2^k2*...*pr^kr
		 * 
		 * 
		 * 
		 * 
		 * phi(k) alltid partall for k>=3
		 * 
		 * For Œ l¿se denne: 
		 * Finne primefactorsbetween gjennom Sieve med cachet primtall under sqrt(10^10)=10^5 og teste mot likning over
		 */
		T t = new T();
		Set<Integer> set = new TreeSet<Integer>();
		long limit = 10000000;
		long sum = 0;
		for (long n = 2; n < limit; n++) {
			if (phiIsCube(n)) {
				sum+=n;
				
				System.out.println(n + " " + Euler.primeFactorList(n));
			}
			pelle[(int)n] = null;
		}
		System.out.println(sum + " " + t);
		System.out.println("563098362");
		System.out.println(set);
	}
	
	static List<Integer>[] pelle = Euler.primeFactorDistinctListsBelow(10000000);

	private static boolean phiIsCube(long n) {
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
		
		List<Integer> primeFactors = pelle[(int)n];
		
		Map<Integer, Integer> ps = new HashMap<Integer, Integer>();
		
		for (int p : primeFactors) {
			int k = 1;
			long temp = n/p;
			while (temp % p == 0) {
				temp/=p;
				k++;
			}
			
			ps.put(p, 2*k-1);
		}
		
		for (int p : primeFactors) {
			for (Map.Entry<Integer, Integer> entry: Euler.primeFactorMap(p-1).entrySet()) {
				Integer prime = entry.getKey();
				ps.put(prime, (ps.containsKey(prime) ? ps.get(prime) : 0) + entry.getValue());
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : ps.entrySet()) {
			if (entry.getValue() % 3 != 0)
				return false;
		}
		
		return true;
	}
}
