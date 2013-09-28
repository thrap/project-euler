package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem266v2 {
	static List<BigInteger> primes = new ArrayList<BigInteger>();
	static BigInteger goal = new BigInteger("2323218950681478446587180516177954548");
	static BigInteger toBig = goal.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
	static BigInteger best = BigInteger.ONE;
	
	public static void main(String[] args) {
		for (Integer prime: Euler.primeList(190)) {
			primes.add(BigInteger.valueOf(prime));
		}
		System.out.println(primes);
		System.out.println(primes.size());
		
		
		Set<BigInteger> set = new TreeSet<BigInteger>(new Comparator<BigInteger>() {
			@Override
			public int compare(BigInteger o1, BigInteger o2) {
				return o2.compareTo(o1);
			}
		});
		
		//TODO: rofl dette funker jo faktisk ikke og går i loop lizm hæhæh xD
		set.addAll(primes);
		int i = 0;
		while(true) {
			BigInteger first = set.iterator().next();
			set.remove(first);
			if (++i % 100000 == 0) {
				System.out.println("------------------");
				System.out.println("Første: "+first);
				System.out.println("Antall: " + set.size());
				System.out.println("Beste:  "+best);
				System.out.println("Goal:   "+goal);
				System.out.println("Ans:    "+best.mod(BigInteger.TEN.pow(16)));
			}
			for (BigInteger prime : primes) {
				BigInteger product = first.multiply(prime);
				if (product.compareTo(goal) < 0) {
					if (product.compareTo(toBig) >= 0) {
						if (product.compareTo(best) == 1) {
							best = product;
							System.out.println(product);
						}
					} else {
						set.add(product);
					}
				}
			}
		}
		
	}
}
