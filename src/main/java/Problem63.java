import java.math.BigInteger;

public class Problem63 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int teller = 0;
		for (int a = 0; a < 30; a++) {
			for (int i = 1; i < 30; i++) {
				BigInteger sum = BigInteger.valueOf(i).pow(a);
				if (sum.toString().length() == a) {
					teller++;
				}
			}
		}
		return teller;
	}
}
