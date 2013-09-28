package problems;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Problem371BaseCase {
	
	private static final int TESTS = 100000;
	private static final Random R = new Random();
	
	public static void main(String[] args) {
		double totalPlates = 0;
		for (int i = 0; i < TESTS; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int number = R.nextInt(1000);
			int plates = 1;
			while (!set.contains(1000-number)) {
				set.add(number);
				plates++;
				number = R.nextInt(1000);
			}
			totalPlates+=plates;
		}
		System.out.println(totalPlates/TESTS);
	}
	
}