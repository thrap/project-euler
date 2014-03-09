package Java;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Euler;

public class Problem43 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	
	private static Set<Integer>[] mod10 = new Set[7];
	private static Set<Integer>[] mod100 = new Set[7];
	static List<Integer> primes = Euler.primeList(20);
	
	static {
		for (int i = 0; i < mod10.length; i++) {
			mod10[i] = new HashSet<Integer>();
			mod100[i] = new HashSet<Integer>();
			int tall = 0;
			while (Math.log10(tall+=primes.get(i)) < 3) {
				mod10[i].add(tall%10);
				mod100[i].add(tall%100);
			}
		}
	}
	static int j = 0;
	public static long recursion(String s, int i, int forrige) {
		if (i == -1) {
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < s.length(); j++) {
				set.add(s.charAt(j));
			}
			return set.size()==9?Long.parseLong(s):0;
		}
		int tall = 0;
		long sum = 0;
		while (Math.log10(tall+=primes.get(i)) < 3) {
			if (tall%100==forrige/10)
				if (i <= 1 || (mod100[i-1].contains(tall/10)) && (i<=2 ||mod10[i-2].contains(tall/100)))
					sum+=recursion(tall/100+s, i-1, tall);
				
		}
		return sum;
	}
	
	public static void hallaBone() {
		System.out.println("HALLA BONE");
	}
	
	public static long solution() {
		int tall = 0;
		long sum = 0;
		int i = 6;
		while (Math.log10(tall+=primes.get(i)) < 3) {
			if (i <= 1 || (mod100[i-1].contains(tall/10)) && (i<=2 ||mod10[i-2].contains(tall/100)))
				sum+=recursion(new DecimalFormat("000").format(tall), i-1, tall);
				
		}
		return sum;
	}
}
