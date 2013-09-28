package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem396BaseCase {
	/**
	 * se hva som skjer på n = 8
	 * 
	 * virker som første tall ikke har en dritt og si, bare teller ned sakte men sikkert
	 * og andre tall teller ned like hver gang første går til 0
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
				if (n == 8 && k==12582910) {
					System.out.println(list + " "+g + " "+n);
					System.out.println(diff - forrigeDiff);
					System.out.println(forrigeDiff + " " + diff);
					System.out.println(g);
					System.out.println(" (" + (System.currentTimeMillis()-start)+"ms)");
					System.exit(0);
				}
			}
			sum += (k-2);
			System.out.println(n + ": "+ (k-2));
		}
		System.out.println(sum);
	}
}
