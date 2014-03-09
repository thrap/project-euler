package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem151raskOgFeil {
	public static void main(String[] args) {
		int[] first = cut.get(1);
		long[] res = ones(first);
		System.out.println(Arrays.toString(res));
		double prob = ((double)res[0]/(double)res[1]);
		System.out.println(Math.pow(1-prob, 2));
	}
	
	private static Map<String, long[]> memoize = new HashMap<String, long[]>();
	
	private static long[] ones(int[] envelope) {
		
		Arrays.sort(envelope);
		String memo = Arrays.toString(envelope);
		if (memoize.containsKey(memo))
			return memoize.get(memo);
			
		long sum = 0;
		long days = 1;
		if (envelope.length == 1) {
			if (envelope[0] == 5) {
				return new long[]{0,0};
			}
			sum++;
		}
		for (int i = 0; i < envelope.length; i++) {
			int[] copy = copyWithout(envelope, i);
			long[] test = ones(copy);
			sum += test[0];
			days += test[1];
		}
		long[] res = new long[] {sum, days};
		memoize.put(memo, res);
		return res;
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
	
	private static List<Integer> cut(int[] envelope, int index) {
		List<Integer> newPapers = new ArrayList<Integer>();
		int Ai = envelope[index];
		while (++Ai <= 5) {
			newPapers.add(Ai);
		}
		return newPapers;
	}
}
