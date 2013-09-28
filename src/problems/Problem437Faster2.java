package problems;

import java.util.List;

import utils.Euler;
import utils.T;

public class Problem437Faster2 {
	public static void main(String[] args) {
		T t = new T();
		long sum = 0;
		int count = 0;
		List<Integer> primes = Euler.primeList(100000);
		
		for (long x = 5; x <= 10000000; x+=2) {
			if ((x*x - 5)%(4) != 0) {
				System.out.println(x);
				break;
			}
			
			long g = (x+1)/2;
			count++;
			List<Integer> list = Euler.primeFactorList((x*x-5)/4);
			
			int p = list.get(list.size()-1);
			if (p < x)
				continue;
			if (p < 1000) {
				System.out.println(p + " " + x);
			}
			
		}

		System.out.println("4777 226602777 (864 ms)");
	}
}
