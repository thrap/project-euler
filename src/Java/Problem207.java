package Java;

public class Problem207 {
	public static void main(String[] args) {
		// pisserns theorem: dette stemmer kun for 4^t = 2^t + k => k = 2^t*(2^t-1)

		// Pisserns bevis av pisserns theorem
		// 4^t = 2^t + 2^t*(2^t-1)
		// 4^t = 2^t + 2^t*2^t-2^t
		// 4^t = 2^(2*t)
		// 4^t = 4^t

		// pisserns theorem 2: 4^t = 2^t + k => k = x^2-x

		long start = System.currentTimeMillis();
		System.out.println(solution() +  " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long solution() {

		long m = 0;
		long neste = neste(m);
		for (long x = 2; true; x++) {
			long k = x*x - x;
			
			if (k == neste) {
				neste = neste(++m);
//				System.out.println(m+"/"+(x-1) + " " + k);
			}
			
			if (m*12345 < x-1) {
				return k;
			}
		}
	}

	public static long neste(long t) {
		t++;
		long twoPow = (long) Math.pow(2, t);
		return twoPow * (twoPow - 1);
	}
}