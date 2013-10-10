package problems;

import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem359BaseCase {
	
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
			return rooms.toString();
		}
	}

	static List<Floor> floors = new ArrayList<Floor>();
	
	public static void main(String[] args) {
		floors.add(new Floor(1));
		ytterste:
		for (int guest = 2; guest < 200000; guest++) {
			for (Floor floor : floors) {
				if (floor.canAddGuest(guest)) {
					floor.addGuest(guest);
					continue ytterste;
				}
			}
			floors.add(new Floor(guest));
		}
		
		System.out.println("P(1, 1) = "+P(1,1));
		System.out.println("P(1, 2) = "+P(1,2));
		System.out.println("P(2, 1) = "+P(2,1));
		System.out.println("P(10, 20) = "+P(10,20));
		System.out.println("P(25, 75) = "+P(25,75));
		System.out.println("P(99, 100) = "+P(99,100));
	}

	private static int P(int f, int r) {
		return floors.get(f-1).rooms.get(r-1);
	}
}
