package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Euler;
import utils.T;

public class Problem170 {
	public static void main(String[] args) {
		int[] digits = {0,1,2,3,4,5,6,7,8,9};
		T t = new T();
		
		long biggest = 0;
		int count = 0;
		do {
			if (digits[0] == 0)
				continue;
			if (++count % 100000 == 0) {
				System.out.println(count + "/"+3628800);
				System.out.println("Current biggest: "+biggest + " " + t);
			}
			
			for (long[] candidate : getCandidates(digits)) {
				long scalar = candidate[0];
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < candidate.length; i++) {
					sb.append(""+scalar*candidate[i]);
				}
				if (isPandigital(sb.toString())) {
					long pandigital = Long.parseLong(sb.toString());
					if (pandigital > biggest) {
						System.out.println(Arrays.toString(digits));
						biggest = pandigital;
						System.out.println(pandigital);
					}
				}
			}
		} while(Euler.permute(digits, digits.length));
		System.out.println(biggest + " "+t);
		
	}

	private static List<long[]> getCandidates(int[] digits) {
		List<long[]> candidates = new ArrayList<long[]>();
		for (int i = 1; i < digits.length; i++) {
			if (digits[i] == 0)
				continue;
			for (int j = i+1; j < digits.length; j++) {
				if (digits[j] == 0)
					continue;
				candidates.add(split(digits, i, j));
			}
		}
		return candidates;
	}

	private static long[] split(int[] digits, int... idx) {
		long[] result = new long[idx.length+1];
		int from = 0;
		for (int i = 0; i < idx.length; i++) {
			result[i] = number(digits, from, idx[i]-1);
			from = idx[i];
		}
		result[idx.length] = number(digits, from, digits.length-1);
		return result;
	}
	
	private static long number(int[] digits, int start, int end) {
		if (digits[start] == 0 || start > end)
			throw new RuntimeException("NŒ har du gjort noe feil mister " + start + " " + end);
		long num = 0;
		for (int i = start; i <= end; i++) {
			num = num*10+digits[i];
		}
		return num;
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
