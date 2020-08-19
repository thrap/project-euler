import java.util.HashSet;
import java.util.Set;

import utils.Euler;

public class Problem38 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		Set<Integer> pandigital = new HashSet<Integer>();
		int[] arr = {9,8,7,6,5,4,3,2,1};
		while (Euler.permuteReversed(arr, arr.length)) {
			if (arr[0] == 8)
				break;
			pandigital.add(value(arr));
		}
		
		int storste = 0;
		for (int i = 1; i < 32000; i++) {
			String tallString = ""+i;
			int j=2;
			while (tallString.length() < 9) {
				tallString += "" + i*j;
				j++;
			}
			if (tallString.length() > 9)
				continue;
			int tall = Integer.parseInt(tallString);
			if (pandigital.contains(tall)) {
				if (storste < tall) {
					storste = tall;
				}
			}
		}
		return storste;
	}

	private static int value(int[] arr) {
		int value = 0;
		for (int i = 0; i < arr.length; i++) {
			value+=arr[i]*(int)Math.pow(10, arr.length-1-i);
		}
		return value;
	}
}
