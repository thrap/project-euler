import java.math.BigInteger;
import java.util.List;

import utils.Euler;

public class Problem347 {
	
	static int[] count;
	
	public static int count(long tall, long n) {
		int count = 1;
		long tallet = tall;
		while (tallet<n) {
			tallet*=tall;
			++count;
		}
		return count;
	}
	
	public static long M(int p, int q, int n) {
		if (p*q > n)
			return 0;
		
		int ilimit = count[p];
		int jlimit = count[q];
//		int ilimit = count(p,n);
//		int jlimit = count(q,n);
		
		long beste = 0;
		for (int i = 1; i <= ilimit; i++) {
			for (int j = 1; j <= jlimit; j++) {
				BigInteger test = BigInteger.valueOf(p).pow(i).multiply(BigInteger.valueOf(q).pow(j));
//				long test = (long) (Math.pow(p, i)*Math.pow(q, j));
				if (test.compareTo(BigInteger.valueOf(n)) <= 0 && test.compareTo(BigInteger.valueOf(beste))==1)
					beste = test.intValue();
			}
		}
		return beste;
	}
	
	public static long S(int n) {
		List<Integer> primes = Euler.primeList(n);
		count = new int[n];
		for (Integer integer : primes) {
			count[integer] = count(integer,n);
//			if (integer*integer > n)
//				break;
		}
		
		long sum = 0;
		
		for (int i = 0; i < primes.size(); ++i) {
			int p = primes.get(i);
//			System.out.println(p*p);
			if (p*p > n)
				break;
			for (int j = i+1; j < primes.size(); j++) {
				int q = primes.get(j);
				if (q*p > n)
					break;
				sum+=M(p,q,n);
			}
		}
//		for (int p = 2; p*p <= n; ++p) {
//			if (Euler.isPrime(p))
//			for (int q = p+1; p*q <= n; ++q) {
//				if (Euler.isPrime(q))
//				sum += M(p, q, n);
//			}
//		}
		return sum;
	}
	public static void main(String[] args) {
//		System.out.println(M(2,3,100));
//		System.out.println(M(3,5,100));
//		System.out.println(M(2,73,100));
		System.out.println(solution());
	}

	public static long solution() {
		return S(10000000);
	}
}
