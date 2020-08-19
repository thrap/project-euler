import utils.T;


public class Problem255BaseCase {
	static long digits = 5;
	public static void main(String[] args) {
		/**
		 * maa se paa sammenheng mellom iterasjon og tall
		 */
		T t = new T();
		long count = 0;
		for (long i = (long) Math.pow(10, digits-1); i < (long) Math.pow(10, digits); i++) {
			long iterations = iterations(i);
			if (iterations == 1) {
				System.out.println(i);
			}
			count += iterations;
		}
		System.out.println((double)count/(9*Math.pow(10, digits-1)) + " " + t);
	}

	static long x0 = (digits%2==0?7:2)*(long) (Math.pow(10, (digits-1)/2));
	private static long iterations(long n) {
		long i = 1;
		for(long x = x0; x != (x = (x+n/x+(n%x==0?0:1))/2); ++i);
		return i;
	}
}
