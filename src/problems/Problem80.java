package problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utils.Euler;

public class Problem80 {
	private static final int DIGITS = 100;
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += Euler.isPerfectSquare(i)?0:(digitRootSum(i));
		}
		
		return sum;
	}

	private static int digitRootSum(int i) {
		int sum = 0;
		String root = root(i);
		for (int j = 0; j <= DIGITS; j++) 
			sum+=root.charAt(j) == '.'? 0 : root.charAt(j)-'0';
		return sum;
	}

	public static String root(int t) {
		BigDecimal xn1 = new BigDecimal(Math.sqrt(t)), xn = BigDecimal.ZERO;
		while (!isDone(xn1.toString(), xn.toString())) {
			xn = xn1;
			xn1 = BigDecimal.valueOf(0.5).multiply(xn.add((BigDecimal.valueOf(t).divide(xn, DIGITS, RoundingMode.HALF_UP))));
		}
		return xn1.toString();
	}

	private static boolean isDone(String a, String b) {
		return a.length() >= DIGITS && b.length() >= DIGITS && b.substring(0,DIGITS).equals(a.substring(0,DIGITS));
	}
}
