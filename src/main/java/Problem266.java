import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import utils.Euler;
import utils.T;

public class Problem266 {
	
	static BigInteger goal = new BigInteger("2323218950681478446587180516177954548");
	
	public static void main(String[] args) {
		T t = new T();
		List<Integer> list = Euler.primeList(190);
		System.out.println(list.size());
		
		int skalHuske = 20;
		BigInteger[] memory = new BigInteger[(int) Math.pow(2, skalHuske)];
		
		System.out.println(memory.length);
		for (int i = 0; i < memory.length; i++) {
			if (i % 100000 == 0) 
				System.out.println(i + " / " + memory.length);
			String binary = Euler.toBinaryString(i, skalHuske);
			BigInteger tall = ONE;
			for (int j = 0; j < binary.length(); j++) {
				int prime = list.get(j);
				if (binary.charAt(j) == '1') {
					tall = tall.multiply(valueOf(prime));
				}
			}
			memory[i] = tall;
		}
		Arrays.sort(memory);
		
		int left = list.size()-skalHuske;
		BigInteger best = ZERO;
		for (int i = 0; i < Math.pow(2, left); i++) {
			String binary = Euler.toBinaryString(i, left);
			BigInteger tall = ONE;
			for (int j = 0; j < binary.length(); j++) {
				int prime = list.get(skalHuske+j);
				if (binary.charAt(j) == '1') {
					tall = tall.multiply(valueOf(prime));
				}
			}
			
			best = best.max(findBest(memory, tall));
			if (i % 100000 == 0) {
				System.out.println(i + " / " + Math.pow(2, left));
				System.out.println(best);
				System.out.println(goal);
			}
		}
		System.out.println(best.mod(TEN.pow(16)) + " " +t);
	}

	private static BigInteger findBest(BigInteger[] memory, BigInteger tall) {
//		System.out.println(tall);
//		System.out.println(goal.divide(tall));
//		System.out.println(-Arrays.binarySearch(memory, goal.divide(tall)));
		int num = Arrays.binarySearch(memory, goal.divide(tall));
		if (num < 0)
			num = -num-2;
		if (num < 0)
			return ZERO;
		return tall.multiply(memory[num]);
	}

	
}
