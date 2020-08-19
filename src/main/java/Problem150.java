public class Problem150 {
	
	public static long minste(long[][] board) {
		long minste = Long.MAX_VALUE;
		
		for (int i = 0; i < board.length; i++) {
			if (i % 10 == 0)
			System.out.println(i);
			for (int j = 0; j < board[i].length; j++) {
				long sum = 0;
				for (int k = i, teller = 1; k < board.length; k++, teller++) {
					for (int k2 = 0; k2 < teller; k2++) {
						sum+=board[k][j+k2];
					}
//					System.out.println(sum);
					minste = Math.min(minste, sum);
					
				}
			}
		}
		
		return minste;
	}
	
	
	public static void main(String[] args) {
		long[][] board = new long[][] {
				{15},
				{-14,-7},
				{20,-13,-5},
				{-3,8,23,-26},
				{1,-4,-5,-18,5},
				{-16,31,2,9,28,3},
		};
		
		System.out.println(minste(board));
		
		board = new long[1000][];
		int teller = 0;
		for (int i = 0; i < board.length; i++) {
			board[i] = new long[i+1];
			for (int j = 0; j <= i; j++) {
				board[i][j] = LCG(teller++);
			}
//			System.out.println(Arrays.toString(board[i]));
		}

		System.out.println(minste(board));
	}
	
	static long t = 0;
	public static long LCG(int k) {
		t = (615949*t + 797807) % (long)Math.pow(2, 20);
		return t-(long)Math.pow(2, 19);
	}
}
