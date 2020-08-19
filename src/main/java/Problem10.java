import utils.Euler;
import utils.T;

public class Problem10 {

	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() + " " + t);
	}
	
	public static long solution() {
		long sum = 0;
        for(int p : Euler.primeList(2000000))
            sum += p;
		return sum;
	}
}
