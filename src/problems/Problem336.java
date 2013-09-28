package problems;

import java.util.ArrayList;
import java.util.List;

import utils.Euler;


public class Problem336 {
	public static void main(String[] args) {
		
		int[] perm = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int max = 0;
		List<String> trains = new ArrayList<String>();
		do {
			int[] train = perm.clone();
			
			int antall = 0;
			for (int i = 0; i < train.length; i++) {
				if (train[i] == i)
					continue;
				int index = find(train, i);
				if (index == train.length-1) {
					reverse(train, i);
					antall += 1;
				} else {
					reverse(train, index);
					reverse(train, i);
					antall += 2;
				}
			}
			if (antall > max) {
				System.out.println(toString(perm) + " " + antall);
				max = antall;
				trains.clear();
			}
			if (antall == max) {
				trains.add(toString(perm));
			}
		} while(Euler.permute(perm, perm.length));
		System.out.println(trains.size());
		System.out.println(trains.get(2010));
	}
	
	private static String toString(int[] perm) {
		char[] arr = new char[perm.length];
		for (int i = 0; i < perm.length; i++) {
			arr[i] = (char) (perm[i]+'A');
		}
		return String.valueOf(arr);
	}

	private static int find(int[] train, int i) {
		for (int j = i+1; j < train.length; j++) {
			if (train[j] == i)
				return j;
		}
		return -1;
	}

	public static void reverse(int[] train, int start) {
		int swaps = (train.length-start)/2;
		for (int i = 0; i < swaps; i++) {
			int temp = train[train.length-1-i];
			train[train.length-1-i] = train[i+start];
			train[i+start] = temp;
		}
	}
}
