package problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem240basecase {
	
	private static final int SUM = 15;
	private static final int MAX = 6;
	
	public static void main(String[] args) {
		long sum = 0;
		for (int a = 1; a <= MAX; a++) {
			for (int b = a; b <= MAX; b++) {
				for (int c = b; c <= MAX; c++) {
					if (check(a,b,c)) {
						sum+=permute(a,b,c);
					}
				}
			}
		}
		System.out.println(sum);
	}
	
	private static long permute(int x, int y, int z) {
		long sum = 0;
		for (int a = 1; a <= x; a++) {
			for (int b = a; b <= x; b++) {
				sum += permutations(a, b, x, y, z);
			}
		}
		return sum;
	}

	private static long permutations(int...is) {
		int[] count = new int[MAX+1];
		for (int i : is) {
			++count[i];
		}
		System.out.println(Arrays.toString(is));
		BigInteger over = BigInteger.ONE;
		for (int i = 2; i <= 5; i++) {
			over = over.multiply(BigInteger.valueOf(i));
		}
		BigInteger under = BigInteger.ONE;
		for (int i : count) {
			if (i >= 2)
				under = under.multiply(factorial(i));
		}
		return over.divide(under).longValue();
	}

	static Map<Integer, BigInteger> FACTORIAL = new HashMap<Integer, BigInteger>();
	
	private static BigInteger factorial(int i) {
		if (FACTORIAL.containsKey(i))
			return FACTORIAL.get(i);
		BigInteger a = BigInteger.ONE;
		for (int j = 2; j <= i; j++) {
			a = a.multiply(BigInteger.valueOf(j));
		}
		FACTORIAL.put(i, a);
		return a;
	}

	private static boolean check(int... is) {
		long sum = 0;
		for (int i : is) {
			sum+=i;
		}

		return sum == SUM;
	}
}
