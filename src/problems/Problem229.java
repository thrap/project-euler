package problems;

import java.util.Map;

import utils.Euler;


public class Problem229 {
	public static void main(String[] args) {
		int count = 0;
		for (int n = 5; n <= (int)Math.pow(10, 7); n++) {
			if (n % 100000 == 0)
				System.out.println(n + " " + count);
			if (isSpecial(n)) {
				if (isBruteSpecial(n)) {
					if (isEdgeCase(n)) {
//						System.out.println(n + " "+Euler.primeFactorMap(n));
//						sumSquarePrint(n,1);
//						sumSquarePrint(n,2);
//						sumSquarePrint(n,3);
//						sumSquarePrint(n,7);
					}
					
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(75373);
	}
	
	private static boolean isEdgeCase(int n) {
		for (Map.Entry<Integer, Integer> entry : Euler.primeFactorMap(n).entrySet()) {
			int p = entry.getKey();
			if (!isCritical(p))
				return false;
		}
		return true;
	}

	private static boolean isBruteSpecial(int n) {
		return isSquareSum(n, 1) && isSquareSum(n, 2) && isSquareSum(n, 3) && isSquareSum(n, 7);
	}
	
	private static boolean sumSquarePrint(int n, int D) {
		for (int a = 1; a*a <= n; a++) {
			for (int b = 1; a*a + D*b*b <= n; b++) {
				if (a*a+D*b*b == n) {
					System.out.println(Euler.primeFactorList(a)+"^2 + "+D+"*"+Euler.primeFactorList(b)+"^2");
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSquareSum(int n, int D) {
		for (int a = 1; a*a < n; a++) {
			if ((n-a*a) % D == 0 && Euler.isPerfectSquare((n-a*a)/D))
				return true;
		}
		return false;
	}

	/**
	 * http://math.uga.edu/~pete/thuelemmav7.pdf
	 * 
	 * p % 7 == 3,5,6
	 * p % 4 == 3
	 * p % 8 == 5,7
	 * p % 3 == 2
	 */

	//alle pows lik 2 returnerer true -> piss
	private static boolean isSpecial(int n) {
		Map<Integer, Integer> primeFactorMap = Euler.primeFactorMap(n);
		for (Map.Entry<Integer, Integer> entry : primeFactorMap.entrySet()) {
			int p = entry.getKey();
			int ord = entry.getValue();
			if (isCritical(p) && ord % 2 != 0)
				return false;
		}
		return true;
	}

	private static boolean isCritical(int p) {
		return  (p % 7 == 3) || (p % 7 == 5) || (p % 7 == 6) || 
				(p % 4 == 3) || (p % 8 == 5) || (p % 8 == 7) || 
				(p % 3 == 2); 
	}
}
