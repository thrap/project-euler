package problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Euler;

public class Problem266v5 {
	
	static List<Integer> primes = Euler.primeList(190);
	static BigInteger goal = new BigInteger("2323218950681478446587180516177954548");
	static BigInteger best = BigInteger.ONE;
	
	public static void main(String[] args) {
		BigInteger p = BigInteger.ONE;
		for (int prime : primes) {
			p = p.multiply(BigInteger.valueOf(prime));
		}
		System.out.println(p);
		System.out.println(goal);
		recursion(primes.size()-1, BigInteger.ONE);
		
		System.out.println(best);
	}
	
	static BigInteger[] max = new BigInteger[primes.size()];
	
	static {
		BigInteger maks = BigInteger.ONE;
		for (int i = 0; i < max.length; i++) {
			maks = maks.multiply(BigInteger.valueOf(primes.get(i)));
			max[i] = maks;
		}
	}
	
	static Set<String> memo = new HashSet<String>();
	
	//TODO: Denne failer paa grunn av at den kun sjekker tall opphoeyd i 1 eller 0, og ikke feks 2^10 = 1024
	public static void recursion(int index, BigInteger sum) {
		String mem = sum.toString() + " " + index;
		if (memo.contains(mem))
			return;
		memo.add(mem);
		if (index == -1) 
			return;
		if (sum.multiply(max[index]).compareTo(best) < 0)
			return;
		if (sum.compareTo(goal) > 0)
			return;
		
		if (sum.compareTo(best) > 0) {
			best = sum;
			System.out.println(best);
			System.out.println(goal);
			System.out.println(best.mod(BigInteger.TEN.pow(16)));
		}
		recursion(index-1, sum);
		if (index >= max.length-10) {
			System.out.println("OMFG" + " " + index);
		}
		recursion(index-1, sum.multiply(BigInteger.valueOf(primes.get(index))));
	}
}
