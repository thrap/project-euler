package Java;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Problem323 {
	
	static int pow = 20;
	static int limit = pow(pow);
	static BigDecimal dLimit = BigDecimal.valueOf(limit);
	
	public static void main(String[] args) {
		
		
		System.out.println(expectedValue(pow));
		
		System.out.println(better(BigDecimal.ONE, 0, 1));
	}
	
	public static int pow(int n) {
		return (int)Math.pow(2, n);
	}
	
	static Map<String, BigDecimal> memoize = new HashMap<String, BigDecimal>();
	
	public static BigDecimal better(BigDecimal prob, int ones, int N) {
		String memo = prob + " " + ones + " " + N;
		if (memoize.containsKey(memo)) {
			return memoize.get(memo);
		}
		if (ones == pow) {
			return prob.multiply(BigDecimal.valueOf(N));
		}
		if (prob.compareTo(BigDecimal.valueOf(0.000000000000000001)) == -1) {
			return BigDecimal.ZERO;
		}
		
//		System.out.println(ones + " enere i runde "+N+": " + prob);
		BigDecimal sum = BigDecimal.ZERO;
		int zeros = pow-ones;
		BigDecimal ekstra = BigDecimal.valueOf(2).pow(ones).divide(dLimit);
		for (int newOnes = 0; newOnes <= zeros; newOnes++) {
			int newZeros = zeros-newOnes;
			BigDecimal newProb = prob.multiply(permutations(zeros, newOnes, newZeros)).multiply(ekstra);
			//2^pow muligheter
			//2^ones 
			//permutasjoner = zeros!/newOnes!newZeros!
			
			sum = sum.add(better(newProb, ones+newOnes, N+1));
		}
		memoize.put(memo, sum);
		return sum;
	}
	
	private static BigDecimal permutations(int zeros, int newOnes, int newZeros) {
		return fact(zeros).divide(fact(newOnes).multiply(fact(newZeros)));
	}

	static Map<Integer, BigDecimal> factorial = new HashMap<Integer, BigDecimal>();
	
	public static BigDecimal fact(int n) {
		if (factorial.containsKey(n))
			return factorial.get(n);
		BigDecimal fact = BigDecimal.ONE;
		for (int i = 2; i <= n; i++) {
			fact = fact.multiply(BigDecimal.valueOf(i));
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
