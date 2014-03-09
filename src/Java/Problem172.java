package Java;

import java.math.BigInteger;

public class Problem172 {
	static long sum = 0;
	static int length = 18;
	static int digits = 3;
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		int[] tall = new int[10];
		for (int i = 9; i >= 0; --i) {
			tall[i]++;
			permute(""+i, i, tall.clone());
			tall[i]--;
		}
		return sum;
	}

	public static long fac(int tiles, int[] count) {
		BigInteger sum = BigInteger.valueOf(1);
		for (int i = 1; i <= tiles; ++i) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		BigInteger sum2 = BigInteger.valueOf(1);
		
		for (int i = 0; i < count.length; i++) {
			for (int j = 1; j <= count[i]; j++) {
				sum2 = sum2.multiply(BigInteger.valueOf(j));
			}
		}
		return sum.divide(sum2).longValue();
	}
	
	public static long permutations(String tall) {
		long sum = 0;
		for (int j = 1; j < 10; j++) {
			if (tall.contains(""+j)) {
				int[] count = new int[10];
				for (int i = 0; i < tall.length(); i++) {
					count[tall.charAt(i)-'0']++;
				}
				count[j]--;
				sum += fac(length-1,count);
			}
		}
		
		return sum;
	}
	
	public static void permute(String tallet, int forrige,int[] tall) {
		if (tallet.length() == length) {
			sum+=permutations(tallet);
			return;
		}
		for (int i = forrige; i >= 0; --i) {
			tall[i]++;
			if (tall[i] <= digits)
				permute(tallet+i, i, tall.clone());
			tall[i]--;
		}
	}
}
