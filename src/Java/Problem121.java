package Java;

import java.math.BigInteger;

public class Problem121 {
	
	static int turns = 15;
	
	public static void main(String[] args) {
		
		
		long start = System.currentTimeMillis();
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static BigInteger solution() {
		Java.Problem183.Rational ans = new Java.Problem183.Rational(BigInteger.ZERO, BigInteger.ONE);
		for (int i = 0; i < Math.pow(2, turns); i++) {
			String binary = legalBinary(Integer.toBinaryString(i));
			if (isWinner(binary)) {
				BigInteger over = BigInteger.ONE;
				BigInteger under = BigInteger.ONE;
				for (int j = 0; j < binary.length(); j++) {
					under = under.multiply(BigInteger.valueOf(j+2));
					if (binary.charAt(j) == '0') 
						over = over.multiply(BigInteger.valueOf(j+1));
				}
				ans = ans.add(new Java.Problem183.Rational(over, under));
			}
		}
		return ans.d.divide(ans.n);
//		System.out.println(ans);
	}

	private static String legalBinary(String binaryString) {
		for (int i = binaryString.length(); i < turns; i++) {
			binaryString = "0"+binaryString;
		}
		return binaryString;
	}

	private static boolean isWinner(String binary) {
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1')
				++count;
		}
		return count>turns/2;
	}
}
