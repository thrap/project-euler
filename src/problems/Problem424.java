package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.T;

public class Problem424 {
	
	private static interface Cell {
		
	}
	
	private static class White implements Cell {
		public String toString() {
			return "     ";
		}
	}
	
	private static class Gray implements Cell {
		public String toString() {
			return "XXXXX";
		}
	}
	
	private static class EncryptedSum implements Cell {
		String horizontal = "";
		String vertical = "";
		public EncryptedSum (String s) {
			for (String el : s.split(",")) {
				if (el.charAt(0) == 'h') {
					horizontal = el.substring(1);
					if (horizontal.length() == 2) {
						possibleValues.get(horizontal.charAt(0)).removeAll(Arrays.asList(new Integer[] {0,5,6,7,8,9}));
					}
				} else {
					vertical = el.substring(1);
					if (vertical.length() == 2) {
						System.out.println(possibleValues);
						possibleValues.get(vertical.charAt(0)).removeAll(Arrays.asList(new Integer[] {0,5,6,7,8,9}));
						System.out.println(possibleValues);
					}
				}
			}
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
	}
	
	private static class Digit implements Cell {
		char c;
		public Digit(char c) {
			this.c = c;
		}
		
		public String toString() {
			return "  "+c + "  ";
		}
	}
	
	static Map<Character, Set<Integer>> possibleValues = new HashMap<Character, Set<Integer>>();
	
	public static void main(String[] args) {
		T t = new T();
		String input = "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X";
		for (char c = 'A'; c <= 'J'; c++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i <= 9; i++) {
				set.add(i);
			}
			possibleValues.put(c, set);
		}
		Cell[][] puzzle = parseBoard(input);
		System.out.println(possibleValues);
	
		for (int j = 0; j < puzzle.length; j++) {
			System.out.println(Arrays.toString(puzzle[j]));
		}
		System.out.println(t);
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
			default: return new Digit(s.charAt(0));
			}
		} else {
			return new EncryptedSum(s);
		}
	}
}
