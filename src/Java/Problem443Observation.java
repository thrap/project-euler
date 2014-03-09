package Java;

import utils.Euler;

public class Problem443Observation {
	public static void main(String[] args) {
//		System.out.println(g(1000));
		System.out.println(g(100000000));
		
		
		/**
		 * omg de biter hverandre i halen :o
		 * 
		 * 9 - 17 (2*9-1)
		 * 21 - 42 (2*21-1)
		 * 42 - 83 (2*42-1)
		 * 84 - 167
		 * 177 - 353
		 * 381 - 761
		 * 762 - 1523
		 * 1560 - 3119
		 * 3129 - 6257
		 */
	}

	private static long g(long n) {
		long g = 13;
		for (int i = 5; i <= n; i++) {
			if (Euler.gcd(i, g) != 1)
				System.out.println(i +" "+ g + " " + Euler.gcd(i, g));
			g = g+Euler.gcd(i, g);
		}
		return g;
	}
}
