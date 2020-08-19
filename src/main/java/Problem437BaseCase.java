import java.math.BigInteger;
import java.util.List;

import utils.Euler;
import utils.T;

public class Problem437BaseCase {
	public static void main(String[] args) {
		T t = new T();
		
		/**
		 * 5 is a special case. 
		 */
		long sum = 5;
		int count = 1;
		
		for (int p : Euler.primeList(10000)) {
			if (!(p % 10 == 9 || p % 10 == 1))
				continue;
			
			if (hasFibonacciPrimitiveRoot(p)) {
				System.out.println("YES: "+p + " " + leastPrimitiveRoot(p));
				count++;
				sum+=p;
			} else {
				System.out.println("NO:  "+p + " " + leastPrimitiveRoot(p));
			}
		}
		System.out.println(count  + " " + sum + " " + t);
	}

	private static boolean hasFibonacciPrimitiveRoot(int p) {
		int b = leastPrimitiveRoot(p);
		
		int phi = Euler.phi(p-1);
		int primitiveRoots = 0;
		for (int k = 1; primitiveRoots < phi; k++) {
			if (Euler.gcd(k, p-1) != 1)
				continue;
			primitiveRoots++;
//			b^(2k) == b^k + 1 mod p
//			b^k*(b^k-1) == 1 mod p
			int g = modPow(b, k, p);
			if (g*g % p == g+1) {
				return true;
			}
		}
		return false;
	}
	
	

	private static int modPow(int b, int k, int p) {
		return BigInteger.valueOf(b).modPow(BigInteger.valueOf(k), BigInteger.valueOf(p)).intValue();
	}

	private static int leastPrimitiveRoot(int prime) {
		int s = prime-1;
		
		List<Integer> factors = Euler.primeFactorDistinctList(s);
		ytterste: 
		for (int a = 2; a <= prime; a++) {
			for (int p : factors) {
				if (Euler.modPow(a, s/p, prime) == 1)
					continue ytterste;
			}
			return a;
		}
		throw new RuntimeException("Fant ikke en dritt ffs");
	}
}
