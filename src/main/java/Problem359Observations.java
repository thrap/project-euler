import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem359Observations {
	
	private static class Floor {
		List<Integer> rooms = new ArrayList<Integer>();
		int lastGuest;
		
		public Floor(int firstGuest) {
			addGuest(firstGuest);
		}
		
		public void addGuest(int guest) {
			rooms.add(guest);
			lastGuest = guest;
		}

		public boolean canAddGuest(int guest) {
			return Euler.isPerfectSquare(guest+lastGuest);
		}
		
		public String toString() {
			List<String> temp = new ArrayList<String>();
			for (int room : rooms) {
				temp.add(new DecimalFormat("000").format(room));
			}
			return temp.toString();
		}
	}

	static List<Floor> floors = new ArrayList<Floor>();
	
	public static void main(String[] args) {
		
		//Kombinasjonen av disse loeser oppgaven ja?
		
		// P(2n+1, 1) = 2*n*(n+1)
		// P(2n, 1) = 2*n*n
		/**
		 * if (f+r) % 2 == 0:  P(f,r) = P(f-2, r+2)+1
		 * if (f+r) % 2 == 1:  P(f,r) = P(f-2, r+2)-1

		 * if (f+r) % 2 == 0:  P(f+2,r-2) = P(f, r)+1
		 * if (f+r) % 2 == 1:  P(f+2,r-2) = P(f, r)-1
		 */
		
		floors.add(new Floor(1));
		ytterste:
		for (int guest = 2; guest < 1000; guest++) {
			for (Floor floor : floors) {
				if (floor.canAddGuest(guest)) {
					floor.addGuest(guest);
					continue ytterste;
				}
			}
			floors.add(new Floor(guest));
		}
		
		for (Floor floor : floors) {
			System.out.println(floor);
		}
		
		ytterste:
		for (int guest = 1000; guest < 200000; guest++) {
			for (Floor floor : floors) {
				if (floor.canAddGuest(guest)) {
					floor.addGuest(guest);
					continue ytterste;
				}
			}
			floors.add(new Floor(guest));
		}
		
		for (int f = 4; f < 300; f++) {
			for (int r = 3; r < 300; r++) {
				if (Pbra(f,r) != P(f,r)) {
					System.out.println("FUCKSHITNIG");
					System.out.println(f + " " + r);
					System.out.println(Pbra(f,r));
					System.out.println(P(f,r));
				}
			}
		}
		
		System.out.println(P(1,11));

		testFaenskap();
	}

	private static long Pbra(int f, int r) {
		if (r == 2) {
			if ((f+r)%2 == 1)
				return Pbra(f, r-1)+1;
			else 
				return Pbra(f, r+1)-2;
		}
		if (r == 1) {
			int n = f/2;
			return (f % 2 == 0 ? 2*n*n : 2*n*(n+1));
		}
		int k = (r-1)/2;
		return Pbra(f + 2*k, r-2*k) + ((f+r)%2 == 1 ? k : -k);
	}

	private static void testFaenskap() {
		for (int n = 1; n < 300; n++) {
			if (P(2*n+1,1) != 2*n*(n+1)) {
				System.out.println("Fuck dawg");
			}
			if (P(2*n,1) != 2*n*n) {
				System.out.println("Fuck dawg");
			}
		}
		
		for (int f = 4; f < 300; f++) {
			for (int r = 3; r < 300; r++) {
				if ((f+r)%2 == 0 && P(f,r) != P(f-2,r+2)+1) {
					System.out.println("Fittefjesfaen");
					System.exit(0);
				}
				if ((f+r)%2 == 1 && P(f,r) != P(f-2,r+2)-1) {
					System.out.println("Fittefjesfaen");
					System.exit(0);
				}
				if ((f+r) % 2 == 0 &&  P(f+2,r-2) != P(f, r)+1) {
					System.out.println("Lol");
				}
				if ((f+r) % 2 == 1 &&  P(f+2,r-2) != P(f, r)-1) {
					System.out.println("Lol");
				}
			}
		}
	}

	private static int P(int f, int r) {
		return floors.get(f-1).rooms.get(r-1);
	}
}
