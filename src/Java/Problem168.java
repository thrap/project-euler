package Java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Problem168 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Set<BigInteger> repdigits = getRepDigits();
		Set<BigInteger> cycles = getCycles(repdigits);
		
		Set<BigInteger> rotatingNumbers = new HashSet<BigInteger>();
		rotatingNumbers.addAll(repdigits);
		rotatingNumbers.addAll(cycles);
		
		System.out.println(repdigits.size() + " repdigits");
		System.out.println(cycles.size() + " cycles");
		System.out.println(rotatingNumbers.size());
		
		long ans = 0;
		for (BigInteger cycle : rotatingNumbers) {
			if (cycle.compareTo(BigInteger.TEN) == 1 && cycle.compareTo(BigInteger.TEN.pow(100)) == -1)
				ans += cycle.mod(BigInteger.valueOf(1000000)).longValue();
		}
		
		System.out.println(ans%100000 + " ("+(System.currentTimeMillis()-start) + " ms)");
	}
	
	private static Set<BigInteger> getCycles(Set<BigInteger> repdigits) {
		
		Set<BigInteger> list = getBaesj(repdigits);
		
		Set<BigInteger> temp = new HashSet<BigInteger>();
		for (BigInteger asd : list) {
			if (asd.compareTo(BigInteger.TEN) == 1 && asd.compareTo(BigInteger.TEN.pow(100)) == -1 && !repdigits.contains(asd)) {
				temp.add(asd);
			}
		}
		return temp;
	}
	
	private static Set<BigInteger> getBaesj(Set<BigInteger> repdigits) {
		Set<BigInteger> cycles = new HashSet<BigInteger>();
		for (int denominator = 2; denominator < 100; denominator++) {
			for (int numerator = 1; numerator < denominator; numerator++) {
				BigDecimal dec = BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator), 200, RoundingMode.HALF_UP);
				String repeat = dec.toString().substring(1);
				
				while ((repeat = repeat.substring(1)).charAt(0) == '0');
				
				for (int i = 2; i <= 100; i++) {
					BigInteger cycle = new BigInteger(repeat.substring(0, i));
					if (!repdigits.contains(cycle) && !cycles.contains(cycle) && isCyclic(cycle) ) {
						cycles.add(cycle);
						System.out.println(denominator + " " + cycle);
					}
				}
			}
		}
		return cycles;
	}

	private static Set<BigInteger> getRepDigits() {
		Set<BigInteger> temp = new HashSet<BigInteger>();
		for (int n = 1; n < 1000; n++) {
			BigInteger repunit = BigInteger.TEN.pow(n).subtract(BigInteger.ONE).divide(BigInteger.valueOf(9));
			if (repunit.toString().length() >= 200)
				break;
			
			for (int a = 1; a <= 9; a++) {
				if (repunit.compareTo(BigInteger.TEN) == 1 && repunit.compareTo(BigInteger.TEN.pow(100)) == -1)
					temp.add(repunit.multiply(BigInteger.valueOf(a)));
			}
		}
		return temp;
	}

	private static boolean isCyclic(BigInteger number) {
		if (number.mod(BigInteger.TEN).intValue() == 0)
			return false;
		if (rotation(number).mod(number).equals(BigInteger.ZERO)) {
			return true;
		}
		return false;
	}

	public static BigInteger rotation(BigInteger b) {
		String a = b.toString();
		return new BigInteger(a.charAt(a.length()-1)+a.substring(0,a.length()-1));
	}
}
