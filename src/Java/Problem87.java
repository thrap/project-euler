package Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem87 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		boolean[] primtall2 = Test.primtallUnder(8000);
		ArrayList<Integer> primtall = new ArrayList<Integer>();
	
		for (int i = 2; i < primtall2.length; i++) {
			if (primtall2[i])
				primtall.add(i);
		}
//		System.out.println(primtall);
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < primtall.size(); i++) {
			int a = primtall.get(i);
			a = a*a;
			int b = primtall.get(i);
			b = b*b*b;
			int c = primtall.get(i);
			c = c*c*c*c;
			if (c > 50000000) {
//				System.out.println(i);
				break;
			}
		}
		
		for (int i = 0; i <=908; i++) {
			for (int j = 0; j <=73; j++) {
				for (int j2 = 0; j2 <= 23; j2++) {
					int a = primtall.get(i);
					a = a*a;
					int b = primtall.get(j);
					b = b*b*b;
					int c = primtall.get(j2);
					c = c*c*c*c;
					if (a+b+c < 50000000)
						set.add(a+b+c);
				}
			}
		}
		return set.size();
	}
}
