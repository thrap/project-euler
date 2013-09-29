package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.T;

public class Problem161BaseCase {
	
	private static class Board {
		private static final char BLANK = ' ';
		private static final char RED = 'r';
		private static final char GREEN = 'g';
		private static final char BLUE = 'b';
		private static final char ORANGE = 'o';
		private static final char TEAL = 't';
		private static final char BLACK = 'b';

		char[][] board;
		public Board(char[][] board) {
			this.board = board;
		}
		
		public List<Board> getChildren() {
			List<Board> children = new ArrayList<Board>();
			
			ytterste: 
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == BLANK) {
						if(redFits(i,j)) {
							children.add(this.placeRed(i, j));
						}
						if (greenFits(i,j)) {
							children.add(this.placeGreen(i, j));
						}
						if (blueFits(i,j)) {
							children.add(this.placeBlue(i, j));
						}
						if (orangeFits(i,j)) {
							children.add(this.placeOrange(i, j));
						}
						if (tealFits(i,j)) {
							children.add(this.placeTeal(i, j));
						}
						if (blackFits(i,j)) {
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
			board.board[i][j] = BLACK;
			board.board[i][j+1] = BLACK;
			board.board[i][j+2] = BLACK;
			return board;
		}

		private boolean blackFits(int i, int j) {
			if (j+2 >= board[0].length) {
				return false;
			}
			return board[i][j+1] == BLANK && board[i][j+2] == BLANK;
		}

		private Board placeTeal(int i, int j) {
			Board board = this.clone();
			board.board[i][j] = TEAL;
			board.board[i+1][j] = TEAL;
			board.board[i+2][j] = TEAL;
			return board;
		}

		private boolean tealFits(int i, int j) {
			if (i+2 >= board.length) {
				return false;
			}
			return board[i+1][j] == BLANK && board[i+2][j] == BLANK;
		}

		private Board placeOrange(int i, int j) {
			Board board = this.clone();
			board.board[i][j] = ORANGE;
			board.board[i+1][j-1] = ORANGE;
			board.board[i+1][j] = ORANGE;
			return board;
		}

		private boolean orangeFits(int i, int j) {
			if (i+1 >= board.length || j-1 < 0) {
				return false;
			}
			return board[i+1][j-1] == BLANK && board[i+1][j] == BLANK;
		}

		private Board placeBlue(int i, int j) {
			Board board = this.clone();
			board.board[i][j] = BLUE;
			board.board[i+1][j+1] = BLUE;
			board.board[i+1][j] = BLUE;
			return board;
		}

		private boolean blueFits(int i, int j) {
			if (i+1 >= board.length || j+1 >= board[0].length) {
				return false;
			}
			return board[i+1][j+1] == BLANK && board[i+1][j] == BLANK;
		}

		private Board placeGreen(int i, int j) {
			Board board = this.clone();
			board.board[i][j] = GREEN;
			board.board[i+1][j+1] = GREEN;
			board.board[i][j+1] = GREEN;
			return board;
		}

		private boolean greenFits(int i, int j) {
			if (i+1 >= board.length || j+1 >= board[0].length) {
				return false;
			}
			return board[i+1][j+1] == BLANK && board[i][j+1] == BLANK;
		}

		public Board clone() {
			char[][] board = new char[this.board.length][this.board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = this.board[i][j];
				}
			}
			return new Board(board);
		}
		
		private boolean redFits(int i, int j) {
			if (i+1 >= board.length || j+1 >= board[0].length) {
				return false;
			}
			return board[i+1][j] == BLANK && board[i][j+1] == BLANK;
		}
		
		private Board placeRed(int i, int j) {
			Board board = this.clone();
			board.board[i][j] = RED;
			board.board[i+1][j] = RED;
			board.board[i][j+1] = RED;
			return board;
		}

		public void printBoard() {
			String horizontal = "+" + new String(new char[board[0].length*2+1]).replace('\0', '-') + "+";
			System.out.println(horizontal);
			for (int i = 0; i < board.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println("|");
			}
			System.out.println(horizontal);
		}

		public boolean isFilled() {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == BLANK)
						return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		char[][] board = new char[4][12];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], Board.BLANK);
		}
		Board b = new Board(board);
		
		reccurse(b);
		System.out.println("Total count: " + count + " "+ t);
	}
	
	static int count = 0;

	private static void reccurse(Board b) {
		List<Board> children = b.getChildren();
		if (children.size() == 0) {
			if (b.isFilled()) {
				count++;
				if (count % 100000 == 0) {
					b.printBoard();
					System.out.println(count);
				}
			} else { 
				/** 
				 * tror disse er det du burde se på
				 */
//				b.printBoard();
			}
		}
		for (Board child : children) {
			reccurse(child);
		}
	}
}
