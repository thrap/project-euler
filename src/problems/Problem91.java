package problems;

public class Problem91 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		int limit = 50;
		int teller = 0;
		
//		System.out.println(isRightAngledTriangle(/*(*/1, 0,/*),(*/0,1/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/1, 0,/*),(*/1,1/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 2,/*),(*/1,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/1, 2,/*),(*/1,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 1,/*),(*/2,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/1, 1,/*),(*/2,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/2, 1,/*),(*/2,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 2,/*),(*/2,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/2, 2,/*),(*/2,0/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 1,/*),(*/1,1/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 1,/*),(*/2,1/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 2,/*),(*/1,1/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 2,/*),(*/1,2/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/0, 2,/*),(*/2,2/*)*/));
//		System.out.println(isRightAngledTriangle(/*(*/1, 2,/*),(*/2,2/*)*/));
		
		for (int y = 0; y <= limit; ++y) {
			for (int x = limit; x >= 1; --x) {
				
				for (int y1 = y; y1 <= limit; ++y1) {
					for (int x1 = x; x1 >= 0; --x1) {
//							System.out.println(isRightAngledTriangle(x,y  ,  x1,y1));
						if (y1 == y && x1 == x)
							continue;
						if (isRightAngledTriangle(x,y  ,  x1,y1))
							++teller;
					}
				}
				
			}
		}
		
		return teller-limit;
	}

	public static boolean isRightAngledTriangle(int x, int y  ,  int x1, int y1) {
		int a1 = x1*x1+y1*y1;
		int a2 = x*x+y*y;
		int a3 = (x-x1)*(x-x1) + (y-y1)*(y-y1);
		
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(a3);
		
		if (a1 > a2 && a1 > a3)
			return a2+a3 == a1;
		else if (a2 > a1 && a2 > a3)
			return a1+a3 == a2;
		else
			return a1+a2 == a3;
	}
}
