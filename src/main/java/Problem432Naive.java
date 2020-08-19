import utils.Euler;
import utils.T;

public class Problem432Naive {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(S(510510,(int)1e6) + " " + t);
	}

	private static long S(long n, int m) {
		long sum = 0;
		for (int i = 1; i <= m; i++) {
			sum += Euler.phi(n*i);
		}
		return sum;
	}
}
