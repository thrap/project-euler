package Java;

import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem65 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		long t=2 ;
		long n=3;
		
		//1-1
		//1-1+1-2 = 2-3
		//1-1+1-2+1-1 = 3-4
		//1-(1-2+1) = 2-3
		//1-2-3+2 = 3/8
		
//		for (int j = 0; j < 200; j++) {
			StringBuilder rekke = new StringBuilder("1 1 1 2 1 1 ");
			int teller = 2;
			//2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
			for (int i = 2; i < 100-2; i++) {
				if (i % 3 == 0) {
					teller+=2;
					rekke.append("1 "+teller+ " ");
				}
				else 
					rekke.append("1 1 ");
				
			}
//			System.out.println(rekke);
			return execute(rekke.toString());
//		}
		
//		for (int i = 1; i < 1000 ; i++) {
//			t+=n;
//			long temp = t;
//			t=n;
//			n=temp;
//			
//			System.out.println(2*n+t+"/"+n);
//		}
	}

	public static int execute(String rekke) {
		rekke = new StringBuilder(rekke).reverse().toString();
		StringTokenizer st = new StringTokenizer(rekke);
//		System.out.println(rekke);
		
		BigInteger n = BigInteger.valueOf(Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString()));
		BigInteger t = BigInteger.valueOf(Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString()));
		while (st.hasMoreTokens()) {
			t= t.add(BigInteger.valueOf(Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString())).multiply(n));
			BigInteger temp = BigInteger.valueOf(Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString())).multiply(n);
			n = t;
			t = temp;
		}
//		System.out.println(n.multiply(BigInteger.valueOf(2)).add(t).toString()+"/"+n.toString());
		
		String lol=n.multiply(BigInteger.valueOf(2)).add(t).toString();
		int sum = 0;
		for (int i = 0; i < lol.length(); i++) {
			sum+=lol.charAt(i)-'0';
//			System.out.print(lol.charAt(i));
		}
		return sum;
//		System.out.println(rekke);
	}
}
