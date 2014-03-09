package Java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Problem212Observation {
	private static class Cuboid {
		int x, y, z, dx, dy, dz;
		
		public Cuboid(int x, int y, int z, int dx, int dy, int dz) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.dx = dx;
			this.dy = dy;
			this.dz = dz;
		}
		
		public String toString() {
			return "{("+x+","+y+","+z+"),("+dx+","+dy+","+dz+")}";
		}
		
		public boolean intersects(Cuboid c) {
			return ((x > c.x && x < c.x + c.dx) && 
					(y > c.y && y < c.y + c.dy) && 
					(z > c.z && z < c.z + c.dz)) || 
					((c.x > x && c.x < x + dx) && 
					(c.y > y && c.y < y + dy) && 
					(c.z > z && c.z < z + dz));
		}
		
		public Cuboid getIntersection(Cuboid c) {
			int x = Math.max(this.x, c.x);
			int y = Math.max(this.y, c.y);
			int z = Math.max(this.z, c.z);
			
			int dx = (x == this.x ? Math.min(this.dx, c.dx - (this.x - c.x)) : Math.min(c.dx, this.dx - (c.x - this.x)));
			int dy = (y == this.y ? Math.min(this.dy, c.dy - (this.y - c.y)) : Math.min(c.dy, this.dy - (c.y - this.y)));
			int dz = (z == this.z ? Math.min(this.dz, c.dz - (this.z - c.z)) : Math.min(c.dz, this.dz - (c.z - this.z)));
			
			return new Cuboid(x,y,z, dx,dy,dz);
		}
		
		public Collection<Cuboid> getNewCuboids(Cuboid c) {
			return null;
		}
		
		public long volume() {
			return dx*dy*dz;
		}
	}
	
	public static void main(String[] args) {
		List<Cuboid> cuboids = getCuboids(100);
		List<Cuboid> intersections = new ArrayList<Cuboid>();
		
		long sum = 0;
		for (int i = 0; i < cuboids.size(); i++) {
			if (i % 100 == 0)
				System.out.println(i + " " + cuboids.size());
			
			Cuboid c1 = cuboids.get(i);
			sum+=c1.volume();
			for (int j = i+1; j < cuboids.size(); j++) {
				Cuboid c2 = cuboids.get(j);
				
				if (c1.intersects(c2)) {
//						System.out.println(i + " " + j);
					intersections.add(c1.getIntersection(c2));
					sum -= c1.getIntersection(c2).volume();
				}
			}
		}
		
		System.out.println(sum);
	}

	private static List<Cuboid> getCuboids(int limit) {
		long[] S = getS();
		List<Cuboid> cuboids = new ArrayList<Cuboid>();
		for (int n = 1; n <= limit; n++) {
			int x = (int)S[6*n-5] % 10000;
			int y = (int)S[6*n-4] % 10000;
			int z = (int)S[6*n-3] % 10000;
			
			int dx = 1+(int)S[6*n-2] % 399;
			int dy = 1+(int)S[6*n-1] % 399;
			int dz = 1+(int)S[6*n] % 399;
			
			cuboids.add(new Cuboid(x,y,z, dx,dy,dz));
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
