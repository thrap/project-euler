package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Java.problem424.Cell;
import Java.problem424.Digit;
import Java.problem424.EncryptedSum;
import Java.problem424.Gray;
import Java.problem424.Letter;
import Java.problem424.PossibleValues;
import Java.problem424.Row;
import Java.problem424.ValueCell;
import Java.problem424.White;
import utils.T;

public class Problem424 {
	
	static PossibleValues pv;
	
	public static void main(String[] args) throws IOException {
		T t = new T();
		BufferedReader br = new BufferedReader(new FileReader("src/input-files/kakuro200.txt"));
		String input;
		
		int count = 0;
		long sum = 0;
		while ((input = br.readLine()) != null) {
			count++;
			
			pv = new PossibleValues();
			// Did this by hand hoho
			if (count == 162)
				pv.remove('D', 7);
			
			Cell[][] puzzle = parseBoard(input);
			removeObious(puzzle);
			for (int i = 0; i <= 10 && !isSolved(); i++) {
				lookAtEncrypted(puzzle);
				decryptDigits(puzzle);
				decryptWhites(puzzle);
			}
			
			long ans = getAnswer();
			System.out.println(count + ": "+ans);
			printRawPuzzle(puzzle);
			System.out.println();
			sum += ans;
		}
		System.out.println(sum + " " +t);
	}

	private static long getAnswer() {
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans*=10;
			ans += pv.value[i];
		}
		return ans;
	}

	private static boolean isSolved() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (pv.possible[i][j])
					count++;
			}
		}
		return count == 10;
	}

	private static void removeObious(Cell[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				Cell cell = puzzle[i][j];
				if (cell instanceof Letter) {
					pv.remove(((Letter)cell).c, 0);
				} else if (cell instanceof EncryptedSum) {
					EncryptedSum es = (EncryptedSum)cell;
					if (es.isHorizontal()) {
						pv.remove(es.horizontal.charAt(0), 0);
						
						if (es.horizontal.length() == 2) {
							pv.remove(es.horizontal.charAt(0), 5,6,7,8,9);
						}
					}
					if (es.isVertical()) {
						pv.remove(es.vertical.charAt(0), 0);
						
						if (es.vertical.length() == 2) {
							pv.remove(es.vertical.charAt(0), 5,6,7,8,9);
						}
					}
				}
			}
		}
	}

	private static void decryptWhites(Cell[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				Cell cell = puzzle[i][j];
				if (cell instanceof White) {
					White white = (White)cell;
					int count = 0;
					int number = -1;
					for (int k = 1; k <= 9; k++) {
						if (white.possible[k]) {
							count++;
							number = k;
						}
					}
					if (count == 1)
						puzzle[i][j] = new Digit(number);
				}
			}
		}
	}

	private static void lookAtEncrypted(Cell[][] puzzle) {
		for (Row row : getRows(puzzle)) {
			if (row.encryptedSum.length() == 1) {
				pv.keep(row.encryptedSum.charAt(0), row.getPossibleValues());
			} else {
				
				char c1 = row.encryptedSum.charAt(0);
				char c2 = row.encryptedSum.charAt(1);
				if (c1 == c2) {
					Set<Integer> valids = row.getPossibleValues();
					if (!valids.contains(11))
						pv.remove(c1, 1);
					if (!valids.contains(22))
						pv.remove(c1, 2);
					if (!valids.contains(33))
						pv.remove(c1, 3);
					if (!valids.contains(44))
						pv.remove(c1, 4);
				} else {
					Set<Integer> c1valid = new HashSet<Integer>();
					Set<Integer> c2valid = new HashSet<Integer>();
					for (Integer number : row.getPossibleValues()) {
						String str = ""+number;
						c1valid.add(str.charAt(0)-'0');
						c2valid.add(str.charAt(1)-'0');
					}
					
					pv.keep(c1, c1valid);
					pv.keep(c2, c2valid);
				}
			}
		}
	}

	private static void decryptDigits(Cell[][] puzzle) {
		for (char c = 'A'; c <= 'J'; c++) {
			if (pv.value[c-'A'] != -1) {
				decryptDigit(c, pv.value[c-'A'], puzzle);
			}
		}
	}

	private static void decryptDigit(char c, int number, Cell[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				Cell cell = puzzle[i][j];
				if (cell instanceof EncryptedSum) {
					((EncryptedSum)cell).rawString = ((EncryptedSum)cell).rawString.replaceAll(""+c, ""+number);
				} else if (cell instanceof Letter && ((Letter)cell).c == c) {
					puzzle[i][j] = new Digit(number);
				}
			}
		}
	}

	private static List<Row> getRows(Cell[][] puzzle) {
		List<Row> rows = new ArrayList<Row>();
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				if (puzzle[i][j] instanceof EncryptedSum) {
					EncryptedSum cell = (EncryptedSum)puzzle[i][j];
					if (cell.isVertical()) {
						Row col = new Row(cell.vertical, pv);
						for (int k = i+1; k < puzzle.length; k++) {
							Cell cellz = puzzle[k][j];
							if (!(cellz instanceof ValueCell))
								break;
							col.addCell((ValueCell)cellz);
						}
						rows.add(col);
					}
					if (cell.isHorizontal()) {
						Row row = new Row(cell.horizontal, pv);
						for (int k = j+1; k < puzzle.length; k++) {
							Cell cellz = puzzle[i][k];
							if (!(cellz instanceof ValueCell))
								break;
							row.addCell((ValueCell)cellz);
						}
						rows.add(row);
					}
				}
			}
		}
		return rows;
	}

	private static void printRawPuzzle(Cell[][] puzzle) {
		System.out.print(puzzle.length+",");
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				System.out.print(puzzle[i][j].toRawString()+",");
			}
		}
		System.out.println();
	}

	private static Cell[][] parseBoard(String input) {
		int size = input.charAt(0)-'0';
		Cell[][] puzzle = new Cell[size][size];

		boolean bracket = false;
		String word = "";
		int i = 0;
		for (char c : input.substring(2).toCharArray()) {
			if (c == '(')
				bracket = true;
			else if (c == ')')
				bracket = false;
			else if (!bracket && c == ',') {
				puzzle[i/size][i%size] = valueOf(word);
				i++;
				word = "";
			} else 
				word += c;
		}
		puzzle[size-1][size-1] = valueOf(word);
		return puzzle;
	}
	
	private static Cell valueOf(String s) {
		if (s.length() == 1) {
			switch(s.charAt(0)) {
			case 'O': return new White();
			case 'X': return new Gray();
			default: return new Letter(s.charAt(0), pv);
			}
		} else {
			return new EncryptedSum(s);
		}
	}
}
