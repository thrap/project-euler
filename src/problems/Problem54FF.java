package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem54FF {
	public static void main(String[] args) throws IOException{
		
		/**
		 * 377 wins
		 */
//		1:  High Card: Highest value card.
//		2:  One Pair: Two cards of the same value.
//		3:  Two Pairs: Two different pairs.
//		4:  Three of a Kind: Three cards of the same value.
//		5:  Straight: All cards are consecutive values.
//		6:  Flush: All cards of the same suit.
//		7:  Full House: Three of a kind and a pair.
//		8:  Four of a Kind: Four cards of the same value.
//		9:  Straight Flush: All cards are consecutive values of same suit.
//		10: Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		String string = in.readLine();
		int teller = 0;
		int vinnteller = 0;
		int a = 1;
		while (string != null) {
			StringTokenizer st = new StringTokenizer(string);
			
			//se player1
			char c1 = '-';
			int[] count1 = new int[13];
			
			boolean flush1 = true;
			for (int i = 0; i < 5; i++) {
				String token = st.nextToken();
				if (c1 != '-') {
					if (c1 != token.charAt(1))
						flush1 = false;
				} else
					c1 = token.charAt(1);
				if (token.charAt(0) == 'T')
					count1[8]++;
				else if (token.charAt(0) == 'J')
					count1[9]++;
				else if (token.charAt(0) == 'Q')
					count1[10]++;
				else if (token.charAt(0) == 'K')
					count1[11]++;
				else if (token.charAt(0) == 'A')
					count1[12]++;
				else {
					count1[token.charAt(0)-'2']++;
				}
			}
			boolean par1=false;
			boolean toPar1=false;
			boolean treLike1 = false;
			boolean fireLike1 = false;
			boolean hus1=false;
			for (int i = 0; i < count1.length; i++) {
				if (count1[i] == 3 && par1)
					hus1 = true;
				if (count1[i] == 2 && treLike1)
					hus1 = true;
				if (count1[i] == 2 && par1)
					toPar1 = true;
				if (count1[i] == 4)
					fireLike1 = true;
				if (count1[i] == 3)
					treLike1 = true;
				if (count1[i] == 2)
					par1 = true;
			}
			boolean straight1 = false;
			boolean royal1 = false;
			for (int i = 0; i < count1.length-4; i++) {
				if (count1[i] == 1)
					if (count1[i+1] == 1)
						if (count1[i+2] == 1)
							if (count1[i+3] == 1)
								if (count1[i+4] == 1) {
									if (i+4 == 12)
										royal1 = true;
									straight1 = true;
								}
			}
//		System.out.println(royal1 + " " + straight1);
			int verdi1 = 1;
			if (royal1 && flush1)
				verdi1 = 10;
			else if (straight1 && flush1)
				verdi1 = 9;
			else if (fireLike1)
				verdi1 = 8;
			else if (hus1)
				verdi1 = 7;
			else if (flush1)
				verdi1 = 6;
			else if (straight1)
				verdi1 = 5;
			else if (treLike1)
				verdi1 = 4;
			else if (toPar1)
				verdi1 = 3;
			else if (par1)
				verdi1 = 2;
			
//			System.out.println(verdi1);
			
			
			//se player2
			char c2 = '-';
			int[] count2 = new int[13];
			
			boolean flush2 = true;
			for (int i = 0; i < 5; i++) {
				String token = st.nextToken();
				if (c2 != '-') {
					if (c2 != token.charAt(1))
						flush2 = false;
				} else
					c2 = token.charAt(1);
				if (token.charAt(0) == 'T')
					count2[8]++;
				else if (token.charAt(0) == 'J')
					count2[9]++;
				else if (token.charAt(0) == 'Q')
					count2[10]++;
				else if (token.charAt(0) == 'K')
					count2[11]++;
				else if (token.charAt(0) == 'A')
					count2[12]++;
				else {
					count2[token.charAt(0)-'2']++;
				}
			}
			boolean par2=false;
			boolean toPar2=false;
			boolean treLike2 = false;
			boolean fireLike2 = false;
			boolean hus2=false;
			for (int i = 0; i < count2.length; i++) {
				if (count2[i] == 3 && par2)
					hus2 = true;
				if (count2[i] == 2 && treLike2)
					hus2 = true;
				if (count2[i] == 2 && par2)
					toPar2 = true;
				if (count2[i] == 4)
					fireLike2 = true;
				if (count2[i] == 3)
					treLike2 = true;
				if (count2[i] == 2)
					par2 = true;
			}
			boolean straight2 = false;
			boolean royal2 = false;
			for (int i = 0; i < count2.length-4; i++) {
				if (count2[i] == 1)
					if (count2[i+1] == 1)
						if (count2[i+2] == 1)
							if (count2[i+3] == 1)
								if (count2[i+4] == 1) {
									if (i+4 == 12)
										royal2 = true;
									straight2 = true;
								}
			}
//		System.out.println(royal1 + " " + straight1);
			int verdi2 = 1;
			if (royal2 && flush2)
				verdi2 = 10;
			else if (straight2 && flush2)
				verdi2 = 9;
			else if (fireLike2)
				verdi2 = 8;
			else if (hus2)
				verdi2 = 7;
			else if (flush2)
				verdi2 = 6;
			else if (straight2)
				verdi2 = 5;
			else if (treLike2)
				verdi2 = 4;
			else if (toPar2)
				verdi2 = 3;
			else if (par2)
				verdi2 = 2;
			
			if (verdi1 > verdi2) {
				vinnteller++;
				System.out.println("win: "+a);
			}
			else if (verdi1 == verdi2) {
				if (verdi1 == 1) {
					for (int i = count2.length-1; i != -1; i--) {
						if (count2[i] != 0 && count1[i] == 0) 
							break;
						else if (count1[i] == 1 && count2[i] == 1)
							continue;
						else if (count1[i] != 0) {
							System.out.println("win: "+a);
							vinnteller++;
							break;
						}
					}
				}
				else if (verdi1 == 2) {
					for (int i = count2.length-1; i != -1; i--) {
						if (count2[i] == 2 && count1[i] != 2) 
							break;
						else if (count1[i] == 2 && count2[i] == 2) {
							for (int j = count2.length-1; j != -1; j--) {
								if (count2[j] == 1 && count1[j] == 0) 
									break;
								else if (count1[i] == 1 && count2[i] == 1)
									continue;
								else if (count1[j] == 1) {
									System.out.println("win: "+a);
									vinnteller++;
									break;
								}
							}
						}
						else if (count1[i] == 2) {
							System.out.println("win: "+a);
							vinnteller++;
							break;
						}
					}
				}
				else if (verdi1 == 4) {
					for (int i = count2.length-1; i != -1; i--) {
						if (count2[i] == 3 && count1[i] != 3) 
							break;
						else if (count1[i] == 3 && count2[i] == 3)
							teller++;
						else if (count1[i] == 3) {
							System.out.println("win: "+a);
							vinnteller++;
							break;
						}
					}
				}
				else if (verdi1 == 8) {
					for (int i = count2.length-1; i != -1; i--) {
						if (count2[i] == 4 && count1[i] != 4) 
							break;
						else if (count1[i] == 4 && count2[i] == 4)
							teller++;
						else if (count1[i] == 4) {
							System.out.println("win: "+a);
							vinnteller++;
							break;
						}
					}
				}
				else {
					teller++;
					System.out.println("draw: "+a);
				}
			}
			string = in.readLine();
			a++;
		}
		System.out.println(vinnteller + "wins / " +teller + "draw");
	}
}
