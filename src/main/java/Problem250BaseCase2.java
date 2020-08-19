import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

import utils.Euler;
import utils.T;

public class Problem250BaseCase2 {
	static int mod = 4;
	static int numbers = 12;
	private static int[] elements = new int[numbers];
	public static void main(String[] args) {
		T t = new T();
		Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
		for (int i = 0; i < numbers; i++) {
			elements[i] = BigInteger.valueOf(i+1).modPow(BigInteger.valueOf(i+1), BigInteger.valueOf(mod)).intValue();
			count.put(elements[i], (count.containsKey(elements[i]) ? count.get(elements[i]) : 0) + 1);
		}
		
		Map<Integer, Integer> permutations = new TreeMap<Integer, Integer>();
		for (int i = 1; i < Math.pow(2, numbers); i++) {
			int sum = sum(i);
			permutations.put(sum, (permutations.containsKey(sum) ? permutations.get(sum) : 0) + 1);
		}
		System.out.println(numbers + " " + t);
		System.out.println(count);
		System.out.println(permutations);
	}
	private static int sum(int subset) {
		String binary = Euler.toBinaryString(subset, numbers);
		
		int sum = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1')
				sum += elements[i];
		}
		return sum;
	}
}
