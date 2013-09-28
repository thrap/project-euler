package problems;

import utils.T;


public class Problem390v2 {
	public static void main(String[] args) {
		//(c^2+b^2+(2*c*b)^2) må være perfect square
		T t = new T();
		long limit = (long) Math.pow(10, 6);
		long areaLimit = limit*limit;
		System.out.println(areaLimit);
		long areaSum = 0;
		for (long b = 1; 2*b*b+4*b*b*b*b <= areaLimit; b++) {
			for (long c = b; c*c+b*b+4*c*c*b*b <= areaLimit; c++) {
				long inni = b*b+c*c+4*b*b*c*c;
				
				if (isPerfectSquare(inni)) {
					System.out.println(b + " " + c);
					areaSum += Math.sqrt(inni);
				}

				
			}
		}
		System.out.println(areaSum + " " + t);
	}
	
	public static boolean isPerfectSquare(long input) {
		long closestRoot = (long) Math.sqrt(input);
		return input == closestRoot * closestRoot;
	}
}
