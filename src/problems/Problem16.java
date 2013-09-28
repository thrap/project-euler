package problems;

import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		String tall = BigInteger.valueOf(2).pow(1000).toString();
		int sum = 0;
		for (int i = 0; i < tall.length(); i++) {
			sum+=tall.charAt(i)-'0';
		}
		return sum;
	}
}
