package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem267 {
	public static void main(String[] args) {
		System.out.println(toss(1, 1, 0));
	}
	
	private static double f = 0.5;
	
	static Map<String, Double> memoize = new HashMap<String, Double>();
	
	static int i = 0;
	
	private static double toss(double value, double prob, int toss) {
		if (toss == 1000) {
			if (++i % 100 == 0)
				System.out.println(i);
			return (value>=1000000000.0)?prob:0;
		}
		String memo = value + " " + prob + " " + toss;
		if (memoize.containsKey(memo))
			return memoize.get(memo);
		double newProb = prob*0.5;
		int newToss = toss+1;
		double bet = value*f;
		double sum = toss(value-bet, newProb, newToss) + toss(value+bet, newProb, newToss);
		memoize.put(memo, sum);
		return sum;
	}
}
