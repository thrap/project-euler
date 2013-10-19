package problems.problem424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class White implements ValueCell {
	public boolean[] possible = new boolean[10];
	
	public White() {
		Arrays.fill(possible, true);
	}
	
	public String toString() {
		return "     "+getPossibleValues().toString();
	}
	
	public String toRawString() {
		return "O";
	}

	@Override
	public List<Integer> getPossibleValues() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < possible.length; i++) {
			if (possible[i])
				list.add(i);
		}
		return list;
	}

	@Override
	public void removeValue(int j) {
		possible[j] = false;
	}
}