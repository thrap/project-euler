import utils.Euler;

public class Problem7 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int count = 1;
		for (int i = 3; true; i+=2) {
			if (Euler.isPrime(i)) 
				if (++count == 10001) 
					return i;
		}
	}
}
