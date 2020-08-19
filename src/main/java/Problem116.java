public class Problem116 {
	
	static long teller = 0;
	
	static long WAYS[][] = new long[100][100];
	/*		//2 = 5-1 + (5-2 = 3 = 3-1) + (5-3 = 2 = 2-1)

	//3 = 5-2
	//4 = 5-3
	
	//..---
	//-..-
	
	//5/2 = 3
	//..-..
	//-..--
	//-....
	//--..-
	//---..
	
	
	//25 = 1
	//1 = 49
	
	//11/2 = 6
	
/*			
	x x x x x x x x x 
	
	
	
	(x-1)
	x x x x x x x xx
	x x x x x x xx x
	x x x x x xx x x
	x x x x xx x x x
	x x x xx x x x x
	x x xx x x x x x
	x xx x x x x x x
	xx x x x x x x x
	
	(x-3)
	x x x x x xx xx
	x x x x xx x xx
	x x x xx x x xx
	x x xx x x x xx
	x xx x x x x xx
	xx x x x x x xx
	
	(x-4)
 	x x x x xx xx x
	x x x xx x xx x
	x x xx x x xx x
	x xx x x x xx x
	xx x x x x xx x
	
	(x-5)
 	x x x xx xx x x
	x x xx x xx x x
	x xx x x xx x x
	xx x x x xx x x
	
	(x-6)
 	x x xx xx x x x
	x xx x xx x x x
	xx x x xx x x x
	
	(x-7)
 	x xx xx x x x x
	xx x xx x x x x
	
	(x-8)
	xx xx x x x x x
	
	xx xx xx x x x
	xx xx x xx x x
	xx xx x x xx x
	xx xx x x x xx
	xx x xx xx x x
	xx x xx x xx x
	xx x xx x x xx
	xx x x xx xx x
	xx x x xx x xx
	xx x x x xx xx
	
	x xx xx xx x x 
	x xx xx x xx x 
	x xx xx x x xx 
	x xx x xx xx x 
	x xx x xx x xx 
	x xx x x xx xx 
	
	x x xx xx xx x 
	x x xx xx x xx  
	x x xx x xx xx 
	
	x x x xx xx xx
	
//	System.out.println(sum(9,2));//skal vaere1+3+6+10
//	System.out.println(antall(7,2,2));
//	antall(6,2,2)
//	antall(5,2,2)
//	antall(4,2,2)
	
		1
	3
	2
	1
	xx xx xx
	xx xx x x
	xx x xx x
	xx x x xx
	x xx x xx
	x xx xx x
	x x xx xx
	
	
	xx x x x x
	x xx x x x
	x x xx x x
	
	xx xx
	xx x x
	x xx x
	x x xx
	
	
	xx xx x
	xx x xx
	x xx xx
	xx x x x
	x xx x x 
	x x xx x
	x x x xx
		
*/

	public static void main(String[] args) {

		
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long solution() {
		int tiles = 50;
		WAYS = new long[100][100];
		return sum(tiles,4)+sum(tiles,3)+sum(tiles,2);
	}

	public static long sum(int tiles, int width) {
		long sum = 0;
		for (int i = tiles/width; i != 0; --i) {
//			System.out.println(tiles + " "+ width+" "+ i);
			sum+=count(tiles-(i*(width-1)), i);
		}
		return sum;
	}

	public static long count(int tiles, int blocks) {
//		return ant(tiles, width, antall);
		if (WAYS[tiles][blocks] != 0)
			return WAYS[tiles][blocks];
		if (blocks == 0) 
			return 0;
		if (blocks == 1) {
			WAYS[tiles][blocks]=tiles;
			return WAYS[tiles][blocks];
		} else {
			long sum = 0;
			for (int i = tiles; i >= blocks-1; --i) {
				sum += count(i-1,blocks-1);
			}
			WAYS[tiles][blocks] = sum;
			return sum;
		}
	}
}
