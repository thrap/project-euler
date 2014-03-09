package Java;

import java.util.ArrayList;
import java.util.List;

public class Problem297v3 {
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
		long start = System.currentTimeMillis();
		Zeck n = new Zeck(0);
//		System.out.println(n);
		Zeck n1 = new Zeck(1);
		Zeck n2 = new Zeck(n, n1);
		List<Zeck> zecks = new ArrayList<Zeck>();
		long limit = (long)Math.pow(10, 17);
		while (n2.fib <= limit) {
			zecks.add(n1);
//			System.out.println(n2);
			n  = n1;
			n1 = n2;
			n2 = new Zeck(n, n1);
		}
		int added = 0;
		while(true) {
			for (int i = zecks.size()-1; i >= 0; i--) {
				Zeck denne = zecks.get(i);
				if (n1.fib+denne.fib < limit) {
					added++;
//					System.out.println(denne);
					n1.add(denne, added);
//					System.out.println(n1);
					break;
				}
			}
			if (n1.fib == limit-1)
				break;
		}
		System.out.println(n1.z + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	private static class Zeck {
		long fib;
		long z;
		public Zeck(long n) {
			this.fib = n;
			z = z(n);
			if (n==0)
				z=1;
		}
		public Zeck(Zeck n, Zeck n1) {
			fib = n.fib+n1.fib;
			z = n.z+n1.z+n.fib-1;
		}
		
		/**
		 * feil her
		 */
		public void add(Zeck n, int added) {
			this.fib += n.fib;
			this.z += n.z+n.fib*added;
		}
		
		public String toString() {
			return ""+fib+": "+z;
		}
	}
	
	private static long z(long limit) {
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
