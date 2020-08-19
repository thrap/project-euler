import java.util.ArrayList;

public class Problem69wtf {
	
	static ArrayList<Integer> primtall = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		boolean[] tall = Test.primtallUnder(1000000);
		for (int i = 2; i < tall.length; i++) {
			if (tall[i])
				primtall.add(i);
		}
//		System.out.println(primtall.size());
		
		double minste = Double.MAX_VALUE;
		int b = 0;
		for (int i = 2; i < 1000000; i++) {
			int q = fi(i);
			String a = ""+i;
			String phi = ""+q;
			int[] count = new int[10];
			int[] count2 = new int[10];
			for (int j = 0; j < a.length(); j++) {
				count[a.charAt(j)-'0']++;
			}
			for (int j = 0; j < phi.length(); j++) {
				count2[phi.charAt(j)-'0']++;
			}
			for (int j = 0; j < count2.length; j++) {
				if (count[j] != count2[j]) {
					break;
				}
				if (j == count2.length-1) {
					if ((double)i/q < minste) {
						minste = (double)i/q;
						System.out.println(minste + "  " + i + " " + phi);
					}
				}
			}
			if (i%100000 == 0) {
				System.out.println(i);
			}
		}
		System.out.println(b+": "+minste);
		
		
	}
	
	public static int fi(int n)  { 
      int result = n; 
      for(int i=2;i*i <= n;i++)  { 
        if (n % i == 0) 
        	result -= result / i; 
        while (n % i == 0) 
        	n /= i; 
      } 
      if (n > 1) 
    	  result -= result / n; 
      return result; 
    } 
}

