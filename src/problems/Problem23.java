package problems;

import java.util.ArrayList;

public class Problem23 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static int solution() {

		ArrayList<Integer> abdudant = new ArrayList<Integer>();
		for (int i = 1; i < 30000; i++) {
			if (divisorSum(i) > i)
				abdudant.add(i);
		}
		boolean[] tall = new boolean[28123];
		for (int i = 0; i < abdudant.size(); i++) {
			int first = abdudant.get(i);
			if (first*2 >= tall.length)
				break;
			for (int j = i; j < abdudant.size(); j++) {
				if (first + abdudant.get(j) < tall.length)
					tall[first + abdudant.get(j)] = true;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < tall.length; i++) {
			if (!tall[i])
				sum+=i;
		}
		
		return sum;
	}
	public static int divisorSum(int tall){
		int sum = 1;
		for (int i = 2; i <= Math.sqrt(tall); i++) {
			if (tall % i == 0 && tall/i == i) {
				sum+=i;
			} else if (tall % i == 0) {
//				System.out.println(i + " " + tall/i);
				sum+=i+tall/i;
			}
		}
		return sum;
	}
}
