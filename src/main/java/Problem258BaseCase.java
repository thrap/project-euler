import java.math.BigInteger;
import java.util.Arrays;

public class Problem258BaseCase {
	public static void main(String[] args) {

		BigInteger[] g = new BigInteger[(int) (Math.pow(10, 7)+1)];
		
		Arrays.fill(g, BigInteger.ONE);
		int like = 0;
		for (int k = 2000; k < g.length; k++) {
			g[k] = g[k-2000].add(g[k-1999]);//(g[(k-2000)] + g[(k-1999)])%20092010;
			g[k-2000] = null;
			if (g[k].equals(g[k-1])) {
				like++;
			} else {
				if (like > 0)
				System.out.println(like + " " + k + " " + g[k].toString().length());
				like = 0;
			}
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(g.length-1-i+": "+g[g.length-1-i].mod(BigInteger.valueOf(20092010)));
		}
	}
}
