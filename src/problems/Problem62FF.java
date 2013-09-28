package problems;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem62FF {
	static HashMap<Long,Integer> map = new HashMap<Long,Integer>();
	
	public static void main(String[] args) {
		/**
		 * 127035954683
		 */
		
		
		for (int i = 1; i < 150000; i++) {
//			long tall = i*i*i;
			BigInteger tall = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)));
			String a = ""+tall.toString();
			int[] count = new int[10];
			for (int j = 0; j < a.length(); j++) {
				count[a.charAt(j)-'0']++;
			}
			StringBuilder b = new StringBuilder();
			for (int q = 9; q != -1; q--) {
				for (int j = 0; j < count[q]; j++) {
					b.append(q);
				}
			}
			long tallet = Long.parseLong(b.toString());
			
			if (tallet == Long.valueOf("987655433210")) {
				System.out.println(i + ": " + tall.toString());
			}
				
//			System.out.println(tallet);
			if (map.containsKey(tallet)) {
				int temp = map.get(tallet);
				temp++;
				map.put(tallet, temp);
				if (temp == 5) {
					System.out.println(tallet);
//					System.exit(0);
				}
			} else {
				map.put(tallet, 1);
			}
			
		}
//		System.out.println(map.get("12"));
	}
}
