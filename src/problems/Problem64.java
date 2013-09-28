package problems;

import utils.Euler;

public class Problem64 {

	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int limit = 1000;
		int[] seq = new int[limit];
		int tellersum = 0;
		int hoy = 0;
		for (int tall = 2; tall <= 10000; ++tall) {
			if (Euler.isPerfectSquare(tall))
				continue;
			int sqrt = (int)Math.sqrt(tall);
			int temp = sqrt;
			int nevner = 1;
			for (int i = 0; i < limit; ++i) {
				int teller = (sqrt + temp);
				nevner = (tall-temp*temp)/nevner;
				
//				System.out.println(teller/nevner);
				temp = sqrt-teller%nevner;
				seq[i] = teller/nevner;
			}
			for (int rep = 1; rep < seq.length; rep++) {
				boolean right = true;
				for (int i = 0; i < seq.length-rep; i++) {
					if (seq[i] != seq[i+rep])
						right = false;
				}
				if (right) {
					if (rep > hoy) {
						hoy = rep;
					}
					if (rep % 2 == 1)
						++tellersum;
					break;
				}
			}
		}
		return tellersum;// + " (høyeste repeat: " + hoy+")");
	}
}
