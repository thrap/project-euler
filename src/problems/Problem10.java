package problems;

import utils.Euler;
import utils.T;

public class Problem10 {

	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() + " " + t);
	}
	
	public static long solution() {
		boolean[] prime = Euler.primeArray(2000000);
		long sum = 2;
		for (int i = 3; i < prime.length; i+=2) {
			if (prime[i])
				sum+=i;
		}
		return sum;
	}
}
