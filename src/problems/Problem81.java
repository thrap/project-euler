package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem81 {
	public static void main(String[] args) throws IOException{
		
		System.out.println(solution());
		for (int i = 0; i < shortest.length; i++) {
			for (int j = 0; j < shortest.length; j++) {
				if (weights[i][j] == 0) {
					System.out.print("     ");
				}
				else
					System.out.print(new DecimalFormat("0000").format(weights[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println(solution());
	}
static int[][] shortest;
static int[][] weights;
	public static int solution() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem81.txt"));
		String linje = in.readLine();
		String asd = ",";
//		StringTokenizer st = new StringTokenizer(linje," , ");
		StringTokenizer st = new StringTokenizer(linje, asd);
		weights = new int[st.countTokens()][st.countTokens()];
		shortest = new int[st.countTokens()][st.countTokens()];
		
		
		//setter noder
		for (int i = 0; i < weights.length; i++) {
//			st = new StringTokenizer(linje, " , ");
			st = new StringTokenizer(linje, asd);
			for (int j = 0; j < weights.length; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
				
				
				shortest[i][j] = Integer.MAX_VALUE;
			}
//			System.out.println();
			linje = in.readLine();
		}
//		System.out.println(weights[0][0]);
		//setter barn til noder
		shortest[0][0] = weights[0][0];
		for (int i = 1; i < shortest.length; i++) {
			shortest[i][0] = shortest[i-1][0] + weights[i][0];
		}
		for (int i = 1; i < shortest.length; i++) {
			shortest[0][i] = shortest[0][i-1] + weights[0][i];
		}
		
		for (int j = 1; j < weights.length; j++) {
			if (shortest[j][j-1] > shortest[j-1][j])
				shortest[j][j] = shortest[j-1][j] + weights[j][j];
			else
				shortest[j][j] = shortest[j][j-1] + weights[j][j];
			
			for (int i = j+1; i < weights.length; i++) {
				if (shortest[i][j] > shortest[i-1][j] + weights[i][j])
					shortest[i][j] = shortest[i-1][j] + weights[i][j];
				if (shortest[i][j] > shortest[i][j-1] + weights[i][j])
					shortest[i][j] = shortest[i][j-1] + weights[i][j];
			}
			for (int i = j+1; i < shortest.length; i++) {
				if (shortest[j][i] > shortest[j][i-1] + weights[j][i])
					shortest[j][i] = shortest[j][i-1] + weights[j][i];
				if (shortest[j][i] > shortest[j-1][i] + weights[j][i]) {
					shortest[j][i] = shortest[j-1][i] + weights[j][i];
				}
				
			}
		}
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < 80*2-2; i++) {
			weights[x][y] = 0;
//			System.out.println(x + "," +y + " ("+i+")");
			if (y == 79) {
				x++;
				continue;
			}
			if (x==79)
				break;
			if (shortest[x+1][y] < shortest[x][y+1])
				x++;
			else 
				y++;
		}
		
		weights[79][79] = 0;
		
//	
		
		return shortest[79][79];
	}
}
