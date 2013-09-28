package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.text.html.MinimalHTMLWriter;

public class Problem83treg {

			
	static int SIZE = 80;
	static int[][] kant = new int[SIZE*SIZE][SIZE*SIZE];
	static int[][] next = new int[SIZE*SIZE][SIZE*SIZE];
	
	public static void main(String[] args) throws IOException {
		
		int[][] input = new int[SIZE][SIZE];
		
		for (int i = 0; i < kant.length; i++) {
			for (int j = 0; j < kant.length; j++) {
				kant[i][j] = 1000000000;
				next[i][j] = Integer.MAX_VALUE;
			}
		}
		
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem81.txt"));
		for (int i = 0; i < input.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " , ");
			for (int j = 0; j < input.length; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				System.out.print(input[i][j] + " ");
				kant[i*SIZE+j][i*SIZE+j] = 0;
				try {kant[i*SIZE+j][(i-1)*SIZE+(j)] = input[i-1][j]; }catch (ArrayIndexOutOfBoundsException e) {}
				try {kant[i*SIZE+j][(i+1)*SIZE+(j)] = input[i+1][j]; }catch (ArrayIndexOutOfBoundsException e) {}
				try {kant[i*SIZE+j][(i)*SIZE+(j-1)] = input[i][j-1]; }catch (ArrayIndexOutOfBoundsException e) {}
				try {kant[i*SIZE+j][(i)*SIZE+(j+1)] = input[i][j+1]; }catch (ArrayIndexOutOfBoundsException e) {}
			}
			System.out.println();
		}
		
//		13    for k := 1 to n
//		14       for i := 1 to n
//		15          for j := 1 to n
//		16             path[i][j] = min ( path[i][j], path[i][k]+path[k][j] );
		
		
		for (int k = 0; k < kant.length; k++) {
			if (k % 100 == 0)
				System.out.println(k);
			for (int i = 0; i < kant.length; i++) {
				for (int j = 0; j < kant.length; j++) {
					
//					if (kant[i][j] > kant[i][k]+kant[k][j]) {
//						kant[i][j] = kant[i][k]+kant[k][j];
//						next[i][j] = k;
//					}
					kant[i][j] = Math.min(kant[i][j], kant[i][k]+kant[k][j]);
				}
			}
		}
//		for (int i = 0; i < kant.length; i++) {
//			for (int j = 0; j < kant.length; j++) {
//				System.out.print(kant[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(kant[0][SIZE*SIZE-1]);
		
//		 1 procedure FloydWarshallWithPathReconstruction ()
//		 2    for k := 1 to n
//		 3       for i := 1 to n
//		 4          for j := 1 to n
//		 5             if path[i][k] + path[k][j] < path[i][j] then
//		 6                path[i][j] := path[i][k]+path[k][j];
//		 7                next[i][j] := k;
//		 8
//		 9 procedure GetPath (i,j)
//		10    if path[i][j] equals infinity then
//		11      return "no path";
//		12    int intermediate := next[i][j];
//		13    if intermediate equals 'null' then
//		14      return " ";   /* there is an edge from i to j, with no vertices between */
//		15    else
//		16      return GetPath(i,intermediate) + intermediate + GetPath(intermediate,j);
		
		
//		naboer[i][j] = Integer.parseInt(st.nextToken());

		
	}
	public static String getPath(int i, int j) {
		if (kant[i][j] == Integer.MAX_VALUE) {
			return "no path";
		}
		int intermediate = next[i][j];
		System.out.println(intermediate);
		if (intermediate == 0) {
			return " ";
		}
		else return getPath(i,intermediate) + intermediate + getPath(intermediate,j);
	}
}
