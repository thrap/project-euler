import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem146 {
	static List<Integer> primelist = Euler.bedrePrimeList(150002000);
	public static boolean isPrime(long number) {
		double sqrt = Math.sqrt(number);
		for (int a = 0; a < primelist.size(); ++a) {
			int i = primelist.get(a);
			if (i > sqrt) {
				return true;
			}
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		/**
		for 20 mill:
		28669650
		[10, 315410, 927070, 2525870, 8146100, 16755190, 39313460]
		 */
		
		long sum = 0;
		List<Long> list = new ArrayList<Long>();
		int tre = 0;
		int syv = 0;
		int elve = 0;
		
		ytterste:
		for (long n = 0; n < 150000000; n+=10) {
			if ((n*n)%3 != 1) {
				++tre;
				continue;
			} 
			
			for (Integer prime : primelist) {
				long prod = n*n;
				if (prime>n)
					break;
				if ((prod+1)%prime == 0) 
					continue ytterste;
				if ((prod+3)%prime == 0) 
					continue ytterste;
				if ((prod+7)%prime == 0) 
					continue ytterste;
				if ((prod+9)%prime == 0) 
					continue ytterste;
				if ((prod+13)%prime == 0) 
					continue ytterste;
				if ((prod+27)%prime == 0) 
					continue ytterste;
			}
			for (int i = 27; i >= 1; i-=2) {
				if (i != 1 && i != 3 && i != 7 && i != 9 && i != 13 && i != 27) {
					if (isPrime(n*n+i))
						continue ytterste;
				}
			}
			list.add(n);
			sum+=n;
		}
		return sum;
	}
}
