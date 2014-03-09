package Java;

import java.util.ArrayList;
import java.util.List;

public class Problem212 {
	private static class Cuboid {
		int x, y, dx, dy;
		
		public Cuboid(int x, int y, int dx, int dy) {
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
		}
		
		public String toString() {
			return "{("+x+","+y+"),("+dx+","+dy+")}";
		}
	}
	
	public static void main(String[] args) {
		List<Cuboid>[] cuboids = getCuboids(50000);
		long volume = 0;
		for (int x = 0; x < cuboids.length; x++) {
			System.out.println(x);
			volume += getVolumeNaive(cuboids[x]);
		}
		System.out.println(volume);
	}

	private static long getVolumeNaive(List<Cuboid> list) {
		boolean[][] taken = new boolean[10400][10400];
		for (Cuboid C : list) {
			for (int i = 0; i < C.dx; i++) {
				for (int j = 0; j < C.dy; j++) {
					taken[C.x+i][C.y+j] = true;
				}
			}
		}
		
		long volume = 0;
		for (int i = 0; i < taken.length; i++) {
			for (int j = 0; j < taken.length; j++) {
				if(taken[i][j])
					volume++;
			}
		}
		return volume;
	}

	private static List<Cuboid>[] getCuboids(int limit) {
		long[] S = getS();
		List<Cuboid>[] cuboids = new ArrayList[10400];
		for (int i = 0; i < cuboids.length; i++) {
			cuboids[i] = new ArrayList<Cuboid>();
		}
		int count = 0;
		
		for (int n = 1; n <= limit; n++) {
			if (n % 100 == 0)
				System.out.println(n + " " + count);
			int x = (int)S[6*n-5] % 10000;
			int y = (int)S[6*n-4] % 10000;
			int z = (int)S[6*n-3] % 10000;
			
			int dx = 1+(int)S[6*n-2] % 399;
			int dy = 1+(int)S[6*n-1] % 399;
			int dz = 1+(int)S[6*n] % 399;
			
			for (int offset = 0; offset < dz; offset++) {
				count++;
				cuboids[z+offset].add(new Cuboid(x,y, dx,dy));
			}
		}
		return cuboids;
	}

	private static long[] getS() {
		long[] S = new long[300000+1];
		for (long k = 1; k <= 55; k++) {
			S[(int)k] = (100003L- 200003L*k + 300007L*k*k*k) % 1000000L;
		}
		for (int k = 56; k <= 300000; k++) {
			S[k] = (S[k-24] + S[k-55]) % 1000000L;
		}
		
		return S;
	}
}
