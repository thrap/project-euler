package Java;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import utils.T;

public class Problem88 {
	static int limit = 12000;
	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() + " " + t);
	}
	
	
	public static long solution() {
		int limitssss = limit+50000;
		
		for (int a=2; a < 445;++a) {
			for (int b=2; b < 84; ++b) {
				if (a*b > limitssss)
					break;
				test(a, b);
				for (int c=2; c < 20;++c) {
					if (a*b*c > limitssss)
						break;
					test(a, b, c);
					for (int d=2; d < 8;++d) {
						if (a*b*c*d > limitssss)
							break;
						test(a, b, c, d);
						for (int e=2; e < 6; ++e) {
							if (a*b*c*d*e > limitssss)
								break;
							test(a, b, c, d, e);
							for (int f=2; f <4; ++f) {
								if (a*b*c*d*e*f > limitssss)
									break;
								test(a, b, c, d, e, f);
								for (int g=2; g <4; ++g) {
									if (a*b*c*d*e*f*g > limitssss)
										break;
									test(a, b, c, d, e, f, g);
									for (int h=2; h <3; ++h) {
										if (a*b*c*d*e*f*g*h > limitssss)
											break;
										test(a, b, c, d, e, f, g, h);
										for (int i=2; i <3; ++i) {
											if (a*b*c*d*e*f*g*h*i > limitssss)
												break;
										test(a, b, c, d, e, f, g, h, i);
											for (int j=2; j <3; ++j) {
												if (a*b*c*d*e*f*g*h*i*j > limitssss)
													break;
										test(a, b, c, d, e, f, g, h, i, j);
												for (int k=2; k <3; ++k) {
										test(a, b, c, d, e, f, g, h, i, j, k);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 2; i <= limit; i++) {
			if (k[i] != Integer.MAX_VALUE) 
			set.add(k[i]);
		}
		
		long sum = 0;
		for (Integer integer : set) {
			sum+=integer;
		}
		return sum;
	}


	static int[] k = new int[limit+1];
	
	static {
		Arrays.fill(k, Integer.MAX_VALUE);
	}
	
	public static void test(int...is ) {
		int sum = 0;
		for (int i : is) {
			sum+=i;
		}
		int prod = 1;
		for (int i : is) {
			prod*=i;
		}
		int lengde = prod - sum + is.length;
		if (lengde >= k.length)
			return;
		k[lengde] = Math.min(k[lengde], prod);
	}
}
