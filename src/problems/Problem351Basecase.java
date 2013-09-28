package problems;

import java.text.DecimalFormat;

import utils.Euler;

public class Problem351Basecase {
	public static int H(int n) {
		
		boolean [][] hidden = new boolean[n+1][];
		for (int i = 0; i < hidden.length; i++) {
			hidden[i] = new boolean[i+1];
		}
		
		
		
		for (int i = 1; i < hidden.length; i++) {
			for (int j = 0; j < hidden[i].length; j++) {
				if (!hidden[i][j]) {
					/**
					 * for partall er bare oddetall invisible
					 */
					if (i % 2 == 0 && j % 2 != 1) {
						System.out.println("todo");
						System.exit(0);
					}
//					System.out.println("(" +i+","+j+ ")");
					for (int k = 2; k*i < hidden.length && k*j < hidden.length; k++) {
						/**
						 * er invisible om (visibleI*k, visibleJ*k)
						 */
						hidden[k*i][k*j] = true;
					}
				}
			}
		}
		if (n <= 100 && SHOULD_PRINT) {
			print(hidden);
			printEven(hidden);
		}
		int invisible = invisible(hidden);
		System.out.println("H("+n+") = " + invisible + " ("+visible(hidden)+")");
		return invisible;
	}
	
	private static void printEven(boolean[][] hidden) {
		for (int i = 1; i < hidden.length; i+=2) {
			System.out.print(new DecimalFormat("000").format(i) + ": ");
			
			
			for (int k=0; k < (hidden.length - i)/2; k++) {
		        System.out.print(" ");
		    }
			for (int j = 0; j < hidden[i].length; j++) {
				if (hidden[i][j]) {
					System.out.print(" ");
//					System.out.print("x");
				} else {
//					System.out.print(" ");
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}

	/**
	 * NOTATER:
	 * 
	 * Alle rader med index som er primtall er alltid synlige
	 * 
	 * Er de usynlige divisorer av radene? hmmm
	 * 
	 */
	public static void main(String[] args) {
		H(5);
		H(10);
		H(15);
		H(16);
		H(30);
		H(100);
		H(1000);
//		H(10000);
//		H(100000000);
	}
	
	private static boolean SHOULD_PRINT = false;

	private static int invisible(boolean[][] hidden) {
		int invisible = 0;
		for (int i = 2; i < hidden.length; i++) {
			invisible++;
			for (int j = 1; j < hidden[i].length-1; j++) {
				if (hidden[i][j]) {
					if (Euler.isPrime(i)) {
						System.out.println("todo");
						System.exit(0);
					}
					invisible++;
				} 
			}
		}
		return invisible*6;
	}
	
	private static int visible(boolean[][] hidden) {
		int visible = 0;
		for (int i = 2; i < hidden.length; i++) {
			for (int j = 0; j < hidden[i].length-1; j++) {
				if (!hidden[i][j]) {
					visible++;
				} 
			}
		}
		return visible*6+7;
	}

	private static void print(boolean[][] hidden) {
		for (int i = 0; i < hidden.length; i++) {
			for (int j = 0; j < hidden[i].length; j++) {
				if (hidden[i][j]) {
					System.out.print("  ");
//					System.out.print("x ");
				} else {
					System.out.print("o ");
				}
			}
			System.out.println();
		}
	}
}
