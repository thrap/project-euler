import utils.Rational;

public class Problem72tregsomfaen {
	private static int teller = 0;
	
	public static void main(String[] args) {
		Rational r = new Rational(1, 8);

		// for (int i = 1; i < 840; i++) {
		// r = new Rational(i,840);
		// if (r.d <= 8) {
		// System.out.print(r + ", ");
		// }
		// }


		// System.out.println(neste(4,7));
//		neste(8, 8);
		
		long NUMERATOR = 8;
		long DENOMINATOR = 8;
		
//		while (true) {
//			teller++;
//			final int MAX_D = 100;
//			
//			long m, n;
//			long bestm = 0, bestn = 1;
//			
//			for (n = 1; n <= MAX_D; n++) {
//				m = (n * NUMERATOR - 1) / DENOMINATOR;
//				if (m * bestn > n * bestm) {
//					bestm = m;
//					bestn = n;
//				}
//			}
////			System.out.println(bestm + "/" + bestn + ", ");
//			if (bestm == 1 && bestn == MAX_D) {
//				break;
//			}
//			NUMERATOR = bestm;
//			DENOMINATOR = bestn;
//		}
//		System.out.println(teller);
		
//		int max = 8;
//		int a = 0, b = 1, c = 3, d = 7;
//		while (b + d <= max) {
//			a+=c; 
//			b+=d;
//			int gcd = gcd(a,b);
//			a/=gcd;
//			b/=gcd;
//		}
//		System.out.println(a+"/"+b);
		long teller = 0;
		int max = 1000000;
		for (int d = max; d >= 2; d--) {
//			if (d != max && d%2 == 0)
//				continue;
			for (int n = d; n >= 1; n--) {
				if (gcd(n,d) == 1)
					teller++;
			}
			if (d % 100 == 0)
				System.out.println(d);
		}
			System.out.println(teller);
	}
	public static int gcd(int a, int b){
		int c;
		while (b>0){
			c = b;
			b = a%b; 
			a = c;
		}
		return a;
	}
	
	public static void neste (final long NUMERATOR, final long DENOMINATOR) {
		teller++;
		final int MAX_D = 100;
		
		long m, n;
		long bestm = 0, bestn = 1;
		
		for (n = 1; n <= MAX_D; n++) {
			m = (n * NUMERATOR - 1) / DENOMINATOR;
			if (m * bestn > n * bestm) {
				bestm = m;
				bestn = n;
			}
		}
		System.out.println(bestm + "/" + bestn + ", ");
		if (bestm == 1 && bestn == MAX_D) {
			return;
		}
		else 
			neste(bestm, bestn);
	}

}
