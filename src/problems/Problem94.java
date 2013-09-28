package problems;

public class Problem94 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		for (long x = 2; 3*x < 400000000; ++x) {
			if (isPerfectSquare(3*x*x-2*x-1)) {
				if ((x+1)*(Math.sqrt(3*x*x-2*x-1)) % 4 == 0) {
//					System.out.println(x);
					sum+=2*x+x+1;
				}
			}
			if (isPerfectSquare(3*x*x+2*x-1)) {
				if ((x-1)*(Math.sqrt(3*x*x+2*x-1)) % 4 == 0) {
//					System.out.println(x);
					sum+=2*x+x-1;
				}
			}
		}
		return sum;
	}

	public static boolean isPerfectSquare(long input) {
	    long closestRoot = (long) Math.sqrt(input);
	    return input == closestRoot * closestRoot;
	}
}
