package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem141treg {
	public static void main(String[] args) {
		long limit = 10000000000L;
		List<Long> list = new ArrayList<Long>();
		for (long i = 1; i*i < limit; i++) {
			list.add(i*i);
		}
		
		long sum = 0;
		int teller = 0;
		for (Long number : list) {
			if (++teller % 1000 == 0) System.out.println(teller + "/"+list.size() + " " + number);
			if (isProgressive(number)) {
				System.out.println(number);
				sum+=number;
			}
		}
		//husk 9 lol
		System.out.println(sum+9);
	}

	private static boolean isProgressive(Long number) {
		long q = number;
		for (long d = 25; d <= (q=number/d); d+=25) {
			long r = number % d;
			
			//ET TALL ER PROGRESSIVE OM r*q == d*d
			if (r*q == d*d) {
				return true;
			}
		}
		for (long d = 9; d <= (q=number/d); d+=9) {
			long r = number % d;
			
			//ET TALL ER PROGRESSIVE OM r*q == d*d
			if (r*q == d*d) {
				return true;
			}
		}
		for (long d = 4; d <= (q=number/d); d+=4) {
			long r = number % d;
			
			//ET TALL ER PROGRESSIVE OM r*q == d*d
			if (r*q == d*d) {
				return true;
			}
		}
		return false;
	}
}
