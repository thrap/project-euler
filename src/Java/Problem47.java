package Java;

import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem47 {
	static ArrayList<Integer> primtall = new ArrayList<Integer>();
	public static void main(String[] args) {
//		init();
//		
//		for (int i = 1; true; i++) {
//			if (sjekkDivisors(i) && sjekkDivisors(i+1) && sjekkDivisors(i+2)) {
//				System.out.println(i);
//				break;
//			}
//		}
		
		System.out.println(solution());
		
	}
	
	public static int solution() {
		List<Integer> list1 = Euler.primeFactorDistinctList(1);
		List<Integer> list2 = Euler.primeFactorDistinctList(1+1);
		List<Integer> list3 = Euler.primeFactorDistinctList(1+2);
		for (int i = 1; true; i++) {
			List<Integer> list4 = Euler.primeFactorDistinctList(i+3);
			if (list1.size() == 4 && list2.size() == 4 && list3.size() == 4 && list4.size() == 4) {
				return i;
			}
			list1=list2;
			list2=list3;
			list3=list4;
		}
	}

	public static boolean sjekkDivisors(int tall) {
		int tall2 = tall + 1;
		int teller1 = 0;
		int teller2 = 0;
		for (int i = 0; i < primtall.size(); i++) {
			if (primtall.get(i) > tall/2)
				return (teller1 == teller2 && teller1 == 4);
			if (tall2%primtall.get(i) == 0)
				teller2++;
			if (tall%primtall.get(i) == 0)
				teller1++;
			if (tall2 % primtall.get(i) == 0 && tall % primtall.get(i) == 0)
				return false;
		}
		return false;
	}
	
	public static void init() {
		boolean[] primtall = Test.primtallUnder(1000000);
		
		for (int i = 2; i < primtall.length; i++) {
			if (primtall[i])
				Problem47.primtall.add(i);
		}
	}
}
