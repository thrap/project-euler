public class Problem230 {
	public static void main(String[] args) {
////		String forste = "A";
////		String andre = "B";
		
		
//		System.out.println(i);
//		
//		System.out.println(rest);
		
//		for (int i = 0; i <= 10; i++) {
//			String temp = andre;
//			andre = forste+andre;
//			forste = temp;
//			System.out.println(andre);
//			if (andre.length()*size >= find) {
////				System.out.println(andre.charAt(find/size));
//				if (andre.charAt((int)(find/size)) == 'A')
//					System.out.println(a.charAt((int)(find%size)-1));
//				else
//					System.out.println(b.charAt((int)(find%size)-1));
//				System.out.println(finn((int)find/size+1));
//				System.out.println(andre.substring(andre.length()-finn((int)find/size+1)));
//				break;
//			}
//		}
		
//		long find = (127+19*x)*7^x;
		System.out.println(solution());
	}
	
	public static String solution() {
		String A = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
		String B = "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
		String res = "";
		for (int q = 17; q >= 0; --q) {
//			System.out.print(q + " = ");
			long find = nr(q);
			long size = 100;
			long i = find/size;
			int rest = (int)(find%size);
			if (rest != 0) {
				++i;
			} else {
				rest = (int)size;
			}
			
			if (q == 0)
				res+=(B.charAt(rest-1));
			else
			while(true) {
				long b = finn(i);
				long a = finn(b);
				i -= a;
				
				if (b == 2) {
					if (i == 1) {
						res+=(A.charAt(rest-1));
					} else if (i == 2) {
						res+=(B.charAt(rest-1));
					} else {
						System.out.println("FEIL DIN FEITE FAEN");
					}
					break;
				} else if (b == 3) {
					if (i == 1) {
						res+=(B.charAt(rest-1));
					} else if (i == 2) {
						res+=(A.charAt(rest-1));
					} else if (i == 3){
						res+=(B.charAt(rest-1));
					} else {
						System.out.println("FEIL DIN FEITE FAEN");
					}
					break;			
				}
				
				
//				System.out.println("a = " + a);
//				System.out.println("b = " + b);
//				System.out.println("i = " + i);
//				System.out.println();
			}
		}
//		System.out.println(res);
		return res;
	}

	public static long nr(int i) {
		long res = 127+19*i;
		
		for (int j = 0; j < i; j++) {
			res*=7;
		}
		return res;
	}
	
	public static long finn(long index) {
		if (index == 0)
			return 0;
		if (index == 1)
			return 1;
		long a = 0;
		long b = 1;
		long c = a+b;
		while (c < index) {
			a = b;
			b = c;
			c = a+b;
		}
		return b;
	}
}
