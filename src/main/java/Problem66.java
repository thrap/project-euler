public class Problem66 {
	public static void main(String[] args) {
		long storste = 0;
		long storsteD = 0;
		for (int d = 2; d <= 1000; d++) {
			if (d == (int)Math.sqrt(d)*(int)Math.sqrt(d)) 
				continue;
			long x = 1;
			long y = 1;
			long sum = x*x -d*y*y;
			while (sum != 1) {
				if (sum > 1)
					y++;
				else
					x++;
				
				if (x > 1000000000) {
					System.out.println(d);
					break;
				}
				sum = x*x -d*y*y;
			}
			if (x > storste) {
				storste = x;
				storsteD = d;
			}
//			System.out.println(d);
		}
	}
}
