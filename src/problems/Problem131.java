package problems;

import java.math.BigInteger;
import java.util.List;

import utils.Euler;

public class Problem131 {
	
	public static boolean isDone(BigInteger sum, BigInteger n) {
		n = n.add(BigInteger.ONE);
		return n.pow(3).compareTo(sum) == 1;
	}
	public static boolean isCube(BigInteger sum, BigInteger n) {
		BigInteger x;
		for (x = n.add(BigInteger.valueOf(1)); x.pow(3).compareTo(sum) == -1; x = x.add(BigInteger.valueOf(1)));
		return x.pow(3).equals(sum);
	}
	public static boolean isDone(long sum, long n) {
		++n;
		return n*n*n > sum;
	}
	public static boolean isCube(long sum, long n) {
		long x;
		for (x = n+1; x*x*x < sum; ++x);
//		if (x*x*x == sum)
//			System.out.print(x + " ");
		return x*x*x == sum;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static int solution() {

//		fact1: p^2 er en faktor
//		fact2: n+p = x^(3*y)
//		fact3: n+p må kunne deles på x^3
//		fact4: n = z^3
//		fact5: z^3 + p = x^3

		int limit = 1000000;
		List<Integer> list = Euler.primeList(limit);
//		Set<Long> set = new HashSet<Long>();
//		for (long i = 1; i <= limit*100; i++) {
//			set.add(i*i*i);
//		}
//		System.out.println(set);
		int teller = 0;
		for (int i = 0; i < list.size(); ++i) {
			int p = list.get(i);
//			boolean funnet = false;
			for (int n = 1; true; ++n) {
//				BigInteger N = BigInteger.valueOf(n);
//				N = N.pow(3);
//				BigInteger SUM = N.add(BigInteger.valueOf(p));
				
				long sum = n*n*n + p;
				
				if (isDone(sum,n))
					break;
//				if (isDone(SUM,BigInteger.valueOf(n)))
//					break;
				
//				if (isCube(SUM,BigInteger.valueOf(n))) {
				if (isCube(sum,n)) {
//					System.out.println(p);
					++teller;
					break;
				}
//				for (int x = 2; x*x*x <= sum; x++) {
//					if (x*x*x == sum) {
//						
//						System.out.println(p);
//						++teller;
//					}
//				}
//				for (long x = 2; x*x*x <= sum; x++) {
//					if (sum%(x*x*x)==0 || sum-(x*x*x) == 0) {
//						System.out.println(n+"+"+p+ " / " + x*x*x + " = " + sum/(x*x*x));
//						++teller;
//						funnet = true;
//					}
//				}
//				
//				if (funnet)
//					break;
//				if (n+p ikke er delelig på noe^3)
//					continue;
//				if (noe^3 > n+p)
//					break;
//				
//				if (sum<0) {
////					System.out.println(sum);
//					break;
//				}
//				if (set.contains(sum)) {
//					System.out.println(n + "^3 + "+p+"*"+ n+"^2" + " = " + sum);
//					++teller;
//				}
			}
//			break;
		}
		
//		System.out.println(teller);
		return teller;
	}
}
