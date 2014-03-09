package Java;

import java.util.List;

import utils.Euler;

public class Problem268 {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(100);
		System.out.println(primes.size());
		
		/**
		 * inclusion exclusion? tror den er for treg men
		 */
		
		for (int i = 0; i < primes.size(); i++) {
			int p1 = primes.get(i);
			for (int j = i+1; j < primes.size(); j++) {
				int p2 = primes.get(j);
				for (int k = j+1; k < primes.size(); k++) {
					int p3 = primes.get(k);
					for (int l = k+1; l < primes.size(); l++) {
						int p4 = primes.get(l);
						long num = p1*p2*p3*p4;
						if (num < 1000) {
							System.out.println(num);
						}
					}
				}
			}
		}
	}
}
