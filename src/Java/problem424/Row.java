package Java.problem424;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Row {
	public String encryptedSum;
	public List<ValueCell> cells = new ArrayList<ValueCell>();
	
	PossibleValues pv;
	public Row(String rule, PossibleValues pv) {
		this.encryptedSum = rule;
		this.pv = pv;
	}
	
	public void addCell(ValueCell cell) {
		cells.add(cell);
	}

	public Set<Integer> getPossibleValues() {
		if (cells.size() == 1) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				if (pv.isPossibleCombination(encryptedSum, i)) {
					used[0][i] = true;
					permutations.add(i);
				}
			}
			removeUnused(used);
			return permutations;
		}
		if (cells.size() == 2) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				for (int j : cells.get(1).getPossibleValues()) {
					if (i == j)
						continue;
					int sum = i+j;
					if (pv.isPossibleCombination(encryptedSum, sum)) {
						used[0][i] = true;
						used[1][j] = true;
						permutations.add(sum);
					}
				}
			}
			removeUnused(used);
			return permutations;
		}
		if (cells.size() == 3) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				for (int j : cells.get(1).getPossibleValues()) {
					if (i == j)
						continue;
					for (int k : cells.get(2).getPossibleValues()) {
						if (k == j || k == i)
							continue;
						int sum = i+j+k;
						if (pv.isPossibleCombination(encryptedSum, sum)) {
							used[0][i] = true;
							used[1][j] = true;
							used[2][k] = true;
							permutations.add(sum);
						}
					}
				}
			}
			removeUnused(used);
			return permutations;
		}
		if (cells.size() == 4) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				for (int j : cells.get(1).getPossibleValues()) {
					if (i == j)
						continue;
					for (int k : cells.get(2).getPossibleValues()) {
						if (k == j || k == i)
							continue;
						for (int l : cells.get(3).getPossibleValues()) {
							if (l == i || l == j || l == k)
								continue;
							int sum = i+j+k+l;
							if (pv.isPossibleCombination(encryptedSum, sum)) {
								used[0][i] = true;
								used[1][j] = true;
								used[2][k] = true;
								used[3][l] = true;
								permutations.add(sum);
							}
						}
					}
				}
			}
			removeUnused(used);
			return permutations;
		}
		if (cells.size() == 5) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				for (int j : cells.get(1).getPossibleValues()) {
					if (i == j)
						continue;
					for (int k : cells.get(2).getPossibleValues()) {
						if (k == j || k == i)
							continue;
						for (int l : cells.get(3).getPossibleValues()) {
							if (l == i || l == j || l == k)
								continue;
							for (int m : cells.get(4).getPossibleValues()) {
								if (m == i || m == j || m==k || m==l)
									continue;
								int sum = i+j+k+l+m;
								if (pv.isPossibleCombination(encryptedSum, sum)) {
									used[0][i] = true;
									used[1][j] = true;
									used[2][k] = true;
									used[3][l] = true;
									used[4][m] = true;
									permutations.add(sum);
								}
							}
						}
					}
				}
			}
			removeUnused(used);
			return permutations;
		}
		if (cells.size() == 6) {
			boolean[][] used = new boolean[cells.size()][10];
			Set<Integer> permutations = new HashSet<Integer>();
			for (int i : cells.get(0).getPossibleValues()) {
				for (int j : cells.get(1).getPossibleValues()) {
					if (i == j)
						continue;
					for (int k : cells.get(2).getPossibleValues()) {
						if (k == j || k == i)
							continue;
						for (int l : cells.get(3).getPossibleValues()) {
							if (l == i || l == j || l == k)
								continue;
							for (int m : cells.get(4).getPossibleValues()) {
								if (m == i || m == j || m==k || m==l)
									continue;
								for (int n : cells.get(5).getPossibleValues()) {
									if (n == i || n == j || n==k || n ==l || n==m)
										continue;
									int sum = i+j+k+l+m+n;
									if (pv.isPossibleCombination(encryptedSum, sum)) {
										used[0][i] = true;
										used[1][j] = true;
										used[2][k] = true;
										used[3][l] = true;
										used[4][m] = true;
										used[5][n] = true;
										permutations.add(sum);
									}
								}
							}
						}
					}
				}
			}
			removeUnused(used);
			return permutations;
		}
		
		throw new RuntimeException("N har du en jobb  gjre her mister:) Size = "+cells.size());
	}
	
	private void removeUnused(boolean[][] used) {
		for (int i = 0; i < used.length; i++) {
			for (int j = 1; j <= 9; j++) {
				if (!used[i][j]) {
					cells.get(i).removeValue(j);
				}
			}
		}
	}

	public String toString() {
		return encryptedSum + ": " + cells.toString() + " (values: "+ getPossibleValues().toString()+")"; 
	}
}