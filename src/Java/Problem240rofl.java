package Java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem240rofl {
	
	private static final int SUM = 70;
	private static final int MAX = 12;
	private static final int DICE = 20;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for (int a = 1; a <= MAX; a++) {
			for (int b = a; b <= MAX; b++) {
				for (int c = b; c <= MAX; c++) {
					for (int d = c; d <= MAX; d++) {
						for (int e = d; e <= MAX; e++) {
							for (int f = e; f <= MAX; f++) {
								for (int g = f; g <= MAX; g++) {
									for (int h = g; h <= MAX; h++) {
										for (int i = h; i <= MAX; i++) {
											for (int j = i; j <= MAX; j++) {
												if (check(a, b, c, d, e, f, g, h, i, j)) {
													for (int k = 1; k <= a; k++) {
														for (int l = k; l <= a; l++) {
															for (int m = l; m <= a; m++) {
																for (int n = m; n <= a; n++) {
																	for (int o = n; o <= a; o++) {
																		for (int p = o; p <= a; p++) {
																			for (int q = p; q <= a; q++) {
																				for (int r = q; r <= a; r++) {
																					for (int s = r; s <= a; s++) {
																						for (int t = s; t <= a; t++) {
																							sum += permutations(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t);
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
		System.out.println(sum + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	

	private static long permutations(int...is) {
		int[] count = new int[MAX+1];
		for (int i : is) {
			++count[i];
		}
		BigInteger over = factorial(DICE);
		BigInteger under = BigInteger.ONE;
		for (int i : count) {
			if (i >= 2)
				under = under.multiply(factorial(i));
		}
		return over.divide(under).longValue();
	}

	private static Map<Integer, BigInteger> FACTORIAL = new HashMap<Integer, BigInteger>();

	public static BigInteger factorial(int i) {
		if (FACTORIAL.containsKey(i)) {
			return FACTORIAL.get(i);
		}
		BigInteger a = BigInteger.ONE;
		for (int j = 2; j <= i; j++) {
			a = a.multiply(BigInteger.valueOf(j));
		}
		FACTORIAL.put(i, a);
		return a;
	}

	private static boolean check(int... is) {
		long sum = 0;
		for (int i : is) {
			sum+=i;
		}

		return sum == SUM;
	}
}
