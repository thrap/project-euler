package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem52 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		for (int x = 1; true; x++) {
			Set<String> set = new HashSet<String>();
			for (int n = 1; n <= 6; n++) {
				set.add(sortString(x*n));
			}
			if (set.size() == 1) {
				return x;
			}
		}
	}

	private static String sortString(int i) {
		char[] a = String.valueOf(i).toCharArray();
		Arrays.sort(a);
		return String.valueOf(a);
	}
}
