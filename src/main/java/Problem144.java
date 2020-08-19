public class Problem144 {
	
	//ta dette inn i wolfram: -14*(x - 1.4)-9.6 = y, 4*x^2+y^2=100
	public static void main(String[] args) {
		double startX=0.0;
		double startY = 10.1;
		double endX = 1.4;
		double endY = -9.6;
		
		double a = (endY-startY)/(endX-startX);
		System.out.println(a+"(X-"+endX+")"+endY);
		double m = -4.0*endX/endY;
		System.out.println(a*m);
	}
}
