import java.math.BigInteger;

public class Problem117 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println(solution()+ " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long solution() {
		long sum = 0;
		for (int red = 0; red <= 50; red++) {
			for (int green = 0; green <= 50; green++) {
				for (int blue = 0; blue <= 50; blue++) {
					int tiles = 50 - (4-1)*blue - (3-1)*green - (2-1)*red;
					if (tiles - (blue + green + red) >= 0) {
						sum += fac(tiles, blue, green, red);
//						System.out.println(red + " " + green + " " + blue+": "+fac(tiles, blue, green, red));
					}
				}
			}
		}
		return sum;
	}

	public static long fac(int tiles, int r, int g, int b) {
		BigInteger sum = BigInteger.valueOf(1);
		for (int i = 1; i <= tiles; ++i) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		BigInteger sum2 = BigInteger.valueOf(1);
		for (int i = 1; i <= r; ++i) {
			sum2 = sum2.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= g; ++i) {
			sum2 = sum2.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= b; ++i) {
			sum2 = sum2.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= tiles-(r+g+b); ++i) {
			sum2 = sum2.multiply(BigInteger.valueOf(i));
		}
//		System.out.println(sum.divide(sum2));
		return sum.divide(sum2).longValue();
	}
}
