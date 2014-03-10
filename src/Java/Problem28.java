package Java;

public class Problem28 {
	public static void main(String[] args) {
		System.out.println(solution());
    }

	public static int solution() {
		int sum = 1;
		for (int x = 3; x <= 1001; x+=2) {
			sum += 4*x*x-(x-1)*6;
		}
		return sum;
	}
}
