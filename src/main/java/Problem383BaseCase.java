import utils.T;


public class Problem383BaseCase {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(T((long)Math.pow(10, 9)) + " "+t);
		System.out.println(2408210);
	}

	private static long T(long n) {
		long count = 0;
		for (long i = 5; i <= n; i+=5) {
			if (i % 10000000 == 0)
				System.out.println(i);
			if (f(2*i-1) < 2*f(i)) {
				count++;
			}
		}
		return count;
	}
	
	private static long pows(long n, long p) {
		long amount = 0;
		long pow = p;
		while (pow <= n) {
			amount+=n/pow;
			pow*=p;
		}
		return amount;
	}

	private static long f(long i) {
		return pows(i, 5);
	}
}
