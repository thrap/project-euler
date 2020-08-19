import java.util.HashSet;

public class Problem90 {
	static byte[] a;
	static byte[] b;

	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		int[] asd = new int[10];
		long teller = 0;
		a = new byte[6];
		b = new byte[6];
		for (byte a1 = 0; a1 < asd.length; a1++) {
			a[0] = a1;
			for (byte a2 = (byte) (a1 + 1); a2 < asd.length; a2++) {
				a[1] = a2;
				for (byte a3 = (byte) (a2 + 1); a3 < asd.length; a3++) {
					a[2] = a3;
//					System.out.println(a1 + " " + a2 + " " + a3);
					for (byte a4 = (byte) (a3 + 1); a4 < asd.length; a4++) {
						a[3] = a4;
						for (byte a5 = (byte) (a4 + 1); a5 < asd.length; a5++) {
							a[4] = a5;
							for (byte a6 = (byte) (a5 + 1); a6 < asd.length; a6++) {
								a[5] = a6;
								for (byte b1 = 0; b1 < asd.length; b1++) {
									b[0] = b1;
									for (byte b2 = (byte) (b1 + 1); b2 < asd.length; b2++) {
										b[1] = b2;
										for (byte b3 = (byte) (b2 + 1); b3 < asd.length; b3++) {
											b[2] = b3;
											for (byte b4 = (byte) (b3 + 1); b4 < asd.length; b4++) {
												b[3] = b4;
												for (byte b5 = (byte) (b4 + 1); b5 < asd.length; b5++) {
													b[4] = b5;
													for (byte b6 = (byte) (b5 + 1); b6 < asd.length; b6++) {
														b[5] = b6;
														if (funker())
															++teller;
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
		return (teller / 2);
	}

	public static boolean funker() {
		// boolean[] tall = new boolean[10];
		// for (int i = 0; i < a.length; i++) {
		// tall[a[i]] = true;
		// }
		// for (int i = 0; i < b.length; i++) {
		// tall[b[i]] = true;
		// }
		// for (int i = 0; i < tall.length; i++) {
		// if (!tall[i] && i != 7 && !(tall[6] || tall[9]))
		// return false;
		// }
		//
		HashSet<Integer> A = new HashSet<Integer>();
		HashSet<Integer> B = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			A.add((int) a[i]);
			B.add((int) b[i]);
		}

		if ((A.contains(0) && B.contains(1))
				|| (B.contains(0) && A.contains(1)))
			if ((A.contains(0) && B.contains(4))
					|| (B.contains(0) && A.contains(4)))
				if ((A.contains(0) && (B.contains(9) || B.contains(6)))
						|| (B.contains(0) && (A.contains(9) || A.contains(6))))
					if ((A.contains(1) && (B.contains(9) || B.contains(6)))
							|| (B.contains(1) && (A.contains(9) || A
									.contains(6))))
						if ((A.contains(2) && B.contains(5))
								|| (B.contains(2) && A.contains(5)))
							if ((A.contains(3) && (B.contains(9) || B
									.contains(6)))
									|| (B.contains(3) && (A.contains(9) || A
											.contains(6))))
								if ((A.contains(4) && (B.contains(9) || B
										.contains(6)))
										|| (B.contains(4) && (A.contains(9) || A
												.contains(6))))
									if (((A.contains(9) || A.contains(6)) && B
											.contains(4))
											|| ((B.contains(9) || B.contains(6)) && A
													.contains(4)))
										if ((A.contains(8) && B.contains(1))
												|| (B.contains(8) && A
														.contains(1)))
											return true;

		return false;
	}
}
