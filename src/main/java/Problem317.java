import java.util.Map;
import java.util.TreeMap;

public class Problem317 {
	
	private static final int v = 20;
	private static final double g = 9.81;
	public static void main(String[] args) {
		
		Map<Double, Double> map = new TreeMap<Double, Double>();
		
		int steps = 500000;
		double h = 0.0005;
		double maxX = 0;
		for (double i = 0; i<steps; i++) {
			if (i%10 == 0)
			System.out.println(i/100 + "/" + steps/100);
			double theta = Math.PI*(i/steps);

			double vx = Math.cos(theta)*v;
			double vy = Math.sin(theta)*v;
			
			
			
			for (int j = 0; true; j++) {
				double x = h*j;
				double y = 100 + vy/vx*x-0.5*9.81/(vx*vx)*x*x;
				if (y < 0)
					break;
				maxX = Math.max(x, maxX);
				if (map.containsKey(x)) {
					map.put(x, Math.max(map.get(x), y));
				} else {
					map.put(x, y);
				}
			}
		}
//		1856532.8660016698
//		1856532.8450579229
//		1856532.8449
//		1856532.8318308378
//		1856532.8199723882
//		1856532.8199723882
//		1856531.6064001548
//		1856532.844935271
//		1856532.8454017292
//		1856532.8449285505
//		1856532.845383554
//		1856532.84540173
//		1856532.8453755223
		System.out.println(maxX);
		
		double b = maxX;
		double a = 0;
		int n = (int) (b/h);
		double s = a*map.get(a) + b*map.get(b);
		double maxdiff = 0;
		for (int j = 1; j < n; j+=2) {
			s += 4*h*j*map.get(j*h);
			
			double diff = Math.abs(map.get(j*h)-f(j*h));
			if (diff > maxdiff) {
				System.out.println(diff);
				maxdiff = diff;
			}
//			System.out.println(map.get(j*h));
//			System.out.println(f(j*h));
		}
		for (int j = 2; j < n-1; j+=2) {
			s += 2*h*j*map.get(j*h);
		}
		

		s = s*h / 3;
		System.out.println(s*Math.PI*2);
		
		double s2 = a*map.get(a) + b*map.get(b);
		for (int j = 1; j < n; j+=2) {
			s2 += 4*h*j*f(j*h);
			
//			System.out.println(map.get(j*h));
//			System.out.println(f(j*h));
		}
		for (int j = 2; j < n-1; j+=2) {
			s2 += 2*h*j*f(j*h);
		}
		

		s2 = s2*h / 3;
		System.out.println(s2*Math.PI*2);
		
		double volume = 0;
		double lastX = 0;
		for (double x : map.keySet()) {
			
			double vol = Math.PI*(x*x-lastX*lastX)*0.5*(map.get(x)+map.get(lastX));
			volume += vol;
			lastX = x;
		}
		System.out.println(volume);
		
	
		System.out.println(f(1));
		System.out.println(Math.PI/2);
	}
	private static double f(double x) {
		double theta = Math.acos(x/Math.sqrt(4.15644+x*x));
		double vx = Math.cos(theta)*v;
		double vy = Math.sin(theta)*v;

		double t = x/vx;
//		System.out.println("theta = "+theta);
//		System.out.println(t*vx);
//		System.out.println("t = " +t);
		return 100 + vy*t-0.5*g*t*t+18.399593280554868;
	}
}
