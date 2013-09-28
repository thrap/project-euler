package problems;

public class Problem226 {
	
	final static int maxN = 1000;
	
	public static void main(String[] args) {
		/**
		 * NIntegrate[(1/2 (1-sqrt(2) sqrt(x-2 x^2))),{x,0.07890796661376953,0.5},WorkingPrecision->20] = 0.12231067396528976755
		 */
		System.out.println(I(0.5)-I(0.07890796661376953)-0.12231067396528976755);
		
		
//		double step = Math.pow(0.5, 20);
//		System.out.println(step);
//		
//		double min = Double.MAX_VALUE;
//		int count = 0;
//		for (int i = 0; i*step < 0.25; i++) {
//			double x = i*step;
//			double y = T(x);
//			
//			if (Math.abs((x-0.25)*(x-0.25)+(y-0.5)*(y-0.5) - 0.25*0.25) < min) {
//				min = Math.abs((x-0.25)*(x-0.25)+(y-0.5)*(y-0.5) - 0.25*0.25);
//				
//				if (count % 100000000 == 0) {
//					System.out.println("Min: "+min);
//					System.out.println("x = "+x);
//					System.out.println("y = "+y);
//				}
//			}
//		}
	}

	private static double T(double x) {
		double sum = 0;
		for (int n = 0; n < maxN; n++) {
			sum += s(Math.pow(2, n)*x)/Math.pow(2, n);
		}
		return sum;
	}

	private static double s(double d) {
		double over = d-Math.floor(d);
		double under = Math.ceil(d)-d;
		
		return Math.min(over, under);
	}

	private static double I(double x) {
		if (x < 0.00000000001)
			return 0;
		if (x>=1) 
			return 0.5 + I(x-1);
		else if (x > 0.5)
			return 0.5 - I(1-x);
		else if (x >= 0)
			return I(2*x)/4 + x*x/2;
		else 
			return -I(-x);
	}
}
