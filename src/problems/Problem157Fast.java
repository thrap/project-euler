package problems;

public class Problem157Fast {
	public static void main(String[] args) {
		/**
		 * TODO: finne smarte grenser så har du den jeg sverger kompis
		 */
		
		//p = 2^n*5^n(a+b)/(b*a)
		
		int count = 0;
		for (int i = 1; i <= 10000; i++) {
			if (i % 2 == 0 || i % 5 == 0)
				continue;
			for (int a2s = 0; a2s < 15; a2s++) {
				for (int a5s = 0; a5s < 15; a5s++) {
					long a = (long) (i*Math.pow(2, a2s)*Math.pow(5, a5s));
					for (int b2s = 0; b2s < 20; b2s++) {
						for (int b5s = 0; b5s < 20; b5s++) {
							long b = (long) (i*Math.pow(2, b2s)*Math.pow(5, b5s));
							if (a > b)
								continue;
							
							if ((10000*(a+b)) % (a*b) == 0) {
								System.out.println(i);
								System.out.println(a + " " + b);
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
