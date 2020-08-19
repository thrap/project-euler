import java.util.List;

import utils.Euler;
import utils.T;

public class Problem159 {
	static int[] mdrs = new int[1000000];
	static boolean[] prime = Euler.primeArray(1000000);
	
	public static int mdrs(int n) {
		if (prime[n])
			return digital(n);
		else {
			List<Integer> divisors = Euler.divisorList(n);
			int max = digital(n);
			for (int i = 1; i < divisors.size(); i++) {
				int divisor = divisors.get(i);
				max = Math.max(mdrs[divisor]+mdrs[n/divisor], max);
			}
			return max;
		}
	}

	public static int digital(int n) {
		int sum = 0;
		while(n != 0) {
			sum+=n%10;
			n/=10;
		}
		if (sum >= 10)
			return digital(sum);
		return sum;
	}
	
	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() +" "+ t);
	}

	public static long solution() {
		int sum = 0;
		for (int i = 2; i < 1000000; i++) {
			mdrs[i] = mdrs(i);
			sum+=mdrs[i];
		}
		return sum;
	}
}
