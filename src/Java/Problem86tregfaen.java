package Java;

import utils.Euler;

public class Problem86tregfaen {
	public static void main(String[] args) {
		
		int goal = 1000000;
		int lower = 1000;
		int upper = 2000;
		
		int temp = 0;
		while (true) {
			int teller = 0;
			int limit = (upper+lower)/2;
			if (limit == temp) 
				System.exit(0);
			temp = limit;
			System.out.print(limit + ": ");
			for (long x = 1; x <= limit; x++) {
				for (long y = x; y <= limit; y++) {
					for (long z = y; z <= limit; z++) {
						long minste = z*z+(y+x)*(y+x);;
						if (Euler.isPerfectSquare(minste))
							++teller;
					}
				}
			}
			System.out.println(teller);
			if (teller > goal)
				upper = limit;
			else if (teller < goal)
				lower = limit;
		}
	}
}
