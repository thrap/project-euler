package problems;

public class Problem174 {
	private static final int TILES = 1000000;
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		//(tiles-4)/4 = heltall
		//med 100: ytterste = 96/4 = 24 per side, prøv med 23 per side - se at det ikke går
		int teller = 0;
		int[] array = new int[TILES+1];
		for (int bredde = ((TILES-4)/4); bredde >= 1; bredde--) {
			int tilesLeft = TILES-((bredde*4)+4);
			int sum = ((bredde*4)+4);
			array[sum]++;
//					System.out.print(bredde + ": " + bredde);
			for (int i = 1; (bredde-2*i) >= 1 ; i++) {
				sum += (((bredde-2*i)*4)+4);
				tilesLeft -= (((bredde-2*i)*4)+4);
				if (tilesLeft < 0) 
					break;
				array[sum]++;
				teller++;
//						System.out.print(", " + (bredde-2*i));
			}
//					System.out.println();
			teller++;
			
//					}
//					System.out.println(teller);
		}
		
		int[] svarArray = new int[15];
		for (int i = 0; i < array.length; i++) {
//					System.out.println(i + ": " + array[i]);
			if (1<= array[i] && array[i] <= 15)
				svarArray[array[i]-1]++;
		}
		int svar = 0;
		for (int i = 0; i < 10; i++) {
			svar+=svarArray[i];
		}
//				System.out.println(svarArray[14]);
		return (svar);
	}
}
