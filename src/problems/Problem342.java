package problems;

import utils.Euler;

public class Problem342 {
	public static void main(String[] args) {
		System.out.println(Euler.primeFactorList(50*Euler.phi(50)));
		
		/**
		 * fi(n^2) = n*fi(n)
		 * 
		 */
		long limit = 10000000;
		long count = 0;
		for (int n = 2; n < limit; n++) {
			if (n%10000 == 0)
				System.out.println(n);
			count+=Euler.primeFactorList(n).size();
		}
		System.out.println(count);
	}
}
