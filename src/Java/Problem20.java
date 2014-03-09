package Java;

import java.math.BigInteger;

public class Problem20 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		BigInteger tallet = BigInteger.ONE;
		for (int i = 2; i <= 100; i++) {
			tallet = tallet.multiply(BigInteger.valueOf(i));
		}
		String tall = tallet.toString();
		int sum = 0;
		for (int i = 0; i < tall.length(); i++) {
			sum+=tall.charAt(i)-'0';
		}
		return sum;
	}
}
