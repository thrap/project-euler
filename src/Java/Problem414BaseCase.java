package Java;

import java.util.Arrays;

public class Problem414BaseCase {
	public static void main(String[] args) {
		//10,4,14,9,5
		long start = System.currentTimeMillis();
		int base = 15;
		int count = 0;
		for (int a = 0; a < base; a++) {
			for (int b = 0; b < base; b++) {
				for (int c = 0; c < base; c++) {
					for (int d = 0; d < base; d++) {
						for (int e = 0; e < base; e++) {
							if (a==b && a==c && a==d && a==e) continue;
							count+=sb(base, a,b,c,d,e);
						}
					}
				}
			}
		}
		System.out.println(count + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	static int i = 0;
	
	public static int[] sortDec(int[] is) {
		int[] array = is.clone();
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int B = array[i];
			while ((j > 0) && (array[j - 1] < B)) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = B;
		}
		return array;
	}
	
	public static int[] sortInc(int[] is) {
		int[] array = is.clone();
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int B = array[i];
			while ((j > 0) && (array[j - 1] > B)) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = B;
		}
		return array;
	}
	
	public static int sb(int base, int ...is) {
		if (is[0] == 10 && is[1] == 4 && is[2] == 14 && is[3] == 9 && is[4] == 5)
			return 0;
		int[] inc = sortInc(is);
		int[] dec = sortDec(is);
		
		Arrays.fill(is, 0);
		for (int i = 4; i >= 0; i--) {
			is[i] += dec[i]-inc[i];
			if (is[i] < 0) {
				is[i-1]--;
				is[i] += base;
			}
		}
		return 1+sb(base, is);
	}
}
