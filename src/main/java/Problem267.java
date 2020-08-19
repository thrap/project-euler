import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem267 {
	public static void main(String[] args) {
		
		for (int i = -1; i <= 1; i++) {
			System.out.println(i);
			System.out.println(prob(0.15 + i*0.01));
		}
		System.out.println("0.abcdefghijkl");
	}
	
	static String prob(double fs) {
		BigDecimal f = BigDecimal.valueOf(fs);
		BigInteger result = BigInteger.ZERO;
		BigDecimal pow = valueOf(0.5).pow(1000);
		for (int wins = 0; wins <= 1000; wins++) {
			int losses = 1000-wins;
			
			if (ONE.add(BigDecimal.valueOf(2).multiply(f)).pow(wins).multiply(ONE.subtract(f).pow(losses)).compareTo(valueOf(1000000000)) >= 0) {
				result = result.add(choose(1000,wins));
			}
		}
		return new BigDecimal(result).multiply(pow).toPlainString().substring(0,"0.abcdefghijkl".length()+1);
	}

	static Map<Integer, BigInteger> chooseMemo = new HashMap<Integer, BigInteger>();

	private static BigInteger choose(int n, int k) {
		if (chooseMemo.containsKey(k))
			return chooseMemo.get(k);
		BigInteger divide = fac(n).divide(fac(n-k).multiply(fac(k)));
		chooseMemo.put(k, divide);
		return divide;
	}

	static Map<Integer, BigInteger> facMemo = new HashMap<Integer, BigInteger>();
	
	private static BigInteger fac(int i) {
		if (facMemo.containsKey(i))
			return facMemo.get(i);
		
		BigInteger result = BigInteger.valueOf(1);
		for (int j = 2; j <= i; j++) {
			result = result.multiply(BigInteger.valueOf(j));
		}
		
		facMemo.put(i, result);
		return result;
	}
}
