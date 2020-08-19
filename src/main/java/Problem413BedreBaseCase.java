public class Problem413BedreBaseCase {
	public static void main(String[] args) {
		/**
		 * tallene kan kun inneholde 
		 * 1 stk 0 eller 1 stk d eller 1 stk x*d
		 */
		
		long start = System.currentTimeMillis();
		int N = 8;
		int count = 0;
		for (int d = 1; d <= N; d++) {
			for (int i = 1; i < 10; i++) {
				count += count(1, d, i, i==0 || i == d);
			}
			System.out.println(count + " ("+(System.currentTimeMillis()-start)+"ms)");
		}
		
	}
	
	/**
	 * finner frst tall som inneholder enten 0 eller d eller ingen av delene
	 * - sjekker p slutten (tregt)
	 */
	private static int count(int index, int d, int number, boolean used) {
		if (index == d)
			return (Problem413BaseCase.isOneChildNumber(number)?1:0);
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (used && (i == 0 || i == d))
				continue;
			count += count(index + 1, d, number*10+i, used || i==0 || i == d);
		}
		return count;
	}
}
