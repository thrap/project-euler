package Java;

import utils.Euler;

public class Problem343 {
	
	public static long f(long k) {
		long n = 1;
		long d = k;
		while (d != 1) {
			d--;
			n++;
			long gcd = Euler.gcd(d, n);
			
			d/=gcd;
			n/=gcd;
		}
		return n;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (long k = 100; k >= 1; --k) {
			System.out.println(k);
			sum+=f(k*k*k);
		}
		System.out.println(sum);
	}
}
