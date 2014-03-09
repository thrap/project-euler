package Java.problem424;

import java.util.List;

public class Letter implements ValueCell {
	public char c;
	private PossibleValues pv;
	public Letter(char c, PossibleValues pv) {
		this.c = c;
		this.pv = pv;
	}
	
	public String toString() {
		return "  "+c+"  " + getPossibleValues().toString();
	}
	
	public String toRawString() {
		return ""+c;
	}

	@Override
	public List<Integer> getPossibleValues() {
		return pv.getPossibleValues(c);
	}

	@Override
	public void removeValue(int j) {
		pv.remove(c, j);
	}
}