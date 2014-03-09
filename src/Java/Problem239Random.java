package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Euler;

public class Problem239Random {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(100);
		System.out.println(primes.size());
		List<Integer> dearangement = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			dearangement.add(i);
		}
		
		int mulige = 1000000;
		int gunstige = 0;
		for (int i = 0; i < mulige; i++) {
			Collections.shuffle(dearangement);
			int ant = 0;
			for (Integer prime : primes) {
				if (dearangement.get(prime-1) == prime)
					++ant;
			}
			if (ant == primes.size()-22)
				gunstige++;
		}
		
		System.out.println((double)gunstige/(double)mulige);
		
	}
}
