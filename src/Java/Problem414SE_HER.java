package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem414SE_HER {
	
	static int[] Cb;
	static int base;
	public static void main(String[] args) {
		getAnswer(111);
	}
	
	public static Set<Long> getAnswer(int basE) {
		long start = System.currentTimeMillis();
		long count = 0;
		base = basE;
		COUNT.clear();
		Cb = findCb(new int[] {0,0,0,0,1});
		for (int i = 0; i < 5; i++) {
			pow[i] = (long) Math.pow(base, i);
		}
		//om Cb er sortert gr ting til helvette
		for (int i = 1; i < 5; i++) {
			if (Cb[i-1] > Cb[i])
				break;
			if (i == 4) {
				System.out.println("sortert rofl");
				System.exit(0);
			}
		}
//			System.out.println(Arrays.toString(Cb));
		int [] numbers = new int[5];
		for (int a = 0; a < base; a++) {
			numbers[0] = a;
			System.out.println(a);
			for (int b = a; b < base; b++) {
				numbers[1] = b;
				for (int d = b; d < base; d++) {
					numbers[3] = d;
					for (int e = d; e < base; e++) {
						numbers[4] = e;
						int perms = 0;
						if (a == b && a == d && a == e)
							continue;
						for (int c = b; c <= d; c++) {
							numbers[2] = c;
							perms += permutations(numbers);
						}
						count += perms * firstsb(numbers);
					}
				}
			}
		}
		for (long number : COUNT.keySet()) {
			int[] decoded = decode(number);
			System.out.println(Arrays.toString(decoded) + " " + COUNT.get(number));
			/**
				TING JEG HAR LAGT MERKE TIL
			 */
			if (decoded[2] != base-1) {
				System.out.println("Det stemmer ikke at de i midten alltid blir base-1");
				System.exit(0);
			}
			if (decoded[0]+decoded[4] != base-1 && decoded[0]+decoded[4] != base) {
				System.out.println("Det stemmer ikke at frste og siste blir summert til base eller base-1");
				System.exit(0);
			}
			if (decoded[1]+decoded[3] != base-2 && decoded[1]+decoded[3] != 2*base-2) {
				System.out.println("Det stemmer ikke at 1 og 3 blir summert til base-2 eller 2*base-2)");
				System.exit(0);
			}
			if (decoded[0]+decoded[4] == base-1 && decoded[1]+decoded[3] != 2*base-2) {
				System.out.println("Det stemmer ikke at 1 og 3 blir summert til base-2 eller 2*base-2)");
				System.exit(0);
			}
			if (decoded[0]+decoded[4] == base && decoded[1]+decoded[3] != base-2) {
				System.out.println("Det stemmer ikke at 1 og 3 blir summert til base-2 eller 2*base-2)");
				System.exit(0);
			}
			if (decoded[0] < decoded[1] && decoded[1] != base-1) {
				System.out.println("Det stemmer ikke at 1 og 3 blir summert til base-2 eller 2*base-2)");
				System.exit(0);
			}
		}
		System.out.println(COUNT.size());
		System.out.println(base + " = "+ (count-1) + " ("+(System.currentTimeMillis()-start)+"ms)");
		return COUNT.keySet();
	}

	public static int[] decode(long number) {
		int[] decoded = new int[5];
		for (int i = 4; i >= 0; i--) {
			long amount = number/pow[i];
			number-=amount*pow[i];
			decoded[4-i] = (int)amount;
		}
		return decoded;
	}

	static Map<Long, Integer> COUNT = new HashMap<Long, Integer>(); 
	
	static long[] pow = new long[5];
	
	public static int firstsb(int[] inc) {
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		return 1+sb(diff);
	}

	public static int[] findCb(int[] last) {
		int[] inc = last.clone();
		Arrays.sort(inc);
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
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
		return findCb(diff);
	}

	static int[] factorial = {1,1,2,6,24};
	
	public static int permutations(int[] is) {
		int permutations = 120;
		int like = 1;
		for (int i = 1; i < 5; i++) {
			if (is[i-1] == is[i]) {
				like++;
			} else {
				permutations/=factorial[like];
				like = 1;
			}
		}
		
		return permutations/factorial[like];
	}

	public static int[] sort(int[] array) {
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
	
	public static long code(int[] inc) {
		long res = 0;
		for (int i = 4; i >= 0; i--) {
			res+=inc[i]*pow[i];
		}
		return res;
	}
	
	public static int sb(int[] inc) {
		if (inc[0] == Cb[0] && inc[1] == Cb[1] && inc[2] == Cb[2] && inc[3] == Cb[3] && inc[4] == Cb[4])
			return 0;
		Arrays.sort(inc);
		long memo = code(inc);
		if (COUNT.containsKey(memo)) {
			return COUNT.get(memo);
		}
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		int count = 1+sb(diff);
		COUNT.put(memo, count);
		return count;
	}
}
