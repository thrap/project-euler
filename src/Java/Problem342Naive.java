package Java;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem342Naive {
	public static void main(String[] args) {
		
		T t = new T();
		Set<Integer> set = new TreeSet<Integer>();
		long limit = 1000000;
		long sum = 0;
		int count = 0;
		for (long n = 2; n < limit; n++) {
			long phi = n*Euler.phi(n);
			if (Math.pow((long)Math.cbrt(phi), 3) == phi) {
				sum += n;
				System.out.println(n + " " + phi);
				System.out.println(Euler.primeFactorList(n));
				List<Integer> phiPrimes = Euler.primeFactorList(phi);
				System.out.println(phiPrimes);
				set.addAll(phiPrimes);
				System.out.println();
				count++;
			}
		}
		
		System.out.println(sum + " " + t);
		System.out.println("563098362");
		System.out.println("Antall tall: " + count);
		System.out.println("Brukte primes: " + set);
	}
}
