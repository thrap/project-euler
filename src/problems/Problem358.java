package problems;

import java.util.List;

import utils.Euler;
import utils.T;


public class Problem358 {
	public static void main(String[] args) {
		T t = new T();
		int count = 0;
		List<Long> primeListBetween = Euler.primeListBetween((99999999999L/138), 99999999999L/137+11);
		for (long prime : primeListBetween) {
			count++;
			/**
			 * må finne ut en måte å finne siste digits på
			 * 
			 * kan kanskje gange med x -> prime og se om de første tallene er lik 567890..0137..
			 */
			if (isCyclic(prime)) {
				System.out.println(prime + " " + count+"/"+primeListBetween.size() + " "+t);
			}
			
		}
		System.out.println(count);
	}
	
	private static boolean isCyclic(long p) {
		long count = 0;
		long r = 1;
		long lastDigits = 0;
		do {
			count++;
			long x = r*10;
			long lastDigit = x/p;
			r = x % p;
			lastDigits = (lastDigits*10 + lastDigit)%100000;
		} while(r != 1);
		
		if (count == p-1) {
			System.out.println(lastDigits);
			if (lastDigits == 56789) {
				/**
				 * dette er målet
				 */
				System.out.println(p + "!!!!!!!!!!!!!!!!!!!!!!!!");
				System.exit(0);
			}
		}
		return (count == p-1);
	}
}
