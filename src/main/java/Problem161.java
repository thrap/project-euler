import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.T;

public class Problem161 {

	private static class Board {
		boolean[][] free;

		public Board(boolean[][] board) {
			this.free = board;
		}

		public List<Board> getChildren() {
			List<Board> children = new ArrayList<Board>();

			ytterste: for (int i = 0; i < free.length; i++) {
				for (int j = 0; j < free[i].length; j++) {
					if (free[i][j]) {
						if (redFits(i, j)) {
							children.add(this.placeRed(i, j));
						}
						if (greenFits(i, j)) {
							children.add(this.placeGreen(i, j));
						}
						if (blueFits(i, j)) {
							children.add(this.placeBlue(i, j));
						}
						if (orangeFits(i, j)) {
							children.add(this.placeOrange(i, j));
						}
						if (tealFits(i, j)) {
							children.add(this.placeTeal(i, j));
						}
						if (blackFits(i, j)) {
							children.add(this.placeBlackl(i, j));
						}

						break ytterste;
					}
				}
			}

			return children;
		}

		private Board placeBlackl(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i][j + 1] = false;
			board.free[i][j + 2] = false;
			return board;
		}

		private boolean blackFits(int i, int j) {
			if (j + 2 >= free[0].length) {
				return false;
			}
			return free[i][j + 1] && free[i][j + 2];
		}

		private Board placeTeal(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i + 1][j] = false;
			board.free[i + 2][j] = false;
			return board;
		}

		private boolean tealFits(int i, int j) {
			if (i + 2 >= free.length) {
				return false;
			}
			return free[i + 1][j] && free[i + 2][j];
		}

		private Board placeOrange(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i + 1][j - 1] = false;
			board.free[i + 1][j] = false;
			return board;
		}

		private boolean orangeFits(int i, int j) {
			if (i + 1 >= free.length || j - 1 < 0) {
				return false;
			}
			return free[i + 1][j - 1] && free[i + 1][j];
		}

		private Board placeBlue(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i + 1][j + 1] = false;
			board.free[i + 1][j] = false;
			return board;
		}

		private boolean blueFits(int i, int j) {
			if (i + 1 >= free.length || j + 1 >= free[0].length) {
				return false;
			}
			return free[i + 1][j + 1]  && free[i + 1][j] ;
		}

		private Board placeGreen(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i + 1][j + 1] = false;
			board.free[i][j + 1] = false;
			return board;
		}

		private boolean greenFits(int i, int j) {
			if (i + 1 >= free.length || j + 1 >= free[0].length) {
				return false;
			}
			return free[i + 1][j + 1]  && free[i][j + 1] ;
		}

		public Board clone() {
			boolean[][] board = new boolean[this.free.length][this.free[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = this.free[i][j];
				}
			}
			return new Board(board);
		}

		private boolean redFits(int i, int j) {
			if (i + 1 >= free.length || j + 1 >= free[0].length) {
				return false;
			}
			return free[i + 1][j]  && free[i][j + 1] ;
		}

		private Board placeRed(int i, int j) {
			Board board = this.clone();
			board.free[i][j] = false;
			board.free[i + 1][j] = false;
			board.free[i][j + 1] = false;
			return board;
		}

		public void printBoard() {
			String horizontal = "+"+new String(new char[free[0].length * 2 + 1]).replace('\0', '-') + "+";
			System.out.println(horizontal);
			for (int i = 0; i < free.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < free[i].length; j++) {
					System.out.print((free[i][j]?" ":"x") + " ");
				}
				System.out.println("|");
			}
			System.out.println(horizontal);
		}

		public boolean isFilled() {
			for (int i = 0; i < free.length; i++) {
				for (int j = 0; j < free[0].length; j++) {
					if (free[i][j])
						return false;
				}
			}
			return true;
		}
		
		public BitSet getBitSet() {
			BitSet bs = new BitSet(free.length*free[0].length);
			for (int i = 0; i < free.length; i++) {
				for (int j = 0; j < free[0].length; j++) {
					bs.set(i*free[0].length+j, free[i][j]);
				}
			}
			return bs;
		}
	}

	public static void main(String[] args) {
		T t = new T();
		boolean[][] board = new boolean[9][12];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], true);
		}
		Board b = new Board(board);

		long sum = 0;
		for (Board child : b.getChildren()) {
			child.printBoard();
			sum += reccurse(child);
		}
		
		System.out.println("Total count: " + sum + " " + t);
	}

	static Map<BitSet, Long> memoize = new HashMap<BitSet, Long>();
	
	private static long reccurse(Board b) {
		BitSet memo = b.getBitSet();

		if (memoize.containsKey(memo))
			return memoize.get(memo);
		
		List<Board> children = b.getChildren();
		if (children.size() == 0) {
			if (b.isFilled())
				return 1;
			return 0;
		}
		long sum = 0;
		for (Board child : children) {
			sum += reccurse(child);
		}
		memoize.put(memo, sum);
		return sum;
	}
}
