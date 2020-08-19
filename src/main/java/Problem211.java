import utils.Euler;

public class Problem211 {
	
	public static long o2(int n) {
		long sum = 0;
		for (long divisor : Euler.divisorList(n)) {
			sum+=divisor*divisor;
		}
		return sum;
	}
	
	//prime^2+1 != perfect square
	static boolean[] prime;
	static int limit = 64000000;
	public static void main(String[] args) {
		prime = Euler.primeArray(limit);
		long start = System.currentTimeMillis();
		long sum = 0;
		for (int n = limit; n >= 2; --n) {
			if (n%100000 == 0)
				System.out.println(n);
			if (!prime[n] && Euler.isPerfectSquare(o2(n))) {
				sum+=n;
				System.out.println(n);
			}
		}	
		System.out.println(sum);
		System.out.println(System.currentTimeMillis()-start);
	}
}
