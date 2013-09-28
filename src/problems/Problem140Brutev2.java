package problems;

import java.util.Set;
import java.util.TreeSet;

public class Problem140Brutev2 {
	private static final double PHI = 0.5*(1+Math.sqrt(5));
	
	public static void main(String[] args) {
		System.out.println(sum((Math.sqrt(22)-2)/6));
		
		Set<Long> set = new TreeSet<Long>();
		int count = 0;
		
		//a = 3/2-1/(2*sqrt(5))
		//b = 0.1*(15+sqrt(5))
		//gn = a*phi^n+b*(-phi)^n
		
		//må finne konvergensradius til  ((3/2-1/(2*sqrt(5)))((1+sqrt(5))/2)^n + 1/10*(15+sqrt(5))((1-sqrt(5))/2)^n)*x^n
		//lol lim an+1 / an = 1/2*(1+sqrt(5))*|x| < 1 -> a < 2b/(1+sqrt(5)) 
		//|x| < 2/(1+sqrt(5))
		/**
		 * må finne konvergensradius omg
		 */
		for (long a = 1; true; a++) {
			for (long b = (long) (PHI*a); b < (5*a)/2; b++) {
				long sum = sum(a, b);
				if (sum > 0 && !set.contains(sum)) {
					set.add(sum);
					count++;
					System.out.println(a + " " + b);
					System.out.println(sum);
					System.out.println(set.size() + " tall hæhæ");
					System.out.println(set);
//					System.out.println(sum((double)a/(double)b));
					if (count == 40) 
						System.exit(0);
				}
			}
		}
	}
	
	//dette er generating function
	public static double sum(double x) {
		return (x+3*x*x)/(1-x*x-x);
	}
	
	public static long sum(long a, long b) {
		if ((a*(3*a+b)) % (b*b - a*a - a*b) != 0)
			return 0;
		return (a*(3*a+b))/(b*b - a*a - a*b);
	}
}
