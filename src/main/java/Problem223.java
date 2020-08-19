import java.util.HashMap;
import java.util.Map;

import utils.Euler;

public class Problem223 {
	public static void main(String[] args) {
		//a = 1 gir
		//b^2 + 1 = c^2 + 1
		//b = c
		int limit = 25000000;
		long count = 0;
		//100000 444833
		Map<Long, Long> sqrts = new HashMap<Long, Long>();
		for (long i = 0; i*i < limit; i++) {
			sqrts.put(i*i, i);
		}
		
		for (long b = 1; b < limit; b++) {
			if (b%1000 == 0)
				System.out.println(b + " " + count);
			for (long a = 1; a < b; a++) {
				if (Euler.isPerfectSquare(a*a+b*b-1)) {
					long c = (long) Math.sqrt(a*a+b*b-1);
					if (a+b+c <= limit) {
						count++; 
					} else {
						break;
					}
//					if (c != b)
//						System.out.println(a + " " + b + " " + c);
				}
			}
		}
		System.out.println(count);
	}
}
