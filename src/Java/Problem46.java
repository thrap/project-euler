package Java;

import java.util.HashSet;
import java.util.Set;

public class Problem46 {
	static boolean[] primtall = Test.primtallUnder(1000000);
	static Set<Integer> map = new HashSet<Integer>();
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		for (int i = 1; i < 1000; i++) {
			map.add(2*i*i);
		}
		
		
		
//		sjekk(9);
		
		for (int i = 3; i < primtall.length; i+=2) {
			if (!primtall[i])
				if (sjekk(i)) 
					return i;
		}
		return 0;
	}

	public static boolean sjekk(int tall) {
		for (int i = tall; i > 1; i--) {
			if (primtall[i]) {
				if (!map.contains(tall-i)) {
					continue;
				} else
					return false;
			}
		}
		return true;
	}
}
