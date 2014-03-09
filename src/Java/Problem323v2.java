package Java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Problem323v2 {
	
	static int pow = 32;
	static long limit = pow(pow);
	static BigDecimal dLimit = BigDecimal.valueOf(limit);
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
//		System.out.println(expectedValue(pow));
		
		System.out.println(better(1, 0, 0) + " (" + (System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long pow(int n) {
		return (long)Math.pow(2, n);
	}
	
	static Map<String, Double> memoize = new HashMap<String, Double>();
	
	public static double better(double prob, int ones, int N) {
		String memo = prob + " " + ones + " " + N;
		if (memoize.containsKey(memo)) {
			return memoize.get(memo);
		}
		if (ones == pow) {
			return prob*N;
		}
		if (prob < 0.0000000000000000000001) {
			return 0;
		}
		
//		System.out.println(ones + " enere i runde "+N+": " + prob);
		double sum = 0;
		int zeros = pow-ones;
		double ekstra = Math.pow(2, ones)/limit;
		for (int newOnes = 0; newOnes <= zeros; newOnes++) {
			int newZeros = zeros-newOnes;
			double newProb = prob * (permutations(zeros, newOnes, newZeros)*(ekstra));
			//2^pow muligheter
			//2^ones 
			//permutasjoner = zeros!/newOnes!newZeros!
			
			sum += better(newProb, ones+newOnes, N+1);
		}
		memoize.put(memo, sum);
		return sum;
	}
	
	static Map<Integer, Double> permutations = new HashMap<Integer, Double>();
	
	private static double permutations(int zeros, int newOnes, int newZeros) {
		int memo = zeros*10000+newOnes*100+newZeros;
		if (permutations.containsKey(memo))
			return permutations.get(memo);
		double sum = fact(zeros).divide(fact(newOnes).multiply(fact(newZeros))).doubleValue();
		permutations.put(memo, sum);
		return sum;
	}

	static Map<Integer, BigInteger> factorial = new HashMap<Integer, BigInteger>();
	
	public static BigInteger fact(int n) {
		if (factorial.containsKey(n))
			return factorial.get(n);
		BigInteger fact = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		factorial.put(n, fact);
		return fact;
	}
	
	public static double probability(double prob, int number, int N) {
		if (number == limit-1) {
			return prob*N;
		}
		if (prob < 0.00000001) {
			return 0;
		}
		
		double sum = 0;
		for (int j = 0; j < limit; j++) {
			sum += probability(prob/limit, number|j, N+1);
		}
		return sum;
	}

	private static double expectedValue(int pow) {
		int limit = (int)Math.pow(2, pow);
		
		int tries = 1000000;
		int sum = 0;
		for (int i = 0; i < tries; i++) {
			int tall = 0;
			
			int N;
			for (N = 1; tall != limit-1; N++) {
				tall = tall|new Random().nextInt(limit);
			}
			sum+=N;
		}
		
		return ((double)sum/(double)tries);
	}
}
