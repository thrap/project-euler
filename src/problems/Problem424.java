package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.T;

public class Problem424 {
	/**
	 * TODO: les denne
	 * http://krazydad.com/krypto/help.php
	 */
	
	private static interface Cell {
		public String toRawString();
	}
	
	private static class White implements Cell {
		public String toString() {
			return "     ";
		}
		
		public String toRawString() {
			return "O";
		}
	}
	
	private static class Gray implements Cell {
		public String toString() {
			return "XXXXX";
		}
		
		public String toRawString() {
			return "X";
		}
	}
	
	private static class EncryptedSum implements Cell {
		String horizontal = "";
		String vertical = "";

		String rawString;
		public EncryptedSum (String s) {
			rawString = s;
			for (String el : s.split(",")) {
				if (el.charAt(0) == 'h') {
					horizontal = el.substring(1);
				} else {
					vertical = el.substring(1);
				}
			}
		}
		
		public boolean isVertical() {
			return this.vertical.length() != 0;
		}
		
		public boolean isHorizontal() {
			return this.horizontal.length() != 0;
		}
		
		public String toString() {
			String vertical = this.vertical;
			String horizontal = this.horizontal;
			switch(vertical.length()) {
			case 0: vertical = "XX"; break;
			case 1: vertical = " "+vertical; break;
			}
			switch(horizontal.length()) {
			case 0: horizontal = "XX"; break;
			case 1: horizontal = " "+horizontal; break;
			}
			return vertical + "\\"+ horizontal;
		}
		
		public String toRawString() {
			return "("+rawString+")";
		}
	}
	
	private static class Letter implements Cell {
		char c;
		public Letter(char c) {
			this.c = c;
		}
		
		public String toString() {
			return "  "+c + "  ";
		}
		
		public String toRawString() {
			return ""+c;
		}
	}
	
	private static class Digit implements Cell {
		int number;
		public Digit(int c) {
			this.number = c;
		}
		
		public String toString() {
			return "  "+number + "  ";
		}
		
		public String toRawString() {
			return ""+number;
		}
	}
	
	private static class Row {
		String rule;
		List<Cell> cells = new ArrayList<Cell>();
		public Row(String rule) {
			this.rule = rule;
		}
		
		public void addCell(Cell cell) {
			cells.add(cell);
		}
	}
	
	public static class PossibleValues {
		boolean[][] possible = new boolean[10][10];
		int[] value = new int[10];
		public PossibleValues() {
			Arrays.fill(value, -1);
			for (char c = 'A'; c <= 'J'; c++) {
				Arrays.fill(possible[c-'A'], true);
			}
		}
		
		public void remove(char c, int...is) {
			for (int i : is) {
				if (possible[c-'A'][i]) {
					possible[c-'A'][i] = false;
					propagateChange(c);
				}
			}
		}
		
		public void remove(char c, List<Integer> is) {
			for (int i : is) {
				remove(c, i);
			}
		}
		
		private void propagateChange(char c) {
			List<Integer> valueList = getPossibleValues(c);
			if (valueList.size() == 1) {
				int value = -1;
				for (int i = 0; i < possible[c-'A'].length; i++) {
					if (possible[c-'A'][i]) {
						value = i;
						break;
					}
				}
				this.value[c-'A'] = value;
			} 
			
			boolean[] possibles = this.possible[c-'A'];
			int equalCount = 0;
			for (int i = 0; i < this.possible.length; i++) {
				if (deepEquals(possibles, this.possible[i])) {
					equalCount++;
				}
			}
			if (equalCount == valueList.size()) {
				for (char other = 'A'; other <= 'J'; other++) {
					if (!deepEquals(possibles, this.possible[other-'A'])) {
						remove(other, valueList);
					}
				}
			}
		}
		
		private List<Integer> getPossibleValues(char c) {
			List<Integer> values = new ArrayList<Integer>();
			for (int i = 0; i < possible.length; i++) {
				if (possible[c-'A'][i])
					values.add(i);
			}
			return values;
		}

		public boolean deepEquals(boolean[] a, boolean[] b) {
			for (int i = 0; i < b.length; i++) {
				if (a[i] != b[i])
					return false;
			}
			return true;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (char c = 'A'; c <= 'J'; c++) {
				sb.append(c + "\t");
				for (int i = 0; i <= 9; i++) {
					if (possible[c-'A'][i]) {
						sb.append(i + " ");
					} else {
						sb.append("  ");
					}
				}
				sb.append('\n');
			}
			return sb.toString();
		}
		
		public int count(char c) {
			int count = 0;
			for (boolean possible : this.possible[c-'A']) {
				if (possible)
					count++;
			}
			return count;
		}
	}
	static PossibleValues pv = new PossibleValues();
	
	public static void main(String[] args) {
		T t = new T();
		String input = "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X";
		Cell[][] puzzle = parseBoard(input);
		
		for (Row row : getRows(puzzle)) {
			String cell = row.rule;
			if (row.cells.size() == 2) {
				if (cell.length() == 2)
					pv.remove(cell.charAt(0), 0,2,3,4,5,6,7,8,9);
				else 
					pv.remove(cell.charAt(0), 0,1,2);
			} else if (row.cells.size() == 3) {
				if (cell.length() == 2)
					pv.remove(cell.charAt(0), 0,3,4,5,6,7,8,9);
				else 
					pv.remove(cell.charAt(0), 0,1,2,3,4,5);
			} else if (row.cells.size() >= 4) {
				// length == 2
				pv.remove(cell.charAt(0), 0,4,5,6,7,8,9);
			}
		}
		
//		for (char c = 'A'; c <= 'J'; c++) {
//			Set<Integer> set = pv.possible[c-'A'];
//			
//			if (set.size() == 1) {
//				int number = set.iterator().next();
//				removeNumberFromOthers(c, number);
//				decryptDigit(c, number, puzzle);
//			}
//		}
		
		System.out.println(pv);
		
		System.out.println(t);
		printRawPuzzle(puzzle);
	}

	private static void decryptDigit(char c, int number, Cell[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				Cell cell = puzzle[i][j];
				if (cell instanceof EncryptedSum) {
					/**
					 * TODO
					 */
				} else if (cell instanceof Letter && ((Letter)cell).c == c) {
					puzzle[i][j] = new Digit(number);
				}
			}
		}
	}

	private static void removeNumberFromOthers(char c, int number) {
		for (char other = 'A'; other <= 'J'; other++) {
			if (c != other) {
				pv.remove(other, number);
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
						Row col = new Row(cell.vertical);
						for (int k = i+1; k < puzzle.length; k++) {
							Cell cellz = puzzle[k][j];
							if (cellz instanceof EncryptedSum || cellz instanceof Gray)
								break;
							col.addCell(cellz);
						}
						rows.add(col);
					}
					if (cell.isHorizontal()) {
						Row row = new Row(cell.horizontal);
						for (int k = j+1; k < puzzle.length; k++) {
							Cell cellz = puzzle[i][k];
							if (cellz instanceof EncryptedSum || cellz instanceof Gray)
								break;
							row.addCell(cellz);
						}
						rows.add(row);
					}
				}
			}
		}
		return rows;
	}

	private static void printPuzzle(Cell[][] puzzle) {
		for (int j = 0; j < puzzle.length; j++) {
			System.out.println(Arrays.toString(puzzle[j]));
		}
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
			default: return new Letter(s.charAt(0));
			}
		} else {
			return new EncryptedSum(s);
		}
	}
}
