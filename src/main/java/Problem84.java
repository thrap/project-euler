import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem84 {
	static class Player {
		private static final int GO_TO_JAIL = 30;
		private static final int JAIL = 10;
		private static final int CC1 = 2;
		private static final int CC2 = 17;
		private static final int CC3 = 33;
		private static final int CH1 = 7;
		private static final int CH2 = 22;
		private static final int CH3 = 36;
		
		int pos = 0;
		int doubles = 0;
		
		private static Random r = new Random();
		
		public int move(int dice1, int dice2) {
			if (dice1 == dice2) {
				if (++doubles == 3) {
					doubles = 0;
					return pos = JAIL;
				}
			} else {
				doubles=0;
			}
			pos=(pos+=dice1+dice2)%40;
			if (pos == GO_TO_JAIL) {
				return pos = JAIL;
			} else if (pos == CC1 || pos == CC2 || pos == CC3) {
				pickCC();
			} else if (pos == CH1 || pos == CH2 || pos == CH3) {
				pickCH();
			}
			return pos;
		}
		
		private int pickCard() {
			return r.nextInt(16)+1;
		}
		
		private void pickCC() {
			int card = pickCard();
			if (card == 1) {
				pos = 0;
			} else if (card == 2) {
				pos = JAIL;
			}
		}
		
		private void pickCH() {
			switch(pickCard()) {
			case 1: pos = 0; break;
			case 2: pos = JAIL; break;
			case 3: pos = 11; break;
			case 4: pos = 24; break;
			case 5: pos = 39; break;
			case 6: pos = R1; break;
			case 7: pos = nextR(); break;
			case 8: pos = nextR(); break;
			case 9: pos = nextU(); break;
			case 10: pos = (40+(pos-3))%40; break;
			}
		}
		
		private static final int R1 = 5;
		private static final int R2 = 15;
		private static final int R3 = 25;
		private static final int R4 = 35;
		
		private int nextR() {
			if (pos >= R4 || pos < R1)
				return R1;
			if (pos < R2)
				return R2;
			if (pos < R3)
				return R3;
			return R4;
		}
		
		private static final int U1 = 12;
		private static final int U2 = 28;
		
		private int nextU() {
			if (pos >= U1 && pos < U2)
				return U2;
			return U1;
		}
	}
	
	private static Random r = new Random();
	
	public static void main(String[] args) {
		System.out.println(solution());
//		101524
//		24 = 32
//		10 = 70
//		15= 36
	}
	
	public static String solution() {
		int[] board = new int[40];
		
		Player p = new Player();
		
		int moves = 1000000;
		for (int i = 0; i < moves; ++i) {
			int dice1 = throwDice();
			int dice2 = throwDice();
			
			++board[p.move(dice1, dice2)];
		}
		
		List<Tuppel> list = new ArrayList<Tuppel>();
		for (int i = 0; i < board.length; i++) {
			list.add(new Tuppel(i, (double)board[i]/moves));
		}
		Collections.sort(list);
//		System.out.println(list);
//		System.out.print("\nSvar: ");
		String ans = "";
		for (Tuppel tuppel : list.subList(0, 3)) {
			ans+=(new DecimalFormat("00").format(tuppel.plass));
		}
		return ans;
	}

	static class Tuppel implements Comparable<Tuppel>{
		int plass;
		Double sannsynlighet;
		
		public Tuppel(int p, double s) {
			plass = p;
			sannsynlighet = s;
		}
		
		@Override
		public String toString() {
			return ""+new DecimalFormat("00").format(plass) + " ("+(int)(sannsynlighet*100)+"."+new DecimalFormat("00").format((int)(sannsynlighet*100000+5)/10%100)+"%)";
		}

		@Override
		public int compareTo(Tuppel arg0) {
			return arg0.sannsynlighet.compareTo(sannsynlighet);
		}
	}
	
	private static final int DICE = 4;
	public static int throwDice() {
		return r.nextInt(DICE)+1;
	}
}
