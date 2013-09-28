package problems;


public class Problem173FF {
	private static final int TILES = 1000000;
	
	public static void main(String[] args) {
		//(tiles-4)/4 = heltall
		//med 100: ytterste = 96/4 = 24 per side, prøv med 23 per side - se at det ikke går
		int teller = 0;
		for (int bredde = ((TILES-4)/4); bredde >= 1; bredde--) {
			
			int tilesLeft = TILES-((bredde*4)+4);
//			System.out.print(bredde + ": " + bredde);
			for (int i = 1; (bredde-2*i) >= 1 ; i++) {
				tilesLeft -= (((bredde-2*i)*4)+4);
				if (tilesLeft < 0) 
					break;
				teller++;
//				System.out.print(", " + (bredde-2*i));
			}
//			System.out.println();
			teller++;
			
		}
		System.out.println(teller);
	}
}
