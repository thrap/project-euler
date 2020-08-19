import utils.Euler;
import utils.T;

public class Problem432Observation {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(Euler.primeListBetween((long)1e11, (long)(1e11+5e7)).size() + " " +t);
	}

	/**
	 * Using the fact that 
	 * 
	 * phi(m*i) = phi(m)*phi(i)*gcd(m,i)/phi(gcd(m,i))
	 * 
	 * 
	 * 
	 * Euler.phi(i) is the bottleneck of this function
	 * 
	 * might be able to generate all factors of the numbers in the limit range through 
	 * the same procedure as primeListBetween and use the factors to compute phi using
	 * 
	 * phi(p1^k1*...*pn^kn) = n*((1-1/p1)*...*(1-1/pn))
	 */
	private static long S(long n, int m) {
		long sum = 0;
		long phi = Euler.phi(n);
		System.out.println(phi);
		for (long i = 1; i <= m; i++) {
			long d = Euler.gcd(n, i);
			sum += (phi*Euler.phi(i)*d)/Euler.phi(d);
		}
		return sum;
	}
}
