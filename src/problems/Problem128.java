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
			long siste = 6*sum(layers)-6*layers+1;

			forste = corners[0];
			
			long[] newCorners = new long[6];
			for (int i = 0; i < 6; i++) {
				newCorners[i] = (siste+1+i*layers);
			}
			long[] rundts = new long[] { (6*sum(layers+1)-6*(layers+1)+1), (6*sum(layers+1)-6*(layers+1)), corners[0], (corners[0]-1), oldCorners[0] };
			int pd2 = PD(rundts, siste);
			if (pd2 >= 3) {
				list.add(siste);
				Collections.sort(list);
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
					if (list.size() > 2100)
						break ytterste;
				}
					
			}
			oldCorners = corners;
			corners = newCorners;
		}
		
		return list.get(2000);
	}

	public static long sum(long n) {
		return ((n+1)*n)/2;
	}
}
