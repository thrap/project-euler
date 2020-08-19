import utils.Euler;


public class Problem351BedreBaseCase {
	public static void main(String[] args) {
		
		/*
			H(5) = 30 (61)
			H(10) = 138 (193)
			H(30) = 1122 (1669)
			H(100) = 12036 (18265)
			H(1000) = 1177848 (1825153)
		 */
		int limit = 10000;
		long invisible = 0;
		for (int row = 2; row <= limit; row++) {
			if (row % 10000 == 0)
				System.out.println(row);
			invisible += invisibleCountRow(row);
		}
		System.out.println(invisible*6);
	}

	private static long invisibleCountRow(int row) {
		long invisible = 1;
		boolean[] hidden = new boolean[row];
		for(int prime : Euler.primeFactorDistinctList(row)) {
			//denne loopen er dritt
			for (int j = prime; j < hidden.length; j+=prime) {
				hidden[j] = true;
			}
		}
		for (int j = 1; j < hidden.length; j++) {
			if (hidden[j]) {
				invisible++;
			}
		}
		return invisible;
	}
}
