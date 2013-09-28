package problems;

import utils.Euler;

public class Problem423 {
	public static void main(String[] args) {
		int n = 15;
		int pi = Euler.bedrePrimeList(n).size();
		
		System.out.println(Euler.bedrePrimeList(n));
		System.out.println(pi);
	}
}
