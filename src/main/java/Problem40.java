public class Problem40 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		StringBuilder asd = new StringBuilder("0");
		for (int i = 1; asd.length()<= 1000000; i++) {
			asd.append(i);
		}
		int sum = 1;
		for (int i = 0; i <= 6; i++) {
			sum*=asd.charAt((int)Math.pow(10, i))-'0';
		}
		return sum;
	}
}
