import java.math.BigInteger;

public class Problem56 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int max = 0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigInteger big = BigInteger.valueOf(a).pow(b);
				max = Math.max(max, digitalSum(big));
			}
		}
		return max;
	}

	private static int digitalSum(BigInteger big) {
		String tall = big.toString();
		int sum = 0;
		for (int i = 0; i < tall.length(); i++) {
			sum+=tall.charAt(i)-'0';
		}
		return sum;
	}
}
