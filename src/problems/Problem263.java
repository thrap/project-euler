package problems;

import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem263 {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(10000000);
		List<Integer> engineers = new ArrayList<Integer>();
		for (int i = 2; i < primes.size(); i++) {
			int a = primes.get(i-2);
			int b = primes.get(i-1);
			int c = primes.get(i);
			
			if (b-a == 6 && c-b == 6) {
				int n = a+9;
				engineers.add(n);
				System.out.println(n);
			}
		}
		System.out.println(engineers.size() + "/"+primes.size());
	}
}
