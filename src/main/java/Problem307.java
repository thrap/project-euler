import java.math.BigDecimal;

public class Problem307 {
	public static void main(String[] args) {

		double svar = P(3, 20000, 1000000).doubleValue();
		double prob = 1-svar;
		System.out.println(prob);
		System.out.println(svar);
	}
	
	public static BigDecimal P(int defects, int totalDefects, int totalChips) {
		if (defects > totalDefects)
			return BigDecimal.ZERO;
		
		int k = defects;
		double p = 1.0/totalChips;
		int n = totalDefects;
		
		return choose(3, n).multiply(pow(p, k)).multiply(pow(1-p, n-k));
	}
	
	public static BigDecimal pow(double p, int exp) {
		return BigDecimal.valueOf(p).pow(exp);
	}
	
	
	public static BigDecimal choose(int k, int n) {
		BigDecimal prod = BigDecimal.ONE;
		for (int i = 0; i < k; i++) {
			prod = prod.multiply(BigDecimal.valueOf(n-i));
		}
		return prod.divide(fact(k));
	}
	
	public static BigDecimal fact(int k) {
		BigDecimal prod = BigDecimal.ONE;
		for (int i = 2; i <= k; i++) {
			prod = prod.multiply(BigDecimal.valueOf(i));
		}
		return prod;
	}
}

