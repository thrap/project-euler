package Java;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem250 {
	public static void main(String[] args) {
		int limit = 10;
		int[] set = new int[limit];
		
		long[] count = new long[250];
		for (int i = 1; i <= set.length; i++) {
			set[(i-1)] = BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), BigInteger.valueOf(250)).intValue();
			
			count[set[(i-1)]]++;
		}
		
		System.out.println(Arrays.toString(count));
	}
}
