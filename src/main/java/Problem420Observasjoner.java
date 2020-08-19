import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Euler;
import utils.T;

public class Problem420Observasjoner {
	
	public static void validate(String str, boolean bool) {
		if (!bool) {
			System.out.println("Fuck! Dette stemmer ikke: "+str);
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		Map<String, Integer> matrices = new HashMap<String, Integer>();
		
		/**
		 * Matrisene blir alltid lik
		 * 
		 * {{a*a+c*b, a*b+b*d},
		 *  {a*c+c*d, b*c+d*d}}
		 */
		
		Map<String, Integer> eigenValues = new HashMap<String, Integer>();
		
		int N = 1000;
		T t = new T();
		for (int a = 1; a*a+3 < N; a++) {
			System.out.println(a + " / "+(int)Math.sqrt(N-3));
			for (int b = 1; a*a+2*b+1 < N; b++) {
				for (int c = 1; a*a+c*b + b*c+1 < N; c++) {
					for (int d = 1; a*a+c*b + b*c+d*d < N; d++) {
						long[][] res = Euler.matrixPow(new long[][]{{a,b},{c,d}}, 2);
						if (res[0][0]+res[1][1] < N) {
							String s = res[0][0]+" "+res[0][1] + " "+res[1][0]+" "+res[1][1];
							matrices.put(s, (matrices.containsKey(s) ? matrices.get(s)+1 : 1));
							
							/**
							 * 
							 * SE P DETTE DET ER VIKTIG OG SMART OG ESSENSIELT
							 * 
							 */
							
							if (matrices.get(s) > 1) {
								validate("Determinant er aldri lik 0", a*d-c*b != 0);
								validate("Det inni squareroot p egenverdier er alltid perfect square", Euler.isPerfectSquare(a*a-2*a*d+4*b*c+d*d));

								long e1 = (-(a+d)*(long)Math.sqrt(a*a-2*a*d+4*b*c+d*d)+a*a+2*b*c+d*d)/2;
								long e2 = ((a+d)*(long)Math.sqrt(a*a-2*a*d+4*b*c+d*d)+a*a+2*b*c+d*d)/2;
								
								validate("Begge egenverdier er alltid perfect squares", Euler.isPerfectSquare(e1) && Euler.isPerfectSquare(e2));
								
								String s2 = e1 + " " + e2;
								eigenValues.put(s2, (eigenValues.containsKey(s2) ? eigenValues.get(s2)+1 : 1));
							}
						}
					}
				}
			}
		}
		
		int count = 0;
		for (String string : matrices.keySet()) {
			if (matrices.get(string) == 2) {
				String[] split = string.split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				int c = Integer.parseInt(split[2]);
				int d = Integer.parseInt(split[3]);
				
				count++;
			}
		}

		printEigenValues(eigenValues);
		
		System.out.println(count + " " + t);
	}
	
	
	
	private static void printEigenValues(Map<String, Integer> eigenValues) {
		List<String> set = new ArrayList<String>();
		for (String string : eigenValues.keySet()) {
			set.add(eigenValues.get(string)+ ": "+string);
		}
		Collections.sort(set, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1.split(":")[0]).compareTo(Integer.valueOf(o2.split(":")[0]));
			}	
		});
		
		for (String string : set) {
			System.out.println(string);
		}
	}
}
