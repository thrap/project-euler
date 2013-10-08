package problems;

import utils.Euler;

public class Problem157Test {
	public static void main(String[] args) {
		//10^n*(a+b) = p*b*a
		//p = 2^n*5^n(a+b)/(b*a)
		
		/**
		 * Dersom man tar bort alle faktorer av 5 eller 2 fra a og b er tallene like
		 */
		
		int n = 1;
		int count = 0;
		for (long a = 1; a <= 100000; a++) {
			for (long b = a; b <= 100000; b++) {
				if ((1000*(a+b)) % (b*a) == 0) {
					long test = a;
					while(test % 5 == 0) {
						test/=5;
					}
					while(test % 2 == 0) {
						test/=2;
					}
					long tes2 = a;
					while(tes2 % 5 == 0) {
						tes2/=5;
					}
					while(tes2 % 2 == 0) {
						tes2/=2;
					}
					if (test != tes2) {
						System.out.println("FUck");
						System.exit(0);
					}
					System.out.println(a + " " + b);
					System.out.println(test + " " + tes2 + " (" + ++count+")");
					if (Euler.isPrime(a) && a != 2 && a != 5 && b%a != 0) {
						System.out.println("Fuck");
						System.exit(0);
					}
				}
			}
		}
	}
}
