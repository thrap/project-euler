package problems;

import utils.Euler;

public class Problem421 {
	public static void main(String[] args) {
		// x^15 = (1+x) (1-x+x^2) (1-x+x^2-x^3+x^4) (1+x-x^3-x^4-x^5+x^7+x^8)
		// se på faktorer og blæst denna hæhæ
		
		long n = 15;
		long f1 = n+1;
		long f2 = n*n-n+1;
		long f3 = pow(n,4)-pow(n,3)+pow(n,2)-n+1;
		long f4 = pow(n,8)+pow(n,7)-pow(n,5)-pow(n,4)-pow(n,3)+n+1;
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(Euler.primeFactorList(f1));
		System.out.println(Euler.primeFactorList(f2));
		System.out.println(Euler.primeFactorList(f3));
		System.out.println(Euler.primeFactorList(f4));
	}

	private static long pow(long n, int i) {
		return (long)Math.pow(n, i);
	}
}
