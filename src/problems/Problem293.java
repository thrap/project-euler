package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem293 {
	static int limit = 1000000000;
	static Set<Long> pfns = new TreeSet<Long>();
	
	public static void main(String[] args) {
		
		System.out.println(solution());
	}
	
	public static long solution() {
		List<Integer> primes = Euler.primeList((int)Math.sqrt(limit));
		
		long tall = 1;
		while ((tall*=2) <= limit) {
			pfns.add(tall);
		}
		
		List<Integer> factors = new ArrayList<Integer>();
		factors.add(2);
//			System.out.println(primes.get(j));
//		factors.add(3);
//		pfn(1, new ArrayList<Integer>(factors));
		for (int i = 1; i < primes.size(); i++) {
			factors.add(primes.get(i));
			pfn(1, new ArrayList<Integer>(factors));
		}
//		
		
		
		//pfn = 2^x*3^x*5^x...
		//pfn = 3^x*5^x*7^x...
//		System.out.println(primes);
//		System.out.println(pfn);
//		System.out.println(pfns);
		
//		System.out.println(pfns);
//		System.out.println(pF(630));
		
		Set<Long> set = new HashSet<Long>();
		for (long integer : pfns) {
			set.add(pF(integer));
		}
		long sum = 0;
		for (Long long1 : set) {
			sum+=long1;
		}
		return sum;
	}

	public static long pF(long n) {
		for (int i = 2; true; i++) {
			if (Euler.isPrime(n+i))
				return i;
		}
	}
	
	public static void pfn(long sum, List<Integer> factors) {
		if (factors.size() == 0)
			return;
		long tall = factors.remove(0);
		sum *= tall;
		
		while (canContinue(sum, factors)) {
			long asdSum = sum*sum(factors);
			pfn(sum, new ArrayList<Integer>(factors));
			pfns.add(asdSum);
//			System.out.println(sum);
			sum*=tall;
		}
	}
	
	public static long sum(List<Integer> factors) {
		long sum = 1;
		for (Integer integer : factors) {
			sum*=integer;
		}
		return sum;
	}
	
	public static boolean canContinue(long sum, List<Integer> factors) {
		if (sum > limit)
			return false;
		for (Integer integer : factors) {
			if ((sum*=integer) > limit)
				return false;
		}
		return true;
	}
}
