package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Euler;

public class Problem200 {
	public static boolean primeProof(String n) {
		if (n.length() > 16)
			return false;
		StringBuilder st = new StringBuilder(n);
		for (int i = 0; i < n.length(); i++) {
			for (int j = 0+(i==0?1:0); j <= 9; j++) {
				st.replace(i, i+1, ""+j);
				if (Euler.isPrime(Long.parseLong(st.toString())))
					return false;
			}
			st = new StringBuilder(n);
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Euler.bedrePrimeList(30000000);
		long storste = Long.MAX_VALUE;
		List<Long> liste = new ArrayList<Long>();
		ytterste:
		for (int i = 0; i < list.size(); i++) {
			long p = list.get(i);
			System.out.println(p + ": "+storste + "("+liste.size()+")");
			long sum = 1;
			for (int j = 0; j < 5; j++) {
				sum*=p;
				if (sum > storste)
					break ytterste;
			}
			
			for (int j = i+1; j < list.size(); j++) {
//				if (j%10000 == 0)
//					System.out.println(j);
				long q = list.get(j);
				long en = p*p*p;
				if (en > storste)
					continue;
				en*=q;
				if (en > storste)
					continue;
				en*=q;
				if (en > storste || en < 0)
					continue;
				
				String squibe1 = ""+en;
				
				
				if (en > 0&&en < storste && squibe1.contains("200") && primeProof(squibe1)) {
					liste.add(en);
					Collections.sort(liste);
					if (liste.size() > 200) {
						liste.remove(liste.size()-1);
						storste = liste.get(liste.size()-1);
					}
				}
				long to = p*p*q;
				if (to > storste)
					continue;
				to*=q;
				if (to > storste)
					continue;
				to*=q;
				if (to > storste || to < 0)
					continue;
				String squibe2 = ""+to;
				if (to > 0&&to<storste && squibe2.contains("200") && primeProof(squibe2)) {
					liste.add(to);
					Collections.sort(liste);
					if (liste.size() > 200) {
						liste.remove(liste.size()-1);
						storste = liste.get(liste.size()-1);
					}
				}
			}
		}
		System.out.println(storste);
	}
}
