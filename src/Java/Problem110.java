package Java;

public class Problem110 {
	
	static long[] tall;
	static long max = 10953009486979560L;
	
	public static void main(String[] args) {
		/**
		 * 
		 * Antall losninger = (antDivisorer(tall^2)-1)/2
		 * 
		 */
		System.out.println(solution());
	}
	
	public static long solution() {
		int limit = 25;
		long divisors = 1;
		long minste = Long.MAX_VALUE;
		
		tall = new long[13];
		
		for (int i = 1; i < limit; i++) {
			//2
			tall[0] = 1L<<i;

			for (int j = 1; j < limit; j++) {
				//3
				tall[1] = (long) pow(3, j);
			
				for (int j2 = 1; j2 < limit; j2++) {
					//5
					tall[2] = (long) pow(5, j2);
					for (int k = 1; k < limit; k++) {
						//7
						tall[3] = (long) pow(7, k);
						if (sjekk(3))
							break;
						
						for (int k2 = 1; k2 < limit; k2++) {
							//11
							tall[4] = (long) pow(11, k2);
							if (sjekk(4))
								break;
							
							for (int l = 1; l < limit; l++) {
								//13
								tall[5] = (long) pow(13, l);
								if (sjekk(5))
									break;
								
								for (int l2 = 1; l2 < limit; l2++) {
									//17
									tall[6] = (long) pow(17, l2);
									if (sjekk(6))
										break;
									
									for (int m = 1; m < limit; m++) {
										//19
										tall[7] = (long) pow(19, m);
										if (sjekk(7))
											break;
										
										for (int m2 = 1; m2 < limit; m2++) {
											//23
											tall[8] = (long) pow(23, m2);
											if (sjekk(8))
												break;
											
											for (int n = 1; n < limit; n++) {
												//29
												tall[9] = (long) pow(29, n);
												if (sjekk(9))
													break;
												
												for (int n2 = 0; n2 < limit; n2++) {
													//31
													tall[10] = (long) pow(31, n2);
													if (sjekk(10))
														break;
													
													for (int o = 0; o < limit; o++) {
														//37
														tall[11] = (long) pow(37, o);
														if (sjekk(11))
															break;
														
														for (int o2 = 0; o2 < limit; o2++) {
															//41
															tall[12] = (long) pow(41, o2);
															if (sjekk(12))
																break;
															
															divisors = (2*i+1)*(2*j+1)*(2*j2+1)
																	*(2*k+1)*(2*k2+1)*(2*l+1)*(2*l2+1)
																	*(2*m+1)*(2*m2+1)*(2*n+1)*(2*n2+1)
																	*(2*o+1)*(2*o2+1);
															
															divisors /= 2;
															
															if (divisors > 4000000) {
																long sum = 1;
																for (int p = 0; p < tall.length; p++) {
																	sum*=tall[p];
																}
//																System.out.println(sum);
																if (sum < max) {
																	max = sum;
																	minste = Math.min(minste, sum);
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
//		System.out.println(teller);
		return minste;
	}

	public static long pow(long tall, int exp) {
		long sum = 1;
		for (int i = 0; i < exp; i++) {
			sum*=tall;
		}
		return sum;
	}
	
	public static boolean sjekk(int a) {
		long sum = 1;
		for (int i = 0; i <= a; i++) {
			if (Math.log10(sum) + Math.log10(tall[i]) > Math.log10(max))
				return true;
			sum*=tall[i];
			if (sum > max)
				return true;
		}
		return false;
	}
}
