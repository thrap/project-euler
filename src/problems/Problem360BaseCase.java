package problems;

import utils.T;


public class Problem360BaseCase {
	
	public static void main(String[] args) {
		T t = new T();
		long sum = 0;
		int r = 45;
		int count = 0;
		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				for (int z = -r; z <= r; z++) {
					if (x*x+y*y+z*z == r*r) {
						count++;
						sum += Math.abs(x)+Math.abs(y)+Math.abs(z);
					}
				}
			}
		}
		System.out.println(sum + " " + count + " " + t);
	}
}
