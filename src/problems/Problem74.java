package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem74 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		int teller = 0;
		for (int i = 0; i < 1000000; i++) {
			long tall = verdi(i);
			Set<Long> map = new HashSet<Long>();
			while (true) {
				if (map.contains(tall)) {
					if(map.size() >= 59) {
//						System.out.println(i+": "+map.size());
						teller++;
					}
					break;
				}
				map.add(tall);
				tall = verdi(tall);
			}
		}
		return teller;
	}

	public static long verdi(long tall) {
		String string = ""+tall;
		long verdi = 0;
		for (int i = 0; i < string.length(); i++) {
			verdi+=fakultet(string.charAt(i)-'0');
		}
		return verdi;
	}
	
	public static int fakultet(int j) {
		int sum = 1;
		for (int i = 1; i <= j; i++) {
			sum *= i;
		}
		return sum;
	}
}
