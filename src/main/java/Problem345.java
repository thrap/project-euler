import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import utils.Euler;

public class Problem345 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:/python27/input.txt"));
		String line = null;
		
		final int bredde = 15;
		int[][] array = new int[bredde][bredde];
		DecimalFormat df = new DecimalFormat("000");
		
		for (int j = 0;(line = br.readLine()) != null; j++) {
			StringTokenizer st = new StringTokenizer(line);
			for (int i = 0;st.hasMoreTokens();i++) {
				array[j][i] = Integer.parseInt(st.nextToken());
				System.out.print(df.format(array[j][i]) + " ");
			}
			System.out.println();
		}
		int teller = 0;
		int beste = 0;
		int test[] = {12,0,1,2,3,4,5,6,7,8,9,10,11,13,14};
		//0, 5, 8, 12
		int i = 0;
		do {
			int sum = array[test[0]][0] + array[test[1]][1] + array[test[2]][2] + 
					array[test[3]][3] + array[test[4]][4] + array[test[5]][5] + array[test[6]][6]
							 + array[test[7]][7] + array[test[8]][8] + array[test[9]][9] + array[test[10]][10]
									 + array[test[11]][11] + array[test[12]][12] + array[test[13]][13] + array[test[14]][14];
			if (sum>beste)
				beste = sum;
			if (i++ %100000000 == 0) {
				for (int j = 0; j < test.length; j++) {
					System.out.print(test[j]);
				}
				System.out.println(": "+beste);
			}
		} while (Euler.permute(test, test.length));
		System.out.println(beste);
	}
}
