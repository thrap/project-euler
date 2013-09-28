package problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Euler;

public class Problem381 {
	static int LIMIT = 5*(int)Math.pow(10, 7);
	static List<Integer> primes;
	static Map<Integer, Integer> pows = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		primes = Euler.bedrePrimeList(LIMIT+10);
		System.out.println(primes.size());
		int sum = 0;
		
		for (int i = 5; i < LIMIT; i++) {
			if (i % 1000 == 0)
				System.out.println(i);
			if (Euler.isPrime(i)) {
				sum+=S(i);
			} 
			for (int pow : Euler.primeFactorList(i-5)) {
				if (pows.containsKey(pow)) {
					pows.put(pow, pows.get(pow)+1);
				} else {
					pows.put(pow, 1);
				}
			}
		}
		
		System.out.println(sum);
	}
	
	static Map<Integer, Integer> juksePows = new HashMap<Integer, Integer>();
	public static long S(int prime) {
		juksePows.clear();
		
		long sum = 0;
		for (int k = 5; k >= 1; k--) {
			addJuks(prime, k);
			
			sum += mod(prime);
			sum%=prime;
		}
		return sum%prime;
	}

	private static void addJuks(int prime, int k) {
		for (int pow : Euler.primeFactorList(prime-k)) {
			if (juksePows.containsKey(pow)) {
				juksePows.put(pow, juksePows.get(pow)+1);
			} else {
				juksePows.put(pow, 1);
			}
		}
	}

	private static long pows(int p) {
		Integer a = pows.get(p);
		Integer b = juksePows.get(p);
		if (a == null)
			a = 0;
		if (b == null)
			b = 0;
		
		return a+b;
	}
	
	private static long mod(int p) {
		long sum = 1;
		for (Integer prime : primes) {
			long exp = pows(prime);
			if (prime > p) break;
			if (exp == 0)
				break;
			sum *= modPow(prime, exp, p); 
			sum%=p;
		}
		return sum%p;
	}


	private static long modPow(Integer prime, long exp, int p) {
		return BigInteger.valueOf(prime).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(p)).longValue();
	}
}
