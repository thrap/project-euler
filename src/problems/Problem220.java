package problems;

public class Problem220 {
	public static final String a = "aRbFR";
	public static final String b = "LFaLb";
	
	public static void main(String[] args) {
		/**
		 * fact1 = hver derive gjør størrelsen 2*x+2 større
		 * 
		 */
		String d = "Fa";
		for (int i = 1; i <= 50; i++) {
			System.out.println(i+" "+d.length());
			d = derive(d);
		}
		System.out.println("halla");
	}
	
	public static String derive(String d) {
		
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < d.length(); i++) {
			char c = d.charAt(i);
			if (c == 'a')
				result.append(a);
			else if (c == 'b')
				result.append(b);
			else
				result.append(c);
		}
		return result.toString();
/*Let D0 be the two-letter string "Fa". For n1, derive Dn from Dn-1 by the string-rewriting rules:

"a"  "aRbFR"
"b"  "LFaLb"

Thus, D0 = "Fa", D1 = "FaRbFR", D2 = "FaRbFRRLFaLbFR", and so on.*/
		
	}
}
