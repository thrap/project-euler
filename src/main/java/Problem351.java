import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem351 {
	static int limit = 100000000;
	static List<Integer> primes = Euler.primeList(limit);
	
	public static void main(String[] args) {
		long startz = System.currentTimeMillis();
		long invisible = 0;
		int parts = 100;
		int part = limit/parts;
		for (int start = 0; start < limit; start+=part) {
			List<Integer>[] primefactors = primeFactorDistinctListsBetween(start, start+part);
			for (int i = (start==0?2:0); i < primefactors.length; i++) {
				int tallet = i+start;
				if (tallet % 1000000 == 0)
					System.out.println(tallet);
				List<Integer> factors = primefactors[i];
				invisible += invisible(tallet, factors);
			}
		}
		invisible += invisible(limit, Euler.primeFactorDistinctList(limit));
//		List<Integer>[] primefactors = primeFactorDistinctListsBetween(0, limit+1);
//		for (int i = 2; i <= limit; i++) {
//			invisible += invisible(i, primefactors[i]);
//		}
		System.out.println(invisible*6 + " (" + (System.currentTimeMillis()-startz) + " ms)");
//		Problem351Basecase.H(limit);
		
//		   123456789012345
		// oo o  oo  o oo 
//		int n = 6;
//		System.out.println(invisible(n, Euler.primeFactorDistinctList(n)));
	}
	
	public static long invisible(int row, List<Integer> factorList) {
		int[] factors = new int[factorList.size()];
		for (int i = 0; i < factors.length; i++) {
			factors[i] = factorList.get(i);
		}
		
		long invisible = 0;
		for (int i = 0; i < factors.length; i++) {
			invisible += row/factors[i];
		}
		
		if (factors.length == 1)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				int number = factors[i]*factors[j];
				invisible -= row/number;
			}
		}
		
		if (factors.length == 2)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					int number = factors[i]*factors[j]*factors[j2];
					invisible += row/number;
				}
			}
		}
		
		if (factors.length == 3)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						int number = factors[i]*factors[j]*factors[j2]*factors[k];
						invisible -= row/number;
					}
				}
			}
		}
		
		if (factors.length == 4)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						for (int k2 = k+1; k2 < factors.length; k2++) {
							int number = factors[i]*factors[j]*factors[j2]*factors[k]*factors[k2];
							invisible += row/number;
						}
					}
				}
			}
		}
		
		if (factors.length == 5)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						for (int k2 = k+1; k2 < factors.length; k2++) {
							for (int l = k2+1; l < factors.length; l++) {
								int number = factors[i]*factors[j]*factors[j2]*factors[k]*factors[k2]*factors[l];
								invisible -= row/number;
							}
						}
					}
				}
			}
		}
		
		if (factors.length == 6)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						for (int k2 = k+1; k2 < factors.length; k2++) {
							for (int l = k2+1; l < factors.length; l++) {
								for (int l2 = l+1; l2 < factors.length; l2++) {
									int number = factors[i]*factors[j]*factors[j2]*factors[k]*factors[k2]*factors[l]*factors[l2];
									invisible += row/number;
								}
							}
						}
					}
				}
			}
		}
		
		if (factors.length == 7)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						for (int k2 = k+1; k2 < factors.length; k2++) {
							for (int l = k2+1; l < factors.length; l++) {
								for (int l2 = l+1; l2 < factors.length; l2++) {
									for (int m = l2+1; m < factors.length; m++) {
										int number = factors[i]*factors[j]*factors[j2]*factors[k]*factors[k2]*factors[l]*factors[l2]*factors[m];
										invisible -= row/number;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (factors.length == 8)
			return invisible;
		
		for (int i = 0; i < factors.length; i++) {
			for (int j = i+1; j < factors.length; j++) {
				for (int j2 = j+1; j2 < factors.length; j2++) {
					for (int k = j2+1; k < factors.length; k++) {
						for (int k2 = k+1; k2 < factors.length; k2++) {
							for (int l = k2+1; l < factors.length; l++) {
								for (int l2 = l+1; l2 < factors.length; l2++) {
									for (int m = l2+1; m < factors.length; m++) {
										for (int m2 = m+1; m2 < factors.length; m2++) {
											int number = factors[i]*factors[j]*factors[j2]*factors[k]*factors[k2]*factors[l]*factors[l2]*factors[m]*factors[m2+1];
											invisible += row/number;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return invisible;
	}
	
	public static List<Integer>[] primeFactorDistinctListsBetween(int start,int end) {
		
		List<Integer>[] primefactors = new List[end-start];
		for (int i = 0; i < primefactors.length; i++) {
			primefactors[i] = new ArrayList<Integer>();
		}
		
		for (int prime : primes) {
			if (prime > end)
				break;
			int s = (start/prime);
			s*=prime;
			if (s != start)
				s+=prime;
			for (int i = s; i < end; i+=prime) {
				primefactors[(i-start)].add(prime);
			}
		}
		
		return primefactors;
	}
}
