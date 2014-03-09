package Java.problem424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PossibleValues {
	public boolean[][] possible = new boolean[10][10];
	public int[] value = new int[10];
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
		throw new RuntimeException("N har det skjedd noe feil");
	}

	public int getMaxValue(char c) {
		for(int i = 9; i>=1; i--) {
			if (possible[c-'A'][i])
				return i;
		}
		throw new RuntimeException("N har det skjedd noe feil");
	}

	public int getMinPositiveValue(char c) {
		for(int i = 1; i<=9; i++) {
			if (possible[c-'A'][i])
				return i;
		}
		throw new RuntimeException("N har det skjedd noe feil");
	}
	
	public int getMinValueOver(char c, int number) {
		for(int i = number+1; i<=9; i++) {
			if (possible[c-'A'][i])
				return i;
		}
		throw new RuntimeException("N har det skjedd noe feil");
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
		
		lookForSingles();
	}
	
	private void lookForSingles() {
		
		for (int i = 0; i <= 9; i++) {
			int count=0;
			char gangster = '_';
			for (char c = 'A'; c <= 'J'; c++) {
				if (possible[c-'A'][i]) {
					count++;
					gangster = c;
				}
			}
			if (count == 1) {
				removeLessThan(gangster, i);
				removeGreaterThan(gangster, i);
			}
		}
	}

	List<Integer> getPossibleValues(char c) {
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

	public void keep(char c, Set<Integer> valid) {
		for (int i = 0; i < possible.length; i++) {
			if (possible[c-'A'][i] && !valid.contains(i))
				remove(c, i);
		}
	}

	public boolean isPossibleCombination(String encrypted, int sum) {
		if (encrypted.length() == 1 && sum < 10) {
			return possible[encrypted.charAt(0)-'A'][sum];
		}
		if (encrypted.length() == 2 && sum >= 10) {
			return possible[encrypted.charAt(0)-'A'][sum/10] && possible[encrypted.charAt(1)-'A'][sum%10]; 
		}
		return false;
	}
}