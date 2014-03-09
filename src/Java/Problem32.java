package Java;

import java.util.HashSet;
import java.util.Set;

public class Problem32 {
	public static void main(String[] args) {
		System.out.println(erPandigital(""+123578946));
		System.out.println(solution());
	}
	
	public static int solution() {
		Set<Integer> set = new HashSet<Integer>();
		int sum=0;
		for (int i = 1; i < 1000; i++) {
			for (int j = i; j < 10000; j++) {
				int produkt = j*i;
				String string = ""+produkt+""+i+""+j;
				if (string.length()>9)
					break;
				if (erPandigital(string)) {
					if (!set.contains(produkt)) {
						sum+=produkt;
						set.add(produkt);
					}
				}
			}
		}
		return sum;
	}

	public static boolean erPandigital(String tall) {

		String s = ""+tall;
		if (s.length() != 9)
			return false;
	    boolean[] A = new boolean[s.length()];
	    
	    for (int i = 0; i < s.length(); i++) {
	    	if (s.charAt(i) == '0')
	            return false;
	    	else if (s.charAt(i)-'1' >= A.length)
	    		return false;
	        if (!A[s.charAt(i)-'1']) 
	            A[s.charAt(i)-'1'] = true;
	        else if (A[s.charAt(i)-'1'])
	            return false;
		}
	    return true;
	}
}
