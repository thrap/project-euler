package problems;


public class Problem360BaseCase {
	
	public static void main(String[] args) {
		long sum = 0;
		int r = 45;
		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				for (int z = -r; z <= r; z++) {
					if (x*x+y*y+z*z == r*r) {
						sum += Math.abs(x)+Math.abs(y)+Math.abs(z);
					}
				}
			}
		}
		System.out.println(sum);
	}
}
