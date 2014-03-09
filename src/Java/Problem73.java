package Java;

import java.util.HashSet;

public class Problem73 {
//	static HashMap<String,Boolean> map = new HashMap<String,Boolean>();
	static HashSet<String> map = new HashSet<String>();
//	static ArrayList<String> map = new ArrayList<String>();
	static class Rational {
		int n;
		int d;
		public Rational(int n, int d) {
			this.n = n;
			this.d = d;
			simplify();
		}
		
		private void simplify() {
			long t = gcd();
		    n /= t;
		    d /= t;

		    if (d < 0) {
		        n *= -1;
		        d *= -1;
		    }
		}
		
		private long gcd() {
		    long a = n;
		    if (a < 0) {
		        a *= -1;
		    }
		    long b = d;
		    if (b < 0) {
		        b *= -1;
		    }
		    while (b != 0) {
		        long temp = b;
		        b = a%b;
		        a = temp;
		    }
		    return a;
		}
		
//		1/3
		public boolean isLessThan() {
			return (n*2 < d);
		}
		
		public boolean isGreaterThan() {
			return (d < 3*n);
		}
		
		public String toString() {
			return n + "/" + d;
		}
	}
	public static void main(String[] args) {
		boolean[] asd = Test.primtallUnder(12000);
		//1/8
		//7/8
		int q = 0;
		for (int i = 2; i <= 12000; i++) {
			for (int j = 1; j < i; j++) {
				Rational r = new Rational(j,i);
				if (r.isLessThan() && r.isGreaterThan()) {
					String string = r.toString();
					
//					if (!map.contains(string))
					if (i<11000)
						map.add(string);
					else if (!map.contains(string))
						q++;
				}
						
			}
			if (i%100 == 0)
				System.out.println(i + ": " + map.size());
			if (i>11400)
				System.out.println(i + ": " + map.size());
		}
		System.out.println(map.size()+q);
	}
}

