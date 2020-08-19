public class Problem114 {

	static long teller = 0;

	static long WAYS[] = new long[100];
	
	static int MIN = 3;
	
	static int[] count = new int[52];

	public static void main(String[] args) {

		// int tiles = 50;
		// WAYS = new long[100][100];
		// System.out.println(sum(tiles,4)+sum(tiles,3)+sum(tiles,2));
		// System.out.println("20492570929");
		System.out.println(solution());
	}

	public static long solution() {
		long antall = count(51,0)+1;
		
//		for (int i = MIN; count[i] != 0; i++) {
//			System.out.println(i + ": " + count[i]);
//		}
		return antall;
	}

	public static long count(int tiles, int width) {
		// return ant(tiles, width, antall);
		if (WAYS[width]!=0)
			return WAYS[width];
		
		if (tiles - width < 0)
			return 0;
		
		long sum = 0;
		for (int blank = 1; blank+width <= tiles; blank++) {
			for (int block = MIN; block+blank+width <= tiles; block++) {
				sum+=1+count(tiles,width+block+blank);
				count[block]++;
//				System.out.println(block);
			}
		}
		
		WAYS[width] = sum;

		return sum;

	}
}