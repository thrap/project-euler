package problems;

import java.math.BigInteger;

public class Problem15 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		int k = 20;
		int n = 2*k;
		BigInteger over = BigInteger.ONE;
		BigInteger under = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			BigInteger bigI = BigInteger.valueOf(i);
			over = over.multiply(bigI);
			if (i<=k)
				under = under.multiply(bigI);
		}
		
		return over.divide(under.pow(2)).longValue();
	}
}
