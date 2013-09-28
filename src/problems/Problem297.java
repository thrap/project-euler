package problems;

public class Problem297 {
	public static void main(String[] args) {
//		long a = 0;
//		long b = 1;
//		long c = 1;
//		int teller = 0;
//		while (c < 100000000000000000L) {
//			a = b;
//			b = c;
//			c = a+b;
//			++teller;
//			System.out.println(c);
//		}
//		System.out.println(teller);
		long teller = 0;
		int count = 0;
		for (long a = 1; a < 1000; a++) {
//			System.out.println(a);
			long i = a;
			for (int j = 0; true; j++) {
				long forrige = finn(i);
//				System.out.println(forrige);
				i-=forrige;
				if (forrige == 1 || i == 0) {
					if (a>= 89 && a <= 89+21)
						count+=j+1-1;
					System.out.println(j+1);
					teller+=j+1;
					break;
				}
			}
			
		}
		System.out.println(count);
		System.out.println(teller);
	}
	
	public static long finn(long index) {
		if (index == 0)
			return 0;
		if (index == 1)
			return 1;
		long a = 0;
		long b = 1;
		long c = a+b;
		while (c < index) {
			a = b;
			b = c;
			c = a+b;
		}
		if (c == index)
			return c;
		return b;
	}
}
