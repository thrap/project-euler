import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

import utils.T;

public class Problem365v2 {
	public static void main(String[] args) {
		T t = new T();
		int[] primes = Problem365.getPrimes();
		
		long n = (long)Math.pow(10,18);
		long m = (long)Math.pow(10, 9);
		
		long[] sum = new long[5000];
		for (int i = 0; i < primes.length; i++) {
			int p = primes[i];
			sum[p] = binomialSmall(n, m, p);
		}
		
		BigInteger result = ZERO;
		for (int i = 0; i < primes.length; i++) {
			long p = primes[i];
			System.out.println(i + " / " + primes.length);
			for (int j = i+1; j < primes.length; j++) {
				long q = primes[j];
				for (int k = j+1; k < primes.length; k++) {
					long r = primes[k];

					long m1 = p;
					long m2 = q;
					long m3 = r;

					long a1 = sum[(int) m1];
					long a2 = sum[(int) m2];
					long a3 = sum[(int) m3];
					
					long M1 = m2*m3;
					long M2 = m1*m3;
					long M3 = m1*m2;
					
					long s1 = extendedGCD(M1,m1).a;
					long s2 = extendedGCD(M2,m2).a;
					long s3 = extendedGCD(M3,m3).a;
					
					long res = (a1*s1*M1 + a2*s2*M2 + a3*s3*M3) % (m1*m2*m3);
					if (res < 0) 
						res += m1*m2*m3;
					result = result.add(valueOf(res));
				}
			}
		}
		System.out.println(result + " " + t);
	}
	
	private static class Point{
		long a, b;
		public Point(long a, long b) {
			this.a = a;
			this.b = b;
		}
		
		public String toString() {
			return "("+a+","+b+")";
		}
	}
	
	private static Point extendedGCD(long a, long b) {
		if (b == 0)
			return new Point(1,0);
		else {
			long q = a/b;
			long r = a - b*q;
			Point gcd = extendedGCD(b,r);
			long s = gcd.a;
			long t = gcd.b;
			
			return new Point(t, s-q*t);
		}
	}
	
	private static long binomialSmall(long n, long m, long p) {
		if (n < p && m < p) {
			return binomial(n,m).mod(valueOf(p)).longValue();
		}
		return (binomialSmall(n/p, m/p,p) * binomialSmall(n-(n/p)*p,m - (m/p)*p,p)) % p;
	}

	static BigInteger binomial(long n, long k) {
//		System.out.println(n+"C"+k);
		if (n < k)
			return ZERO;
		return BinomialCoefficient(valueOf(n), valueOf(k));
	}
	
	static BigInteger BinomialCoefficient(BigInteger n, BigInteger k) {
	    if (k.compareTo(n.subtract(k)) == 1) 
	    	k = n.subtract(k);
	    BigInteger asd = n.subtract(k);
	    BigInteger result = ONE;
	    long longK = k.longValue();
	    for (long i = 1; i <= longK; ++i) {
	    	if (i % 1000000 == 0) {
	    		System.out.println(i/1000000 + " / 1000");
	    	}
	    	BigInteger a = valueOf(i);
	        result = result.multiply(asd.add(a));
	        result = result.divide(a);
	    }
	    return result;
	}
}
