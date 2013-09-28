package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem227 {
	public static void main(String[] args) {
		System.out.println(prob(1.0, 1, 0));
	}
	
	static final int PLAYERS = 100;
	static final int MAX_DIFF = PLAYERS/2;

	static final double ÅTTE_TRETTISEKSDELER = 8.0/36.0;
	static final double EN_TRETTISEKSDEL = 1.0/36.0;
	
	static Map<Double, Double> memoize = new HashMap<Double, Double>();
	
	private static double prob(double prob, int diff, int turns) {
		if(prob<0.00000000000001)
			return 0;
		if (diff < 0)
			diff = -diff;
		else if (diff > MAX_DIFF)  {
			diff = PLAYERS-diff;
		}
		if (diff == 0)
			return prob*turns;
		//0, begge 0 eller left+right = 18/36 = 0.5
		//1, en left, andre 0 = 8/36 = 2/9
		//-1 en right, andre 0 = 8/36
		//2, begge left = 1/36
		//-2 begge right = 1/36
		double memo = turns*100+diff+prob;
		if (memoize.containsKey(memo))
			return memoize.get(memo);
		++turns;
		double expected = 0;
		expected += prob(prob*0.5, diff, turns);
		expected += prob(prob*ÅTTE_TRETTISEKSDELER, diff+1, turns);
		expected += prob(prob*ÅTTE_TRETTISEKSDELER, diff-1, turns);
		expected += prob(prob*EN_TRETTISEKSDEL, diff+2, turns);
		expected += prob(prob*EN_TRETTISEKSDEL, diff-2, turns);
		memoize.put(memo, expected);
		return expected;
	}
}
