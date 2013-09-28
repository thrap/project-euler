package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Problem11 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	public static int solution() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem11.txt"));
		int[][] board = new int[20][20];
		String line;
		int i  = 0;
		while ((line = in.readLine())!=null) {
			int j = 0;
			for (String n : line.split(" ")) {
				board[i][j] = Integer.parseInt(n);
				++j;
			}
			++i;
		}
		
		int max = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				int prod = 1;
				for (int t = 0; t < 4; t++) {
					try {
						prod*=board[x+t][y-t];
					} catch (Exception e) {}
				}
				max = Math.max(prod, max);
			}
		}
		return max;
	}
}
