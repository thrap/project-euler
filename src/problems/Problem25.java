package problems;

import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		BigInteger goal = BigInteger.TEN.pow(999);
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		for (int i = 2; true; i++) {
			c = a.add(b);
			if (c.compareTo(goal) >= 0)
				return i;
			a = b;
			b = c;
		}
	}
}
