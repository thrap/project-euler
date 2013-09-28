package problems;

import java.util.Arrays;

public class Problem419BaseCase {
	
	/**
	 * 
	 * Tror denne er verdt å se på lizm
	 * 
	 * http://www.njohnston.ca/2010/10/a-derivation-of-conways-degree-71-look-and-say-polynomial/
	 * 
	 * The important thing about this particular basis of subsequences is that the evolution of any sequence made up of 
	 * these subsequences is determined entirely by the evolution rule for the subsequences given in the final column of 
	 * the above table. For example, the eighth term in the look-and-say sequence is 1113213211 = (24)(39). The 
	 * subsequence (24) evolves into (83) and the subsequence (39) evolves into (9), so the ninth term in the look-and-say 
	 * sequence is (83)(9), which is 31131211131221.
	 *
	 * 1113213211 er 7. element i denne oppgaven, ta det derfra lizm hæhæ 
	 */
	public static void main(String[] args) {
		String element = "1";
		for (int n = 2; n <= 100; n++) {
			element = getNextElement(element);
			if (n < 20)
				System.out.println(element);
			System.out.println(n + ": " +Arrays.toString(count(element)));
		}
	}

	public static int[] count(String element) {
		int[]count = new int[10];
		for (int i = 0; i < element.length(); i++) {
			++count[element.charAt(i)-'0'];
		}
		return count;
	}

	private static String getNextElement(String element) {
		char last = element.charAt(0);
		int count = 1;
		StringBuilder next = new StringBuilder();
		for (int i = 1; i < element.length(); i++) {
			char c = element.charAt(i);
			if (c == last) {
				count++;
			} else {
				next.append(count);
				next.append(last);
				last = c;
				count = 1;
			}
		}
		next.append(count);
		next.append(last);

		return next.toString();
	}
}
