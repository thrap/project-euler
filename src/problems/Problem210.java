package problems;

import utils.Point;
import utils.Vector;

public class Problem210 {
	public static void main(String[] args) {
		System.out.println(N(4));
	}

	private static int N(int r) {
		Point O = new Point(0, 0);
		Point C = new Point(r/4, r/4);
		Vector OC = new Vector(O, C);

		for (int x = 0; 2*x <= r; x++) {
			for (int y = 0; x+y <= r; y++) {
				Point B1 = new Point(x,y);
				Point B2 = new Point(-x,y);
				Point B3 = new Point(x,-y);
				Point B4 = new Point(-x,-y);
				
				
				System.out.println();
			}
		}
		return 0;
	}
}
