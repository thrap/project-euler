package Java;

import java.math.BigInteger;

public class Problem48 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		BigInteger mod = BigInteger.TEN.pow(10);
		long sum = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger n = BigInteger.valueOf(i);
			sum+=n.modPow(n, mod).longValue();
			sum%=mod.longValue();
		}
		return sum;
	}
}
