package problems;

import java.util.List;

import utils.Euler;
import utils.T;

public class Problem437Faster {
	public static void main(String[] args) {
		T t = new T();
		long sum = 0;
		int count = 0;
		List<Integer> primes = Euler.primeList(100000);
		System.out.println(primes.size());
//		Collections.reverse(primes);
		for (int p : primes) {
			if (!(p % 10 == 9 || p % 10 == 1))
				continue;
				
			for (long g = 2; g <= p/2; g++) {
				if ((g*(g-1))%p == 1) {
					System.out.println(p + " [" + g + ", "+(p+1-g) + "] " + t);
					System.out.println((g*(g-1)-1)/p);
					
					count++;
					sum+=p;
					break;
				}
			}

			
		}
		System.out.println(count  + " " + sum + " " + t);
	}
}
