import java.math.BigInteger;

import utils.Euler;

public class Problem133 {
	public static long bedreA(long n) {
		int teller = 0;
		long sum= 0;
		for (int p : Euler.primeList(1000000)) {
			if (!divides(n,p)) {
//				System.out.println(++teller + " " +p);
				if (p > 100000)
					break;
				sum += p;
			}
		}
//		System.out.println(sum);
		return sum;
	}
	
	public static boolean divides(long n, int p) {
		return BigInteger.valueOf(10).modPow(BigInteger.valueOf(n), BigInteger.valueOf(p)).intValue() == 1 && p%3 != 0;
	}
	
	public static void main(String[] args) {
//		bedreA(1000000000000000000L);
		System.out.println(solution());
	}

	public static long solution() {
		return bedreA(1000000000000000000L);
	}
}
