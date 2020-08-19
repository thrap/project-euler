import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem157 {
	public static void main(String[] args) {
		/**
		 * 5001*(1+2^3*5^4)/5001^2
		 * 
		 * (1+2^4*5^6)/4717
		 * 
		 * (2^4+5^5)/3141
		 * 
		 * 10^n*(2^a*5^b + 2^c*5^d) / x er et heltall
		 */
		
		T t = new T();
		int N = 9;
		
		int matches = 0;
		Set<Long> set = new TreeSet<Long>();
		int limit = N+1;
		for (int a = 0; a <= limit; a++) {
			for (int b = 0; b <= limit; b++) {
				for (int c = 0; c <= limit; c++) {
					for (int d = 0; d <= limit; d++) {
						long i = pow(2,a)*pow(5,b) +pow(2,c)*pow(5,d);
						while(i%2 == 0)
							i/=2;
						while (i%5 == 0) 
							i/=5;
						for (long long1 : Euler.divisorList(i)) {
							set.add(long1);
						}
					}
				}
			}
		}
		

		int iteration = 0;
		for (long i: set) {
			System.out.println(matches + " ("+(++iteration) + "/"+set.size()+")");
			
			for (int a2s = 0; a2s <= N+1; a2s++) {
				for (int a5s = 0; a5s <= N+1; a5s++) {
					BigInteger A = valueOf(i).multiply(valueOf(2).pow(a2s)).multiply(valueOf(5).pow(a5s));
					for (int b2s = 0; b2s <= N+1; b2s++) {
						for (int b5s = 0; b5s <= N+1; b5s++) {
							BigInteger B = valueOf(i).multiply(valueOf(2).pow(b2s)).multiply(valueOf(5).pow(b5s));
							if (A.compareTo(B) == 1)
								continue;
							
							
							for (int n = 1; n <= N; n++) {
								if (TEN.pow(n).multiply(A.add(B)).mod(A.multiply(B)).equals(ZERO)) {
									matches++;	
								} 
							}
						}
					}
				}
			}
		}
		
		System.out.println("Solution: " +matches + " " + t);
	}

	private static long pow(int i, int a) {
		return (long)Math.pow(i, a);
	}
	
	
}
