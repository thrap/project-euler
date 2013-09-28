package problems;

import java.util.List;

import utils.Euler;

public class Problem123 {
	public static void main(String[] args) {
		System.out.println(solution());

	}
	
	public static int solution() {
		List<Integer> list = Euler.primeList(1000000);
		
//		System.out.println(pows(list.get(3),3));
		for (int n = 1; n < list.size(); n++) {
			if (pows(list.get(n),n)>10000000000L) {
				return n+2;
			}
		}
		return 0;
	}

	public static long pows(long a, long n) {
		long sum1 = 1;
		long sum2 = 1;
		for (int i = 0; i<n; ++i) {
			sum1*=(a-1);
			sum1%=(a*a);

			sum2*=(a+1);
			sum2%=(a*a);
		}
		return (sum1+sum2)%(a*a);
	}
}
