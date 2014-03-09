package Java;

import utils.Euler;

public class Problem27 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int best = 0;
		int bestProduct = 0;
		for (int b : Euler.primeList(1000)) {
			for (int a = -1000; a < 1000; a++) {
				int n = 0;
				for (; Euler.isPrime(n*n+a*n+b); n++) {
					
				}
				if (n > best) {
					best = n;
					bestProduct = a*b;
				}
			}
		}
		return bestProduct;
	}
}
