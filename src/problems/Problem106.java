package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;


public class Problem106 {
	public static void main(String[] args) {
		int n = 12;
		Set<String> pairs = getSubsetPairs(n);
		System.out.println(pairs.size());
		
		int count = 0;
		
		for (String string : pairs) {
			String[] split = string.split("-");
			String A = split[0].trim();
			String B = split[1].trim();
			if (mustBeTested(A, B)) {
				count++;
				System.out.println(A + " - " + B);
			}
		}
		System.out.println(count);
	}
	
	private static boolean mustBeTested(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		
		if (A.length != B.length || A.length == 1) {
			return false;
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < B.length; i++) {
			if (A[i] > B[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * til future pissern: dette funker, men er lite vakker og er bare å drite i aa sette seg inn i egentlig
	 */
	public static Set<String> getSubsetPairs(int n) {
		Set<String> pairs = new TreeSet<String>();
		for (int i = 1; i < Math.pow(2, n)-1; i++) {
			List<Character> B = new ArrayList<Character>();
			List<Character> otherSet = new ArrayList<Character>();
			
			String boolString = Euler.toBinaryString(i, n);
			for (int j = 0; j < n; j++) {
				char c = (char) ('a' + j);
				if (boolString.charAt(j) == '0') {
					B.add(c);
				} else {
					otherSet.add(c);
				}
			}
//			System.out.println("--"+B+"--");
			StringBuilder Bstring = new StringBuilder();
			for (Character c : B) {
				Bstring.append(c + "");
			}
			for (int j = 0; j < Math.pow(2, otherSet.size())-1; j++) {
				String boolString2 = Euler.toBinaryString(j, otherSet.size());
				List<Character> C = new ArrayList<Character>();
				for (int k = 0; k < otherSet.size(); k++) {
					if (boolString2.charAt(k) == '0') {
						C.add(otherSet.get(k));
					} 
				}
				StringBuilder Cstring = new StringBuilder();
				for (Character c : C) {
					Cstring.append(c + "");
				}
				if (B.size() == C.size()) {
					if (B.get(0) < C.get(0)) {
						pairs.add(Bstring.toString() + "- " + Cstring.toString());
					} else {
						pairs.add(Cstring.toString() + "- " + Bstring.toString());
					}
				} else if (B.size() < C.size()) {
					pairs.add(Bstring.toString() + "- " + Cstring.toString());
				} else {
					pairs.add(Cstring.toString() + "- " + Bstring.toString());
				}
//				System.out.println(C);
			}
		}
		return pairs;
	}
}
