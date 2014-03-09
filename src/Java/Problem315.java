package Java;

import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem315 {
	
	static int[] cost = new int[] {6,2,5,5,4,5,6,4,7,6};
	static int[][] sam = new int[][] {
		{1,	0, 1, 1, 1, 1, 1}, //0
		{0,	0, 0, 0, 0, 1, 1}, //1
		{1,	1, 1, 0, 1, 1, 0}, //2
		{1,	1, 1, 0, 0, 1, 1},//3
		{0,	1, 0, 1, 0, 1, 1}, //4
		{1,	1, 1, 1, 0, 0, 1}, //5
		{1,	1, 1, 1, 1, 0, 1}, //6
		{1,	0, 0, 1, 0, 1, 1}, //7
		{1,	1, 1, 1, 1, 1, 1}, //8
		{1,	1, 1, 1, 0, 1, 1}, //9
	};
	
	public static void main(String[] args) {
		System.out.println(solution());
//		int i = 1999993;
//		System.out.println(max(roots(i)));
//		System.out.println(sam(roots(i)));
//		System.out.println(felles(137,7));
		
	}
	
	public static long solution() {
		boolean[] prime = Euler.primeArray(20000000);
		long sum = 0;
		for (int i = 10000000; i < prime.length; i++) {
			if (prime[i]) {
				sum+=diff(i);
			}
		}
//		System.out.println(sum);
		return sum;
	}

	public static long diff(int i) {
		List<Integer> roots = roots(i);
		return sam(roots)-max(roots);
	}
	
	public static long sam(List<Integer> list) {
		long sum = 0;
		for (Integer integer : list) {
			sum+=paa(integer, 0);
			sum+=av(integer, 0);
//			for (int i = 0; i < number.length(); i++) {
//				int digit = number.charAt(i)-'0';
//				sum+=2*cost[digit];
//			}
		}
		return sum;
	}
	
	public static long max(List<Integer> list) {
		int sum = 0;
		int forrige = 0;
		for (int i = 0; i < list.size(); i++) {
			int tall = list.get(i);
			int neste = (i+1==list.size()?0:list.get(i+1));
			sum+=paa(tall, forrige);
			sum+=av(tall, neste);
			forrige = tall;
		}
		return sum;
	}
	
	public static long paa(int tall, int forrige) {
		long sum = 0;
		if (forrige == 0) {
			String number = ""+tall;
			for (int i = 0; i < number.length(); i++) {
				int digit = number.charAt(i)-'0';
				sum+=cost[digit];
			}
			return sum;
		}
		String number = ""+tall;
		//regne ut de som ikke er felles
		for (int i = 0; i < number.length(); i++) {
			int digit = number.charAt(i)-'0';
			sum+=cost[digit];
		}
		return sum-felles(forrige, tall);
	}
	
	public static long felles(int tall, int neste) {
		String number = ""+tall;
		String next = ""+neste;
		int diff = number.length()-next.length();
		int felles = 0;
		for (int i = 0; i < next.length(); i++) {
			int d1 = number.charAt(i+diff)-'0';
			int d2 = next.charAt(i)-'0';
			
			for (int j = 0; j < sam[0].length; j++) {
				if (sam[d1][j] == sam[d2][j] && sam[d2][j] == 1)
					felles++;
			}
//			System.out.println(""+d1+"->"+d2);
		}
//		System.out.println(number + " " + next + " " +diff + " "+sum);
		return felles;
	}
	
	public static long av(int tall, int neste) {
		long sum = 0;
		if (neste == 0) {
			String number = ""+tall;
			for (int i = 0; i < number.length(); i++) {
				int digit = number.charAt(i)-'0';
				sum+=cost[digit];
			}
			return sum;
		}
		String number = ""+tall;
		//regne ut de som ikke er felles
		for (int i = 0; i < number.length(); i++) {
			int digit = number.charAt(i)-'0';
			sum+=cost[digit];
		}
		return sum-felles(tall, neste);
	}
	
	public static List<Integer> roots(int n) {
		List<Integer> roots = new ArrayList<Integer>();
		roots.add(n);
		return roots(roots);
	}
	
	public static List<Integer> roots(List<Integer> roots) {
		int number = roots.get(roots.size()-1);
		if (number < 10)
			return roots;
		int digital = digital(number);
		roots.add(digital);
		return roots(roots);
	}
	
	public static int digital(int n) {
		String number = ""+n;
		int res = 0;
		for (int i = 0; i < number.length(); i++) {
			res+=number.charAt(i)-'0';
		}
		return res;
	}
}
