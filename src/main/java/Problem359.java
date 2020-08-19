import java.math.BigInteger;

import utils.T;

public class Problem359 {
	public static void main(String[] args) {
		// 71328803586048 = 2^27*3^12
		
		T t = new T();
		BigInteger sum = BigInteger.ZERO;
		for (int a = 0; a <= 27; a++) {
			for (int b = 0; b <= 12; b++) {
				long f = (long)Math.pow(2, a)*(long)Math.pow(3, b);
				long r = (long)Math.pow(2, 27-a)*(long)Math.pow(3, 12-b);
				sum = sum.add(P(f,r));
			}
		}
		System.out.println(sum.mod(BigInteger.TEN.pow(8)) + " " + t);
	}
	
	static BigInteger TWO = BigInteger.valueOf(2);
	
	private static BigInteger P(long f, long r) {
		if (f == 1) {
			return BigInteger.ONE.add(P(f+1,r-1));
		}
		if (r == 2) {
			return ((f+r)%2 == 1 ? P(f, r-1).add(BigInteger.ONE) : P(f, r+1).subtract(TWO));
		}
		if (r == 1) {
			BigInteger N = BigInteger.valueOf(f/2);
			return (f % 2 == 0 ? TWO.multiply(N.pow(2)) : TWO.multiply(N).multiply(N.add(BigInteger.ONE)));
		}
		long k = (r-1)/2;
		return P(f + 2*k, r-2*k).add(BigInteger.valueOf(((f+r)%2 == 1 ? k : -k)));
	}
}
