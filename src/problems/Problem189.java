package problems;

import java.util.HashMap;
import java.util.Map;

import utils.T;

public class Problem189 {
	
	private static class Tree {
		final int size;
		int[] left;
		int[] right;
		int[] under;
		
		private Tree(int size, boolean asd) {
			this.size = size;
			this.left = new int[size];
			this.right = new int[size];
			this.under = new int[size];
		}
		
		public Tree(int n) {
			this(1, true);
			this.left[0] = n;
			this.right[0] = n;
			this.under[0] = n;
		}
		
		public Tree(Tree over, DownTree middle, Tree left, Tree right) {
			this(over.size*2, true);
			if (over.size != left.size || over.size != right.size || left.size != right.size)
				throw new RuntimeException("Sizes må være like");
			if (!middle.fitsUnder(over) || !middle.fitsLeftOf(right) || !middle.fitsRightOf(left))
				throw new RuntimeException("Nå har du vært dum her kompis");
			
			for (int i = 0; i < over.size; i++) {
				this.under[i] = left.under[i];
				this.under[over.size + i] = right.under[i];
				
				this.left[i] = over.left[i];
				this.left[over.size + i] = left.left[i];
				
				this.right[i] = over.right[i];
				this.right[over.size + i] = right.right[i];
			}
		}
		
		public int hashCode() {
			return toString().hashCode();
		}
		
		public boolean equals(Object o) {
			return toString().equals(o.toString());
		}
		
		// det er ikke denne som er piss a?
		public String toString() {
			if (size == 1)
				return ""+right[0];
			else if (size == 2) 
				return " " + right[0] + "\n"+under[0]+" "+under[1];
			else if (size == 4)
				return  "   "+this.left[0] + "\n" +
						"  "+this.left[1] + " " + this.right[1] + "\n" +
						" "+this.left[2] + "   " + this.right[2] + "\n" + 
						this.under[0] + " " + this.under[1] + " " + this.under[2] + " " +this.under[3] + " ";
			throw new RuntimeException("De skal enten være 2 eller 4 din dass");
		}
	}
	
	private static class DownTree {
		int size;
		int[] over;
		int[] right;
		int[] left;
		public DownTree(Tree tree) {
			this.size = tree.size;
			this.over = tree.under.clone();
			this.right = tree.right.clone();
			reverse(this.right);
			this.left = tree.left.clone();
			reverse(this.left);
		}
		
		public boolean fitsLeftOf(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (this.right[i] == tree.left[i])
					return false;
			}
			return true;
		}
		public boolean fitsRightOf(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (this.left[i] == tree.right[i])
					return false;
			}
			return true;
		}
		public boolean fitsUnder(Tree tree) {
			for (int i = 0; i < size; i++) {
				if (this.over[i] == tree.under[i])
					return false;
			}
			return true;
		}
	}
	
	private static void reverse(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		Map<Tree, Long> trees = getFourRowTrees();
		long sum = 0;
		int i = 0;
		for (Tree mid : trees.keySet()) {
			if (++i % 100 == 0)
				System.out.println(i + " / "+trees.size() + " " + sum);
			DownTree middle = new DownTree(mid);
			
			long overFits = 0;
			long leftFits = 0;
			long rightFits = 0;
			for (Tree tree : trees.keySet()) {
				Long fits = trees.get(tree);
				if (middle.fitsUnder(tree))
					overFits += fits;
				if (middle.fitsRightOf(tree))
					leftFits += fits;
				if (middle.fitsLeftOf(tree))
					rightFits += fits;
			}
			
			sum += trees.get(mid)*overFits*leftFits*rightFits;
		}
		System.out.println(sum + " " + t);
	}

	private static Map<Tree, Long> getFourRowTrees() {
		Map<Tree,Long> lastMap = new HashMap<Tree, Long>();
		for (int root = 0; root < 3; root++) {
			lastMap.put(new Tree(root), 1L);
		}
		
		for (int i = 0; i < 2; i++) {
			Map<Tree,Long> map = new HashMap<Tree, Long>();
			for (Tree t : lastMap.keySet()) {
				DownTree middle = new DownTree(t);
				for (Tree over : lastMap.keySet()) {
					if (!middle.fitsUnder(over))
						continue;
					for (Tree left : lastMap.keySet()) {
						if (!middle.fitsRightOf(left))
							continue;
						for (Tree right : lastMap.keySet()) {
							if (!middle.fitsLeftOf(right))
								continue;
							Tree tree = new Tree(over, middle, left, right);
							map.put(tree, (map.containsKey(tree) ? map.get(tree) : 0) + lastMap.get(t)*lastMap.get(over)*lastMap.get(left)*lastMap.get(right));
						}
					}
				}
			}
			lastMap = map;
		}
		
		return lastMap;
	}
}
