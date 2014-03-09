package Java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem53 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	
	public static int solution() {
//		int n = 23;
//		int r = 10;
		
		int teller=0;
		
		for (int n = 0; n <= 100; n++) {
			for (int r = 0; r <= 100; r++) {
//				System.out.println((fakultet(n).divide(fakultet(r).multiply(fakultet(n-r))).toString()));
				if ((fakultet(n).divide(fakultet(r).multiply(fakultet(n-r))).toString()).length() > 6)
					teller++;
			}
		}
		return teller;
//		Long.
	}
	
	static Map<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();

	public static BigInteger fakultet(int j) {
		if (memo.containsKey(j))
			return memo.get(j);
		BigInteger sum = BigInteger.ONE;
		for (int i = 1; i <= j; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		memo.put(j, sum);
		return sum;
	}
}
