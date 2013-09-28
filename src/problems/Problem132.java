package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem132 {
	
	public static BigInteger R(int k) {
		return BigInteger.valueOf(10).pow(k).divide(BigInteger.valueOf(9));
	}
	
	public static void main(String[] args) {
		System.out.println(R(10));
		System.out.println(R(16).longValue());
		System.out.println(R(2));
		System.out.println(Euler.primeFactorList(R(16).longValue()));
		
		List<Integer> divisors = Euler.divisorList(1000000000);
		Collections.sort(divisors);
		divisors.remove(0);
		System.out.println(divisors);
		
		List<Integer> primeFactors = new ArrayList<Integer>();
		Set<Integer> f = new HashSet<Integer>();
		
		for (Integer divisor : divisors) {
			BigInteger r = R(divisor);
			for (int i : Euler.primeList(162252)) {
				if (r.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
					if (!f.contains(i)) {
						f.add(i);
						for (Integer a : Euler.primeFactorDistinctList(i)) {
							if (!primeFactors.contains(a)) {
								primeFactors.add(a);
							}
						}
						System.out.println(i + " " + primeFactors.size());
						if (primeFactors.size() >= 40) {
							Collections.sort(primeFactors);
							int sum = 0;
							for (int j = 0; j < 40; j++) {
								sum += primeFactors.get(j);
							}
							System.out.println(sum + " " + primeFactors.get(39) + " " + divisor);
						}
					}
				}
			}
		}
	}
}
