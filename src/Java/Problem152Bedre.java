package Java;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import utils.Euler;

public class Problem152Bedre {
	static int antall = 40;
	static BigInteger nevner = getFellesnevner(antall);
	static BigInteger[] fraction = new BigInteger[antall+1];
	static BigInteger[] leftSum = new BigInteger[antall+1];
	static BigInteger goal = nevner.divide(BigInteger.valueOf(2));
	
	static {
		for (int i = 2; i <= antall; i++) {
			fraction[i] = nevner.divide(BigInteger.valueOf(i*i));
			System.out.println(new DecimalFormat("00").format(i) + " "+nevner.divide(BigInteger.valueOf(i*i)));
		}
		
		for (int i = 2; i <= antall; i++) {
			BigInteger sum = BigInteger.ZERO;
			for (int j = i; j <= antall; j++) {
				sum = sum.add(fraction[j]);
			}
			leftSum[i] = sum;
			System.out.println(i + " " +sum);
		}
		System.out.println(goal);
	}
	
	/**
	 * Tanke: har fellesnevner
	 * Maal: finne kombinasjoner av valg av tall som gir fellesnevner/2 som sum
	 * 
	 * Utfoerelse: dritt
	 */
	public static void main(String[] args) {
		reccursion(2, goal, "2");
	}
	static int count = 0;
	
	/**
	 * FUCK FAENS BIGINTEGER
	 */
	public static void reccursion(int i, BigInteger missing, String tall) {
		if (missing.compareTo(BigInteger.ZERO) == 0) {
			System.out.println("OMFG " +tall);
			return;
		}
		if (++count % 1000000 == 0)
			System.out.println(tall);
		if (i > antall) {
			return;
		} else if (missing.subtract(leftSum[i]).compareTo(BigInteger.ZERO) >= 0)
			return;
		else if (missing.compareTo(BigInteger.ZERO) < 0)
			return;
		reccursion(i+1, missing, tall);
		reccursion(i+1, missing.subtract(fraction[i]), tall + " "+(i+1));
	}
	
	public static BigInteger getFellesnevner(int n) {
		Map<Integer, Integer> fellesnevner = new HashMap<Integer, Integer>();
		for (int i = 2; i <= n; i++) {
			for (Map.Entry<Integer, Integer> factor : Euler.primeFactorMap(i*i).entrySet()) {
				if (fellesnevner.containsKey(factor.getKey())) {
					fellesnevner.put(factor.getKey(), Math.max(factor.getValue(), fellesnevner.get(factor.getKey())));
				} else {
					fellesnevner.put(factor.getKey(), factor.getValue());
				}
			}
		}
		
		BigInteger f = BigInteger.ONE;
		for (Map.Entry<Integer, Integer> entry: fellesnevner.entrySet()) {
			//overflow bsj
			f = f.multiply(BigInteger.valueOf(entry.getKey()).pow(entry.getValue()));
		}
		System.out.println(f);
		System.out.println(fellesnevner);
		
		return f;
	}
}
