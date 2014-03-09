package Java;

import utils.Euler;

public class Problem5 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		int tall = 1;
		tall*=8;
		tall*=3;
		for (int prime : Euler.primeList(20)) {
			tall*=prime;
		}
		return tall;
	}
}
