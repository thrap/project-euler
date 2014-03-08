package problems;

import java.io.IOException;
import java.util.Random;

import utils.Euler;
import utils.T;

public class Problem282 {
	
	public static final int MOD = (int)Math.pow(14, 8);
	public static void main(String[] args) throws IOException {
		/**
		 * naar n > 24 blir alltid(?) hyper(a, n, MOD) lik 407921152
		 * 
		 * er ganske sikker paa at hyper-dritten min er feil lizm
		 */
		
		T t = new T();
		
		long sum = 0;
		for (int n = 0; n <= 5; n++) {
			System.out.println("A("+n+","+n+")" + " = "+A(n,n));
			
			sum += A(n,n);
		}
		System.out.println((sum + A(5,5))%MOD);
	}
	/*
		c[b_, k_, 1] := 0
		c[b_, k_, n_] := PowerMod[b,c[b, k - 1, EulerPhi[n]], n]
		c[1777, 1855, 10^8]
	 */
	
	
	public static long hyper(long a, long n, long m) {
		if (n==1)
			return a%m;
		if (m == 1)
			return 0;
		return Euler.modPow(a, hyper(a, n-1, Euler.phi(m)), m);
	}
	
	public static long A(long m, long n) {
		if (m == 3) {
			return Euler.modPow(2, n+3, MOD)-3;
		} 
		if (m == 4) {
			return hyper(2, n+3, MOD)-3;
		} 
		
		if (m==0)
			return n+1;
		if (n==0)
			return A(m-1, 1);
		else {
			long res = A(m-1, A(m, n-1));
			return res;
		}
	}
}
