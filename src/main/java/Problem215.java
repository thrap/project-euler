import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Tuple {
	public final int to;
	public final int tre;
	public List<String> permutations;

	public Tuple(int x, int y) {
		this.to = x;
		this.tre = y;
		permutations();
	}
	
	public String toString() {
		return ""+to + "x2 " + tre + "x3" + " ("+perm()+")";
	}
	
	private long perm() {
		return (fac(to+tre))/(fac(to)*fac(tre));
	}
	
	private long fac(int n) {
		long sum = 1;
		for (int i = 2; i <= n; i++) 
			sum*=i;
		return sum;
	}
	
	public List<String> getPermutations() {
		return permutations;
	}
	
	private void permutations() {
		permutations = new ArrayList<String>();
		for (int i = 0; i < Math.pow(2, to+tre); i++) {
			String s = Integer.toBinaryString(i);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < to+tre - s.length(); j++) {
				sb.append('0');
			}
			sb.append(s);
			if (legal(sb.toString())) {
				String denne = sb.toString();
				Problem215.map.put(denne,new HashSet<String>());
				for (String perm : Problem215.map.keySet()) {
					if (passer(denne, perm)) {
						Problem215.map.get(perm).add(denne);
						Problem215.map.get(denne).add(perm);
					}
				}
				permutations.add(denne);
			}
		}
	}
	
	private boolean passer(String s1, String s2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == '0')
				sb1.append("2|");
			else
				sb1.append("33|");
		}
		
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == '0')
				sb2.append("2|");
			else
				sb2.append("33|");
		}
		
		for(int i = 0; i<sb1.length()-1; ++i) {
			if (sb1.charAt(i) == '|' && sb2.charAt(i) == '|') {
				return false;
			}
		}
		return true;
	}
	
	private boolean legal(String s) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0')
				a++;
			else
				b++;
		}
		return a==to && b==tre;
	}
}

public class Problem215 {
	
	public static Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	static long a = 0;
	static int y = 10;
	static int x = 32;

	public static void main(String[] args) {

		System.out.println(solution());
	}
	
	public static long solution() {
		// Bygg en og en linje av gangen FAKK DU ER SMART AS ;)
		List<Tuple> list = new ArrayList<Tuple>();

		for (int to = 0; to * 2 <= x; to++) {
			for (int tre = 0; 2 * to + 3 * tre <= x; tre++) {
				if (to * 2 + tre * 3 == x) {
//							System.out.println(to + " " + tre);
					list.add(new Tuple(to, tre));
				}
			}
		}

//				System.out.println(list);
		
		long sum = 0;
		for (String tuple : map.keySet()) {
//					System.out.println(count++ + "/"+map.keySet().size());
			sum+=perm(tuple,1);
		}
//				System.out.println(map);
		return sum;
	}

	static HashMap<String, Long> memo = new HashMap<String, Long>();
	
	public static long perm(String s, int antall) {
		String mem = s+" "+antall;
		if (memo.containsKey(mem))
			return memo.get(mem);
		if (antall == y) {
			a++;
			return 1;
		}
		long sum = 0;
		for (String perm : map.get(s)) {
			sum+=perm(perm, antall+1);
		}
		memo.put(mem, sum);
		return sum;
	}
}
