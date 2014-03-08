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
		return x*x*x == sum;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static int solution() {

//		fact1: p^2 er en faktor
//		fact2: n+p = x^(3*y)
//		fact3: n+p m kunne deles paa x^3
//		fact4: n = z^3
//		fact5: z^3 + p = x^3

		int limit = 1000000;
		List<Integer> list = Euler.primeList(limit);
		int teller = 0;
		for (int i = 0; i < list.size(); ++i) {
			int p = list.get(i);
			for (int n = 1; true; ++n) {
				long sum = n*n*n + p;
				
				if (isDone(sum,n))
					break;
				if (isCube(sum,n)) {
					++teller;
					break;
				}
			}
		}
		
		return teller;
	}
}
