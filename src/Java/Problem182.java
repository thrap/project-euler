package Java;

import utils.T;

public class Problem182 {
	static int p = 1009;
	static int q = 3643;
	static int phi = (p-1)*(q-1);
	public static void main(String[] args) {
		T t = new T();
		
		long sum = 0;
		for (int e = 11; e < phi; e+=12) {
			if ((e-1) % 7 == 0 || e % 7 == 0 || (e-1) % 607 == 0 || e % 607 == 0) {
				continue;
			}
			sum+=e;
		}
		System.out.println(sum + " " + t);
		System.out.println(399788195976L);
	}
}

