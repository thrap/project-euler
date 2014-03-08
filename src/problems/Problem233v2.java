package problems;

import java.util.Arrays;


public class Problem233v2 {
	public static void main(String[] args) {
		/**
		 * er en sirkel paa formen (x-N/2)^2+(y-N/2)^2 = N^2/2
		 * 
		 * x^2+y^2 = N(x+y)
		 * 
		 * N = (x^2+y^2)/(x+y)
		 * 
		 * kan bruke supertrikset til pythagoras
		 */
		
		for (long x = 0; x <= 10000; x++) {
			for (long y = x+1; y <= 20000; y++) {
				if ((x*x+y*y)%(x+y) == 0 && (x*x+y*y)/(x+y) == 10000)
					System.out.println(x + " " + y);
			}
		}
	}
}
