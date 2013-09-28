package problems;

import utils.Euler;

public class Problem143 {
	public static void main(String[] args) {
		/**
		 * se maple-fil i dropbox
		 */

		int limit = 10000;
		int count = 0;
		for (long a = 1; a < limit; a++) {
			for (long b = a; b < limit; b++) {
				for (long c = b; c < limit; c++) {
					long s1 = 3*(-a*a*a*a+2*a*a*b*b-b*b*b*b+2*a*a*c*c+2*b*b*c*c-c*c*c*c);
					if (!Euler.isPerfectSquare(s1)) 
						continue;
					long q1 = (long) Math.sqrt(s1);
					long s2 = a*a+b*b+c*c+q1;
					if (s2%2 != 0)
						continue;
					s2/=2;
					if (Euler.isPerfectSquare(s2)) {
						long pqr = (long) Math.sqrt(s2);
						if (++count % 1 == 0) {
							System.out.println(pqr);
							System.out.println(a + " " + b + " " +c);
						}
					}
				}
			}
		}
	}
}
