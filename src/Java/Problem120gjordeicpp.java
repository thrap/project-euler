package Java;

public class Problem120gjordeicpp {
	public static void main(String[] args) {
		System.out.println(Math.pow(123, 4)%13);
		int sum = 1;
		for (int i = 0; i < 4; i++) {
			sum*=123;
			sum%=13;
		}
		System.out.println(sum%13);
	}
}
