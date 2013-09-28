package problems;

public class Problem49 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static String solution() {
		boolean[] primtall = Test.primtallUnder(100000);
		for (int i = 1000; true; i++) {
			if (primtall[i] && primtall[i+3330] && primtall[i+2*3330] && i!=1487) {
				if (permutasjon(i))
					return i +""+(i+3330)+""+(i+2*3330);
			}
		}
	}

	public static boolean permutasjon(int tall) {
		if (tall+6660 > 10000)
			return false;
		String tall1=""+tall;
		String tall2=""+(tall+3330);
		String tall3=""+(tall2+3330);
		
		int[] t1 = new int[10];
		for (int i = 0; i < tall1.length(); i++) {
			t1[tall1.charAt(i)-'0']++;
		}
		int[] t2 = new int[10];
		for (int i = 0; i < tall1.length(); i++) {
			t2[tall2.charAt(i)-'0']++;
		}
		int[] t3 = new int[10];
		for (int i = 0; i < tall1.length(); i++) {
			t3[tall3.charAt(i)-'0']++;
		}
		
		for (int i = 0; i < t3.length; i++) {
			if (t1[i] != t2[i] || t1[i] != t3[i])
				return false;
		}
		
//		for (int i = 0; i < t3.length; i++) {
//			System.out.print(t1[i]+"");
//			System.out.print(t2[i]+"");
//			System.out.print(t3[i]+" ");
//		}
//		System.out.println(tall1 + tall2+tall3);
		return true;
	}
}
