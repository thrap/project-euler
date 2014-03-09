package Java;

import java.util.Random;

public class Problem227baseCase {
	public static void main(String[] args) {
		int players = 100;
//		int rolls = 10000000;
//		int diff = players/2;
//		
//		//0, begge 0 eller left+right = 18/36
//		//1, en left, andre 0 = 8/36
//		//2, begge left = 1/36
//		//-2 begge right = 1/36
//		//-1 en right, andre 0 = 8/36
		
		
		int games = 10000;
		int totalRounds = 0;
		for (int game = 0; game < games; game++) {
			if (game % 100 == 0)
				System.out.println(game);
			
			Position pos1 = new Position(0, players);
			Position pos2 = new Position(1, players);
			int rounds = 1;
			while (pos1.roll() != pos2.roll()) {
				++rounds;
			}
			totalRounds += rounds;
		}
		System.out.println((double)totalRounds/games);
	}
	
	public static class Position {
		static Random r = new Random();
		
		int pos;
		int players;
		
		public Position(int pos, int players) {
			this.pos = pos;
			this.players = players;
		}
		
		public int roll() {
			switch (new Random().nextInt(6)+1) {
			case 1: passLeft(); break;
			case 6: passRight(); break;
			}
			
			return pos;
		}

		private void passRight() {
			if (++pos == players) {
				pos = 0;
			}
		}

		private void passLeft() {
			if (--pos == -1) {
				pos = players-1;
			}
		}
	}
}
