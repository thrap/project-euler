package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem414 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int k = 2; k <= 300; k++) {
			int base = 6*k+3;
			
			List<Long> values = generatePossibleNumbers(base);
			
			/**
			 * det skal finnes 
			 * midten kan vre hva som helst (bare den er imellom b og d)
			 * har du [a,b, ,d,e] => du har [a,b+1, ,d+1,e]
			 * har du [a,b, ,d,e] => du har [a+1,b, ,d,e+1]
			 */
			
			base = 15;
			printAllValues(generatePossibleNumbers(base), base);
			System.exit(0);
			
			
			int antall = -1;
			for (int i = 0; i < base; i++) {
				for (int j = i; j < base; j++) {
					antall++;
				}
			}
			System.out.println("base = "+base +" ("+k+"/300)" + "\nantall = " + values.size());
			System.out.println("antallTest = " + antall);
		}
		System.out.println("("+(System.currentTimeMillis()-start+" ms)"));
//		System.out.println(Arrays.toString(decode(toLong(new int[] {12,2,0,0,28}, 29), 29)));
	}
	
	private static void printAllValues(List<Long> values, int base) {
		Map<Long, List<Long>> count = new HashMap<Long, List<Long>>();
		for (Long value : values) {
			count.put(value, new ArrayList<Long>());
		}
		
		int [] numbers = new int[5];
		for (int a = 0; a < base; a++) {
			numbers[0] = a;
			for (int b = a; b < base; b++) {
				numbers[1] = b;
				for (int c = b; c < base; c++) {
					numbers[2] = c;
					for (int d = c; d < base; d++) {
						numbers[3] = d;
						for (int e = d; e < base; e++) {
							numbers[4] = e;
							if (a==b && a==c && a==d && a==e) continue;
							
							int[] diff = new int[5];
							for (int i = 4; i >= 0; i--) {
								diff[i] += numbers[4-i]-numbers[i];
								if (diff[i] < 0) {
									diff[i-1]--;
									diff[i] += base;
								}
							}
							long num = toLong(diff, base);
							count.get(num).add(toLong(numbers,base));
						}
					}
				}
			}
		}
		
		/**
		 * fact: midten er alltid med, lenge den er mindre enn index 3 og strre enn index 1
		 */
		Map<Long, List<String>> equal = new TreeMap<Long, List<String>>(); 
		for (long value : values) {
			List<Long> list = count.get(value);
			long permutations = permutations(list, base);
			if (equal.containsKey(permutations)) {
				equal.get(permutations).add(decodeString(list.get(0),base));
			} else {
				List<String> l = new ArrayList<String>();
				l.add(decodeString(list.get(0),base));
				equal.put(permutations, l);
			}
		}
		
		int x = base;
		Set<Long> set = new TreeSet<Long>();
		/**
		 * tallene er p formen ..,a,b]
		 */
		
		
		//de frste (base) sifferene
		System.out.print("InterpolatingPolynomial {");
		for (long i = 2; true; i++) {
			long number = ((2*base-i)*(i-1))/2;
			if (number<=0)
				break;
			System.out.print("{"+(i+1)+","+number+"},");
			set.add(number);
		}
		System.out.println("}");		

		//begge siffere like
		System.out.print("InterpolatingPolynomial {");
		for (long i = 1; true; i++) {
			long number = 1*(base-i)*(3*i-1);
			if (number<=0)
				break;
			System.out.print("{"+(i)+","+number+"},");
			set.add(number);
		}
		System.out.println("}");
				
		//tallene er ...,a,a+1]
		System.out.print("InterpolatingPolynomial {");
		for (long i = 2; true; i++) {
			long number = 2*(base-i)*(6*i-7);
			if (number<=0)
				break;
			System.out.print("{"+(i+1)+","+number+"},");
			set.add(number);
		}
		System.out.println("}");
		
		//tallene er ...,a,a+2]
		System.out.println("a,a+2");
		for (long i = 3; true; i++) {
			long number = 2*(base-i)*(12*i-25);
			System.out.print("{"+i+","+number+"},");
			if (number<=0)
				break;
//			System.out.print(number + " ");
			set.add(number);
		}
		
		//tallene er ...,a,a+3]
		System.out.println("a,a+3");
		for (long i = 5; true; i++) {
			long number = 2*(base-i)*(18*i-55);
			System.out.print("{"+i+","+number+"},");
			if (number<=0)
				break;
//					System.out.print(number + " ");
			set.add(number);
		}
		
		//tallene er ...,a,a+4]
		System.out.println("a,a+4");
		for (long i = 5; true; i++) {
			long number = 2*(base-i)*(24*i-97);
			System.out.print("{"+i+","+number+"},");
			if (number<=0)
				break;
//							System.out.print(number + " ");
			set.add(number);
		}
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * for a,a+n: number=2*(base-i)*(n*6*i-(6*n*n-12*n+7))
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		System.out.println();
		System.out.println("Jeg inneholder disse");
		for (long j : equal.keySet()) {
			if (set.contains(j/10)) {
				System.out.println(j/10 + " " +equal.get(j));
			}
		}
		
		System.out.println();
		System.out.println("Jeg inneholder ikke disse");
		for (long j : equal.keySet()) {
			if (!set.contains(j/10)) {
				System.out.println(j/10 + " " +equal.get(j));
			}
		}
		//80,154,204,230,232
		//110, 220, 306, 368, 406
		//-12*i*i+11*base*i-base*2-2
		
		
		
		System.out.println("Dette er de resterende:");
		for (long j : equal.keySet()) {
			if (!set.contains(j/10)) {
				System.out.print(j/10+" ");
			}
//			System.out.println(j + ": "+equal.get(j));
		}
		System.out.println();
		
		
		System.out.println((1*x-t(1)) + " " + (2*x-t(2)) + " " + 2*(x-1) + " " + (3*x-t(3)) + " " + (3*(x-1)-t(1))+ " " +
		+ (4*x-t(4)) + " " + (5*x-t(5)) +" " + (5*(x-1)-t(3)) + " " + (6*x-15) + " " + (6*x-8) + " " + (7*x-21) + " " + (8*x-28) + " " +
		+ (9*x-36) + " " + (10*x-45) + " " + (11*x-55));
		for (long i = 1; i < 100; i++) {
			System.out.print(i*x-t(i) + " ");
			if (!set.contains(i*x-t(i))) {
				System.out.println(i*x-t(i));
				break;
			}
			set.remove(i*x-t(i));
		}
		System.out.println();
		System.out.println("test:");
		for (int i = 1; i < 20; i++) {
			System.out.print((i*(2*base-1-i))/2 + " ");
		}
		System.out.println("\n"+set);
		System.out.println(2*(base)-2*t(1));
		System.out.println(3*(base)-3*t(1));
		System.out.println("\ntest2:");
		for (int i = 1; i < 20; i++) {
			System.out.print((i*(4*base-1-2*i))/2 + " ");
		}
		
		System.out.println();
		System.out.println("Base = "+base);
		System.out.print("InterpolatingPolynomial {");
		int index = 0;
		for (long number : new long[]{4180, 4998, 5720, 6346, 6876}) {
			System.out.print("{"+(1+index++)+","+number+"},");
		}
		System.out.println();
		System.out.println();
		System.out.println();
//		for (long j : equal.keySet()) {
//			System.out.println(j + " " + delelig(j/10,base));
//		}
		System.out.println(set.size());
	}
	
	private static long t(long n) {
		return (n*(n+1))/2;
	}
	

	private static List<Long> delelig(long j, int base) {
		List<Long> list = new ArrayList<Long>();
		for (long i = base; i >= 2; i--) {
			if (j % i == 0) 
				list.add(i-base);
		}
		return list;
	}

	public static long permutations(List<Long> list, int base) {
		long count = 0;
		for (long long1 : list) {
			count+=permutations(decode(long1,base));
		}
		return count;
	}
	
	static int[] factorial = {1,1,2,6,24};
	
	private static int permutations(int[] is) {
		int permutations = 120;
		int like = 1;
		for (int i = 1; i < 5; i++) {
			if (is[i-1] == is[i]) {
				like++;
			} else {
				permutations/=factorial[like];
				like = 1;
			}
		}
		
		return permutations/factorial[like];
	}
	
	public static String decodeString(long value, int base) {
		return Arrays.toString(decode(value, base));
	}

	/**
	 * m kanskje gjre om til bigInteger etterhvert
	 */
	public static List<Long> generatePossibleNumbers(int base) {
		for (int i = 0; i < 5; i++) {
			pow[i] = (long) Math.pow(base, i);
		}
		/**
		 * 0 = 0 til (base-1)
		 * 1 = 0 til (base-1)
		 * 2 = base-1
		 * 3 = 0 til (base-1)
		 * 4 = 1 til (base-1)
		 * 
		 * 0 + 4 = base-1 eller base
		 * 1 + 3 = base-2 eller 2*base-2
		 */
		List<Long> list = new ArrayList<Long>();
		int[] diff = new int[5];
		diff[2] = base-1;
		for (int a = 0; a < base; a++) {
			for (int b = 0; b < a; b++) {
				diff[0] = a;
				diff[1] = b;
				
				int e1 = base-a;
				int d1 = base-2-b;
				
				int e2 = base-1-a;
				int d2 = 2*base-2-b;

				if (d2 <= base-1 &&d2 >= 0 && e2 >= 1) {
					diff[4] = e2;
					
					diff[3] = d2;
					list.add(toLong(diff, base));
				}	
				if (d1 >= 0 && e1 >= 1){
					diff[4] = e1;
					
					diff[3] = d1;
					list.add(toLong(diff, base));
				}
			}
			int b = base-1;
			diff[0] = a;
			diff[1] = b;
			
			int e1 = base-a;
			int d1 = base-2-b;
			
			int e2 = base-1-a;
			int d2 = 2*base-2-b;

			if (d2 <= base-1 &&d2 >= 0 && e2 >= 1) {
				diff[4] = e2;
				
				diff[3] = d2;
				list.add(toLong(diff, base));
			}	
			if (d1 >= 0 && e1 >= 1){
				diff[4] = e1;
				
				diff[3] = d1;
				list.add(toLong(diff, base));
			}
		}
		
		return list;
	}
	
	public static Long toLong(int[] diff, int base) {
		return diff[0]*pow(base,4)+diff[1]*pow(base,3)+diff[2]*pow(base,2)+diff[3]*pow(base,1)+diff[4];
	}

	static long[] pow = new long[5];
	
	private static long pow(int base, int i) {
		return pow[i];
	}
	
	public static int[] decode(long number, int base) {
		int[] decoded = new int[5];
		for (int i = 4; i >= 0; i--) {
			long amount = number/pow(base,i);
			number-=amount*pow(base,i);
			decoded[4-i] = (int)amount;
		}
		return decoded;
	}
}
