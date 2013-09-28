package problems;

public class Problem34 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int sum = 0;
		for (int i = 10; i < 50000; i++) {
			if (i == check(i))
				sum+=i;
		}
		return sum;
	}

	private static int check(int i) {
		int sum = fact[i%10];
		while ((i/=10) != 0) {
			sum+=fact[i%10];
		}
		return sum;
	}
	
	static int [] fact = new int[10];
	
	static {
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact(i);
		}
	}

	private static int fact(int i) {
		int prod = 1;
		for (int j = 2; j <= i; j++) {
			prod*=j;
		}
		return prod;
	}
}
