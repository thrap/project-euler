package problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		Set<BigInteger> set = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++) {
			BigInteger ab = BigInteger.valueOf(a);
			for (int b = 2; b <= 100; b++) {
				set.add(ab.pow(b));
			}
		}
		return set.size();
	}
}
