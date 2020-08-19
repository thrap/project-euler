import utils.Euler;

public class Problem175 {
	public static void main(String[] args) {
		//f(0) = 1
		//f(2k) = f(k)+ f(k-1)
		//f(2k+1) = f(k) 
		
		long start = System.currentTimeMillis();
		System.out.println(SBE(13, 17));
		System.out.println(SBE(123456789,987654321) + " ("+(System.currentTimeMillis()-start)+" ms)");
	}

	private static String SBE(int n, int d) {
		int gcd = (int)Euler.gcd(n, d);
		n/=gcd;
		d/=gcd;
		System.out.println(n + "/" + d);
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (n == d) {
				sb.append(1);
				
				sb = sb.reverse();
				break;
			} else if (n < d) {
				sb.append(1);
				d -= n;
			} else {
				sb.append(0);
				n -= d;
			}
		}
		StringBuilder svar = new StringBuilder();
		int count = 0;
		int forrige = 1;
		for (int i = 0; i < sb.length(); i++) {
			int denne = sb.charAt(i)-'0';
			if (denne == forrige) {
				count++;
			} else {
				forrige = denne;
				svar.append(count+",");
				count=1;
			}
		}
		return svar+""+count;
	}
}
