import utils.Euler;
import utils.T;

public class Problem443 {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(f((long)Math.pow(10, 15)) + " " + t);
	}
	
	private static long f(long n) {
		long g = 13;
		long i = 5;
		
		while (i <= n) {
			long gcd = Euler.gcd(i, g);
			if (gcd != 1 && Euler.isPrime(2*i-1) && i != 6) {
				if (2*i-1 > n) {
					return g+gcd+(n-i);
				}
				g = g+gcd+i-2;
				i = 2*i-1;
			} else {
				g += gcd;
				i++;
			}
		}
		return i;
	}
}
