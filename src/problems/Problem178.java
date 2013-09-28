package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem178 {
	static int limit;
	static Map<String, Long>[][] memoize = new HashMap[10][50];
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		
		for (limit = 40; limit > 0; limit--) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 50; j++) {
					memoize[i][j] = new HashMap<String, Long>();
				}
			}
			for (int i = 1; i <= 9; i++) {
				Set<Integer> includes = new TreeSet<Integer>();
				includes.add(i);
				sum += makeNumber(""+i, includes);
			}
			if (limit == 1)
			return sum;
		}
		return 0;
	}

	public static long makeNumber(String n, Set<Integer> i) {
		Set<Integer> includes = new TreeSet<Integer>();
		for (Integer integer : i) {
			includes.add(integer);
		}
		
		if (n.length() == limit) {
//			System.out.println(n + " " + includes);
			if (includes.size() == 10)
				return 1;
			else
				return 0;
		} else {
			
			int forrige = n.charAt(n.length()-1)-'0';
			
			if (memoize[forrige][n.length()].containsKey(includes.toString()))
				return memoize[forrige][n.length()].get(includes.toString());
			
			if (forrige == 0) {
				includes.add(1);
				long ant = makeNumber(n+1, includes);
				memoize[forrige][n.length()].put(i.toString(),ant);
				return ant;
			} else if (forrige == 9) {
				includes.add(8);
				long ant = makeNumber(n+8,includes);
				memoize[forrige][n.length()].put(i.toString(),ant);
				return ant;
			} else {
				long ant = 0;
				if (!includes.contains(forrige+1)) {
					includes.add(forrige+1);
					ant = makeNumber(n+(forrige+1),includes);
					includes.remove(forrige+1);
				} else {
					ant = makeNumber(n+(forrige+1),includes);
				} 
				includes.add(forrige-1);
				ant += makeNumber(n+(forrige-1), includes);
				memoize[forrige][n.length()].put(i.toString(),ant);
				return ant;
			}
		}
	}
}
