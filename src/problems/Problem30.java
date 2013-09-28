package problems;

public class Problem30 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int sum = 0;
		for (int i = 2; i < 200000; i++) {
			if (i == sum(i))
				sum+=i;
		}
		return sum;
	}
	
	private static int sum(int i) {
		int sum = pow[i%10];
		while ((i/=10) != 0) {
			sum+=pow[i%10];
		}
		return sum;
	}

	static int[] pow = new int[10];
	
	static {
		for (int i = 0; i < pow.length; i++) {
			pow[i] = i*i*i*i*i;
		}
	}
}
