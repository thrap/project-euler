package Java;

import java.math.BigInteger;

import utils.Euler;
import utils.T;

import static java.math.BigInteger.*;


public class Problem429 {
	
	private static final int PRIMES_BELOW_LIMIT = 5761455;
	private static final int n = 100000000;

	public static void main(String[] args) {
		T t = new T();
		int[] pows = fillPowArray();

		BigInteger mod = valueOf(1000000009);
		BigInteger temp = ZERO;
		BigInteger ans = ONE;
		for (int i = pows.length-2; i >= 0; i-=2) {
			if (i%100000 == 0) 
				System.out.println(i);
			int prime = pows[i];
			int pow = pows[i+1];
			temp = valueOf(prime).modPow(valueOf(pow*2), mod).multiply(ans).mod(mod);
			ans = ans.add(temp).mod(mod);
		}
		System.out.println(ans + " "+t);
		
		
	}
	
	private static int[] fillPowArray() {
		int[] pows = new int[PRIMES_BELOW_LIMIT*2];
		boolean[] prime = Euler.primeArray(n);
		int i = 0;
		for (int p = 2; p < prime.length; p++) {
			if (p % 10000 == 0)
				System.out.println(p);
			if (prime[p]) {
				pows[i++] = p; 
				pows[i++] = (int)pows(n,p);
			}
		}
		return pows;
	}
	
	private static long pows(int n, int p) {
		long amount = 0;
		long pow = p;
		while (pow <= n) {
			amount+=n/pow;
			pow*=p;
		}
		return amount;
	}
}
