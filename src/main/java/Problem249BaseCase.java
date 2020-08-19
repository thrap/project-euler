import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.Euler;
import utils.T;

public class Problem249BaseCase {
	private static List<Integer> primes = Euler.primeList(70);
	public static void main(String[] args) {
		T t = new T();
		System.out.println(primes.size());
		int count = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 1; i < Math.pow(2, primes.size()); i++) {
			int sum = sum(i);
			if(Euler.isPrime(sum)) {
				map.put(sum, (map.containsKey(sum) ? map.get(sum) : 0) + 1);
				count++;
			}
		}
		System.out.println(count + " " + t);
		System.out.println(map);
	}
	private static int sum(int subset) {
		String binary = Euler.toBinaryString(subset, primes.size());
		
		int sum = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1')
				sum += primes.get(i);
		}
		return sum;
	}
}
