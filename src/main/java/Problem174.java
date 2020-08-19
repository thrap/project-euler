public class Problem174 {
	private static final int TILES = 1000000;
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int teller = 0;
		int[] array = new int[TILES+1];
		for (int bredde = ((TILES-4)/4); bredde >= 1; bredde--) {
			int tilesLeft = TILES-((bredde*4)+4);
			int sum = ((bredde*4)+4);
			array[sum]++;
			for (int i = 1; (bredde-2*i) >= 1 ; i++) {
				sum += (((bredde-2*i)*4)+4);
				tilesLeft -= (((bredde-2*i)*4)+4);
				if (tilesLeft < 0) 
					break;
				array[sum]++;
				teller++;
			}
			teller++;
		}
		
		int[] svarArray = new int[15];
		for (int i = 0; i < array.length; i++) {
			if (1<= array[i] && array[i] <= 15)
				svarArray[array[i]-1]++;
		}
		int svar = 0;
		for (int i = 0; i < 10; i++) {
			svar+=svarArray[i];
		}
		return (svar);
	}
}
