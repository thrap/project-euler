package problems;


public class Problem349 {
	private static long blacks(long moves) {
		//starter paa 19000 og ut fra brute er 19000 = 1760
		//13000 mellom hver sum av arr
		int[] arr = {120, 112, 114, 122, 112, 114, 118, 112, 118, 116, 114, 114, 114};
		long sum = 0;
		for (int i : arr) {
			sum+=i;
		}
		moves-=19000;
		long blacks = 1760;
		long ant = moves/13000;
		blacks+=ant*sum;
		
		moves-=ant*13000;
		
		for (int i = 1000; i <= moves; i+=1000) {
			blacks+=arr[i/1000];
		}
		return blacks;
	}
	static long moves = 1000000000000000000L;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
		
	}
	public static long solution() {
		return blacks(moves);
	}
}