import utils.Euler;

public class Problem3 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		long tall = 600851475143L;
		int best = 0;
		for (int prime : Euler.primeList((int)Math.sqrt(tall))) {
			if (tall%prime==0)
				best = prime;
		}
		return best;
	}
}
