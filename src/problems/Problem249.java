package problems;

import java.util.List;

import utils.Euler;

public class Problem249 {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(5000);
		System.out.println(primes);
		
		long[] array = new long[5000];
		for (int prime : primes) {
			array[prime]++;
		}
		System.out.println(primes.size());
		//5 = 3+2 && 5
		//7 = 5+2 && 3+2+2 NEI
		//Fylle nedenfra og opp?
		//9 = 7+2
		//7 = 5+2
		//5 = 3+2
		//NEI? :p hæhæhæh
	}
}
