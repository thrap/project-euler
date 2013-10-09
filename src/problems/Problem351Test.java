package problems;

import utils.Euler;

public class Problem351Test {
	public static void main(String[] args) {
		int limit = 100000000;
		long invisible = 0;
		for (int row = 2; row <= limit; row++) {
			if (row % 100000 == 0)
				System.out.println(row);
			invisible+=(row-Euler.phi(row))*6;
		}
		System.out.println(invisible);
	}
}
