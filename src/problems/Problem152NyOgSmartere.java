package problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Euler;

public class Problem152NyOgSmartere {
	
	private static int limit = 80;
	private static int smallSum = 16;
	
	private static BigInteger[] numbers = getNumerators(limit);
	private static BigInteger goal = getCommonDenominator(limit).divide(BigInteger.valueOf(2));
	
	
	/**
	 * vet ikke om denne funker helt as 
	 */
	private static Set<BigInteger> smallSums = getSmallSums(smallSum);
	
	public static void main(String[] args) {
		
		/** 
		 * TODO : lagre info om feks index 20-35 f¿rst
		 */
		System.out.println(smallSums.size());
		// TODO: sjekke om smallsums inneholder dessa
		
		
		/**
		 * dette er det som betyr noe, ignorer alle hjelpemetoder under
		 */
		System.out.println("Hvilken kombinasjon av f¿lgende tall");
		System.out.println(Arrays.toString(numbers));
		System.out.println("gir sum lik \n"+goal);
		
		
		recursion(2, BigInteger.ZERO, "");
	}

	static int count = 0;
	private static void recursion(int index, BigInteger sum, String nums) {
		if (count ++ % 1000000 == 0)
			System.out.println("hei" + " " + count);
		if (index == limit+1) {
		}
		if (index == limit-smallSum+1) {
			if (smallSums.contains(goal.subtract(sum))) {
				System.out.println(nums + " ...");
				System.out.println("OMG YEAH");
			}
			return;
		}
		if (goal.equals(sum)) {
			//lik (dette er spa)
			System.out.println(nums);
			System.out.println("FUCK YEAH BABY GIRL");
			System.exit(0);
		} else if (sum.compareTo(goal) == 1 || index > limit) {
			//for stor
			return;
		}
		if (isBigEnough(index, sum)) {
			//kan bli stor nok
			recursion(index+1, sum, nums);
			recursion(index+1, sum.add(numbers[index]), nums+" "+index);
		}
	}
	
	private static boolean isBigEnough(int index, BigInteger sum) {
		return sum.add(getBiggestSum(index)).compareTo(goal) >= 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	












	private static Set<BigInteger> getSmallSums(int pow) {
		Set<BigInteger> set = new HashSet<BigInteger>();
		
		for (int i = 1; i < Math.pow(2, pow); i++) {
			String bits = Euler.toBinaryString(i, pow);
			BigInteger sum = BigInteger.ZERO;
			for (int j = 0; j < bits.length(); j++) {
				if (bits.charAt(j) == '1') {
					sum = sum.add(numbers[limit-pow+j+1]);
				}
			}
			set.add(sum);
		}
		// TODO Auto-generated method stub
		return set;
	}
	
	/**
	 * disse boysa funker - bare drit i dem 
	 */
	private static Map<Integer, BigInteger> memoize = new HashMap<Integer, BigInteger>();
	private static BigInteger getBiggestSum(int index) {
		if (memoize.containsKey(index)) {
			return memoize.get(index);
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = index; i < numbers.length; i++) {
			sum = sum.add(numbers[i]);
		}
		
		memoize.put(index, sum);
		return sum;
	}
	
	
	private static BigInteger[] getNumerators(int limit) {
		BigInteger commonDenominator = getCommonDenominator(limit);

		BigInteger[] numbers = new BigInteger[limit+1]; 
		for (int i = 2; i <= limit; i++) {
			numbers[i] = commonDenominator.divide(BigInteger.valueOf(i*i));
		}
		return numbers;
	}

	private static BigInteger getCommonDenominator(int limit) {
		Map<Integer, Integer> commonFactors = getCommonFactors(limit);
		
		BigInteger denominator = BigInteger.ONE;
		for (int factor : commonFactors.keySet()) {
			int pow = commonFactors.get(factor);
			denominator = denominator.multiply(BigInteger.valueOf(factor).pow(pow));
		}
		return denominator;
	}

	private static Map<Integer, Integer> getCommonFactors(int limit) {
		Map<Integer, Integer> commonFactors = new HashMap<Integer, Integer>();
		for (int i = 2; i <= limit; i++) {
			for (Map.Entry<Integer, Integer> factor : Euler.primeFactorMap(i*i).entrySet()) {
				if (commonFactors.containsKey(factor.getKey())) {
					commonFactors.put(factor.getKey(), Math.max(factor.getValue(), commonFactors.get(factor.getKey())));
				} else {
					commonFactors.put(factor.getKey(), factor.getValue());
				}
			}
		}
		return commonFactors;
	}
}
