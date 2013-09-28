package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem151tregOgFeil {
	public static void main(String[] args) {
		int[] first = cut.get(3);
		long ones = 0;
		for (int i = 0; i < first.length; i++) {
			ones += ones(copyWithout(first, i));
		}
		
		System.out.println(ones);
		System.out.println(days);
		System.out.println(((double)ones/(double)days));
	}
	
	static long days = 0;
	
	private static long ones(int[] envelope) {
		Arrays.sort(envelope);
		long sum = 0;
		if (envelope.length == 1) {
			if (envelope[0] == 5) {
				return 0;
			}
			sum++;
		}
		System.out.println(Arrays.toString(envelope));
		days++;
		for (int i = 0; i < envelope.length; i++) {
			int[] copy = copyWithout(envelope, i);
			sum+=ones(copy);
		}
		return sum;
	}
	
	private static int[] copyWithout(int[] envelope, int index) {
		int[] newPapers = cut.get(envelope[index]);
		int[] newArray = new int[envelope.length+newPapers.length-1];
		int start = envelope.length-1;
		boolean found = false;
		for (int i = 0; i < start; i++) {
			if (i == index) found=true;
			newArray[i] = envelope[i+(found?1:0)];
		}
		
		for (int i = 0; i < newPapers.length; i++) {
			newArray[start+i] = newPapers[i];
		}
		
		return newArray;
	}
	
	static Map<Integer, int[]> cut = new HashMap<Integer, int[]>();
	
	static {
		cut.put(1, new int[]{2,3,4,5});
		cut.put(2, new int[]{3,4,5});
		cut.put(3, new int[]{4,5});
		cut.put(4, new int[]{5});
		cut.put(5, new int[0]);
	}
}
