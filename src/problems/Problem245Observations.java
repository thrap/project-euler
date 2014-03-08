package problems;

import utils.Euler;
import utils.T;

public class Problem245Observations {
	public static void main(String[] args) {
		/**
		 * alle faktorer er i foerste
		 * 
		 * n = p1*p2*..*pk
		 * phi(n) = phi(p1)*phi(p2)..*phi(pk)
		 *        = (p1-1)*(p2-1)*...*(pk-1)
		 *
		 * n-1 == 0 mod (n-(p1-1)*(p2-1)*...*(pk-1))
		 */
		T t = new T();
		int limit = 2000000000;
		int count = 0;
		for (int n = 2; n <= limit; n++) {
			if (Euler.isPrime(n))
				continue;
			int num = n-Euler.phi(n);
			int denom = n-1;
			if (denom%num==0) {
				count++;
				System.out.println(count+": "+n + " "+ Euler.primeFactorList(n));
			}
		}
		System.out.println(t);
	}
}
