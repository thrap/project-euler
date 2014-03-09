package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Problem323test {
	
	static int pow = 20;
	static int limit = pow(pow);
	
	public static void main(String[] args) {
		
		
		System.out.println(expectedValue(pow));
		
		System.out.println(better(1, 0, 1));
	}
	
	public static int pow(int n) {
		return (int)Math.pow(2, n);
	}
	
	static Map<String, Double> memoize = new HashMap<String, Double>();
	
	public static double better(double prob, int ones, int N) {
		String memo = prob + " " + ones + " " + N;
		if (memoize.containsKey(memo)) {
			return memoize.get(memo);
		}
		if (ones == pow) {
			return N*prob;
		}
		if (prob < 0.0000000000000000001) {
			return 0;
		}
		
//		System.out.println(ones + " enere i runde "+N+": " + prob);
		double sum = 0;
		int zeros = pow-ones;
		for (int newOnes = 0; newOnes <= zeros; newOnes++) {
			int newZeros = zeros-newOnes;
			long permutations = fact(zeros)/(fact(newOnes)*fact(newZeros));
			double newProb = (prob*permutations)*Math.pow(2, ones)/limit;
			//2^pow muligheter
			//2^ones 
			//permutasjoner = zeros!/newOnes!newZeros!
			
			sum += better(newProb, ones+newOnes, N+1);
		}
		memoize.put(memo, sum);
		return sum;
	}
	
	public static long fact(int n) {
		long fact = 1;
		for (int i = 2; i <= n; i++) {
			fact*=i;
		}
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
