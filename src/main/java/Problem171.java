import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem171 {
	private static Set<String> numbers = new HashSet<String>();
	public static final int DIGITS = 10;

	public static int f(String n) {
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			int digit = n.charAt(i)-'0';
			sum+=digit*digit;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int limit = 9*9*DIGITS;
//		100000000000000000000
		List<Integer> squares = new ArrayList<Integer>();
		for (int i = 1; i*i <= limit; i++) {
			squares.add(i*i);
		}
		System.out.println(squares);
		
		for (Integer square : squares) {
			System.out.println(square);
			divideSquare(square, 9, "");
		}
		for (String number : numbers) {
//			if (!Euler.isPerfectSquare(f(number)) || f(number) > limit || number.length() > DIGITS)
				System.out.println(number);
		}
		System.out.println("Antall tall: "+numbers.size() + " " +(System.currentTimeMillis()-start)+"ms");
		//221372
		
		//TODO naa er permutasjonstallene funnet. Legg sammen permutasjoner og vinn
	}
	
	public static void divideSquare(int square, int forrige, String number) {
		if (number.length() > DIGITS || forrige*forrige*(DIGITS-number.length()) < square) {
			return;
		}
		if (square == 0) {
			numbers.add(number);
			return;
		}
		
		for (int i = forrige; i != 0; --i) {
			divideSquare(square-i*i, i, number+i);
		}
	}
}
