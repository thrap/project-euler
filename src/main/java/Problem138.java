public class Problem138 {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println(solution() + " " + (System.currentTimeMillis() - start));
	}

	public static long solution() {
		long nesteN = 1;
		int teller = 0;
		long sum = 0;
		
		ytterste: for (long m = 1; true; m++) {
			// System.out.println(m);
			// System.out.println(a + " " +b+ " " + c);
			long n = nesteN;
			// if (Euler.gcd(n, m) != 1 || n%2 == m%2) {
			// continue;
			// }
			long a = 2 * m * n;
			long b = m * m - n * n;
			long c = m * m + n * n;

			if (Math.abs(2 * a - b) == 1) {
				++teller;
				// System.out.println(a*2 + " " + c);
//				System.out.println(a + " " + b + " " + c + ": " + m + " " + n);
				nesteN = m;
				m *= 4.22;
				sum += c;
				if (teller == 12)
					break ytterste;
			}

			// if (2*m*m+2*m > limit)
			// break;
		}
		return sum;
	}
}
