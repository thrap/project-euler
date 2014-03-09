package Java;

public class Problem413 {

	/**
	 * se klassene Problem413BaseCase og Problem413BedreBaseCase 
	 */
	public static void main(String[] args) {
		int d = 6;

		int count = 0;
		for (int i = 0; i < 10; i++) {
			count += count(1, i, i, d, i == d || i ==0);
		}
		System.out.println(count);
	}

	private static int count(int index, long number, int last, int d, boolean used) {
		if (index == d) {
			System.out.println(number);
			//TODO: legge m legge p en 0 om number.length < d
			
			//strre TODO: regne ut permutasjoner av number

			return 1;
		}
		
		int count = 0;
		for (int i = last; i < 10; i++) {
			if (used && (i == d || i == 0)) 
				continue;
			count += count(index+1, number*10+i, i, d, used || i == d || i ==0);
		}

		return count;
	}
}
