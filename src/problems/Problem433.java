package problems;

import utils.T;

public class Problem433 {
	public static void main(String[] args) {
		System.out.println(E(1,1,0));
		T t = new T();
		long sum = 0;
		int N = 1000;
		for (int x = 1; x <= N; x++) {
			if (x%100 == 0)
				System.out.println(x);
			for (int y = 1; y <= N; y++) {
				sum += E(x,y,0);
			}
		}
		System.out.println(sum+" "+t);
	}

	private static int E(int x, int y, int accu) {
		if (y == 0)
			return accu;
		else 
			return E(y, x%y, accu+1);
	}
}
