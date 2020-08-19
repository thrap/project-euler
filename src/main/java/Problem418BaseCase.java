import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Euler;

public class Problem418BaseCase {
	
	static int factorial = 20;
	static Map<Integer, Integer> factors = factorialPrimeFactors(factorial);
	static int[] factorz = new int[factors.size()];
	
	static {
		int i = 0;
		for (int factor : factors.keySet()) {
			factorz[i++] = factor;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f(165));
		
		System.out.println(factorialPrimeFactors(factorial));
		System.out.println(factorialFactorString(factorial));
		
		//TODO dele ut faktorer til a b c og se hvilke som gir minst c/a
		
		reccursion(0);
		
		System.out.println(count);
	}
	
	static Map<Integer, Integer> factors1 = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> factors2 = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> factors3 = new HashMap<Integer, Integer>();

	static int count = 0;
	
	static BigDecimal min = null;
	static BigDecimal minSum = null;
	private static void reccursion(int i) {
		if (i == factorz.length) {
			sjekkTall();
			return;
		}
		int factor = factorz[i];
		int pow = factors.get(factor);
		for (int pow1 = 0; pow1 <= pow; pow1++) {
			for (int pow2 = 0; pow1+pow2 <= pow; pow2++) {
				/**
				 * denne funker ikke :(
				 */
				int pow3 = pow-pow1-pow2;

				factors1.put(factor, pow1);
				factors2.put(factor, pow2);
				factors3.put(factor, pow3);
				
				reccursion(i+1);
			}
		}
	}




	private static void sjekkTall() {
		if(count++%10000000 == 0)
			System.out.println(count);
		
		BigDecimal number1 = mapToBigDecimal(factors1);
		BigDecimal number2 = mapToBigDecimal(factors2);
		BigDecimal number3 = mapToBigDecimal(factors3);
		
		BigDecimal[] numbers = {number1,number2,number3};
		Arrays.sort(numbers);
		BigDecimal a = numbers[0];
		BigDecimal b = numbers[1];
		BigDecimal c = numbers[2];
		
		BigDecimal divide = c.divide(a, 10, RoundingMode.HALF_UP);
		if (min == null) {
			min = divide;
		} else {
			if (divide.compareTo(min) < 0) {
				min = divide;
				minSum = c.add(b).add(a);
				System.out.println("a: "+a);
				System.out.println("b: "+b);
				System.out.println("c: "+c);
				System.out.println(minSum);
			}
		}
	}
	



	private static BigDecimal mapToBigDecimal(Map<Integer, Integer> factorMap) {
		BigDecimal n = BigDecimal.ONE;
		
		for (int factor: factorMap.keySet()) {
			n = n.multiply(BigDecimal.valueOf(factor).pow(factorMap.get(factor)));
		}
		
		return n;
	}




	private static String factorialFactorString(int factorial) {
		Map<Integer, Integer> map = factorialPrimeFactors(factorial);
		String res = "";
		for (int prime : Euler.primeList(factorial)) {
			res += prime+(map.get(prime) == 1?"":"^"+map.get(prime))+" * ";
		}
		return res.substring(0,res.length()-2);
	}



	public static Map<Integer, Integer> factorialPrimeFactors(int i) {
		int[] numbers = new int[i-1];
		for (int j = 2; j <= i; j++) {
			numbers[j-2] = j;
		}
		return Euler.primeFactorMap(numbers);
	}



	private static int f(int n) {
		List<Integer> factors = Euler.primeFactorList(n);
		
		System.out.println(factors);
		return 0;
	}
	
	
}
