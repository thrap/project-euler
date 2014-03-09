package Java;

public class Problem108TODOOOO {
	//n/y + n/x = 1
	//if < 1 continue, if > 1 break
	//gogog niggnog
	public static void main(String[] args) {
		
		int storste = 0;
		for (long n = 2; true; ++n) {
			int teller = 1;
			for (long x = 2*n-1; x > n; --x) {
				if (x-n == 0)
					continue;
				long y = (x*n)/(x-n);
				if (n*y+n*x == x*y)
					++teller;
			}
			if (teller > storste) {
				storste = teller;
				System.out.println(n + " " + teller);
			}
				
			if (teller >= 1000) {
				System.out.println(n + " " + teller);
				System.exit(0);
			}
		}
		
		//TODO Hashmap med rational!
//		for (int n = 4; n <= 4; n++) {
//			int teller = 0;
//			int storste = Integer.MAX_VALUE;
//			for (int y = 1; y < 1000; y++) {
//				for (int x = y; true; x++) {
//					if (n*x+n*y == x*y) 
//						teller++;
//					if (n*x+n*y > x*y) {
//						break;
//					}
//				}
//			}
//			System.out.println(teller);
//		}
	}
}
