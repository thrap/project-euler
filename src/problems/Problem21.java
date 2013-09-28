package problems;

import utils.Euler;

public class Problem21 {
	public static int d(int n) {
		int sum=-n;
		for (int t : Euler.divisorList(n)) 
			sum+=t;
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static int solution() {
		int sum = 0;
		for (int i = 2; i < 10000; i++) 
			if (d(i) != i && i == d(d(i))) 
				sum+=i;
		return sum;
	}
}
