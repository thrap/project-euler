package Java;

public class Problem149 {
	static long[][] table;

	static {
//		table = new long[][] { { -2, 5, 3, 2 }, { 9, -6, 5, 1 },
//				{ 3, 2, 7, 3 }, { -1, 8, -4, 8 } };
//		For 1  k  55, sk = [100003  200003k + 300007k3] (modulo 1000000)  500000.
//				For 56  k  4000000, sk = [sk24 + sk55 + 1000000] (modulo 1000000)  500000.
//
//				Thus, s10 = 393027 and s100 = 86613.
		long[] s = new long[2000*2000];
		for (int k = 1; k <= 55; k++) {
			s[k-1] = (100003 - 200003*k + 300007L*k*k*k)%1000000 - 500000;
		}
		for (int k = 56; k <= s.length; k++) {
			s[k-1] = (s[k-24-1]+s[k-55-1]+1000000)%1000000 - 500000;
		}
		
		table = new long[2000][2000];
		for (int i = 0; i < s.length; i++) {
			table[i%2000][i/2000] = s[i];
		}
//		System.out.println(s[9] + " " + s[99]);
		
	}

	public static long getRowMax() {
		long max = Long.MIN_VALUE;
		long[][] maxRow = makeCopy(table);
		for (int col = 0; col < maxRow.length; col++) {
			max = Math.max(max, maxRow[col][0]);
			for (int row = 1; row < table.length; ++row) {
				if (maxRow[col][row - 1] > 0)
					maxRow[col][row] += maxRow[col][row - 1];
				max = Math.max(max, maxRow[col][row]);
			}
//			System.out.println(Arrays.toString(maxRow[col]));
		}
		return max;
	}

	public static long getColMax() {
		long max = Long.MIN_VALUE;
		long[][] maxCol = makeCopy(table);
		for (int row = 0; row < table.length; row++) {
			max = Math.max(max, maxCol[0][row]);
			for (int col = 1; col < table.length; ++col) {
				if (maxCol[col - 1][row] > 0)
					maxCol[col][row] += maxCol[col - 1][row];
				max = Math.max(max, maxCol[col][row]);
			}
//			System.out.println(Arrays.toString(maxCol[row]));
		}
		return max;
	}

	// public static long getDiaMax() {
	// long max = Long.MIN_VALUE;
	// long[][] maxCol = makeCopy(table);
	// for (int row = 0; row < table.length; row++) {
	// max = Math.max(max, maxCol[0][row]);
	// for (int col = 1; col < table.length; ++col) {
	// if (maxCol[col - 1][row] > 0)
	// maxCol[col][row] += maxCol[col - 1][row];
	// max = Math.max(max, maxCol[col][row]);
	// }
	// System.out.println(Arrays.toString(maxCol[row]));
	// }
	// return max;
	// }

	public static void main(String[] args) {

		System.out.println(solution());

	}

	public static long solution() {
		return Math.max(getColMax(), getRowMax());
		// System.out.println(getDiaMax());
	}

	public static long[][] makeCopy(long[][] from) {
		long[][] copy = new long[from.length][from.length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				copy[i][j] = from[i][j];
			}
		}
		return copy;
	}
}
