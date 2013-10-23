package problems;

import utils.Point;

public class Problem184 {
	
	private static final int r = 105;

    /**
     * Se på side 40 i grafikkboka - jeg sverger kompis dette er det som kommer til å funke
     */
	
	public static void main(String[] args) {
		int count = 0;
		for (int x = -r+1; x < r; x++) {
			for (int y = -r+1; y < r; y++) {
				if (y*y+x*x >= r*r)
					continue;
				count++;
				System.out.println(new Point(x,y));
			}
		}
		System.out.println(count);
	}
}
