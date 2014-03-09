package Java;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Problem418Helper {
	public static void main(String[] args) {

		nestedFor(0);
		
		
//		for (String string : set) {
//			System.out.println(string);
//			System.out.println();
//		}
		System.out.println("Trenger: "+set.size());
		System.out.println("Fr:     "+count);
	}
	
	static int[] pows = {4,2,1,1,1,1,1,1,1,2}; 
	static int[] pows1 = new int[pows.length];
	static int[] pows2 = new int[pows.length];
	static int[] pows3 = new int[pows.length];
	
	static int count = 0;
	static Set<String> set = new TreeSet<String>();
	
	private static void nestedFor(int i) {
		if (i == pows.length) {
			String[] strings =  {Arrays.toString(pows1), Arrays.toString(pows2), Arrays.toString(pows3)};
			Arrays.sort(strings);
			set.add(strings[0]+"\n"+strings[1]+"\n"+strings[2]);
			count++;
			return;
		}
		int pow = pows[i];
		
		for (int pow1 = 0; pow1 <= pow; pow1++) {
			pows1[i] = pow1;
			for (int pow2 = 0; pow2+pow1 <= pow; pow2++) {
				pows2[i] = pow2;
				int pow3 = pow-pow1-pow2;
				pows3[i] = pow3;
				nestedFor(i+1);
			}
		}
	}
	
}
