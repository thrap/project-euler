public class Problem417 {
	/**
	 * denne har med cyclic numbers  gjre
	 * 
	 * se ogs p primtallsfaktorisering av repunits
	 */
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i < 10000000; i++) {
			if (i%1 == 0)
				System.out.println(i);
			sum+=period(i);
		}
		System.out.println(sum);
		System.out.println(period(7));
	}

	private static int period(int n) {
		int k = 1;
		int p10 = 10;
		while (p10 > 1) {
			p10 = (10 * p10) % n;
			k++;
		}
		return k;
	}
}
