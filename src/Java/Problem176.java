package Java;

import utils.Euler;

public class Problem176 {
	public static void main(String[] args) {
		int limit = 221764;
		int[] triangles = new int[limit];
		for (long m = 1; m < limit; m++) {
			if (m % 1000 == 0)
				System.out.println(m);
			for (int n = 1; n < m; n++) {
//				if (Euler.gcd(m, n) != 1)
//					continue;
				long a = m*m-n*n;
				long b = 2*m*n;
				long c = m*m+n*n;
				if (a > b) {
					long temp = b;
					b = a;
					a = temp;
				}
				
				if (a > limit) {
					continue;
				}
				
				if (isPrimitive(a, b, c)) {
					for (long i = 1; i*a < triangles.length; i++) {
						triangles[(int)(i*a)]++;
					}
					for (long i = 1; i*b < triangles.length; i++) {
						triangles[(int) (i*b)]++;
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < triangles.length; i++) {
			if (triangles[i] >= max) {
				max = triangles[i];
				System.out.println(i + ": " + triangles[i] + " " + Euler.primeFactorList(i) + " " + Euler.divisorAmount(i));
			}
		}
		System.out.println(triangles[12]);
		System.out.println(triangles[221760]);
	}
	
	private static boolean isPrimitive(long a, long b, long c) {
		return Euler.gcd(a, b) == 1 && Euler.gcd(b, c) == 1;
	}
}
