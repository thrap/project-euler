package problems;

import java.math.BigInteger;

import utils.Euler;

public class Problem130treg {
	public static BigInteger R(int k) {
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < k; i++) {
//			sb.append(1);
//		}
//		return new BigInteger(sb.toString());
		return BigInteger.valueOf(10).pow(k).divide(BigInteger.valueOf(9));
	}
	
	public static int A(int n) {
		for (int k = 2; true; k++) {
			if (R(k).mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO))
				return k;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(A(41));
		
		long sum = 0;
		int teller = 0;
		for (int i = 7; true; i+=2) {
			if (Euler.gcd(i, 10) == 1 && !Euler.isPrime(i) && (i-1)%A(i) == 0) {
				sum+=i;
				++teller;
				System.out.println(teller+": "+i + " "+Euler.primeFactorList(i));
				if (teller == 25)
					break;
			} 
		}
		System.out.println(sum);
	}
}
