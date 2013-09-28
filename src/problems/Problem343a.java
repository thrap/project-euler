package problems;

public class Problem343a {
	
	public static long f(long k) {
		long n = 1;
		long d = k;
		while (d != 1) {
			d--;
			n++;
			if (d%n == 0){
				System.out.println(n + " " + k);
				d = d/n;
				n = 1;
			}
		}
		return n;
	}
	/**
	 * ser ut som GCD ikke er vits, om gcd != 1 er d%n==0
	 */
	public static void main(String[] args) {
		long sum = 0;
		for (long k = 100; k >= 1; --k) {
			System.out.println(k);
			sum+=f(k*k*k);
		}
		System.out.println(sum);
	}
}
