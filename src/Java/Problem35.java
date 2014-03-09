package Java;

import utils.Euler;


public class Problem35 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	static boolean[] PRIME = Euler.primeArray(1000000);

	public static int solution() {
		int count = 1;
		ytterste:
		for (int i = 3; i < PRIME.length; i+=2) {
			if (PRIME[i]) {
				String number = ""+i;
				for (int j = 0; j < number.length(); j++) {
					number = number.substring(1)+number.charAt(0);
					if (!PRIME[Integer.parseInt(number)])
						continue ytterste;
				}
				count++;
			}
			
		}
		return count;
	}
}
