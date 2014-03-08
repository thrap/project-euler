package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem396 {
	/**
	 * se hva som skjer paa n = 8
	 * 
	 * virker som foerste tall ikke har en dritt og si, bare teller ned sakte men sikkert
	 * og andre tall teller ned like hver gang foerste gaar til 0
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int n = 1; n <= 8; n++) {
			long g = n;
			int k;
			long forrigeDiff = 0;
			long diff = -2;
			long forrige;
			long delta = 0;
			for (k = 2; g!=0; k++) {
				forrigeDiff = diff;
				forrige = g;
				
				
				List<Long> list = new ArrayList<Long>();
				while(g != 0) {
					list.add(g%k);
					g = g/k;
				}
				for (int i = 0; i < list.size(); i++) {
					g += list.get(i)*Math.pow(k+1, i);
				}
				g-=1;

				
				diff = g-forrige;
				if (list.get(0) > 5 && delta == diff - forrigeDiff) {
					long ant = list.get(0)-1;
					k+=ant;
					g+=diff*ant+delta*(ant*(ant+1))/2;
					System.out.println(k + ": " +g);
				}
				
				delta = diff-forrigeDiff;
				if (k > 10000000) {
					System.out.println(158329712148476L);
					System.out.println(k + " (" + (System.currentTimeMillis()-start)+"ms)");
					System.exit(0);
				}
			}
			sum += (k-2);
			System.out.println(n + ": "+ (k-2));
		}
		System.out.println(sum);
	}
}
