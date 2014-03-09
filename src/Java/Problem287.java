package Java;

public class Problem287 {
	static int n = 10;
	public static void main(String[] args) {
		boolean[][] baseCase = {{true, true, true, false},{true, true, false, true}, {false, false, true, true},  {false, false, true, true}};
		printBoard(baseCase);
		System.out.println(encode(baseCase));
		
		
		boolean[][] black = D(n);
		printBoard(black);
		
		
		
		System.out.println(encode(black).length());
		
		System.out.println("0100101111101110");
	}
	
	private static void printBoard(boolean[][] black) {
		for (int x = 0; x < black.length; x++) {
			for (int y = 0; y < black.length; y++) {
				System.out.print(black[x][y]?"L ":"  ");
			}
			System.out.println();
		}
	}

	private static String encode(boolean[][] black) {
//		if (black.length == Math.pow(2, n-1)) {
//			printBoard(black);
//			System.out.println();
//		}
		if (onlyBlack(black)) {
			return "10";
		} else if (onlyWhite(black)) {
			return "11";
		} else {
			boolean[][] topLeft = new boolean[black.length/2][black.length/2];
			boolean[][] bottomLeft = new boolean[black.length/2][black.length/2];
			boolean[][] topRight = new boolean[black.length/2][black.length/2];
			boolean[][] bottomRight = new boolean[black.length/2][black.length/2];
			
			for (int i = 0; i < black.length; i++) {
				for (int j = 0; j < black.length; j++) {
					boolean val = black[i][j];
					if (j < black.length/2) {
						if (i < black.length/2) {
							topLeft[i][j] = val;
						} else {
							bottomLeft[i-black.length/2][j] = val;
						}
					} else {
						if (i < black.length/2) {
							topRight[i][j-black.length/2] = val;
						} else {
							bottomRight[i-black.length/2][j-black.length/2] = val;
						}
					}
				}
			}
			if (black.length == Math.pow(2, n)) {
				printBoard(topLeft);
//				System.out.println();
			}
			
			if (black.length == Math.pow(2, n)) {
				if (encode(topRight).length() != encode(bottomLeft).length()) {
					System.out.println("TODO");
				}
			}
			
			return "0"+encode(topLeft) + encode(topRight) + encode(bottomLeft) + encode(bottomRight);
		}
	}

	private static boolean onlyWhite(boolean[][] black) {
		for (int i = 0; i < black.length; i++) {
			for (int j = 0; j < black.length; j++) {
				if (black[i][j])
					return false;
			}
		}
		return true;
	}

	private static boolean onlyBlack(boolean[][] black) {
		for (int i = 0; i < black.length; i++) {
			for (int j = 0; j < black.length; j++) {
				if (!black[i][j])
					return false;
			}
		}
		return true;
	}

	public static boolean[][] D(int n) {
		int px = (int)Math.pow(2,n);
		boolean[][] board = new boolean[px][px];
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				board[x][y] = black(x,y,n);
			}
		}
		return board;
	}
	
	public static boolean black(int x, int  y, int n) {
		return Math.pow(x-Math.pow(2, n-1),2)+Math.pow(y-Math.pow(2, n-1),2) <= Math.pow(2, 2*n-2);
	}
}
