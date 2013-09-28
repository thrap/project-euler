package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem137 {
	
	private static final double PHI = 0.5*(1+Math.sqrt(5));
	public static void main(String[] args) {
		//phi*|x| < 1
		//a/b < 1/phi
		//a < b/phi
		//(a*b)/(b^2-a*b-a^2)
		//FIB TALL? WTFFFFFFFF
		int count = 0;
		Set<Long> set = new HashSet<Long>();
		for (int i = 1; i < 100; i++) {
			long b = fib(i);
			for (long a = 1; a < b/PHI; a++) {
				long sum = sum(a, b);
				if (sum != 0 && !set.contains(sum)) {
					count++;
					set.add(sum);
					System.out.println(a + " " + b);
					System.out.println(sum);
					if (count == 15) 
						System.exit(0);
				}
			}
		}
	}
	
	
	public static Map<Integer, Long> memoize = new HashMap<Integer, Long>();
	
	public static long fib(int i) {
		if (memoize.containsKey(i)) return memoize.get(i);
		if (i <= 1) return 1;
		else {
			long memo = fib(i-1)+fib(i-2);
			memoize.put(i, memo);
			return memo;
		}
	}

	public static long sum(long a, long b) {
		if ((a*b)%(b*b-a*b-a*a) == 0)  {
			return (a*b)/(b*b-a*b-a*a);
		} else {
			return 0;
		}
	}
}
