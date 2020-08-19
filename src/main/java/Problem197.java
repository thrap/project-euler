import java.util.HashSet;
import java.util.Set;

public class Problem197 {
	
	public static double f(double x) {
		return (long)Math.pow(2, 30.403243784-(x*x))*0.000000001;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static double solution() {
		double un = -1;
		Set<Double> set = new HashSet<Double>();
		double answ = 0;
		for (int i = 0; i < 1000; i++) {
//			System.out.println(un);
			un = f(un);
			if (set.contains(un)) {
//				System.out.println("omgomgomg " + i + " " + un);
			}
			set.add(un);
			if (i >= 998) {
				answ+=un;
			}
		}
//		System.out.println(answ);
		return answ;
	}
}