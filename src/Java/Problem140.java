package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem140 {
	public static void main(String[] args) {
		Set<Long> nuggets = new TreeSet<Long>();

		for (int i = 1; i < 20; i++) {
			nuggets.add(pissNugget(i));
			nuggets.add(fibNugget(i));
		}
		
		int count = 0;
		long sum = 0;
		for (Long nugget : nuggets) {
			if (nugget > 0) {
				count++;
				System.out.println(count + ": " + nugget);
				sum+=nugget;
			}
			if (count >= 30) 
				break;
		}
		System.out.println(sum);
	}
	
	public static long pissNugget(int i) {
		return sum(pissonacci(2*i-1), pissonacci(2*i));
	}
	
	public static long fibNugget(int i) {
		return sum(fibonacci(2*i-1), fibonacci(2*i));
	}

	public static Map<Integer, Long> fibMemo = new HashMap<Integer, Long>();

	public static long fibonacci(int i) {
		if (fibMemo.containsKey(i))
			return fibMemo.get(i);
		if (i <= 1)
			return 1;
		else {
			long memo = fibonacci(i - 1) + fibonacci(i - 2);
			fibMemo.put(i, memo);
			return memo;
		}
	}

	public static Map<Integer, Long> pissMemo = new HashMap<Integer, Long>();

	public static long pissonacci(int i) {
		if (pissMemo.containsKey(i))
			return pissMemo.get(i);
		if (i == 1)
			return 2;
		else if (i == 2)
			return 5;
		else {
			long memo = pissonacci(i - 1) + pissonacci(i - 2);
			pissMemo.put(i, memo);
			return memo;
		}
	}

	public static long sum(long a, long b) {
		if ((a * (3 * a + b)) % (b * b - a * a - a * b) != 0)
			return 0;
		return (a * (3 * a + b)) / (b * b - a * a - a * b);
	}
}
