import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem137brute {
	private static class Fib {
		BigDecimal b = BigDecimal.ZERO;
		BigDecimal c = BigDecimal.ONE;
		
		public BigDecimal getNext() {
			BigDecimal temp = c;
			c = b.add(c);
			b = temp;
			return b;
		}
	}
	
	private static final double PHI = 0.5*(1+Math.sqrt(5));
	public static void main(String[] args) {
		System.out.println(PHI);
		//phi*|x| < 1
		double overz = 1;
		double underz = 2;
		int ITERATIONS = 5000;
		while(true) {
			double x = overz/underz;
			if (x*PHI < 1) {
				System.out.println("konvergens");
			} else {
				underz++;
				continue;
			}
			System.out.println(overz+"/"+underz);
			BigDecimal xOver = BigDecimal.valueOf(overz);
			BigDecimal xUnder = BigDecimal.valueOf(underz);
			BigDecimal tallet = BigDecimal.ZERO;
			Fib fib = new Fib();
			BigDecimal over = fib.getNext();
			BigDecimal under = xUnder;
			for (int i = 1; i < ITERATIONS; i++) {
				BigDecimal nytt = over.divide(under, 200, RoundingMode.HALF_UP);
				tallet = tallet.add(nytt);
				over = fib.getNext().multiply(xOver.pow(i));
				under = under.multiply(xUnder);
				if (i == ITERATIONS-1) {
					System.out.println(tallet.setScale(10, RoundingMode.HALF_UP));
					if (nytt.compareTo(BigDecimal.ONE.divide(BigDecimal.valueOf(100))) <= 0) {
						
						overz++;
					} else {
						underz++;
					}
					
				}
			}
		}
		
	}
}
