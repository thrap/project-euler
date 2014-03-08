package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem158v2 {

	static int N;
	static int criticalIndex;

	public static void main(String[] args) {
		for (N = 1; N <= 26; N++) {
			long count = 0;
			for (criticalIndex = 1; criticalIndex < N; criticalIndex++) {
				// System.out.println(criticalIndex);
				// perms foer * perms etter
				for (char c = 'a'; c <= 'z'; c++) {
					count += count("" + c, c, 1);
				}
			}
			System.out.println(N + " " + count);
		}
	}

	/**
	 * 1 0 
	 * 2 325 
	 * 3 10400 
	 * 4 164450 
	 * 5 1710280 
	 * 6 13123110
	 *   
	 */

	private static long count(String word, char lastChar, int index) {
		if (index == criticalIndex) {
			List<Character> chars = getUnusedChars(word);

			int idx = -1;
			for (int i = 0; i < chars.size(); i++) {
				if (lastChar < chars.get(i)) {
					idx = i;
					break;
				}
			}
			if (idx == -1)
				return 0;

			int left = N - index - 1;
			int count = 0;
			for (int i = idx; i < chars.size(); i++) {
				count += choose(i, left);
			}
			return count;
		} else {
			long count = 0;
			for (char c = 'a'; c < lastChar; c++) {
				count += count(word + c, c, index + 1);
			}
			return count;
		}
	}

	private static List<Character> getUnusedChars(String word) {
		List<Character> chars = new ArrayList<Character>();
		for (char c = 'a'; c <= 'z'; c++) {
			chars.add(c);
		}

		for (int i = 0; i < word.length(); i++) {
			chars.remove((Character) word.charAt(i));
		}
		return chars;
	}

	static long choose(final int N, final int K) {
	    long ret = 1;
	    for (int k = 0; k < K; k++) {
	        ret = ret*(N-k)/(k+1);
	    }
	    return ret;
	}
}
