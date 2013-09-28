package problems;

import java.util.ArrayList;

public class Problem61 {
	
//	Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
//	Square	 		P4,n=n2	 			1, 4, 9, 16, 25, ...
//	Pentagonal	 	P5,n=n(3n1)/2	 	1, 5, 12, 22, 35, ...
//	Hexagonal	 	P6,n=n(2n1)	 		1, 6, 15, 28, 45, ...
//	Heptagonal	 	P7,n=n(5n3)/2	 	1, 7, 18, 34, 55, ...
//	Octagonal	 	P8,n=n(3n2)	 		1, 8, 21, 40, 65, ...
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
//		int triangle = i*(i+1)/2;
//		int square = i*i;
//		int penta = i*(3*i-1)/2;
//		int hexa = i*(2*i-1);
//		int hepta = i*(5*i-3)/2;
//		int octa = i*(3*i-2);
		
		ArrayList<Integer> triangleList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int triangle = i*(i+1)/2;
			if (triangle >= 10000)
				break;
			if (triangle < 1000) 
				continue;
			triangleList.add(triangle);
		}
		
		ArrayList<Integer> squareList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int square = i*i;
			if (square >= 10000)
				break;
			if (square < 1000) 
				continue;
			squareList.add(square);
		}
//		System.out.println(squareList.size());
		
		ArrayList<Integer> pentaList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int penta = i*(3*i-1)/2;
			if (penta >= 10000)
				break;
			if (penta < 1000) 
				continue;
			pentaList.add(penta);
		}
//		System.out.println(pentaList.size());
		
		ArrayList<Integer> hexaList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int hexa = i*(2*i-1);
			if (hexa >= 10000)
				break;
			if (hexa < 1000) 
				continue;
			hexaList.add(hexa);
		}
//		System.out.println(pentaList.size());
		
		ArrayList<Integer> heptaList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int hepta = i*(5*i-3)/2;
			if (hepta >= 10000)
				break;
			if (hepta < 1000) 
				continue;
			heptaList.add(hepta);
		}
//		System.out.println(heptaList.size());
		
		ArrayList<Integer> octaList = new ArrayList<Integer>();
		for (int i = 1; true; i++) {
			int octa = i*(3*i-2);
			if (octa >= 10000)
				break;
			if (octa < 1000) 
				continue;
			octaList.add(octa);
		}
//		System.out.println(octaList.size());
		
		ArrayList<ArrayList<Integer>> par = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < triangleList.size(); i++) {
			for (int j = 0; j < squareList.size(); j++) {
				int tF = triangleList.get(i)/100;
				int tB = triangleList.get(i)%100;
				
				int sF = squareList.get(j)/100;
				int sB = squareList.get(j)%100;
				
				if (sB == tF) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(squareList.get(j));
					temp.add(triangleList.get(i));
					par.add(temp);
				}
				else if (tB == sF) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(triangleList.get(i));
					temp.add(squareList.get(j));
					par.add(temp);
				}
			}
		}
//		System.out.println(par);
		
		ArrayList<ArrayList<Integer>> trio = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<ArrayList<Integer>> tabell;
		ArrayList<ArrayList<Integer>> tabell2;
		//endre denne
		tabell = par;
		tabell2 = trio;
		
		for (int i = 0; i < par.size(); i++) {
			ArrayList<Integer> tallListe = pentaList;
			for (int j = 0; j < tallListe.size(); j++) {
				
				int start = tabell.get(i).get(0)/100;
				int slutt = tabell.get(i).get(tabell.get(i).size()-1)%100;
				
				int nyFront = tallListe.get(j)/100;
				int nyBak = tallListe.get(j)%100;
				
				if (nyBak == start) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(tallListe.get(j));
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					tabell2.add(temp);
				}
				else if (slutt == nyFront) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					temp.add(tallListe.get(j));
					tabell2.add(temp);
				}
			}
		}
//		System.out.println(tabell2);
		
		ArrayList<Integer> tallListe;
		//endre denne
		ArrayList<ArrayList<Integer>> quadro = new ArrayList<ArrayList<Integer>>();
		tabell = trio;
		tabell2 = quadro;
		tallListe = hexaList;
		for (int i = 0; i < tabell.size(); i++) {
			//endre denne
			for (int j = 0; j < tallListe.size(); j++) {
				int start = tabell.get(i).get(0)/100;
				int slutt = tabell.get(i).get(tabell.get(i).size()-1)%100;
				
				int nyFront = tallListe.get(j)/100;
				int nyBak = tallListe.get(j)%100;
				
				if (nyBak == start) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(tallListe.get(j));
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					tabell2.add(temp);
				}
				else if (slutt == nyFront) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					temp.add(tallListe.get(j));
					tabell2.add(temp);
				}
			}
		}
//		System.out.println(tabell2);
		
		//endre denne
		ArrayList<ArrayList<Integer>> penta = new ArrayList<ArrayList<Integer>>();
		tabell = quadro;
		tabell2 = penta;
		tallListe = heptaList;
		for (int i = 0; i < tabell.size(); i++) {
			//endre denne
			for (int j = 0; j < tallListe.size(); j++) {
				int start = tabell.get(i).get(0)/100;
				int slutt = tabell.get(i).get(tabell.get(i).size()-1)%100;
				
				int nyFront = tallListe.get(j)/100;
				int nyBak = tallListe.get(j)%100;
				
				if (nyBak == start) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(tallListe.get(j));
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					tabell2.add(temp);
				}
				else if (slutt == nyFront) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					temp.add(tallListe.get(j));
					tabell2.add(temp);
				}
			}
		}
		
		//endre denne
		ArrayList<ArrayList<Integer>> octa = new ArrayList<ArrayList<Integer>>();
		tabell = penta;
		tabell2 = octa;
		tallListe = octaList;
		for (int i = 0; i < tabell.size(); i++) {
			//endre denne
			for (int j = 0; j < tallListe.size(); j++) {
				int start = tabell.get(i).get(0)/100;
				int slutt = tabell.get(i).get(tabell.get(i).size()-1)%100;
				
				int nyFront = tallListe.get(j)/100;
				int nyBak = tallListe.get(j)%100;
				
				if (nyBak == start) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(tallListe.get(j));
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					tabell2.add(temp);
				}
				else if (slutt == nyFront) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int k = 0; k < tabell.get(i).size(); k++) {
						temp.add(tabell.get(i).get(k));
					}
					temp.add(tallListe.get(j));
					tabell2.add(temp);
				}
			}
		}
		
//		System.out.println(octa);
		for (int i = 0; i < octa.size(); i++) {
			int start = octa.get(i).get(0)/100;
			int slutt = octa.get(i).get(octa.get(i).size()-1)%100;
			
			if (start == slutt) {
//				System.out.println(octa.get(i));
				int sum = 0;
				for (int j = 0; j < octa.get(i).size(); j++) {
					sum+=octa.get(i).get(j);
				}
				return sum;
			}
			
		}
		return 0;
	}

}
