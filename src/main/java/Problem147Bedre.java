public class Problem147Bedre {
	private static class Block {
		final int limitX;
		final int limitY;
		final double north;
		final double south;
		final double east;
		final double west;
		
		public Block(double x, double y, int w, int h) {
			this.limitX = w;
			this.limitY = h;

			north = y;
			south = y;
			west = x;
			east = x;
		}
		
		public long sum() {
			long blocks = 0;
			
			double n,s,e,w;
			for (int height = 1; true; height++) {
				e = east+0.5*height;
				s = south-0.5*height;
				if (e > limitX || s < 0)
					break;
				
				for (int width = 1; true; width++) {
					n = north+0.5*width;
					//feil her kanskje?
					e = east+0.5*height+0.5*width-0.5;
					s = south-0.5*height;
					if (e > limitX || s < 0 || n > limitY)
						break;
					blocks++;
				}
			}
			return blocks;
		}
		
	}
	
	private static class Board {
		double x;
		double y;
		int w;
		int h;

		public Board(int w, int h) {
			x = 1.0;
			y = 0.5;
			this.w = w;
			this.h = h;
		}
		
		public long blocks() {
			long sum = 0;
			
			do {
				sum += lineSum();
			} while (nextLine());
			
			return sum;
		}
		
		private long lineSum() {
			long sum = 0;
			
			double limit = w-x;
			for (int i = 0; i < limit; i++) {
				Block block = new Block(x+i, y, w, h);
				sum += block.sum();
//				System.out.println("("+(x+i) + ", "+y+")");
			}
			
			return sum;
		}

		public boolean nextLine() {
			y += 0.5;
			x = (x==0.5)? 1.0:0.5;
			
			return h-y >=0.5;
		}
	}
	
	//denne er riktig
	static long normalSum(int x, int y) {
		long sum = 0;
		for (int w = 1; w <= x; w++) {
			for (int h = 1; h <= y; h++) {
				sum+=rect(w,h,x,y);
			}
		}
		return sum;
	}
	
	static long rect(long w, long h, long x, long y) {
		long sum = (x-(w-1))*(y-(h-1));
		if (sum > 0)
			return sum;
		else
			return 0;
	}
	
	static long sum(int x, int y) {
		return normalSum(x,y)+tiltedSum(x,y);
	}
	
	private static long tiltedSum(int x, int y) {
		return new Board(x, y).blocks();
	}

	private static long sumAll(int x, int y) {
		long sum = 0;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				sum+=sum(i,j);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(normalSum(3,2) + " er summen ikke-snudde i 3x2");
		System.out.println(tiltedSum(3,2) + " er summen snudde i 3x2");
		System.out.println(sumAll(47,43));
	}
}
