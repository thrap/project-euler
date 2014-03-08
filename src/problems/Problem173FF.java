package problems;


public class Problem173FF {
	private static final int TILES = 1000000;
	
	public static void main(String[] args) {
		int teller = 0;
		for (int bredde = ((TILES-4)/4); bredde >= 1; bredde--) {
			
			int tilesLeft = TILES-((bredde*4)+4);
			for (int i = 1; (bredde-2*i) >= 1 ; i++) {
				tilesLeft -= (((bredde-2*i)*4)+4);
				if (tilesLeft < 0) 
					break;
				teller++;
			}
			teller++;
			
		}
		System.out.println(teller);
	}
}
