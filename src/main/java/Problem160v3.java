public class Problem160v3 {
	public static void main(String[] args) {
//		long n = 200L;
//		int i;
//		for (i=0; Math.pow(5, i+1) < n; i++) {
//			System.out.println(Math.pow(5, i+1));
//		}
//		
//		System.out.println(i + " ekstra tall foran svaret: " + (long)(Math.pow(10, i)));
//		
//		System.out.println(f(n));
		int i = 1;
		for (int j = 1; j <= 100; j++) {
			if (j%5!=0) {
//				i*=j%100;
			}
			else 
				i*=j;
			while (i%10 == 0)
				i/=10;
			i%=100;
		}
		System.out.println(i);
		
	}
	
	public static long f(long n) {
		long result = 1;
		for (long i = 1; i <= n; i++) {
			if (i%100 != 0)
				result*=(i%100);
			else
				result*=i;
			result = format(result);
		}
		return result;
	}
	
	public static long format(long tall) {
		while (tall % 10 == 0) {
//			System.out.println(tall);
			tall /= 10;
		}
		if (tall > 100000) {
			tall %= 100000;
		}
		if (tall == 0)
			return 1;
		return tall;
	}
	
//	public static void main(String[] args) {
//		long limit = 1000000000000L;
//		long scale = limit;
//		int orgscale = 100000;
//		if (scale<orgscale)
//			scale=orgscale;
//		
//		//2000 = 7339008
//		//1000 = 7753472
//		
//		long tall = 1;
//		for (long i = 2; i <= limit; i++) {
//			long temp = i;
//			while(temp%10==0) 
//				temp/=10;
//			tall*=temp;
//			while (tall % 10 == 0) {
//				tall /= 10;
//			}
//			tall%=scale;
//			if (i%100000000 == 0)
//				System.out.println(i/100000000 + "/"+limit/100000000);
////			if (sjekk%orgscale != tall%orgscale) {
////				System.out.print("FEIL: ");
////			System.out.println(i + " "+ sjekk + " " + tall);
//////				break;
////			}
//		}
//		
//		
////		int skalar = 1;
////		for (int i = 1; i < scale; i++) {
////			skalar*=i;
////			while (skalar%10 == 0)
////				skalar/=10;
////			skalar%=scale;
////		}
////		
////		int result = 1;
////		for (int i = 0; i < limit/scale; i++) {
////			result*=skalar;
////			while (result%10 == 0)
////				result/=10;
////			result%=scale;
////		}
//		
//		
////		for (int i = 2; i < limit/scale; i++) {
//////			System.out.println("hei");
////			result*=i;
////			if (result%10 == 0)
////				result/=10;
////			result%=scale;
////		}
//		
////		System.out.println(skalar);
////		System.out.println(result);
//		System.out.println(tall%orgscale);
//	}
}
