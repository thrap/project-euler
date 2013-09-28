package problems;

import java.util.List;

import utils.Euler;

public class Problem58 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	private static List<Integer> PRIMES = Euler.primeList(500000);
	
	public static int solution() {
		int sum = 1;
		double primes = 0;
		double tall = 1;
		for (int x = 3; x <= 1000000; x+=2) {
			int length = x-1;
			for (int i = 0; i < 4; i++) {
				if (isPrime(x*x - length*i))
					++primes;
				++tall;
			}
			if (primes/tall <= 0.1)
				return x;
		}
		System.out.println(primes/tall);
		return sum;
	}

	private static boolean isPrime(int i) {
		for (int prime : PRIMES) {
			if (prime*prime > i)
				return true;
			if (i%prime == 0)
				return false;
		}
		return true;
	}
}
