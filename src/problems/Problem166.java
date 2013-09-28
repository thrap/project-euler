package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Helper {
	private static Map<Integer, Map<String,List<String>>> searchMap = new HashMap<Integer, Map<String,List<String>>>();
	
	public Helper() {
		for(int i = 0; i<= 9*4; ++i) {
			searchMap.put(i, new HashMap<String,List<String>>());
		}
	}
	
	public void add(int i, String tall) {
		Map<String, List<String>> map = searchMap.get(i);
		char[] number = tall.toCharArray();
		String[] sok = {number[0]+"xxx", 
				number[0]+"xx"+number[3], 
				number[0]+"x"+number[2]+"x", 
				number[0]+""+number[1]+""+number[2]+"x", 
				number[0]+""+number[1]+"xx",
				tall};
		for (int j = 0; j < sok.length; j++) {
			if (map.containsKey(sok[j])) {
				map.get(sok[j]).add(tall);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(tall);
				map.put(sok[j], list);
			}
		}
	}
	
	public List<String> find(int i, String sok) {
		if (searchMap.get(i).get(sok) == null)
			return new ArrayList<String>();
		return searchMap.get(i).get(sok);
	}
}

public class Problem166 {
	
	
	
	static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
//	static Map<Integer, List<String>[]> digitMap = new HashMap<Integer, List<String>[]>();
//	static Map<Integer, Map<String,List<String>>> searchMap = new HashMap<Integer, Map<String,List<String>>>();
	static Helper helper = new Helper();
	
	static int length = 4;
	
	public static void main(String[] args) {
		for (int i = 0; i <= 9*length; i++) {
			map.put(i, new ArrayList<String>());
//			digitMap.put(i, new List[length]);
		}
		
		for (int i = 0; i < Math.pow(10, length); i++) {
			String number = format(i);
			int digital = digitalSum(number);
			helper.add(digital, number);
			map.get(digital).add(number);
		}
		long sum = 0;
		for (int i = 0; i <= 9*length; i++) {
			System.out.println(i);
			for (String firstX : map.get(i)) {
				char[] x = firstX.toCharArray();
				String sok1 = x[0]+"xxx";
				
				for (String firstY : helper.find(i, sok1)) {
					char[] y = firstY.toCharArray();
					String sok2 = y[3]+"xx"+x[3];
					for (String diagonal : helper.find(i, sok2)) {
						char[] d = diagonal.toCharArray();
						
						/*
						 * x0 x1 x2 x3
						 * y1    d2
						 * y2 d1
						 * y3
						 */
						String sok3 = ""+y[1]+"x"+d[2]+"x";
						for (String  res3 : helper.find(i, sok3)) {
							char[] a = res3.toCharArray();
							/*
							 * x0 x1 x2 x3
							 * y1 a1 d2 a3
							 * y2 d1
							 * y3
							 */
							String sok4 = ""+x[1]+""+a[1]+""+d[1]+"x";
							for (String res4 : helper.find(i, sok4)) {
								char[] b = res4.toCharArray();
								/*
								 * x0 x1 x2 x3
								 * y1 a1 d2 a3
								 * y2 d1
								 * y3 b3
								 */
								String sok5 = ""+x[2]+""+d[2]+"xx";
								for (String res5 : helper.find(i, sok5)) {
									char[] c = res5.toCharArray();
									/*
									 * x0 x1 x2 x3
									 * y1 a1 d2 a3
									 * y2 d1 c2
									 * y3 b3 c3
									 */
									String sok6 = ""+y[2]+""+d[1]+""+c[2]+"x";
									for (String res6 : helper.find(i, sok6)) {
										char[] e = res6.toCharArray();
										/*
										 * x0 x1 x2 x3
										 * y1 a1 d2 a3
										 * y2 d1 c2 e3
										 * y3 b3 c3
										 */
										
										String sok7 = ""+x[3]+""+a[3]+""+e[3]+"x";
										for (String res7 : helper.find(i, sok7)) {
											char[] f = res7.toCharArray();
											/*
											 * x0 x1 x2 x3
											 * y1 a1 d2 a3
											 * y2 d1 c2 e3
											 * y3 b3 c3 f3
											 */
											String sok8 = ""+y[3]+""+b[3]+""+c[3]+""+f[3];
											String sok9 = ""+x[0]+""+a[1]+""+c[2]+""+f[3];
											if (helper.find(i, sok8).size() != 0 && helper.find(i, sok9).size() != 0) {
												sum++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
		System.out.println(sum == 3458872);
//		for (int i = 0; i <= 9*length; i++) {
//			Collections.sort(map.get(i));
//			firstDigitMap.put(i, new HashMap<Integer,List<String>>());
//			for (String string : map.get(i)) {
//				int firstDigit = string.charAt(0)-'0';
//				if (firstDigitMap.get(i).containsKey(firstDigit))
//					firstDigitMap.get(i).get(firstDigit).add(string);
//				else {
//					List<String> list = new ArrayList<String>();
//					list.add(string);
//					firstDigitMap.get(i).put(firstDigit, list);
//				}
//			}
//			System.out.println(i+": "+map.get(i).size());
//		}
		
		
//		long sum = 0;
//		for (int i = 0; i <= 9*length; i++) {
//			for (String firstLine : map.get(i)) {
//				List<String>[] legalStrings = new List[length];
//				for (int j = 0; j < length; j++) {
//					int firstDigit = firstLine.charAt(j)-'0';
//					legalStrings[j] = firstDigitMap.get(i).get(firstDigit);
//				}
//				long lokalSum = 1;
//				for (int j = 0; j < legalStrings.length; j++) {
//					lokalSum*=legalStrings[j].size();
//				}
//				sum+=lokalSum;
//			}
//		}
//		System.out.println(sum);
	}
	
	public static String format(int i) {
		String string = ""+i;
		if (i >= Math.pow(10, length-1))
			return string;
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < length-string.length(); j++) {
			sb.append(0);
		}
		sb.append(string);
		return sb.toString();
	}
	
	public static int digitalSum(String t) {
		int sum = 0;
		for (int i = 0; i < t.length(); i++) {
			sum+=t.charAt(i)-'0';
		}
		return sum;
	}
}
