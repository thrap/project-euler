public class Problem136 {
	public static void main(String[] args) {
		System.out.println(solution());
		// for (long a = 1; a <= 400000; a++) {
		// if (a%1000 == 0)
		// System.out.println(a);
		// //(2*a+x)^2 - (a+x)^2 - x^2 < 1000000
		// for (long i = 2*a+1; true; i++) {
		// long x = i;
		// long y = i-a;
		// long z = y-a;
		// long n = x*x - y*y - z*z;
		// if (n<=0) {
		// break;
		// }
		// if (n>=limit)
		// continue;
		// if (n == 1155)
		// System.out.println(x + " " + y + " " +z);
		// array[(int)n]++;
		// }
		// }
		
	}

	public static int solution() {
		int limit = 50000000;
		int[] array = new int[limit + 1];

		for (long p = 2; p <= limit; p++) {
			long a = 4 - p % 4;
			long n = 0;
			for (long v = 0; v < (3 * p - a) / 4; v++) {
				n = p * (4 * v + a);
				if (n <= limit) {
					array[(int)n]++;
				} else {
					v = limit;
				}
			}
		}
		int teller = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == 1) {
//				System.out.println(i);
				++teller;
			}
		}
		return teller;
	}
}
