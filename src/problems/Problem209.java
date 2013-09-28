package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem209 {
	public static void main(String[] args) {
		for (int a = 0; a <= 1; a++) {
			for (int b = 0; b <= 1; b++) {
				for (int c = 0; c <= 1; c++) {
					for (int d = 0; d <= 1; d++) {
						for (int e = 0; e <= 1; e++) {
							for (int f = 0; f <= 1; f++) {
								T(a,b,c,d,e,f);
//								T(b,c,d,e,f,a^(b&c));
							}
						}
					}
				}
			}
		}
		System.out.println(set.size());
	}

	static Set<String> set = new HashSet<String>();
	private static void T(int a, int b, int c, int d, int e, int f) {
		String bits = ""+a+b+c+d+e+f;
		System.out.println(bits);
		set.add(bits);
	}

}
