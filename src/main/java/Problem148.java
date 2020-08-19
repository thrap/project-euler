public class Problem148 {
	public static void main(String[] args) {
		System.out.println(solution());
    }

	public static long solution() {
		return count(1000000000L);
	}

	private static long sum(long r) {
		return ((r+1)*r)/2;
	}

	private static long count(long r) {
        int p = (int)Math.floor(Math.log(r)/Math.log(7)); //floor(log7(r))
		long rNext = r % (long)Math.pow(7,p);

        r/=Math.pow(7, p);

		if (rNext < 7) {
            return sum(7) + (r+1)*sum(rNext);
		} else {
            return (long)Math.pow(sum(7), p)* sum(r) + (r+1)*count(rNext);
		}
	}
}
