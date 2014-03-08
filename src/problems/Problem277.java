package problems;

public class Problem277 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
//		tall - 1 er delelig paa 3
//		4*tall+2 er delelig paa 81
		for (long i = 1000013819853784L; true; i+=94143178827L) {
			if (a(i).contains("UDDDUdddDDUDDddDdDddDDUDDdUUDd")) {
//				System.out.println(a(i));
				return(i);
			}
		}
	}

	public static String a(long an) {
		if (an == 1) {
//			System.out.println();
			return"";
		}
		if (an%3 == 0) {
			return "D" + a(an/3);
		} else if (an%3 == 1) {
			return "U"+a((4*an+2)/3);
		} else {
			return "d"+a((2*an-1)/3);
		}
//		an+1 = an/3 if an is divisible by 3. We shall denote this as a large downward step, "D".
//
//				an+1 = (4an + 2)/3 if an divided by 3 gives a remainder of 1. We shall denote this as an upward step, "U".
//
//				an+1 = (2an - 1)/3 if an divided by 3 gives a remainder of 2. We shall denote this as a small downward step, "d".
	}
}
