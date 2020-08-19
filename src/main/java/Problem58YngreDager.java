public class Problem58YngreDager {
	public static void main(String[] args) {
		boolean[] primtall = Test.primtallUnder(6500000);
		System.out.println("halla");
		
		int pluss = 2; 
		int tall = 1;
		int primteller = 0;
		int teller = 1;
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 4; j++) {
				tall+=pluss;
				if (tall > primtall.length) {
					if (Test.erPrimtall(tall))
						primteller++;
				}
				else if (primtall[tall])
					primteller++;
				teller++;
			}
			pluss+=2;
			if ((double)primteller/teller < 0.1) {
				System.out.println(pluss-1);
				break;
			}
		}
		System.out.println(primteller + "/"+teller);
	}
}
