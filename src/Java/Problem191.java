package Java;

public class Problem191 {
	static long[][][][] memoize = new long[80][80][31][2];
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		sum += makeNumber("L", true);
		sum += makeNumber("O", false);
		sum += makeNumber("A", false);
//		System.out.println(sum);
		return sum;
	}

	public static long makeNumber(String n, boolean late) {
		
		if (n.length() == 1) {
			long ant = 0;
			if (!late)
				ant += makeNumber(n+"L", true);
			ant += makeNumber(n+"O", late);
			ant += makeNumber(n+"A", late);
			return ant;
		} else if (n.length() == 30) {
//			System.out.println(n);
			return 1;
		} else {
			char forste = n.charAt(n.length()-1);
			char andre = n.charAt(n.length()-2);
			if (memoize[forste][andre][n.length()][(late?1:0)] != 0)
				return memoize[forste][andre][n.length()][(late?1:0)];
			long ant = 0;
			if (forste != 'A' || andre != 'A')
				ant += makeNumber(n+"A", late);
			if (!late)
				ant += makeNumber(n+'L',true);
			ant += makeNumber(n+"O", late);
			memoize[forste][andre][n.length()][(late?1:0)] = ant;
			return ant;
		}
	}
}
