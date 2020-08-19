import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.T;

public class Problem418 {
	static int factorial = 43;
	static int[] factors;
	static int[] pows;
	/**
	 * legger inn faktorer og eksponenter i arrays
	 */
	static {
		int i = 0;
		Map<Integer, Integer> tempFactors = Problem418BaseCase.factorialPrimeFactors(factorial);
		factors = new int[tempFactors.size()];
		pows = new int[tempFactors.size()];
		for (Entry<Integer, Integer> factor : tempFactors.entrySet()) {
			System.out.println(factor);
			factors[i] = factor.getKey();
			pows[i] = factor.getValue();
			i++;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		for (int i = 0; i < factors.length; i++) {
			System.out.print(factors[i]+"^"+pows[i]+" * ");
		}
		System.out.println();
		
		rec(BigInteger.ONE, 0);
		BigInteger goal = BigInteger.ONE;
		for (int i = 2; i <= factorial; i++) {
			goal = goal.multiply(BigInteger.valueOf(i));
		}
		BigInteger[] numbers = new BigInteger[candidates.size()];
		int asd = 0;
		for (BigInteger candidate : candidates) {
			numbers[asd++] = candidate;
		}
		
		BigDecimal minste = BigDecimal.TEN.pow(100);
		BigDecimal f = null;
		for (int i = 0; i < numbers.length; i++) {
			if (i % 100 == 0)
				System.out.println(i + " " + numbers.length);
			for (int j = i; j < numbers.length; j++) {
				BigInteger num = numbers[i].multiply(numbers[j]);
				if (goal.mod(num).equals(BigInteger.ZERO) && candidates.contains(goal.divide(num))) {
					BigInteger[] tall = {goal.divide(num), numbers[i], numbers[j]};
					Arrays.sort(tall);
					
					BigDecimal a = new BigDecimal(tall[0]);
					BigDecimal b = new BigDecimal(tall[1]);
					BigDecimal c = new BigDecimal(tall[2]);
					
					if (c.divide(a, 100, RoundingMode.HALF_DOWN).compareTo(minste) == -1) {
						minste = c.divide(a, 100, RoundingMode.HALF_DOWN);
						System.out.println(a);
						System.out.println(b);
						System.out.println(c);
						System.out.println(minste);
						f = a.add(b).add(c);
						System.out.println(a.add(b).add(c));
					}
				}
			}
		}
		System.out.println(f + " " + t);
	}
	static BigInteger upperLimit = BigInteger.valueOf(3925).multiply(BigInteger.TEN.pow(14));
	static BigInteger lowerLimit = BigInteger.valueOf(3922).multiply(BigInteger.TEN.pow(14));

	static int count = 0;
	static Set<BigInteger> candidates = new HashSet<BigInteger>();
	
	private static void rec(BigInteger number, int i) {
		if (number.compareTo(upperLimit) == 1)
			return;
		if (i == pows.length) {
			if (number.compareTo(lowerLimit) == 1) {
				candidates.add(number);
				if (++count % 10000 == 0)
					System.out.println(count + " "+ number);
			}
			return;
		}
		
		for (int j = 0; j <= pows[i]; j++) {
			rec(number.multiply(BigInteger.valueOf(factors[i]).pow(j)), i+1);
		}
	}
}
