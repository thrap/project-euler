public class Problem14 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static int solution() {
		int longest = 0;
		int best = 0;
		for (int i = 1; i < 1000000; i++) {
			int chain = chain(i);
			if (chain > longest) {
				longest = chain;
				best = i;
			}
		}
		return best;
	}
	
//	Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
	private static int chain(long i) {
		if (i == 1)
			return 1;
		if (i % 2 == 0)
			return 1+chain(i/2);
		else 
			return 1+chain(3*i+1);
	}
}

