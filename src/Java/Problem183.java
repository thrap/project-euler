package Java;

import java.math.BigInteger;

public class Problem183 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		long sum2 = 0;
		for (int N = 5; N <= 10000; N++) {
//			sum+=D(N);
			if (M2(N))
				sum2-=N;
			else
				sum2+=N;
			if (N == 10000)
			return sum2;
		}
		return 0;
	}

	public static long D(int N) {
		Rational mn = M(N);
		if (terminating(mn.d)) {
			System.out.println(mn);
			return -N;
		}
		else
			return N;
	}
	
	public static boolean M2(int N) {
		R2 a = new R2(N,1);
		for (int i = 2; i < N; i++) {
			R2 b = new R2(N,i);
//			if ( < 0) {
//				a = b;
//			} else if (r.compareTo(t) < 0) {
//				System.out.println("FEIL OMG");
//				System.exit(0);
//			}
			if (a.compareTo(b) < 0) {
				a = b;
			}
			else {
				break;
			}
		}
		a.simplify();
		return terminating(a.d);
	}
	
	public static boolean terminating(long n) {
		while (n%2==0) {
			n/=2;
		}
		while (n%5==0) {
			n/=5;
		}
		return n == 1;
	}
	
	public static boolean terminating(BigInteger n) {
		while (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			n = n.divide(BigInteger.valueOf(2));
		}
		while (n.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO)) {
			n = n.divide(BigInteger.valueOf(5));
		}
		return n.equals(BigInteger.ONE);
	}
	
	
	public static class R2 implements Comparable<R2>{
		int N;
		int d;
		int pow;
		public R2(int n, int D) {
			N = n;
			d = D;
		}
		
		public void simplify() {
			long t = gcd();
		    N /= t;
		    d /= t;
		
		    if (d < 0) {
		        N *= -1;
		        d *= -1;
		    }
		}
		
		public boolean isLessThan(R2 r) {
		    return (N*r.d < d*r.N);
		}
		
		private long gcd() {
		    long a = N;
		    if (a < 0) {
		        a *= -1;
		    }
		    long b = d;
		    if (b < 0) {
		        b *= -1;
		    }
		    while (b != 0) {
		        long temp = b;
		        b = a%b;
		        a = temp;
		    }
		    return a;
		}
		
		public Double value() {
			return (double)d*(Math.log((double)N)-Math.log((double)d));
		}
		
		public int compareTo(R2 b) {
			return value().compareTo(b.value());
		}
	}
	/**
	 * BOTTLENECK
	 * BOTTLENECK
	 * BOTTLENECK
	 * BOTTLENECK
	 * BOTTLENECK
	 * BOTTLENECK
	 * BOTTLENECK
	 */
	public static Rational M(int N) {
		Rational r = new Rational(BigInteger.valueOf(N),BigInteger.ONE);
		R2 a = new R2(N,1);
		for (int i = 2; i < N; i++) {
			Rational t = new Rational(BigInteger.valueOf(N).pow(i),BigInteger.valueOf(i).pow(i));
			R2 b = new R2(N,i);
//			if ( < 0) {
//				a = b;
//			} else if (r.compareTo(t) < 0) {
//				System.out.println("FEIL OMG");
//				System.exit(0);
//			}
			if (a.compareTo(b) < 0) {
				a = b;
				r = t;
			}
			else
				return r;
		}
		return r;
	}
	
	public static class Rational implements Comparable<Rational>{
		BigInteger n;
		BigInteger d;
		public Rational(BigInteger n, BigInteger d) {
			this.n = n;
			this.d = d;
			simplify();
		}
		
		public Rational add(Rational rational2) {
	        BigInteger newNumerator = this.n.multiply(rational2.d).add(this.d.multiply(rational2.n));
	        BigInteger newDenominator = this.d.multiply(rational2.d);
	        Rational newRational = new Rational(newNumerator, newDenominator);
	        return newRational;
		}
		
		public void simplify() {
			BigInteger t = gcd();
		    n = n.divide(t);
		    d = d.divide(t);
		
		    if (d.compareTo(BigInteger.ZERO) < 0) {
		        n = n.multiply(BigInteger.valueOf(-1));
		        d = d.multiply(BigInteger.valueOf(-1));
		    }
		}
		
		public int compareTo(Rational r) {
		    return (n.multiply(r.d).compareTo(d.multiply(r.n)));
		}
		
		private BigInteger gcd() {
		    BigInteger a = n;
		    if (a.compareTo(BigInteger.ZERO) < 0) {
		        a = a.multiply(BigInteger.valueOf(-1));
		    }
		    BigInteger b = d;
		    if (b.compareTo(BigInteger.ZERO) < 0) {
		    	b = b.multiply(BigInteger.valueOf(-1));
		    }
		    while (!b.equals(BigInteger.ZERO)) {
		        BigInteger temp = b;
		        b = a.mod(b);
		        a = temp;
		    }
		    return a;
		}
		
		public String toString() {
			return ""+n+"/"+d;
		}
	}
}


