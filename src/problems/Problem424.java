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
		int digit;
		public Digit(int digit) {
			this.digit = digit;
		}
		
		public String toString() {
			return "  "+digit + "  ";
		}
		
		public String toRawString() {
			return ""+digit;
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

		public int getMinValue() {
			int blank = 0;
			int minSum = 0;
			boolean[] taken = new boolean[10];
			List<Letter> letters = new ArrayList<Letter>();
			for (Cell cell : cells) {
				if (cell instanceof White) {
					blank++;
				} else if (cell instanceof Digit) {
					int number = ((Digit)cell).digit;
					taken[number] = true;
					minSum += number;
				} else if (cell instanceof Letter) {
					letters.add((Letter)cell);
				} else {
					throw new RuntimeException("Nå har det skjedd noe feil");
				}
			}
			if (letters.size() == 1) {
				int number = pv.getMinPositiveValue(letters.get(0).c);
				taken[number] = true;
				minSum+=number;
			} else if (letters.size() == 2) {
				char c1 = letters.get(0).c;
				char c2 = letters.get(1).c;

				int number1 = pv.getMinPositiveValue(c1);
				int number2 = pv.getMinPositiveValue(c2);

				int sum1 = number1 + pv.getMinValueOver(c2, number1);
				int sum2 = number2 + pv.getMinValueOver(c1, number2);
				
				if (sum1 < sum2) {
					taken[number1] = true;
					taken[sum1-number1] = true;
					minSum += sum1;
				} else {
					taken[number2] = true;
					taken[sum2-number2] = true;
					minSum += sum2;
				}
			} else if (letters.size() >= 3) {
				throw new RuntimeException("Denne må du lage nå kompis");
			}
			
			for (int i = 1; blank != 0; i++) {
				if (!taken[i]) {
					minSum += i;
					blank--;
				}
			}
			
			if (rule.length() == 2) {
				char c1 = rule.charAt(0);
				return Math.max(pv.getMinPositiveValue(c1)*10, minSum);
			} else {
				return minSum;
			}
		}

		public int getMaxValue() {
			int blank = 0;
			int maxSum = 0;
			boolean[] taken = new boolean[10];
			List<Letter> letters = new ArrayList<Letter>();
			for (Cell cell : cells) {
				if (cell instanceof White) {
					blank++;
				} else if (cell instanceof Digit) {
					int number = ((Digit)cell).digit;
					taken[number] = true;
					maxSum += number;
				} else if (cell instanceof Letter) {
					letters.add((Letter)cell);
				} else {
					throw new RuntimeException("Nå har det skjedd noe feil");
				}
			}
			if (letters.size() == 1) {
				int number = pv.getMaxValue(letters.get(0).c);
				taken[number] = true;
				maxSum+=number;
			} else if (letters.size() == 2) {
				char c1 = letters.get(0).c;
				char c2 = letters.get(1).c;

				int number1 = pv.getMaxValue(c1);
				int number2 = pv.getMaxValue(c2);

				int sum1 = number1 + pv.getMaxValueUnder(c2, number1);
				int sum2 = number2 + pv.getMaxValueUnder(c1, number2);
				
				if (sum1 > sum2) {
					taken[number1] = true;
					taken[sum1-number1] = true;
					maxSum += sum1;
				} else {
					taken[number2] = true;
					taken[sum2-number2] = true;
					maxSum += sum2;
				}
			} else if (letters.size() >= 3) {
				throw new RuntimeException("Denne må du lage nå kompis");
			}
			
			for (int i = 9; blank != 0; i--) {
				if (!taken[i]) {
					maxSum += i;
					blank--;
				}
			}
			
			if (rule.length() == 1) {
				return Math.min(9, maxSum);
			} else {
				char c1 = rule.charAt(0);
				return Math.min(pv.getMaxValue(c1)*10+9, maxSum); 
			}
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
		
		public int getMaxValueUnder(char c, int number) {
			for(int i = number-1; i>=1; i--) {
				if (possible[c-'A'][i])
					return i;
			}
			throw new RuntimeException("Nå har det skjedd noe feil");
		}

		public int getMaxValue(char c) {
			for(int i = 9; i>=1; i--) {
				if (possible[c-'A'][i])
					return i;
			}
			throw new RuntimeException("Nå har det skjedd noe feil");
		}

		public int getMinPositiveValue(char c) {
			for(int i = 1; i<=9; i++) {
				if (possible[c-'A'][i])
					return i;
			}
			throw new RuntimeException("Nå har det skjedd noe feil");
		}
		
		public int getMinValueOver(char c, int number) {
			for(int i = number+1; i<=9; i++) {
				if (possible[c-'A'][i])
					return i;
			}
			throw new RuntimeException("Nå har det skjedd noe feil");
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

		public void removeLessThan(char c, int minValue) {
			for (int i = minValue-1; i >= 0; i--) {
				remove(c, i);
			}
		}

		public void removeGreaterThan(char c, int maxValue) {
			for (int i = maxValue+1; i<=9; i++) {
				remove(c, i);
			}
		}
	}
	static PossibleValues pv = new PossibleValues();
	
	public static void main(String[] args) {
		T t = new T();
		String input = "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X";
		Cell[][] puzzle = parseBoard(input);
		
		for (int i = 0; i <= 10; i++) {
			lookAtRowsWithMinAndMaxValues(puzzle);
			decryptDigits(puzzle);
		}
		
		System.out.println(pv);
//		decryptDigit(c, number, puzzle);
		System.out.println(t);
		printRawPuzzle(puzzle);
	}

	private static void lookAtRowsWithMinAndMaxValues(Cell[][] puzzle) {
		for (Row row : getRows(puzzle)) {
			String sum = row.rule;
			int minValue = row.getMinValue();
			int maxValue = row.getMaxValue();
			
			if (sum.length() == 1) {
				char c = sum.charAt(0);
				pv.removeLessThan(c, minValue);
				pv.removeGreaterThan(c, maxValue);
			} else {
				char c1 = sum.charAt(0);
				pv.remove(c1, 0);
				pv.remove(c1, 5,6,7,8,9);
				char c2 = sum.charAt(1);
				String minString = ""+minValue;
				String maxString = ""+maxValue;
				
				pv.removeLessThan(c1, minValue/10);
				pv.removeGreaterThan(c1, maxValue/10);
				
				if (c1 == c2) {
					if (minValue > 11 || maxValue < 11) {
						pv.remove(c1, 1);
					}
					if (minValue > 22 || maxValue < 22) {
						pv.remove(c1, 2);
					}
					if (minValue > 33 || maxValue < 33) {
						pv.remove(c1, 3);
					}
					if (minValue > 44 || maxValue < 44) {
						pv.remove(c1, 4);
					}
				}
				if (minString.charAt(0) == maxString.charAt(0)) {
					pv.removeLessThan(c2, minValue%10);
					pv.removeGreaterThan(c2, maxValue%10);
				}
				
				System.out.println(sum + " " +minString + " - " + maxString);
				
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
