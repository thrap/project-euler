package problems;

import java.util.List;

import utils.Euler;

public class Problem50 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int a = 0;
		List<Integer> primes = Euler.primeList(5000);
		for (int prime : primes) {
			if (a + prime > 1000000) {
				for (Integer integer : primes) {
					if (Euler.isPrime(a))
						return a;
					a-=integer;
				}
				break;
			}
			a+=prime;
		}
		return 0;
	}
}
