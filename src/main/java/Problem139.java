import utils.Euler;


public class Problem139 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int limit = 100000000;
		int teller = 0;
		for (int m = 1; true; m++) {
//			System.out.println(m);
//			System.out.println(a + " " +b+ " " + c);
			for (int n = 1; n < m; n++) {
				if (Euler.gcd(n, m) != 1 || n%2 == m%2) {
					continue;
				}
				long a = m*m-n*n;
				long b = 2*m*n;
				long c = m*m+n*n;
				if (b < a) {
					long temp = a;
					a = b;
					b = temp;
				}
				
				long square = c*c;
				long hole = square-2*a*b;
				if (square % hole == 0 && a+b+c < limit) {
//					System.out.println(a + " " +b+ " " + c);
					for (int i = 1; i*a+i*b+i*c < limit; ++i) {
//						if (i%100 == 0)
//							System.out.println();
//						if (a>b)
//							set.add(i*b+" "+i*a+" "+i*c);
//						else
//							set.add(i*a+" "+i*b+" "+i*c);
						++teller;
					}
				}
			}
			if (2*m*m+2*m > limit)
				break;
		}
//		System.out.println(teller);
		return teller;
	}
}
