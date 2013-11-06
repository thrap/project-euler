package problems;

import java.util.HashMap;
import java.util.Map;

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
		
		Map<Tree,Long> trees1 = new HashMap<Tree, Long>();
		for (int root = 0; root < 3; root++) {
			trees1.put(new Tree(root), 1L);
		}
		
		
		Map<Tree,Long> trees2 = new HashMap<Tree, Long>();
		for (Tree t : trees1.keySet()) {
			DownTree middle = new DownTree(t);
			for (Tree over : trees1.keySet()) {
				if (!middle.fitsUnder(over))
					continue;
				for (Tree left : trees1.keySet()) {
					if (!middle.fitsRightOf(left))
						continue;
					for (Tree right : trees1.keySet()) {
						if (!middle.fitsLeftOf(right))
							continue;
						Tree tree = new Tree(over, middle, left, right);
						trees2.put(tree, (trees2.containsKey(tree) ? trees2.get(tree) : 0) + trees1.get(t)*trees1.get(over)*trees1.get(left)*trees1.get(right));
					}
				}
			}
		}
		
		Map<Tree,Long> trees4 = new HashMap<Tree, Long>();
		for (Tree t : trees2.keySet()) {
			DownTree middle = new DownTree(t);
			for (Tree over : trees2.keySet()) {
				if (!middle.fitsUnder(over))
					continue;
				for (Tree left : trees2.keySet()) {
					if (!middle.fitsRightOf(left))
						continue;
					for (Tree right : trees2.keySet()) {
						if (!middle.fitsLeftOf(right))
							continue;
						Tree tree = new Tree(over, middle, left, right);
						trees4.put(tree, (trees4.containsKey(tree) ? trees4.get(tree) : 0) + trees2.get(t)*trees2.get(over)*trees2.get(left)*trees2.get(right));
					}
				}
			}
		}
		
		long sum = 0;
		int i = 0;
		for (Tree t : trees4.keySet()) {
			if (++i % 100 == 0)
				System.out.println(i + " / "+trees4.size() + " " + sum);
			DownTree middle = new DownTree(t);
			
			long overFits = 0;
			long leftFits = 0;
			long rightFits = 0;
			for (Tree tree : trees4.keySet()) {
				Long fits = trees4.get(tree);
				if (middle.fitsUnder(tree))
					overFits += fits;
				if (middle.fitsRightOf(tree))
					leftFits += fits;
				if (middle.fitsLeftOf(tree))
					rightFits += fits;
			}
			
			sum += trees4.get(t)*overFits*leftFits*rightFits;
		}
		System.out.println(sum);
		System.out.println(trees4.size());
	}
}
