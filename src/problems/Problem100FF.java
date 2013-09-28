package problems;

public class Problem100FF {
	public static long blue = Long.valueOf("19306983");
	public static long disks = Long.valueOf("27304197");
	
	public static void main(String[] args) {
		
		for (int i = 0; true; i++) {
			if ((blue*(blue-1)) == (disks*(disks-1))/2) {
				System.out.println("hei!");
			}
		}
		
//		for (int i = 0; true; i++) {
//			Rational c = new Rational(blue,disks);
//			Rational b = new Rational((blue-1),(disks-1));
//			Rational a = new Rational(c.n*b.n,c.d*b.d);
//			if (a.isLessThan()) {
//				blue++;
//			}
//			else 
//				disks++;
//		}
		
	}
}

//class Rational {
//	long n;
//	long d;
//	public Rational(long n, long d) {
//		this.n = n;
//		this.d = d;
//		simplify();
//	}
//	
//	private void simplify() {
//		long t = gcd();
//	    n /= t;
//	    d /= t;
//
//	    if (d < 0) {
//	        n *= -1;
//	        d *= -1;
//	    }
//	}
//	
//	public boolean isLessThan() {
//		if (n*2 == d) {
//			System.out.println("FY FAEN HÆHÆHÆHÆ\nDet finnes: \n" + Problem100.blue + " blå\n"+(Problem100.disks-Problem100.blue)+" røde\n"+Problem100.disks+" disker");
////			System.exit(0);
//		}
//	    return (n*2 < d);
//	}
//	
//	private long gcd() {
//	    long a = n;
//	    if (a < 0) {
//	        a *= -1;
//	    }
//	    long b = d;
//	    if (b < 0) {
//	        b *= -1;
//	    }
//	    while (b != 0) {
//	        long temp = b;
//	        b = a%b;
//	        a = temp;
//	    }
//	    return a;
//	}
//}
