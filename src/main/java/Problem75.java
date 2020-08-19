import java.util.HashMap;

public class Problem75 {
	public static void main(String[] args) {
		
		int limit = 1500000;
		int teller = 0;
		
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		
		for (long k1 = 1; k1*2 + Math.sqrt(2*k1*k1) <= limit; ++k1) {
			for (long k2 = k1+1; k1+k2+Math.sqrt(k1*k1+k2*k2) <= limit; ++k2) {
				long h = (long)Math.sqrt(k1*k1+k2*k2);
				if (h*h == k1*k1+k2*k2) {
					long o = h+k1+k2;
					if (h+k1+k2 <= limit) {
						if (!map.containsKey(o)) {
							map.put(o, 1);
						} else {
							map.put(o, map.get(o)+1);
						}
					}
				}
			}
			if (k1 % 1000 == 0)
				System.out.println(k1+ "("+(k1*2 + Math.sqrt(2*k1*k1))+")");
		}
		
		for (Long string : map.keySet()) {
			if (map.get(string) == 1) {
				++teller;
				if (string > 1499920)
					System.out.println(string);
			}
		}
		
		System.out.println(teller);
	}
}
