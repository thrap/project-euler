package Java;

public class Problem294 {
	public static void main(String[] args) {
		System.out.println(S(9));
	}
	
	public static long S(int n) {
		long res = 0;
		for (int k = 0; k < Math.pow(10, n); k+=23) {
			if (d(k) == 23)
				++res;
		}
		return res;
	}
	
	public static int d(int k) {
		int sum = 0;
		while (k != 0) {
			sum+=k%10;
			k/=10;
		}
		return sum;
	}
}
