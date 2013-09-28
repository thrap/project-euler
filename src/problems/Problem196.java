package problems;

import java.text.DecimalFormat;
import java.util.List;

import utils.Euler;

public class Problem196 {
	
	public static List<Integer> LIST = Euler.primeList((int)Math.sqrt(t(7208785)));
	
	public static void main(String[] args) {
		System.out.println(solution());
		
	}
	
	public static long solution() {
//		boolean[] prime = Euler.primeArray(1000);
//		prime[1] = false;
//		int t = 1;
//		for (int i = 1; i < 45; i++) {
//			for (int j = 0; j < i; j++, ++t) {
//				if (prime[t])
//					System.out.print("*** ");
//				else
//					System.out.print(new DecimalFormat("000").format(t)+" ");
//			}
//			System.out.println();
//		}
		
//		System.out.println(LIST);
//		79697256800321526
//		242605983970758409
		int radnr = 7208785;
		boolean[][] rader = new boolean[5][];
		for (int rad = -2; rad <= 2; rad++) {
			long start = t(radnr+rad-1)+1;
			long slutt = t(radnr+rad);
			boolean[] row = primeArrayBetween(start, slutt);
			rader[2+rad] = row;
//			System.out.println(Arrays.toString(row));
			
		}
		
//		for (int i = 0; i < rader.length; i++) {
//			for (int j = 0; j < rader[i].length; j++) {
//				long start = t(radnr+i-2-1)+1;
//				if (rader[i][j])
//					System.out.print("** ");
//				else 
//					System.out.print(new DecimalFormat("00").format(start+j)+" ");
//			}
//			System.out.println();
//		}
		
		long sum = 0;
		long start = t(radnr-1)+1;
		for (int i = 0; i < rader[2].length; i++) {
			if (rader[2][i]) {
				boolean funnet = false;
				int ant = 0;
				for (int j = -1; j <= 1; ++j) {
					for (int j2 = -1; j2 <= 1; ++j2) {
						try {
							if (!(j2 == 0 && j == 0) && rader[2+j][i+j2]) {
								++ant;
//								System.out.println(start+i);
								for (int p = -1; p <= 1; ++p) {
									for (int x = -1; x <= 1; ++x) {
										try {
											if (!(p == 0 && x == 0) && !(j+p== 0 && j2+x == 0) && rader[2+j+p][i+j2+x]) {
												funnet = true;
											}
										} catch (Exception e) {
											
										}
									}
								}
							}
						} catch (Exception e) {
							
						}
					}
				}
				if (funnet || ant>=2) {
//					System.out.println(start+i);
					sum+=start+i;
				}
			}
		}
		return (sum + 79697256800321526L);
	}

	public static long t(long i) {
		return (i*(i+1))/2;
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
}
