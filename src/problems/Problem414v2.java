package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem414v2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int k = 2; k <= 300; k++) {
			int base = 6*k+3;
			
			long[] values = generatePossibleValues(base);
			
			/**
			 * det skal finnes 
			 * midten kan vre hva som helst (bare den er imellom b og d)
			 * har du [a,b, ,d,e] => du har [a,b+1, ,d+1,e]
			 * har du [a,b, ,d,e] => du har [a+1,b, ,d,e+1]
			 */
			
//			base = 17;
//			printAllValues(generatePossibleNumbers(base), base);
//			System.exit(0);
			
			
			int antall = -1;
			for (int i = 0; i < base; i++) {
				for (int j = i; j < base; j++) {
					antall++;
				}
			}
			System.out.println("base = "+base +" ("+k+"/300)" + "\nantall = " + values.length);
			System.out.println("antallTest = " + antall);
		}
		System.out.println("("+(System.currentTimeMillis()-start+" ms)"));
	}

	static long[] pow = new long[5];
	private static long[] generatePossibleValues(int base) {
		for (int i = 0; i < 5; i++) {
			pow[i] = (long) Math.pow(base, i);
		}
		int antall = 0;
		for (int i = 0; i < base; i++) {
			for (int j = i; j < base; j++) {
				antall++;
			}
		}
		long[] list = new long[antall];
		int[] number = new int[5];
		int count = 0;
		for (int i = 0; i < base; i++) {
			number[3] = i;
			for (int j = i; j < base; j++) {
				number[4] = j;
				list[count] = toLong(number, base);
				++count;
			}
		}

		return list;
	}

	private static Long toLong(int[] inc, int base) {
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		return diff[0]*pow[4]+diff[1]*pow[3]+diff[2]*pow[2]+diff[3]*pow[1]+diff[4];
	}
}
