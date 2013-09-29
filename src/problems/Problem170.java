package problems;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem170 {
	public static void main(String[] args) {
		int[] digits = {0,1,2,3,4,5,6,7,8,9};
		
		int count = 0;
		Set<Long> numbers = new TreeSet<Long>();
		do {
			for (int i = 1; i < digits.length-1; i++) {
				int number = digits[i];
				int first = 0;
				for (int j = 0; j < i; j++) {
					first = first*10+digits[j];
				}
				
				int second = 0;
				for (int j = i+1; j < digits.length; j++) {
					second = second*10 + digits[j];
				}
				
				String numberString = ""+(number*first) + ""+(number*second);
				if (isPandigital(numberString)) {
					System.out.println(Arrays.toString(digits));
					System.out.println(numberString);
					numbers.add(Long.parseLong(numberString));
					System.out.println(number + " " + first + " " + second);
				}
				
			}
			count++;
//			System.out.println(Arrays.toString(digits));
		} while(Euler.permute(digits, digits.length));
		System.out.println(count);
		for (Long long1 : numbers) {
			System.out.println(long1);
		}
		System.out.println(numbers.size());
	}

	private static boolean isPandigital(String string) {
		if (string.length() != 10)
			return false;
		for (int i = 0; i <= 9; i++) {
			if (string.indexOf(""+i) == -1)
				return false;
		}
		return true;
	}
}
