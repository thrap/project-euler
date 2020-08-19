import utils.Euler;

public class Problem12 {
	public static int sum(int n) {
		return (n * (n + 1)) / 2;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution());
		System.out.println(System.currentTimeMillis()-start);
	}

	public static int solution() {
		for (int i = 0; true; i++) {
			int teller = Euler.divisorAmount(sum(i));
			
			if (teller > 500) {
				return sum(i);
			}
		}
	}
}
