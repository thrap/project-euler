package problems;

public class Problem85 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int beste = 2000000;
		int areal = Integer.MAX_VALUE;
		for (int x = 0; x < 2500; ++x) {
			for (int n = 0; n < 2500; ++n) {
				int sum = ((x*(x+1))/2)*(n*(n+1))/2;
				if (Math.abs(sum-2000000) < beste) {
					beste = Math.abs(sum-2000000);
					areal = x*n;
				}
			}
		}
//		System.out.println(areal);
		return areal;
	}
}
