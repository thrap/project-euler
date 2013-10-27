package problems;

import utils.T;

public class Problem442BaseCase {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(E(500000) + " "+t);
	}

	private static long E(int n) {
		int count = 0;
		
		for (int i = 1; true; i++) {
			if (isElevenFree(i)) {
				count++;
			} 
			if (count == n)
				return i;
		}
	}

	private static boolean isElevenFree(int i) {
		String number = ""+i;
		
		for (int j = 11; j <= i; j*=11) {
			if (number.contains(""+j))
				return false;
		}
		return true;
	}
}
