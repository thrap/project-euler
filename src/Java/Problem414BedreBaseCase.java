package Java;

import java.util.HashMap;
import java.util.Map;

public class Problem414BedreBaseCase {
	
	static int[] Cb;
	public static void main(String[] args) {
		for (int k = 2; k < 300; k++) {
			long start = System.currentTimeMillis();
			int base = 6*k+3;
			long count = 0;
			Cb = findCb(base, new int[] {0,0,0,0,1});
			//om Cb er sortert gr ting til helvette
			for (int i = 1; i < 5; i++) {
				if (Cb[i-1] > Cb[i])
					break;
				if (i == 4) {
					System.out.println("sortert rofl");
					System.exit(0);
				}
			}
			// System.out.println(Arrays.toString(Cb));
			int[] numbers = new int[5];
			for (int a = 0; a < base; a++) {
				numbers[0] = a;
				for (int b = a; b < base; b++) {
					numbers[1] = b;
					numbers[2] = b;
					for (int d = b; d < base; d++) {
						numbers[3] = d;
						for (int e = d; e < base; e++) {
							numbers[4] = e;
							int perms = 0;
							if (a == b && a == d && a == e)
								continue;
							for (int c = b; c <= d; c++) {
								perms += permutations(a, b, c, d, e);
							}
							count += perms * sb(base, numbers);
						}
					}
				}
			}
			/**
			 * NB OM CB ER DEN MAN TESTER P GR DET TIL HELVETTE
			 * 
			 * 
			 * count bommer med 1 pga Cb
			 */
			System.out.println(base + " = "+ (count-1) + " ("+(System.currentTimeMillis()-start)+"ms)");
			System.out.println("15 = 5274369");
		}
	}
	
	private static int[] findCb(int base, int[] last) {
		int[] inc = sortInc(last);
		int[] dec = sortDec(last);
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += dec[i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (last[i] != diff[i])
				break;
			if (i == 4) {
				return diff;
			}
		}
		return findCb(base, diff);
	}

	static int[] factorial = {1,1,2,6,24,120};
	
	private static int permutations(int...is) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < is.length; i++) {
			int k = is[i];
			if (count.containsKey(k)) {
				count.put(k, count.get(k)+1);
			} else {
				count.put(k, 1);
			}
		}
		
		int permutations = factorial[is.length];
		for (int i : count.values()) {
			permutations/=factorial[i];
		}
		return permutations;
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
	
	public static int sb(int base, int[] is) {
		if (is[0] == Cb[0] && is[1] == Cb[1] && is[2] == Cb[2] && is[3] == Cb[3] && is[4] == Cb[4])
			return 0;
		int[] inc = sortInc(is);
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		return 1+sb(base, diff);
	}
}
