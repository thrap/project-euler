package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Euler;

public class Problem348 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		int count = 0;
		List<Long> palinList = new ArrayList<Long>();
		
		for (int i = 1; true; i++) {
			String tall = ""+i;
			StringBuilder sb = new StringBuilder(tall);
			for (int j = tall.length()-2; j >= 0 ; --j) {
				sb.append(tall.charAt(j));
			}
			long palin = Long.parseLong(sb.toString());
			
			
			if (count(palin) == 4) {
				
				palinList.add(palin);
				count++;
				if (count == 5) {
//					System.out.println(palin);
					break;
				}
			}
		}
		long biggest = Long.MAX_VALUE;
		for (int i = 1; true; i++) {
			String tall = ""+i;
			StringBuilder sb = new StringBuilder(tall);
			for (int j = tall.length()-1; j >= 0 ; --j) {
				sb.append(tall.charAt(j));
			}
			long palin = Long.parseLong(sb.toString());
			if (palin > biggest)
				break;
			if (count(palin) == 4) {
//				System.out.println(palin);
				palinList.add(palin);
				Collections.sort(palinList);
				palinList.remove(palinList.size()-1);
				biggest = palinList.get(palinList.size()-1);
			}
		}
		long sum = 0;
		for (Long long1 : palinList) {
			sum+=long1;
		}
//		System.out.println(palinList);
//		System.out.println(sum);
		return sum;
	}

	public static long count(long palin) {
		int teller = 0;
		for (long j = 2; j*j*j < palin; ++j) {
			if (Euler.isPerfectSquare(palin - j*j*j))
				++teller;
		}
		return teller;
	}
}
