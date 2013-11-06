package problems;

import java.util.List;

import utils.Euler;

public class Problem313BaseCase {
	public static void main(String[] args) {
		int count = 0;
		for (int m = 2; m < 10000; m++) {
			for (int n = 2; n < 10000; n++) {
				List<Integer> primes = Euler.primeFactorList(moves(m,n));
				if (primes.size() == 2 && primes.get(0) == primes.get(1) && primes.get(0) < 100) {
					count++;
					System.out.println(m + " " + n + " " + count);
				}
			}
		}
		System.out.println(count);
	}

	private static int moves(int m, int n) {
		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		int moves = (m-1)+(n-1); // r¿d = (1,0) hvit = (0,0)
		if (m == n)
			return moves + 3 + 6*(n-2);
		if (m == n+1)
			return moves + 6*(n-1);
		return moves + 6*(n-1)+5*(m-n-1);
	}
	
	
}
