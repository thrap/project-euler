package problems;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class Problem221 {
	public static void main(String[] args) {
		//A = (p*q*r)/(p*q+p*r+q*r) 
		//A = p*q*r
		
		//dette gir
		//p*q+p*r+q*r = 1
		
		//som gir
		//r = (1-p*q)/(p+q)
		//(1-p*q) % (p+q) = 0
		//
		
		int limit = 156000;
//		Set<Integer> set = new TreeSet<Integer>();
//		for (int p = -limit; p <= limit; p++) {
//			for (int q = -limit; q <= limit; q++) {
//				if (p == -q)
//					continue;
//				if ((1-p*q) % (p+q) == 0) { 
//					int r = (1-p*q) / (p+q);
//					int A = p*q*r;
//					set.add(Math.abs(A));
//					if (Math.abs(A) < 130) {
//						System.out.println(A + " " + Euler.primeFactorList(A));
//						System.out.println("A="+A+", r="+r+", p="+p+", q="+q);
//					}
////					System.out.println(A);
//					if (set.size() % 10 == 0)
//						System.out.println(set.size());
//				}
//			}
//		}
		Set<BigInteger> set2 = new TreeSet<BigInteger>();
		for (long p = 0; p <= limit; p++) {
			if (p % 1000 == 0) {
				System.out.println(p);
				int count = 0;
				for (BigInteger A : set2) {
					count++;
					if (count == 150000) {
						System.out.println(A);
						break;
					}
				}				
			}
			for (long q = -p; q < 0; q++) {
				if (p == -q)
					continue;
				if ((1-p*q) % (p+q) == 0) { 
					long r = (1-p*q) / (p+q);
					BigInteger A = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q)).multiply(BigInteger.valueOf(r)).abs();
					set2.add(A);
				}
			}
		}
//		System.out.println(set.size());
		System.out.println(set2.size());
		int count = 0;
		for (BigInteger A : set2) {
			count++;
			if (count == 6) {
				System.out.println(A);
			} else if (count == 1000) {
				System.out.println(A + " skal vaere 772168278");
			} else if (count == 150000) {
				System.out.println(A);
			}
		}
	}
}
