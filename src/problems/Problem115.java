package problems;
public class Problem115 {
	
	static long[] WAYS;
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		for (int n = 51; true; n++) {
			WAYS = new long[n+2];
			long antall = F(n+1,0,50)+1;
			if (antall >= 1000000) {
				return n;//(n+": "+antall);
			}
		}
	}

	public static long F(int tiles, int width, int min) {
		if (WAYS[width]!=0)
			return WAYS[width];
		
		long sum = 0;
		for (int blank = 1; blank+width <= tiles; blank++) {
			for (int block = min; block+blank+width <= tiles; block++) {
				sum+=1+F(tiles,width+block+blank, min);
			}
		}
		
		WAYS[width] = sum;
		return sum;
	}
}