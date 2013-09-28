package problems;

import java.util.ArrayList;

public class Problem111littgay {
	
	private static final ArrayList<Integer> LIST = new ArrayList<Integer>();
	private static final byte[] M = new byte[10];
	private static final long[] S = new long[10];
	static int i;
	
	public static void main(String[] args) {
		init();
		System.out.println(LIST);
		
		long a[]={38000000042L,12882626601L,97447914665L,23234122821L,4444444447L,
				5555555557L,6666666661L,59950904793L,285769942206L,78455389922L};
		long tempsumlol=0;
		for (int i = 0; i < a.length; i++) {
			tempsumlol+=a[i];
		}
		System.out.println(tempsumlol);

		
		for (i = 100; i < 1000; i++) {
			long start = 10000000L*i;
			
			boolean[] b = primeArrayBetween(start,10000000L*(long)(i+1));
			
			for (int t = 0; t < b.length; t++) {
				if (b[t]) {
					byte[] teMp = new byte[10];
					long tall = t+start;

					while (true) {
						teMp[(int)(tall % 10)]++;
						tall/=10;
						if (tall == 0)
							break;
					}
					
					for (int j = 0; j < teMp.length; j++) {
						if (teMp[j] > M[j]) {
							M[j] = teMp[j];
							S[j] = t+start;
						} else if (teMp[j] == M[j])
							S[j]+=t+start;
					}
				}
			}
			System.out.println(i);
		}
		long sum = 0;
		for (int i = 0; i < S.length; i++) {
			System.out.println(S[i]);
			sum+=S[i];
		}
		
		System.out.println(sum);
		
	}
	
	public static void init() {
		boolean array[] = new boolean[333333];
		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}
		
		System.out.println("halla");
		LIST.add(2);
		for (int j = 2*2; j < array.length; j += 2) {
			array[j] = false;
		}
		for (int i = 3; i < array.length; i=i+2) {
			if (array[i]) {
				LIST.add(i);
				for (int j = 2 * i; j < array.length; j += i) {
					array[j] = false;
				}
			}
		}
	}

	public static boolean[] primeArrayBetween(long start, long limit) {
		limit++;
//		limit-=start;
		boolean[] array = new boolean[(int)(limit-start)];
		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}
		
//		 0 = 1000
//		32 = 1032   1031/7?
//		5761457
//		5761457 (4374 ms)
		
		for (int t = 0; t < LIST.size(); ++t) {
			int i = LIST.get(t);
//			System.out.print(i);
			long s = (start/i);
			s*=i;
			if (s != start)
				s+=i;
//			System.out.println(", " +s);
			for (long j = s; j < limit; j += i) {
				if (j != i) {
					array[(int)(j-start)] = false;
				}
			}
		}
		return array;
	}
	
	public static boolean[] primeArray(int limit) {

		limit++;
		boolean[] array = new boolean[limit];
		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}
		
//		 0 = 1000
//		32 = 1032   1031/7?
//		5761457
//		5761457 (4374 ms)
		
		long start = System.currentTimeMillis();
		
		for (int j = 2*2; j < array.length; j += 2) {
			array[j] = false;
		}
		for (int i = 3; i <= Math.sqrt(limit); i=i+2) {
			if (array[i]) {
				for (int j = 2 * i; j < limit; j += i) {
					array[j] = false;
				}
			}
		}
		System.out.println("("+(System.currentTimeMillis()-start)+" ms)");
		
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < array.length; i++) {
//			if (array[i]) 
//				list.add(i);
//		}
//		
//		byte[] M = new byte[10];
//		for (int i = 0; i < list.size(); i++) {
//			byte[] teMp = new byte[10];
//			int tall = list.get(i);
//			
//			while (true) {
//				teMp[tall%10]++;
//				tall/=10;
//				if (tall == 0)
//					break;
//			}
//			
//			for (int j = 0; j < teMp.length; j++) {
//				if (teMp[j] > M[j])
//					M[j] = teMp[j];
//			}
//		}
//		
//		for (int i = 0; i < M.length; i++) {
//			System.out.println(M[i]);
//		}
//		
//		
//		long[] S = new long[10];
//		for (int i = 0; i < list.size(); i++) {
//			byte[] teMp = new byte[10];
//			int tall = list.get(i);
//			
//			while (true) {
//				teMp[tall%10]++;
//				tall/=10;
//				if (tall == 0)
//					break;
//			}
//			
//			for (int j = 0; j < teMp.length; j++) {
//				if (teMp[j] == M[j]) {
//					S[j]+=list.get(i);
//				}
//			}
//		}
//		
//		long sum = 0;
//		for (int i = 0; i < M.length; i++) {
//			sum+=S[i];
//			System.out.println(S[i]);
//		}
//		System.out.println(sum);
		return array;
	}
}
