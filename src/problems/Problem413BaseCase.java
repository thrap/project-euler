package problems;

public class Problem413BaseCase {
	public static void main(String[] args) {
		int count = 0;
		int N = (int) Math.pow(10, 7);
		long start = System.currentTimeMillis();
		for (int i = 1; i < N; i++) {
			if (i % (N/100) == 0)
				System.out.println(i/(N/100)+" %");
			
			if (isOneChildNumber(i)) {
				count++;
			}
		}
		System.out.println(count + " ("+(System.currentTimeMillis()-start)+"ms)");
	}

	public static boolean isOneChildNumber(int n) {
		String number = ""+n;
		int d = number.length();
		int count = 0;
		for (int i = 1; i <= d; i++) {
			for (int j = 0; j+i <= d; j++) {
				if (Integer.parseInt(number.substring(j, j+i)) % d == 0) {
					count++;
					if (count > 1) {
						return false;
					}
				}
			}
		}
		return count == 1;
	}
}
