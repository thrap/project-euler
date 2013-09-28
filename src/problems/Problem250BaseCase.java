package problems;

import java.math.BigInteger;
import java.util.Arrays;

import utils.Euler;

public class Problem250BaseCase {
	public static void main(String[] args) {
		int[] set = new int[11];
		
		long[] count = new long[250];
		for (int i = 1; i <= set.length; i++) {
			set[(i-1)] = BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), BigInteger.valueOf(250)).intValue();
			
			count[(i-1)]++;
		}
		
		System.out.println(Arrays.toString(set));
		
		int antall = 0;
		for (int i = 1; i < Math.pow(2, set.length); i++) {
			int sum = getSum(Euler.toBinaryString(i, set.length), set);
			if (sum % 250 == 0) {
				printShit(Euler.toBinaryString(i, set.length), set);
				System.out.println(Euler.toBinaryString(i, set.length));
				antall++;
			}
		}
		System.out.println(antall);
	}

	private static void printShit(String string, int[] set) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1')
				System.out.print(set[i]+" ");
		}
		System.out.println();
		
	}

	private static int getSum(String string, int[] set) {
		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1')
				sum+=set[i];
		}
		return sum;
	}
}
