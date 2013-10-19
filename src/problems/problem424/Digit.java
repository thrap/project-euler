package problems.problem424;

import java.util.Arrays;
import java.util.List;

public class Digit implements ValueCell {
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

	@Override
	public List<Integer> getPossibleValues() {
		return Arrays.asList(digit);
	}

	@Override
	public void removeValue(int j) {
		if (j == digit)
			throw new RuntimeException("Om digit er satt, skal det ikke endres");
	}
}