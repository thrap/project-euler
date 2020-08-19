import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem157Test2 {
	public static void main(String[] args) {
		/**
		 * TODO: finne smarte grenser saa har du den jeg sverger kompis
		 */
		
		//p = 2^n*5^n(a+b)/(b*a)
		/**
		 * 5001*(1+2^3*5^4)/5001^2
		 * 
		 * (1+2^4*5^6)/4717
		 * 
		 * (2^4+5^5)/3141
		 */
		int count = 0;
		int N = 3;
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 1; i <= 1000000; i+=2) {
			if (i % 5 == 0)
				continue;
			
			for (int a2s = 0; a2s <= N+1; a2s++) {
				for (int a5s = 0; a5s <= N+1; a5s++) {
					long a = (long) (i*Math.pow(2, a2s)*Math.pow(5, a5s));
					for (int b2s = 0; b2s <= N+1; b2s++) {
						for (int b5s = 0; b5s <= N+1; b5s++) {
							long b = (long) (i*Math.pow(2, b2s)*Math.pow(5, b5s));
							if (a > b || b == Long.MAX_VALUE)
								continue;
							
							
							for (int n = 1; n <= N; n++) {
								if (((long)Math.pow(10, n)*(a+b)) % (a*b) == 0) {
									count++;
									if (!set.contains(i)) {
										set.add(i);
										System.out.println(i);
										System.out.println(a + " " + b + " ("+count+")");
										System.out.println(set.size());
										System.out.println(Euler.primeFactorList(i));
										System.out.println(i + " "+ (i-1)/2 + " " + Euler.primeFactorList(i-1));
										System.out.println(a2s + " " + a5s + ", "+b2s + " "+b5s);
										System.out.println();
										System.out.println(set);
									}
								} 
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}

	private static int max(int... ints) {
		int max = Integer.MIN_VALUE;
		for (int i : ints) {
			max = Math.max(max, i);
		}
		return max;
	}
}
