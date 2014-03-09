package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem59FF {
	public static void main(String[] args) throws IOException {
		byte asd=107;
		String binaryString = Integer.toBinaryString(asd);
		Integer q = new Integer(1);
		
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		String tekst = in.readLine();
		StringTokenizer st = new StringTokenizer(tekst,",");
//		System.out.println(st.nextToken());
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int storste = 0;
		for (int i = 0; i < st.countTokens(); i++) {
			int token = Integer.parseInt(st.nextToken());
			if (i%3==2) {
				if (map.containsKey(token)) {
					int temp = map.get(token);
					temp++;
					if (temp > storste) {
						storste = temp;
						System.out.println(token + ": " + temp);
					}
					map.put(token, temp);
				} else {
					map.put(token, 1);
				}
			}
		}
		
		
		System.out.println(map);
		
		st = new StringTokenizer(tekst,",");
		String string = "";
		int storste2 = Integer.MAX_VALUE;
		for (int i = 0; st.hasMoreElements(); i++) {
			int token = Integer.parseInt(st.nextToken());
			if (storste2 > token) {
				storste2 = token;
				System.out.println(token);
			}
			if (i%3 == 0) 
				string+=xor(token,'g');
			else if (i%3 == 1)
				string+=xor(token,'o');
			else if (i%3 == 2)
				string+=xor(token,'d');
		}
		System.out.println(string);
		//god
		
//		for (int j = 97; j <= 122; j++) {
//			if (xor(68,j) == ' ')
//				System.out.println((char)j);
////			System.out.print((char)j);
//		}
		int sum=0;
		for (int i = 0; i < string.length(); i++) {
			sum+=string.charAt(i);
		}
		System.out.println(sum);
	}
	
	public static String nuller(int a) {
		if (a >= 128)
			return "";
		if (a >= 64)
			return "0";
		if (a >= 32)
			return "00";
		if (a >= 16)
			return "000";
		if (a >= 8)
			return "0000";
		if (a >= 4)
			return "00000";
		if (a >= 2)
			return "000000";
		if (a >= 1)
			return "0000000";
		return "0000000";
		
	}
	
	public static char xor(int a, int b) {
		
//		String aa = nuller(a) + Integer.toBinaryString(a);
//		String bb = nuller(b) + Integer.toBinaryString(b);
////		System.out.println(aa);
////		System.out.println(bb);
//		if (aa.length() == 9)
//			System.out.println(aa);
//		
////		if (a == 79) {
////			System.out.println(aa);
////			System.out.println(bb);
////		}
//		
//		StringBuilder retur = new StringBuilder();
//		for (int i = 0; i < aa.length(); i++) {
//			if (aa.charAt(i) == bb.charAt(i))
//				retur.append("0");
//			else
//				retur.append("1");
//		}
//		
//		int sum = 0;
//		int teller = 1;
//		for (int i = retur.length()-1; i != -1; i--) {
//			sum+=Integer.parseInt(""+retur.charAt(i))*teller;
//			teller*=2;
//		}
//		return (char)sum;
//		
		return (char)(a^b);
	}
}
