public class Problem1 {
	static int target = 999;

	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		return sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15);
	}

	public static int sumDivisibleBy(int n) {
		int p = target / n;
		return n * (p * (p + 1)) / 2;
	}
}
