import java.math.BigInteger;
import java.util.List;

import utils.Euler;

public class Problem381ForTreg {
	static int LIMIT = 10;
	static List<Integer> primes = Euler.primeList(LIMIT+10);
	
	public static void main(String[] args) {
		System.out.println(primes.size());
		
		/////TEESSSSSSSSSSST
		System.out.println(S(7));
		
		int sum = 0;
		
		for (int prime : primes) {
			if (prime > LIMIT) {
				break;
			} else if (prime < 5) {
				continue;
			}
			System.out.println(prime);
			sum+=S(prime);
		}
		System.out.println(sum);
	}
	
	
	public static long S(int prime) {
		long sum = 0;
		for (int k = 1; k <= 5; k++) {
			sum += mod(prime, prime-k);
			sum%=prime;
		}
		return sum%prime;
	}

	private static long pows(int n, int p) {
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
	
	private static long mod(int p, int pk) {
		long sum = 1;
		for (Integer prime : primes) {
			long exp = pows(pk, prime);
			if (prime > p) break;
			if (exp == 0)
				break;
			sum *= modPow(prime, exp, p); 
			sum%=p;
		}
		return sum%p;
	}


	private static long modPow(Integer prime, long exp, int p) {
		return BigInteger.valueOf(prime).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(p)).longValue();
	}
}
