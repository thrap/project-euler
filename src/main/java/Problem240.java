import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem240 {
	
	private static final int SUM = 70;
	private static final int MAX = 12;
	private static final int DICE = 20;
	private static final int TOP_DICE = 10;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long solution() {
		return roll(1, MAX, 0);
	}

	static int[] DIE = new int[DICE];
	
	private static long roll(int start, int max, int n) {
		if (n==TOP_DICE) {
			return checkTopDice();
		} else if (n == DICE) {
			return permutations(DIE);
		}
		long sum = 0;
		for (int die = start; die <= max; die++) {
			DIE[n] = die;
			sum += roll(die, max, n+1);
		}
		return sum;
	}
	
	private static long checkTopDice() {
		if (check(DIE)) {
			long sum = 0;
			for (int die = 1; die <= DIE[0]; die++) {
				DIE[TOP_DICE] = die;
				sum+=roll(die, DIE[0], TOP_DICE+1);
			}
			return sum;
		} else {
			return 0;
		}
	}

	private static long permutations(int...is) {
		int[] count = new int[MAX+1];
		for (int i : is) {
			++count[i];
		}
		BigInteger under = BigInteger.ONE;
		for (int i : count) {
			if (i >= 2)
				under = under.multiply(Problem240rofl.factorial(i));
		}
		return divide(under);
	}
	
	private static BigInteger OVER = Problem240rofl.factorial(DICE);
	private static Map<BigInteger, Long> memoize = new HashMap<BigInteger, Long>();
	
	private static long divide(BigInteger under) {
		if (memoize.containsKey(under))
			return memoize.get(under);
		long asd = OVER.divide(under).longValue();
		memoize.put(under, asd);
		return asd;
	}

	private static boolean check(int... is) {
		long sum = 0;
		for (int i = 0; i < TOP_DICE; i++) {
			sum+=is[i];
		}
		return sum == SUM;
	}
}
