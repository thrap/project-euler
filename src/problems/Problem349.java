package problems;


public class Problem349 {
	private static long blacks(long moves) {
		//starter på 19000 og ut fra brute er 19000 = 1760
		//13000 mellom hver sum av arr
		int[] arr = {120, 112, 114, 122, 112, 114, 118, 112, 118, 116, 114, 114, 114};
		long sum = 0;
		for (int i : arr) {
			sum+=i;
		}
		moves-=19000;
		long blacks = 1760;
		long ant = moves/13000;
		blacks+=ant*sum;
		
		moves-=ant*13000;
		
		for (int i = 1000; i <= moves; i+=1000) {
			blacks+=arr[i/1000];
		}
		return blacks;
	}
	static long moves = 1000000000000000000L;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
		
//		int length = 10000;
//		boolean[][] black = new boolean[length][length];
//		Ant ant = new Ant(black);
		
//		int last = 0;
//		List<Integer> list = new ArrayList<Integer>();
//		boolean asd = false;
//		for (int i = 1; i <= moves; i++) {
//			ant.move();
//			if (i % 1000 == 0) {
//				int antall = count(black);
//				System.out.println(antall-last);
//				if (antall-last == 120) {
//					System.out.println(i + " " + count(black)); 
//					asd = true;
//				}
//				if (asd)
//					list.add(antall-last);
//				last = antall;
//			}
//		}
		
//		System.out.println(list);
//		System.out.println(count(black));
		
//		for (int y = 0; y < black.length; y++) {
//			for (int x = 0; x < black.length; x++) {
//				System.out.print(black[x][y]?"X":" ");
//			}
//			System.out.println();
//		}
	}
	public static long solution() {
		return blacks(moves);
	}
	
//	static enum Direction {
//	LEFT(-1, 0), RIGHT(1, 0), UP(0,-1), DOWN(0,1);
//	
//	int x;
//	int y;
//	Direction(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	Direction turnClockwise() {
//		switch(this) {
//			case LEFT: return UP;
//			case UP: return RIGHT;
//			case RIGHT: return DOWN;
//			case DOWN: return LEFT;
//		}
//		return null;
//	}
//	
//	Direction turnCounterclockwise() {
//		switch(this) {
//			case LEFT: return DOWN;
//			case DOWN: return RIGHT;
//			case RIGHT: return UP;
//			case UP: return LEFT;
//		}
//		return null;
//	}
//}
//
//static class Ant {
//	int x;
//	int y;
//	Direction direction = Direction.LEFT;
//	boolean[][] black;
//	
//	public Ant(boolean[][] black) {
//		this.black = black;
//		x = black.length/2;
//		y = x;
//	}
//	
//	public void move() {
//		if (black[x][y]) {
//			direction = direction.turnCounterclockwise();
//		} else {
//			direction = direction.turnClockwise();
//		}
//		black[x][y] = !black[x][y];
//		x+=direction.x;
//		y+=direction.y;
//	}
//}
//
	
//	private static int count(boolean[][] black) {
//		int count = 0;
//		for (int y = 0; y < black.length; y++) {
//			for (int x = 0; x < black.length; x++) {
//				if (black[y][x])
//					count++;
//			}
//		}
//		return count;
//	}
}
