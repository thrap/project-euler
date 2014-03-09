package Java;

import java.awt.geom.Line2D;

public class Problem144lol {
	public static void main(String[] args) {
		double startX1 = 0;
		double startY1 = 10.1;
		double endX1 = 1.4;
		double endY1 = -9.6;
		
		double startX2 = endX1;
		double startY2 = endY1;
		double endX2 = endY1+endX1;
		double endY2 = -4*endX1+endY1;
		
		
		Line2D line1 = new Line2D.Double(startX1, startY1, endX1, endY1);
		Line2D line2 = new Line2D.Double(startX2, startY2, endX2, endY2);
		
		System.out.println(angleBetween2Lines(line1, line2));
	}
	
	public static double angleBetween2Lines(Line2D line1, Line2D line2) {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                                   line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                                   line2.getX1() - line2.getX2());
        return 180.0 / Math.PI *(angle1-angle2);
    }
}