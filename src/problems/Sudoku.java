package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Sudoku {
	
	public static byte[][] brett = {
			{0,0,8,  0,0,0,  0,1,5},
			{4,0,6,  5,0,0,  0,0,0},
			{0,0,0,  9,0,0,  0,6,0},
			
			{0,0,0,  0,0,5,  4,8,0},
			{6,0,0,  0,0,0,  0,0,3},
			{0,8,2,  6,0,0,  0,0,0},
			
			{0,9,0,  0,0,1,  0,0,0},
			{0,0,0,  0,0,4,  8,0,9},
			{5,2,0,  0,0,0,  7,0,0}};
	
	public static int teller;
	public static int superteller=0;
	public static int ferdigteller=0;
	public static HashMap<Byte,Boolean>[][] tall = new HashMap[9][9];
	public static int eulerTall = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		int q;
		for (q = 0; q < 1; q++) {
//			String linje = in.readLine();
//			System.out.println(linje);
//			for (int j = 0; j < 9; j++) {
//				linje = in.readLine();
//				for (int i = 0; i < linje.length(); i++) {
//					brett[j][i] = (byte)(linje.charAt(i)-'0');
//				}
//			}
//			if (q == 5)
//				brett[0][2] = 6;
//			if (q == 6)
//				brett[0][0] = 1;
////			if (q == 42)
////				brett[0][2] = 9;
//			if (q == 45)
//				brett[0][1] = 5;
//			if (q == 47)
//				brett[0][1] = 6;
//			if (q == 48)
//				brett[0][0] = 2;
			solve();
//			System.out.println(tall[0][2].size());
//			System.out.println(q + ": "+ tall[0][2].keySet());
//			System.out.println(100*brett[0][0]+10*brett[0][1]+brett[0][2]);
		}
		System.out.println(superteller + " / " + 81*q);
		System.out.println(ferdigteller + " / " + q);
	}
	
	public static void solve() {
		init();
		for (int i = 0; i <20; i++) {
			sjekkRad();
			sjekkBokser();
			sjekkTvillinger();
			sjekkSingle();
			
			if (teller == 81) {
//				System.out.println(i);
				ferdigteller++;
				break;
			}
		}
		for (int j = 0; j < tall.length; j++) {
			for (int j2 = 0; j2 < tall.length; j2++) {
				if (brett[j][j2] == 0 && tall[j][j2].size() == 0) {
					System.out.println("fy faen så fuckings feil");
					System.exit(0);
				}
			}
		}
		printBrett();
	}
	
	public static void sjekkSingle() {
		for (int j = 0; j < tall.length; j++) {
			for (int j2 = 0; j2 < tall.length; j2++) {
				if (tall[j][j2].size() == 1) {
					for (byte r = 1; r <=9; r++) {
						if (tall[j][j2].containsKey(r)) {
							if(brett[j][j2] == 0) {
								settTall(j,j2,r);
							}
						}
					}
				}
			}
		}
	}
	
	public static void sjekkTvillinger() {
		for (int i2 = 0; i2 < tall.length; i2++) {
			
			ArrayList<HashMap<Byte,Boolean>> liste = new ArrayList<HashMap<Byte,Boolean>>();
			int[] forekomster = new int[10];
			
			for (int i = 0; i < tall.length; i++) {
				for (byte r = 1; r <=9; r++) {
					if (tall[i2][i].containsKey(r))
						forekomster[r]++;
				}
				if (tall[i2][i].size() == 2)
					liste.add(tall[i2][i]);
			}
			for (int i = 0; i < liste.size()-1; i++) {
				for (int j = i+1; j < liste.size(); j++) {
					if (liste.get(i).equals(liste.get(j)) && liste.get(i) != liste.get(j)) {
						ArrayList<Byte> list = new ArrayList<Byte>();
						for (Byte e: liste.get(i).keySet()) {
							list.add(e);
						}
						for (int r = 0; r < tall.length; r++) {
							if (!tall[i2][r].equals(liste.get(i))) {
								for (int k = 0; k < list.size(); k++) {
									tall[i2][r].remove(list.get(k));
								}
							}
						}
//						System.out.println(liste.get(i));
					}
				}
			}
			ArrayList<Byte> list = new ArrayList<Byte>();
			for (byte i = 0; i < forekomster.length; i++) {
				if (forekomster[i] == 2)
					list.add(i);
			}
//			System.out.println(list);
			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					HashMap temp = null;
					for (int k2 = 0; k2 < 9; k2++) {
						if (tall[i2][k2].containsKey(list.get(i)) && tall[i2][k2].containsKey(list.get(j))) {
							if (temp == null)
								temp = tall[i2][k2];
							else {
								temp.clear();
								tall[i2][k2].clear();
								tall[i2][k2].put(list.get(i), true);
								tall[i2][k2].put(list.get(j), true);
								temp.put(list.get(i), true);
								temp.put(list.get(j), true);
							}
						}
					}
				}
			}
		}
		for (int i2 = 0; i2 < tall.length; i2++) {
			
			ArrayList<HashMap<Byte,Boolean>> liste = new ArrayList<HashMap<Byte,Boolean>>();
			int[] forekomster = new int[10];
			
			for (int i = 0; i < tall.length; i++) {
				for (byte r = 1; r <=9; r++) {
					if (tall[i][i2].containsKey(r))
						forekomster[r]++;
				}
				if (tall[i][i2].size() == 2)
					liste.add(tall[i][i2]);
			}
			for (int i = 0; i < liste.size()-1; i++) {
				for (int j = i+1; j < liste.size(); j++) {
					if (liste.get(i).equals(liste.get(j)) && liste.get(i) != liste.get(j)) {
						ArrayList<Byte> list = new ArrayList<Byte>();
						for (Byte e: liste.get(i).keySet()) {
							list.add(e);
						}
						for (int r = 0; r < tall.length; r++) {
							if (!tall[r][i2].equals(liste.get(i))) {
								for (int k = 0; k < list.size(); k++) {
									tall[r][i2].remove(list.get(k));
								}
							}
						}
						
						
//						System.out.println(liste.get(i));
					}
				}
			}
			ArrayList<Byte> list = new ArrayList<Byte>();
			for (byte i = 0; i < forekomster.length; i++) {
				if (forekomster[i] == 2)
					list.add(i);
			}
//			System.out.println(list);
			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					HashMap temp = null;
					for (int k2 = 0; k2 < 9; k2++) {
						if (tall[k2][i2].containsKey(list.get(i)) && tall[k2][i2].containsKey(list.get(j))) {
							if (temp == null)
								temp = tall[k2][i2];
							else {
								temp.clear();
								tall[k2][i2].clear();
								tall[k2][i2].put(list.get(i), true);
								tall[k2][i2].put(list.get(j), true);
								temp.put(list.get(i), true);
								temp.put(list.get(j), true);
							}
						}
					}
				}
			}
			
		}
		
		sjekkBoksTvillinger();
	}
	
	public static void sjekkBoksTvillinger() {
		for (int i2 = 0; i2 < 3; i2++) {
			for (int a = 0; a < 3; a++) {
				ArrayList<HashMap<Byte,Boolean>> liste = new ArrayList<HashMap<Byte,Boolean>>();
				
				int[] forekomster = new int[10];
				
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						for (byte r = 1; r <=9; r++) {
							if (tall[i2*3+i][a*3+j].containsKey(r))
								forekomster[r]++;
						}
						if (tall[i2*3+i][a*3+j].size() == 2) {
							liste.add(tall[i2*3+i][a*3+j]);
//							System.out.println((i2*3+i) + " " + (a*3+j));
//							System.out.println(liste);
						}
					}
				}
				for (int i = 0; i < liste.size()-1; i++) {
					for (int j = i+1; j < liste.size(); j++) {
						if (liste.get(i).equals(liste.get(j)) && liste.get(i) != liste.get(j)) {
							ArrayList<Byte> list = new ArrayList<Byte>();
							for (Byte e: liste.get(i).keySet()) {
								list.add(e);
							}
							for (int q = 0; q < 3; q++) {
								for (int jk = 0; jk < 3; jk++) {
									if (!tall[i2*3+q][a*3+jk].equals(liste.get(i))) {
										for (int k = 0; k < list.size(); k++) {
											tall[i2*3+q][a*3+jk].remove(list.get(k));
										}
									}
								}
							}
//							System.out.println(liste.get(i));
						}
					}
				}
				
				ArrayList<Byte> list = new ArrayList<Byte>();
				for (byte i = 0; i < forekomster.length; i++) {
					if (forekomster[i] == 2)
						list.add(i);
				}
//				System.out.println(list);
				for (int i = 0; i < list.size()-1; i++) {
					for (int j = i+1; j < list.size(); j++) {
						HashMap temp = null;
						for (int k2 = 0; k2 < 3; k2++) {
							for (int l = 0; l < 3; l++) {
								if (tall[i2*3+k2][a*3+l].containsKey(list.get(i)) && tall[i2*3+k2][a*3+l].containsKey(list.get(j))) {
									if (temp == null)
										temp = tall[i2*3+k2][a*3+l];
									else {
										temp.clear();
										tall[i2*3+k2][a*3+l].clear();
										tall[i2*3+k2][a*3+l].put(list.get(i), true);
										tall[i2*3+k2][a*3+l].put(list.get(j), true);
										temp.put(list.get(i), true);
										temp.put(list.get(j), true);
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < list.size(); i++) {
					int tempX = -1;
					int tempY = -1;
					for (int k2 = 0; k2 < 3; k2++) {
						for (int l = 0; l < 3; l++) {
							if (tall[i2*3+k2][a*3+l].containsKey(list.get(i))) {
								if (tempX == -1) {
									tempY = i2*3+k2;
									tempX = a*3+l;
								}
								else if (tempY == i2*3+k2) {
									for (int j = 0; j < tall.length; j++) {
										if (j == a*3 || j == a*3+1 || j== a*3+2)
											continue;
										tall[i2*3+k2][j].remove(list.get(i));
									}
								}
								else if (tempX == a*3+l) {
									for (int j = 0; j < tall.length; j++) {
										if (j == i2*3 || j == i2*3+1 || j== i2*3+2)
											continue;
										tall[j][a*3+l].remove(list.get(i));
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void sjekkBokser() {
		for (int i = 0; i < brett.length; i++) {
			for (int j = 0; j < brett.length; j++) {
				if (brett[i][j] != 0) {
					int[] forekomster = new int[10];
					for (int j2 = 0; j2 <3; j2++) {
						for (int k = 0; k <3; k++) {
							//sjekker forekomster
							for (byte r = 1; r <=9; r++) {
								if (tall[(i/3)*3+j2][(j/3)*3+k].containsKey(r))
									forekomster[r]++;
							}
							//sjekker tall 
							if (tall[(i/3)*3+j2][(j/3)*3+k].containsKey(brett[i][j])) {
								tall[(i/3)*3+j2][(j/3)*3+k].remove(brett[i][j]);
								
								
								if (tall[(i/3)*3+j2][(j/3)*3+k].size() == 1) {
									for (byte r = 1; r <=9; r++) {
										if (tall[(i/3)*3+j2][(j/3)*3+k].containsKey(r))
											if(brett[(i/3)*3+j2][(j/3)*3+k] == 0) {
												settTall((i/3)*3+j2,(j/3)*3+k,r);
											}
									}
								}
							}
						}
					}
					
					//sjekker forekomster
					for (byte k = 1; k < forekomster.length; k++) {
						if (forekomster[k] == 1) {
							for (int k2 = 0; k2 < 3; k2++) {
								for (int l = 0; l < 3; l++) {
									if (tall[(i/3)*3+k2][(j/3)*3+l].containsKey(k))
										if(brett[(i/3)*3+k2][(j/3)*3+l] == 0)
											settTall((i/3)*3+k2,(j/3)*3+l,k);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void settTall(int y, int x, byte t) {
		teller++;
		superteller++;
		brett[y][x] = t;
		tall[y][x].clear();
		for (int i = 0; i < brett.length; i++) {
			if(tall[i][x].containsKey(t))
				tall[i][x].remove(t);
			if(tall[y][i].containsKey(t))
				tall[y][i].remove(t);
		}
		
		for (int j2 = 0; j2 <3; j2++) {
			for (int k = 0; k <3; k++) {
				if (tall[(y/3)*3+j2][(x/3)*3+k].containsKey(t))
					tall[(y/3)*3+j2][(x/3)*3+k].remove(t);
			}
		}
	}
	
	public static void sjekkRad() {
		for (int i = 0; i < tall.length; i++) {
			for (int j = 0; j < tall.length; j++) {
				if (brett[i][j] != 0) {
					int[] forekomster1 = new int[10];
					int[] forekomster2 = new int[10];
					
					for (int j2 = 0; j2 < tall.length; j2++) {
						for (byte r = 1; r <=9; r++) {
							if (tall[i][j2].containsKey(r)) {
								forekomster2[r]++;
							}
						}
						for (byte r = 1; r <=9; r++) {
							if (tall[j2][j].containsKey(r)) {
								if (i==4 && j == 1 && r == 4)
//									System.out.println("("+i+","+j2+")");
								forekomster1[r]++;
							}
						}
						
						if (tall[i][j2].containsKey(brett[i][j])) {
							tall[i][j2].remove(brett[i][j]);
							if (tall[i][j2].size() == 1) {
								for (byte k = 1; k <=9; k++) {
									if (tall[i][j2].containsKey(k))
										if(brett[i][j2] == 0)
											settTall(i,j2,k);
								}
							}
						}
						if (tall[j2][j].containsKey(brett[i][j])) {
							tall[j2][j].remove(brett[i][j]);
							if (tall[j2][j].size() == 1) {
								for (byte k = 1; k <=9; k++) {
									if (tall[j2][j].containsKey(k))
										if (brett[j2][j] == 0)
											settTall(j2,j,k);
								}
							}
						}
					}
					for (byte k = 1; k < forekomster1.length; k++) {
						if (forekomster1[k] == 1) {
							for (int k3 = 0; k3 < tall.length; k3++) {
								if (tall[k3][j].containsKey(k))
									settTall(k3,j,k);
							}
						}
						if (forekomster2[k] == 1) {
							for (int k3 = 0; k3 < tall.length; k3++) {
								if (tall[i][k3].containsKey(k))
									settTall(i,k3,k);
							}
						}
					}
				}
			}
		}
	}
	
	public static void init() {
		teller=0;
		for (byte i = 0; i < tall.length; i++) {
			for (byte j = 0; j < tall.length; j++) {
				tall[i][j] = new HashMap<Byte,Boolean>();
				for (byte j2 = 1; j2 <= 9; j2++) {
					tall[i][j].put(j2, true);
				}
			}
		}
		for (int i = 0; i < tall.length; i++) {
			for (int j = 0; j < tall.length; j++) {
				if (brett[i][j] != 0)
					settTall(i,j,brett[i][j]);
			}
		}
	}
	
	public static void printBrett() {
		for (int i = 0; i < brett.length; i++) {
			if (i%3 == 0 && i!= 0)
//				System.out.println("---------------+----------------+---------------");
				System.out.println("------+-------+------");
			for (int j = 0; j < brett.length; j++) {
				if ((j)%3==0 && j != 0)
					System.out.print("| ");
				if (brett[i][j] == 0)
					System.out.print(".");
				else 
					System.out.print(brett[i][j]);
//				System.out.print("(" + tall[i][j].size()+") ");
				System.out.print(" ");
//				System.out.print(tall[i][j].keySet());
			}
			System.out.println();
		}
	}
}
