package Java;

import utils.Euler;

public class Problem41 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	
	
	public static long solution() {
		int[] arr = {7,6,5,4,3,2,1};
		int i = 0;
		while (Euler.permuteReversed(arr, arr.length)) {
			if (Euler.isPrime(asNumber(arr)))
				return asNumber(arr);
		}
		return i;
	}



	private static long asNumber(int[] arr) {
		StringBuilder num = new StringBuilder();
		for (int i : arr) {
			num.append(i);
		}
		// TODO Auto-generated method stub
		return Long.parseLong(num.toString());
	}
}
