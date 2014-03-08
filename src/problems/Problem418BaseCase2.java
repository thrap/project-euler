package problems;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public class Problem418BaseCase2 {
	static int factorial = 23;
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
		for (int i = 0; i < factors.length; i++) {
			System.out.print(factors[i]+"^"+pows[i]+" * ");
		}
		long start = System.currentTimeMillis();
		System.out.println();
		nestedFor(0);
		System.out.println(count + " ("+(System.currentTimeMillis()-start)+"ms)");
	}

	static int count = 0;
	
	static int[] pows1 = new int[pows.length];
	static int[] pows2 = new int[pows.length];
	static int[] pows3 = new int[pows.length];

	/**
	 * dette gr ikke ugg ugg
	 * 
	 * fr det samme tallet 6 ganger, m finne noe smart for  unng dette
	 * 
	 */
	private static void nestedFor(int i) {
		if (i == pows.length) {
			sjekkTall();
			return;
		}
		int pow = pows[i];
		
		for (int pow1 = 0; pow1 <= pow; pow1++) {
			pows1[i] = pow1;
			for (int pow2 = 0; pow2+pow1 <= pow; pow2++) {
				pows2[i] = pow2;
				int pow3 = pow-pow1-pow2;
				pows3[i] = pow3;
				nestedFor(i+1);
			}
		}
	}
	
	private static BigDecimal biggest(int i) {
		BigDecimal a = BigDecimal.ONE;
		BigDecimal b = BigDecimal.ONE;
		BigDecimal c = BigDecimal.ONE;
		for (int j = 0; j < i; j++) {
			a = a.multiply(BigDecimal.valueOf(factors[j]).pow(pows1[j]));
			b = b.multiply(BigDecimal.valueOf(factors[j]).pow(pows2[j]));
			c = c.multiply(BigDecimal.valueOf(factors[j]).pow(pows3[j]));
		}
		return a.max(b).max(c);
	}

	static BigDecimal min = null;
	static BigDecimal minSum = null;
	
	private static void sjekkTall() {
		if(count++%10000000 == 0)
			System.out.println(count);
		
		BigDecimal number1 = toBigDecimal(pows1);
		BigDecimal number2 = toBigDecimal(pows2);
		BigDecimal number3 = toBigDecimal(pows3);
		
		BigDecimal[] numbers = {number1,number2,number3};
		Arrays.sort(numbers);
		BigDecimal a = numbers[0];
		BigDecimal b = numbers[1];
		BigDecimal c = numbers[2];
		
		BigDecimal divide = c.divide(a, 10, RoundingMode.HALF_UP);
		if (min == null) {
			min = divide;
		} else {
			if (divide.compareTo(min) <= 0) {
				min = divide;
				minSum = c.add(b).add(a);
				System.out.println("a: "+a);
				System.out.println("b: "+b);
				System.out.println("c: "+c);
				System.out.println(minSum);
			}
		}
	}

	private static BigDecimal toBigDecimal(int[] pow) {
		BigDecimal prod = BigDecimal.ONE;
		
		for (int i = 0; i < pow.length; i++) {
			prod = prod.multiply(BigDecimal.valueOf(factors[i]).pow(pow[i]));
		}
		
		return prod;
	}
}
