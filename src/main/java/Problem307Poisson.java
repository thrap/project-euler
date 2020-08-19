import java.math.BigDecimal;

public class Problem307Poisson {
	public static void main(String[] args) {
		BigDecimal sum = BigDecimal.ZERO;
		for (int k = 3; k <= defects && k<100; k++) {
			sum = sum.add(P(k));
			System.out.println(sum);
		}
		System.out.println(sum.toString().substring(0, 12));
//		System.out.println(BigDecimal.ONE.subtract(sum).pow(1000));
		System.out.println(1-Math.pow(1-sum.doubleValue(), chips));
	}
	
	static double defects = 20000;
	static double chips = 1000000;
	
	static double n = defects;
	static double p = 1.0/chips;
	static BigDecimal lambda = BigDecimal.valueOf(n).multiply(BigDecimal.valueOf(p));
	static BigDecimal eLambda = BigDecimal.valueOf(Math.pow(Math.E, -lambda.doubleValue()));
	
	public static BigDecimal P(int k) {
		return (lambda.pow(k).multiply(eLambda).divide(fact(k), 100, BigDecimal.ROUND_UP));
	}
	
	public static BigDecimal fact(int k) {
		BigDecimal prod = BigDecimal.ONE;
		for (int i = 2; i <= k; i++) {
			prod = prod.multiply(BigDecimal.valueOf(i));
		}
		return prod;
	}
}
