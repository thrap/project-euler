public class Problem431 {
	
	public static final int R = 6;
	public static final double deg = 2*Math.PI/9.0;
	
	public static void main(String[] args) {
		double sum = 0;
		for (int n = (int) Math.sqrt(integrate(0))+1; n <= Math.sqrt(integrate(R)); n++) {
			double temp = binarySearch(n*n, 0, R);
			sum+=temp;
			System.out.println(n*n + " : "+ temp);
		}
		System.out.println(sum);
	}
	
	static double binarySearch(double value, double min, double max) {
		if ((long)(Math.abs(min-max)*Math.pow(10, 12))==0)
			return min;
		double mid = (min + max) / 2;
		double val = integrate(mid);
		if (val > value)
			return binarySearch(value, min, mid);
		else if (val < value)
			return binarySearch(value, mid, max);
		else
			return mid;
	}
	
	
	public static double integrate(double x) {
		double b = 2 * Math.PI;
		double a = 0;
		int n = 1000;
		double h = (b - a) / n;
		double s = f(a, x) + f(b, x);

		for (int i = 1; i < n; i += 2) {
			s += 4*f(i*h, x);
		}
		for (int i = 2; i < n - 1; i += 2) {
			s += 2*f(i*h, x);
		}
		return s * h / 3;
	}
	
	public static double f(double theta, double x) {
		return (Math.tan(deg)/3 * Math.sqrt(R*R+x*x*(Math.cos(2*theta)-1)*0.5) *(R*R+x*x* (2*Math.cos(2*theta)+1)));
	}
}
