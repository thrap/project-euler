package problems;

import java.util.ArrayList;

public class Problem60 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		boolean[] primtable = Test.primtallUnder(100000000);
		ArrayList<Integer> primlist = new ArrayList<Integer>();
		for (int i = 2; i < primtable.length; i++) {
			if (i > 9000)
				break;
			if (primtable[i])
				primlist.add(i);
		}
//		System.out.println(primlist);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < primlist.size(); i++) {
			for (int j = i+1; j < primlist.size(); j++) {
				if (primtable[Integer.parseInt(""+primlist.get(i)+""+primlist.get(j))]) {
					if (primtable[Integer.parseInt(""+primlist.get(j)+""+primlist.get(i))]) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(primlist.get(i));
						temp.add(primlist.get(j));
						list.add(temp);
					}
				}
			}
		}
		
		
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < primlist.size(); j++) {
				for (int j2 = 0; j2 < list.get(i).size(); j2++) {
					if (primtable[Integer.parseInt(""+list.get(i).get(j2)+""+primlist.get(j))] && primtable[Integer.parseInt(""+primlist.get(j)+""+list.get(i).get(j2))]) {
						if (j2 == list.get(i).size()-1) {
							ArrayList<Integer> temp = (ArrayList<Integer>) list.get(i).clone();
							temp.add(primlist.get(j));
							list2.add(temp);
						}
					} else {
						break;
					}
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> list3 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < list2.size(); i++) {
			for (int j = i+1; j < primlist.size(); j++) {
				for (int j2 = 0; j2 < list2.get(i).size(); j2++) {
					if (primtable[Integer.parseInt(""+list2.get(i).get(j2)+""+primlist.get(j))] && primtable[Integer.parseInt(""+primlist.get(j)+""+list2.get(i).get(j2))]) {
						if (j2 == list2.get(i).size()-1) {
							ArrayList<Integer> temp = (ArrayList<Integer>) list2.get(i).clone();
							temp.add(primlist.get(j));
							list3.add(temp);
						}
					} else {
						break;
					}
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> list4 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < list3.size(); i++) {
			for (int j = i+1; j < primlist.size(); j++) {
				for (int j2 = 0; j2 < list3.get(i).size(); j2++) {
					if (primtable[Integer.parseInt(""+list3.get(i).get(j2)+""+primlist.get(j))] && primtable[Integer.parseInt(""+primlist.get(j)+""+list3.get(i).get(j2))]) {
						if (j2 == list3.get(i).size()-1) {
							ArrayList<Integer> temp = (ArrayList<Integer>) list3.get(i).clone();
							temp.add(primlist.get(j));
							list4.add(temp);
						}
					} else {
						break;
					}
				}
			}
		}
//		System.out.println(list4);
		for (int j = 0; j < list4.size(); j++) {
			int sum = 0;
			for (int i = 0; i < list4.get(j).size(); i++) {
				sum += list4.get(j).get(i);
			}
			return sum;
		}
		return 0;
	}
}
