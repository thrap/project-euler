package problems;

public class Problem9 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		for (int a = 1; a <= 1000; a++) {
			for (int b = a+1; a+b <= 1000; b++) {
				int c = (int)Math.sqrt(a*a+b*b);
				if (a+b+c == 1000 && c*c == a*a+b*b)
					return a*b*c;
			}
		}
		return 0;
	}
}
