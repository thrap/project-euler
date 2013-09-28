package problems;

import java.util.List;

import utils.Euler;

public class Problem231 {
	
	static int limit = 20000000;
	public static List<Integer> primes = Euler.primeList((int)(1+Math.sqrt(limit)));
	static boolean[] prim = Euler.primeArray(limit);
	
	static long sum = 0;
	
	public static void main(String[] args) {
		System.out.println(solution());
		
		
	}
	
	public static long solution() {
		int n = 20000000;
		int k = 15000000;
		int r = n-k;
//		n!/k!*(n-k)!
//		20000000*...*15000001
		
		
		for (int i = n; i > k; --i) {
			pluss(i);
		}
		for (int i = r; i !=0 ; --i) {
			minus(i);
		}
		return sum;
	}

	public static void pluss(int numbers) {
		int n = numbers;
		int tall = 2;
		for (int i = 0; tall <= n / tall && i<primes.size(); i++) {
			tall = primes.get(i);
			while (n % tall == 0) {
				sum+=tall;
				n /= tall;
			}
			if (prim[n])
				break;
		}
		if (n > 1)
			sum+=n;
	}
	
	public static void minus(int numbers) {
		int n = numbers;
		int tall = 2;
		for (int i = 0; tall <= n / tall && i<primes.size(); i++) {
			tall = primes.get(i);
			while (n % tall == 0) {
				sum-=tall;
				n /= tall;
			}
			if (prim[n])
				break;
		}
		if (n > 1)
			sum-=n;
	}
}
