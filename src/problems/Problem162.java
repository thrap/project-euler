package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem162 {
	
	static Map<String, Long> memoize = new HashMap<String, Long>();
	static int numberLength;
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static String solution() {
		long sum = 0;
		for (int i = 0; i <= 16; i++) {
			numberLength = i;
			memoize.clear();
			sum+=antall(0, false, false, false);
		}
		return Long.toHexString(sum).toUpperCase();
	}

	public static long antall(int length, boolean zero, boolean one, boolean a) {
		if (length == numberLength) {
			return (zero && one && a)?1:0;
		}
		String memo = ""+length + zero + one + a;
		if (memoize.containsKey(memo)) {
			return memoize.get(memo);
		}
		long sum = 0;
		for (int i = (length == 0?1:0); i < 16; i++) {
			if (i == 0) {
				sum+=antall(length+1, true, one, a);
			} else if (i == 1) {
				sum+=antall(length+1, zero, true, a);
			} else if (i == 10) {
				sum+=antall(length+1, zero, one, true);
			} else {
				sum+=antall(length+1, zero, one, a);
			}
			
		}
		memoize.put(memo, sum);
		return sum;
	}

	private static char hexify(int i) {
		switch(i) {
		case 10: return 'A';
		case 11: return 'B';
		case 12: return 'C';
		case 13: return 'D';
		case 14: return 'E';
		case 15: return 'F';
		default: return (char)('0'+i);
		}
	}
}
