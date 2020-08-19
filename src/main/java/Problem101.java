import java.math.BigInteger;

import utils.T;

public class Problem101 {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() + " " + t);
	}
	
	public static long solution() {
		long sum = 1;
		for (int n = 1; n < 10; n++) {
//			System.out.println(Arrays.toString(OP(n)));
//			System.out.println(BOP(OP(n)));
			sum+=BOP(OP(n));
		}
		return sum;
	}

	public static long BOP(long[] OP) {
		long bop = 1;
		for (int i = 1; true; i++) {
			bop = f(i, OP);
//			System.out.println(bop);
			if (bop != f(i))
				break;
		}
		return bop;
	}
	
	public static long f(int x, long[] OP) {
		long sum = 0;
		for (int i = 0; i < OP.length; i++) {
			sum+=pow(x,OP.length-i-1)*OP[i];
		}
		return sum;
	}

	private static long[] OP(int n) {
		BigInteger[] result = new BigInteger[n+1];
		for (int i = 0; i < result.length; i++) {
			result[i] = BigInteger.ZERO;
		}
		
		BigInteger under = BigInteger.valueOf(lkk(0,n));
		for (int i = 0; i <= n; i++) {
			under=under.multiply(BigInteger.valueOf(lkk(i, n)));
		}
		
		for (int i = 0; i <= n; i++) {
			add(result, divide(multiply(multiply(lk(i,n), f(i+1)),under), lkk(i,n)));
		}
		
		result = divide(result, under);
		
		long[] longResult = new long[n+1];
		for (int i = 0; i < longResult.length; i++) {
			longResult[i] = result[i].longValue();
		}
		
		return longResult;
	}
	
	private static BigInteger[] divide(BigInteger[] multiply, long lkk) {
		return divide(multiply, BigInteger.valueOf(lkk));
	}
	
	private static BigInteger[] divide(BigInteger[] multiply, BigInteger lkk) {
		for (int i = 0; i < multiply.length; i++) {
			multiply[i] = multiply[i].divide(lkk);
		}
		return multiply;
	}

	private static void add(BigInteger[] result, BigInteger[] b) {
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i].add(b[i]);
		}
	}
	
	public static BigInteger[] multiply(BigInteger[] lk, long f) {
		return multiply(lk, BigInteger.valueOf(f));
	}

	private static BigInteger[] multiply(BigInteger[] lk, BigInteger f) {
		for (int i = 0; i < lk.length; i++) {
			lk[i] = lk[i].multiply(f);
		}
		return lk;
	}

	//1  n + n2  n3 + n4  n5 + n6  n7 + n8  n9 + n10
	public static long f(long n) {
		long sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum+=(i%2==0?1:-1)*pow(n,i);
		}
		return sum;
		
//		return pow(n, 3);
	}
	
	public static long pow(long n, int p) {
		return (long)Math.pow(n, p);
	}
	
	public static BigInteger[] lk(int k, int n) {
		k++;
		BigInteger[] res = null;
		for (int i = 1; i <= n+1; i++) {
			if (i != k)
				res = asd(res, 1, -i);
		}
		return res;
	}
	
	public static long lkk(long k, long n) {
		k++;
		long sum = 1;
		for (int i = 1; i <= n+1; i++) {
			if (i != k)
				sum*=(k-i);
		}
		return sum;
	}
	
	public static BigInteger[] asd(BigInteger[] a, int b02, int b12) {
		BigInteger b0 = BigInteger.valueOf(b02);
		BigInteger b1 = BigInteger.valueOf(b12);
		if (a == null)
			return new BigInteger[]{b0,b1};
		
		BigInteger[] c = new BigInteger[a.length+1];
		for (int i = 0; i < c.length; i++) {
			c[i] = BigInteger.ZERO;
		}
		
		for (int i = 0; i <= a.length; i++) {
			if (i < a.length)
				c[i] = c[i].add(a[i].multiply(b0));
			if (i > 0)
				c[i] = c[i].add(a[i-1].multiply(b1));
		}
		return c;
	}
}
