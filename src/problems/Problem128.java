package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.Euler;

public class Problem128 {
	
	public static int PD(long[] arr, long tall) {
		int pd = 0;
		for (long i : arr) {
			long diff = Math.abs(tall - i);
			if (Euler.isPrime(diff))
				++pd;
		}
		return pd;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {

		int[] PD = new int[100000];
		long[] corners = new long[6];
		long[] oldCorners = new long[6];
		long forste = 0;
		List<Long> list = new ArrayList<Long>();
		//antall tiles per layer
		ytterste:
		for (long layers = 1; layers < 200000; layers++) {
//			System.out.println("Hjørner:"+Arrays.toString(corners));
			long siste = 6*sum(layers)-6*layers+1;
//			System.out.println("Siste tile layer "+layers+": "+siste);
			
			//her printes de som ikke er hjørner hæhæ
//			int diffInn = corners[0]-første;
//			//husk siste
//			int inn1 = (siste-diffInn);
//			int inn2 = første;
//			System.out.println(siste+" -> " + inn1 + " & "+ inn2);
			
			forste = corners[0];
			
			long[] newCorners = new long[6];
			for (int i = 0; i < 6; i++) {
				newCorners[i] = (siste+1+i*layers);
			}
			//TODO: husk første
//			System.out.println((newCorners[0]+1)+ " "+ newCorners[0]+" "+(6*sum(layers+1)-6*(layers+1)+1) +" <- "+corners[0] + " -> " + siste + ", " + oldCorners[0]);
			long[] rundts = new long[] { (6*sum(layers+1)-6*(layers+1)+1), (6*sum(layers+1)-6*(layers+1)), corners[0], (corners[0]-1), oldCorners[0] };
			int pd2 = PD(rundts, siste);
			if (pd2 >= 3) {
				list.add(siste);
				Collections.sort(list);
//				System.out.println(siste + " -> " + Arrays.toString(rundts) + " " + pd2);
//				System.out.println(list.size());
			}
			
			for (int i = 0; i < oldCorners.length; i++) {
				long[] rundt;
				if (i == 0) {
					rundt = new long[] { (newCorners[0]+1), newCorners[0], (6*sum(layers+1)-6*(layers+1)+1), siste, oldCorners[0] };
				} else {
					rundt = new long[] {(newCorners[i]+1), newCorners[i], (newCorners[i]-1), oldCorners[i] };
				}
				int pd = PD(rundt, corners[i]);
				if (pd >= 3) {
					list.add(corners[i]);
					Collections.sort(list);
//					System.out.println(corners[i] + " -> " +Arrays.toString(rundt) + " " + pd);
//					System.out.println(list.size());
					if (list.size() > 2100)
						break ytterste;
				}
					
//				System.out.println((newCorners[i]+1) + " "+ newCorners[i] + " " +(newCorners[i]-1) + " <- "+corners[i]+" -> "+oldCorners[i]);
			}
			oldCorners = corners;
			corners = newCorners;
		}
		
//		for (int i = 0; i < PD.length; i++) {
//			if (PD[i] == 3)
//				System.out.println(i);
//		}
//		System.out.println(PD[17]);
//		for (int layers = 1; layers < 12; layers++) {
//			System.out.println("Hjørner:"+Arrays.toString(corners));
//			int siste = 6*sum(layers)-6*layers+1;
//			System.out.println("Siste tile layer "+layers+": "+siste);
//			
//			//her printes de som ikke er hjørner hæhæ
//			int diffInn = corners[0]-første;
//			for (int i = 0; i < corners.length; i++, diffInn++) {
//				/**
//				 * ta med før og etter på 3 linjer inn i array og alt skal gå bra
//				 * spør inn om primtall, la andre si fra at de er
//				 */
//				int denne = corners[i];
//				int inn = denne-diffInn;
//				if (Euler.isPrime(denne-inn) && inn >= 0) {
//					PD[inn]++;
//					PD[denne]++;
//				}
//				System.out.println(denne+" -> "+(corners[i]-diffInn));
////				if (corners[i])
//				for (int j = corners[i]+1; j < (i==5?siste:corners[i+1]); j++) {
//					denne = j;
//					int inn1 = (j-diffInn);
//					int inn2 = (j-diffInn-1);
//					if (Euler.isPrime(denne-inn1)) {
//						PD[inn1]++;
//						PD[denne]++;
//					}
//					if (Euler.isPrime(denne-inn2)) {
//						PD[inn2]++;
//						PD[denne]++;
//					}
//					System.out.println(j + " -> " + inn1 + " & " + inn2);
//				}
//			}
//			//husk siste
//			int inn1 = (siste-diffInn);
//			int inn2 = første;
//			if (Euler.isPrime(siste-inn1)) {
//				PD[inn1]++;
//				PD[siste]++;
//			}
//			if (Euler.isPrime(siste-inn2)) {
//				PD[inn2]++;
//				PD[siste]++;
//			}
//			System.out.println(siste+" -> " + inn1 + " & "+ inn2);
//			
//			første = corners[0];
//			
//			int[] newCorners = new int[6];
//			for (int i = 0; i < 6; i++) {
//				newCorners[i] = (siste+1+i*layers);
//			}
//			System.out.println();
//			corners = newCorners;
//		}
//		
//		for (int i = 0; i < PD.length; i++) {
//			if (PD[i] == 3)
//				System.out.println(i);
//		}
//		System.out.println(PD[17]);
//		System.out.println(list.get(10));
//		System.out.println(list.get(2000));
		return list.get(2000);
	}

	public static long sum(long n) {
		return ((n+1)*n)/2;
	}
}
