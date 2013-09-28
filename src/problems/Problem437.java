package problems;

import utils.Euler;
import utils.T;

public class Problem437 {
	public static void main(String[] args) {
		T t = new T();
		long sum = 0;
		int count = 0;
		
		/**
		 * det finnes kun 0,1 eller 2 g'er
		 * finner andre g ved Œ ta g2 = p + 1 - g1
		 */
		int twos = 0;
		for (int p : Euler.primeList(100000)) {
			if (!(p % 10 == 9 || p % 10 == 1))
				continue;
				
			int localCount = 0;
			long[] gs = new long[2];
			for (long g = 2; g < p; g++) {
				if ((g*(g-1))%p == 1) {
					gs[localCount] = g;
					localCount++;
				}
			}
			
			if(localCount > 2) {
				System.out.println("FUCK");
				System.exit(0);
			}
			if (localCount >= 1) {
				System.out.println(p + " " + (localCount==2?gs[0] + " "+gs[1] : gs[0]));
				count++;
				if (localCount == 2)
					twos++;
				sum+=p;
			}
		}
		System.out.println(count  + " " + sum + " " + t);
		System.out.println("Twos: "+twos);
	}
}
