package problems;

public class Problem164 {
	static long[][][] memoize = new long[10][10][20];
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += makeNumber(""+i);
		}
//		System.out.println(sum);
		return sum;
	}

	public static long makeNumber(String n) {
		
		if (n.length() == 1) {
			int sum = n.charAt(0)-'0';
			long ant = 0;
			for (int i = 0; i + sum <= 9; i++) {
				ant += makeNumber(n+i);
			}
			return ant;
		} else if (n.length() == 20) {
//			System.out.println(n);
			return 1;
		} else {
			int forste = n.charAt(n.length()-1) - '0';
			int andre = n.charAt(n.length()-2) - '0';
			if (memoize[forste][andre][n.length()] != 0)
				return memoize[forste][andre][n.length()];
			int sum = forste+andre;
			long ant = 0;
			for (int i = 0; i + sum <= 9; i++) {
				ant += makeNumber(n+i);
			}
			memoize[forste][andre][n.length()] = ant;
			return ant;
		}
	}
}
