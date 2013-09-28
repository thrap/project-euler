package problems;

public class Problem4 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int largest = 0;
		for (int i = 1000; i >= 1; i--) {
			if (largest > i*i)
				break;
			for (int j = i; j >= 1; j--) {
				int product = i*j;
				if (isPalindrome(product))
					largest = Math.max(product, largest);
			}
		}
		return largest;
	}

	private static boolean isPalindrome(int product) {
		String tall = ""+product;
		int length = tall.length();
		for (int i = 0; i < length/2; i++) {
			if (tall.charAt(i) != tall.charAt(length-i-1))
				return false;
		}
		return true;
	}
}
