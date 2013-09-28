package problems;

public class Problem147 {
	
	//denne er riktig
	static long normalSum(int x, int y) {
		long sum = 0;
		for (int w = 1; w <= x; w++) {
			for (int h = 1; h <= y; h++) {
				sum+=rect(w,h,x,y);
			}
		}
		return sum;
	}
	
	static long sum(int x, int y) {
		return normalSum(x,y)+tiltedSum(x,y);
	}
	
	static long tiltedSum(int x, int y) {
		long sum = 0;
		System.out.println("----"+x+"x"+y+"----");
		for (int w = 1; (w+1)/2 <= x; w++) {
			for (int h = 1; (h+1)/2 <= y; h++) {
				if (fits(w, h, x, y)) {
					if (tilted(w,h,x,y) > 0) {
//						System.out.println(w+"x"+h + " = "+tilted(w,h,x,y));
						sum+=tilted(w,h,x,y);
					}
				}
			}
		}
		return sum;
	}
	
	//tror denne er riktig
	private static boolean fits(long w, long h, long x, long y) {
		if (h > w) {
			long temp = w;
			w = h;
			h = temp;
		}
		if (y > x) {
			long temp = x;
			x = y;
			y = temp;
		}
		//Y og H er minste lizm
		if (w == h) {
			if (y%2 == 0)
				return y>=w;
			else
				return y-1>=w || (y>=w && x-1>=w);
		} else {
			//høyde på største kvadrat = y
			long i = y-w;
			if (y==x) 
				return h<=y+i -(h%2==0?0:1);
			else
				return h<=y+i;
		}
	}

	static long rect(long w, long h, long x, long y) {
		long sum = (x-(w-1))*(y-(h-1));
		if (sum > 0)
			return sum;
		else
			return 0;
	}
	
	static long tilted(long w, long h, long x, long y) {
		if (h > w) {
			long temp = w;
			w = h;
			h = temp;
		}
		if (y>x) {
			long temp = y;
			y=x;
			x=temp;
		}
		if (w == h && w % 2 == 0) {
			return (y-w)*(x-w) + (y-w+1)*(x-w+1);
		} else if (w == h){
			return (y-w+1)*(x-w) + (y-w)*(x-w+1);
		} else if (h == 1) {
			if (w%2==0) {
				return (y-w/2)*2*(x-w/2);
			} else {
				long f¿rsteRad = (x-w)+1;
				long andreRad = f¿rsteRad+1;
				long antallEkstraRader = (y+1-w);
				if (antallEkstraRader < 0) 
					antallEkstraRader = 0;
				long sum = f¿rsteRad + antallEkstraRader*(f¿rsteRad+andreRad);
				if (sum > 0)
					return sum;
				//TODO HER
				/**
				 * 
				 * tips kanskje til TODO's:
					//høyde på største kvadrat = y
					long i = y-w;
					if (y==x) 
						return h<=y+i -(h%2==0?0:1);
					else
						return h<=y+i;
				 */
			}
		} else {
			//TODO HER
			//y == høyde på største kvadrat
//			(x-y)+1 = antall kvadrater
//			antall kvadrater - 1 = antall mindre kvadrater
			
			//TODO dette er feil fordi det strøste kvadratet er bare bullshit hæhæ
//			storste kvadrat w*h passer i er w*w
			long kvadrater = ((x-w)+1)*(y-w+1);
			long sum = kvadrater*rect(w, h, w, w);
			
			//TODO kutter av i 4 hjørner som har w-1 kvadrater
			sum += 2*rect(w, h, w, w-1);
			if (sum >= 0)
				return sum;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		int x = 47;
		int y = 43;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				sum+=sum(i,j);
			}
		}
		System.out.println(sum(3,2) + " skal være 37");
		System.out.println(sum(5,7) + " skal være 1120");
		System.out.println(sum + " er summen");
//		System.out.println(normalSum(3,2) + " er summen ikke-snudde i 3x2");
//		System.out.println(tiltedSum(3,2) + " er summen snudde i 3x2");
		System.out.println(tilted(1, 4, 5, 5));
	}
}
