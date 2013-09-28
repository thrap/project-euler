package problems;

import java.util.Arrays;
import java.util.List;

public class Problem213 {
	public static void main(String[] args) {
		int[][] grid = new int[2][2];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], 1);
		}
		
		print(grid);
		
		ring(grid,0,0,grid[0][0]);
	}

	private static void ring(int[][] grid, int x, int y, int fleas) {
		
		
	}

	private static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
