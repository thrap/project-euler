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
		
		for (int a = 1; a <= 1000; a++) {
			for (int b = a; b <= 100000; b++) {
				if ((100*(a+b)) % (b*a) == 0) {
					int test = a;
					while(test % 5 == 0) {
						test/=5;
					}
					while(test % 2 == 0) {
						test/=2;
					}
					int tes2 = a;
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
					System.out.println(test + " " + tes2);
					if (Euler.isPrime(a) && a != 2 && a != 5 && b%a != 0) {
						System.out.println("Fuck");
						System.exit(0);
					}
				}
			}
		}
	}
}
