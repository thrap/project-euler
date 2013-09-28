package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem51FFFFFFFFFFFF {
	static HashMap<String,Integer> map;
	
	public static void putMap(String tall) {
		//tell niggere
		int[] count = new int[10];
		for (int i = 0; i < tall.length(); i++) {
			count[tall.charAt(i)-'0']++;
		}
		
		for (int i = 0; i < count.length; i++) {
			//er det bare én kan det replaces
			if (count[i] >= 1) {
				String ny = tall.replace((char)('0'+i), '*');
				Integer antall = map.get(ny);
				if (antall == null)
					map.put(ny, 1);
				else 
					map.put(ny, antall+1);
				
				
			} 
			if (count[i] >= 2) {
				//4331 -> 4*31 og 43*1
				for (int j = 0; j < tall.length(); j++) {
					if (tall.charAt(j) == i+'0') {
						StringBuilder sb = new StringBuilder();
						//TODO Ta med minus 1?
						for (int j2 = 0; j2 < tall.length(); j2++) {
							if (j2 == j) 
								sb.append('*');
							else 
								sb.append(tall.charAt(j2));
							
						}
						Integer ant = map.get(sb.toString());
						if (ant == null)
							map.put(sb.toString(), 1);
						else 
							map.put(sb.toString(), ant+1);
					}
				}
			}
			if (count[i] >= 3) {
				//4331 -> 4*31 og 43*1
				//1333 -> 1|*33 + 1|3*3 + 1|33* -> 1*|33 + 13|*3 + 13|3*
				for (int j = 0; j < tall.length(); j++) {
					if (tall.charAt(j) == i+'0') {
						for (int j2 = j+1; j2 < tall.length(); j2++) {
							if (tall.charAt(j2)  == i+'0') {
								StringBuilder sb = new StringBuilder();
								//TODO Ta med minus 1?
								for (int j3 = 0; j3 < tall.length(); j3++) {
									if (j3 == j || j3 == j2) 
										sb.append('*');
									else 
										sb.append(tall.charAt(j3));
									
								}
								Integer ant = map.get(sb.toString());
								if (ant == null)
									map.put(sb.toString(), 1);
								else 
									map.put(sb.toString(), ant+1);
								
							}
						}
					}
				}
			}
			if (count[i] >= 4) {
				//4331 -> 4*31 og 43*1
				//1333 -> 1|*33 + 1|3*3 + 1|33* -> 1*|33 + 13|*3 + 13|3*
				for (int j = 0; j < tall.length(); j++) {
					if (tall.charAt(j) == i+'0') {
						for (int j2 = j+1; j2 < tall.length(); j2++) {
							if (tall.charAt(j2)  == i+'0') {
								for (int j3 = j2+1; j3 < tall.length(); j3++) {
									if (tall.charAt(j3)  == i+'0') {
										StringBuilder sb = new StringBuilder();
										//TODO Ta med minus 1?
										for (int q = 0; q < tall.length(); q++) {
											if (q == j || q == j2 || q == j3) 
												sb.append('*');
											else 
												sb.append(tall.charAt(q));
											
										}
										Integer ant = map.get(sb.toString());
										if (ant == null)
											map.put(sb.toString(), 1);
										else 
											map.put(sb.toString(), ant+1);
									}
								}
								
							}
						}
					}
				}
			}
			if (count[i] >= 5) {
				System.out.println(tall);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> primtall = new ArrayList<Integer>();
		int lol = 1000000;
		boolean[] primtallArray = Test.primtallUnder(lol*10);
		System.out.println(primtallArray[5074009]);
		System.out.println(5074009);
//		System.exit(0);
		
		for (int i = 0; i < lol*10; i++) {
			if (primtallArray[i])
				primtall.add(i);
		}
		
		map = new HashMap<String,Integer>();
		for (int i = 0; i < primtall.size(); i++) {
			if (primtall.get(i) < 100000)
				continue;
			if (primtall.get(i) > 1000000)
				break;
			
			String tall = ""+primtall.get(i);
//			String tall = "" + 2222;
			putMap(tall);
		}
		String tallet="";
		int storste = 0;
		for (String k: map.keySet()) {
			if (map.get(k) > storste) {
				storste = map.get(k);
				tallet = k;
			}
		}
//		System.out.println(map);
		System.out.println(tallet + ": " + storste);
	}
}
