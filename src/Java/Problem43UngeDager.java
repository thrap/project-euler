package Java;

import java.util.ArrayList;

public class Problem43UngeDager {
	public static void main(String[] args) {
		int teller=0;
		
		System.out.println(sjekk(new StringBuilder("1406357298")));
		long sum=0;
		for (int q5 = 0; q5 <10; q5++) {
			for (int q6 = 0; q6 < 9; q6++) {
				for (int q2 = 0; q2 < 8; q2++) {
					for (int q3 = 0; q3 < 7; q3++) {
						for (int q4 = 0; q4 < 6; q4++) {
							for (int q = 0; q < 5; q++) {
								for (int a = 0; a <4; a++) {
									for (int i = 0; i <3; i++) {
										for (int j = 0; j <2; j++) {
											ArrayList asd = new ArrayList();
											asd.add(1);
											asd.add(2);
											asd.add(3);
											asd.add(4);
											asd.add(5);
											asd.add(6);
											asd.add(7);
											asd.add(8);
											asd.add(9);
											asd.add(0);
											StringBuilder aaa = new StringBuilder();
											aaa.append(asd.get(q5));
											asd.remove(q5);
											aaa.append(asd.get(q6));
											asd.remove(q6);
											aaa.append(asd.get(q2));
											asd.remove(q2);
											aaa.append(asd.get(q3));
											asd.remove(q3);
											aaa.append(asd.get(q4));
											asd.remove(q4);
											aaa.append(asd.get(q));
											asd.remove(q);
											aaa.append(asd.get(a));
											asd.remove(a);
											aaa.append(asd.get(i));
											asd.remove(i);
											aaa.append(asd.get(j));
											asd.remove(j);
											aaa.append(asd.get(0));
//											System.out.println(aaa);
											if (sjekk(aaa)) {
												System.out.println(aaa);
												sum+=Long.parseLong(aaa.toString());
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
	}
	
	public static boolean sjekk(StringBuilder string) {
		StringBuilder tall = new StringBuilder();
		tall.append(string.charAt(1));
		tall.append(string.charAt(2));
		tall.append(string.charAt(3));
		if (Integer.parseInt(tall.toString()) % 2 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(4));
		if (Integer.parseInt(tall.toString()) % 3 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(5));
		if (Integer.parseInt(tall.toString()) % 5 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(6));
		if (Integer.parseInt(tall.toString()) % 7 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(7));
		if (Integer.parseInt(tall.toString()) % 11 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(8));
		if (Integer.parseInt(tall.toString()) % 13 != 0)
			return false;
		tall.delete(0, 1);
		tall.append(string.charAt(9));
		if (Integer.parseInt(tall.toString()) % 17 != 0)
			return false;
//		System.out.println(tall);
		return true;
	}
}
