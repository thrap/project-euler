import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Euler;

import static java.math.BigInteger.*;

public class Problem365 {
	public static void main(String[] args) {
		int[] primes = getPrimes();
		System.out.println(Arrays.toString(primes));
		
		
		BigInteger modulo = ONE;
		for (int prime : primes) {
			modulo = modulo.multiply(valueOf(prime));
		}
		System.out.println(modulo.toString().length());
		BigInteger binomial = BinomialCoefficient(TEN.pow(18), TEN.pow(9));
		BigInteger sum = ZERO;
		for (int i = 0; i < primes.length; i++) {
			long p = primes[i];
			System.out.println(i);
			for (int j = i+1; j < primes.length; j++) {
				long q = primes[j];
				for (int k = j+1; k < primes.length; k++) {
					long r = primes[k];
					sum = sum.add(binomial.mod(valueOf(r*q*p)));
				}
			}
		}
		System.out.println(sum);
	}
	
	static BigInteger BinomialCoefficient(BigInteger n, BigInteger k) {
	    if (k.compareTo(n.subtract(k)) == 1) 
	    	k = n.subtract(k);
	    BigInteger asd = n.subtract(k);
	    BigInteger result = ONE;
	    long longK = k.longValue();
	    for (long i = 1; i <= longK; ++i) {
	    	if (i % 1000000 == 0) {
	    		System.out.println(i/1000000 + " / 1000");
	    	}
	    	BigInteger a = valueOf(i);
	        result = result.multiply(asd.add(a));
	        result = result.divide(a);
	    }
	    return result;
	}

	public static int[] getPrimes() {
		int[] primes = new int[501];
		int j = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1000; i < 5000; i++) {
			if (Euler.isPrime(i)) {
				primes[j++] = i;
			}
		}
		return primes;
	}
}
