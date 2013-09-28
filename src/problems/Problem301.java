package problems;

import utils.Euler;

public class Problem301 {
	public static void main(String[] args) {
//		int count = 0;
//		for (long n = 1; n <= Math.pow(2, 4); n++) {
//			long a = n ^ (2*n) ^ (3*n);
//			if (a == 0) {
//				System.out.println(n);
//				count++;
//			}
//				
//			if (n % 1000000 == 0)
//				System.out.println(n);
//		}
//		System.out.println(count);
		
		System.out.println(Euler.fib(30+2));
	}
}
