package problems;

import java.math.BigInteger;
import java.util.List;

import utils.Euler;

public class Problem358Brute {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(10000000);
		primes.remove(0);
		primes.remove(0);
		
		/**
		 * teste primtall mellom 99999999999/138 og 99999999999/137 (eller kanskje 136)
		 */
		
		//(10^(p-1)-1)/p mod 10^10
		
		System.out.println(BigInteger.TEN.modPow(BigInteger.valueOf(725-1), BigInteger.valueOf(725)));
		for(Integer prime : primes) {
			BigInteger cycle = BigInteger.TEN.pow(prime-1).subtract(BigInteger.ONE);
			int length = cycle.toString().length();
			cycle = cycle.divide(BigInteger.valueOf(prime));
			int leadingZeros = length - cycle.toString().length();
			if (cycle.toString().substring(0, 3).equals("137")) {
				System.out.println(prime); 
				System.out.println(leadingZeros + " leading zeros");
//				System.out.println(cycle.toString().length());
				System.out.println(cycle);
//				System.out.println("OMG");
				continue;
			}
			
			
		}
	}
}
