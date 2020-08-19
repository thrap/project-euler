import utils.Euler;
import utils.T;

public class Problem439 {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(S2(1000) + " " + t);
	}

	private static long S2(int N) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			long temp = d(i);
			for (int j = 1; j <= N; j++) {
				if (Euler.gcd(i, j) == 1) {
					sum+=d(j)*temp;
				} else {
					sum+=d(i*j);
				}
			}
		}
		return sum;
	}
	
	private static long d(int k) {
		long sum = 0;
		for (int div : Euler.divisorList(k)) {
			sum += div;
		}
		return sum;
	}

	private static long S(int N) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int div : Euler.divisorList(i*j)) {
					sum += div;
				}
			}
		}
		return sum;
	}
}
