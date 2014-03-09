package Java;

import java.util.Random;

public class Problem307asd {
	public static void main(String[] args) {
		
		double sanns = 0;
		int hit = 0;
		int ant = 10000000;
		for (int i = 0; i < ant; i++) {
			
			int[] count = new int[7];
			for (int j = 0; j < 3; j++) {
				++count[new Random().nextInt(7)];
			}
			for (int j = 0; j < count.length; j++) {
				if (count[j] == 3)
					hit++;
			}
		}
		System.out.println(hit + " " + ant);
	}
}
