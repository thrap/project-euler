public class Problem220v2 {
	
	private static enum Direction {
		NORTH(0,1), SOUTH(0,-1), WEST(-1,0), EAST(1,0);
		
		int x, y;
		private Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Direction turnLeft() {
			if (this == NORTH) {
				return WEST;
			} else if (this == SOUTH) {
				return EAST;
			} else if (this == WEST) {
				return SOUTH;
			} else {
				return NORTH;
			}
		}

		public Direction turnRight() {
			if (this == SOUTH) {
				return WEST;
			} else if (this == NORTH) {
				return EAST;
			} else if (this == EAST) {
				return SOUTH;
			} else {
				return NORTH;
			}
		}
	}
	
	public static void main(String[] args) {
		Direction direction = Direction.NORTH;
		int x = 0;
		int y = 1;
		for (long n = 1; n < 1000000000000L; n++) {
			boolean left = (((n & -n) << 1) & n) != 0;
			if (left) {
				direction = direction.turnLeft();
			} else {
				direction = direction.turnRight();
			}
			
			x+=direction.x;
			y+=direction.y;
			if (n % 100000000 == 0)
				System.out.println(n+": ("+x+", "+y+")");
		}
		System.out.println("("+x+", "+y+")");
	}
}
