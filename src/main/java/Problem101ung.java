import java.util.Arrays;

public class Problem101ung {
	public static void main(String[] args) {
		int n = 2;
		long[] result = new long[n+1];
		
		long under = lkk(0,n);
		for (int i = 0; i <= n; i++) {
			under=under*lkk(i, n);
		}
		System.out.println(under);
		
		for (int i = 0; i <= n; i++) {
			add(result, divide(multiply(multiply(lk(i,n), f(i+1)),under), lkk(i,n)));
			System.out.println("(?/"+lkk(i,n)+")*"+f(i+1));
		}
		
		System.out.println(Arrays.toString(divide(result, under)));
		
	}
	
	private static long[] divide(long[] multiply, long lkk) {
		for (int i = 0; i < multiply.length; i++) {
			multiply[i]/=lkk;
		}
		return multiply;
	}

	private static void add(long[] result, long[] b) {
		for (int i = 0; i < result.length; i++) {
			result[i] += b[i];
		}
	}

	private static long[] multiply(long[] lk, long f) {
		for (int i = 0; i < lk.length; i++) {
			lk[i]*=f;
		}
		return lk;
	}

	//1  n + n2  n3 + n4  n5 + n6  n7 + n8  n9 + n10
	public static long f(long n) {
		long sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum+=(i%2==0?1:-1)*pow(n,i);
		}
//		return sum;
		
		return pow(n, 3);
	}
	
	public static long pow(long n, int p) {
		return (long)Math.pow(n, p);
	}
	
	public static long[] lk(int k, int n) {
		k++;
		long[] res = null;
		for (int i = 1; i <= n+1; i++) {
			if (i != k)
				res = multiply(res, 1, -i);
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
	
	public static long[] multiply(long[] xpows, int x, int a) {
		if (xpows == null)
			return new long[]{x,a};
		
		long[] c = new long[xpows.length+1];
		
		for (int i = 0; i <= xpows.length; i++) {
			if (i < xpows.length)
				c[i] += xpows[i]*x;
			if (i > 0)
				c[i] += xpows[i-1]*a;
		}
		return c;
	}
}
