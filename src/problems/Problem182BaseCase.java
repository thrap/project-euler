package problems;

import java.math.BigInteger;

public class Problem182BaseCase {
	public static void main(String[] args) {
		int p = 19;
		int q = 37;
		int n = p*q;
		int phi = (p-1)*(q-1);
		
		int e = 181;
		
		for (int m = 0; m <= n-1; m++) {
			if (BigInteger.valueOf(m).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).intValue() == m) {
				System.out.println(m);
			}
		}
	}
}
