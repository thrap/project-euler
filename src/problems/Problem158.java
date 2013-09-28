package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem158 {
	static long biggest;
	public static void main(String[] args) {
		biggest = 0;
		for (int i = 1; i <= 26; i++) {
			long start = System.currentTimeMillis();
			long sum = 0;
			length = i;
			for (char c = 'a'; c <= 'z'; c++) {
//				System.out.println(i + ": " + c + ", biggest = " + biggest + " ("+(System.currentTimeMillis()-start+"ms)"));
				sum += antall("", c, false);
			}
			System.out.println(i + " " + sum);
			if (sum > biggest)
				biggest = sum;
		}
	}
	static int i = 0;
	static Map<String, Long> memoize = new HashMap<String, Long>();
	static int length;
	
	public static long antall(String word, char last, boolean lexicallyLeft) {
		word+=last;
		
		if (word.length() == length) {
//			System.out.println(word + " length = " + length + ", biggest =  " + biggest);
			return lexicallyLeft?1:0;
		}
		long sum = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			if (word.indexOf(c) == -1) {
				if (last < c) {
					if (!lexicallyLeft) {
						sum += antall(word, c, true);
					} else {
						break;
					}
				} else {
					sum += antall(word, c, lexicallyLeft);
				}
			}
		}
		return sum;
	}
	
	public static String sort(String word) {
		char[] arr = word.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
