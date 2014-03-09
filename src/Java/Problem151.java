package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem151 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static String solution() {
		double result = ones(CUTS.get(1), 1, 0);

		int verdi = (int)(result*Math.pow(10, 7));
		verdi+=5;
		verdi/=10;
		return "0."+verdi;
	}

	static int ANTALL = 1;
	
	static Map<String, Double> MEMOIZE = new HashMap<String, Double>();
	
	private static double ones(int[] envelope, double prob, int funnet) {
		Arrays.sort(envelope);
		if (allFives(envelope)) {
			return funnet*prob;
		}
		String memo = Arrays.toString(envelope) + " " + prob + " "+funnet;
		if (MEMOIZE.containsKey(memo))
			return MEMOIZE.get(memo);
		if (envelope.length == 1) {
			funnet++;
		}
		double thisProb = prob*(1.0/envelope.length);
		double sum = 0;
		for (int i = 0; i < envelope.length; i++) {
			int[] copy = copyWithout(envelope, i);
			sum+=ones(copy, thisProb, funnet);
		}
		MEMOIZE.put(memo, sum);
		return sum;
	}
	
	private static boolean allFives(int[] envelope) {
		for (int i = 0; i < envelope.length; i++) {
			if (envelope[i] != 5)
				return false;
		}
		return true;
	}

	private static int[] copyWithout(int[] envelope, int index) {
		int[] newPapers = CUTS.get(envelope[index]);
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
	
	static Map<Integer, int[]> CUTS = new HashMap<Integer, int[]>();
	
	static {
		CUTS.put(1, new int[]{2,3,4,5});
		CUTS.put(2, new int[]{3,4,5});
		CUTS.put(3, new int[]{4,5});
		CUTS.put(4, new int[]{5});
		CUTS.put(5, new int[0]);
	}
}
