import java.util.HashSet;
import java.util.Set;

public class Problem36 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int sum = 0;
		Set<Integer> palindromes = new HashSet<Integer>();
		for (int i = 0; i <= 9; i++) {
			palindromes.add(i);
		}
		for (int i = 1; i < 100; i++) {
			for (int j = 0; j <= 9; j++) {
				palindromes.add(Integer.parseInt(""+i +""+ j +""+ new StringBuilder(""+i).reverse().toString()));
			}
		}
		for (int i = 1; i < 1000; i++) {
			palindromes.add(Integer.parseInt(""+i + ""+new StringBuilder(""+i).reverse().toString()));
		}
		for (Integer palindrome : palindromes) {
			if (isPalindrome(Integer.toBinaryString(palindrome))) {
				sum+=palindrome;
			}
		}
		return sum;
	}

	private static boolean isPalindrome(String binaryString) {
		for (int i = 0; i < binaryString.length()/2; i++) {
			if (binaryString.charAt(i) != binaryString.charAt(binaryString.length()-i-1))
				return false;
		}
		return true;
	}
}
