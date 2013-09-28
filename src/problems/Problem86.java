package problems;

import utils.Euler;

public class Problem86 {
	public static void main(String[] args) {
		
		int mål = 1000000;
		int lav = 1000;
		int hoy = 2000;
		
		int temp = 0;
		while (true) {
			int teller = 0;
			int limit = (hoy+lav)/2;
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
			if (teller > mål)
				hoy = limit;
			else if (teller < mål)
				lav = limit;
		}
	}
}
