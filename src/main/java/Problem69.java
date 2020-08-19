public class Problem69 {
	//============================================================================
	// Name        : Problem69.cpp
	// Author      : 
	// Version     :
	// Copyright   : Your copyright notice
	// Description : Hello World in C++, Ansi-style
	//============================================================================


	public static void main(String [] args) {
//		cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
		double biggest = 0;
		int a = 0;
		for (int i = 2; i <= 1000000; ++i) {
			int rp = 1;
			for (int j = 2; j < i; ++j) {
				if (gcd(i,j) == 1)
					rp++;
			}
			if (biggest < i/rp) {
				biggest = i/rp;
				a = i;
			}
			if (i%1000 == 0) {
				System.out.println(i);
			}
		}
		System.out.println(a + " " + biggest);

	}

	static long gcd(int numerator, int denomerator) {
	    long a = numerator;
	    if (a < 0) {
	        a *= -1;
	    }
	    long b = denomerator;
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

}
