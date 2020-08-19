import java.util.Random;

public class Problem227BedreBaseCase {
	public static void main(String[] args) {
//		//0, begge 0 eller left+right = 18/36
//		//1, en left, andre 0 = 8/36
//		//-1 en right, andre 0 = 8/36
//		//2, begge left = 1/36
//		//-2 begge right = 1/36
		
		int players = 100;
		int games = 1000000;
		double totalTurns = 0;
		
		for (int i = 0; i < games; i++) {
			if (i % 1000 == 0)
				System.out.println(i);
			Game game = new Game(players);
			
			while (game.nextTurn());
			
			totalTurns+=game.turns;
		}
		System.out.println(totalTurns/games);
	}
	
	private static class Game {
		private int diff;
		private final int MAX_DIFF;
		private int turns = 0;
		
		public Game(int players) {
			this.diff = players/2;
			this.MAX_DIFF = diff;
			this.diff = 1;
		}

		public boolean nextTurn() {
			++turns;
			diff+=roll();
			if (diff < 0)
				diff = -diff;
			else if (diff > MAX_DIFF) {
				diff = 2*MAX_DIFF-diff;
			}
			return diff != 0;
		}
	}

	static Random random = new Random();
	private static int roll() {
		//0 : 0-17
		//1 : 18-25
		//-1: 26-33
		//2 : 34
		//-2: 35
		int roll = random.nextInt(36);
		if (roll >= 18 && roll <= 25) {
			//1
			return 1;
		} else if (roll >= 26 && roll <= 33) {
			//-1
			return -1;
		} else if (roll == 34) {
			//2
			return 2;
		} else if (roll == 35) {
			//-2
			return -2;
		} else {
			//0
			return 0;
		}
	}
}
