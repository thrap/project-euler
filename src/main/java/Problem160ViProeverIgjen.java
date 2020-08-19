import java.math.BigInteger;

public class Problem160ViProeverIgjen {
	public static void main(String[] args) {
		BigInteger fact = BigInteger.ONE;
		BigInteger mod = BigInteger.TEN.pow(18);
		for (long j = 2; j <= 100000000L; j++) {
			if (j % 5 == 0) {
				long number = j;
				while(number % 10 == 0) {
					number/=10;
				}
				while(number % 5 == 0 && number >= 0) {
					number/=5;
					fact = fact.divide(BigInteger.valueOf(2));
				}
				if (number != 0) {
					fact = fact.multiply(BigInteger.valueOf(number));
				}
			} else {
				fact = fact.multiply(BigInteger.valueOf(j));
			}
			fact = fact.mod(mod);
			if (j%1000000 == 0)
				System.out.println(j + " " + fact + " " + (double)j/1000000000000.0);
		}
		System.out.println(fact);
	}
	
	private static long pows(long n, int p) {
		long amount = 0;
		/**
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 * flaskehals
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		long pow = p;
		while (pow <= n) {
			amount+=n/pow;
			pow*=p;
		}
		return amount;
	}
}
