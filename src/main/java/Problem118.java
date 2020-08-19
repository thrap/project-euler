import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Euler;

public class Problem118 {
	
	private static final List<Integer> LIST = Euler.primeList(100000);
	
	static int[] perm = {1,2,3,4,5,6,7,8,9};
	static Set<String> set = new HashSet<String>();
	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n == 2)
			return true;
		int sqrt = 1+(int)Math.sqrt(n);
		for (int prime : LIST) {
			if (prime > sqrt)
				return true;
			
			if (n%prime == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
//		for (String string : set) {
//			System.out.println(string);
//		}
	}
	
	public static long solution() {
		while (Euler.permute(perm, perm.length)) {
			if (p(0,9)){
				int[] a = {t(0,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,8) && p(8,9)){
				int[] a = {t(0,8) ,t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			
			if (p(0,7) && p(7,9)){
				int[] a = {t(0,7) ,t(7,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,7) && p(7,8) && p(8,9)){
				int[] a = {t(0,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			if (p(0,6) && p(6,9)){
				int[] a = {t(0,6),t(6,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,6) && p(6,8) && p(8,9)){
				int[] a = {t(0,6),t(6,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,6) && p(6,7) && p(7,8) && p(8,9)) {
				int[] a = {t(0,6),t(6,7),t(7,8) ,t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			if (p(0,5) && p(5,9)) {
				int[] a = {t(0,5), t(5,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,5) && p(5,8) && p(8,9)){
				int[] a = {t(0,5), t(5,8), t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,5) && p(5,7)&&p (7,9)){
				int[] a = {t(0,5) ,t(5,7),t(7,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,5) &&p(5,7) &&p(7,8) &&p(8,9)){
				int[] a = {t(0,5) ,t(5,7) ,t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,5) && p(5,6) &&p(6,7) &&p(7,8) &&p(8,9)){
				int[] a = {t(0,5) ,t(5,6) ,t(6,7) ,t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			
			
			if (p(0,4) &&p(4,8)&&p (8,9)){
				int[] a = {t(0,4) ,t(4,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,4)&&p (4,7)&&p (7,9)){
				int[] a = {t(0,4),t(4,7),t(7,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,4)&&p (4,7) &&p(7,8)&&p (8,9)){
				int[] a = {t(0,4),t(4,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,4)&&p (4,6)&&p (6,8) &&p(8,9)){
				int[] a = {t(0,4),t(4,6),t(6,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,4) &&p(4,6) &&p(6,7)&&p (7,8) &&p(8,9)){
				int[] a = {t(0,4) ,t(4,6) ,t(6,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			
			
			if (p(0,3) &&p(3,6) &&p(6,9)) {
				int[] a = {t(0,3),t(3,6),t(6,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,3) &&p(3,6) &&p(6,8)&&p (8,9)){
				int[] a = {t(0,3),t(3,6) ,t(6,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,3)&& p(3,6) &&p(6,7) &&p(7,8) &&p(8,9)) {
				int[] a = {t(0,3),t(3,6),t(6,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,3)&&p (3,5) &&p(5,7) &&p(7,9)) {
				int[] a = {t(0,3),t(3,5) ,t(5,7) ,t(7,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,3) &&p(3,5)&&p (5,7)&&p (7,8) &&p(8,9)){
				int[] a = {t(0,3) ,t(3,5),t(5,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,3)&&p (3,5) &&p(5,6) &&p(6,7)&&p (7,8) &&p(8,9)){
				int[] a = {t(0,3),t(3,5),t(5,6),t(6,7),t(7,8) ,t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			
			if (p(0,2) &&p(2,4)&&p (4,6)&&p (6,8)&&p (8,9)){
				int[] a = {t(0,2),t(2,4),t(4,6),t(6,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
			if (p(0,2)&&p (2,4) &&p(4,6)&&p (6,7) &&p(7,8)&&p (8,9)){
				int[] a = {t(0,2),t(2,4),t(4,6),t(6,7),t(7,8),t(8,9)};
				Arrays.sort(a);
				set.add(Arrays.toString(a));
			}
/*			
			xxxxxxxxx
			(0,9)
			
			xxxxxxxx x
			(0,8) (8,9)
			
			xxxxxxx xx
			(0,7) (7,9)
			xxxxxxx x x
			(0,7) (7,8) (8,9)
			
			xxxxxx xxx
			(0,6) (6,9)
			xxxxxx xx x
			(0,6) (6,8) (8,9)
			xxxxxx x x x
			(0,6) (6,7) (7,8) (8,9)
			
			xxxxx xxxx
			(0,5) (5,9)
			xxxxx xxx x
			(0,5) (5,8) (8,9)
			xxxxx xx xx
			(0,5) (5,7) (7,9)
			xxxxx xx x x
			(0,5) (5,7) (7,8) (8,9)
			xxxxx x x x x
			(0,5) (5,6) (6,7) (7,8) (8,9)
			
			xxxx xxxx x
			(0,4) (4,8) (8,9)
			xxxx xxx xx
			(0,4) (4,7) (7,9)
			xxxx xxx x x
			(0,4) (4,7) (7,8) (8,9)
			xxxx xx xx x
			(0,4) (4,6) (6,8) (8,9)
			xxxx xx x x x
			(0,4) (4,6) (6,7) (7,8) (8,9)
			
			xxx xxx xxx
			(0,3) (3,6) (6,9)
			xxx xxx xx x
			(0,3) (3,6) (6,8) (8,9)
			xxx xxx x x x
			(0,3) (3,6) (6,7) (7,8) (8,9)
			xxx xx xx xx
			(0,3) (3,5) (5,7) (7,9)
			xxx xx xx x x
			(0,3) (3,5) (5,7) (7,8) (8,9)
			xxx xx x x x x
			(0,3) (3,5) (5,6) (6,7) (7,8) (8,9)
			
			
			xx xx xx xx x
			(0,2) (2,4) (4,6) (6,8) (8,9)
			xx xx xx x x x
 			(0,2) (2,4) (4,6) (6,7) (7,8) (8,9)
 */
//			if (isPrime(tall(0,9)))
//				System.out.println(tall(0,9));
//			System.out.println(tall(perm));
		}
		return set.size();
	}

	public static boolean p(int start, int slutt) {
		return isPrime(t(start,slutt));
	}
	
	public static int t(int start, int slutt) {
		int tall = perm[start];
		for (int i = 1; start+i < slutt; i++) {
			tall*=10;
			tall+=perm[start+i];
		}
		return tall;
	}
}
