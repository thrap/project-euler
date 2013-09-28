package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem67 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	public static int solution() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem67.txt"));
		String linje = in.readLine();
		StringTokenizer st = new StringTokenizer(linje);
		int hoyde = 100;
		int[][] weights = new int[hoyde][hoyde];
		int[][] shortest = new int[hoyde][hoyde];
		
		
		//setter noder
		for (int i = 0; i < weights.length; i++) {
			st = new StringTokenizer(linje);
			int j = 0;
			while (st.hasMoreTokens()) {
				weights[i][j] = Integer.parseInt(st.nextToken());
				
				
				shortest[i][j] = Integer.MAX_VALUE;
				j++;
			}
			while (j < weights.length) {
				weights[i][j] = Integer.MAX_VALUE;
				j++;
			}
//			System.out.println();
			linje = in.readLine();
		}
		
//		for (int i = 0; i < shortest.length; i++) {
//			for (int j = 0; j < shortest.length; j++) {
//				System.out.print(weights[i][j] + " ");
////				System.out.print(shortest[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		shortest[0][0] = weights[0][0];
		for (int j = 0; j < shortest.length; j++) {
			for (int i = 1; i < shortest.length; i++) {
				shortest[i][0] = weights[i][0] + shortest[i-1][0];
				shortest[i][i] = weights[i][i] + shortest[i-1][i-1];
			}
		}
		
		for (int j = 0; j < shortest.length-2; j++) {
			int x = 2+j;
			int y = 1+j;
			if (shortest[x-1][y] < shortest[x-1][y-1])
				shortest[x][y] = weights[x][y] + shortest[x-1][y-1];
			else 
				shortest[x][y] = weights[x][y] + shortest[x-1][y];
//			System.out.println(shortest[x][y]);
			
			for (int i = 1; i < shortest.length-x; i++) {
				if (shortest[x+i-1][y] < shortest[x+i-1][y-1])
					shortest[x+i][y] = weights[x+i][y] + shortest[x+i-1][y-1];
				else
					shortest[x+i][y] = weights[x+i][y] + shortest[x+i-1][y];
				
				if (shortest[x+i-1][y+i] < shortest[x+i-1][y-1+i])
					shortest[x+i][y+i] = weights[x+i][y+i] + shortest[x+i-1][y-1+i];
				else
					shortest[x+i][y+i] = weights[x+i][y+i] + shortest[x+i-1][y+i];
			}
		}
		
		
		for (int i = 0; i < shortest.length; i++) {
			for (int j = 0; j < shortest.length; j++) {
				if (weights[i][j] == Integer.MAX_VALUE)
					break;
//				System.out.print(weights[i][j] + " ");
				
//				System.out.print(shortest[i][j] + " ");
			}
//			System.out.println();
		}
		
		int storste = 0;
		
		for (int i = 0; i < shortest.length; i++) {
			if (storste < shortest[99][i])
				storste = shortest[99][i];
		}
		return storste;
	}
}
