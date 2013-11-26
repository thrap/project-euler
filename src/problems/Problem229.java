package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Euler;
import utils.T;


public class Problem229 {
	
	/**
	 * http://math.uga.edu/~pete/thuelemmav7.pdf
	 * 
	 * denne lager alt for stor stack. fix plx
	 */
	
	static int limit = (int)Math.pow(10, 7);
	public static void main(String[] args) {
		T t = new T();
		for (Integer p : Euler.primeList((int)Math.sqrt(limit))) {
			if (isCritical(p))
				critical.add(p);
		}
		for (Integer p : Euler.primeList(limit)) {
			if (!isCritical(p))
				other.add(p);
		}
		
		reccurse(1, 0);
		
		int ones = 0;
		for (int special: specials) {
			Map<Integer, Integer> factors = Euler.primeFactorMap(special);
			if (factors.size() == 1)
				ones++;
			System.out.println(factors);
		}
		System.out.println("Ones: "+ones);
		
		System.out.println("generert antall: "+specials.size() + " " + t);
		System.out.println("riktig antall  : "+75373);
		
	}
	
	static List<Integer> other = new ArrayList<Integer>();
	static List<Integer> critical = new ArrayList<Integer>();
	
	static List<Integer> specials = new ArrayList<Integer>();
	
	private static void reccurse(long n, int i) {
		if (i == critical.size() || critical.get(i)*n > limit) {
			reccurse2(n, 0);
		} else {
			int p = critical.get(i);
			
			for (int j = 0; n*Math.pow(p, j) <= limit; j+=2) {
				reccurse(n*(long)Math.pow(p, j), i+1);
			}
		}
	}

	private static void reccurse2(long n, int i) {
		if (i == other.size() || other.get(i)*n > limit) {
			if (isBruteSpecial((int)n)) {
				specials.add((int)n);
				if (specials.size() % 1000 == 0)
					System.out.println(specials.size());
			}
		} else {
			int p = other.get(i);
			for (int j = 0; n*Math.pow(p, j) <= limit; j++) {
				reccurse2(n*(long)Math.pow(p, j), i+1);
			}
		}
	}

	private static boolean isBruteSpecial(int n) {
		return isSquareSum(n, 1) && isSquareSum(n, 2) && isSquareSum(n, 3) && isSquareSum(n, 7);
	}
	
	private static boolean isSquareSum(int n, int D) {
		for (int a = 1; a*a < n; a++) {
			if ((n-a*a) % D == 0 && Euler.isPerfectSquare((n-a*a)/D))
				return true;
		}
		return false;
	}

	private static boolean isCritical(int p) {
		return  (p % 7 == 3) || (p % 7 == 5) || (p % 7 == 6) || 
				(p % 4 == 3) || (p % 8 == 5) || (p % 8 == 7) || 
				(p % 3 == 2); 
	}
}
