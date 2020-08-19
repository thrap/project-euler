import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem82 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
		
	}

	public static int solution() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem81.txt"));
		String linje = in.readLine();
//		String asd = ",";
		StringTokenizer st = new StringTokenizer(linje," , ");
//		StringTokenizer st = new StringTokenizer(linje);
		
		int[][] weights = new int[st.countTokens()][st.countTokens()];
		int[][] shortest = new int[st.countTokens()][st.countTokens()];
		
		for (int i = 0; i < weights.length; i++) {
			st = new StringTokenizer(linje, " , ");
//			st = new StringTokenizer(linje);
			for (int j = 0; j < weights.length; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
				
				
				shortest[i][j] = Integer.MAX_VALUE;
			}
//			System.out.println();
			linje = in.readLine();
		}
		
		for (int i = 0; i < shortest.length; i++) {
			shortest[i][0] = (weights[i][0]);
		} 
		for (int j = 1; j < shortest.length; j++) {
			for (int i = 0; i < shortest.length; i++) {
				shortest[i][j] = (weights[i][j]) + shortest[i][j-1];
			}
			for (int a = 0; a < shortest.length; a++) {
				for (int i = 1; i < shortest.length; i++) {
					if (shortest[i][j] > shortest[i-1][j] + weights[i][j])
						shortest[i][j] = shortest[i-1][j] + weights[i][j];
				}
				for (int i = 0; i < shortest.length-1; i++) {
					if (shortest[i][j] > shortest[i+1][j] + weights[i][j])
						shortest[i][j] = shortest[i+1][j] + weights[i][j];
				}
			}
		}
		
		for (int i = 0; i < shortest.length; i++) {
			for (int j = 0; j < shortest.length; j++) {
//				System.out.print(shortest[i][j]+" ");
			}
//			System.out.println();
		}
		
		int storste = Integer.MAX_VALUE;
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i][79] < storste)
				storste = shortest[i][79];
		}
		return storste;
	}
}
