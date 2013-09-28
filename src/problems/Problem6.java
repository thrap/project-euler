package problems;

public class Problem6 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		return squareSum(100) - sumSquare(100);
	}

	private static int sumSquare(int i) {
		int sum = 1;
		for (int j = 2; j <= i; j++) {
			sum+=j*j;
		}
		return sum;
	}

	private static int squareSum(int i) {
		int sum = (i*(i+1))/2;
		return sum*sum;
	}
}
