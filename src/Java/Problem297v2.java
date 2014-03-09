package Java;

public class Problem297v2 {
	public static void main(String[] args) {
		
		/**
		 * mellom     1 og     8 er det   11
		 * mellom  13+1 og  13+8 er det 11+8-1 (fordi 21 er fib)
		 * mellom  21+1 og  21+8 er det 11+8
		 * mellom  34+1 og  34+8 er det 11+8
		 * mellom  55+1 og  55+8 er det 11+8
		 * mellom  89+1 og  89+8 er det 11+8
		 * mellom 144+1 og 144+8 er det 11+8
		 * 
		 * mellom     1 og     13 er det    21
		 * mellom  21+1 og  21+13 er det 13+21-1 (fordi 21 er fib)
		 * mellom  34+1 og  34+13 er det 13+21
		 * mellom  55+1 og  55+21 er det 13+21
		 * mellom  89+1 og  89+21 er det 13+21
		 * mellom 144+1 og 144+21 er det 13+21
		 * 
		 * mellom     1 og     21 er det    39
		 * mellom  34+1 og  34+21 er det 21+39-1 (fordi 55 er fib)
		 * mellom  55+1 og  55+21 er det 21+39
		 * mellom  89+1 og  89+21 er det 21+39
		 * mellom 144+1 og 144+21 er det 21+39
		 * 
		 * mellom fib(n+1) og fib(n+2) er det z(fib(n))-1+fib(n) stykk
		 */
		int n = 21;
		int n1= n+13;
		int n2 = n1+n;
		for (int i = 0; i < 5; i++) {
			System.out.println(z(n1));
			System.out.println(z(n+n1));
			System.out.println(z(n)+z(n1)+n-1);
			n=n1;
			n1=n2;
			n2=n1+n;
		}
	}
	
	private static class Z {
		long n;
		public Z(long n) {
			this.n = n;
		}
	}
	
	private static long z(int limit) {
		long teller = 0;
		for (long a = 1; a <= limit; a++) {
//			System.out.println(a);
			long i = a;
			for (int j = 0; true; j++) {
				long forrige = finn(i);
//				System.out.println(forrige);
				i-=forrige;
				if (forrige == 1 || i == 0) {
					teller+=j+1;
					break;
				}
			}
			
		}
		return teller;
	}

	public static long finn(long index) {
		if (index == 0)
			return 0;
		if (index == 1)
			return 1;
		long a = 0;
		long b = 1;
		long c = a+b;
		while (c < index) {
			a = b;
			b = c;
			c = a+b;
		}
		if (c == index)
			return c;
		return b;
	}
}
